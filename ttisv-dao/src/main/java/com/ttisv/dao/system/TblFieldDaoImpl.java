package com.ttisv.dao.system;


import java.util.Date;
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

import com.ttisv.bean.system.TblField;
import com.ttisv.common.utils.StringUtils;
import com.ttisv.dao.impl.BaseDaoImpl;
@Repository
public class TblFieldDaoImpl extends BaseDaoImpl<TblField> implements TblFieldDao{

	@Override
	public TblField findByFieldName(String fieldName) {
		TblField result = null;
		try {
			Session session = this.getCurrentSession();
			String sql = "select u FROM TblField u WHERE u.fieldName =:fieldName";
			Query query = session.createQuery(sql).setParameter("fieldName", fieldName);
			result = (TblField) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public TblField findById(Long id) {
		TblField result = null;
		try {
			Session session = this.getCurrentSession();
			String sql ="select u FROM TblField u WHERE u.id =:id";
			Query query = session.createQuery(sql).setParameter("id", id);
			result = (TblField) query.getSingleResult();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	@Override
	public Page<TblField> getListPageField(Pageable pageable, Map<String, String> map) {
	    Session session = this.getCurrentSession();
	    Page<TblField> rs = null;

	    try {
	        int pageSize = pageable.getPageSize();
	        int currentPage = pageable.getPageNumber();
	        int startItem = currentPage * pageSize;

	        String sql = "SELECT f FROM TblField f WHERE f.status <> '2'";

	        if (!StringUtils.isEmpty(map.get("provinceName"))) {
	            sql += " and lower(f.provinceName) like :provinceName ESCAPE '/'";
	        }
	        if (!StringUtils.isEmpty(map.get("districtName"))) {
	            sql += " and lower(f.districtName) like :districtName ESCAPE '/'";
	        }
	        if (!StringUtils.isEmpty(map.get("wardName"))) {
	            sql += " and lower(f.wardName) like :wardName ESCAPE '/'";
	        }
	        if (!StringUtils.isEmpty(map.get("fieldName"))) {
	            sql += " and lower(f.fieldName) like :fieldName ESCAPE '/'";
	        }
	        if (!StringUtils.isEmpty(map.get("phoneNumberField"))) {
	            sql += " and lower(f.phoneNumberField) like :phoneNumberField ESCAPE '/'";
	        }
	    	if (!StringUtils.isEmpty(map.get("status"))) {
				sql += " and f.status =:status";
			}

	        Query query = session.createQuery(sql, TblField.class);
	        query.setFirstResult(startItem);
	        query.setMaxResults(pageSize);

	        Set<Parameter<?>> params = query.getParameters();
	    	for (Parameter<?> parameter : params) {
				if (Objects.equals(parameter.getName(), "provinceName") || Objects.equals(parameter.getName(), "districtName")
						|| Objects.equals(parameter.getName(), "wardName")
						|| Objects.equals(parameter.getName(), "fieldName")
						|| Objects.equals(parameter.getName(), "phoneNumberField")
						)
				{
					query.setParameter(parameter.getName(),
							StringUtils.toLikeAndLowerCaseString(map.get(parameter.getName())));
				} else {
					query.setParameter(parameter.getName(), map.get(parameter.getName()));
				}
			}

	        List<TblField> lst = query.getResultList();
	        int count = this.countFields(map);  
	        rs = new PageImpl<>(lst, PageRequest.of(currentPage, pageSize), count);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rs;
	}
	
	public int countFields(Map<String, String> map) {
	    Session session = this.getCurrentSession();
	    int rs = 0;
	    try {
	        String sql = "SELECT COUNT(*) FROM TblField f WHERE f.status <> '2'";

	        if (!StringUtils.isEmpty(map.get("provinceName"))) {
	            sql += " and lower(f.provinceName) like :provinceName ESCAPE '/'";
	        }
	        if (!StringUtils.isEmpty(map.get("districtName"))) {
	            sql += " and lower(f.districtName) like :districtName ESCAPE '/'";
	        }
	        if (!StringUtils.isEmpty(map.get("wardName"))) {
	            sql += " and lower(f.wardName) like :wardName ESCAPE '/'";
	        }
	        if (!StringUtils.isEmpty(map.get("fieldName"))) {
	            sql += " and lower(f.fieldName) like :fieldName ESCAPE '/'";
	        }
	        if (!StringUtils.isEmpty(map.get("phoneNumberField"))) {
	            sql += " and lower(f.phoneNumberField) like :phoneNumberField ESCAPE '/'";
	        }

	    	if (!StringUtils.isEmpty(map.get("status"))) {
				sql += " and u.status =:status";
			}

	        Query query = session.createQuery(sql, Long.class);
	        Set<Parameter<?>> params = query.getParameters();
	    	for (Parameter<?> parameter : params) {
				if (Objects.equals(parameter.getName(), "provinceName") || Objects.equals(parameter.getName(), "districtName")
						|| Objects.equals(parameter.getName(), "wardName")
						|| Objects.equals(parameter.getName(), "fieldName")
						|| Objects.equals(parameter.getName(), "phoneNumberField")
						)
				{
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

	@Override
	public Boolean existsByFieldName(String fieldName) {
		int count = 0;
		try {
			Session session = this.getCurrentSession();
			String sql = "select count (*) FROM TBL_FIELD fg WHERE fieldName =:fieldName";
			Query q = session.createNativeQuery(sql).setParameter("fieldName", fieldName);
			count = ((Number) q.getSingleResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count > 0 ? true : false;
	}

	@Override
	public List<TblField> findbySupplierId(Long supplierId) {
	    List<TblField> result = null;
	    try {
	        Session session = this.getCurrentSession();
	        String sql = "SELECT f FROM TblField f, TblSupplier a, TblUser b " +
	                     "WHERE f.supplierId = a.supplierId AND b.userName = a.supplierNameLogin AND f.supplierId = :supplierId";
	        Query query = session.createQuery(sql).setParameter("supplierId", supplierId);
	        result = query.getResultList();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	@Override
	public TblField saveorUpdate(TblField field) {
	    Session session = this.getCurrentSession();
	    try {
	        if (field != null) {
	            if (field.getId() != null) {
	                // Check if the entity already exists
	                TblField existingField = session.get(TblField.class, field.getId());
	                if (existingField != null) {
	                    // Update the existing entity
	                    existingField.setFieldName(field.getFieldName());
	                    existingField.setProvinceName(field.getProvinceName());
	                    existingField.setDistrictName(field.getDistrictName());
	                    existingField.setWardName(field.getWardName());
	                    existingField.setProvinceid(field.getProvinceid());
	                    existingField.setDistrictId(field.getDistrictId());
	                    existingField.setWardId(field.getWardId());
	                    existingField.setPhoneNumberField(field.getPhoneNumberField());
	                    existingField.setDay(field.getDay());
	                    existingField.setFieldType(field.getFieldType());
	                    existingField.setSmallFieldCount(field.getSmallFieldCount());
	                    existingField.setTimeStart(field.getTimeStart());
	                    existingField.setTimeEnd(field.getTimeEnd());
	                    existingField.setAddress(field.getAddress());
	                    existingField.setImage(field.getImage());
	                    existingField.setSupplierName(field.getSupplierName());
	                    existingField.setSupplierId(field.getSupplierId());
	                    existingField.setStatus(1L);
	                    existingField.setModifiedDate(new Date());
	                    session.merge(existingField);
	                    return existingField;
	                } else {
	                    // Save as a new entity
	                    field.setCreatedDate(new Date());
	                    session.save(field);
	                    return field;
	                }
	            } else {
	                // Save as a new entity
	                field.setCreatedDate(new Date());
	                session.save(field);
	                return field;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	@Override
	public boolean existsById(Long id) {
		int count = 0;
		try {
			Session session = this.getCurrentSession();
			String sql = "select count (*) FROM TBL_FIELD fg WHERE id =:id";
			Query q = session.createNativeQuery(sql).setParameter("id", id);
			count = ((Number) q.getSingleResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count > 0 ? true : false;
	}
	   @Override
	    public long countActiveFields() {
	        Session session = this.getCurrentSession();
	        long count = 0;
	        try {
	            String sql = "SELECT COUNT(*) FROM TblField f WHERE f.status = '1'"; // Trạng thái '1' là hoạt động
	            Query query = session.createQuery(sql);
	            count = (Long) query.getSingleResult();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return count;
	    }

	    @Override
	    public long countInactiveFields() {
	        Session session = this.getCurrentSession();
	        long count = 0;
	        try {
	            String sql = "SELECT COUNT(*) FROM TblField f WHERE f.status = '2'"; // Trạng thái '2' là không hoạt động
	            Query query = session.createQuery(sql);
	            count = (Long) query.getSingleResult();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return count;
	    }
	    @Override
	    public Long countActiveSmallFields(Long fieldId) {
	        Session session = this.getCurrentSession();
	        try {
	            String sql = "SELECT COUNT(s.id) " +
	                         "FROM TblSmallField s " +
	                         "WHERE s.fieldId = :fieldId AND s.status = 1";

	            Query query = session.createQuery(sql);
	            query.setParameter("fieldId", fieldId);

	            return (Long) query.getSingleResult();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return 0L;
	    }
	    
	    @Override
	    public Long countMaintenanceSmallFields(Long fieldId) {
	        Session session = this.getCurrentSession();
	        try {
	            String sql = "SELECT COUNT(s.id) " +
	                         "FROM TblSmallField s " +
	                         "WHERE s.fieldId = :fieldId AND s.status = 2";

	            Query query = session.createQuery(sql);
	            query.setParameter("fieldId", fieldId);

	            return (Long) query.getSingleResult();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return 0L;
	    }

}
