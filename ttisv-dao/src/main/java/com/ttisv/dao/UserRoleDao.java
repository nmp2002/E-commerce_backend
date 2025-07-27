package com.ttisv.dao;

import java.util.List;
import com.ttisv.bean.UserRole;

public interface UserRoleDao extends BaseDao<UserRole> {
    List<UserRole> findByUserId(Long userId);
    List<UserRole> findByRoleId(Long roleId);
    UserRole findByUserIdAndRoleId(Long userId, Long roleId);
    void deleteByUserId(Long userId);
    void deleteByRoleId(Long roleId);
}
