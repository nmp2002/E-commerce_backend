package com.ttisv.dao.system;

import com.ttisv.bean.system.TblProductAttribute;
import com.ttisv.dao.BaseDao;
import java.util.List;

public interface TblProductAttributeDao extends BaseDao<TblProductAttribute> {
    List<TblProductAttribute> findByProductId(Long productId);
    TblProductAttribute updates(TblProductAttribute attribute);
    boolean delete(Long id);
    TblProductAttribute findById(Long id);
    List<TblProductAttribute> findAll();
}
