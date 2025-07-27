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
@Table(name = "TBL_DISTRICT")
public class TblDistrict implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "SEQ_TBL_DISTRICT", sequenceName = "SEQ_TBL_DISTRICT", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TBL_DISTRICT")
    @Column(name = "DISTRICTID")
    private Long districtId;
    
    @Column(name = "CITY_ID")
    private Long cityId;
    
    @Column(name = "CREATEDBY")
    private String createdBy;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;
    
    @Column(name ="MODIFIEDBY")
    private String modifiedBy;
    
    @Column(name ="DISTRICT_TYPE")
    private Number districtType;
    
    @Column(name ="ACTIVE")
    private String active;
    
    @Column(name ="DISTRICTCODE")
    private String districtCode;
    
    @Column(name ="DISTRICTNAME")
    private String districtName;
    
    @Column(name = "DISTRICTNAMEENGLISH")
    private String districtNameEnglish;
    
    @Column(name = "PROVINCECODE")
    private String provinceCode;
    
    @Column(name = "PROVINCENAME")
    private String provinceName;

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
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

	public Number getDistrictType() {
		return districtType;
	}

	public void setDistrictType(Number districtType) {
		this.districtType = districtType;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistrictNameEnglish() {
		return districtNameEnglish;
	}

	public void setDistrictNameEnglish(String districtNameEnglish) {
		this.districtNameEnglish = districtNameEnglish;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TblDistrict() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TblDistrict(Long districtId, Long cityId, String createdBy, Date createdDate, Date modifiedDate,
			String modifiedBy, Number districtType, String active, String districtCode, String districtName,
			String districtNameEnglish, String provinceCode, String provinceName) {
		super();
		this.districtId = districtId;
		this.cityId = cityId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.districtType = districtType;
		this.active = active;
		this.districtCode = districtCode;
		this.districtName = districtName;
		this.districtNameEnglish = districtNameEnglish;
		this.provinceCode = provinceCode;
		this.provinceName = provinceName;
	}
    
}