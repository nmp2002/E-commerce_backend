package com.ttisv.dao.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ttisv.bean.system.TblFieldType;
import com.ttisv.bean.system.TblUser;
import com.ttisv.dao.impl.BaseDaoImpl;

@Repository
public class TblFieldTypeDaoImpl extends BaseDaoImpl<TblFieldType> implements TblFieldTypeDao {

    @Override
    public TblFieldType saveorUpdate(Long fieldId, String fieldTypeName, Long totalNumberField) {
        Session session = this.getCurrentSession();
        
        TblFieldType fieldType = findByFieldIdAndTypeName(fieldId, fieldTypeName);
        if (fieldType == null) {
            fieldType = new TblFieldType();
            fieldType.setFieldId(fieldId);
            fieldType.setFieldTypeName(fieldTypeName);
            fieldType.setTotalNumberField(totalNumberField);
            save(fieldType); 
        } else {
            fieldType.setTotalNumberField(totalNumberField);
            update(fieldType);
        }

        return fieldType;
    }


    
    public TblFieldType findByFieldIdAndTypeName(Long fieldId, String fieldTypeName) {
        TblFieldType result = null;
        try {
            Session session = this.getCurrentSession();
            String sql = "select u FROM TblFieldType u WHERE u.fieldId = :fieldId AND u.fieldTypeName = :fieldTypeName";
            Query query = session.createQuery(sql)
                                 .setParameter("fieldId", fieldId)
                                 .setParameter("fieldTypeName", fieldTypeName);
            result = (TblFieldType) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public List<TblFieldType> findbyFieldId(Long fieldId) {
        Session session = this.getCurrentSession();
        try {
            String sql = "SELECT t.FIELDTYPEID, t.FIELDID, t.CREATED_DATE, t.CREATEDBY, t.MODIFIED_DATE, " +
                         "t.MODIFIEDBY, t.TOTALNUMBERFIELD, t.FIELDMONEY, t.FIELDTYPENAME " +
                         "FROM TBL_FIELD_TYPE t " +
                         "WHERE t.FIELDID = :fieldId";

            Query query = session.createNativeQuery(sql);
            query.setParameter("fieldId", fieldId);

            List<Object[]> results = query.getResultList();
            List<TblFieldType> fieldTypes = new ArrayList<>();

            for (Object[] result : results) {
                TblFieldType fieldType = new TblFieldType();
                fieldType.setFieldTypeId(((Number) result[0]).longValue());
                fieldType.setFieldId(((Number) result[1]).longValue());
                fieldType.setCreatedDate((Date) result[2]);
                fieldType.setCreatedBy((String) result[3]);
                fieldType.setModifiedDate((Date) result[4]);
                fieldType.setModifiedBy((String) result[5]);
                fieldType.setTotalNumberField((Number) result[6] != null ? ((Number) result[6]).longValue() : null);
                fieldType.setFieldMoney((String) result[7]);
                fieldType.setFieldTypeName((String) result[8]);

                fieldTypes.add(fieldType);
            }

            return fieldTypes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

 
}
