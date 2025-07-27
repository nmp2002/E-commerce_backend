package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttisv.bean.system.TblSupplier;
import com.ttisv.dao.system.TblSupplierDao;

@Service
@Transactional
public class TblSupplierServiceImpl implements TblSupplierService {
	
	@Autowired
	TblSupplierDao tblSupplierDao;
	@Override
	public TblSupplier saveorUpdate(Long supplierId, String supplierName,String supplierNameLogin) {
		// TODO Auto-generated method stub
		return tblSupplierDao.saveorUpdate(supplierId, supplierName,supplierNameLogin);
	}
	  @Override
	    public TblSupplier findByUserId(Long userId) {
	        return tblSupplierDao.findByUserId(userId);
	    }
	@Override
	public List<TblSupplier> getListSupplier(Map<String, String> map) {
		// TODO Auto-generated method stub
		return tblSupplierDao.getListSupplier(map);
	}
	
	@Override
	 public TblSupplier saveFieldId(Long supplierId, String fieldId) {
	        return tblSupplierDao.saveFieldId(supplierId, fieldId);
	    }
	@Override
	public TblSupplier findBySupplierNameLogin(String supplierNameLogin) {
		// TODO Auto-generated method stub
		return tblSupplierDao.findBySupplierNameLogin(supplierNameLogin);
	}
	@Override
	public List<TblSupplier> getSuppliersByFieldId(Long fieldId) {
		// TODO Auto-generated method stub
		return tblSupplierDao.getSuppliersByFieldId(fieldId);
	}
}
