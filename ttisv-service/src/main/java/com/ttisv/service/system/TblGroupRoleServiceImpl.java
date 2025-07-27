package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ttisv.bean.system.TblGroupRole;
import com.ttisv.dao.system.TblGroupRoleDao;

@Service
@Transactional
public class TblGroupRoleServiceImpl implements TblGroupRoleService {

	@Autowired
	TblGroupRoleDao tblGroupRoleDao;

	@Override
	public Page<TblGroupRole> getListPageGroupRole(Pageable pageable, Map<String, String> map) {
		// TODO Auto-generated method stub
		return tblGroupRoleDao.getListPageGroupRole(pageable, map);
	}

	@Override
	public List<TblGroupRole> getListGroupRole(Map<String, String> map) {
		// TODO Auto-generated method stub
		return tblGroupRoleDao.getListGroupRole(map);
	}

	@Override
	public TblGroupRole saveorUpdate(TblGroupRole groupRole) {
		// TODO Auto-generated method stub
		tblGroupRoleDao.saveOrUpdate(groupRole);
		return groupRole;
	}

	@Override
	public Boolean existsByGroupRoleCode(String groupRoleCode, Long ignoreId) {
		return tblGroupRoleDao.existsByGroupRoleCode(groupRoleCode, ignoreId);
	}

	@Override
	public TblGroupRole findById(Long groupRoleId) {
		// TODO Auto-generated method stub
		return tblGroupRoleDao.findById(groupRoleId);
	}

}
