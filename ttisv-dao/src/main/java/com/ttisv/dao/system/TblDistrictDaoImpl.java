package com.ttisv.dao.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ttisv.bean.system.TblCity;
import com.ttisv.bean.system.TblDistrict;
import com.ttisv.dao.impl.BaseDaoImpl;
@Repository
public class TblDistrictDaoImpl extends BaseDaoImpl<TblDistrict> implements TblDistrictDao {
	@Override
	public TblDistrict findByDistrictName(String districtName) {
		TblDistrict result = null;
		try {
			Session session = this.getCurrentSession();
			String sql = "select u FROM TblDistrict u WHERE u.districtName =:districtName";
			Query query = session.createQuery(sql).setParameter("districtName", districtName);
			result = (TblDistrict) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
    public List<TblDistrict> getListDistrict(Long provinceid) {
        Session session = this.getCurrentSession();
        try {
            String sql = "SELECT d.DISTRICTID, d.CITY_ID, d.CREATEDBY, d.CREATED_DATE, d.MODIFIED_DATE, d.MODIFIEDBY, " +
                         "d.DISTRICT_TYPE, d.ACTIVE, d.DISTRICTCODE, d.DISTRICTNAME, d.DISTRICTNAMEENGLISH, " +
                         "d.PROVINCECODE, g.PROVINCENAME " +
                         "FROM TBL_DISTRICT d " +
                         "LEFT JOIN TBL_CITY g ON d.PROVINCECODE = g.PROVINCEID " +
                         "WHERE d.ACTIVE <> '2' AND d.PROVINCECODE = :provinceid";

            Query query = session.createNativeQuery(sql);
            query.setParameter("provinceid", provinceid);

            // Get the result list
            List<Object[]> results = query.getResultList();
            List<TblDistrict> districts = new ArrayList<>();

            for (Object[] result : results) {
                TblDistrict district = new TblDistrict();
                district.setDistrictId(((Number) result[0]).longValue());
                district.setCityId((Number) result[1] != null ? ((Number) result[1]).longValue() : null);
                district.setCreatedBy((String) result[2]);
       //         district.setCreatedDate((Date) result[3]);
         //       district.setModifiedDate((Date) result[4]);
                district.setModifiedBy((String) result[5]);
                district.setDistrictType((Number) result[6]);
                district.setActive((String) result[7]);
                district.setDistrictCode((String) result[8]);
                district.setDistrictName((String) result[9]);
                district.setDistrictNameEnglish((String) result[10]);
                district.setProvinceCode((String) result[11]);
                district.setProvinceName((String) result[12]);

                districts.add(district);
            }

            return districts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
