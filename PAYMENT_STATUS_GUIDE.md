# Hướng dẫn trạng thái thanh toán

## Tổng quan
Khi thanh toán thành công qua VNPay, hệ thống sẽ cập nhật trạng thái đơn hàng và trả về thông tin chi tiết.

## Trạng thái đơn hàng (Order Status)

### Các trạng thái có thể có:
- **0**: Đang xử lý (Chưa thanh toán)
- **1**: Đã xác nhận (Đã thanh toán thành công)
- **2**: Đang giao hàng
- **3**: Hoàn tất
- **4**: Đã hủy

### Khi thanh toán thành công:
- **Status được cập nhật thành 1** (Đã xác nhận)
- **VNPay trả về ResponseCode = "00"**
- **Hệ thống tự động cập nhật trạng thái**

## Các endpoint kiểm tra trạng thái

### 1. Kiểm tra trạng thái cơ bản
```
GET /api/order-payment/checkPaymentStatus?orderId={orderId}
GET /api/order-payment/checkPaymentStatus?bookingId={bookingId}
```

**Response:**
```json
{
    "message": "Trạng thái đơn hàng: Đã xác nhận (Đã thanh toán)"
}
```

### 2. Kiểm tra trạng thái chi tiết (Mới)
```
GET /api/order-payment/getPaymentStatusDetail?orderId={orderId}
GET /api/order-payment/getPaymentStatusDetail?bookingId={bookingId}
```

**Response:**
```json
{
    "orderId": 6,
    "status": 1,
    "statusCode": 1,
    "orderDate": "2024-12-01T10:30:00",
    "totalAmount": 74690000.0,
    "customerName": "Nguyễn Văn A",
    "customerPhone": "0123456789",
    "customerAddress": "123 Đường ABC, Quận 1, TP.HCM",
    "statusMessage": "Đã xác nhận (Đã thanh toán)",
    "isPaid": true,
    "paymentSuccess": true
}
```

## Logic xử lý thanh toán

### Khi thanh toán thành công (VNPay ResponseCode = "00"):
```java
// Cập nhật trạng thái đơn hàng thành "Đã xác nhận" (status = 1)
orderService.updateOrderStatus(orderId, 1L);

// Gửi thông báo
notificationController.sendNotification(notificationMessage);

// Lưu thông báo vào database
tblNotificationService.saveNotification(notification);

// Trả về response
return ResponseEntity.ok("Payment success and order status updated");
```

### Khi thanh toán thất bại:
```java
// Hủy đơn hàng (status = 4)
orderService.cancelOrder(orderId);

// Trả về response
return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Payment failed, order cancelled");
```

## Cách kiểm tra thanh toán thành công

### 1. Kiểm tra status code:
```javascript
// Gọi API kiểm tra trạng thái
const response = await fetch(`/api/order-payment/getPaymentStatusDetail?orderId=${orderId}`);
const data = await response.json();

if (data.statusCode === 1) {
    console.log("Thanh toán thành công!");
} else if (data.statusCode === 0) {
    console.log("Chưa thanh toán");
} else if (data.statusCode === 4) {
    console.log("Đơn hàng đã bị hủy");
}
```

### 2. Kiểm tra boolean flags:
```javascript
if (data.isPaid) {
    console.log("Đã thanh toán");
}

if (data.paymentSuccess) {
    console.log("Thanh toán thành công");
}
```

### 3. Kiểm tra status message:
```javascript
if (data.statusMessage.includes("Đã thanh toán")) {
    console.log("Thanh toán thành công");
}
```

## Ví dụ sử dụng

### Frontend code để kiểm tra thanh toán:
```javascript
async function checkPaymentStatus(orderId) {
    try {
        const response = await fetch(`/api/order-payment/getPaymentStatusDetail?orderId=${orderId}`);
        
        if (response.ok) {
            const data = await response.json();
            
            if (data.paymentSuccess) {
                // Thanh toán thành công
                showSuccessMessage(`Đơn hàng #${data.orderId} đã thanh toán thành công!`);
                updateOrderStatus(data);
            } else if (data.statusCode === 0) {
                // Chưa thanh toán
                showPendingMessage("Đang chờ thanh toán...");
            } else if (data.statusCode === 4) {
                // Đã hủy
                showErrorMessage("Đơn hàng đã bị hủy");
            }
        } else {
            const error = await response.json();
            showErrorMessage(error.message);
        }
    } catch (error) {
        console.error('Error checking payment status:', error);
        showErrorMessage("Có lỗi xảy ra khi kiểm tra trạng thái");
    }
}

function showSuccessMessage(message) {
    // Hiển thị thông báo thành công
    alert(message);
}

function updateOrderStatus(data) {
    // Cập nhật UI với thông tin đơn hàng
    document.getElementById('order-status').textContent = data.statusMessage;
    document.getElementById('order-amount').textContent = data.totalAmount.toLocaleString('vi-VN') + ' VNĐ';
}
```

### Polling để kiểm tra trạng thái:
```javascript
function pollPaymentStatus(orderId, maxAttempts = 30) {
    let attempts = 0;
    
    const poll = async () => {
        if (attempts >= maxAttempts) {
            console.log("Hết thời gian chờ thanh toán");
            return;
        }
        
        try {
            const response = await fetch(`/api/order-payment/getPaymentStatusDetail?orderId=${orderId}`);
            const data = await response.json();
            
            if (data.paymentSuccess) {
                console.log("Thanh toán thành công!");
                // Xử lý khi thanh toán thành công
                return;
            } else if (data.statusCode === 4) {
                console.log("Đơn hàng đã bị hủy");
                return;
            }
            
            // Tiếp tục polling sau 2 giây
            attempts++;
            setTimeout(poll, 2000);
            
        } catch (error) {
            console.error('Error polling payment status:', error);
            attempts++;
            setTimeout(poll, 2000);
        }
    };
    
    poll();
}

// Sử dụng
pollPaymentStatus(6); // Kiểm tra đơn hàng ID 6
```

## Lưu ý quan trọng

1. **Status = 1**: Đơn hàng đã thanh toán thành công
2. **Status = 0**: Chưa thanh toán hoặc đang xử lý
3. **Status = 4**: Đơn hàng đã bị hủy
4. **VNPay ResponseCode = "00"**: Thanh toán thành công
5. **VNPay ResponseCode khác "00"**: Thanh toán thất bại

## Troubleshooting

### Nếu status không được cập nhật:
1. Kiểm tra VNPay callback URL có đúng không
2. Kiểm tra log để xem có lỗi gì không
3. Kiểm tra database connection
4. Kiểm tra orderId có tồn tại không

### Nếu không nhận được thông báo:
1. Kiểm tra notification service
2. Kiểm tra WebSocket connection
3. Kiểm tra notification database 