package com.ttisv.common.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TtiQuoteaccessoryDTO {

	private Long id;

	private String accessorycode;

	private String accessoryname;

	private BigDecimal amount;

	private Long caraccessoriesid;

	private String carbrandcode;

	private String carmodelcode;

	private String ccy;

	private String iscancel;

	private String legal;

	private String note;

	private BigDecimal percent;

	private BigDecimal price;

	private Integer quantity;

	private Long quotaid;

	private String quotano;

	private Long quotapolicyid;

	private String quotapolicyno;

	private Long quotapolicydetailid;

	private String additionaltermcode;

	private String insuranceproductcode;

	public TtiQuoteaccessoryDTO() {
	}

	public String getAccessorycode() {
		return this.accessorycode;
	}

	public void setAccessorycode(String accessorycode) {
		this.accessorycode = accessorycode;
	}

	public String getAccessoryname() {
		return this.accessoryname;
	}

	public void setAccessoryname(String accessoryname) {
		this.accessoryname = accessoryname;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Long getCaraccessoriesid() {
		return this.caraccessoriesid;
	}

	public void setCaraccessoriesid(Long caraccessoriesid) {
		this.caraccessoriesid = caraccessoriesid;
	}

	public String getCarbrandcode() {
		return this.carbrandcode;
	}

	public void setCarbrandcode(String carbrandcode) {
		this.carbrandcode = carbrandcode;
	}

	public String getCarmodelcode() {
		return this.carmodelcode;
	}

	public void setCarmodelcode(String carmodelcode) {
		this.carmodelcode = carmodelcode;
	}

	public String getCcy() {
		return this.ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIscancel() {
		return this.iscancel;
	}

	public void setIscancel(String iscancel) {
		this.iscancel = iscancel;
	}

	public String getLegal() {
		return this.legal;
	}

	public void setLegal(String legal) {
		this.legal = legal;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public BigDecimal getPercent() {
		return this.percent;
	}

	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getQuotaid() {
		return this.quotaid;
	}

	public void setQuotaid(Long quotaid) {
		this.quotaid = quotaid;
	}

	public String getQuotano() {
		return this.quotano;
	}

	public void setQuotano(String quotano) {
		this.quotano = quotano;
	}

	public Long getQuotapolicyid() {
		return this.quotapolicyid;
	}

	public void setQuotapolicyid(Long quotapolicyid) {
		this.quotapolicyid = quotapolicyid;
	}

	public String getQuotapolicyno() {
		return this.quotapolicyno;
	}

	public void setQuotapolicyno(String quotapolicyno) {
		this.quotapolicyno = quotapolicyno;
	}

	public Long getQuotapolicydetailid() {
		return quotapolicydetailid;
	}

	public void setQuotapolicydetailid(Long quotapolicydetailid) {
		this.quotapolicydetailid = quotapolicydetailid;
	}

	public String getAdditionaltermcode() {
		return additionaltermcode;
	}

	public void setAdditionaltermcode(String additionaltermcode) {
		this.additionaltermcode = additionaltermcode;
	}

	public String getInsuranceproductcode() {
		return insuranceproductcode;
	}

	public void setInsuranceproductcode(String insuranceproductcode) {
		this.insuranceproductcode = insuranceproductcode;
	}

}