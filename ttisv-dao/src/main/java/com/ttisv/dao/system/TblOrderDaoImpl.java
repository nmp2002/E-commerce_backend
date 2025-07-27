package com.ttisv.dao.system;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ttisv.bean.system.TblOrder;
import com.ttisv.dao.impl.BaseDaoImpl;

@Repository("tblOrderDao")
public class TblOrderDaoImpl extends BaseDaoImpl<TblOrder> implements TblOrderDao {

    @Override
    public TblOrder saveOrUpdate(TblOrder order) {
        return super.saveOrUpdate(order);
    }

    @Override
    public List<TblOrder> findByUserId(Long userId) {
        String hql = "from TblOrder where userId = :userId order by orderDate desc";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        return find(hql, params);
    }

    @Override
    public List<TblOrder> findByStatus(Long status) {
        String hql = "from TblOrder where status = :status order by orderDate desc";
        Map<String, Object> params = new HashMap<>();
        params.put("status", status);
        return find(hql, params);
    }

    @Override
    public List<TblOrder> findByUserIdAndStatus(Long userId, Long status) {
        String hql = "from TblOrder where userId = :userId and status = :status order by orderDate desc";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("status", status);
        return find(hql, params);
    }

    @Override
    public List<TblOrder> findOrdersByDateRange(Date startDate, Date endDate) {
        String hql = "from TblOrder where orderDate between :startDate and :endDate order by orderDate desc";
        Map<String, Object> params = new HashMap<>();
        params.put("startDate", startDate);
        params.put("endDate", endDate);
        return find(hql, params);
    }
} 