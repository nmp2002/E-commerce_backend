package com.ttisv.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttisv.bean.Role;
import com.ttisv.dao.RoleDao;
import com.ttisv.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl  implements RoleService{
	@Autowired
	RoleDao roleDao;
	@Override
	public Role findByName(String name) {
		// TODO Auto-generated method stub
		return roleDao.findByName(name);
	}

}
