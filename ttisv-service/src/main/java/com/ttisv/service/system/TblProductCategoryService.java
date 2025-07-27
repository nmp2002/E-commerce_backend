package com.ttisv.service.system;

import java.util.List;

import com.ttisv.bean.system.TblProductCategory;

public interface TblProductCategoryService {
    TblProductCategory save(TblProductCategory category);
    TblProductCategory updates(TblProductCategory category);
    boolean delete(Long id);

    TblProductCategory findById(Long id);

    List<TblProductCategory> findAll();

    List<TblProductCategory> findByName(String name);
}
