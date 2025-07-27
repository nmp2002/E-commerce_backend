package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ttisv.bean.system.TblSupplier;
import com.ttisv.bean.system.TblUser;
import com.ttisv.bean.system.TblUserPermission;

public interface TblUserService {

	Page<TblUser> getListPageUser(Pageable pageable, Map<String, String> map);

	TblUser saveorUpdate(TblUser user);

	TblUser createUser(TblUser user, List<TblUserPermission> lstPermission );

	TblUser updateUser(TblUser user, List<TblUserPermission> lstPermission);

	TblUser updateStatusUser(String username, String active, String modifiedby);

	TblUser findByUserName(String username);

	TblUser getFullByUserName(String username, boolean isGetMapRole);

	TblUser findById(Long id);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email, Long ignoreId);

	void resetLoginTimes(String username);
	 int countActiveUsers();
	 int countInactiveUsers();
}
