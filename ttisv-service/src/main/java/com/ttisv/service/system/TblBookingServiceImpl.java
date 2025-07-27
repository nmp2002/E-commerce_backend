package com.ttisv.service.system;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ttisv.bean.system.TblBooking;
import com.ttisv.bean.system.TblRevenue;
import com.ttisv.dao.system.TblBookingDao;

@Service
@Transactional
public class TblBookingServiceImpl implements TblBookingService{
	
	@Autowired
	TblBookingDao tblBookingDao;
	@Override
	public TblBooking saveOrUpdate(TblBooking booking) {
		// TODO Auto-generated method stub
		return tblBookingDao.saveOrUpdate(booking);
	}
	@Override
	public Page<TblBooking> getListPageBooking(Pageable pageable, Map<String, String> map) {
		// TODO Auto-generated method stub
		return tblBookingDao.getListPageBooking(pageable, map);
	}
	@Override
	public List<TblBooking> getBookingbySmallFieldId(Long smallFieldId) {
		// TODO Auto-generated method stub
		return tblBookingDao.getBookingbySmallFieldId(smallFieldId);
	}
	@Override
	public TblBooking getBookingById(Long bookingId) {
		// TODO Auto-generated method stub
		return tblBookingDao.getBookingById(bookingId);
	}
	@Override
	public TblBooking updateStatusPayment(Long bookingId, String booked) {
		// TODO Auto-generated method stub
		try {
			TblBooking booking = tblBookingDao.getBookingById(bookingId);
			booking.setStatusField(booked);
			booking.setModifiedDate(new Date());
			tblBookingDao.saveOrUpdate(booking);
			return booking;
			
		}  catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
		}
	@Override
	public Boolean deleteBooking(Long bookingId) {
		// TODO Auto-generated method stub
		return tblBookingDao.deleteBooking(bookingId);
	}
	@Override
	public List<TblRevenue> getWeeklyRevenueByFieldId(Long fieldId) {
		// TODO Auto-generated method stub
		return tblBookingDao.getWeeklyRevenueByFieldId(fieldId);
	}
	@Override
	public List<TblRevenue> getMonthlyRevenueByFieldId(Long fieldId) {
		// TODO Auto-generated method stub
		return tblBookingDao.getMonthlyRevenueByFieldId(fieldId);
	}
	@Override
	public List<TblBooking> getBookingbyFieldId(Long fieldId) {
		// TODO Auto-generated method stub
		return tblBookingDao.getBookingbyFieldId(fieldId);
	}
	@Override
	public Boolean checkBookingExistence(Long smallFieldId, String timeStart, Date day) {
		// TODO Auto-generated method stub
		return tblBookingDao.checkBookingExistence(smallFieldId,timeStart,day);
	}
	@Override
	public long countBookingsToday(Long fieldId) {
		// TODO Auto-generated method stub
		return tblBookingDao.countBookingsToday(fieldId);
	}
	@Override
	public long calculateRevenueToday(Long fieldId) {
		// TODO Auto-generated method stub
		return tblBookingDao.calculateRevenueToday(fieldId);
	}
}
