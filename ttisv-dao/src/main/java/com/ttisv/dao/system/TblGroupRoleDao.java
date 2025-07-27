package com.ttisv.dao.system;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ttisv.bean.system.TblGroupRole;
import com.ttisv.dao.BaseDao;

public interface TblGroupRoleDao extends BaseDao<TblGroupRole> {

	public Page<TblGroupRole> getListPageGroupRole(Pageable pageable, Map<String, String> map);

	public List<TblGroupRole> getListGroupRole(Map<String, String> map);

	public Boolean existsByGroupRoleCode(String groupRoleCode, Long ignoreId);
	
	TblGroupRole findById(Long groupRoleId);
}
