package com.ttisv.dao.system;

import java.math.BigDecimal;
import java.sql.Clob;
import java.util.Date;
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

import com.ttisv.bean.system.TblUser;
import com.ttisv.dao.impl.BaseDaoImpl;
import com.ttisv.common.utils.StringUtils;

@Repository
public class TblUserDaoImpl extends BaseDaoImpl<TblUser> implements TblUserDao {

	@SuppressWarnings("unchecked")
	@Override
	public Page<TblUser> getListPageUser(Pageable pageable, Map<String, String> map) {
		Page<TblUser> rs = null;
		Session session = this.getCurrentSession();
		try {
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			int count = this.countNhanSu(map);

			String sql = "SELECT u FROM TblUser u WHERE u.status <> '2'";
			if (!StringUtils.isEmpty(map.get("userName"))) {
				sql += " and lower(u.userName) like :userName ESCAPE '/'";
			}
			if (!StringUtils.isEmpty(map.get("email"))) {
				sql += " and lower(u.email) like :email ESCAPE '/'";
			}
			if (!StringUtils.isEmpty(map.get("status"))) {
				sql += " and u.status =:status";
			}
			if (!StringUtils.isEmpty(map.get("fullName"))) {
				sql += " and lower(u.fullname) like :fullName ESCAPE '/'";
			}
			if (!StringUtils.isEmpty(map.get("departmentname"))) {
				sql += " and lower(u.departmentname) like :departmentname ESCAPE '/'";
			}
			Query query = session.createQuery(sql, TblUser.class);
			query.setFirstResult(startItem);
			query.setMaxResults(pageSize);
			Set<Parameter<?>> params = query.getParameters();
			for (Parameter<?> parameter : params) {
				if (Objects.equals(parameter.getName(), "userName") || Objects.equals(parameter.getName(), "email")
						|| Objects.equals(parameter.getName(), "fullName")
						|| Objects.equals(parameter.getName(), "departmentname")) {
					query.setParameter(parameter.getName(),
							StringUtils.toLikeAndLowerCaseString(map.get(parameter.getName())));
				} else {
					query.setParameter(parameter.getName(), map.get(parameter.getName()));
				}
			}
			List<TblUser> lst = query.getResultList();
			rs = new PageImpl<TblUser>(lst, PageRequest.of(currentPage, pageSize), count);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	public int countNhanSu(Map<String, String> map) {
		Session session = this.getCurrentSession();
		int rs = 0;
		try {
			String sql = "SELECT COUNT(*) FROM TblUser u WHERE u.status <> '2'";
			if (!StringUtils.isEmpty(map.get("userName"))) {
				sql += " and lower(u.userName) like :userName ESCAPE '/'";
			}
			if (!StringUtils.isEmpty(map.get("email"))) {
				sql += " and lower(u.email) like :email ESCAPE '/'";
			}
			if (!StringUtils.isEmpty(map.get("status"))) {
				sql += " and u.status =:status";
			}
			if (!StringUtils.isEmpty(map.get("fullName"))) {
				sql += " and lower(u.fullname) like :fullName ESCAPE '/'";
			}
			if (!StringUtils.isEmpty(map.get("departmentname"))) {
				sql += " and lower(u.departmentname) like :departmentname ESCAPE '/'";
			}
			Query query = session.createQuery(sql);
			Set<Parameter<?>> params = query.getParameters();
			for (Parameter<?> parameter : params) {
				if (Objects.equals(parameter.getName(), "userName") || Objects.equals(parameter.getName(), "email")
						|| Objects.equals(parameter.getName(), "fullName")
						|| Objects.equals(parameter.getName(), "departmentname")) {
					query.setParameter(parameter.getName(),
							StringUtils.toLikeAndLowerCaseString(map.get(parameter.getName())));
				} else {
					query.setParameter(parameter.getName(), map.get(parameter.getName()));
				}
			}
			rs = Integer.valueOf(String.valueOf(query.getSingleResult()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public TblUser findByUserName(String username) {
		TblUser result = null;
		try {
			Session session = this.getCurrentSession();
			String sql = "select u FROM TblUser u WHERE u.userName =:username";
			Query query = session.createQuery(sql).setParameter("username", username);
			result = (TblUser) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public TblUser getFullByUserName(String username) {
		TblUser result = null;
		try {
			Session session = this.getCurrentSession();
			String sql = "SELECT u.ID, u.USER_NAME, u.FULLNAME, u.PASSWORD, u.DESCRIPTION, u.EMAIL, u.GENDER, u.TELEPHONE,"
					+ " u.CREATED_DATE, u.MODIFIED_DATE, u.DEPARTMENTNAME, u.POSITIONCODE, u.DEPARTMENTCODE, u.EXPIRED_PASSWORD,"
					+ " u.IS_RESET_PASS, u.CREATEDBY, u.ADDRESS, u.STATUS, u.ROLE_ID, u.COUNT_LOGIN, g.ID AS GROUP_ROLE_ID,"
					+ " g.GROUP_ROLE_NAME, r.ROLE_NAME, d.ID AS DEPT_ID, u.OFFICECODE, u.OFFICENAME, u.AVATAR, g.GROUP_PERMISSION, u.OFFICETYPE "
					+ " FROM TBL_USER u LEFT JOIN TBL_DEPARTMENT d ON u.DEPARTMENTCODE = d.DEPARTMENT_CODE AND d.STATUS = 1 "
					+ " LEFT JOIN TBL_ROLE r ON u.ROLE_ID = r.ID AND r.STATUS = 1 "
					+ " LEFT JOIN TBL_GROUP_ROLE g ON r.GROUP_ROLE_ID = g.ID AND g.STATUS = 1 "
					+ " WHERE u.USER_NAME = :username";
			Query query = session.createNativeQuery(sql).setParameter("username", username);

			List<Object[]> a = query.getResultList();
			// Object[] row = (Object[]) query.getSingleResult();
			if (a != null && a.size() > 0) {
				Object[] row = a.get(0);
				result = new TblUser();
				result.setId(row[0] != null ? ((BigDecimal) row[0]).longValue() : null);
				result.setUserName(row[1] != null ? (String) row[1] : null);
				result.setFullname(row[2] != null ? (String) row[2] : null);
				result.setPassword(row[3] != null ? (String) row[3] : null);
				result.setDescription(row[4] != null ? (String) row[4] : null);
				result.setEmail(row[5] != null ? (String) row[5] : null);
				result.setGender(row[6] != null ? (String) row[6] : null);
				result.setTelephone(row[7] != null ? (String) row[7] : null);
				result.setCreatedDate(row[8] != null ? (Date) row[8] : null);
				result.setModifiedDate(row[9] != null ? (Date) row[9] : null);
				result.setDepartmentname(row[10] != null ? (String) row[10] : null);
				result.setPositioncode(row[11] != null ? (String) row[11] : null);
				result.setDepartmentcode(row[12] != null ? (String) row[12] : null);
				result.setExpiredPassword(row[13] != null ? (Date) row[13] : null);
				result.setIsResetPass(row[14] != null ? (String) row[14] : null);
				result.setCreatedby(row[15] != null ? (String) row[15] : null);
				result.setAddress(row[16] != null ? (String) row[16] : null);
				result.setStatus(row[17] != null ? (String) row[17] : null);
				result.setRoleId(row[18] != null ? ((BigDecimal) row[18]).longValue() : null);
				result.setCountLogin(row[19] != null ? ((BigDecimal) row[19]).longValue() : null);
				result.setRoleGroupId(row[20] != null ? ((BigDecimal) row[20]).longValue() : null);
				result.setRoleGroupName(row[21] != null ? (String) row[21] : null);
				result.setRoleName(row[22] != null ? (String) row[22] : null);
				result.setDepartmentId(row[23] != null ? ((BigDecimal) row[23]).longValue() : null);
				result.setOfficecode(row[24] != null ? (String) row[24] : null);
				result.setOfficename(row[25] != null ? (String) row[25] : null);
				if (row[26] != null) {
					Clob clob = (Clob) row[26];
					String avatar = StringUtils.getAsString(clob);
					result.setAvatar(avatar);
				}
				result.setMapRuleAction(row[27] != null ? (String) row[27] : null);
				result.setOfficetype(row[28] != null ? (String) row[28] : null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public TblUser findById(Long id) {
		TblUser result = null;
		try {
			Session session = this.getCurrentSession();
			String sql = "select u FROM TblUser u WHERE u.id =:id";
			Query query = session.createQuery(sql).setParameter("id", id);
			result = (TblUser) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Boolean existsByUsername(String username) {
		int count = 0;
		try {
			Session session = this.getCurrentSession();
			String sql = "select count (*) FROM TBL_USER fg WHERE USER_NAME =:username";
			Query q = session.createNativeQuery(sql).setParameter("username", username);
			count = ((Number) q.getSingleResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count > 0 ? true : false;
	}

	@Override
	public Boolean existsByEmail(String email, Long ignoreId) {
		int count = 0;
		try {
			Session session = this.getCurrentSession();
			String sql = "select count (*) FROM TBL_USER fg WHERE email =:email";
			if (ignoreId != null) {
				sql += " AND id <> :id";
			}
			Query q = session.createNativeQuery(sql).setParameter("email", email);
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
	public void resetLoginTimes(String username) {
		try {
			String sql = "UPDATE TBL_USER SET COUNT_LOGIN = 0 WHERE USER_NAME=:username";
			Query query = this.getCurrentSession().createNativeQuery(sql).setParameter("username", username);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int countActiveUsers() {
	    Session session = this.getCurrentSession();
	    int count = 0;
	    try {
	        String sql = "SELECT COUNT(*) FROM TblUser u WHERE u.status = '1'";
	        Query query = session.createQuery(sql);
	        count = ((Long) query.getSingleResult()).intValue();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return count;
	}

	public int countInactiveUsers() {
	    Session session = this.getCurrentSession();
	    int count = 0;
	    try {
	        String sql = "SELECT COUNT(*) FROM TblUser u WHERE u.status = '0'";
	        Query query = session.createQuery(sql);
	        count = ((Long) query.getSingleResult()).intValue();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return count;
	}

}
