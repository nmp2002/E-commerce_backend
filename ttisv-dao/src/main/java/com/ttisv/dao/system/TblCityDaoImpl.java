package com.ttisv.dao.system;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ttisv.bean.system.TblCity;
import com.ttisv.dao.BaseDao;
import com.ttisv.dao.impl.BaseDaoImpl;

@Repository
public class TblCityDaoImpl extends BaseDaoImpl<TblCity> implements TblCityDao {

	@Override
	public TblCity findByprovinceName(String provinceName) {
		TblCity result = null;
		try {
			Session session = this.getCurrentSession();
			String sql = "select u FROM TblCity u WHERE u.provinceName =:provinceName";
			Query query = session.createQuery(sql).setParameter("provinceName", provinceName);
			result = (TblCity) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<TblCity> getListCity(Map<String, String> map) {
		Session session = this.getCurrentSession();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM TBL_CITY t");
			Query query = session.createNativeQuery(sql.toString(), TblCity.class);
			List<TblCity> lst = query.getResultList();
			return lst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TblCity getCitybyId(Long provinceid) {
	    try {
	        Session session = this.getCurrentSession();
	        String sql = "SELECT u FROM TblCity u WHERE u.provinceid = :provinceid";
	        Query query = session.createQuery(sql).setParameter("provinceid", provinceid);
	        return (TblCity) query.getSingleResult();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

}
