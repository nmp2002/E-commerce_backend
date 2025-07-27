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

import com.ttisv.bean.system.TblRole;
import com.ttisv.dao.impl.BaseDaoImpl;
import com.ttisv.common.utils.StringUtils;

@Repository
public class TblRoleDaoImpl extends BaseDaoImpl<TblRole> implements TblRoleDao {

	@SuppressWarnings("unchecked")
	@Override
	public Page<TblRole> getListPageRole(Pageable pageable, Map<String, String> map) {
		Page<TblRole> rs = null;

		Session session = this.getCurrentSession();
		try {
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			int count = countRole(map);
			String sql = "SELECT d.ID, d.ROLE_CODE, d.ROLE_NAME, d.GROUP_ROLE_ID,"
					+ " d.STATUS, d.DESCRIPTION, g.GROUP_ROLE_NAME FROM TBL_ROLE d"
					+ " LEFT JOIN TBL_GROUP_ROLE g ON d.GROUP_ROLE_ID = g.ID WHERE d.STATUS <> '2'";

			if (!StringUtils.isEmpty(map.get("roleCode"))) {
				sql += " AND lower(d.ROLE_CODE) like :roleCode ESCAPE '/'";
			}
			if (!StringUtils.isEmpty(map.get("roleName"))) {
				sql += " AND lower(d.ROLE_NAME) like :roleName ESCAPE '/'";
			}
			if (!StringUtils.isEmpty(map.get("groupRoleId"))) {
				sql += " AND d.GROUP_ROLE_ID = :groupRoleId";
			}
			if (!StringUtils.isEmpty(map.get("status"))) {
				sql += " AND d.STATUS = :status";
			}

			Query query = session.createNativeQuery(sql);
			query.setFirstResult(startItem);
			query.setMaxResults(pageSize);
			Set<Parameter<?>> params = query.getParameters();
			for (Parameter<?> parameter : params) {
				if (Objects.equals(parameter.getName(), "groupRoleId")) {
					query.setParameter(parameter.getName(), Long.valueOf(map.get(parameter.getName())));
				} else if (Objects.equals(parameter.getName(), "roleCode")
						|| Objects.equals(parameter.getName(), "roleName")) {
					query.setParameter(parameter.getName(),
							StringUtils.toLikeAndLowerCaseString(map.get(parameter.getName())));
				} else {
					query.setParameter(parameter.getName(), map.get(parameter.getName()));
				}
			}
			List<Object[]> rows = query.getResultList();
			List<TblRole> lst = new ArrayList<>();
			if (rows != null && !rows.isEmpty()) {
				for (Object[] row : rows) {
					TblRole role = new TblRole();
					if (row[0] != null) {
						role.setId(((BigDecimal) row[0]).longValue());
					}
					if (row[1] != null) {
						role.setRoleCode((String) row[1]);
					}
					if (row[2] != null) {
						role.setRoleName((String) row[2]);
					}
					if (row[3] != null) {
						role.setGroupRoleId(((BigDecimal) row[3]).longValue());
					}
					if (row[4] != null) {
						role.setStatus((String) row[4]);
					}
					if (row[5] != null) {
						role.setDescription((String) row[5]);
					}
					if (row[6] != null) {
						role.setGroupRoleName((String) row[6]);
					}
					lst.add(role);
				}
			}
			rs = new PageImpl<TblRole>(lst, PageRequest.of(currentPage, pageSize), count);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	public int countRole(Map<String, String> map) {
		int totalWithCondition = 0;
		Session session = this.getCurrentSession();
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(*) FROM TblRole t where t.status <> '2'");
			if (!StringUtils.isEmpty(map.get("roleCode"))) {
				sql.append(" AND lower(t.roleCode) = :roleCode ESCAPE '/'");
			}
			if (!StringUtils.isEmpty(map.get("roleName"))) {
				sql.append(" AND lower(t.roleName) = :roleName ESCAPE '/'");
			}
			if (!StringUtils.isEmpty(map.get("groupRoleId"))) {
				sql.append(" AND t.groupRoleId = :groupRoleId");
			}
			if (!StringUtils.isEmpty(map.get("status"))) {
				sql.append(" AND t.status = :status");
			}
			Query query = session.createQuery(sql.toString());
			Set<Parameter<?>> params = query.getParameters();
			for (Parameter<?> parameter : params) {
				if (Objects.equals(parameter.getName(), "groupRoleId")) {
					query.setParameter(parameter.getName(), Long.valueOf(map.get(parameter.getName())));
				} else if (Objects.equals(parameter.getName(), "roleCode")
						|| Objects.equals(parameter.getName(), "roleName")) {
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
	public List<TblRole> getListRole(Map<String, String> map) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM TBL_ROLE t");
			Query query = session.createNativeQuery(sql.toString(), TblRole.class);
			List<TblRole> lst = query.getResultList();
			return lst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean existsByRoleCode(String roleCode, Long ignoreId) {
		int count = 0;
		try {
			Session session = this.getCurrentSession();
			String sql = "SELECT COUNT(*) FROM TBL_ROLE t WHERE t.STATUS <> '2' AND t.ROLE_CODE =:roleCode";
			if (ignoreId != null) {
				sql += " AND t.ID <> :id";
			}
			Query q = session.createNativeQuery(sql).setParameter("roleCode", roleCode);
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
	public TblRole findById(Long roleId) {
		TblRole result = null;
		try {
			Session session = this.getCurrentSession();
			String sql = "select t FROM TblRole t WHERE t.id =:id";
			Query query = session.createQuery(sql).setParameter("id", roleId);
			result = (TblRole) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
