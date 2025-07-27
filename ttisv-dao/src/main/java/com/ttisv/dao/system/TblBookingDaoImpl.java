package com.ttisv.dao.system;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Repository;

import com.ttisv.bean.system.TblBooking;
import com.ttisv.bean.system.TblRevenue;
import com.ttisv.common.utils.StringUtils;
import com.ttisv.dao.impl.BaseDaoImpl;

@Repository
public class TblBookingDaoImpl extends BaseDaoImpl<TblBooking> implements TblBookingDao {

    @Override
    public Page<TblBooking> getListPageBooking(Pageable pageable, Map<String, String> map) {
        Session session = this.getCurrentSession();
        Page<TblBooking> rs = null;
        try {
            int pageSize = pageable.getPageSize();
            int currentPage = pageable.getPageNumber();
            int startItem = currentPage * pageSize;

            String sql = "SELECT f FROM TblBooking f WHERE 1=1";

            if (!StringUtils.isEmpty(map.get("nameField"))) {
                sql += " and lower(f.nameField) like :nameField ESCAPE '/'";
            }
            if (!StringUtils.isEmpty(map.get("smallFieldName"))) {
                sql += " and lower(f.smallFieldName) like :smallFieldName ESCAPE '/'";
            }
            if (!StringUtils.isEmpty(map.get("nameGuest"))) {
                sql += " and lower(f.nameGuest) like :nameGuest ESCAPE '/'";
            }
            if (!StringUtils.isEmpty(map.get("phoneNumberGuest"))) {
                sql += " and lower(f.phoneNumberGuest) like :phoneNumberGuest ESCAPE '/'";
            }
            if (!StringUtils.isEmpty(map.get("totalPayment"))) {
                sql += " and lower(f.totalPayment) like :totalPayment ESCAPE '/'";
            }
            if (!StringUtils.isEmpty(map.get("day"))) {
                try {
                    // Định dạng đầu vào từ chuỗi có múi giờ
                    SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                    Date dayDate = inputFormat.parse(map.get("day")); // Chuyển chuỗi thành Date

                    // Dùng `TRUNC(f.day) = :day` để so sánh DATE mà không cần TO_DATE
                    sql += " and TRUNC(f.day) = :day";

                } catch (ParseException e) {
                    e.printStackTrace(); // Log lỗi nếu chuyển đổi thất bại
                }
            }



            if (!StringUtils.isEmpty(map.get("timeStart"))) {
                sql += " and lower(f.timeStart) like :timeStart ESCAPE '/'";
            }
            if (!StringUtils.isEmpty(map.get("timeEnd"))) {
                sql += " and lower(f.timeEnd) like :timeEnd ESCAPE '/'";
            }
            if (!StringUtils.isEmpty(map.get("paymentStatus"))) {
                sql += " and lower(f.paymentStatus) like :paymentStatus ESCAPE '/'";
            }
            if (!StringUtils.isEmpty(map.get("statusField"))) {
                sql += " and lower(f.statusField) like :statusField ESCAPE '/'";
            }

            Query query = session.createQuery(sql, TblBooking.class);
            query.setFirstResult(startItem);
            query.setMaxResults(pageSize);

            Set<Parameter<?>> params = query.getParameters();
            for (Parameter<?> parameter : params) {
                if (Objects.equals(parameter.getName(), "nameField") 
                        || Objects.equals(parameter.getName(), "smallFieldName")  
                        || Objects.equals(parameter.getName(), "nameGuest")
                        || Objects.equals(parameter.getName(), "phoneNumberGuest")
                        || Objects.equals(parameter.getName(), "totalPayment")
                        || Objects.equals(parameter.getName(), "day")
                        || Objects.equals(parameter.getName(), "timeStart")
                        || Objects.equals(parameter.getName(), "timeEnd")
                        || Objects.equals(parameter.getName(), "paymentStatus")) {
                    
                    // Kiểm tra xem có phải là trường "day", nếu có thì truyền đối tượng Date
                    if (parameter.getName().equals("day")) {
                        String dayString = map.get("day");
                        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
                        try {
                            Date dayDate = sdf.parse(dayString);
                            query.setParameter(parameter.getName(), dayDate); // Truyền Date vào tham số
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    } else {
                        query.setParameter(parameter.getName(), 
                            StringUtils.toLikeAndLowerCaseString(map.get(parameter.getName())));
                    }
                } else {
                    query.setParameter(parameter.getName(), map.get(parameter.getName()));
                }
            }

            List<TblBooking> lst = query.getResultList();
            int count = this.countBookings(map);  
            rs = new PageImpl<>(lst, PageRequest.of(currentPage, pageSize), count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }



	public int countBookings(Map<String, String> map) {
	    Session session = this.getCurrentSession();
	    int rs = 0;
	    try {
	        String sql = "SELECT COUNT(*) FROM TblBooking f WHERE 1=1";


	        if (!StringUtils.isEmpty(map.get("nameField"))) {
	            sql += " and lower(f.nameField) like :nameField ESCAPE '/'";
	        }
	        if (!StringUtils.isEmpty(map.get("smallFieldName"))) {
	            sql += " and lower(f.smallFieldName) like :smallFieldName ESCAPE '/'";
	        }
	        if (!StringUtils.isEmpty(map.get("nameGuest"))) {
	            sql += " and lower(f.nameGuest) like :nameGuest ESCAPE '/'";
	        }
	        if (!StringUtils.isEmpty(map.get("phoneNumberGuest"))) {
	            sql += " and lower(f.phoneNumberGuest) like :phoneNumberGuest ESCAPE '/'";
	        }
	        if (!StringUtils.isEmpty(map.get("totalPayment"))) {
	            sql += " and lower(f.totalPayment) like :totalPayment ESCAPE '/'";
	        }
	        if (!StringUtils.isEmpty(map.get("day"))) {
	            sql += " and lower(f.day) like :day ESCAPE '/'";
	        }
	        if (!StringUtils.isEmpty(map.get("timeStart"))) {
	            sql += " and lower(f.timeStart) like :timeStart ESCAPE '/'";
	        }
	        if (!StringUtils.isEmpty(map.get("timeEnd"))) {
	            sql += " and lower(f.timeEnd) like :timeEnd ESCAPE '/'";
	        }
	        if (!StringUtils.isEmpty(map.get("paymentStatus"))) {
	            sql += " and lower(f.paymentStatus) like :paymentStatus ESCAPE '/'";
	        }


	        Query query = session.createQuery(sql, Long.class);
	        Set<Parameter<?>> params = query.getParameters();
	    	for (Parameter<?> parameter : params) {
				if (Objects.equals(parameter.getName(), "nameField") || Objects.equals(parameter.getName(), "nameGuest")
						|| Objects.equals(parameter.getName(), "phoneNumberGuest")
						|| Objects.equals(parameter.getName(), "smallFieldName")  
						|| Objects.equals(parameter.getName(), "totalPayment")
						|| Objects.equals(parameter.getName(), "day")
						|| Objects.equals(parameter.getName(), "timeStart")
						|| Objects.equals(parameter.getName(), "timeEnd")
						|| Objects.equals(parameter.getName(), "paymentStatus"))
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
	public List<TblBooking> getBookingbySmallFieldId(Long smallFieldId) {
		List<TblBooking> result = null;
		try {
			Session session = this.getCurrentSession();
			String sql ="select u FROM TblBooking u WHERE u.smallFieldId =:smallFieldId";
			Query query = session.createQuery(sql).setParameter("smallFieldId", smallFieldId);
		    result = query.getResultList();
		   } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return result;
		}

	@Override
	public TblBooking getBookingById(Long bookingId) {
		TblBooking result = null;
		try {
			Session session = this.getCurrentSession();
			String sql = "select u FROM TblBooking u WHERE u.bookingId =:bookingId";
			Query query = session.createQuery(sql).setParameter("bookingId", bookingId);
			result = (TblBooking) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Boolean deleteBooking(Long bookingId) {
	    Session session = this.getCurrentSession();
	    try {
	        TblBooking booking = session.get(TblBooking.class, bookingId);
	        if (booking != null) {
	            session.delete(booking);
	            session.flush(); 
	            return true; 
	        } else {
	            return false; 
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false; 
	    }
	}

	@Override
	public List<TblRevenue> getWeeklyRevenueByFieldId(Long fieldId) {
	    List<TblRevenue> result = new ArrayList<>();
	    try {
	        Session session = this.getCurrentSession();
	        String sql = "SELECT TO_CHAR(b.day, 'IW') as period, SUM(b.totalPayment) as totalPayment " +
	                     "FROM tbl_booking b " +
	                     "WHERE b.field_id = :fieldId AND b.status_field = 'booked' " +
	                     "GROUP BY TO_CHAR(b.day, 'IW')";
	        Query query = session.createNativeQuery(sql);
	        query.setParameter("fieldId", fieldId);

	        List<Object[]> queryResult = query.getResultList();
	        for (Object[] row : queryResult) {
	            String period = (String) row[0];
	            Long totalPayment = ((Number) row[1]).longValue(); // Chuyển đổi giá trị tổng tiền về kiểu Long
	            TblRevenue revenue = new TblRevenue(null, period, totalPayment);
	            result.add(revenue);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}


	
	@Override
	public List<TblRevenue> getMonthlyRevenueByFieldId(Long fieldId) {
	    List<TblRevenue> result = new ArrayList<>();
	    try {
	        Session session = this.getCurrentSession();
	        String sql = "SELECT TO_CHAR(b.day, 'MM') as period, SUM(b.totalPayment) as totalPayment " +
	                     "FROM tbl_booking b " +
	                     "WHERE b.field_id = :fieldId AND b.status_field = 'booked' " +
	                     "GROUP BY TO_CHAR(b.day, 'MM')";
	        Query query = session.createNativeQuery(sql);
	        query.setParameter("fieldId", fieldId);

	        List<Object[]> queryResult = query.getResultList();
	        for (Object[] row : queryResult) {
	            String period = (String) row[0];
	            Long totalPayment = ((Number) row[1]).longValue(); 
	            TblRevenue revenue = new TblRevenue(null, period, totalPayment);
	            result.add(revenue);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	
	@Override
	public List<TblBooking> getBookingbyFieldId(Long fieldId) {
		// TODO Auto-generated method stub
		List<TblBooking> result = null;
		try {
			Session session = this.getCurrentSession();
			String sql ="select u FROM TblBooking u WHERE u.fieldId =:fieldId";
			Query query = session.createQuery(sql).setParameter("fieldId", fieldId);
		    result = query.getResultList();
		   } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return result;
		}


	@Override
	public Boolean checkBookingExistence(Long smallFieldId, String timeStart, Date day) {
	    Session session = this.getCurrentSession();
	    Boolean exists = false;
	    try {
	        String sql = "SELECT COUNT(b) FROM TblBooking b WHERE b.smallFieldId = :smallFieldId " +
	                     "AND b.timeStart = :timeStart AND b.day = :day AND b.statusField = 'booked'";
	        Query query = session.createQuery(sql);
	        query.setParameter("smallFieldId", smallFieldId);
	        query.setParameter("timeStart", timeStart);
	        query.setParameter("day", day);
	        
	        Long count = (Long) query.getSingleResult();
	        exists = count > 0; // Nếu có bản ghi, trả về true
	        System.out.println("Booking check result for smallFieldId=" + smallFieldId + ", timeStart=" + timeStart + ", day=" + day + ": " + exists);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return exists;
	}
	
	@Override
	public long countBookingsToday(Long fieldId) {
	    Session session = this.getCurrentSession();
	    try {
	        // Lấy ngày hôm nay và chuyển đổi sang java.util.Date
	        LocalDate today = LocalDate.now();
	        Date todayDate = java.sql.Date.valueOf(today);  // Đảm bảo là chỉ có ngày, không có giờ

	        // In ra ngày hôm nay và fieldId để kiểm tra
	        System.out.println("Ngày hôm nay: " + todayDate);
	        System.out.println("fieldId: " + fieldId);

	        // Tạo câu truy vấn và xử lý thời gian nếu cần
	        String sql = "SELECT COUNT(*) FROM TblBooking f WHERE TRUNC(f.modifiedDate) = :today AND f.fieldId = :fieldId";  // Truncate phần thời gian
	        Query query = session.createQuery(sql, Long.class);

	        // Truyền tham số
	        query.setParameter("today", todayDate);
	        query.setParameter("fieldId", fieldId);

	        // In ra câu truy vấn để kiểm tra
	        System.out.println("Truy vấn SQL: " + sql);

	        // Lấy kết quả
	        long result = (long) query.getSingleResult();
	        System.out.println("Số lượng booking ngày hôm nay: " + result);
	        
	        return result;
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Lỗi khi đếm booking của ngày hôm nay cho fieldId: " + fieldId, e);
	    }
	}


	@Override
	public long calculateRevenueToday(Long fieldId) {
	    Session session = this.getCurrentSession();
	    try {
	        Date todayDate = new Date();
	        java.sql.Date sqlTodayDate = new java.sql.Date(todayDate.getTime());

	        // Truy vấn Hibernate
	        String sql = "SELECT COALESCE(SUM(f.totalPayment), 0) " +
	                     "FROM TblBooking f " +
	                     "WHERE TRUNC(f.modifiedDate) = TRUNC(:today) AND f.fieldId = :fieldId";

	        Query query = session.createQuery(sql);

	        query.setParameter("today", sqlTodayDate);
	        query.setParameter("fieldId", fieldId);

	        // Lấy kết quả
	        Object result = query.getSingleResult();

	        // Kiểm tra và chuyển đổi kết quả
	        if (result instanceof Number) {
	            return ((Number) result).longValue();
	        } else if (result instanceof String) {
	            return Long.parseLong((String) result);
	        } else {
	            return 0; // Trường hợp không có kết quả
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Lỗi khi tính doanh thu cho fieldId: " + fieldId, e);
	    }
	}


	
}
