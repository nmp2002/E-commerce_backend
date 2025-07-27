package com.ttisv.dao.system;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ttisv.bean.system.TblBooking;
import com.ttisv.bean.system.TblRevenue;
import com.ttisv.dao.BaseDao;

public interface TblBookingDao extends BaseDao<TblBooking>{
	public Page<TblBooking> getListPageBooking(Pageable pageable, Map<String, String> map);
	List<TblBooking> getBookingbySmallFieldId(Long smallFieldId);
	List<TblBooking> getBookingbyFieldId(Long fieldId);
	TblBooking getBookingById(Long bookingId);
	Boolean deleteBooking(Long bookingId);
	List<TblRevenue> getWeeklyRevenueByFieldId(Long fieldId);
	List<TblRevenue> getMonthlyRevenueByFieldId(Long fieldId);
	Boolean checkBookingExistence(Long smallFieldId, String timeStart, Date day);
	long countBookingsToday(Long fieldId);
	long calculateRevenueToday(Long fieldId);
}
