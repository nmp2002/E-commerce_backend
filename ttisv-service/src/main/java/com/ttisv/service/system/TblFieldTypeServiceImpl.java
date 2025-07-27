package com.ttisv.service.system;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttisv.bean.system.TblFieldType;
import com.ttisv.dao.system.TblFieldTypeDao;

@Service
@Transactional
public class TblFieldTypeServiceImpl implements TblFieldTypeService{
	@Autowired
	TblFieldTypeDao tblFieldTypeDao;
	@Override
	public TblFieldType saveorUpdate(Long fieldId, String fieldTypeName, Long totalNumberField) {
		// TODO Auto-generated method stub
		return tblFieldTypeDao.saveorUpdate(fieldId,fieldTypeName,totalNumberField);
	}
	@Override
	public List<TblFieldType> findbyFieldId(Long fieldId) {
		// TODO Auto-generated method stub
		return tblFieldTypeDao.findbyFieldId(fieldId);
	}
	@Override
	public TblFieldType findByFieldIdAndTypeName(Long fieldId,String fieldTypeName) {
		// TODO Auto-generated method stub
		return tblFieldTypeDao.findByFieldIdAndTypeName(fieldId,fieldTypeName);
	}

}
