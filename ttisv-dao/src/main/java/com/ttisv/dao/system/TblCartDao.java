package com.ttisv.dao.system;

import com.ttisv.bean.system.TblCart;
import com.ttisv.dao.BaseDao;

import java.util.List;

public interface TblCartDao extends BaseDao<TblCart> {
    TblCart findByUserId(Long userId);
    TblCart saveOrUpdateCart(TblCart cart);
    List<TblCart> findAll();
} 