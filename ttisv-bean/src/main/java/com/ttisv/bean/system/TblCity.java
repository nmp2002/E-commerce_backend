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
@Table(name = "TBL_CITY")
public class TblCity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "SEQ_TBL_CITY", sequenceName = "SEQ_TBL_CITY", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TBL_CITY")
    @Column(name = "PROVINCEID")
    private Long provinceid;
    
    @Column(name = "PROVINCECODE")
    private String provinceCode;
    
    @Column(name = "PROVINCENAME")
    private String provinceName;
    
    @Column(name = "PROVINCENAMEENGLISH")
    private String provinceNameEnglish;
    
    @Column(name = "PROVINCETYPE")
    private String provinceType;
    
    @Column(name = "ISELEMENT")
    private String isElement;
    
    @Column(name = "ACTIVE")
    private String active;
    
    @Column(name = "COUNTRYNAME")
    private String countryName;
    
    @Column(name = "COUNTRYCODE")
    private String countryCode;
    
    @Column(name = "TTISV_CODE")
    private String ttisvCode;
    
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

	public Long getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(Long provinceid) {
		this.provinceid = provinceid;
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

	public String getProvinceNameEnglish() {
		return provinceNameEnglish;
	}

	public void setProvinceNameEnglish(String provinceNameEnglish) {
		this.provinceNameEnglish = provinceNameEnglish;
	}

	public String getProvinceType() {
		return provinceType;
	}

	public void setProvinceType(String provinceType) {
		this.provinceType = provinceType;
	}

	public String getIsElement() {
		return isElement;
	}

	public void setIsElement(String isElement) {
		this.isElement = isElement;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getTtisvCode() {
		return ttisvCode;
	}

	public void setTtisvCode(String ttisvCode) {
		this.ttisvCode = ttisvCode;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TblCity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TblCity(Long provinceid, String provinceCode, String provinceName, String provinceNameEnglish,
			String provinceType, String isElement, String active, String countryName, String countryCode,
			String ttisvCode, Date createdDate, String createdBy, Date modifiedDate, String modifiedBy) {
		super();
		this.provinceid = provinceid;
		this.provinceCode = provinceCode;
		this.provinceName = provinceName;
		this.provinceNameEnglish = provinceNameEnglish;
		this.provinceType = provinceType;
		this.isElement = isElement;
		this.active = active;
		this.countryName = countryName;
		this.countryCode = countryCode;
		this.ttisvCode = ttisvCode;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
	}
    
}