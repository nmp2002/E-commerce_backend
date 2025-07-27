package com.ttisv.service.system;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttisv.bean.system.TblProductCategory;
import com.ttisv.dao.system.TblProductCategoryDao;

@Service
@Transactional
public class TblProductCategoryServiceImpl implements TblProductCategoryService {
	@Autowired
	TblProductCategoryDao tblProductCategoryDao;

	@Override
	public TblProductCategory save(TblProductCategory category) {
		// TODO Auto-generated method stub
		return tblProductCategoryDao.save(category);
	}

	@Override
	public TblProductCategory updates(TblProductCategory category) {
		// TODO Auto-generated method stub
		return tblProductCategoryDao.updates(category);
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return tblProductCategoryDao.delete(id);
	}

	@Override
	public TblProductCategory findById(Long id) {
		// TODO Auto-generated method stub
		return tblProductCategoryDao.findById(id);
	}

	@Override
	public List<TblProductCategory> findAll() {
		// TODO Auto-generated method stub
		return tblProductCategoryDao.findAll();
	}

	@Override
	public List<TblProductCategory> findByName(String name) {
		// TODO Auto-generated method stub
		return tblProductCategoryDao.findByName(name);
	}
}
