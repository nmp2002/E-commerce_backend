package com.ttisv.service.system;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttisv.bean.system.TblNotification;
import com.ttisv.dao.system.TblNotificationDao;

@Service
@Transactional
public class TblNotificationServiceImpl implements TblNotificationService {
	@Autowired
	TblNotificationDao tblNotificationDao;
	@Override
	public TblNotification saveNotification(TblNotification notification) {
		// TODO Auto-generated method stub
		return tblNotificationDao.saveNotification(notification);
	}
	@Override
	public List<TblNotification> getNotification(Long fieldId) {
		// TODO Auto-generated method stub
		return tblNotificationDao.getNotification(fieldId);
	}

}
