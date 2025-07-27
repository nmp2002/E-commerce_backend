package com.ttisv.springbootwildfly.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.icu.text.SimpleDateFormat;
import com.ttisv.bean.system.TblOrder;
import com.ttisv.bean.system.TblNotification;
import com.ttisv.dao.system.TblNotificationDao;
import com.ttisv.service.system.TblOrderService;
import com.ttisv.service.system.TblNotificationService;
import com.ttisv.service.system.VnPayService;
import com.ttisv.service.system.TblProductService;
import com.ttisv.bean.system.TblProduct;
import com.ttisv.service.system.TblOrderItemService;
import com.ttisv.bean.system.TblOrderItem;

@RestController
@RequestMapping("/api/payment")
public class VnPayController extends BaseController  {

    @Autowired
    private VnPayService vnpayService; 
    @Autowired
    private TblOrderService orderService;
    @Autowired
    private NotificationController notificationController;
    @Autowired
    private TblNotificationDao tblNotificationDao;
    @Autowired
    private TblNotificationService tblNotificationService;
    @Autowired
    private TblProductService productService;
    @Autowired
    private TblOrderItemService orderItemService;

    @GetMapping("/createPayment")
    public ResponseEntity<?> createPayment(@RequestParam(required = false) Long orderId, 
                                         @RequestParam(required = false) Long bookingId,
                                         @RequestParam(required = false) Double amount) {
        try {
            // Hỗ trợ cả orderId và bookingId (tương thích ngược)
            Long finalOrderId = orderId;
            if (finalOrderId == null && bookingId != null) {
                finalOrderId = bookingId;
            }
            
            if (finalOrderId == null) {
                return ResponseEntity.badRequest().body("Lỗi: orderId hoặc bookingId không được để trống!");
            }
            if (amount == null) {
                return ResponseEntity.badRequest().body("Lỗi: amount không được để trống!");
            }
            
            String paymentUrl = vnpayService.createPaymentUrl(finalOrderId, amount);
            if (paymentUrl == null) {
                throw new RuntimeException("Failed to generate payment URL");
            }
            return ResponseEntity.ok(paymentUrl);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating payment URL");
        }
    }

    
    @PostMapping("/vnpay-return")
    public ResponseEntity<String> vnpayReturn(@RequestBody Map<String, String> vnpParams) {
        vnpParams.forEach((key, value) -> System.out.println("Parameter Name - " + key + ", Value - " + value));
        
        // Lấy mã phản hồi và transaction reference từ VNPay
        String vnpResponseCode = vnpParams.get("vnp_ResponseCode");
        String txnRef = vnpParams.get("vnp_TxnRef");

        if (txnRef == null || txnRef.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid transaction reference (vnp_TxnRef)");
        }

        Long orderId;
        try {
            orderId = Long.parseLong(txnRef);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid order ID format");
        }

        if ("00".equals(vnpResponseCode)) {
            try {
                // Cập nhật trạng thái đơn hàng thành "Đã xác nhận" (status = 1)
                orderService.updateOrderStatus(orderId, 1L);
                
                // Trừ tồn kho sản phẩm
                List<TblOrderItem> orderItems = orderItemService.findByOrderId(orderId);
                for (TblOrderItem item : orderItems) {
                    TblProduct product = productService.findProductById(item.getProductId());
                    if (product != null && product.getStockQuantity() != null) {
                        int newStock = product.getStockQuantity() - item.getQuantity();
                        if (newStock < 0) newStock = 0; // Không cho tồn kho âm
                        product.setStockQuantity(newStock);
                        productService.updateProduct(product);
                    }
                }
                
                // Gửi thông báo
                TblOrder order = orderService.get(orderId);
                if (order == null) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
                }
                
                String vnpAmount = vnpParams.get("vnp_Amount");
                long amount = 0;
                try {
                    amount = Long.parseLong(vnpAmount) / 100;
                } catch (Exception ex) {
                    amount = 0;
                }
                Date paymentTime = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String formattedPaymentTime = dateFormat.format(paymentTime);
                
                // Tạo thông báo
                String notificationMessage = String.format(
                    "Đơn hàng #%d đã được thanh toán thành công!\nSố tiền: %d VNĐ\nThời gian: %s",
                    orderId,
                    amount,
                    formattedPaymentTime
                );
                
                notificationController.sendNotification(notificationMessage);
                
                // Lưu thông báo vào cơ sở dữ liệu
                TblNotification notification = new TblNotification();
                notification.setMessage(notificationMessage);
                notification.setFieldId(1L); // Có thể điều chỉnh theo logic nghiệp vụ
                notification.setTime(formattedPaymentTime);
                notification.setStatus(1L); // Có thể điều chỉnh trạng thái phù hợp
                notification.setCreateby("VNPay"); // Có thể thay đổi tùy theo hệ thống
                notification.setCreatedDate(new Date());
                tblNotificationService.saveNotification(notification);
                
                return ResponseEntity.ok("Payment success and order status updated");
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Payment success but failed to update order");
            }
        } else {
            // Xử lý giao dịch thất bại: Hủy đơn hàng
            try {
                orderService.cancelOrder(orderId);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Payment failed, order cancelled");
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Payment failed and failed to cancel order");
            }
        }
    }

    /**
     * Xử lý redirect từ VNPay về frontend
     * Endpoint này sẽ được gọi khi VNPay redirect về frontend
     */
    @GetMapping("/vnpay-redirect")
    public ResponseEntity<String> vnpayRedirect(@RequestParam Map<String, String> vnpParams) {
        vnpParams.forEach((key, value) -> System.out.println("Redirect Parameter Name - " + key + ", Value - " + value));
        
        // Lấy mã phản hồi và transaction reference từ VNPay
        String vnpResponseCode = vnpParams.get("vnp_ResponseCode");
        String txnRef = vnpParams.get("vnp_TxnRef");

        if (txnRef == null || txnRef.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid transaction reference (vnp_TxnRef)");
        }

        Long orderId;
        try {
            orderId = Long.parseLong(txnRef);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid order ID format");
        }

        if ("00".equals(vnpResponseCode)) {
            try {
                // Cập nhật trạng thái đơn hàng thành "Đã xác nhận" (status = 1)
                orderService.updateOrderStatus(orderId, 1L);
                
                // Trừ tồn kho sản phẩm
                List<TblOrderItem> orderItems = orderItemService.findByOrderId(orderId);
                for (TblOrderItem item : orderItems) {
                    TblProduct product = productService.findProductById(item.getProductId());
                    if (product != null && product.getStockQuantity() != null) {
                        int newStock = product.getStockQuantity() - item.getQuantity();
                        if (newStock < 0) newStock = 0; // Không cho tồn kho âm
                        product.setStockQuantity(newStock);
                        productService.updateProduct(product);
                    }
                }
                
                // Gửi thông báo
                TblOrder order = orderService.get(orderId);
                if (order == null) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
                }
                
                String vnpAmount = vnpParams.get("vnp_Amount");
                long amount = 0;
                try {
                    amount = Long.parseLong(vnpAmount) / 100;
                } catch (Exception ex) {
                    amount = 0;
                }
                Date paymentTime = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String formattedPaymentTime = dateFormat.format(paymentTime);
                
                // Tạo thông báo
                String notificationMessage = String.format(
                    "Đơn hàng #%d đã được thanh toán thành công!\nSố tiền: %d VNĐ\nThời gian: %s",
                    orderId,
                    amount,
                    formattedPaymentTime
                );
                
                notificationController.sendNotification(notificationMessage);
                
                // Lưu thông báo vào cơ sở dữ liệu
                TblNotification notification = new TblNotification();
                notification.setMessage(notificationMessage);
                notification.setFieldId(1L);
                notification.setTime(formattedPaymentTime);
                notification.setStatus(1L);
                notification.setCreateby("VNPay");
                notification.setCreatedDate(new Date());
                tblNotificationService.saveNotification(notification);
                
                // Redirect về frontend với thông tin thành công
                String frontendUrl = "http://localhost:4200/order/payment-result?status=success&orderId=" + orderId + "&amount=" + amount;
                return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", frontendUrl)
                    .body("Payment success! Redirecting to frontend...");
                
            } catch (Exception e) {
                e.printStackTrace();
                String frontendUrl = "http://localhost:4200/order/payment-result?status=error&message=Payment+success+but+failed+to+update+order";
                return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", frontendUrl)
                    .body("Payment success but failed to update order. Redirecting to frontend...");
            }
        } else {
            // Xử lý giao dịch thất bại: Hủy đơn hàng
            try {
                orderService.cancelOrder(orderId);
                String frontendUrl = "http://localhost:4200/order/payment-result?status=failed&orderId=" + orderId + "&message=Payment+failed";
                return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", frontendUrl)
                    .body("Payment failed, order cancelled. Redirecting to frontend...");
            } catch (Exception e) {
                e.printStackTrace();
                String frontendUrl = "http://localhost:4200/order/payment-result?status=error&message=Payment+failed+and+failed+to+cancel+order";
                return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", frontendUrl)
                    .body("Payment failed and failed to cancel order. Redirecting to frontend...");
            }
        }
    }

    @GetMapping("/notification")
    public ResponseEntity<List<TblNotification>> getNotification(@Valid @RequestParam Long fieldId) {
        try {
            List<TblNotification> notifications = tblNotificationService.getNotification(fieldId);
            if (notifications != null && !notifications.isEmpty()) {
                return ResponseEntity.ok(notifications);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

}
