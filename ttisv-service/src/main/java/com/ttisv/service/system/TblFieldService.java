package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ttisv.bean.system.TblField;

public interface TblFieldService {
	Page<TblField> getListPageField(Pageable pageable, Map<String, String> map);
	TblField findByFieldName(String fieldName);
	TblField findById(Long id);
	Boolean existsByFieldName(String fieldName);
	TblField  saveorUpdate(TblField field);
	List<TblField> findbySupplierId(Long supplierId);
	 boolean existsById(Long fieldId);
	 TblField updateStatusField(Long id, Long status);
		long countActiveFields();
		long countInactiveFields();
		Long countActiveSmallFields(Long fieldId);
		Long countMaintenanceSmallFields(Long fieldId);
}
