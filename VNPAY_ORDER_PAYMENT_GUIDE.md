# Hướng dẫn sử dụng hệ thống thanh toán VNPay cho đặt hàng

## Tổng quan

Hệ thống thanh toán VNPay đã được chuyển đổi từ đặt sân sang đặt hàng. Dưới đây là hướng dẫn chi tiết về cách sử dụng.

## Cấu trúc hệ thống

### 1. VnPayService
- **File**: `ttisv-service/src/main/java/com/ttisv/service/system/VnPayService.java`
- **Chức năng**: Tạo URL thanh toán VNPay và chữ ký bảo mật
- **Thay đổi chính**: 
  - Tham số từ `bookingId` → `orderId`
  - Thông tin đơn hàng từ "Thanh toán đặt sân" → "Thanh toán đặt hàng"

### 2. OrderPaymentController (Mới)
- **File**: `springbootwildfly/src/main/java/com/ttisv/springbootwildfly/controllers/OrderPaymentController.java`
- **Endpoint**: `/api/order-payment/*`
- **Chức năng**: Xử lý thanh toán đặt hàng

### 3. VnPayController (Đã cập nhật)
- **File**: `springbootwildfly/src/main/java/com/ttisv/springbootwildfly/controllers/VnPayController.java`
- **Endpoint**: `/api/payment/*`
- **Chức năng**: Xử lý thanh toán (có thể dùng cho cả đặt sân và đặt hàng)

## API Endpoints

### 1. Tạo URL thanh toán
```
GET /api/order-payment/createPayment
```

**Parameters:**
- `orderId` (Long): ID đơn hàng
- `amount` (Double): Số tiền thanh toán

**Response:**
- Success: URL thanh toán VNPay
- Error: Thông báo lỗi

**Ví dụ:**
```
GET /api/order-payment/createPayment?orderId=123&amount=500000
```

### 2. Callback từ VNPay
```
POST /api/order-payment/vnpay-return
```

**Body:** Các tham số từ VNPay trả về

**Xử lý:**
- Nếu `vnp_ResponseCode = "00"`: Thanh toán thành công
  - Cập nhật trạng thái đơn hàng thành "Đã xác nhận" (status = 1)
  - Gửi thông báo
  - Lưu notification vào database
- Nếu khác "00": Thanh toán thất bại
  - Hủy đơn hàng (status = 4)

### 3. Kiểm tra trạng thái thanh toán
```
GET /api/order-payment/checkPaymentStatus
```

**Parameters:**
- `orderId` (Long): ID đơn hàng

**Response:**
- Trạng thái đơn hàng hiện tại

### 4. Lấy thông báo
```
GET /api/order-payment/notification
```

**Parameters:**
- `fieldId` (Long): ID field (có thể điều chỉnh theo logic nghiệp vụ)

## Trạng thái đơn hàng

| Status | Mô tả |
|--------|-------|
| 0 | Đang xử lý |
| 1 | Đã xác nhận (Đã thanh toán) |
| 2 | Đang giao hàng |
| 3 | Hoàn tất |
| 4 | Đã hủy |

## Cấu hình

### application.properties
```properties
# VNPay Configuration
vnpay.tmncode=YAU4UZ9R
vnpay.hashSecret=BZ6K4MB1DRNIXM2RIOGZXHR3AOL8G21B
vnpay.url=https://sandbox.vnpayment.vn/paymentv2/vpcpay.html
vnpay.returnUrl=http://localhost:4200/order/payment-result
```

## Luồng thanh toán

### 1. Tạo đơn hàng
```java
// Tạo đơn hàng với status = 0 (Đang xử lý)
TblOrder order = new TblOrder();
order.setUserId(userId);
order.setTotalAmount(amount);
order.setStatus(0L);
orderService.createOrder(order);
```

### 2. Tạo URL thanh toán
```java
// Gọi API tạo URL thanh toán
String paymentUrl = vnpayService.createPaymentUrl(orderId, amount);
```

### 3. Redirect người dùng
```javascript
// Frontend redirect người dùng đến VNPay
window.location.href = paymentUrl;
```

### 4. Xử lý callback
- VNPay gọi về `/api/order-payment/vnpay-return`
- Hệ thống cập nhật trạng thái đơn hàng
- Gửi thông báo

## Tích hợp với OrderController

Để tích hợp thanh toán vào quy trình đặt hàng:

```java
@PutMapping("/createOrder")
public ResponseEntity<?> createOrder(@Valid @RequestBody OrderRequest orderRequest) {
    try {
        // Tạo đơn hàng
        TblOrder order = orderService.createOrder(orderRequest);
        
        // Tạo URL thanh toán
        String paymentUrl = vnpayService.createPaymentUrl(order.getId(), order.getTotalAmount());
        
        // Trả về thông tin đơn hàng và URL thanh toán
        Map<String, Object> response = new HashMap<>();
        response.put("order", order);
        response.put("paymentUrl", paymentUrl);
        
        return ResponseEntity.ok(response);
    } catch (Exception e) {
        return ResponseEntity.badRequest().body(new MessageResponse("Lỗi tạo đơn hàng"));
    }
}
```

## Lưu ý

1. **Bảo mật**: Đảm bảo validate tất cả input từ VNPay
2. **Logging**: Ghi log đầy đủ các giao dịch thanh toán
3. **Error Handling**: Xử lý lỗi một cách graceful
4. **Testing**: Test kỹ với sandbox VNPay trước khi deploy production
5. **Monitoring**: Theo dõi tỷ lệ thành công/thất bại của các giao dịch

## Troubleshooting

### Lỗi thường gặp:
1. **Invalid signature**: Kiểm tra lại `vnpay.hashSecret`
2. **Order not found**: Kiểm tra `orderId` có tồn tại không
3. **Invalid amount**: Đảm bảo số tiền đúng format (VND)
4. **Callback timeout**: Kiểm tra network và VNPay service

### Debug:
- Kiểm tra log để xem chi tiết lỗi
- Verify các tham số VNPay
- Test với sandbox trước 