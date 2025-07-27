package com.ttisv.dao.system;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ttisv.bean.system.TblUserPermission;
import com.ttisv.dao.impl.BaseDaoImpl;

@Repository
public class TblUserPermissionDaoImpl extends BaseDaoImpl<TblUserPermission> implements TblUserPermissionDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TblUserPermission> getListUserPermission(Long userId) {
		List<TblUserPermission> rs = new ArrayList<>();
		Session session = this.getCurrentSession();
		try {
			String sql = "SELECT u FROM TblUserPermission u WHERE u.userId = :userId";
			Query query = session.createQuery(sql, TblUserPermission.class);
			query.setParameter("userId", userId);
			rs = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public Boolean deleteUserPermission(Long userId) {
		try {
			Session session = this.getCurrentSession();
			String sql = "DELETE FROM TBL_USER_PERMISSION WHERE USER_ID = :userId";
			Query query = session.createNativeQuery(sql).setParameter("userId", userId);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean updateUserPermission(Long userId, String active) {
		try {
			Session session = this.getCurrentSession();
			String sql = "UPDATE TBL_USER_PERMISSION SET ACTIVE = :active WHERE USER_ID = :userId";
			Query query = session.createNativeQuery(sql).setParameter("userId", userId).setParameter("active", active);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
