package com.ttisv.service.system;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ttisv.bean.system.TblBooking;
import com.ttisv.bean.system.TblRevenue;

public interface TblBookingService {
	TblBooking saveOrUpdate(TblBooking booking);
	Page<TblBooking> getListPageBooking(Pageable pageable, Map<String, String> map);
	List<TblBooking> getBookingbySmallFieldId(Long smallFieldId);
	 TblBooking getBookingById(Long bookingId);
	 TblBooking updateStatusPayment(Long bookingId,String booked);
	 Boolean deleteBooking(Long bookingId);
	 List<TblRevenue> getWeeklyRevenueByFieldId(Long fieldId);
	 List<TblRevenue> getMonthlyRevenueByFieldId(Long fieldId);
	 List<TblBooking> getBookingbyFieldId(Long fieldId);
	 Boolean checkBookingExistence(Long smallFieldId, String timeStart, Date day);
	 long countBookingsToday(Long fieldId);
	 long calculateRevenueToday(Long fieldId);
}
