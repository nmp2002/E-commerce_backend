package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ttisv.bean.system.TblRole;

public interface TblRoleService {

	TblRole saveorUpdate(TblRole role);

	TblRole findById(Long roleId);

	Boolean existsByRoleCode(String roleCode, Long ignoreId);

	public Page<TblRole> getListPageRole(Pageable pageable, Map<String, String> map);

	public List<TblRole> getListRole(Map<String, String> map);
}
