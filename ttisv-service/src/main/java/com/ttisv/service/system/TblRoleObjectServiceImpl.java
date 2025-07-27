package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttisv.bean.system.TblMenu;
import com.ttisv.bean.system.TblRoleObject;
import com.ttisv.dao.system.TblRoleObjectDao;

@Service
@Transactional
public class TblRoleObjectServiceImpl implements TblRoleObjectService {

	@Autowired
	TblRoleObjectDao tblRoleObjectDao;

	@Override
	public List<TblRoleObject> getListRoleObject(Map<String, String> map) {
		// TODO Auto-generated method stub
		return tblRoleObjectDao.getListRoleObject(map);
	}
	
	@Override
	public List<TblMenu> getListMenuByRoleObject(Map<String, String> map) {
		return tblRoleObjectDao.getListMenuByRoleObject(map);
	}

	@Override
	public TblRoleObject saveorUpdate(TblRoleObject roleObject) {
		// TODO Auto-generated method stub
		tblRoleObjectDao.saveOrUpdate(roleObject);
		return roleObject;
	}

	@Override
	public TblRoleObject findById(Long roleObjectId) {
		// TODO Auto-generated method stub
		return tblRoleObjectDao.findById(roleObjectId);
	}

	@Override
	public boolean deleteRoleObject(Long groupRoleId, Long roleId) {
		// TODO Auto-generated method stub
		return tblRoleObjectDao.deleteRoleObject(groupRoleId, roleId);
	}

	@Override
	public void saveBatch(List<TblRoleObject> list) {
		// TODO Auto-generated method stub
		tblRoleObjectDao.saveBatch(list);
	}
}
