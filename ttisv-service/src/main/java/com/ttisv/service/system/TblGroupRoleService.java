package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ttisv.bean.system.TblGroupRole;

public interface TblGroupRoleService {

	TblGroupRole saveorUpdate(TblGroupRole groupRole);

	TblGroupRole findById(Long groupRoleId);

	Boolean existsByGroupRoleCode(String groupRoleCode, Long ignoreId);

	public Page<TblGroupRole> getListPageGroupRole(Pageable pageable, Map<String, String> map);

	public List<TblGroupRole> getListGroupRole(Map<String, String> map);
}
