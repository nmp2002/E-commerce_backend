package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ttisv.bean.system.TblMenuBtn;
import com.ttisv.dao.system.TblMenuBtnDao;

@Service
@Transactional
public class TblMenuBtnServiceImpl implements TblMenuBtnService {

	@Autowired
	TblMenuBtnDao tblMenuBtnDao;

	@Override
	public Page<TblMenuBtn> getListPageMenuBtn(Pageable pageable, Map<String, String> map) {
		// TODO Auto-generated method stub
		return tblMenuBtnDao.getListPageMenuBtn(pageable, map);
	}

	@Override
	public List<TblMenuBtn> getListMenuBtn(Map<String, String> map) {
		// TODO Auto-generated method stub
		return tblMenuBtnDao.getListMenuBtn(map);
	}

	@Override
	public TblMenuBtn saveorUpdate(TblMenuBtn menuBtn) {
		// TODO Auto-generated method stub
		tblMenuBtnDao.saveOrUpdate(menuBtn);
		return menuBtn;
	}

	@Override
	public Boolean existsByMenuBtnCode(String menuBtnCode, Long menuId, Long ignoreId) {
		return tblMenuBtnDao.existsByMenuBtnCode(menuBtnCode, menuId, ignoreId);
	}

	@Override
	public TblMenuBtn findById(Long menuBtnId) {
		// TODO Auto-generated method stub
		return tblMenuBtnDao.findById(menuBtnId);
	}

}
