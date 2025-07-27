package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import com.ttisv.bean.system.TblMenu;
import com.ttisv.bean.system.TblRoleObject;

public interface TblRoleObjectService {

	TblRoleObject saveorUpdate(TblRoleObject roleObject);
	
	public List<TblMenu> getListMenuByRoleObject(Map<String, String> map);

	TblRoleObject findById(Long roleObjectId);

	public List<TblRoleObject> getListRoleObject(Map<String, String> map);

	boolean deleteRoleObject(Long groupRoleId, Long roleId);

	void saveBatch(List<TblRoleObject> list);
}
