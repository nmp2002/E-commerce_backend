# Hướng dẫn sửa lỗi MissingServletRequestParameterException

## Mô tả lỗi
Lỗi `MissingServletRequestParameterException: Required request parameter 'orderId' for method parameter type Long is not present` xảy ra khi frontend gọi API mà không truyền parameter bắt buộc.

## Nguyên nhân
- Frontend không truyền parameter `orderId` trong request
- Parameter được đánh dấu là `required = true` (mặc định) nhưng không được truyền
- URL không đúng format hoặc thiếu parameter

## Giải pháp đã áp dụng

### 1. Thay đổi annotation @RequestParam
Thay đổi từ:
```java
@RequestParam Long orderId
```
Thành:
```java
@RequestParam(required = false) Long orderId
```

### 2. Thêm validation trong method
Thêm kiểm tra null và trả về thông báo lỗi rõ ràng:
```java
if (orderId == null) {
    return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: orderId không được để trống!"));
}
```

### 3. Các endpoint đã được sửa

#### OrderController
- `PUT /api/orders/updateOrderStatus` - Cập nhật trạng thái đơn hàng
- `GET /api/orders/cancelOrder` - Hủy đơn hàng
- `GET /api/orders/orderItems` - Lấy danh sách order items
- `GET /api/orders/totalAmount` - Lấy tổng tiền đơn hàng

#### OrderItemController
- `GET /api/orderItems/byOrderId` - Tìm order items theo orderId
- `GET /api/orderItems/deleteByOrderId` - Xóa order items theo orderId
- `GET /api/orderItems/totalAmountByOrderId` - Lấy tổng tiền theo orderId

#### OrderPaymentController
- `GET /api/orderPayment/createPayment` - Tạo URL thanh toán
- `GET /api/orderPayment/checkPaymentStatus` - Kiểm tra trạng thái thanh toán

#### VnPayController
- `GET /api/payment/createPayment` - Tạo URL thanh toán VNPay

## Cách sử dụng API

### Ví dụ gọi API đúng:
```
GET /api/orders/orderItems?orderId=123
GET /api/orderPayment/createPayment?orderId=123&amount=100000
```

### Ví dụ gọi API sai (sẽ trả về lỗi rõ ràng):
```
GET /api/orders/orderItems
GET /api/orderPayment/createPayment?orderId=123
```

## Response format

### Khi thiếu parameter:
```json
{
    "message": "Lỗi: orderId không được để trống!"
}
```

### Khi thành công:
```json
{
    "data": [...],
    "message": "Thành công"
}
```

## Lợi ích của việc sửa đổi

1. **Graceful error handling**: Thay vì throw exception, API trả về thông báo lỗi rõ ràng
2. **Better user experience**: Frontend có thể hiển thị thông báo lỗi thân thiện
3. **Easier debugging**: Dễ dàng xác định lỗi từ phía frontend
4. **Consistent error format**: Tất cả lỗi đều có format thống nhất

## Khuyến nghị cho Frontend

1. **Validation**: Kiểm tra parameter trước khi gọi API
2. **Error handling**: Xử lý response lỗi và hiển thị thông báo phù hợp
3. **URL encoding**: Đảm bảo parameter được encode đúng cách
4. **Testing**: Test các trường hợp thiếu parameter

## Ví dụ code Frontend (JavaScript)

```javascript
// Kiểm tra parameter trước khi gọi API
function getOrderItems(orderId) {
    if (!orderId) {
        alert('Vui lòng nhập Order ID');
        return;
    }
    
    fetch(`/api/orders/orderItems?orderId=${orderId}`)
        .then(response => response.json())
        .then(data => {
            if (data.message && data.message.includes('Lỗi')) {
                alert(data.message);
            } else {
                // Xử lý data thành công
                console.log(data);
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Có lỗi xảy ra khi gọi API');
        });
}
```

## Kết luận
Việc sửa đổi này giúp hệ thống xử lý lỗi tốt hơn và cung cấp thông tin hữu ích cho developer và user khi có lỗi xảy ra. 