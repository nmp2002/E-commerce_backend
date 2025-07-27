# Hướng dẫn tương thích ngược BookingId và OrderId

## Vấn đề
Frontend đang gọi API với parameter `bookingId` thay vì `orderId`, gây ra lỗi 400 Bad Request.

## Nguyên nhân
- Hệ thống đã chuyển từ booking sang order payment
- Frontend vẫn đang sử dụng logic cũ với `bookingId`
- API endpoint yêu cầu `orderId` nhưng frontend truyền `bookingId`

## Giải pháp đã áp dụng

### 1. Hỗ trợ tương thích ngược
Các endpoint payment hiện tại hỗ trợ cả hai parameter:
- `orderId` (mới)
- `bookingId` (cũ, tương thích ngược)

### 2. Logic xử lý
```java
// Hỗ trợ cả orderId và bookingId (tương thích ngược)
Long finalOrderId = orderId;
if (finalOrderId == null && bookingId != null) {
    finalOrderId = bookingId;
}

if (finalOrderId == null) {
    return ResponseEntity.badRequest().body("Lỗi: orderId hoặc bookingId không được để trống!");
}
```

### 3. Các endpoint đã được cập nhật

#### OrderPaymentController
- `GET /api/order-payment/createPayment`
- `GET /api/order-payment/checkPaymentStatus`

#### VnPayController
- `GET /api/payment/createPayment`

## Cách sử dụng

### Frontend có thể gọi với bookingId (cũ):
```
GET /api/order-payment/createPayment?bookingId=6&amount=74690000
```

### Hoặc với orderId (mới):
```
GET /api/order-payment/createPayment?orderId=6&amount=74690000
```

### Hoặc cả hai (orderId sẽ được ưu tiên):
```
GET /api/order-payment/createPayment?orderId=6&bookingId=6&amount=74690000
```

## Response format

### Khi thành công:
```json
"https://sandbox.vnpayment.vn/paymentv2/vpcpay.html?vnp_Amount=74690000&vnp_Command=pay&vnp_CreateDate=20241201120000&vnp_CurrCode=VND&vnp_IpAddr=127.0.0.1&vnp_Locale=vn&vnp_OrderInfo=Thanh+toan+don+hang+6&vnp_OrderType=other&vnp_ReturnUrl=http://localhost:8080/api/payment/vnpay-return&vnp_TmnCode=DEMO&vnp_TxnRef=6&vnp_Version=2.1.0&vnp_SecureHash=..."
```

### Khi thiếu parameter:
```json
{
    "message": "Lỗi: orderId hoặc bookingId không được để trống!"
}
```

### Khi thiếu amount:
```json
{
    "message": "Lỗi: amount không được để trống!"
}
```

## Lợi ích

1. **Tương thích ngược**: Frontend cũ vẫn hoạt động bình thường
2. **Linh hoạt**: Hỗ trợ cả hai cách gọi API
3. **Migration dễ dàng**: Có thể chuyển đổi từ từ
4. **Không breaking change**: Không ảnh hưởng đến code hiện tại

## Khuyến nghị cho Frontend

### 1. Cập nhật dần dần
```javascript
// Cũ (vẫn hoạt động)
const response = await fetch(`/api/order-payment/createPayment?bookingId=${id}&amount=${amount}`);

// Mới (khuyến nghị)
const response = await fetch(`/api/order-payment/createPayment?orderId=${id}&amount=${amount}`);
```

### 2. Validation
```javascript
function createPayment(id, amount) {
    if (!id) {
        alert('Vui lòng nhập ID đơn hàng');
        return;
    }
    if (!amount) {
        alert('Vui lòng nhập số tiền');
        return;
    }
    
    // Sử dụng orderId thay vì bookingId
    return fetch(`/api/order-payment/createPayment?orderId=${id}&amount=${amount}`);
}
```

### 3. Error handling
```javascript
try {
    const response = await createPayment(orderId, amount);
    if (response.ok) {
        const paymentUrl = await response.text();
        window.location.href = paymentUrl;
    } else {
        const error = await response.json();
        alert(error.message);
    }
} catch (error) {
    console.error('Error:', error);
    alert('Có lỗi xảy ra khi tạo thanh toán');
}
```

## Migration Plan

### Phase 1: Tương thích ngược (Hiện tại)
- Hỗ trợ cả `bookingId` và `orderId`
- Frontend có thể sử dụng cả hai

### Phase 2: Cập nhật Frontend
- Thay đổi từ `bookingId` sang `orderId`
- Cập nhật logic xử lý

### Phase 3: Loại bỏ bookingId (Tương lai)
- Chỉ hỗ trợ `orderId`
- Deprecate `bookingId` parameter

## Testing

### Test cases cần kiểm tra:
1. Gọi với `bookingId` → Thành công
2. Gọi với `orderId` → Thành công
3. Gọi với cả hai → `orderId` được ưu tiên
4. Không truyền parameter → Lỗi rõ ràng
5. Truyền sai format → Lỗi validation

### Ví dụ test:
```bash
# Test với bookingId
curl "http://localhost:8080/api/order-payment/createPayment?bookingId=6&amount=74690000"

# Test với orderId
curl "http://localhost:8080/api/order-payment/createPayment?orderId=6&amount=74690000"

# Test thiếu parameter
curl "http://localhost:8080/api/order-payment/createPayment?amount=74690000"
```

## Kết luận
Giải pháp tương thích ngược này cho phép hệ thống hoạt động mượt mà trong quá trình chuyển đổi từ booking sang order payment, đồng thời cung cấp lộ trình migration rõ ràng cho frontend. 