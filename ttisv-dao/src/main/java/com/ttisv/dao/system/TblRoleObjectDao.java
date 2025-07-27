package com.ttisv.dao.system;

import java.util.List;
import java.util.Map;

import com.ttisv.bean.system.TblMenu;
import com.ttisv.bean.system.TblRoleObject;
import com.ttisv.dao.BaseDao;

public interface TblRoleObjectDao extends BaseDao<TblRoleObject> {

	public List<TblRoleObject> getListRoleObject(Map<String, String> map);

	public List<TblMenu> getListMenuByRoleObject(Map<String, String> map);

	TblRoleObject findById(Long roleObjectId);

	boolean deleteRoleObject(Long groupRoleId, Long roleId);
}
