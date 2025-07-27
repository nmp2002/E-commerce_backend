package com.ttisv.dao.system;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ttisv.bean.system.TblBooking;
import com.ttisv.bean.system.TblCity;
import com.ttisv.bean.system.TblSmallField;
import com.ttisv.bean.system.TblSupplier;
import com.ttisv.dao.impl.BaseDaoImpl;
@Repository
public class TblSupplierDaoImpl extends BaseDaoImpl<TblSupplier> implements TblSupplierDao{
	 @PersistenceContext
	   private EntityManager entityManager;

	@Override
	public List<TblSupplier> getListSupplier(Map<String, String> map) {
		Session session = this.getCurrentSession();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM TBL_SUPPLIER t");
			Query query = session.createNativeQuery(sql.toString(), TblSupplier.class);
			List<TblSupplier> lst = query.getResultList();
			return lst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	 @Override
	    public TblSupplier findByUserId(Long userId) {
	        TypedQuery<TblSupplier> query = entityManager.createQuery(
	            "SELECT s FROM TblSupplier s WHERE s.userId = :userId", TblSupplier.class);
	        query.setParameter("userId", userId);
	        return query.getResultStream().findFirst().orElse(null);
	    }
	 @Override
	    public TblSupplier saveorUpdate(Long supplierId, String supplierName,String supplierNameLogin) {
	        Session session = this.getCurrentSession();
	        TblSupplier supplier = session.get(TblSupplier.class, supplierId);
	        if (supplier != null) {
	            // Update the existing entity
	            supplier.setSupplierName(supplierName);
	            supplier.setSupplierNameLogin(supplierNameLogin);
	            session.merge(supplier);
	        } else {
	            // Create a new entity
	            supplier = new TblSupplier();
	            supplier.setSupplierId(supplierId);
	            supplier.setSupplierName(supplierName);
	            supplier.setSupplierNameLogin(supplierNameLogin);
	            session.save(supplier);
	        }
	        return supplier;
	    }

	@Override
	 public TblSupplier saveFieldId(Long supplierId, String fieldId) {
	     Session session = this.getCurrentSession();
	     TblSupplier supplier = session.get(TblSupplier.class, supplierId);
	     if (supplier != null) {
	         String existingFieldIds = supplier.getFieldId();
	         if (existingFieldIds != null && !existingFieldIds.isEmpty()) {
	             supplier.setFieldId(existingFieldIds + "," + fieldId);
	         } else {
	             supplier.setFieldId(fieldId);
	         }
	         session.merge(supplier);
	         return supplier;
	     }
	     return null;
	 }

	
	  @Override
	    public TblSupplier findBySupplierNameLogin(String supplierNameLogin) {
	        TypedQuery<TblSupplier> query = entityManager.createQuery(
	            "SELECT s FROM TblSupplier s WHERE s.supplierNameLogin = :supplierNameLogin", TblSupplier.class);
	        query.setParameter("supplierNameLogin", supplierNameLogin);
	        return query.getResultStream().findFirst().orElse(null);
	    }

	  @Override
	  public List<TblSupplier> getSuppliersByFieldId(Long fieldId) {
	      List<TblSupplier> result = new ArrayList<>();
	      try {
	          Session session = this.getCurrentSession();
	          String sql = "SELECT u FROM TblSupplier u WHERE REGEXP_LIKE(u.fieldId, :fieldIdPattern)";
	          Query query = session.createQuery(sql)
	                               .setParameter("fieldIdPattern", "(^|,)" + fieldId + "(,|$)");

	          result = query.getResultList();
	      } catch (Exception e) {
	          e.printStackTrace();
	      }
	      return result;
	  }



	
}
