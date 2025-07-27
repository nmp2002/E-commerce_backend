package com.ttisv.common.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class TtiQuotevehicleDTO {

	private Long quotavehicleid;

	private String brandcode;

	private String brandname;

	private String capacity;

	private Integer seatingcapacity;

	private String ccy;

	private String code;

	private Long colorid;

	@Temporal(TemporalType.DATE)
	private Date registrationdate;

	@Temporal(TemporalType.DATE)
	private Date deliverydate;

	private String editioncode;

	private String editionname;

	private String enginenumber;

	private Long fuelid;

	private String gear;

	private String grade;

	private BigDecimal invoiceprice;

	private String lineoffmonth;

	private String manufacturingdate;

	private BigDecimal marketprice;

	private String modelcode;

	private String modelname;

	private String licenseplates;

	private BigDecimal priceatsale;

	@Temporal(TemporalType.DATE)
	private Date priceatsaledate;

	private String purposeofuseid;

	private Long quotaid;

	@Temporal(TemporalType.DATE)
	private Date salesdate;

	private String vehicletypeid;

	private String vinnumber;

	private String vehicletypename;

	private String purposeofusename;

	private BigDecimal tonnage;

	private String classcode;

	private String classname;

	private String gradepro;

	private String katashiky;

	public TtiQuotevehicleDTO() {
	}

	public String getBrandcode() {
		return this.brandcode;
	}

	public void setBrandcode(String brandcode) {
		this.brandcode = brandcode;
	}

	public String getBrandname() {
		return this.brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getCapacity() {
		return this.capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public Integer getSeatingcapacity() {
		return seatingcapacity;
	}

	public void setSeatingcapacity(Integer seatingcapacity) {
		this.seatingcapacity = seatingcapacity;
	}

	public String getCcy() {
		return this.ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getColorid() {
		return this.colorid;
	}

	public void setColorid(Long colorid) {
		this.colorid = colorid;
	}

	public Date getDeliverydate() {
		return this.deliverydate;
	}

	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}

	public String getEditioncode() {
		return this.editioncode;
	}

	public void setEditioncode(String editioncode) {
		this.editioncode = editioncode;
	}

	public String getEditionname() {
		return this.editionname;
	}

	public void setEditionname(String editionname) {
		this.editionname = editionname;
	}

	public String getEnginenumber() {
		return this.enginenumber;
	}

	public void setEnginenumber(String enginenumber) {
		this.enginenumber = enginenumber;
	}

	public Long getFuelid() {
		return this.fuelid;
	}

	public void setFuelid(Long fuelid) {
		this.fuelid = fuelid;
	}

	public String getGear() {
		return this.gear;
	}

	public void setGear(String gear) {
		this.gear = gear;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public BigDecimal getInvoiceprice() {
		return this.invoiceprice;
	}

	public void setInvoiceprice(BigDecimal invoiceprice) {
		this.invoiceprice = invoiceprice;
	}

	public String getLineoffmonth() {
		return this.lineoffmonth;
	}

	public void setLineoffmonth(String lineoffmonth) {
		this.lineoffmonth = lineoffmonth;
	}

	public String getManufacturingdate() {
		return this.manufacturingdate;
	}

	public void setManufacturingdate(String manufacturingdate) {
		this.manufacturingdate = manufacturingdate;
	}

	public BigDecimal getMarketprice() {
		return this.marketprice;
	}

	public void setMarketprice(BigDecimal marketprice) {
		this.marketprice = marketprice;
	}

	public String getModelcode() {
		return this.modelcode;
	}

	public void setModelcode(String modelcode) {
		this.modelcode = modelcode;
	}

	public String getModelname() {
		return this.modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public String getLicenseplates() {
		return licenseplates;
	}

	public void setLicenseplates(String licenseplates) {
		this.licenseplates = licenseplates;
	}

	public BigDecimal getPriceatsale() {
		return this.priceatsale;
	}

	public void setPriceatsale(BigDecimal priceatsale) {
		this.priceatsale = priceatsale;
	}

	public Date getPriceatsaledate() {
		return this.priceatsaledate;
	}

	public void setPriceatsaledate(Date priceatsaledate) {
		this.priceatsaledate = priceatsaledate;
	}

	public String getPurposeofuseid() {
		return this.purposeofuseid;
	}

	public void setPurposeofuseid(String purposeofuseid) {
		this.purposeofuseid = purposeofuseid;
	}

	public Long getQuotaid() {
		return this.quotaid;
	}

	public void setQuotaid(Long quotaid) {
		this.quotaid = quotaid;
	}

	public Long getQuotavehicleid() {
		return this.quotavehicleid;
	}

	public void setQuotavehicleid(Long quotavehicleid) {
		this.quotavehicleid = quotavehicleid;
	}

	public Date getSalesdate() {
		return this.salesdate;
	}

	public void setSalesdate(Date salesdate) {
		this.salesdate = salesdate;
	}

	public String getVehicletypeid() {
		return this.vehicletypeid;
	}

	public void setVehicletypeid(String vehicletypeid) {
		this.vehicletypeid = vehicletypeid;
	}

	public String getVinnumber() {
		return this.vinnumber;
	}

	public void setVinnumber(String vinnumber) {
		this.vinnumber = vinnumber;
	}

	public Date getRegistrationdate() {
		return registrationdate;
	}

	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}

	public String getVehicletypename() {
		return vehicletypename;
	}

	public void setVehicletypename(String vehicletypename) {
		this.vehicletypename = vehicletypename;
	}

	public String getPurposeofusename() {
		return purposeofusename;
	}

	public void setPurposeofusename(String purposeofusename) {
		this.purposeofusename = purposeofusename;
	}

	public BigDecimal getTonnage() {
		return tonnage;
	}

	public void setTonnage(BigDecimal tonnage) {
		this.tonnage = tonnage;
	}

	public String getClasscode() {
		return classcode;
	}

	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getGradepro() {
		return gradepro;
	}

	public void setGradepro(String gradepro) {
		this.gradepro = gradepro;
	}

	public String getKatashiky() {
		return katashiky;
	}

	public void setKatashiky(String katashiky) {
		this.katashiky = katashiky;
	}

}