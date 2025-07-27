package com.ttisv.springbootwildfly.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttisv.bean.system.TblOrderItem;
import com.ttisv.service.system.TblOrderItemService;
import com.ttisv.springbootwildfly.payload.request.OrderItemRequest;
import com.ttisv.springbootwildfly.payload.response.MessageResponse;
import com.ttisv.springbootwildfly.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/order-items")
public class OrderItemController extends BaseController {

    @Autowired
    private TblOrderItemService orderItemService;

    /**
     * Tìm order item theo ID
     */
    @GetMapping("/findById")
    public ResponseEntity<TblOrderItem> findById(@Valid @RequestParam Long id) {
        try {
            TblOrderItem orderItem = orderItemService.get(id);
            if (orderItem != null) {
                return new ResponseEntity<>(orderItem, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Lấy tất cả order items
     */
    @GetMapping("/list")
    public ResponseEntity<List<TblOrderItem>> findAllOrderItems() {
        try {
            List<TblOrderItem> orderItems = orderItemService.find("from TblOrderItem order by createdDate desc");
            return new ResponseEntity<>(orderItems, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Lấy order items theo Order ID
     */
    @GetMapping("/byOrderId")
    public ResponseEntity<?> findByOrderId(@RequestParam(required = false) Long orderId) {
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
     * Lấy order items theo Product ID
     */
    @GetMapping("/byProductId")
    public ResponseEntity<List<TblOrderItem>> findByProductId(@Valid @RequestParam Long productId) {
        try {
            List<TblOrderItem> orderItems = orderItemService.findByProductId(productId);
            return new ResponseEntity<>(orderItems, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Tạo order item mới
     */
    @PostMapping("/create")
    public ResponseEntity<?> createOrderItem(@Valid @RequestBody OrderItemRequest orderItemRequest) {
        try {
            String username = getCurrentUsername();
            
            TblOrderItem orderItem = new TblOrderItem();
            orderItem.setOrderId(orderItemRequest.getOrderId());
            orderItem.setProductId(orderItemRequest.getProductId());
            orderItem.setQuantity(orderItemRequest.getQuantity());
            orderItem.setPrice(orderItemRequest.getPrice());
            orderItem.setCreateby(username);
            orderItem.setCreatedDate(new Date());
            
            orderItemService.addOrderItem(orderItem);
            
            return ResponseEntity.ok(new MessageResponse("Tạo order item thành công!"));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình tạo order item!"));
        }
    }

    /**
     * Cập nhật order item
     */
    @PutMapping("/update")
    public ResponseEntity<?> updateOrderItem(@Valid @RequestBody OrderItemRequest orderItemRequest) {
        try {
            String username = getCurrentUsername();
            
            TblOrderItem orderItem = orderItemService.get(Long.parseLong(orderItemRequest.getId()));
            if (orderItem == null) {
                return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Không tìm thấy order item!"));
            }
            
            // Cập nhật thông tin
            orderItem.setQuantity(orderItemRequest.getQuantity());
            orderItem.setPrice(orderItemRequest.getPrice());
            orderItem.setModifiedby(username);
            orderItem.setModifiedDate(new Date());
            
            orderItemService.update(orderItem);
            
            return ResponseEntity.ok(new MessageResponse("Cập nhật order item thành công!"));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình cập nhật!"));
        }
    }

    /**
     * Cập nhật số lượng order item
     */
    @PutMapping("/updateQuantity")
    public ResponseEntity<?> updateOrderItemQuantity(@Valid @RequestParam Long orderItemId, @Valid @RequestParam Integer quantity) {
        try {
            orderItemService.updateOrderItemQuantity(orderItemId, quantity);
            return ResponseEntity.ok(new MessageResponse("Cập nhật số lượng thành công!"));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình cập nhật số lượng!"));
        }
    }

    /**
     * Xóa order item
     */
    @GetMapping("/delete")
    public ResponseEntity<?> deleteOrderItem(@Valid @RequestParam Long id) {
        try {
            orderItemService.delete(id);
            return ResponseEntity.ok(new MessageResponse("Xóa order item thành công!"));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình xóa order item!"));
        }
    }

    /**
     * Xóa tất cả order items của một đơn hàng
     */
    @GetMapping("/deleteByOrderId")
    public ResponseEntity<?> deleteByOrderId(@RequestParam(required = false) Long orderId) {
        try {
            if (orderId == null) {
                return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: orderId không được để trống!"));
            }
            
            orderItemService.deleteByOrderId(orderId);
            return ResponseEntity.ok(new MessageResponse("Xóa tất cả order items của đơn hàng thành công!"));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình xóa!"));
        }
    }

    /**
     * Lấy tổng tiền theo Order ID
     */
    @GetMapping("/totalAmountByOrderId")
    public ResponseEntity<?> getTotalAmountByOrderId(@RequestParam(required = false) Long orderId) {
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
     * Thống kê order items
     */
    @GetMapping("/statistics")
    public ResponseEntity<Map<String, Object>> getOrderItemStatistics() {
        try {
            Map<String, Object> statistics = new HashMap<>();
            
            // Tổng số order items
            Integer totalOrderItems = orderItemService.count("from TblOrderItem");
            statistics.put("totalOrderItems", totalOrderItems);
            
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
     * Tìm kiếm order items theo sản phẩm
     */
    @GetMapping("/searchByProduct")
    public ResponseEntity<List<TblOrderItem>> searchByProduct(@RequestParam String productName) {
        try {
            // Giả sử có join với bảng Product để tìm theo tên sản phẩm
            // Cần implement logic tìm kiếm phù hợp với cấu trúc database
            String hql = "from TblOrderItem oi where oi.productId in (select p.id from Product p where p.name like :productName)";
            Map<String, Object> params = new HashMap<>();
            params.put("productName", "%" + productName + "%");
            List<TblOrderItem> orderItems = orderItemService.find(hql, params);
            return new ResponseEntity<>(orderItems, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Lấy order items theo khoảng giá
     */
    @GetMapping("/byPriceRange")
    public ResponseEntity<List<TblOrderItem>> findByPriceRange(@RequestParam Double minPrice, @RequestParam Double maxPrice) {
        try {
            String hql = "from TblOrderItem where price >= :minPrice and price <= :maxPrice order by price desc";
            Map<String, Object> params = new HashMap<>();
            params.put("minPrice", minPrice);
            params.put("maxPrice", maxPrice);
            List<TblOrderItem> orderItems = orderItemService.find(hql, params);
            return new ResponseEntity<>(orderItems, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
} 