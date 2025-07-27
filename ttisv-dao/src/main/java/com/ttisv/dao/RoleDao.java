package com.ttisv.dao;

import com.ttisv.bean.Role;

public interface RoleDao extends BaseDao<Role> {
	Role findByName(String name);
}
