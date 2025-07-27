package com.ttisv.dao;

import com.ttisv.bean.User;

public interface UserDao extends BaseDao<User> {
	User findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	User findByEmail(String email);

	User findByGoogleId(String googleId);
}
