package com.ttisv.service.system;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ttisv.bean.system.TblSupplier;
import com.ttisv.bean.system.TblUser;
import com.ttisv.bean.system.TblUserPermission;
import com.ttisv.common.utils.TtisvConstant;
import com.ttisv.dao.system.TblSupplierDao;
import com.ttisv.dao.system.TblUserDao;
import com.ttisv.dao.system.TblUserPermissionDao;

@Service
@Transactional
public class TblUserServiceImpl implements TblUserService {

	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	@Autowired
	private TblSupplierDao tblSupplierDao;
	@Autowired
	TblUserDao tblUserDao;

	@Autowired
	TblUserPermissionDao tblUserPermissionDao;

	@Autowired
	TblUserPermissionService tblUserPermissionService;

	@Override
	public Page<TblUser> getListPageUser(Pageable pageable, Map<String, String> map) {
		// TODO Auto-generated method stub
		return tblUserDao.getListPageUser(pageable, map);
	}

	@Override
	public TblUser saveorUpdate(TblUser user) {
		// TODO Auto-generated method stub
		tblUserDao.saveOrUpdate(user);
		return user;
	}

	@Override
	public TblUser createUser(TblUser user, List<TblUserPermission> lstPermission) {
		// TODO Auto-generated method stub
		try {
			user.setCountLogin(TtisvConstant.ZERO);
			user.setIsResetPass("N");
			user.setCreatedDate(new Date());
			tblUserDao.saveOrUpdate(user);
			if (user != null) {
			
                
				if (lstPermission != null && !lstPermission.isEmpty()) {
					for (TblUserPermission userPermiss : lstPermission) {
						userPermiss.setUserId(user.getId());
						userPermiss.setUserName(user.getUserName());
						userPermiss.setCreatedDate(new Date());
						userPermiss.setActive(TtisvConstant.STATUS.ACTIVE);
						if (Objects.equals(userPermiss.getOfficetype(), TtisvConstant.ALL)) {
							userPermiss.setOfficetype(null);
							userPermiss.setOfficecode(null);
							userPermiss.setOfficename(null);
						}
					}
					tblUserPermissionDao.saveBatch(lstPermission);
				}
			}
			return user;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public TblUser updateUser(TblUser user, List<TblUserPermission> lstPermission) {
		// TODO Auto-generated method stub
		try {
			user.setModifiedDate(new Date());
			user.setCountLogin(TtisvConstant.ZERO);
			tblUserDao.saveOrUpdate(user);
			if (user != null) {
				Boolean isDelPermission = tblUserPermissionDao.deleteUserPermission(user.getId());
				if (isDelPermission) {
					if (lstPermission != null && !lstPermission.isEmpty()) {
						for (TblUserPermission userPermiss : lstPermission) {
							userPermiss.setUserId(user.getId());
							userPermiss.setUserName(user.getUserName());
							userPermiss.setCreatedDate(new Date());
							userPermiss.setActive(TtisvConstant.STATUS.ACTIVE);
							if (Objects.equals(userPermiss.getOfficetype(), TtisvConstant.ALL)) {
								userPermiss.setOfficetype(null);
								userPermiss.setOfficecode(null);
								userPermiss.setOfficename(null);
							}
						}
						tblUserPermissionDao.saveBatch(lstPermission);
					}
	                }
				}
			
			return user;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public TblUser updateStatusUser(String username, String active, String modifiedby) {
		// TODO Auto-generated method stub
		try {
			TblUser user = tblUserDao.findByUserName(username);
			user.setStatus(active);
			user.setModifiedby(modifiedby);
			user.setModifiedDate(new Date());
			user.setCountLogin(Long.valueOf(TtisvConstant.ZERO));
			tblUserDao.saveOrUpdate(user);
			if (user != null) {
				tblUserPermissionDao.updateUserPermission(user.getId(),
						Objects.equals(active, TtisvConstant.STATUS.ACTIVE) ? active : TtisvConstant.STATUS.INACTIVE);
			}
			return user;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public TblUser findByUserName(String username) {
		// TODO Auto-generated method stub
		return tblUserDao.findByUserName(username);
	}

	@Override
	public TblUser getFullByUserName(String username, boolean isGetMapRole) {
		// TODO Auto-generated method stub
		TblUser user = tblUserDao.getFullByUserName(username);
		if (user != null && user.getOfficecode() != null && !user.getOfficecode().isEmpty()) {
			// Lay ngan chan quyen
			if (isGetMapRole) {
				Map<String, String> mapRuleData = tblUserPermissionService.getAllOfficeOfPermissionUser(user.getId(),
						user.getOfficecode());
				if (mapRuleData != null && !mapRuleData.isEmpty()) {
					user.setMapRuleData(gson.toJson(mapRuleData));
				}
			}
		}
		return user;
	}

	@Override
	public TblUser findById(Long id) {
		// TODO Auto-generated method stub
		TblUser user = tblUserDao.findById(id);
		if (user != null) {
			List<TblUserPermission> lstPermission = tblUserPermissionDao.getListUserPermission(id);
			user.setLstPermission(lstPermission != null && !lstPermission.isEmpty() ? lstPermission : null);
		}
		return user;
	}

	@Override
	public Boolean existsByUsername(String username) {
		// TODO Auto-generated method stub
		return tblUserDao.existsByUsername(username);
	}

	@Override
	public Boolean existsByEmail(String email, Long ignoreId) {
		// TODO Auto-generated method stub
		return tblUserDao.existsByEmail(email, ignoreId);
	}

	@Override
	public void resetLoginTimes(String username) {
		// TODO Auto-generated method stub
		tblUserDao.resetLoginTimes(username);
	}

	@Override
	public int countActiveUsers() {
		// TODO Auto-generated method stub
		return tblUserDao.countActiveUsers();
	}

	@Override
	public int countInactiveUsers() {
		// TODO Auto-generated method stub
		return tblUserDao.countInactiveUsers();
	}
}
