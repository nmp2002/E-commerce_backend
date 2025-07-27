package com.ttisv.common.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TtiQuotapolicyinsuranceDTO {

	private Long id;

	private Date modifiedDate;

	private String modifiedby;

	private String createdby;

	private Date createdDate;

	private String insuranceitemcode;

	private String insuranceitemname;

	private String quotano;

	private String quotapolicyno;

	private String taxcode;

	private BigDecimal taxRate;

	private List<TtiQuotapolicydetailDTO> quotapolicydetails;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getInsuranceitemcode() {
		return this.insuranceitemcode;
	}

	public void setInsuranceitemcode(String insuranceitemcode) {
		this.insuranceitemcode = insuranceitemcode;
	}

	public String getInsuranceitemname() {
		return this.insuranceitemname;
	}

	public void setInsuranceitemname(String insuranceitemname) {
		this.insuranceitemname = insuranceitemname;
	}

	public String getQuotano() {
		return this.quotano;
	}

	public void setQuotano(String quotano) {
		this.quotano = quotano;
	}

	public String getQuotapolicyno() {
		return this.quotapolicyno;
	}

	public void setQuotapolicyno(String quotapolicyno) {
		this.quotapolicyno = quotapolicyno;
	}

	public String getTaxcode() {
		return taxcode;
	}

	public void setTaxcode(String taxcode) {
		this.taxcode = taxcode;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public List<TtiQuotapolicydetailDTO> getQuotapolicydetails() {
		return quotapolicydetails;
	}

	public void setQuotapolicydetails(List<TtiQuotapolicydetailDTO> quotapolicydetails) {
		this.quotapolicydetails = quotapolicydetails;
	}
}