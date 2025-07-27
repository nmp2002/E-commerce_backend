package com.ttisv.dao.system;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ttisv.bean.system.TblOrderItem;

public interface TblOrderItemDao {
    
    public Serializable save(TblOrderItem orderItem);
    
    public void delete(Serializable id);
    
    public void update(TblOrderItem orderItem);
    
    public TblOrderItem get(Serializable id);
    
    public List<TblOrderItem> find(String hql);
    
    public List<TblOrderItem> find(String hql, Map<String, Object> params);
    
    public List<TblOrderItem> find(String hql, int page, int rows);
    
    public List<TblOrderItem> find(String hql, Map<String, Object> params, int page, int rows);
    
    public Integer count(String hql);
    
    public Integer count(String hql, Map<String, Object> params);
    
    // Custom business methods
    public List<TblOrderItem> findByOrderId(Long orderId);
    
    public List<TblOrderItem> findByProductId(Long productId);
    
    public void deleteByOrderId(Long orderId);
    
    public Double getTotalAmountByOrderId(Long orderId);
    
    public List<Object> findRaw(String hql);
} 