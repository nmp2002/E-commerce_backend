package com.ttisv.springbootwildfly.payload.request;

import java.util.Date;

public class ShiftFieldRequest {
	 Long id;
	 Long fieldId;
	 Long shiftFieldName;
	 String timeStart;
	 String timeEnd;
	 String amountWeekday;
	 String amountWeekend;
	 String dayOfWeek;
	 Date day;
	 String fieldType;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	 
}
