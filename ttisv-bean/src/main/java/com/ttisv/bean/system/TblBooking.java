package com.ttisv.bean.system;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TBL_BOOKING")
public class TblBooking implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQ_BOOKING", sequenceName = "SEQ_BOOKING", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BOOKING")
    @Column(name = "BOOKING_ID")
    private Long bookingId;

    @Column(name = "FIELD_ID")
    private Long fieldId;

    @Column(name = "GUEST_ID")
    private Long guestId;

    @Column(name = "SHIFTFIELD_ID")
    private Long shiftFieldId;
    
    @Column(name = "SMALL_FIELD_ID")
    private Long smallFieldId;
    
    @Column(name = "NAMEFIELD")
    private String nameField;
    
    @Column (name="SMALLFIELDNAME")
    private String smallFieldName;
    
    @Column(name = "NAMEGUEST")
    private String nameGuest;

    @Column(name = "PHONE_NUMBER_GUEST")
    private String phoneNumberGuest;

    @Column(name = "TOTALPAYMENT")
    private String totalPayment;

 
    @Column(name = "TIMESTART")
    private String timeStart;

    @Temporal(TemporalType.DATE)
    @Column(name = "DAY")
    private Date day;

    @Column(name = "TIMEEND")
    private String timeEnd;

    @Column(name = "STATUS_FIELD")
    private String statusField;

    @Column(name = "PAYMENT_STATUS")
    private String paymentStatus;
    
    @Column(name="FIELDTYPE")
    private String fieldType;
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    
    @Column(name = "CREATEDBY")
    private String createdBy;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;
    
    @Column(name = "MODIFIEDBY")
    private String modifiedBy;
    
    public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Long getBookingId() {
        return bookingId;
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

    public String getNameGuest() {
        return nameGuest;
    }
    
    
    public String getSmallFieldName() {
		return smallFieldName;
	}

	public void setSmallFieldName(String smallFieldName) {
		this.smallFieldName = smallFieldName;
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public TblBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TblBooking(Long bookingId, Long fieldId, Long guestId, Long shiftFieldId, Long smallFieldId,
			String nameField, String smallFieldName, String nameGuest, String phoneNumberGuest, String totalPayment,
			String timeStart, Date day, String timeEnd, String statusField, String paymentStatus, String fieldType,
			Date createdDate, String createdBy, Date modifiedDate, String modifiedBy) {
		super();
		this.bookingId = bookingId;
		this.fieldId = fieldId;
		this.guestId = guestId;
		this.shiftFieldId = shiftFieldId;
		this.smallFieldId = smallFieldId;
		this.nameField = nameField;
		this.smallFieldName = smallFieldName;
		this.nameGuest = nameGuest;
		this.phoneNumberGuest = phoneNumberGuest;
		this.totalPayment = totalPayment;
		this.timeStart = timeStart;
		this.day = day;
		this.timeEnd = timeEnd;
		this.statusField = statusField;
		this.paymentStatus = paymentStatus;
		this.fieldType = fieldType;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
	}

	
   
}
