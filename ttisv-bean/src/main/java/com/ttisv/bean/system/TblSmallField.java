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
@Table(name ="TBL_SMALL_FIELD")
public class TblSmallField  implements Serializable {
	@Id
	@SequenceGenerator(name = "SEQ_TBL_SMALL_FIELD", sequenceName = "SEQ_TBL_SMALL_FIELD", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TBL_SMALL_FIELD")
    private Long Id;

    @Column(name = "FIELD_ID")
    private Long fieldId;
    
    @Column(name = "PROVINCE_ID")
    private Long provinceId;
    
    @Column(name = "DISTRICT_ID")
    private Long districtId;
    
    @Column(name = "WARD_ID")
    private Long wardId;
    
    @Column(name ="FIELDTYPE_ID")
    private long fieldTypeId;
    
    @Column(name ="SMALLFIELDNAME")
    private String smallFieldName;
    
    @Column(name = "FIELD_MONEY")
    private Long fieldMoney;
    
    @Column(name = "STATUS")
    private Long status;
    
    @Column(name = "FIELDTYPE")
    private String fieldType;
    
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

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
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

	
	public long getFieldTypeId() {
		return fieldTypeId;
	}

	public void setFieldTypeId(long fieldTypeId) {
		this.fieldTypeId = fieldTypeId;
	}
	
	
	public String getSmallFieldName() {
		return smallFieldName;
	}

	public void setSmallFieldName(String smallFieldName) {
		this.smallFieldName = smallFieldName;
	}

	public Long getFieldMoney() {
		return fieldMoney;
	}
	
	public void setFieldMoney(Long fieldMoney) {
		this.fieldMoney = fieldMoney;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public String getModifieldby() {
		return modifieldby;
	}

	public void setModifieldby(String modifieldby) {
		this.modifieldby = modifieldby;
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
	
	
	public TblSmallField() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TblSmallField(Long id, Long fieldId, Long provinceId, Long districtId, Long wardId, long fieldTypeId,
			String smallFieldName, Long fieldMoney, Long status, String fieldType, String createby, String modifieldby,
			Date createdDate, Date modifiedDate) {
		super();
		Id = id;
		this.fieldId = fieldId;
		this.provinceId = provinceId;
		this.districtId = districtId;
		this.wardId = wardId;
		this.fieldTypeId = fieldTypeId;
		this.smallFieldName = smallFieldName;
		this.fieldMoney = fieldMoney;
		this.status = status;
		this.fieldType = fieldType;
		this.createby = createby;
		this.modifieldby = modifieldby;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}	
	
}
