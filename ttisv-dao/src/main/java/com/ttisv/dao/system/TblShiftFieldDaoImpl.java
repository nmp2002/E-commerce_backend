package com.ttisv.dao.system;

import java.math.BigDecimal;
import java.sql.Clob;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.Parameter;
import javax.persistence.Query;

import com.ttisv.bean.system.TblField;
import com.ttisv.bean.system.TblShiftField;
import com.ttisv.common.utils.StringUtils;
import com.ttisv.dao.impl.BaseDaoImpl;

@Repository
public class TblShiftFieldDaoImpl extends BaseDaoImpl<TblShiftField> implements TblShiftFieldDao {

    @Override
    public Page<TblShiftField> getListPageShiftField(Pageable pageable, Map<String, String> map) {
        Page<TblShiftField> rs = null;
        Session session = this.getCurrentSession();
        try {
            if (session != null && map != null && !map.isEmpty()) {
                int pageSize = pageable.getPageSize();
                int currentPage = pageable.getPageNumber();
                int startItem = currentPage * pageSize;
                int count = this.countShiftField(map);

                String sql = "FROM TblShiftField sf WHERE sf.statusField <> '2'";
                if (!StringUtils.isEmpty(map.get("day"))) {
                    sql += " and lower(sf.day) like :day ESCAPE '/'";
                }
                Query query = session.createQuery(sql, TblShiftField.class);
                query.setFirstResult(startItem);
                query.setMaxResults(pageSize);
                Set<Parameter<?>> params = query.getParameters();
                for (Parameter<?> parameter : params) {
                    if (Objects.equals(parameter.getName(), "day")) {
                        query.setParameter(parameter.getName(),
                                StringUtils.toLikeAndLowerCaseString(map.get(parameter.getName())));
                    }
                }

                List<TblShiftField> lst = query.getResultList();
                rs = new PageImpl<TblShiftField>(lst, PageRequest.of(currentPage, pageSize), count);
            } 
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return rs;
    }

    public int countShiftField(Map<String, String> map) {
        Session session = this.getCurrentSession();
        int rs = 0;
        try {
            if (session != null && map != null && !map.isEmpty()) {
                String sql = "SELECT COUNT(*) FROM TblShiftField sf WHERE sf.statusField <> '2'";
                if (!StringUtils.isEmpty(map.get("day"))) {
                    sql += " and lower(sf.day) like :day ESCAPE '/'";
                }
                Query query = session.createQuery(sql);
                Set<Parameter<?>> params = query.getParameters();
                for (Parameter<?> parameter : params) {
                    if (Objects.equals(parameter.getName(), "day")) {
                        query.setParameter(parameter.getName(),
                                StringUtils.toLikeAndLowerCaseString(map.get(parameter.getName())));
                    }
                }
                rs = ((Number) query.getSingleResult()).intValue();
            } else {
              
            }
        } catch (Exception e) {
            e.printStackTrace();
        
        }
        return rs;
    }
    


  

    @Override
    public boolean deleteShiftField(Long shiftFieldId) {
    	try {
        Session session = this.getCurrentSession();
        String sql = "DELETE FROM TBL_SHIFT_FIELD WHERE SHIFT_FIELD_ID = :shiftFieldId";
        Query query = session.createNativeQuery(sql).setParameter("shiftFieldId", shiftFieldId);
		query.executeUpdate();
		return true;
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

    @Override
	public TblShiftField saveorUpdate(TblShiftField shiftField) {
		Session session = this.getCurrentSession();
		try {
			if (shiftField != null) {
				if (shiftField.getId() != null) {
					// Check if the entity already exists
					TblShiftField existingShiftField = session.get(TblShiftField.class, shiftField.getId());
					if (existingShiftField != null) {
						// Update the existing entity
						existingShiftField.setFieldId(shiftField.getFieldId());
						existingShiftField.setShiftFieldName(shiftField.getShiftFieldName());
						existingShiftField.setCreatedBy(shiftField.getCreatedBy());
						existingShiftField.setCreatedDate(shiftField.getCreatedDate());
						existingShiftField.setModifiedDate(shiftField.getModifiedDate());
						existingShiftField.setModifiedBy(shiftField.getModifiedBy());
						existingShiftField.setTimeStart(shiftField.getTimeStart());
						existingShiftField.setTimeEnd(shiftField.getTimeEnd());
						existingShiftField.setAmountWeekday(shiftField.getAmountWeekday());
						existingShiftField.setAmountWeekend(shiftField.getAmountWeekend());
						existingShiftField.setDayOfWeek(shiftField.getDayOfWeek());
						existingShiftField.setDay(shiftField.getDay());
						existingShiftField.setStatusField(shiftField.getStatusField());
						existingShiftField.setFieldType(shiftField.getFieldType());
						session.merge(existingShiftField);
					} else {
						// Save as a new entity
						session.save(shiftField);
					}
				} else {
					// Save as a new entity
					session.save(shiftField);
				}
				session.flush(); // Ensure changes are persisted immediately
				return shiftField;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    
    @Override
    public List<TblShiftField> getShiftFieldsByFieldId(Long fieldId) {
        Session session = this.getCurrentSession();
        List<TblShiftField> result = null;
        try {
            if (session != null && fieldId != null) {
                String sql = "FROM TblShiftField sf WHERE sf.fieldId = :fieldId";
                Query query = session.createQuery(sql, TblShiftField.class);
                query.setParameter("fieldId", fieldId);
                result = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<TblShiftField> getShiftFieldsByFieldType(Long fieldId, String fieldType) {
        Session session = this.getCurrentSession();
        List<TblShiftField> result = null;
        try {
            if (session != null && fieldId != null && fieldType != null) {
                String sql = "FROM TblShiftField sf WHERE sf.fieldId = :fieldId AND sf.fieldType = :fieldType";
                Query query = session.createQuery(sql, TblShiftField.class);
                query.setParameter("fieldId", fieldId);
                query.setParameter("fieldType", fieldType);
                result = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

	@Override
	public TblShiftField findById(Long id) {
		TblShiftField result = null;
		try {
			Session session = this.getCurrentSession();
			String sql ="select u FROM TblShiftField u WHERE u.id =:id";
			Query query = session.createQuery(sql).setParameter("id", id);
			result = (TblShiftField) query.getSingleResult();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Boolean existingByShiftFieldName(Long shiftFieldName, Long fieldId) {
	    int count = 0;
	    try {
	        Session session = this.getCurrentSession();
	        String sql = "SELECT COUNT(*) FROM TBL_SHIFT_FIELD fg WHERE fg.shiftFieldName = :shiftFieldName AND fg.FIELD_ID = :fieldId";
	        Query q = session.createNativeQuery(sql)
	                         .setParameter("shiftFieldName", shiftFieldName)
	                         .setParameter("fieldId", fieldId);
	        count = ((Number) q.getSingleResult()).intValue();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return count > 0 ? true :false;
	}

}
