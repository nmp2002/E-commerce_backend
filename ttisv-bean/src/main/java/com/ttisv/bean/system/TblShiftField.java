package com.ttisv.bean.system;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SHIFT_FIELD")
@NamedQuery(name = "TblShiftField.findAll", query = "SELECT t FROM TblShiftField t")
public class TblShiftField implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_TBL_SHIFT_FIELD", sequenceName = "SEQ_TBL_SHIFT_FIELD", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TBL_SHIFT_FIELD")
    private Long Id;

    @Column(name = "FIELD_ID")
    private Long fieldId;
    
    @Column(name = "SHIFTFIELDNAME")
    private Long shiftFieldName;
    
    @Column(name = "CREATEDBY")
    private String createdBy;
    
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "MODIFIEDBY")
    private String modifiedBy;

    @Column(name = "TIME_START")
    private String timeStart;

    @Column(name = "TIME_END")
    private String timeEnd;

    @Column(name = "AMOUNT_WEEKDAY")
    private String amountWeekday;

    @Column(name = "AMOUNT_WEEKEND")
    private String amountWeekend;

    @Column(name = "DAY_OF_WEEK")
    private String dayOfWeek;

    @Column(name = "DAY")
    private Date day;

    @Column(name = "STATUS_FIELD")
    private String statusField;
    
    @Column(name ="FIELD_TYPE")
    private String fieldType;
	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getFieldId() {
		return fieldId;
	}
	
	public void setFieldId(Long fieldId) {
		this.fieldId = fieldId;
	}
	
	
	public Long getShiftFieldName() {
		return shiftFieldName;
	}

	public void setShiftFieldName(Long shiftFieldName) {
		this.shiftFieldName = shiftFieldName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getAmountWeekday() {
		return amountWeekday;
	}

	public void setAmountWeekday(String amountWeekday) {
		this.amountWeekday = amountWeekday;
	}

	public String getAmountWeekend() {
		return amountWeekend;
	}

	public void setAmountWeekend(String amountWeekend) {
		this.amountWeekend = amountWeekend;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public String getStatusField() {
		return statusField;
	}

	public void setStatusField(String statusField) {
		this.statusField = statusField;
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

	public TblShiftField() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TblShiftField(Long id, Long fieldId, Long shiftFieldName, String createdBy, Date createdDate,
			Date modifiedDate, String modifiedBy, String timeStart, String timeEnd, String amountWeekday,
			String amountWeekend, String dayOfWeek, Date day, String statusField, String fieldType) {
		super();
		Id = id;
		this.fieldId = fieldId;
		this.shiftFieldName = shiftFieldName;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.amountWeekday = amountWeekday;
		this.amountWeekend = amountWeekend;
		this.dayOfWeek = dayOfWeek;
		this.day = day;
		this.statusField = statusField;
		this.fieldType = fieldType;
	}

	

}
