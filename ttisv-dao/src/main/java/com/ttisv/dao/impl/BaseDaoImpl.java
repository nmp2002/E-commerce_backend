package com.ttisv.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttisv.dao.BaseDao;

@Repository("baseDao")
@SuppressWarnings("all")
public class BaseDaoImpl<T> implements BaseDao<T> {

	private SessionFactory sessionFactory;
	private Class<T> clz;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	private Class<T> getClz() {
		if (clz == null) {
			// 获取泛型的Class对象
			clz = ((Class<T>) (((ParameterizedType) (this.getClass().getGenericSuperclass()))
					.getActualTypeArguments()[0]));
		}
		return clz;
	}

	public Serializable save(T o) {

		return this.getCurrentSession().save(o);
	}

	public void saveBatch(List<T> list) {
		for (T instance : list) {
			this.getCurrentSession().save(instance);
		}
		this.getCurrentSession().flush();
		// JpaGeneralDao.saveBatch(entityManager, list);
	}

	public T saveOrUpdate(T o) {
		this.getCurrentSession().saveOrUpdate(o);

		this.getCurrentSession().flush();
		return o;
	}

	public void update(T o) {
		this.getCurrentSession().update(o);
		this.getCurrentSession().flush();
	}

	public void delete(T o) {
		this.getCurrentSession().delete(o);
	}

	public void delete(Serializable id) {
		T o = this.get(id);
		this.getCurrentSession().delete(o);
	}

	public T get(Serializable id) {
		return (T) this.getCurrentSession().get(getClz(), id);
	}

	public List<T> find(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		return q.list();
	}

	public List<T> find(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.list();
	}

	public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	public List<T> find(String hql, int page, int rows) {
		Query q = this.getCurrentSession().createQuery(hql);
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	public Integer count(String hql) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		List cc = q.list();
		Long a = (Long) cc.get(0);
		return a.intValue();
	}

	public Integer count(String hql, Integer id) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setParameter(0, id);
		List cc = q.list();
		Long a = (Long) cc.get(0);
		return a.intValue();
	}

	public Integer count(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return Integer.valueOf(String.valueOf(q.uniqueResult()));
	}

	public int executeHql(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		return q.executeUpdate();
	}

	public int executeHql(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.executeUpdate();
	}

	public Integer findByUid(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer findTicketByCid(Integer cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void merge(T o) {
		this.getCurrentSession().merge(o);
	}

	@Override
	public long getSeq(String seqName) {
		long seq = 0;
		try {
			Session session = this.getCurrentSession();
			String sql = "SELECT " + seqName + ".NEXTVAL  FROM dual ";
			Query qCount = session.createNativeQuery(sql);
	
			seq = ((BigDecimal) qCount.getSingleResult()).longValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return seq;

	}

	@Override
	public void updateBatch(List<?> list) {
		list.forEach(e -> this.getCurrentSession().saveOrUpdate(e));
		this.getCurrentSession().flush();
	}
}

