# Hướng dẫn Flow Điều hướng Thanh toán VNPay

## Tổng quan Flow

### 1. Flow hiện tại (Đã cập nhật):
```
Frontend → Backend → VNPay → Backend → Frontend
```

### 2. Chi tiết các bước:

#### Bước 1: Frontend tạo thanh toán
```
Frontend gọi: GET /api/order-payment/createPayment?orderId=6&amount=74690000
Backend trả về: URL thanh toán VNPay
```

#### Bước 2: Chuyển hướng đến VNPay
```
Frontend redirect: https://sandbox.vnpayment.vn/paymentv2/vpcpay.html?...
User thanh toán trên VNPay
```

#### Bước 3: VNPay redirect về Backend
```
VNPay redirect: http://localhost:8080/api/payment/vnpay-redirect?vnp_ResponseCode=00&vnp_TxnRef=6&...
Backend xử lý và cập nhật trạng thái
```

#### Bước 4: Backend redirect về Frontend
```
Backend redirect: http://localhost:4200/order/payment-result?status=success&orderId=6&amount=74690000
Frontend hiển thị kết quả
```

## Cấu hình Return URL

### Backend Configuration (application.properties):
```properties
vnpay.returnUrl=http://localhost:8080/api/payment/vnpay-redirect
```

### Frontend URL nhận kết quả:
```
http://localhost:4200/order/payment-result
```

## Các trạng thái redirect

### 1. Thanh toán thành công:
```
http://localhost:4200/order/payment-result?status=success&orderId=6&amount=74690000
```

### 2. Thanh toán thất bại:
```
http://localhost:4200/order/payment-result?status=failed&orderId=6&message=Payment+failed
```

### 3. Lỗi hệ thống:
```
http://localhost:4200/order/payment-result?status=error&message=Payment+success+but+failed+to+update+order
```

## Frontend Implementation

### 1. Component Payment Result (Angular):

```typescript
// payment-result.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-payment-result',
  template: `
    <div class="payment-result">
      <div *ngIf="status === 'success'" class="success">
        <h2>Thanh toán thành công!</h2>
        <p>Đơn hàng #{{ orderId }} đã được thanh toán</p>
        <p>Số tiền: {{ amount | currency:'VND' }}</p>
        <button (click)="goToOrders()">Xem đơn hàng</button>
      </div>
      
      <div *ngIf="status === 'failed'" class="failed">
        <h2>Thanh toán thất bại!</h2>
        <p>{{ message }}</p>
        <button (click)="retryPayment()">Thử lại</button>
      </div>
      
      <div *ngIf="status === 'error'" class="error">
        <h2>Có lỗi xảy ra!</h2>
        <p>{{ message }}</p>
        <button (click)="contactSupport()">Liên hệ hỗ trợ</button>
      </div>
    </div>
  `
})
export class PaymentResultComponent implements OnInit {
  status: string = '';
  orderId: string = '';
  amount: string = '';
  message: string = '';

  constructor(
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.status = params['status'] || '';
      this.orderId = params['orderId'] || '';
      this.amount = params['amount'] || '';
      this.message = params['message'] || '';
      
      // Log để debug
      console.log('Payment Result:', {
        status: this.status,
        orderId: this.orderId,
        amount: this.amount,
        message: this.message
      });
    });
  }

  goToOrders() {
    this.router.navigate(['/orders']);
  }

  retryPayment() {
    // Có thể redirect về trang checkout hoặc tạo thanh toán mới
    this.router.navigate(['/checkout']);
  }

  contactSupport() {
    // Liên hệ hỗ trợ
    window.open('mailto:support@example.com', '_blank');
  }
}
```

### 2. Routing Configuration:

```typescript
// app-routing.module.ts
const routes: Routes = [
  // ... other routes
  {
    path: 'order/payment-result',
    component: PaymentResultComponent
  }
];
```

### 3. CSS Styling:

```css
/* payment-result.component.css */
.payment-result {
  max-width: 600px;
  margin: 50px auto;
  padding: 30px;
  text-align: center;
  border-radius: 10px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.success {
  background-color: #d4edda;
  border: 1px solid #c3e6cb;
  color: #155724;
}

.failed {
  background-color: #f8d7da;
  border: 1px solid #f5c6cb;
  color: #721c24;
}

.error {
  background-color: #fff3cd;
  border: 1px solid #ffeaa7;
  color: #856404;
}

button {
  margin: 10px;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 16px;
}

.success button {
  background-color: #28a745;
  color: white;
}

.failed button {
  background-color: #dc3545;
  color: white;
}

.error button {
  background-color: #ffc107;
  color: #212529;
}
```

## Backend Endpoints

### 1. Tạo thanh toán:
```
GET /api/order-payment/createPayment?orderId=6&amount=74690000
```

### 2. Xử lý redirect từ VNPay:
```
GET /api/payment/vnpay-redirect?vnp_ResponseCode=00&vnp_TxnRef=6&...
```

### 3. Kiểm tra trạng thái:
```
GET /api/order-payment/getPaymentStatusDetail?orderId=6
```

## Testing Flow

### 1. Test thanh toán thành công:
```bash
# 1. Tạo thanh toán
curl "http://localhost:8080/api/order-payment/createPayment?orderId=6&amount=74690000"

# 2. Simulate VNPay redirect (success)
curl "http://localhost:8080/api/payment/vnpay-redirect?vnp_ResponseCode=00&vnp_TxnRef=6&vnp_Amount=74690000"

# 3. Kiểm tra trạng thái
curl "http://localhost:8080/api/order-payment/getPaymentStatusDetail?orderId=6"
```

### 2. Test thanh toán thất bại:
```bash
# Simulate VNPay redirect (failed)
curl "http://localhost:8080/api/payment/vnpay-redirect?vnp_ResponseCode=07&vnp_TxnRef=6"
```

## Troubleshooting

### 1. Nếu không redirect về frontend:
- Kiểm tra cấu hình `vnpay.returnUrl` trong `application.properties`
- Kiểm tra frontend có chạy trên port 4200 không
- Kiểm tra CORS configuration

### 2. Nếu không nhận được parameters:
- Kiểm tra VNPay có gửi đúng parameters không
- Kiểm tra log của endpoint `/vnpay-redirect`

### 3. Nếu status không được cập nhật:
- Kiểm tra database connection
- Kiểm tra orderId có tồn tại không
- Kiểm tra log để xem có exception gì không

## Lưu ý quan trọng

1. **CORS Configuration**: Đảm bảo backend cho phép frontend truy cập
2. **HTTPS**: Trong production, sử dụng HTTPS cho tất cả URLs
3. **Error Handling**: Luôn xử lý các trường hợp lỗi
4. **Logging**: Log đầy đủ để debug
5. **Security**: Validate tất cả parameters từ VNPay

## Production Configuration

### 1. Update application.properties:
```properties
vnpay.returnUrl=https://yourdomain.com/api/payment/vnpay-redirect
```

### 2. Update frontend URL:
```typescript
// Thay đổi từ localhost:4200 thành domain thực tế
const frontendUrl = "https://yourdomain.com/order/payment-result?status=success&orderId=" + orderId;
``` 