package com.ttisv.dao.system;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Parameter;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.ttisv.bean.system.TblMenu;
import com.ttisv.dao.impl.BaseDaoImpl;
import com.ttisv.common.utils.StringUtils;

@Repository
public class TblMenuDaoImpl extends BaseDaoImpl<TblMenu> implements TblMenuDao {

	@SuppressWarnings("unchecked")
	@Override
	public Page<TblMenu> getListPageMenu(Pageable pageable, Map<String, String> map) {
		Page<TblMenu> rs = null;

		Session session = this.getCurrentSession();
		try {
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			int count = countMenu(map);
			String sql = "SELECT t FROM TblMenu t WHERE t.status <> '2'";

			if (!StringUtils.isEmpty(map.get("menuCode"))) {
				sql += " AND lower(t.menuCode) like :menuCode ESCAPE '/'";
			}
			if (!StringUtils.isEmpty(map.get("menuName"))) {
				sql += " AND lower(t.menuName) like :menuName ESCAPE '/'";
			}
			if (!StringUtils.isEmpty(map.get("parentId"))) {
				sql += " AND t.parentId = :parentId";
			}
			if (!StringUtils.isEmpty(map.get("status"))) {
				sql += " AND t.status = :status";
			}
			sql += " ORDER BY t.orderNumber ASC, t.menuName ASC";
			Query query = session.createQuery(sql, TblMenu.class);
			query.setFirstResult(startItem);
			query.setMaxResults(pageSize);
			Set<Parameter<?>> params = query.getParameters();
			for (Parameter<?> parameter : params) {
				if (Objects.equals(parameter.getName(), "parentId")) {
					query.setParameter(parameter.getName(), Long.valueOf(map.get(parameter.getName())));
				} else if (Objects.equals(parameter.getName(), "menuCode")
						|| Objects.equals(parameter.getName(), "menuName")) {
					query.setParameter(parameter.getName(),
							StringUtils.toLikeAndLowerCaseString(map.get(parameter.getName())));
				} else {
					query.setParameter(parameter.getName(), map.get(parameter.getName()));
				}
			}
			List<TblMenu> lst = query.getResultList();
			rs = new PageImpl<TblMenu>(lst, PageRequest.of(currentPage, pageSize), count);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	public int countMenu(Map<String, String> map) {
		int totalWithCondition = 0;
		Session session = this.getCurrentSession();
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(*) FROM TBL_MENU t WHERE t.STATUS <> '2'");
			if (!StringUtils.isEmpty(map.get("menuCode"))) {
				sql.append(" AND lower(t.MENU_CODE) like :menuCode ESCAPE '/'");
			}
			if (!StringUtils.isEmpty(map.get("menuName"))) {
				sql.append(" AND lower(t.MENU_NAME) like :menuName ESCAPE '/'");
			}
			if (!StringUtils.isEmpty(map.get("parentId"))) {
				sql.append(" AND t.PARENT_ID = :parentId");
			}
			if (!StringUtils.isEmpty(map.get("status"))) {
				sql.append(" AND t.STATUS = :status");
			}
			Query query = session.createNativeQuery(sql.toString());
			Set<Parameter<?>> params = query.getParameters();
			for (Parameter<?> parameter : params) {
				if (Objects.equals(parameter.getName(), "parentId")) {
					query.setParameter(parameter.getName(), Long.valueOf(map.get(parameter.getName())));
				} else if (Objects.equals(parameter.getName(), "menuCode")
						|| Objects.equals(parameter.getName(), "menuName")) {
					query.setParameter(parameter.getName(),
							StringUtils.toLikeAndLowerCaseString(map.get(parameter.getName())));
				} else {
					query.setParameter(parameter.getName(), map.get(parameter.getName()));
				}
			}
			totalWithCondition = Integer.valueOf(String.valueOf(query.getSingleResult()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalWithCondition;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TblMenu> getListMenu(Map<String, String> map) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM TBL_MENU t WHERE 1 = 1 ORDER BY t.MENU_NAME ASC");
			Query query = session.createNativeQuery(sql.toString(), TblMenu.class);
			List<TblMenu> lst = query.getResultList();
			return lst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TblMenu> getListMenuByRole(Map<String, String> map) {
		// TODO Auto-generated method stub
		List<TblMenu> result = new ArrayList<>();
		Session session = this.getCurrentSession();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT t.MENU_ID, t.MENU_CODE,t.MENU_NAME,t.PARENT_ID,t.STATUS,t.DESCRIPTION,"
					+ " t.ICON,t.URL,t.COLOR,t.TEXT,t.TITLE,t.ORDER_NUMBER,t.IS_HAVE_BUTTON, r.MENU_BTN ");
			if (map.get("isGetAll") != null && !map.get("isGetAll").isEmpty() && Boolean.valueOf(map.get("isGetAll"))) {
				sql.append(" FROM TBL_MENU t LEFT JOIN TBL_ROLE_OBJECT r ON t.MENU_ID = r.OBJECT_ID ");
			} else {
				sql.append(" FROM TBL_MENU t INNER JOIN TBL_ROLE_OBJECT r ON t.MENU_ID = r.OBJECT_ID ");
			}
			if (!StringUtils.isEmpty(map.get("roleId"))) {
				sql.append(" AND r.ROLE_ID = :roleId");
			}
			if (!StringUtils.isEmpty(map.get("groupRoleId"))) {
				sql.append(" AND r.GROUP_ROLE_ID = :groupRoleId");
			}
			sql.append(" WHERE t.STATUS = '1' ORDER BY t.ORDER_NUMBER ASC");
			Query query = session.createNativeQuery(sql.toString());
			if (!StringUtils.isEmpty(map.get("roleId"))) {
				query.setParameter("roleId", Long.valueOf(map.get("roleId")));
			}
			if (!StringUtils.isEmpty(map.get("groupRoleId"))) {
				query.setParameter("groupRoleId", Long.valueOf(map.get("groupRoleId")));
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
	public Boolean existsByMenuCode(String menuCode, Long ignoreId) {
		int count = 0;
		try {
			Session session = this.getCurrentSession();
			String sql = "SELECT COUNT(*) FROM TBL_MENU t WHERE t.STATUS <> '2' AND t.MENU_CODE = :menuCode";
			if (ignoreId != null) {
				sql += " AND t.MENU_ID <> :menuId";
			}
			Query q = session.createNativeQuery(sql).setParameter("menuCode", menuCode);
			if (ignoreId != null) {
				q.setParameter("menuId", ignoreId);
			}
			count = ((Number) q.getSingleResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return count > 0 ? true : false;
	}

	@Override
	public TblMenu findById(Long menuId) {
		TblMenu result = null;
		try {
			Session session = this.getCurrentSession();
			String sql = "select t FROM TblMenu t WHERE t.menuId =:menuId";
			Query query = session.createQuery(sql).setParameter("menuId", menuId);
			result = (TblMenu) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TblMenu> getListMenuObjectId(Long groupRoleId, Long roleId) {
		// TODO Auto-generated method stub
		List<TblMenu> result = new ArrayList<>();
		if (groupRoleId == null && roleId == null) {
			return result;
		}
		Session session = this.getCurrentSession();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT m FROM TblMenu m, TblRoleObject r WHERE m.menuId = r.objectId AND m.status = 1 ");
			if (groupRoleId != null) {
				sql.append(" AND r.groupRoleId = :groupRoleId");
			}
			if (roleId != null) {
				sql.append(" AND r.roleId = :roleId");
			}
			sql.append(" ORDER BY m.orderNumber ASC");
			Query query = session.createQuery(sql.toString(), TblMenu.class);
			if (groupRoleId != null) {
				query.setParameter("groupRoleId", groupRoleId);
			}
			if (roleId != null) {
				query.setParameter("roleId", roleId);
			}
			List<TblMenu> lst = query.getResultList();
			return lst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Boolean updateStatusHaveButton(Long menuId, String status) {
		try {
			Session session = this.getCurrentSession();
			String sql = "UPDATE TBL_MENU SET IS_HAVE_BUTTON = :status WHERE MENU_ID = :menuId";
			Query q = session.createNativeQuery(sql).setParameter("status", status).setParameter("menuId", menuId);
			q.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean checkHaveButton(Long menuId, Long ignoreBtnId) {
		int count = 0;
		try {
			Session session = this.getCurrentSession();
			String sql = "SELECT COUNT(*) FROM TBL_MENU_BTN t WHERE t.STATUS = '1' AND t.MENU_ID = :menuId";
			if (ignoreBtnId != null) {
				sql += " AND t.ID <> :ignoreBtnId";
			}
			Query q = session.createNativeQuery(sql).setParameter("menuId", menuId);
			if (ignoreBtnId != null) {
				q.setParameter("ignoreBtnId", ignoreBtnId);
			}
			count = ((Number) q.getSingleResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count > 0 ? true : false;
	}
}
