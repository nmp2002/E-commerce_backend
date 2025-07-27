# Khắc phục lỗi ClassCastException trong Order System

## Lỗi gặp phải

```
class java.lang.Long cannot be cast to class com.ttisv.bean.system.TblOrder 
(java.lang.Long is in module java.base of loader 'bootstrap'; 
com.ttisv.bean.system.TblOrder is in unnamed module of loader 'app')
```

## Nguyên nhân

Lỗi này xảy ra trong `TblOrderServiceImpl.createOrder()` tại dòng 98. Nguyên nhân chính là:

1. **Method `save()` của Hibernate trả về `Serializable` (thường là ID)**, không phải entity object
2. **Code đang cố gắng cast kết quả của `save()` thành `TblOrder`**
3. **`BaseDaoImpl.save()` gọi `session.save()` của Hibernate**

### Code gây lỗi:
```java
// LỖI: save() trả về Serializable (Long), không phải TblOrder
return (TblOrder) orderDao.save(order);
```

## Cách khắc phục

### 1. Sử dụng `saveOrUpdate()` thay vì `save()`

#### **Thêm method vào TblOrderDao interface:**
```java
public interface TblOrderDao {
    public Serializable save(TblOrder order);
    public TblOrder saveOrUpdate(TblOrder order); // Thêm method này
    // ... other methods
}
```

#### **Implement trong TblOrderDaoImpl:**
```java
@Repository("tblOrderDao")
public class TblOrderDaoImpl extends BaseDaoImpl<TblOrder> implements TblOrderDao {

    @Override
    public TblOrder saveOrUpdate(TblOrder order) {
        return super.saveOrUpdate(order);
    }
    
    // ... other methods
}
```

#### **Sửa TblOrderServiceImpl:**
```java
@Override
public TblOrder createOrder(TblOrder order) {
    try {
        order.setOrderDate(new Date());
        order.setCreatedDate(new Date());
        order.setStatus(0L); // Đang xử lý
        
        // Sử dụng saveOrUpdate để đảm bảo order được save và trả về object
        TblOrder savedOrder = orderDao.saveOrUpdate(order);
        
        // Trả về order đã được save
        return savedOrder;
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Failed to create order: " + e.getMessage());
    }
}
```

### 2. Sự khác biệt giữa `save()` và `saveOrUpdate()`

#### **`save()`:**
- Trả về `Serializable` (ID của entity)
- Chỉ dùng cho entity mới (transient)
- Không update entity hiện có

#### **`saveOrUpdate()`:**
- Trả về entity object đã được save/update
- Có thể dùng cho cả entity mới và existing
- Tự động quyết định save hay update

### 3. Cách tiếp cận thay thế (nếu không muốn dùng saveOrUpdate)

```java
@Override
public TblOrder createOrder(TblOrder order) {
    try {
        order.setOrderDate(new Date());
        order.setCreatedDate(new Date());
        order.setStatus(0L); // Đang xử lý
        
        // Save order và lấy ID
        Serializable savedId = orderDao.save(order);
        
        // Set ID cho order
        if (savedId != null) {
            if (savedId instanceof Long) {
                order.setId((Long) savedId);
            } else if (savedId instanceof Integer) {
                order.setId(((Integer) savedId).longValue());
            }
        }
        
        // Trả về order đã được save
        return order;
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Failed to create order: " + e.getMessage());
    }
}
```

## Best Practices

### 1. **Luôn kiểm tra kiểu dữ liệu trước khi cast**
```java
if (result instanceof TblOrder) {
    return (TblOrder) result;
} else if (result instanceof Long) {
    // Handle Long case
}
```

### 2. **Sử dụng method phù hợp với mục đích**
- `save()`: Khi chỉ cần lưu entity mới và lấy ID
- `saveOrUpdate()`: Khi cần lưu/update và lấy entity object
- `update()`: Khi chỉ update entity existing

### 3. **Exception Handling**
```java
try {
    // Database operations
} catch (Exception e) {
    e.printStackTrace();
    throw new RuntimeException("Failed to create order: " + e.getMessage());
}
```

### 4. **Validation trước khi save**
```java
// Validate required fields
if (order.getUserId() == null) {
    throw new IllegalArgumentException("User ID is required");
}
if (order.getTotalAmount() == null || order.getTotalAmount() <= 0) {
    throw new IllegalArgumentException("Total amount must be positive");
}
```

## Testing

### 1. **Test createOrder method:**
```java
@Test
public void testCreateOrder() {
    TblOrder order = new TblOrder();
    order.setUserId(1L);
    order.setTotalAmount(100000.0);
    order.setShippingAddress("Test Address");
    order.setPhone("0123456789");
    order.setEmail("test@example.com");
    
    TblOrder savedOrder = orderService.createOrder(order);
    
    assertNotNull(savedOrder);
    assertNotNull(savedOrder.getId());
    assertEquals(0L, savedOrder.getStatus().longValue());
    assertNotNull(savedOrder.getOrderDate());
    assertNotNull(savedOrder.getCreatedDate());
}
```

### 2. **Test error scenarios:**
```java
@Test
public void testCreateOrderWithNullData() {
    TblOrder order = new TblOrder();
    // Don't set required fields
    
    assertThrows(RuntimeException.class, () -> {
        orderService.createOrder(order);
    });
}
```

## Monitoring và Debugging

### 1. **Enable SQL logging:**
```properties
# application.properties
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```

### 2. **Add debug logging:**
```java
@Override
public TblOrder createOrder(TblOrder order) {
    try {
        logger.debug("Creating order: {}", order);
        
        order.setOrderDate(new Date());
        order.setCreatedDate(new Date());
        order.setStatus(0L);
        
        TblOrder savedOrder = orderDao.saveOrUpdate(order);
        
        logger.debug("Order created successfully with ID: {}", savedOrder.getId());
        return savedOrder;
    } catch (Exception e) {
        logger.error("Failed to create order: {}", e.getMessage(), e);
        throw new RuntimeException("Failed to create order: " + e.getMessage());
    }
}
```

## Kết luận

Lỗi `ClassCastException` này xảy ra do hiểu nhầm về return type của method `save()` trong Hibernate. Bằng cách sử dụng `saveOrUpdate()` hoặc xử lý đúng return type của `save()`, chúng ta có thể khắc phục lỗi này một cách hiệu quả.

**Khuyến nghị:** Sử dụng `saveOrUpdate()` cho các trường hợp cần lấy entity object sau khi save, và `save()` cho các trường hợp chỉ cần ID. 