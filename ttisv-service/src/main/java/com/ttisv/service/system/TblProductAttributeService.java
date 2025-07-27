package com.ttisv.service.system;

import java.util.List;

import com.ttisv.bean.system.TblProductAttribute;

public interface TblProductAttributeService {
	TblProductAttribute create(TblProductAttribute attribute);
	TblProductAttribute update(Long id, TblProductAttribute attribute);
	boolean delete(Long id);
	TblProductAttribute getById(Long id);
	List<TblProductAttribute> getByProductId(Long productId);
	List<TblProductAttribute> getAll();
}
