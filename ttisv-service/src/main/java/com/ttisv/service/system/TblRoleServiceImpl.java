package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ttisv.bean.system.TblRole;
import com.ttisv.dao.system.TblRoleDao;

@Service
@Transactional
public class TblRoleServiceImpl implements TblRoleService {

	@Autowired
	TblRoleDao tblRoleDao;

	@Override
	public Page<TblRole> getListPageRole(Pageable pageable, Map<String, String> map) {
		// TODO Auto-generated method stub
		return tblRoleDao.getListPageRole(pageable, map);
	}

	@Override
	public List<TblRole> getListRole(Map<String, String> map) {
		// TODO Auto-generated method stub
		return tblRoleDao.getListRole(map);
	}

	@Override
	public TblRole saveorUpdate(TblRole role) {
		// TODO Auto-generated method stub
		tblRoleDao.saveOrUpdate(role);
		return role;
	}

	@Override
	public Boolean existsByRoleCode(String roleCode, Long ignoreId) {
		return tblRoleDao.existsByRoleCode(roleCode, ignoreId);
	}

	@Override
	public TblRole findById(Long roleId) {
		// TODO Auto-generated method stub
		return tblRoleDao.findById(roleId);
	}

}
