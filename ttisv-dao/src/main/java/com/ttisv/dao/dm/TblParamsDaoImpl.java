package com.ttisv.dao.dm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Parameter;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.ttisv.bean.dm.ObjCbb;
import com.ttisv.bean.dm.TblParam;
import com.ttisv.common.utils.StringUtils;
import com.ttisv.dao.impl.BaseDaoImpl;

@Repository
public class TblParamsDaoImpl extends BaseDaoImpl<TblParam> implements TblParamsDao {
	@SuppressWarnings("unchecked")
	@Override
	public Page<TblParam> getListPageParam(Pageable pageable, Map<String, String> map) {
		Page<TblParam> rs = null;

		Session session = this.getCurrentSession();
		try {
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			int count = this.countParam(map);
			String sql = "SELECT u FROM TblParam u WHERE  1 = 1";
			if (!StringUtils.isEmpty(map.get("paramcode"))) {
				sql += " and lower(u.paramcode) like :paramcode ESCAPE '/'";
			}
			if (!StringUtils.isEmpty(map.get("paramname"))) {
				sql += " and lower(u.paramname) like :paramname ESCAPE '/'";
			}
			if (!StringUtils.isEmpty(map.get("status"))) {
				sql += " and u.status = :status";
			}
			Query query = session.createQuery(sql, TblParam.class);
			query.setFirstResult(startItem);
			query.setMaxResults(pageSize);
			Set<Parameter<?>> params = query.getParameters();
			for (Parameter<?> parameter : params) {
				if (Objects.equals(parameter.getName(), "paramcode")
						|| Objects.equals(parameter.getName(), "paramname")) {
					query.setParameter(parameter.getName(),
							StringUtils.toLikeAndLowerCaseString(map.get(parameter.getName())));
				} else {
					query.setParameter(parameter.getName(), map.get(parameter.getName()));
				}
			}
			List<TblParam> lst = query.getResultList();

			rs = new PageImpl<TblParam>(lst, PageRequest.of(currentPage, pageSize), count);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	public int countParam(Map<String, String> map) {
		Session session = this.getCurrentSession();
		int rs = 0;
		try {
			String sql = "SELECT COUNT(*) FROM TblParam u WHERE 1 = 1 ";
			if (!StringUtils.isEmpty(map.get("paramcode"))) {
				sql += " and lower(u.paramcode) like :paramcode ESCAPE '/'";
			}
			if (!StringUtils.isEmpty(map.get("paramname"))) {
				sql += " and lower(u.paramname) like :paramname ESCAPE '/'";
			}
			if (!StringUtils.isEmpty(map.get("status"))) {
				sql += " and u.status = :status";
			}
			Query query = session.createQuery(sql);
			Set<Parameter<?>> params = query.getParameters();
			for (Parameter<?> parameter : params) {
				if (Objects.equals(parameter.getName(), "paramcode")
						|| Objects.equals(parameter.getName(), "paramname")) {
					query.setParameter(parameter.getName(),
							StringUtils.toLikeAndLowerCaseString(map.get(parameter.getName())));
				} else {
					query.setParameter(parameter.getName(), map.get(parameter.getName()));
				}
			}
			rs = Integer.valueOf(String.valueOf(query.getSingleResult()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TblParam getParamById(Long id) {
		TblParam rs = null;
		Session session = this.getCurrentSession();
		try {
			Query query = session.createQuery("SELECT fg FROM TblParam fg WHERE id = :id", TblParam.class);
			query.setParameter("id", id);
			List<TblParam> lst = query.getResultList();
			if (lst != null && lst.size() > 0) {
				return lst.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TblParam getParamByCode(String paramcode) {
		TblParam rs = null;
		Session session = this.getCurrentSession();
		try {
			Query query = session.createQuery("SELECT fg FROM TblParam fg WHERE paramcode = :paramcode",
					TblParam.class);
			query.setParameter("paramcode", paramcode);
			List<TblParam> lst = query.getResultList();
			if (lst != null && lst.size() > 0) {
				return lst.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ObjCbb> getParamCbb(String paramgroup, String type) {
		Session session = this.getCurrentSession();
		List<ObjCbb> lstObjCbb = new ArrayList<ObjCbb>();
		try {
			String sql = "SELECT value, paramname FROM  TTI_Param where status ='01' and paramgroup =:paramgroup and type =:type order by sort ";
			Query query = session.createNativeQuery(sql);
			query.setParameter("paramgroup", paramgroup);
			query.setParameter("type", type);
			List<Object[]> lst = query.getResultList();
			if (!lst.isEmpty()) {
				for (Object[] ob : lst) {
					ObjCbb objCbb = new ObjCbb();
					objCbb.setKey(String.valueOf(ob[0]));
					objCbb.setValue(String.valueOf(ob[1]));
					lstObjCbb.add(objCbb);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstObjCbb;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TblParam> getParams() {
		List<TblParam> rs = null;
		Session session = this.getCurrentSession();
		try {
			Query query = session.createQuery("SELECT fg FROM TblParam fg WHERE status ='1'", TblParam.class);
			List<TblParam> lst = query.getResultList();
			if (lst != null && lst.size() > 0) {
				return lst;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public boolean existsByParamcode(String paramcode, Long ignoreId) {
		int count = 0;
		try {
			Session session = this.getCurrentSession();
			String sql = "SELECT COUNT(*) FROM TBL_PARAMS t WHERE t.PARAMCODE = :paramcode";
			if (ignoreId != null) {
				sql += " AND t.ID <> :ignoreId";
			}
			Query q = session.createNativeQuery(sql).setParameter("paramcode", paramcode);
			if (ignoreId != null) {
				q.setParameter("ignoreId", ignoreId);
			}
			count = ((Number) q.getSingleResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return count > 0 ? true : false;
	}
}
