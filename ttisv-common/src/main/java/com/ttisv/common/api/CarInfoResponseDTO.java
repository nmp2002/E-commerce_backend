package com.ttisv.common.api;

import java.util.List;

import com.ttisv.common.utils.StringUtils;

public class CarInfoResponseDTO {
	private List<CarInfo> result;
	private String targetUrl;
	private boolean success;
	private boolean error;
	private boolean unAuthorizedRequest;
	private boolean __abp;

	public List<CarInfo> getResult() {
		return result;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public boolean isSuccess() {
		return success;
	}

	public boolean isError() {
		return error;
	}

	public boolean isUnAuthorizedRequest() {
		return unAuthorizedRequest;
	}

	public boolean is__abp() {
		return __abp;
	}

	public void setResult(List<CarInfo> result) {
		this.result = result;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public void setUnAuthorizedRequest(boolean unAuthorizedRequest) {
		this.unAuthorizedRequest = unAuthorizedRequest;
	}

	public void set__abp(boolean __abp) {
		this.__abp = __abp;
	}

	public class CarInfo {
		private Long id;
		private String carCompany;
		private String carCompanyForm;
		private boolean iscarCompany;
		private String  cfNameForm;
		private String commercialNameForm;
		private String carVersionForm;
		private String cfName;
		private boolean iscfName;
		private String carLife;
		private String carVersion;
		private String numberOfSeats;
		private String carTonnage;
		private String commercialName;
		private boolean iscommercialName;
		private String grade;
		private String gradePro;
		private String katashiky;
		private String fuel;
		private String gear;
		private String deliveryDate;
		private String lineOfMonth;
		private String lineOffDate;
		private String saleDate;
		private String vinNo;
		private String engine;
		private String price;
		private String priceTT;
		private boolean isreadngaysx;
		public String getPriceTT() {
			return priceTT;
		}

		public void setPriceTT(String priceTT) {
			this.priceTT = priceTT;
		}

		private String priceVat;

		private String note="";
		public Long getId() {
			return id;
		}

		public String getCarCompany() {
			if (StringUtils.isNotEmpty(carCompany))
				carCompany = carCompany.toUpperCase();
			return carCompany;
		}

		public String getCfName() {
			if (StringUtils.isNotEmpty(cfName))
				cfName = cfName.toUpperCase();
			return cfName;
		}

		public String getCarLife() {
			return carLife;
		}

		public String getCarVersion() {
			if (StringUtils.isNotEmpty(carVersion))
				carVersion = carVersion.toUpperCase();
			return carVersion;
		}

		public String getNumberOfSeats() {
			return numberOfSeats;
		}

		public String getCarTonnage() {
			return carTonnage;
		}

		public String getCommercialName() {
			if (StringUtils.isNotEmpty(commercialName))
				commercialName = commercialName.toUpperCase();
			return commercialName;
		}

		public String getGrade() {
			return grade;
		}

		public String getGradePro() {
			return gradePro;
		}

		public String getKatashiky() {
			return katashiky;
		}

		public String getFuel() {
			return fuel;
		}

		public String getGear() {
			return gear;
		}

		public String getDeliveryDate() {
			return deliveryDate;
		}

		public String getLineOfMonth() {
			return lineOfMonth;
		}

		public String getLineOffDate() {
			return lineOffDate;
		}

		public String getSaleDate() {
			return saleDate;
		}

		public String getVinNo() {
			return vinNo;
		}

		public String getEngine() {
			return engine;
		}

		public String getPrice() {
			return price;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public void setCarCompany(String carCompany) {
			if (StringUtils.isNotEmpty(carCompany))
				carCompany = carCompany.toUpperCase();
			this.carCompany = carCompany;
		}

		public void setCfName(String cfName) {
			if (StringUtils.isNotEmpty(cfName))
				cfName = cfName.toUpperCase();
			this.cfName = cfName;
		}

		public void setCarLife(String carLife) {
			this.carLife = carLife;
		}

		public void setCarVersion(String carVersion) {
			if (StringUtils.isNotEmpty(carVersion))
				carVersion = carVersion.toUpperCase();
			this.carVersion = carVersion;
		}

		public void setNumberOfSeats(String numberOfSeats) {
			this.numberOfSeats = numberOfSeats;
		}

		public void setCarTonnage(String carTonnage) {
			this.carTonnage = carTonnage;
		}

		public void setCommercialName(String commercialName) {
			if (StringUtils.isNotEmpty(commercialName))
				commercialName = commercialName.toUpperCase();
			this.commercialName = commercialName;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}

		public void setGradePro(String gradePro) {
			this.gradePro = gradePro;
		}

		public void setKatashiky(String katashiky) {
			this.katashiky = katashiky;
		}

		public void setFuel(String fuel) {
			this.fuel = fuel;
		}

		public void setGear(String gear) {
			this.gear = gear;
		}

		public void setDeliveryDate(String deliveryDate) {
			this.deliveryDate = deliveryDate;
		}

		public void setLineOfMonth(String lineOfMonth) {
			this.lineOfMonth = lineOfMonth;
		}

		public void setLineOffDate(String lineOffDate) {
			this.lineOffDate = lineOffDate;
		}

		public void setSaleDate(String saleDate) {
			this.saleDate = saleDate;
		}

		public void setVinNo(String vinNo) {
			this.vinNo = vinNo;
		}

		public void setEngine(String engine) {
			this.engine = engine;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getCarCompanyForm() {
			return carCompanyForm;
		}

		public void setCarCompanyForm(String carCompanyForm) {
			this.carCompanyForm = carCompanyForm;
		}

		public String getCfNameForm() {
			return cfNameForm;
		}

		public void setCfNameForm(String cfNameForm) {
			this.cfNameForm = cfNameForm;
		}

		public String getCommercialNameForm() {
			return commercialNameForm;
		}

		public void setCommercialNameForm(String commercialNameForm) {
			this.commercialNameForm = commercialNameForm;
		}

		public String getCarVersionForm() {
			return carVersionForm;
		}

		public void setCarVersionForm(String carVersionForm) {
			this.carVersionForm = carVersionForm;
		}

		public String getNote() {
			return note;
		}

		public void setNote(String note) {
			
			this.note = note;
		}

		public boolean isIscarCompany() {
			return iscarCompany;
		}

		public void setIscarCompany(boolean iscarCompany) {
			this.iscarCompany = iscarCompany;
		}

		public boolean isIscfName() {
			return iscfName;
		}

		public void setIscfName(boolean iscfName) {
			this.iscfName = iscfName;
		}

		public boolean isIscommercialName() {
			return iscommercialName;
		}

		public void setIscommercialName(boolean iscommercialName) {
			this.iscommercialName = iscommercialName;
		}

		public String getPriceVat() {
			return priceVat;
		}

		public void setPriceVat(String priceVat) {
			this.priceVat = priceVat;
		}

		public boolean isIsreadngaysx() {
			return isreadngaysx;
		}

		public void setIsreadngaysx(boolean isreadngaysx) {
			this.isreadngaysx = isreadngaysx;
		}
		
		
	}
}
