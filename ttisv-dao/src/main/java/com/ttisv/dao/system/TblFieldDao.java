package com.ttisv.dao.system;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ttisv.bean.system.TblField;
import com.ttisv.dao.BaseDao;

public interface TblFieldDao extends BaseDao<TblField> {
	public Page<TblField> getListPageField(Pageable pageable, Map<String, String> map);
	TblField findByFieldName(String fieldName);
	TblField findById(Long id);
	Boolean existsByFieldName(String fieldName);
	List<TblField> findbySupplierId(Long supplierId);
	public boolean existsById(Long id);
	long countActiveFields();
	long countInactiveFields();
	Long countActiveSmallFields(Long fieldId);
	Long countMaintenanceSmallFields(Long fieldId);
	TblField saveorUpdate(TblField field);
}
