package com.ttisv.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.ttisv.bean.UserRole;
import com.ttisv.dao.UserRoleDao;

@Repository
public class UserRoleDaoImpl extends BaseDaoImpl<UserRole> implements UserRoleDao {
    
    @Override
    public List<UserRole> findByUserId(Long userId) {
        String hql = "FROM UserRole ur WHERE ur.userId = :userId AND ur.isActive = true";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        return find(hql, params);
    }
    
    @Override
    public List<UserRole> findByRoleId(Long roleId) {
        String hql = "FROM UserRole ur WHERE ur.roleId = :roleId AND ur.isActive = true";
        Map<String, Object> params = new HashMap<>();
        params.put("roleId", roleId);
        return find(hql, params);
    }
    
    @Override
    public UserRole findByUserIdAndRoleId(Long userId, Long roleId) {
        String hql = "FROM UserRole ur WHERE ur.userId = :userId AND ur.roleId = :roleId AND ur.isActive = true";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("roleId", roleId);
        List<UserRole> userRoles = find(hql, params);
        return userRoles.isEmpty() ? null : userRoles.get(0);
    }
    
    @Override
    public void deleteByUserId(Long userId) {
        String hql = "UPDATE UserRole ur SET ur.isActive = false WHERE ur.userId = :userId";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        executeHql(hql, params);
    }
    
    @Override
    public void deleteByRoleId(Long roleId) {
        String hql = "UPDATE UserRole ur SET ur.isActive = false WHERE ur.roleId = :roleId";
        Map<String, Object> params = new HashMap<>();
        params.put("roleId", roleId);
        executeHql(hql, params);
    }
}
