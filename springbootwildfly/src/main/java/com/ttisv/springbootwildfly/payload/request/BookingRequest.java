package com.ttisv.springbootwildfly.payload.request;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class BookingRequest {
	int page;
    private Long bookingId;
    
    @NotNull
    private Long fieldId;
    
    @NotNull
    private Long guestId;
    
    @NotNull
    private Long shiftFieldId;
    
    @NotNull
    private Long smallFieldId;
    private String nameField;
    private String smallFieldName;
    private String nameGuest;
    private String phoneNumberGuest;
    private String totalPayment;
    
    @NotNull
    private String timeStart;
    
    @NotNull
    private Date day;
    
    @NotNull
    private String timeEnd;
    
    private String statusField;
    private String paymentStatus;

    // Getters and Setters
    
    public Long getBookingId() {
        return bookingId;
    }

    public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public Long getShiftFieldId() {
        return shiftFieldId;
    }

    public void setShiftFieldId(Long shiftFieldId) {
        this.shiftFieldId = shiftFieldId;
    }

    
    public Long getSmallFieldId() {
		return smallFieldId;
	}

	public void setSmallFieldId(Long smallFieldId) {
		this.smallFieldId = smallFieldId;
	}

	public String getNameField() {
        return nameField;
    }

    public void setNameField(String nameField) {
        this.nameField = nameField;
    }
    
    
    public String getSmallFieldName() {
		return smallFieldName;
	}

	public void setSmallFieldName(String smallFieldName) {
		this.smallFieldName = smallFieldName;
	}

	public String getNameGuest() {
        return nameGuest;
    }

    public void setNameGuest(String nameGuest) {
        this.nameGuest = nameGuest;
    }

    public String getPhoneNumberGuest() {
        return phoneNumberGuest;
    }

    public void setPhoneNumberGuest(String phoneNumberGuest) {
        this.phoneNumberGuest = phoneNumberGuest;
    }

    public String getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(String totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getStatusField() {
        return statusField;
    }

    public void setStatusField(String statusField) {
        this.statusField = statusField;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
