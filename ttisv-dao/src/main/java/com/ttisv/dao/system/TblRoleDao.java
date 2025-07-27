package com.ttisv.dao.system;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ttisv.bean.system.TblRole;
import com.ttisv.dao.BaseDao;

public interface TblRoleDao extends BaseDao<TblRole> {

	public Page<TblRole> getListPageRole(Pageable pageable, Map<String, String> map);

	public List<TblRole> getListRole(Map<String, String> map);

	public Boolean existsByRoleCode(String roleCode, Long ignoreId);

	TblRole findById(Long roleId);
	
}
