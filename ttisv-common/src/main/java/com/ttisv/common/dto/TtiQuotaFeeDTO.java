package com.ttisv.common.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

public class TtiQuotaFeeDTO {

	private Long id;

	private Long quoteid;

	private Long quotapolicyid;

	private Long quotapolicydetailid;

	private String quoteno;

	private String ccy;

	private Date modifiedDate;

	private String modifiedby;

	private String createdby;

	private Date createdDate;

	private BigDecimal exrate;

	private BigDecimal feeamount;

	private String feetype;

	private String insurancefeecode;

	private String insurancefeename;

	private String insuranceitemcode;

	private String insuranceitemname;

	private String insuranceproductcode;

	private String insuranceproductname;

	private String itemtypecode;

	private String itemtypename;

	private BigDecimal percentval;

	private BigDecimal priceval;

	private String productname;

	private Date todate;

	private Date fromdate;

	private String timeinsurance;
	private String id_data;

	private BigDecimal val;

	private String unitVal;

	private String prtype;

	private BigDecimal prval;

	public TtiQuotaFeeDTO() {
	}

	public Long getQuotapolicyid() {
		return quotapolicyid;
	}

	public void setQuotapolicyid(Long quotapolicyid) {
		this.quotapolicyid = quotapolicyid;
	}

	public String getCcy() {
		return this.ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
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

	public BigDecimal getExrate() {
		return this.exrate;
	}

	public void setExrate(BigDecimal exrate) {
		this.exrate = exrate;
	}

	public BigDecimal getFeeamount() {
		return this.feeamount;
	}

	public void setFeeamount(BigDecimal feeamount) {
		this.feeamount = feeamount;
	}

	public String getFeetype() {
		return this.feetype;
	}

	public void setFeetype(String feetype) {
		this.feetype = feetype;
	}

	public Date getFromdate() {
		return this.fromdate;
	}

	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuoteid() {
		return quoteid;
	}

	public void setQuoteid(Long quoteid) {
		this.quoteid = quoteid;
	}

	public String getQuoteno() {
		return quoteno;
	}

	public void setQuoteno(String quoteno) {
		this.quoteno = quoteno;
	}

	public String getInsurancefeecode() {
		return this.insurancefeecode;
	}

	public void setInsurancefeecode(String insurancefeecode) {
		this.insurancefeecode = insurancefeecode;
	}

	public String getInsurancefeename() {
		return this.insurancefeename;
	}

	public void setInsurancefeename(String insurancefeename) {
		this.insurancefeename = insurancefeename;
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

	public String getInsuranceproductcode() {
		return this.insuranceproductcode;
	}

	public void setInsuranceproductcode(String insuranceproductcode) {
		this.insuranceproductcode = insuranceproductcode;
	}

	public String getInsuranceproductname() {
		return this.insuranceproductname;
	}

	public void setInsuranceproductname(String insuranceproductname) {
		this.insuranceproductname = insuranceproductname;
	}

	public String getItemtypecode() {
		return this.itemtypecode;
	}

	public void setItemtypecode(String itemtypecode) {
		this.itemtypecode = itemtypecode;
	}

	public String getItemtypename() {
		return this.itemtypename;
	}

	public void setItemtypename(String itemtypename) {
		this.itemtypename = itemtypename;
	}

	public BigDecimal getPercentval() {
		return this.percentval;
	}

	public void setPercentval(BigDecimal percentval) {
		this.percentval = percentval;
	}

	public BigDecimal getPriceval() {
		return this.priceval;
	}

	public void setPriceval(BigDecimal priceval) {
		this.priceval = priceval;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Date getTodate() {
		return this.todate;
	}

	public void setTodate(Date todate) {
		this.todate = todate;
	}

	public String getTimeinsurance() {
		return timeinsurance;
	}

	public void setTimeinsurance(String timeinsurance) {
		this.timeinsurance = timeinsurance;
	}

	public Long getQuotapolicydetailid() {
		return quotapolicydetailid;
	}

	public void setQuotapolicydetailid(Long quotapolicydetailid) {
		this.quotapolicydetailid = quotapolicydetailid;
	}

	public String getId_data() {
		return id_data;
	}

	public void setId_data(String id_data) {
		this.id_data = id_data;
	}

	public BigDecimal getVal() {
		return val;
	}

	public void setVal(BigDecimal val) {
		this.val = val;
	}

	public String getUnitVal() {
		return unitVal;
	}

	public void setUnitVal(String unitVal) {
		this.unitVal = unitVal;
	}

	public String getPrtype() {
		return prtype;
	}

	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	public BigDecimal getPrval() {
		return prval;
	}

	public void setPrval(BigDecimal prval) {
		this.prval = prval;
	}

}