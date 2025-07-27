package com.ttisv.service.system;

import java.util.List;

import com.ttisv.bean.system.TblNotification;

public interface TblNotificationService {
	TblNotification saveNotification(TblNotification notification);
	List<TblNotification> getNotification(Long fieldId);
}
