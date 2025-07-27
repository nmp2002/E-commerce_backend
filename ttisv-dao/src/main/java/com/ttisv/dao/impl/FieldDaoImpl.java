package com.ttisv.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ttisv.bean.Field;
import com.ttisv.dao.FieldDao;

@Repository
public class FieldDaoImpl extends BaseDaoImpl<Field> implements FieldDao{

	@Override
	public Field findByFieldName(String fieldName) {
		Field rs = null;
		Session session = this.getCurrentSession();
		try {
			Query query = session.createQuery("SELECT fg FROM Field fg WHERE fieldName =:fieldName", Field.class);
			query.setParameter("fieldName", fieldName);

			List<Field> lst = query.getResultList();
			if (lst != null && lst.size() > 0) {
				return lst.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public Field findById(Integer id) {
		// TODO Auto-generated method stub
		
		Field rs = null;
	    Session session = this.getCurrentSession();
	    try {
	        rs = session.get(Field.class, id);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return rs;
	}

	@Override
    public Field addField(Field field) {
        Session session = getCurrentSession();
        try {
            session.save(field);
            return field;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public boolean deleteField(Integer id) {
	    Session session = getCurrentSession();
	    try {
	        Field fieldToDelete = session.load(Field.class, id);
	        if (fieldToDelete != null) {
	            session.delete(fieldToDelete);
	            return true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	@Override
	public Field updateField(Field field) {
	    Session session = getCurrentSession();
	    try {
	        session.update(field);
	        return field;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

}



