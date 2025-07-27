package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ttisv.bean.system.TblMenuBtn;

public interface TblMenuBtnService {

	TblMenuBtn saveorUpdate(TblMenuBtn menuBtn);

	TblMenuBtn findById(Long menuBtnId);

	Boolean existsByMenuBtnCode(String menuBtnCode, Long menuId, Long ignoreId);

	public Page<TblMenuBtn> getListPageMenuBtn(Pageable pageable, Map<String, String> map);

	public List<TblMenuBtn> getListMenuBtn(Map<String, String> map);
}
