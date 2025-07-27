package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ttisv.bean.system.TblMenu;

public interface TblMenuService {

	TblMenu saveorUpdate(TblMenu menu);

	TblMenu findById(Long menuId);

	Boolean existsByMenuCode(String menuCode, Long ignoreId);

	public Page<TblMenu> getListPageMenu(Pageable pageable, Map<String, String> map);

	public List<TblMenu> getListMenuObjectId(Long groupRoleId, Long roleId);

	public List<TblMenu> getListMenu(Map<String, String> map);

	public List<TblMenu> getListMenuByRole(Map<String, String> map);

	Boolean updateStatusHaveButton(Long menuId, String status);

	Boolean checkHaveButton(Long menuId, Long ignoreBtnId);
}
