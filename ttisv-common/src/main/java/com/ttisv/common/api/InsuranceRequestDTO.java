package com.ttisv.common.api;

import java.io.Serializable;
import java.math.BigDecimal;

import com.google.gson.annotations.Expose;

public class InsuranceRequestDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@Expose(serialize = false)
	private transient Long contractid;
	@Expose(serialize = false)
	private transient Long quotaid;
	@Expose(serialize = false)
	private transient Long quotapolicyid;
	private String contractsCWDNumber;
	private String insuranceNumber;
	private int formOfSale;
	private String insuranceNumberOld;
	private String insuranceFromDate;
	private String insuranceToDate;
	private String campaignCode;
	private String discountCode;
	private String vinNo;
	private String usesInsurance;
	private String usesInsuranceObligatory;
	private String insurancePackage;
	private BigDecimal insuranceMoney;
	private BigDecimal liabilityLevel;
	private BigDecimal liabilityLevelOfPeople;
	private BigDecimal liabilityLevelOfProperty;
	private BigDecimal liabilityInsuranceMoney;
	private BigDecimal accessoryInsuranceMoney;
	private BigDecimal insuranceTotalPriceObligatory;
	private String dealerCode;

	public InsuranceRequestDTO() {
		super();
	}

	public Long getContractid() {
		return contractid;
	}

	public void setContractid(Long contractid) {
		this.contractid = contractid;
	}

	public Long getQuotaid() {
		return quotaid;
	}

	public void setQuotaid(Long quotaid) {
		this.quotaid = quotaid;
	}

	public Long getQuotapolicyid() {
		return quotapolicyid;
	}

	public void setQuotapolicyid(Long quotapolicyid) {
		this.quotapolicyid = quotapolicyid;
	}

	public String getContractsCWDNumber() {
		return contractsCWDNumber;
	}

	public void setContractsCWDNumber(String contractsCWDNumber) {
		this.contractsCWDNumber = contractsCWDNumber;
	}

	public String getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	public int getFormOfSale() {
		return formOfSale;
	}

	public void setFormOfSale(int formOfSale) {
		this.formOfSale = formOfSale;
	}

	public String getInsuranceNumberOld() {
		return insuranceNumberOld;
	}

	public void setInsuranceNumberOld(String insuranceNumberOld) {
		this.insuranceNumberOld = insuranceNumberOld;
	}

	public String getInsuranceFromDate() {
		return insuranceFromDate;
	}

	public void setInsuranceFromDate(String insuranceFromDate) {
		this.insuranceFromDate = insuranceFromDate;
	}

	public String getInsuranceToDate() {
		return insuranceToDate;
	}

	public void setInsuranceToDate(String insuranceToDate) {
		this.insuranceToDate = insuranceToDate;
	}

	public String getCampaignCode() {
		return campaignCode;
	}

	public void setCampaignCode(String campaignCode) {
		this.campaignCode = campaignCode;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public String getVinNo() {
		return vinNo;
	}

	public void setVinNo(String vinNo) {
		this.vinNo = vinNo;
	}

	public String getUsesInsurance() {
		return usesInsurance;
	}

	public void setUsesInsurance(String usesInsurance) {
		this.usesInsurance = usesInsurance;
	}

	public String getUsesInsuranceObligatory() {
		return usesInsuranceObligatory;
	}

	public void setUsesInsuranceObligatory(String usesInsuranceObligatory) {
		this.usesInsuranceObligatory = usesInsuranceObligatory;
	}

	public String getInsurancePackage() {
		return insurancePackage;
	}

	public void setInsurancePackage(String insurancePackage) {
		this.insurancePackage = insurancePackage;
	}

	public BigDecimal getInsuranceMoney() {
		return insuranceMoney;
	}

	public void setInsuranceMoney(BigDecimal insuranceMoney) {
		this.insuranceMoney = insuranceMoney;
	}

	public BigDecimal getLiabilityLevel() {
		return liabilityLevel;
	}

	public void setLiabilityLevel(BigDecimal liabilityLevel) {
		this.liabilityLevel = liabilityLevel;
	}

	public BigDecimal getLiabilityLevelOfPeople() {
		return liabilityLevelOfPeople;
	}

	public void setLiabilityLevelOfPeople(BigDecimal liabilityLevelOfPeople) {
		this.liabilityLevelOfPeople = liabilityLevelOfPeople;
	}

	public BigDecimal getLiabilityLevelOfProperty() {
		return liabilityLevelOfProperty;
	}

	public void setLiabilityLevelOfProperty(BigDecimal liabilityLevelOfProperty) {
		this.liabilityLevelOfProperty = liabilityLevelOfProperty;
	}

	public BigDecimal getLiabilityInsuranceMoney() {
		return liabilityInsuranceMoney;
	}

	public void setLiabilityInsuranceMoney(BigDecimal liabilityInsuranceMoney) {
		this.liabilityInsuranceMoney = liabilityInsuranceMoney;
	}

	public BigDecimal getAccessoryInsuranceMoney() {
		return accessoryInsuranceMoney;
	}

	public void setAccessoryInsuranceMoney(BigDecimal accessoryInsuranceMoney) {
		this.accessoryInsuranceMoney = accessoryInsuranceMoney;
	}

	public BigDecimal getInsuranceTotalPriceObligatory() {
		return insuranceTotalPriceObligatory;
	}

	public void setInsuranceTotalPriceObligatory(BigDecimal insuranceTotalPriceObligatory) {
		this.insuranceTotalPriceObligatory = insuranceTotalPriceObligatory;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}
}
