package com.ttisv.service.system;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttisv.bean.system.TblOrderItem;
import com.ttisv.dao.system.TblOrderItemDao;
import com.ttisv.service.system.TblOrderItemService;

@Service
@Transactional
public class TblOrderItemServiceImpl implements TblOrderItemService {

    @Autowired
    private TblOrderItemDao orderItemDao;

    @Override
    public Serializable save(TblOrderItem orderItem) {
        return orderItemDao.save(orderItem);
    }

    @Override
    public void delete(Serializable id) {
        orderItemDao.delete(id);
    }

    @Override
    public void update(TblOrderItem orderItem) {
        orderItemDao.update(orderItem);
    }

    @Override
    public TblOrderItem get(Serializable id) {
        return orderItemDao.get(id);
    }

    @Override
    public List<TblOrderItem> find(String hql) {
        return orderItemDao.find(hql);
    }

    @Override
    public List<TblOrderItem> find(String hql, Map<String, Object> params) {
        return orderItemDao.find(hql, params);
    }

    @Override
    public List<TblOrderItem> find(String hql, int page, int rows) {
        return orderItemDao.find(hql, page, rows);
    }

    @Override
    public List<TblOrderItem> find(String hql, Map<String, Object> params, int page, int rows) {
        return orderItemDao.find(hql, params, page, rows);
    }

    @Override
    public Integer count(String hql) {
        return orderItemDao.count(hql);
    }

    @Override
    public Integer count(String hql, Map<String, Object> params) {
        return orderItemDao.count(hql, params);
    }

    @Override
    public List<TblOrderItem> findByOrderId(Long orderId) {
        return orderItemDao.findByOrderId(orderId);
    }

    @Override
    public List<TblOrderItem> findByProductId(Long productId) {
        return orderItemDao.findByProductId(productId);
    }

    @Override
    public void deleteByOrderId(Long orderId) {
        orderItemDao.deleteByOrderId(orderId);
    }

    @Override
    public Double getTotalAmountByOrderId(Long orderId) {
        return orderItemDao.getTotalAmountByOrderId(orderId);
    }

    @Override
    public void addOrderItem(TblOrderItem orderItem) {
        orderItem.setCreatedDate(new Date());
        orderItemDao.save(orderItem);
    }

    @Override
    public void updateOrderItemQuantity(Long orderItemId, Integer quantity) {
        TblOrderItem orderItem = orderItemDao.get(orderItemId);
        if (orderItem != null) {
            orderItem.setQuantity(quantity);
            orderItem.setModifiedDate(new Date());
            orderItemDao.update(orderItem);
        }
    }

    @Override
    public List<Object> findRaw(String hql) {
        return orderItemDao.findRaw(hql);
    }
} 