package com.ttisv.dao.system;


import java.util.List;
import java.util.Map;

import com.ttisv.bean.system.TblSupplier;
import com.ttisv.dao.BaseDao;

public interface TblSupplierDao extends BaseDao<TblSupplier>{
	  public List<TblSupplier> getListSupplier(Map<String, String> map);
	  TblSupplier findByUserId(Long userId);
	  TblSupplier saveorUpdate(Long supplierId, String supplierName,String supplierNameLogin);
	  TblSupplier saveFieldId(Long supplierId,String fieldId);
	  TblSupplier findBySupplierNameLogin(String supplierNameLogin);
	  List<TblSupplier> getSuppliersByFieldId(Long fieldId);
}
