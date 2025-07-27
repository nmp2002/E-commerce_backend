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

import com.ttisv.bean.system.TblMenuBtn;
import com.ttisv.dao.impl.BaseDaoImpl;
import com.ttisv.common.utils.StringUtils;

@Repository
public class TblMenuBtnDaoImpl extends BaseDaoImpl<TblMenuBtn> implements TblMenuBtnDao {

	@SuppressWarnings("unchecked")
	@Override
	public Page<TblMenuBtn> getListPageMenuBtn(Pageable pageable, Map<String, String> map) {
		Page<TblMenuBtn> rs = null;

		Session session = this.getCurrentSession();
		try {
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			int count = countMenuBtn(map);
			String sql = "SELECT d.ID, d.BTN_CODE, d.BTN_NAME, d.MENU_ID, g.MENU_NAME, d.STATUS, d.ICON,"
					+ " d.DESCRIPTION FROM TBL_MENU_BTN d LEFT JOIN TBL_MENU g ON d.MENU_ID = g.MENU_ID WHERE d.STATUS <> '2'";

			if (!StringUtils.isEmpty(map.get("btnCode"))) {
				sql += " AND lower(d.BTN_CODE) like :btnCode ESCAPE '/'";
			}
			if (!StringUtils.isEmpty(map.get("btnName"))) {
				sql += " AND lower(d.BTN_NAME) like :btnName ESCAPE '/'";
			}
			if (!StringUtils.isEmpty(map.get("menuId"))) {
				sql += " AND d.MENU_ID = :menuId";
			}
			if (!StringUtils.isEmpty(map.get("status"))) {
				sql += " AND d.STATUS = :status";
			}

			Query query = session.createNativeQuery(sql);
			query.setFirstResult(startItem);
			query.setMaxResults(pageSize);
			Set<Parameter<?>> params = query.getParameters();
			for (Parameter<?> parameter : params) {
				if (Objects.equals(parameter.getName(), "menuId")) {
					query.setParameter(parameter.getName(), Long.valueOf(map.get(parameter.getName())));
				} else if (Objects.equals(parameter.getName(), "btnCode")
						|| Objects.equals(parameter.getName(), "btnName")) {
					query.setParameter(parameter.getName(),
							StringUtils.toLikeAndLowerCaseString(map.get(parameter.getName())));
				} else {
					query.setParameter(parameter.getName(), map.get(parameter.getName()));
				}
			}
			
			List<Object[]> rows = query.getResultList();
			List<TblMenuBtn> lst = new ArrayList<>();
			if (rows != null && !rows.isEmpty()) {
				for (Object[] row : rows) {
					TblMenuBtn menuBtn = new TblMenuBtn();
					if (row[0] != null) {
						menuBtn.setId(((BigDecimal) row[0]).longValue());
					}
					if (row[1] != null) {
						menuBtn.setBtnCode((String) row[1]);
					}
					if (row[2] != null) {
						menuBtn.setBtnName((String) row[2]);
					}
					if (row[3] != null) {
						menuBtn.setMenuId(((BigDecimal) row[3]).longValue());
					}
					if (row[4] != null) {
						menuBtn.setMenuName((String) row[4]);
					}
					if (row[5] != null) {
						menuBtn.setStatus((String) row[5]);
					}
					if (row[6] != null) {
						menuBtn.setIcon((String) row[6]);
					}
					if (row[7] != null) {
						menuBtn.setDescription((String) row[7]);
					}
					lst.add(menuBtn);
				}
			}
			rs = new PageImpl<TblMenuBtn>(lst, PageRequest.of(currentPage, pageSize), count);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	public int countMenuBtn(Map<String, String> map) {
		int totalWithCondition = 0;
		Session session = this.getCurrentSession();
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(*) FROM TblMenuBtn t where t.status <> '2'");
			if (!StringUtils.isEmpty(map.get("btnCode"))) {
				sql.append(" lower(AND t.btnCode) = :btnCode ESCAPE '/'");
			}
			if (!StringUtils.isEmpty(map.get("btnName"))) {
				sql.append(" AND lower(t.btnName) = :btnName ESCAPE '/'");
			}
			if (!StringUtils.isEmpty(map.get("menuId"))) {
				sql.append(" AND t.menuId = :menuId");
			}
			if (!StringUtils.isEmpty(map.get("status"))) {
				sql.append(" AND t.status = :status");
			}
			Query query = session.createQuery(sql.toString());
			Set<Parameter<?>> params = query.getParameters();
			for (Parameter<?> parameter : params) {
				if (Objects.equals(parameter.getName(), "menuId")) {
					query.setParameter(parameter.getName(), Long.valueOf(map.get(parameter.getName())));
				} else if (Objects.equals(parameter.getName(), "btnCode")
						|| Objects.equals(parameter.getName(), "btnName")) {
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
	public List<TblMenuBtn> getListMenuBtn(Map<String, String> map) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM TBL_MENU_BTN t WHERE 1 = 1 ");
			if (map.get("status") != null && !map.get("status").isEmpty()) {
				sql.append(" AND t.STATUS = :status");
			}
			if (map.get("menuId") != null && !map.get("menuId").isEmpty()) {
				sql.append(" AND t.MENU_ID = :menuId");
			}
			Query query = session.createNativeQuery(sql.toString(), TblMenuBtn.class);
			if (map.get("menuId") != null && !map.get("menuId").isEmpty()) {
				query.setParameter("menuId", map.get("menuId"));
			}
			if (map.get("status") != null && !map.get("status").isEmpty()) {
				query.setParameter("status", map.get("status"));
			}
			List<TblMenuBtn> lst = query.getResultList();
			return lst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean existsByMenuBtnCode(String btnCode, Long menuId, Long ignoreId) {
		int count = 0;
		try {
			Session session = this.getCurrentSession();
			String sql = "SELECT COUNT(*) FROM TBL_MENU_BTN t WHERE t.STATUS <> '2' AND t.BTN_CODE =:btnCode "
					+ " AND t.MENU_ID = :menuId";
			if (ignoreId != null) {
				sql += " AND t.ID <> :id";
			}
			Query q = session.createNativeQuery(sql).setParameter("btnCode", btnCode).setParameter("menuId", menuId);
			if (ignoreId != null) {
				q.setParameter("id", ignoreId);
			}
			count = ((Number) q.getSingleResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return count > 0 ? true : false;
	}

	@Override
	public TblMenuBtn findById(Long menuBtnId) {
		TblMenuBtn result = null;
		try {
			Session session = this.getCurrentSession();
			String sql = "SELECT t FROM TblMenuBtn t WHERE t.id =:id";
			Query query = session.createQuery(sql).setParameter("id", menuBtnId);
			result = (TblMenuBtn) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
