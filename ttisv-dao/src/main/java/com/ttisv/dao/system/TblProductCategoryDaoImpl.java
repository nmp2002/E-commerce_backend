package com.ttisv.dao.system;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ttisv.bean.system.TblProductCategory;
import com.ttisv.dao.impl.BaseDaoImpl;
@Repository
public class TblProductCategoryDaoImpl extends BaseDaoImpl<TblProductCategory> implements TblProductCategoryDao {
	   @Override
	    public TblProductCategory save(TblProductCategory category) {
	        try {
	            Session session = this.getCurrentSession();
	            session.save(category);
	            return category;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    @Override
	    public TblProductCategory updates(TblProductCategory category) {
	        try {
	            Session session = this.getCurrentSession();
	            session.update(category);
	            return category;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    @Override
	    public boolean delete(Long id) {
	        try {
	            Session session = this.getCurrentSession();
	            TblProductCategory category = session.find(TblProductCategory.class, id);
	            if (category != null) {
	                session.delete(category);
	                return true;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    @Override
	    public TblProductCategory findById(Long id) {
	        try {
	            Session session = this.getCurrentSession();
	            String hql = "SELECT c FROM TblProductCategory c WHERE c.id = :id";
	            Query query = session.createQuery(hql)
	                                 .setParameter("id", id);
	            return (TblProductCategory) query.getSingleResult();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    @Override
	    public List<TblProductCategory> findAll() {
	        try {
	            Session session = this.getCurrentSession();
	            String hql = "FROM TblProductCategory ORDER BY createdDate DESC";
	            Query query = session.createQuery(hql);
	            return query.getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    @Override
	    public List<TblProductCategory> findByName(String name) {
	        try {
	            Session session = this.getCurrentSession();
	            String hql = "FROM TblProductCategory WHERE LOWER(categoryName) LIKE :name";
	            Query query = session.createQuery(hql)
	                                 .setParameter("name", "%" + name.toLowerCase() + "%");
	            return query.getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
}
