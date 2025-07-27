package com.ttisv.service.system;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttisv.bean.system.TblSmallField;
import com.ttisv.common.utils.TtisvConstant;
import com.ttisv.dao.system.TblSmallFieldDao;


@Service
@Transactional
public class TblSmallFieldServiceImpl implements TblSmallFieldService{
	 	@Autowired
	    private TblSmallFieldDao smallFieldDao;

	 	@Override
	    public TblSmallField createSmallField(Long fieldId, String smallFieldName, Long fieldTypeId,String fieldType) {
	        return smallFieldDao.createSmallField(fieldId, smallFieldName, fieldTypeId,fieldType);
	    }

		@Override
		public List<TblSmallField> getSmallFieldsByFieldId(Long fieldId) {
		
			return smallFieldDao.getSmallFieldsByFieldId(fieldId);
		}

		@Override
		public List<TblSmallField> getSmallFieldsByFieldTypeId(Long fieldId, Long fieldTypeId) {
			// TODO Auto-generated method stub
			return smallFieldDao.getSmallFieldsByFieldTypeId(fieldId, fieldTypeId);
		}

		@Override
		public TblSmallField updateStatusSmallField(Long id, Long active) {
		try {
			TblSmallField smallField = smallFieldDao.findSmallFieldById(id);
			smallField.setStatus(active);
			smallField.setModifiedDate(new Date());
			smallFieldDao.saveOrUpdate(smallField);
			return smallField;
		}  catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
		}

		@Override
		public TblSmallField findSmallFieldById(Long id) {
			
			return smallFieldDao.findSmallFieldById(id);
		}
}
