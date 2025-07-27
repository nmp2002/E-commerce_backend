package com.ttisv.springbootwildfly.payload.request;

import java.util.Date;

public class FieldRequest {
	String id;
	int page;
	String fieldName;
	String provinceName;
	String districtName;
	String wardName;
	Long provinceid;
	Long districtId;
	Long wardId;
	String status;
	Date day;
	String phoneNumberField;
	Long fieldType;
	Long smallFieldCount;
	Date timeStart;
	Date timeEnd;
	String address;
	String image;
	String supplierName;
	Long supplierId;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	
	public String getWardName() {
		return wardName;
	}
	public void setWardName(String wardName) {
		this.wardName = wardName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public Long getFieldType() {
		return fieldType;
	}
	public void setFieldType(Long fieldType) {
		this.fieldType = fieldType;
	}
	public Long getSmallFieldCount() {
		return smallFieldCount;
	}
	public void setSmallFieldCount(Long smallFieldCount) {
		this.smallFieldCount = smallFieldCount;
	}
	public Date getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}
	public Date getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}
	public long getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(Long provinceid) {
		this.provinceid = provinceid;
	}
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	public Long getWardId() {
		return wardId;
	}
	public void setWardId(Long wardId) {
		this.wardId = wardId;
	}
	public String getPhoneNumberField() {
		return phoneNumberField;
	}
	public void setPhoneNumberField(String phoneNumberField) {
		this.phoneNumberField = phoneNumberField;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
