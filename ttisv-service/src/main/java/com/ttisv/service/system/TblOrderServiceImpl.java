package com.ttisv.service.system;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttisv.bean.system.TblOrder;
import com.ttisv.dao.system.TblOrderDao;
import com.ttisv.service.system.TblOrderService;

@Service
@Transactional
public class TblOrderServiceImpl implements TblOrderService {

    @Autowired
    private TblOrderDao orderDao;

    @Override
    public Serializable save(TblOrder order) {
        return orderDao.save(order);
    }

    @Override
    public void delete(Serializable id) {
        orderDao.delete(id);
    }

    @Override
    public void update(TblOrder order) {
        orderDao.update(order);
    }

    @Override
    public TblOrder get(Serializable id) {
        return orderDao.get(id);
    }

    @Override
    public List<TblOrder> find(String hql) {
        return orderDao.find(hql);
    }

    @Override
    public List<TblOrder> find(String hql, Map<String, Object> params) {
        return orderDao.find(hql, params);
    }

    @Override
    public List<TblOrder> find(String hql, int page, int rows) {
        return orderDao.find(hql, page, rows);
    }

    @Override
    public List<TblOrder> find(String hql, Map<String, Object> params, int page, int rows) {
        return orderDao.find(hql, params, page, rows);
    }

    @Override
    public Integer count(String hql) {
        return orderDao.count(hql);
    }

    @Override
    public Integer count(String hql, Map<String, Object> params) {
        return orderDao.count(hql, params);
    }

    @Override
    public List<TblOrder> findByUserId(Long userId) {
        return orderDao.findByUserId(userId);
    }

    @Override
    public List<TblOrder> findByStatus(Long status) {
        return orderDao.findByStatus(status);
    }

    @Override
    public List<TblOrder> findByUserIdAndStatus(Long userId, Long status) {
        return orderDao.findByUserIdAndStatus(userId, status);
    }

    @Override
    public List<TblOrder> findOrdersByDateRange(Date startDate, Date endDate) {
        return orderDao.findOrdersByDateRange(startDate, endDate);
    }

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

    @Override
    public TblOrder updateOrderStatus(Long orderId, Long status) {
        TblOrder order = orderDao.get(orderId);
        if (order != null) {
            order.setStatus(status);
            order.setModifiedDate(new Date());
            orderDao.update(order);
        }
        return order;
    }

    @Override
    public void cancelOrder(Long orderId) {
        TblOrder order = orderDao.get(orderId);
        if (order != null) {
            order.setStatus(4L); // Hủy
            order.setModifiedDate(new Date());
            orderDao.update(order);
        }
    }
} 