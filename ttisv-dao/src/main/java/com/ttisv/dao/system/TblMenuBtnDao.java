package com.ttisv.dao.system;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ttisv.bean.system.TblMenuBtn;
import com.ttisv.dao.BaseDao;

public interface TblMenuBtnDao extends BaseDao<TblMenuBtn> {

	public Page<TblMenuBtn> getListPageMenuBtn(Pageable pageable, Map<String, String> map);

	public List<TblMenuBtn> getListMenuBtn(Map<String, String> map);

	public Boolean existsByMenuBtnCode(String menuBtnCode, Long menuId, Long ignoreId);

	TblMenuBtn findById(Long menuBtnId);

}
