package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ttisv.bean.system.TblMenu;
import com.ttisv.dao.system.TblMenuDao;

@Service
@Transactional
public class TblMenuServiceImpl implements TblMenuService {

	@Autowired
	TblMenuDao tblMenuDao;

	@Override
	public Page<TblMenu> getListPageMenu(Pageable pageable, Map<String, String> map) {
		// TODO Auto-generated method stub
		return tblMenuDao.getListPageMenu(pageable, map);
	}

	@Override
	public List<TblMenu> getListMenu(Map<String, String> map) {
		// TODO Auto-generated method stub
		return tblMenuDao.getListMenu(map);
	}

	@Override
	public TblMenu saveorUpdate(TblMenu menu) {
		// TODO Auto-generated method stub
		tblMenuDao.saveOrUpdate(menu);
		return menu;
	}

	@Override
	public Boolean existsByMenuCode(String menuCode, Long ignoreId) {
		return tblMenuDao.existsByMenuCode(menuCode, ignoreId);
	}

	@Override
	public TblMenu findById(Long menuId) {
		// TODO Auto-generated method stub
		return tblMenuDao.findById(menuId);
	}

	@Override
	public List<TblMenu> getListMenuObjectId(Long groupRoleId, Long roleId) {
		return tblMenuDao.getListMenuObjectId(groupRoleId, roleId);
	}

	@Override
	public Boolean updateStatusHaveButton(Long menuId, String status) {
		return tblMenuDao.updateStatusHaveButton(menuId, status);
	}

	@Override
	public Boolean checkHaveButton(Long menuId, Long ignoreBtnId) {
		// TODO Auto-generated method stub
		return tblMenuDao.checkHaveButton(menuId, ignoreBtnId);
	}

	@Override
	public List<TblMenu> getListMenuByRole(Map<String, String> map) {
		// TODO Auto-generated method stub
		return tblMenuDao.getListMenuByRole(map);
	}
}
