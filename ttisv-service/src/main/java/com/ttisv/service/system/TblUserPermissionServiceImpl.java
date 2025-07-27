package com.ttisv.service.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttisv.bean.system.TblUserPermission;
import com.ttisv.common.utils.StringUtils;
import com.ttisv.common.utils.TtisvConstant;
import com.ttisv.dao.system.TblUserPermissionDao;

@Service
@Transactional
public class TblUserPermissionServiceImpl implements TblUserPermissionService {

	@Autowired
	TblUserPermissionDao tblUserPermissionDao;

	@Override
	public void saveorUpdate(TblUserPermission userPermission) {
		// TODO Auto-generated method stub
		tblUserPermissionDao.saveOrUpdate(userPermission);
	}

	@Override
	public List<TblUserPermission> getListUserPermission(Long userId) {
		// TODO Auto-generated method stub
		return tblUserPermissionDao.getListUserPermission(userId);
	}

	@Override
	public Map<String, String> getAllOfficeOfPermissionUser(Long userId, String officecode) {
		Map<String, String> map = new HashMap<>();
		try {
			boolean isAllAgentFlg = false;
			boolean isAllOfficeFlg = false;
			boolean isAllBranchFlg = false;

			List<TblUserPermission> lstPermis = this.getListUserPermission(userId);
			if (lstPermis != null && !lstPermis.isEmpty()) {
				Optional<TblUserPermission> existOfficetypeAll = lstPermis.stream()
						.filter(x -> x.getOfficetype() == null).findFirst();
				if (existOfficetypeAll.isPresent()) {
					map.put("isAll", String.valueOf(TtisvConstant.STATUS.FLG_TRUE));
					return map;
				} else {
					// check type select all
					Optional<TblUserPermission> existOfficeG = lstPermis.stream()
							.filter(x -> StringUtils.isNullOrEmpty(x.getOfficecode())
									&& Objects.equals(x.getOfficetype(), TtisvConstant.OFFICE_TYPE.AGENT.getKey()))
							.findFirst();
					if (existOfficeG.isPresent()) {
						map.put("isAllAgent", String.valueOf(TtisvConstant.STATUS.FLG_TRUE));
						isAllAgentFlg = true;
					}

					Optional<TblUserPermission> existOfficeB = lstPermis.stream()
							.filter(x -> StringUtils.isNullOrEmpty(x.getOfficecode())
									&& Objects.equals(x.getOfficetype(), TtisvConstant.OFFICE_TYPE.OFFICE.getKey()))
							.findFirst();
					if (existOfficeB.isPresent()) {
						map.put("isAllOffice", String.valueOf(TtisvConstant.STATUS.FLG_TRUE));
						isAllOfficeFlg = true;
					}

					Optional<TblUserPermission> existOfficeQ = lstPermis.stream()
							.filter(x -> StringUtils.isNullOrEmpty(x.getOfficecode()) && Objects
									.equals(x.getOfficetype(), TtisvConstant.OFFICE_TYPE.OFFICE_BRANCH.getKey()))
							.findFirst();
					if (existOfficeQ.isPresent()) {
						map.put("isAllBranch", String.valueOf(TtisvConstant.STATUS.FLG_TRUE));
						isAllBranchFlg = true;
					}

					String officecodesG = "";
					String officecodesB = "";
					String officecodesQ = "";
					for (TblUserPermission item : lstPermis) {
						if (isAllAgentFlg
								&& Objects.equals(item.getOfficetype(), TtisvConstant.OFFICE_TYPE.AGENT.getKey())) {
							break;
						} else if (isAllOfficeFlg
								&& Objects.equals(item.getOfficetype(), TtisvConstant.OFFICE_TYPE.OFFICE.getKey())) {
							break;
						} else if (isAllBranchFlg && Objects.equals(item.getOfficetype(),
								TtisvConstant.OFFICE_TYPE.OFFICE_BRANCH.getKey())) {
							break;
						} else {
							String officecodefrm = ("'").concat(item.getOfficecode()).concat("'");
							if (Objects.equals(item.getOfficetype(), TtisvConstant.OFFICE_TYPE.AGENT.getKey())) {
								if (officecodesG != null && !officecodesG.isEmpty()) {
									officecodesG = officecodesG.concat(",").concat(officecodefrm);
								} else {
									officecodesG = officecodesG.concat(officecodefrm);
								}
							}
							if (Objects.equals(item.getOfficetype(), TtisvConstant.OFFICE_TYPE.OFFICE.getKey())) {
								if (officecodesB != null && !officecodesB.isEmpty()) {
									officecodesB = officecodesB.concat(",").concat(officecodefrm);
								} else {
									officecodesB = officecodesB.concat(officecodefrm);
								}
							}
							if (Objects.equals(item.getOfficetype(),
									TtisvConstant.OFFICE_TYPE.OFFICE_BRANCH.getKey())) {
								if (officecodesQ != null && !officecodesQ.isEmpty()) {
									officecodesQ = officecodesQ.concat(",").concat(officecodefrm);
								} else {
									officecodesQ = officecodesQ.concat(officecodefrm);
								}
							}
						}
					}
					if (officecodesG != null && !officecodesG.isEmpty()) {
						map.put("agents", officecodesG);
					}
					if (officecodesB != null && !officecodesB.isEmpty()) {
						map.put("offices", officecodesB);
					}
					if (officecodesQ != null && !officecodesQ.isEmpty()) {
						map.put("branchs", officecodesQ);
					}
				}
			}
		} catch (

		Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return map;
	}

	@Override
	public Boolean deleteUserPermission(Long userId) {
		// TODO Auto-generated method stub
		return tblUserPermissionDao.deleteUserPermission(userId);
	}
}
