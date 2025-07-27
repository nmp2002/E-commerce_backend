package com.ttisv.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttisv.bean.User;
import com.ttisv.dao.UserDao;
import com.ttisv.service.UserSerivce;

@Service
@Transactional
public class UserSerivceImpl implements UserSerivce {
	
	@Autowired
	UserDao userDao;

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}

	@Override
	public Boolean existsByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.existsByUsername(username);
	}

	@Override
	public Boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.existsByEmail(email);
	}

	@Override
	public void saveOrUpdate(User o) {
		// TODO Auto-generated method stub
		userDao.saveOrUpdate(o);
	}

}
