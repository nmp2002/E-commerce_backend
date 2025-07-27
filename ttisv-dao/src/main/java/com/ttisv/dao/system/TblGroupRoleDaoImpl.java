package com.ttisv.dao.system;

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

import com.ttisv.bean.system.TblGroupRole;
import com.ttisv.dao.impl.BaseDaoImpl;
import com.ttisv.common.utils.StringUtils;

@Repository
public class TblGroupRoleDaoImpl extends BaseDaoImpl<TblGroupRole> implements TblGroupRoleDao {

	@SuppressWarnings("unchecked")
	@Override
	public Page<TblGroupRole> getListPageGroupRole(Pageable pageable, Map<String, String> map) {
		Page<TblGroupRole> rs = null;
		Session session = this.getCurrentSession();
		try {
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			int count = countGroupRole(map);
			String sql = "SELECT d FROM TblGroupRole d WHERE d.status <> '2'";

			if (!StringUtils.isEmpty(map.get("groupRoleCode"))) {
				sql += " AND lower(d.groupRoleCode) like :groupRoleCode ESCAPE '/'";
			}
			if (!StringUtils.isEmpty(map.get("groupRoleName"))) {
				sql += " AND lower(d.groupRoleName) like :groupRoleName ESCAPE '/'";
			}
			if (!StringUtils.isEmpty(map.get("status"))) {
				sql += " AND d.status = :status";
			}

			Query query = session.createQuery(sql, TblGroupRole.class);
			query.setFirstResult(startItem);
			query.setMaxResults(pageSize);
			Set<Parameter<?>> params = query.getParameters();
			for (Parameter<?> parameter : params) {
				if (Objects.equals(parameter.getName(), "groupRoleCode")
						|| Objects.equals(parameter.getName(), "groupRoleName")) {
					query.setParameter(parameter.getName(),
							StringUtils.toLikeAndLowerCaseString(map.get(parameter.getName())));
				} else {
					query.setParameter(parameter.getName(), map.get(parameter.getName()));
				}
			}
			List<TblGroupRole> lst = query.getResultList();
			rs = new PageImpl<TblGroupRole>(lst, PageRequest.of(currentPage, pageSize), count);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	public int countGroupRole(Map<String, String> map) {
		int totalWithCondition = 0;
		Session session = this.getCurrentSession();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(*) FROM TblGroupRole t where 1=1 ");
			if (!StringUtils.isEmpty(map.get("groupRoleCode"))) {
				sql.append(" AND lower(t.groupRoleCode) = :groupRoleCode ESCAPE '/'");
			}
			if (!StringUtils.isEmpty(map.get("groupRoleName"))) {
				sql.append(" AND lower(t.groupRoleName) = :groupRoleName ESCAPE '/'");
			}
			if (!StringUtils.isEmpty(map.get("status"))) {
				sql.append(" AND t.status = :status");
			}
			Query query = session.createQuery(sql.toString());
			Set<Parameter<?>> params = query.getParameters();
			for (Parameter<?> parameter : params) {
				if (Objects.equals(parameter.getName(), "groupRoleCode")
						|| Objects.equals(parameter.getName(), "groupRoleName")) {
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
	public List<TblGroupRole> getListGroupRole(Map<String, String> map) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM TBL_GROUP_ROLE t ");
			Query query = session.createNativeQuery(sql.toString(), TblGroupRole.class);
			List<TblGroupRole> lst = query.getResultList();
			return lst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean existsByGroupRoleCode(String groupRoleCode, Long ignoreId) {
		int count = 0;
		try {
			Session session = this.getCurrentSession();
			String sql = "SELECT COUNT(*) FROM TBL_GROUP_ROLE fg WHERE fg.GROUP_ROLE_CODE =:groupRoleCode";
			if (ignoreId != null) {
				sql += " AND fg.ID <> :id";
			}
			Query q = session.createNativeQuery(sql).setParameter("groupRoleCode", groupRoleCode);
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
	public TblGroupRole findById(Long groupRoleId) {
		TblGroupRole result = null;
		try {
			Session session = this.getCurrentSession();
			String sql = "select d FROM TblGroupRole d WHERE d.id =:id";
			Query query = session.createQuery(sql).setParameter("id", groupRoleId);
			result = (TblGroupRole) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
