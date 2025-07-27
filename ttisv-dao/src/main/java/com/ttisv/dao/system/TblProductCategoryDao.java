package com.ttisv.dao.system;

import java.util.List;

import com.ttisv.bean.system.TblProductCategory;
import com.ttisv.dao.BaseDao;

public interface TblProductCategoryDao  extends BaseDao<TblProductCategory> {
    TblProductCategory save(TblProductCategory category);
    TblProductCategory updates(TblProductCategory category);
    boolean delete(Long id);

    TblProductCategory findById(Long id);

    List<TblProductCategory> findAll();

    List<TblProductCategory> findByName(String name);
}
