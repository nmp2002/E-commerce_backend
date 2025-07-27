package com.ttisv.dao.system;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ttisv.bean.system.TblProductAttribute;
import com.ttisv.dao.impl.BaseDaoImpl;
@Repository
public class TblProductAttributeDaoImpl extends BaseDaoImpl<TblProductAttribute> implements TblProductAttributeDao {
	   @Override
	    public TblProductAttribute save(TblProductAttribute attribute) {
	        try {
	            Session session = this.getCurrentSession();
	            session.save(attribute);
	            return attribute;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    @Override
	    public TblProductAttribute updates(TblProductAttribute attribute) {
	        try {
	            Session session = this.getCurrentSession();
	            session.update(attribute);
	            return attribute;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    @Override
	    public boolean delete(Long id) {
	        try {
	            Session session = this.getCurrentSession();
	            TblProductAttribute attr = session.find(TblProductAttribute.class, id);
	            if (attr != null) {
	                session.delete(attr);
	                return true;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    @Override
	    public TblProductAttribute findById(Long id) {
	        try {
	            Session session = this.getCurrentSession();
	            String hql = "SELECT a FROM TblProductAttribute a WHERE a.id = :id";
	            Query query = session.createQuery(hql);
	            query.setParameter("id", id);
	            return (TblProductAttribute) query.getSingleResult();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }


	    @Override
	    public List<TblProductAttribute> findAll() {
	        try {
	            Session session = this.getCurrentSession();
	            String hql = "FROM TblProductAttribute ORDER BY createdDate DESC";
	            Query query = session.createQuery(hql);
	            return query.getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    @Override
	    public List<TblProductAttribute> findByProductId(Long productId) {
	        String hql = "FROM TblProductAttribute WHERE productId = :productId";
	        TypedQuery<TblProductAttribute> query = getCurrentSession().createQuery(hql, TblProductAttribute.class);
	        query.setParameter("productId", productId);
	        return query.getResultList();
	    }

}
