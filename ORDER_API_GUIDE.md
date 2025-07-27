# Hướng dẫn API Order và OrderItem

## Tổng quan

Hệ thống quản lý đơn hàng bao gồm 2 controller chính:
- **OrderController**: Quản lý đơn hàng
- **OrderItemController**: Quản lý chi tiết đơn hàng

## OrderController API

### 1. Tìm kiếm và Lấy dữ liệu

#### 1.1 Tìm đơn hàng theo ID
```
GET /api/orders/findById?id={orderId}
```
**Response:**
```json
{
  "id": 1,
  "userId": 123,
  "totalAmount": 500000.0,
  "status": 1,
  "shippingAddress": "123 Đường ABC",
  "phone": "0123456789",
  "email": "user@example.com",
  "orderDate": "2024-01-15T10:30:00",
  "createdDate": "2024-01-15T10:30:00"
}
```

#### 1.2 Lấy tất cả đơn hàng
```
GET /api/orders/list
```

#### 1.3 Tìm đơn hàng theo User ID
```
GET /api/orders/byUserId?userId={userId}
```

#### 1.4 Tìm đơn hàng theo trạng thái
```
GET /api/orders/byStatus?status={status}
```

#### 1.5 Tìm đơn hàng theo User ID và trạng thái
```
GET /api/orders/byUserIdAndStatus?userId={userId}&status={status}
```

#### 1.6 Tìm kiếm đơn hàng theo từ khóa
```
GET /api/orders/search?keyword={keyword}
```
Tìm theo: phone, email, shippingAddress

#### 1.7 Tìm đơn hàng theo khoảng thời gian
```
GET /api/orders/byDateRange?startDate={startDate}&endDate={endDate}
```

### 2. Tạo và Cập nhật

#### 2.1 Tạo đơn hàng mới
```
PUT /api/orders/createOrder
```
**Request Body:**
```json
{
  "userId": 123,
  "totalAmount": 500000.0,
  "shippingAddress": "123 Đường ABC",
  "phone": "0123456789",
  "email": "user@example.com",
  "orderItems": [
    {
      "productId": 1,
      "quantity": 2,
      "price": 250000.0
    }
  ]
}
```

#### 2.2 Cập nhật thông tin đơn hàng
```
PUT /api/orders/updateOrder
```
**Request Body:**
```json
{
  "id": "1",
  "totalAmount": 600000.0,
  "shippingAddress": "456 Đường XYZ",
  "phone": "0987654321",
  "email": "newemail@example.com"
}
```

#### 2.3 Cập nhật trạng thái đơn hàng
```
PUT /api/orders/updateOrderStatus?orderId={orderId}&status={status}
```

### 3. Xóa và Hủy

#### 3.1 Hủy đơn hàng
```
GET /api/orders/cancelOrder?orderId={orderId}
```

#### 3.2 Xóa đơn hàng
```
GET /api/orders/delete?id={orderId}
```

### 4. Thông tin bổ sung

#### 4.1 Lấy order items của đơn hàng
```
GET /api/orders/orderItems?orderId={orderId}
```

#### 4.2 Lấy tổng tiền đơn hàng
```
GET /api/orders/totalAmount?orderId={orderId}
```

#### 4.3 Thống kê đơn hàng
```
GET /api/orders/statistics
```
**Response:**
```json
{
  "totalOrders": 100,
  "pendingOrders": 20,
  "confirmedOrders": 30,
  "shippingOrders": 25,
  "completedOrders": 20,
  "cancelledOrders": 5
}
```

#### 4.4 Phân trang đơn hàng
```
POST /api/orders/paging
```
**Request Body:**
```json
{
  "page": 0
}
```

## OrderItemController API

### 1. Tìm kiếm và Lấy dữ liệu

#### 1.1 Tìm order item theo ID
```
GET /api/order-items/findById?id={orderItemId}
```

#### 1.2 Lấy tất cả order items
```
GET /api/order-items/list
```

#### 1.3 Lấy order items theo Order ID
```
GET /api/order-items/byOrderId?orderId={orderId}
```

#### 1.4 Lấy order items theo Product ID
```
GET /api/order-items/byProductId?productId={productId}
```

#### 1.5 Tìm kiếm order items theo sản phẩm
```
GET /api/order-items/searchByProduct?productName={productName}
```

#### 1.6 Lấy order items theo khoảng giá
```
GET /api/order-items/byPriceRange?minPrice={minPrice}&maxPrice={maxPrice}
```

### 2. Tạo và Cập nhật

#### 2.1 Tạo order item mới
```
POST /api/order-items/create
```
**Request Body:**
```json
{
  "orderId": 1,
  "productId": 1,
  "quantity": 2,
  "price": 250000.0
}
```

#### 2.2 Cập nhật order item
```
PUT /api/order-items/update
```
**Request Body:**
```json
{
  "id": "1",
  "quantity": 3,
  "price": 300000.0
}
```

#### 2.3 Cập nhật số lượng order item
```
PUT /api/order-items/updateQuantity?orderItemId={orderItemId}&quantity={quantity}
```

### 3. Xóa

#### 3.1 Xóa order item
```
GET /api/order-items/delete?id={orderItemId}
```

#### 3.2 Xóa tất cả order items của đơn hàng
```
GET /api/order-items/deleteByOrderId?orderId={orderId}
```

### 4. Thông tin bổ sung

#### 4.1 Lấy tổng tiền theo Order ID
```
GET /api/order-items/totalAmountByOrderId?orderId={orderId}
```

#### 4.2 Thống kê order items
```
GET /api/order-items/statistics
```
**Response:**
```json
{
  "totalOrderItems": 500,
  "totalQuantity": 1000,
  "totalRevenue": 50000000.0
}
```

## Trạng thái đơn hàng

| Status | Mô tả |
|--------|-------|
| 0 | Đang xử lý |
| 1 | Đã xác nhận (Đã thanh toán) |
| 2 | Đang giao hàng |
| 3 | Hoàn tất |
| 4 | Đã hủy |

## Luồng xử lý đơn hàng

### 1. Tạo đơn hàng
```javascript
// 1. Tạo đơn hàng
const orderResponse = await fetch('/api/orders/createOrder', {
  method: 'PUT',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify(orderData)
});

// 2. Lấy thông tin đơn hàng đã tạo
const order = await orderResponse.json();
```

### 2. Thanh toán
```javascript
// 3. Tạo URL thanh toán VNPay
const paymentResponse = await fetch(`/api/order-payment/createPayment?orderId=${order.id}&amount=${order.totalAmount}`);
const paymentUrl = await paymentResponse.text();

// 4. Redirect đến VNPay
window.location.href = paymentUrl;
```

### 3. Theo dõi trạng thái
```javascript
// 5. Kiểm tra trạng thái đơn hàng
const statusResponse = await fetch(`/api/order-payment/checkPaymentStatus?orderId=${order.id}`);
const status = await statusResponse.json();
```

## Error Handling

### Các mã lỗi thường gặp:

- **400 Bad Request**: Dữ liệu đầu vào không hợp lệ
- **404 Not Found**: Không tìm thấy đơn hàng/order item
- **500 Internal Server Error**: Lỗi server

### Response format cho lỗi:
```json
{
  "message": "Lỗi: Có lỗi xảy ra trong quá trình xử lý!"
}
```

## Best Practices

### 1. Validation
- Luôn validate dữ liệu đầu vào
- Kiểm tra quyền truy cập trước khi thực hiện thao tác
- Validate trạng thái đơn hàng trước khi cập nhật

### 2. Security
- Sử dụng authentication cho tất cả API
- Validate user ownership cho đơn hàng
- Log tất cả các thao tác quan trọng

### 3. Performance
- Sử dụng phân trang cho danh sách lớn
- Cache dữ liệu thống kê
- Optimize queries với index

### 4. Monitoring
- Theo dõi tỷ lệ thành công/thất bại
- Monitor thời gian response
- Alert khi có lỗi nghiêm trọng

## Testing

### Test cases cần thiết:

1. **Tạo đơn hàng**
   - Tạo đơn hàng hợp lệ
   - Tạo đơn hàng với dữ liệu không hợp lệ
   - Tạo đơn hàng không có order items

2. **Cập nhật đơn hàng**
   - Cập nhật thông tin đơn hàng
   - Cập nhật trạng thái đơn hàng
   - Cập nhật đơn hàng không tồn tại

3. **Xóa đơn hàng**
   - Xóa đơn hàng hợp lệ
   - Xóa đơn hàng không tồn tại
   - Xóa đơn hàng đã thanh toán

4. **Tìm kiếm**
   - Tìm kiếm theo các tiêu chí khác nhau
   - Tìm kiếm với dữ liệu không tồn tại
   - Test phân trang

5. **Thanh toán**
   - Tạo URL thanh toán
   - Xử lý callback thành công
   - Xử lý callback thất bại 