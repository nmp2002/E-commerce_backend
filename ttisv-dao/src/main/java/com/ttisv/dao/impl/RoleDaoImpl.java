package com.ttisv.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ttisv.bean.Role;
import com.ttisv.dao.RoleDao;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@Override
	public Role findByName(String name) {
		String hql = "FROM Role r WHERE r.name = :name AND r.isActive = true";
		Map<String, Object> params = new HashMap<>();
		params.put("name", name);
		List<Role> roles = find(hql, params);
		return roles.isEmpty() ? null : roles.get(0);
	}
}
