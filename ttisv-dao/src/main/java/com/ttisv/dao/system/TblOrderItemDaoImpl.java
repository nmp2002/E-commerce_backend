package com.ttisv.dao.system;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ttisv.bean.system.TblOrderItem;
import com.ttisv.dao.impl.BaseDaoImpl;

@Repository("tblOrderItemDao")
public class TblOrderItemDaoImpl extends BaseDaoImpl<TblOrderItem> implements TblOrderItemDao {

    @Override
    public List<TblOrderItem> findByOrderId(Long orderId) {
        String hql = "from TblOrderItem where orderId = :orderId";
        Map<String, Object> params = new HashMap<>();
        params.put("orderId", orderId);
        return find(hql, params);
    }

    @Override
    public List<TblOrderItem> findByProductId(Long productId) {
        String hql = "from TblOrderItem where productId = :productId";
        Map<String, Object> params = new HashMap<>();
        params.put("productId", productId);
        return find(hql, params);
    }

    @Override
    public void deleteByOrderId(Long orderId) {
        String hql = "delete from TblOrderItem where orderId = :orderId";
        Map<String, Object> params = new HashMap<>();
        params.put("orderId", orderId);
        executeHql(hql, params);
    }

    @Override
    public Double getTotalAmountByOrderId(Long orderId) {
        String hql = "select sum(price * quantity) from TblOrderItem where orderId = :orderId";
        Map<String, Object> params = new HashMap<>();
        params.put("orderId", orderId);
        List<Object> result = find(hql, params);
        if (result != null && !result.isEmpty() && result.get(0) != null) {
            return (Double) result.get(0);
        }
        return 0.0;
    }

    @Override
    public List<Object> findRaw(String hql) {
        return getSession().createQuery(hql).list();
    }
} 