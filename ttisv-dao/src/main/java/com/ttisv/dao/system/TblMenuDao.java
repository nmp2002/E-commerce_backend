package com.ttisv.dao.system;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ttisv.bean.system.TblMenu;
import com.ttisv.dao.BaseDao;

public interface TblMenuDao extends BaseDao<TblMenu> {

	public Page<TblMenu> getListPageMenu(Pageable pageable, Map<String, String> map);

	public List<TblMenu> getListMenu(Map<String, String> map);

	public List<TblMenu> getListMenuByRole(Map<String, String> map);

	public Boolean existsByMenuCode(String menuCode, Long ignoreId);

	List<TblMenu> getListMenuObjectId(Long groupRoleId, Long roleId);

	TblMenu findById(Long menuId);

	Boolean updateStatusHaveButton(Long menuId, String status);

	Boolean checkHaveButton(Long menuId, Long ignoreBtnId);
}
