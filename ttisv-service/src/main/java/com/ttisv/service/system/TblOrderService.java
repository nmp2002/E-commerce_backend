package com.ttisv.service.system;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ttisv.bean.system.TblOrder;

public interface TblOrderService {
    
    public Serializable save(TblOrder order);
    
    public void delete(Serializable id);
    
    public void update(TblOrder order);
    
    public TblOrder get(Serializable id);
    
    public List<TblOrder> find(String hql);
    
    public List<TblOrder> find(String hql, Map<String, Object> params);
    
    public List<TblOrder> find(String hql, int page, int rows);
    
    public List<TblOrder> find(String hql, Map<String, Object> params, int page, int rows);
    
    public Integer count(String hql);
    
    public Integer count(String hql, Map<String, Object> params);
    
    // Custom business methods
    public List<TblOrder> findByUserId(Long userId);
    
    public List<TblOrder> findByStatus(Long status);
    
    public List<TblOrder> findByUserIdAndStatus(Long userId, Long status);
    
    public List<TblOrder> findOrdersByDateRange(Date startDate, Date endDate);
    
    public TblOrder createOrder(TblOrder order);
    
    public TblOrder updateOrderStatus(Long orderId, Long status);
    
    public void cancelOrder(Long orderId);
} 