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
@Table(name = "TBL_WARD")
public class TblWard implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "SEQ_TBL_WARD", sequenceName = "SEQ_TBL_WARD", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TBL_WARD")
    @Column(name = "WARDID")
    private Long wardId;
    
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
    
    @Column(name ="ACTIVE")
    private String active;
    
    @Column(name ="WARDCODE")
    private String wardCode;
    
    @Column(name ="WARDNAME")
    private String wardName;
    
    @Column(name = "DISTRICT_ID")
    private Long districtId;
    
    @Column(name ="DISTRICTNAME")
    private String districtName;
    
    @Column(name = "DISTRICTCODE")
    private String districtCode;
    
    @Column(name = "WARDNAMEENG")
    private String wardNameEng;

	public Long getWardId() {
		return wardId;
	}

	public void setWardId(Long wardId) {
		this.wardId = wardId;
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

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getWardCode() {
		return wardCode;
	}

	public void setWardCode(String wardCode) {
		this.wardCode = wardCode;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getWardNameEng() {
		return wardNameEng;
	}

	public void setWardNameEng(String wardNameEng) {
		this.wardNameEng = wardNameEng;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TblWard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TblWard(Long wardId, String createdBy, Date createdDate, Date modifiedDate, String modifiedBy, String active,
			String wardCode, String wardName, Long districtId, String districtName, String districtCode,
			String wardNameEng) {
		super();
		this.wardId = wardId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.active = active;
		this.wardCode = wardCode;
		this.wardName = wardName;
		this.districtId = districtId;
		this.districtName = districtName;
		this.districtCode = districtCode;
		this.wardNameEng = wardNameEng;
	}
    
}