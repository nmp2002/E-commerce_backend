package com.ttisv.service;

import com.ttisv.bean.User;

public interface UserSerivce {
	
	User findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	void saveOrUpdate(User o);
}
