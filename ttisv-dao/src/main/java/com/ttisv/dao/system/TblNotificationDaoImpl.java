package com.ttisv.dao.system;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;


import com.ttisv.bean.system.TblNotification;

import com.ttisv.dao.impl.BaseDaoImpl;
@Repository
public class TblNotificationDaoImpl extends BaseDaoImpl<TblNotification> implements TblNotificationDao {

	@Override
	public TblNotification saveNotification(TblNotification notification) {
	    Session session = this.getCurrentSession();
	    try {
	        if (notification != null) {
	            if (notification.getId() != null) {
	                // Kiểm tra xem entity đã tồn tại hay chưa
	                TblNotification existingNotification = session.get(TblNotification.class, notification.getId());
	                if (existingNotification != null) {
	                    // Cập nhật entity đã tồn tại
	                    existingNotification.setMessage(notification.getMessage());
	                    existingNotification.setStatus(notification.getStatus());
	                    existingNotification.setCreateby(notification.getCreateby());
	                    existingNotification.setModifieldby(notification.getModifieldby());
	                    existingNotification.setModifiedDate(new Date());
	                    session.merge(existingNotification);
	                    return existingNotification;
	                } else {
	                    // Lưu như là entity mới
	                    notification.setCreatedDate(new Date());
	                    session.save(notification);
	                    return notification;
	                }
	            } else {
	                // Lưu như là entity mới
	                notification.setCreatedDate(new Date());
	                session.save(notification);
	                return notification;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	@Override
	public List<TblNotification> getNotification(Long fieldId) {
	       Session session = this.getCurrentSession();
	        List<TblNotification> result = null;
	        try {
	            if (session != null && fieldId != null) {
	                String sql = "FROM TblNotification sf WHERE sf.fieldId = :fieldId";
	                Query query = session.createQuery(sql, TblNotification.class);
	                query.setParameter("fieldId", fieldId);
	                result = query.getResultList();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result;
	    }



}
