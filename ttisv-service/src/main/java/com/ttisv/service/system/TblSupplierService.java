package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import com.ttisv.bean.system.TblSupplier;

public interface TblSupplierService {
	TblSupplier saveorUpdate(Long supplierId, String fieldName,String supplierNameLogin);
	public List<TblSupplier> getListSupplier(Map<String, String> map);
	TblSupplier findByUserId(Long userId);
	TblSupplier saveFieldId(Long supplierId, String fieldId);
	TblSupplier findBySupplierNameLogin(String supplierNameLogin);
	List<TblSupplier> getSuppliersByFieldId(Long fieldId);
}



