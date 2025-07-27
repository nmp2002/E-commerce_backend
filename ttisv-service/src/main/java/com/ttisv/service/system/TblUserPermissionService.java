package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import com.ttisv.bean.system.TblUserPermission;

public interface TblUserPermissionService {

	void saveorUpdate(TblUserPermission userPermission);

	List<TblUserPermission> getListUserPermission(Long userId);

	Map<String, String> getAllOfficeOfPermissionUser(Long userId, String officecode);

	Boolean deleteUserPermission(Long userId);

}
