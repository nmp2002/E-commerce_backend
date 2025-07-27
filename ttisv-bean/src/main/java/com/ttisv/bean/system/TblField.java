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
@Table(name ="TBL_FIELD")
public class TblField implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SEQ_field", sequenceName = "SEQ_field", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_field")
	private Long id;
	
	@Column(name ="PROVINCE_ID")
	private Long provinceid;
	
	@Column(name = "DISTRICT_ID")
	private Long districtId;
	
	@Column(name = "WARD_ID")
	private Long wardId;
	
	@Column(name = "CREATEBY")
	private String createby;
	
	@Column(name ="MODIFIEDBY")
	private String modifieldby;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;
	
	@Column(name = "FIELDNAME")
	private String fieldName;
	
	@Column(name = "PROVINCENAME")
	private String provinceName;
	
	@Column(name = "DISTRICTNAME")
	private String districtName;
	
	@Column(name = "WARDNAME")
	private String wardName;
	
	@Column(name = "PHONENUMBERFIELD")
	private String phoneNumberField;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAY")
	private Date day;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "TIME_START")
	private Date timeStart;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "TIME_END")
	private Date timeEnd;
	
	@Column(name ="FIELDTYPE")
	private Long fieldType;
	
	@Column(name = "SMALL_FIELD_COUNT")
	 private Long smallFieldCount;
	
	@Column(name ="IMAGE")
	private String image;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "SUPPLIERID")
	private Long supplierId;
	
	@Column(name = "SUPPLIERNAME")
	private String supplierName;
	
	@Column(name="STATUS")
	private Long status;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProvinceid() {
		return	provinceid;
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

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
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

	public String getPhoneNumberField() {
		return phoneNumberField;
	}

	public void setPhoneNumberField(String phoneNumberField) {
		this.phoneNumberField = phoneNumberField;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getModifieldby() {
		return modifieldby;
	}

	public void setModifieldby(String modifieldby) {
		this.modifieldby = modifieldby;
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
	
	
	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	
	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}
	
	
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public TblField() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TblField(Long id, Long provinceid, Long districtId, Long wardId, String createby, String modifieldby,
			Date createdDate, Date modifiedDate, String fieldName, String provinceName, String districtName,
			String wardName, String phoneNumberField, Date day, Date timeStart, Date timeEnd, Long fieldType,
			Long smallFieldCount, String image, String address, Long supplierId, String supplierName, Long status) {
		super();
		this.id = id;
		this.provinceid = provinceid;
		this.districtId = districtId;
		this.wardId = wardId;
		this.createby = createby;
		this.modifieldby = modifieldby;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.fieldName = fieldName;
		this.provinceName = provinceName;
		this.districtName = districtName;
		this.wardName = wardName;
		this.phoneNumberField = phoneNumberField;
		this.day = day;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.fieldType = fieldType;
		this.smallFieldCount = smallFieldCount;
		this.image = image;
		this.address = address;
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.status = status;
	}

	
	
}
