package com.ttisv.springbootwildfly.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttisv.bean.system.TblOrder;
import com.ttisv.bean.system.TblOrderItem;
import com.ttisv.service.system.TblOrderItemService;
import com.ttisv.service.system.TblOrderService;
import com.ttisv.springbootwildfly.payload.request.OrderItemRequest;
import com.ttisv.springbootwildfly.payload.request.OrderRequest;
import com.ttisv.springbootwildfly.payload.response.MessageResponse;
import com.ttisv.springbootwildfly.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/orders")
public class OrderController extends BaseController {

    @Autowired
    private TblOrderService orderService;
    
    @Autowired
    private TblOrderItemService orderItemService;

    /**
     * Tìm đơn hàng theo ID
     */
    @GetMapping("/findById")
    public ResponseEntity<TblOrder> findById(@Valid @RequestParam Long id) {
        try {
            TblOrder order = orderService.get(id);
            if (order != null) {
                return new ResponseEntity<>(order, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Lấy tất cả đơn hàng
     */
    @GetMapping("/list")
    public ResponseEntity<List<TblOrder>> findAllOrders() {
        try {
            List<TblOrder> orders = orderService.find("from TblOrder order by orderDate desc");
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Tìm đơn hàng theo User ID
     */
    @GetMapping("/byUserId")
    public ResponseEntity<List<TblOrder>> findByUserId(@Valid @RequestParam Long userId) {
        try {
            List<TblOrder> orders = orderService.findByUserId(userId);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Tìm đơn hàng theo trạng thái
     */
    @GetMapping("/byStatus")
    public ResponseEntity<List<TblOrder>> findByStatus(@Valid @RequestParam Long status) {
        try {
            List<TblOrder> orders = orderService.findByStatus(status);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Tìm đơn hàng theo User ID và trạng thái
     */
    @GetMapping("/byUserIdAndStatus")
    public ResponseEntity<List<TblOrder>> findByUserIdAndStatus(@Valid @RequestParam Long userId, @Valid @RequestParam Long status) {
        try {
            List<TblOrder> orders = orderService.findByUserIdAndStatus(userId, status);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Tìm kiếm đơn hàng theo từ khóa
     */
    @GetMapping("/search")
    public ResponseEntity<List<TblOrder>> searchOrders(@RequestParam String keyword) {
        try {
            String hql = "from TblOrder where phone like :keyword or email like :keyword or shippingAddress like :keyword order by orderDate desc";
            Map<String, Object> params = new HashMap<>();
            params.put("keyword", "%" + keyword + "%");
            List<TblOrder> orders = orderService.find(hql, params);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Tìm đơn hàng theo khoảng thời gian
     */
    @GetMapping("/byDateRange")
    public ResponseEntity<List<TblOrder>> findByDateRange(@RequestParam String startDate, @RequestParam String endDate) {
        try {
            // Chuyển đổi string thành Date (cần implement logic chuyển đổi)
            Date start = new Date(); // TODO: Implement date conversion
            Date end = new Date();   // TODO: Implement date conversion
            
            List<TblOrder> orders = orderService.findOrdersByDateRange(start, end);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Tạo đơn hàng mới
     */
    @PutMapping("/createOrder")
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderRequest orderRequest) {
        try {
            String username = getCurrentUsername();
            
            TblOrder order = new TblOrder();
            order.setUserId(orderRequest.getUserId());
            order.setTotalAmount(orderRequest.getTotalAmount());
            order.setShippingAddress(orderRequest.getShippingAddress());
            order.setPhone(orderRequest.getPhone());
            order.setEmail(orderRequest.getEmail());
            order.setCreateby(username);
            
            TblOrder savedOrder = orderService.createOrder(order);
            
            // Save order items if provided
            if (orderRequest.getOrderItems() != null && !orderRequest.getOrderItems().isEmpty()) {
                for (OrderItemRequest itemRequest : orderRequest.getOrderItems()) {
                    TblOrderItem orderItem = new TblOrderItem();
                    orderItem.setOrderId(savedOrder.getId());
                    orderItem.setProductId(itemRequest.getProductId());
                    orderItem.setQuantity(itemRequest.getQuantity());
                    orderItem.setPrice(itemRequest.getPrice());
                    orderItem.setCreateby(username);
                    orderItemService.addOrderItem(orderItem);
                }
            }
            
            return ResponseEntity.ok(new MessageResponse(savedOrder.getId(), "Tạo đơn hàng thành công!"));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình tạo đơn hàng!"));
        }
    }

    /**
     * Cập nhật thông tin đơn hàng
     */
    @PutMapping("/updateOrder")
    public ResponseEntity<?> updateOrder(@Valid @RequestBody OrderRequest orderRequest) {
        try {
            String username = getCurrentUsername();
            
            TblOrder order = orderService.get(Long.parseLong(orderRequest.getId()));
            if (order == null) {
                return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Không tìm thấy đơn hàng!"));
            }
            
            // Cập nhật thông tin
            order.setTotalAmount(orderRequest.getTotalAmount());
            order.setShippingAddress(orderRequest.getShippingAddress());
            order.setPhone(orderRequest.getPhone());
            order.setEmail(orderRequest.getEmail());
            order.setModifiedby(username);
            order.setModifiedDate(new Date());
            
            orderService.update(order);
            
            return ResponseEntity.ok(new MessageResponse("Cập nhật đơn hàng thành công!"));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình cập nhật!"));
        }
    }

    /**
     * RESTful: Cập nhật trạng thái đơn hàng theo id
     */
    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateOrderStatusRestful(@PathVariable("id") Long orderId, @RequestParam("status") Long status) {
        try {
            if (orderId == null) {
                return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: orderId không được để trống!"));
            }
            if (status == null) {
                return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: status không được để trống!"));
            }
            String username = getCurrentUsername();
            TblOrder order = orderService.updateOrderStatus(orderId, status);
            if (order != null) {
                order.setModifiedby(username);
                orderService.update(order);
                return ResponseEntity.ok(new MessageResponse("Cập nhật trạng thái đơn hàng thành công!"));
            } else {
                return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Không tìm thấy đơn hàng!"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình cập nhật!"));
        }
    }

    /**
     * Hủy đơn hàng
     */
    @GetMapping("/cancelOrder")
    public ResponseEntity<?> cancelOrder(@RequestParam(required = false) Long orderId) {
        try {
            if (orderId == null) {
                return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: orderId không được để trống!"));
            }
            
            orderService.cancelOrder(orderId);
            return ResponseEntity.ok(new MessageResponse("Hủy đơn hàng thành công!"));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình hủy đơn hàng!"));
        }
    }

    /**
     * Xóa đơn hàng
     */
    @GetMapping("/delete")
    public ResponseEntity<?> deleteOrder(@Valid @RequestParam Long id) {
        try {
            // Delete order items first
            orderItemService.deleteByOrderId(id);
            // Then delete the order
            orderService.delete(id);
            return ResponseEntity.ok(new MessageResponse("Xóa đơn hàng thành công!"));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình xóa đơn hàng!"));
        }
    }

    /**
     * Lấy danh sách order items của đơn hàng
     */
    @GetMapping("/orderItems")
    public ResponseEntity<?> getOrderItems(@RequestParam(required = false) Long orderId) {
        try {
            if (orderId == null) {
                return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: orderId không được để trống!"));
            }
            
            List<TblOrderItem> orderItems = orderItemService.findByOrderId(orderId);
            return new ResponseEntity<>(orderItems, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Lấy tổng tiền đơn hàng
     */
    @GetMapping("/totalAmount")
    public ResponseEntity<?> getTotalAmount(@RequestParam(required = false) Long orderId) {
        try {
            if (orderId == null) {
                return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: orderId không được để trống!"));
            }
            
            Double totalAmount = orderItemService.getTotalAmountByOrderId(orderId);
            return new ResponseEntity<>(totalAmount, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Thống kê đơn hàng
     */
    @GetMapping("/statistics")
    public ResponseEntity<Map<String, Object>> getOrderStatistics() {
        try {
            Map<String, Object> statistics = new HashMap<>();
            
            // Tổng số đơn hàng
            Integer totalOrders = orderService.count("from TblOrder");
            statistics.put("totalOrders", totalOrders);
            
            // Đơn hàng theo trạng thái
            Integer pendingOrders = orderService.count("from TblOrder where status = 0");
            Integer confirmedOrders = orderService.count("from TblOrder where status = 1");
            Integer shippingOrders = orderService.count("from TblOrder where status = 2");
            Integer completedOrders = orderService.count("from TblOrder where status = 3");
            Integer cancelledOrders = orderService.count("from TblOrder where status = 4");
            
            statistics.put("pendingOrders", pendingOrders);
            statistics.put("confirmedOrders", confirmedOrders);
            statistics.put("shippingOrders", shippingOrders);
            statistics.put("completedOrders", completedOrders);
            statistics.put("cancelledOrders", cancelledOrders);
            
            // Tổng số lượng sản phẩm đã bán
            String hql = "select sum(quantity) from TblOrderItem";
            List<Object> result = orderItemService.findRaw(hql);
            Integer totalQuantity = result != null && !result.isEmpty() && result.get(0) != null ?
                ((Number) result.get(0)).intValue() : 0;
            statistics.put("totalQuantity", totalQuantity);

            // Tổng doanh thu
            String revenueHql = "select sum(price * quantity) from TblOrderItem";
            List<Object> revenueResult = orderItemService.findRaw(revenueHql);
            Double totalRevenue = revenueResult != null && !revenueResult.isEmpty() && revenueResult.get(0) != null ?
                ((Number) revenueResult.get(0)).doubleValue() : 0.0;
            statistics.put("totalRevenue", totalRevenue);
            
            return new ResponseEntity<>(statistics, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Phân trang đơn hàng
     */
    @SuppressWarnings("deprecation")
    @CrossOrigin
    @RequestMapping(value = "/paging", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<TblOrder>> findAllOrders(@RequestBody String req, HttpServletRequest request,
            HttpServletResponse resp) {
        try {
            OrderRequest orderReq = gson.fromJson(req, OrderRequest.class);
            int currentPage = orderReq.getPage();
            int pageSize = 10;
            
            String hql = "from TblOrder order by orderDate desc";
            List<TblOrder> orders = orderService.find(hql, currentPage, pageSize);
            
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
} 