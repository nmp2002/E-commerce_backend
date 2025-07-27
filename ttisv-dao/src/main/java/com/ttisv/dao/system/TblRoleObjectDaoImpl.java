package com.ttisv.dao.system;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ttisv.bean.system.TblMenu;
import com.ttisv.bean.system.TblRoleObject;
import com.ttisv.common.utils.StringUtils;
import com.ttisv.dao.impl.BaseDaoImpl;

@Repository
public class TblRoleObjectDaoImpl extends BaseDaoImpl<TblRoleObject> implements TblRoleObjectDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TblRoleObject> getListRoleObject(Map<String, String> map) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		try {
			String sql = "SELECT t FROM TblRoleObject t, TblMenu m WHERE m.menuId = t.objectId AND m.status = 1";
			if (!StringUtils.isEmpty(map.get("groupRoleId"))) {
				sql += " AND t.groupRoleId = :groupRoleId";
			}
			if (!StringUtils.isEmpty(map.get("roleId"))) {
				sql += " AND t.roleId = :roleId";
			}
			sql += " ORDER BY m.orderNumber ASC";
			Query query = session.createQuery(sql.toString(), TblRoleObject.class);
			if (!StringUtils.isEmpty(map.get("groupRoleId"))) {
				query.setParameter("groupRoleId", Long.valueOf(map.get("groupRoleId")));
			}
			if (!StringUtils.isEmpty(map.get("roleId"))) {
				query.setParameter("roleId", Long.valueOf(map.get("roleId")));
			}
			List<TblRoleObject> lst = query.getResultList();
			return lst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TblMenu> getListMenuByRoleObject(Map<String, String> map) {
		List<TblMenu> result = new ArrayList<>();
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		try {
			String sql = "SELECT r.MENU_ID, r.MENU_CODE, r.MENU_NAME, r.PARENT_ID, r.STATUS, r.DESCRIPTION, r.ICON,"
					+ " r.URL, r.COLOR, r.TEXT, r.TITLE, r.ORDER_NUMBER, r.IS_HAVE_BUTTON, r.MENU_BTN AS LST_BTN"
					+ " FROM (SELECT m.*, t.MENU_BTN FROM TBL_ROLE_OBJECT t, TBL_MENU m WHERE m.MENU_ID = t.OBJECT_ID ";
			if (!StringUtils.isEmpty(map.get("groupRoleId"))) {
				sql += " AND t.GROUP_ROLE_ID = :groupRoleId";
			}
			if (!StringUtils.isEmpty(map.get("roleId"))) {
				sql += " AND t.ROLE_ID = :roleId";
			}
			sql += " AND m.STATUS = 1 ORDER BY m.PARENT_ID ASC) r";
			sql += " CONNECT BY NOCYCLE PARENT_ID = PRIOR MENU_ID START WITH PARENT_ID IS NULL ";
			Query query = session.createNativeQuery(sql.toString());
			if (!StringUtils.isEmpty(map.get("groupRoleId"))) {
				query.setParameter("groupRoleId", Long.valueOf(map.get("groupRoleId")));
			}
			if (!StringUtils.isEmpty(map.get("roleId"))) {
				query.setParameter("roleId", Long.valueOf(map.get("roleId")));
			}
			List<Object[]> rows = query.getResultList();
			if (rows != null && !rows.isEmpty()) {
				for (Object[] row : rows) {
					TblMenu menu = new TblMenu();
					menu.setMenuId(row[0] != null ? ((BigDecimal) row[0]).longValue() : null);
					menu.setMenuCode(row[1] != null ? (String) row[1] : null);
					menu.setMenuName(row[2] != null ? (String) row[2] : null);
					menu.setParentId(row[3] != null ? ((BigDecimal) row[3]).longValue() : null);
					menu.setStatus(row[4] != null ? (String) row[4] : null);
					menu.setDescription(row[5] != null ? (String) row[5] : null);
					menu.setIcon(row[6] != null ? (String) row[6] : null);
					menu.setUrl(row[7] != null ? (String) row[7] : null);
					menu.setColor(row[8] != null ? (String) row[8] : null);
					menu.setText(row[9] != null ? (String) row[9] : null);
					menu.setTitle(row[10] != null ? (String) row[10] : null);
					menu.setOrderNumber(row[11] != null ? ((BigDecimal) row[11]).longValue() : null);
					menu.setIsHaveButton(row[12] != null ? (String) row[12] : null);
					menu.setMenuBtn(row[13] != null ? (String) row[13] : null);
					result.add(menu);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public TblRoleObject findById(Long roleObjectId) {
		TblRoleObject result = null;
		try {
			Session session = this.getCurrentSession();
			String sql = "select t FROM TblRoleObject t WHERE t.roleObjectId =:roleObjectId";
			Query query = session.createQuery(sql).setParameter("roleObjectId", roleObjectId);
			result = (TblRoleObject) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteRoleObject(Long groupRoleId, Long roleId) {
		if (groupRoleId == null && roleId == null) {
			return false;
		}
		try {
			Session session = this.getCurrentSession();
			String sql = "DELETE FROM TBL_ROLE_OBJECT t WHERE 1 = 1";
			if (groupRoleId != null) {
				sql += " AND t.GROUP_ROLE_ID = :groupRoleId";
			}
			if (roleId != null) {
				sql += " AND t.ROLE_ID = :roleId";
			}
			Query query = session.createNativeQuery(sql);
			if (groupRoleId != null) {
				query.setParameter("groupRoleId", groupRoleId);
			}
			if (roleId != null) {
				query.setParameter("roleId", roleId);
			}
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
