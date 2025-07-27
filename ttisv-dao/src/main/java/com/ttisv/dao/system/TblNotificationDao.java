package com.ttisv.dao.system;


import java.util.List;

import com.ttisv.bean.system.TblNotification;
import com.ttisv.dao.BaseDao;

public interface TblNotificationDao extends BaseDao<TblNotification>{
	TblNotification saveNotification(TblNotification notification);
	List<TblNotification> getNotification(Long fieldId);
}
