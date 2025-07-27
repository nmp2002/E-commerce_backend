package com.ttisv.springbootwildfly.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttisv.bean.system.TblBooking;
import com.ttisv.bean.system.TblRevenue;
import com.ttisv.common.utils.StringUtils;
import com.ttisv.service.system.TblBookingService;
import com.ttisv.springbootwildfly.common.Constants;
import com.ttisv.springbootwildfly.payload.request.BookingRequest;
import com.ttisv.springbootwildfly.payload.response.MessageResponse;

@RestController
@RequestMapping("/api/booking")

public class BookingController extends BaseController {

    @Autowired
    private TblBookingService bookingService;

    @PutMapping("/savebooking")
    public ResponseEntity<?> saveOrUpdateBooking(@Valid @RequestBody BookingRequest bookingRequest) {
        try {
            TblBooking booking = new TblBooking();
            if (bookingRequest.getBookingId() != null) {
                booking.setBookingId(bookingRequest.getBookingId());
                booking.setModifiedDate(new Date());
            } else {
                booking.setCreatedDate(new Date());
            }
            booking.setFieldId(bookingRequest.getFieldId());
            booking.setGuestId(bookingRequest.getGuestId());
            booking.setShiftFieldId(bookingRequest.getShiftFieldId());
            booking.setSmallFieldId(bookingRequest.getSmallFieldId());
            booking.setNameField(bookingRequest.getNameField());
            booking.setSmallFieldName(bookingRequest.getSmallFieldName());
            booking.setNameGuest(bookingRequest.getNameGuest());
            booking.setPhoneNumberGuest(bookingRequest.getPhoneNumberGuest());
            booking.setTotalPayment(bookingRequest.getTotalPayment());
            booking.setTimeStart(bookingRequest.getTimeStart());
            booking.setDay(bookingRequest.getDay());
            booking.setTimeEnd(bookingRequest.getTimeEnd());
            booking.setStatusField(bookingRequest.getStatusField());
            booking.setPaymentStatus(bookingRequest.getPaymentStatus());

            TblBooking savedBooking = bookingService.saveorUpdate(booking);
            if (savedBooking != null) {
                return ResponseEntity.ok(new MessageResponse(savedBooking.getBookingId(), "Booking saved/updated successfully!"));
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error: Unable to save/update booking."));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error: An error occurred during processing!"));
        }
    }
    
    @GetMapping("/bookingid")
    public ResponseEntity<List<TblBooking>> getBookingbySmallFieldId(@Valid @RequestParam Long smallFieldId) {
    	   try {
               List<TblBooking> bookings = bookingService.getBookingbySmallFieldId(smallFieldId);
               if (bookings == null || bookings.isEmpty()) {
                   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
               }
               return new ResponseEntity<>(bookings, HttpStatus.OK);
           } catch (Exception ex) {
               return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
           }
    	
    }
    
    @GetMapping("/bookingFieldId")
    public ResponseEntity<List<TblBooking>> getBookingbyFieldId(@Valid @RequestParam Long fieldId) {
    	   try {
               List<TblBooking> bookings = bookingService.getBookingbyFieldId(fieldId);
               if (bookings == null || bookings.isEmpty()) {
                   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
               }
               return new ResponseEntity<>(bookings, HttpStatus.OK);
           } catch (Exception ex) {
               return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
           }
    	
    }
    
    @GetMapping("/bookingId")
    public ResponseEntity<TblBooking> getBookingById(@Valid @RequestParam Long bookingId){
    	try {
    		TblBooking booking = bookingService.getBookingById(bookingId);
    		if(booking != null ) {
    			return ResponseEntity.ok(booking);
    		} else {
    				return ResponseEntity.noContent().build();
    				}
    		}
    		catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    	}
    
    @GetMapping("/deleteBooking")
    public ResponseEntity<String> deleteBooking(@RequestParam Long bookingId) {
        try {
            boolean isDeleted = bookingService.deleteBooking(bookingId);
            if (isDeleted) {
                return ResponseEntity.ok("Booking deleted successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found or already deleted.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the booking.");
        }
    }
    
    @GetMapping("/weekly-revenue")
    public ResponseEntity<?> getWeeklyRevenueByFieldId(@RequestParam Long fieldId) {
        try {
            List<TblRevenue> weeklyRevenue = bookingService.getWeeklyRevenueByFieldId(fieldId);
            if (weeklyRevenue == null || weeklyRevenue.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(weeklyRevenue, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching weekly revenue.");
        }
    }

    
    @GetMapping("/monthly-revenue")
    public ResponseEntity<?> getMonthlyRevenueByFieldId(@RequestParam Long fieldId) {
        try {
            List<TblRevenue> monthlyRevenue = bookingService.getMonthlyRevenueByFieldId(fieldId);
            if (monthlyRevenue == null || monthlyRevenue.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(monthlyRevenue, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching monthly revenue.");
        }
    }


    
    
    @GetMapping("/list")
    public ResponseEntity<Page<TblBooking>> findAllBooking(@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
    	int sizeRecord = 10;
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(sizeRecord);
		Map<String, String> map = new HashMap<>();
		Page<TblBooking> list = bookingService.getListPageBooking(PageRequest.of(currentPage - 1, pageSize), map);
		if (list == null) {
			return new ResponseEntity<Page<TblBooking>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Page<TblBooking>>(list, HttpStatus.OK);
    }
    
	@SuppressWarnings("deprecation")
	@CrossOrigin
	@RequestMapping(value = "/paging", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Page<TblBooking>> findAllField(@RequestBody String req, HttpServletRequest request,
			HttpServletResponse resp) {
		BookingRequest acctreq = gson.fromJson(req, BookingRequest.class);
		int currentPage = acctreq.getPage();
		int pageSize = 10;
		Map<String, String> map = taoMapTraCuu(acctreq);
		Page<TblBooking> list = bookingService.getListPageBooking(PageRequest.of(currentPage - 1, pageSize), map);
		if (list == null) {
			return new ResponseEntity<Page<TblBooking>>(HttpStatus.NOT_FOUND);
		}
		String s = gson.toJson(list);
		System.out.println(list.getNumber());
		System.out.println(s);
		return new ResponseEntity<Page<TblBooking>>(list, HttpStatus.OK);
	}
    private Map<String, String> taoMapTraCuu(BookingRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("nameField", !StringUtils.isEmpty(request.getNameField()) ? request.getNameField() : null);
		map.put("smallFieldName", !StringUtils.isEmpty(request.getSmallFieldName()) ? request.getSmallFieldName() : null);
		map.put("nameGuest", !StringUtils.isEmpty(request.getNameGuest()) ? request.getNameGuest() : null);
		map.put("phoneNumberGuest",
				!StringUtils.isEmpty(request.getPhoneNumberGuest()) ? request.getPhoneNumberGuest() : null);
		map.put("totalPayment",
				!StringUtils.isEmpty(request.getTotalPayment()) ? request.getTotalPayment() : null);
		map.put("timeStart", request.getTimeStart() != null ? request.getTimeStart().toString() : null);
		map.put("timeEnd", request.getTimeEnd() != null ? request.getTimeEnd().toString() : null);
		map.put("day", request.getDay() != null ? request.getDay().toString() : null);
		map.put("statusField", request.getStatusField() != null ? request.getStatusField().toString() : null);
		return map;
	}
    // API kiểm tra sự tồn tại của booking
    @GetMapping("/checkExistence")
    public ResponseEntity<?> checkBookingExistence(
            @RequestParam Long smallFieldId,
            @RequestParam String timeStart,
            @RequestParam Date day) {

    	 try {
    	        // Kiểm tra sự tồn tại của booking
    	        Boolean isBookingExist = bookingService.checkBookingExistence(smallFieldId, timeStart, day);

    	        // Trả về true nếu có booking tồn tại, false nếu không có
    	        return ResponseEntity.ok(isBookingExist);
    	    } catch (Exception ex) {
    	        ex.printStackTrace();
    	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
    	                .body(false); // Trả về false nếu có lỗi xảy ra
    	    }
    	}
    @GetMapping("/countBookingsByFieldToday")
    public ResponseEntity<?> countBookingsByFieldToday(
            @RequestParam Long fieldId) {
        try {
            long bookingCount = bookingService.countBookingsToday(fieldId);
            return ResponseEntity.ok(bookingCount);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while counting bookings.");
        }
    }
    
    @GetMapping("/calculateRevenueToday")
    public ResponseEntity<?> calculateRevenueToday(@RequestParam Long fieldId) {
        try {
            // Tính toán doanh thu hôm nay cho fieldId
            long revenue = bookingService.calculateRevenueToday(fieldId);
            return ResponseEntity.ok(revenue);  // Trả về doanh thu
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while calculating revenue.");
        }
    }

}
