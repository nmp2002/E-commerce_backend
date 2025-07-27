package com.ttisv.dao.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ttisv.bean.system.TblSmallField;
import com.ttisv.bean.system.TblUser;
import com.ttisv.dao.impl.BaseDaoImpl;

@Repository
public class TblSmallFieldDaoImpl extends BaseDaoImpl<TblSmallField> implements TblSmallFieldDao {

	 @Override
	    public TblSmallField createSmallField(Long fieldId, String smallFieldName, Long fieldTypeId, String fieldType) {
	        Session session = this.getCurrentSession();
	        TblSmallField smallField = new TblSmallField();
	        smallField.setFieldId(fieldId);
	        smallField.setSmallFieldName(smallFieldName);
	        smallField.setFieldTypeId(fieldTypeId);
	        smallField.setCreatedDate(new Date());
	        smallField.setStatus(1L);
	        smallField.setFieldType(fieldType);
	        session.saveOrUpdate(smallField);
	        return smallField;
	    }

	   
	   @Override
	   public TblSmallField findByFieldIdAndSmallFieldName(Long fieldId, String smallFieldName,String fieldType) {
		    Session session = this.getCurrentSession();
		    try {
		        String sql = "SELECT s FROM TblSmallField s WHERE s.fieldId = :fieldId AND s.smallFieldName = :smallFieldName AND s.fieldType = :fieldType";
		        Query query = session.createQuery(sql)
		                             .setParameter("fieldId", fieldId)
		                             .setParameter("smallFieldName", smallFieldName);
		        return (TblSmallField) query.getSingleResult();
		    } catch (Exception e) {
		        return null; 
		    }
		}
	   
	   private Long getTotalNumberFieldByFieldTypeId(Long fieldTypeId) {
	        Session session = this.getCurrentSession();
	        try {
	            String sql = "SELECT f.totalNumberField FROM TblFieldType f WHERE f.fieldTypeId = :fieldTypeId";
	            Query query = session.createQuery(sql);
	            query.setParameter("fieldTypeId", fieldTypeId);
	            return (Long) query.getSingleResult();
	        } catch (Exception e) {
	            return null;
	        }
	    }
	   
	   @Override
	    public List<TblSmallField> getSmallFieldsByFieldId(Long fieldId) {
	        Session session = this.getCurrentSession();
	        try {
	            String sql = "SELECT s.ID, s.FIELD_ID, s.PROVINCE_ID, s.DISTRICT_ID, s.WARD_ID, " +
	                         "s.FIELDTYPE_ID, s.SMALLFIELDNAME, s.FIELD_MONEY, s.STATUS, s.FIELDTYPE, " +
	                         "s.CREATEBY, s.MODIFIEDBY, s.CREATED_DATE, s.MODIFIED_DATE " +
	                         "FROM TBL_SMALL_FIELD s " +
	                         "WHERE s.FIELD_ID = :fieldId";

	            Query query = session.createNativeQuery(sql);
	            query.setParameter("fieldId", fieldId);

	            List<Object[]> results = query.getResultList();
	            List<TblSmallField> smallFields = new ArrayList<>();

	            for (Object[] result : results) {
	                TblSmallField smallField = new TblSmallField();
	                smallField.setId(((Number) result[0]).longValue());
	                smallField.setFieldId(((Number) result[1]).longValue());
	                smallField.setProvinceId((Number) result[2] != null ? ((Number) result[2]).longValue() : null);
	                smallField.setDistrictId((Number) result[3] != null ? ((Number) result[3]).longValue() : null);
	                smallField.setWardId((Number) result[4] != null ? ((Number) result[4]).longValue() : null);
	                smallField.setFieldTypeId(((Number) result[5]).longValue());
	                smallField.setSmallFieldName((String) result[6]);
	                smallField.setFieldMoney((Number) result[7] != null ? ((Number) result[7]).longValue() : null);
	                smallField.setStatus((Number) result[8] != null ? ((Number) result[8]).longValue() : null);
	                smallField.setFieldType((String) result[9]);
	                smallField.setCreateby((String) result[10]);
	                smallField.setModifieldby((String) result[11]);
	                smallField.setCreatedDate((Date) result[12]);
	                smallField.setModifiedDate((Date) result[13]);

	                smallFields.add(smallField);
	            }

	            return smallFields;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	   @Override
	    public List<TblSmallField> getSmallFieldsByFieldTypeId(Long fieldId, Long fieldTypeId) {
	        Session session = this.getCurrentSession();
	        try {
	            String sql = "SELECT s.ID, s.FIELD_ID, s.PROVINCE_ID, s.DISTRICT_ID, s.WARD_ID, " +
	                         "s.FIELDTYPE_ID, s.SMALLFIELDNAME, s.FIELD_MONEY, s.STATUS, s.FIELDTYPE, " +
	                         "s.CREATEBY, s.MODIFIEDBY, s.CREATED_DATE, s.MODIFIED_DATE " +
	                         "FROM TBL_SMALL_FIELD s " +
	                         "WHERE s.FIELD_ID = :fieldId AND s.FIELDTYPE_ID = :fieldTypeId";

	            Query query = session.createNativeQuery(sql);
	            query.setParameter("fieldId", fieldId);
	            query.setParameter("fieldTypeId", fieldTypeId);

	            List<Object[]> results = query.getResultList();
	            List<TblSmallField> smallFields = new ArrayList<>();

	            for (Object[] result : results) {
	                TblSmallField smallField = new TblSmallField();
	                smallField.setId(((Number) result[0]).longValue());
	                smallField.setFieldId(((Number) result[1]).longValue());
	                smallField.setProvinceId((Number) result[2] != null ? ((Number) result[2]).longValue() : null);
	                smallField.setDistrictId((Number) result[3] != null ? ((Number) result[3]).longValue() : null);
	                smallField.setWardId((Number) result[4] != null ? ((Number) result[4]).longValue() : null);
	                smallField.setFieldTypeId(((Number) result[5]).longValue());
	                smallField.setSmallFieldName((String) result[6]);
	                smallField.setFieldMoney((Number) result[7] != null ? ((Number) result[7]).longValue() : null);
	                smallField.setStatus((Number) result[8] != null ? ((Number) result[8]).longValue() : null);
	                smallField.setFieldType((String) result[9]);
	                smallField.setCreateby((String) result[10]);
	                smallField.setModifieldby((String) result[11]);
	                smallField.setCreatedDate((Date) result[12]);
	                smallField.setModifiedDate((Date) result[13]);

	                smallFields.add(smallField);
	            }

	            return smallFields;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }


	@Override
	public TblSmallField findSmallFieldById(Long id) {
		TblSmallField result = null;
		try {
			Session session = this.getCurrentSession();
			String sql = "select u FROM TblSmallField u WHERE u.id =:id";
			Query query = session.createQuery(sql).setParameter("id", id);
			result = (TblSmallField) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
