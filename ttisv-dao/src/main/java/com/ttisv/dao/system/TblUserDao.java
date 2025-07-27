package com.ttisv.dao.system;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ttisv.bean.system.TblUser;
import com.ttisv.dao.BaseDao;

public interface TblUserDao extends BaseDao<TblUser> {

	public Page<TblUser> getListPageUser(Pageable pageable, Map<String, String> map);

	TblUser findByUserName(String username);

	TblUser getFullByUserName(String username);

	TblUser findById(Long id);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email, Long ignoreId);

	void resetLoginTimes(String username);
	 int countActiveUsers();
	 int countInactiveUsers();
}
