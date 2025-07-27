package com.ttisv.dao.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ttisv.bean.system.TblDistrict;
import com.ttisv.bean.system.TblWard;
import com.ttisv.dao.impl.BaseDaoImpl;
@Repository
public class TblWardDaoImpl extends BaseDaoImpl<TblWard> implements TblWardDao {

	@Override
	public TblWard findByWardName(String wardName) {
		TblWard result =null;
		try {
			Session session = this.getCurrentSession();
			String sql = "select u FROM TblWard u WHERE u.wardName =:wardName";
			Query query = session.createQuery(sql).setParameter("wardName",wardName);
			result = (TblWard) query.getSingleResult();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		}

	@Override
	public List<TblWard> getListWard(Long districtId) {
	    Session session = this.getCurrentSession();
	    try {
	        String sql = "SELECT w.WARDID, w.DISTRICT_ID, w.CREATEDBY, w.CREATED_DATE, w.MODIFIED_DATE, w.MODIFIEDBY, w.ACTIVE, w.WARDCODE, w.WARDNAME, w.WARDNAMEENG " +
	                     "FROM TBL_WARD w " +
	                     "LEFT JOIN TBL_DISTRICT g ON w.DISTRICTCODE = g.DISTRICTID " +
                         "WHERE w.ACTIVE <> '2' AND w.DISTRICTCODE = :districtId";

	        Query query = session.createNativeQuery(sql);
	        query.setParameter("districtId", districtId);

	        // Get the result list
	        List<Object[]> results = query.getResultList();
	        List<TblWard> wards = new ArrayList<>();

	        for (Object[] result : results) {
	            TblWard ward = new TblWard();
	            ward.setWardId(((Number) result[0]).longValue());
	            ward.setDistrictId((Number) result[1] != null ? ((Number) result[1]).longValue() : null);
	            ward.setCreatedBy((String) result[2]);
	            // ward.setCreatedDate((Date) result[3]);
	            // ward.setModifiedDate((Date) result[4]);
	            ward.setModifiedBy((String) result[5]);
	         //   ward.setwardType((Number) result[6]);
	            ward.setActive((String) result[6]);
	            ward.setWardCode((String) result[7]);
	            ward.setWardName((String) result[8]);
	            ward.setWardNameEng((String) result[9]);
	            wards.add(ward);
	        }
	        return wards;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	}

