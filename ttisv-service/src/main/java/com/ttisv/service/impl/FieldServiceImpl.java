package com.ttisv.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttisv.service.FieldService;
import com.ttisv.dao.FieldDao;
import com.ttisv.bean.Field;
@Service
@Transactional
public class FieldServiceImpl implements FieldService{
	
	@Autowired
	FieldDao fieldDao;
	
	@Override
	public Field findByFieldName(String fieldName) {
		// TODO Auto-generated method stub
		return fieldDao.findByFieldName(fieldName);
	}

	@Override
	public Field findById(Integer id) {
		// TODO Auto-generated method stub
		return fieldDao.findById(id);
	}

	@Override
	public Field addField(Field field) {
		// TODO Auto-generated method stub
		 return fieldDao.addField(field);
	}

	@Override
	public Field updateField(Field field) {
		// TODO Auto-generated method stub
		return fieldDao.updateField(field);
	}

}
