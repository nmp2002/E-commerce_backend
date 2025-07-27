package com.ttisv.dao.system;

import java.util.List;

import com.ttisv.bean.system.TblUserPermission;
import com.ttisv.dao.BaseDao;

public interface TblUserPermissionDao extends BaseDao<TblUserPermission> {

	List<TblUserPermission> getListUserPermission(Long userId);

	Boolean deleteUserPermission(Long userId);

	Boolean updateUserPermission(Long userId, String active);
	
}
