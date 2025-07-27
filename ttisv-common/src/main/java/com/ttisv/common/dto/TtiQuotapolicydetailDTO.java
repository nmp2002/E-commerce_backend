package com.ttisv.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class TtiQuotapolicydetailDTO implements Serializable {

	private static final long serialVersionUID = 6613114896428448138L;

	private Long id;

	private Long quotaid;

	private Long quotapolicyid;

	private Long quotapolicyinsuranceid;

	private String quotapolicyno;

	private String insurancefeecode;

	private String insurancefeename;

	private String insuranceitemcode;

	private String insuranceitemname;

	private String insuranceproductcode;

	private String insuranceproductname;

	private String itemtypecode;

	private String itemtypename;

	@Temporal(TemporalType.DATE)
	private Date begindate;

	private Date modifiedDate;

	private String modifiedby;

	private String createdby;

	private Date createdDate;

	private String currencyid;

	private BigDecimal dealercommission;

	private BigDecimal dealersupportfee;
	private BigDecimal deductible;
	private String prtypedeductible;
	private BigDecimal prldeductibleval;
	private BigDecimal deductibleval;
	private String deductibleunitVal;

	private BigDecimal val;
	private String unitVal;
	private BigDecimal prlimitval;
	private String prtypelimit;

	private BigDecimal disbfvat;

	private BigDecimal disbfvatfee;

	private BigDecimal discountamountaftervat;

	private BigDecimal discountbyrate;

	private Date enddate;

	private BigDecimal incurreddealersupportfee;

	private BigDecimal incurreddrcommission;

	private BigDecimal incurreditfee;

	private BigDecimal incurredpremiumafvat;

	private BigDecimal incurredpremiumbfvat;

	private BigDecimal incurredttisvcommission;

	private BigDecimal itfee;

	private BigDecimal premiumafterdisbfvat;

	private BigDecimal premiumafterdiscountafvat;

	private BigDecimal premiumaftervat;

	private BigDecimal premiumrateafdisbfvat;

	private BigDecimal premiumrateafterdisafvat;

	private BigDecimal premiumrateaftervat;

	private BigDecimal rateexchange;

	private BigDecimal suninsure;

	private BigDecimal tax;

	private String taxcode;

	private BigDecimal taxinsurance;

	private BigDecimal taxofdealercommission;

	private BigDecimal taxofdealersupportfee;

	private BigDecimal taxofincurreddealercom;

	private BigDecimal taxofincurreddealersupfee;

	private BigDecimal taxofincurreditfee;

	private BigDecimal taxofincurredttisvcommission;

	private BigDecimal taxofitfee;

	private BigDecimal taxofttisvcommission;

	private BigDecimal ttisvcommission;

	private BigDecimal percentval;

	private BigDecimal priceval;

	private String timeinsurance;

	private String additionaltermcode;

	private String additionaltermname;

	private String isAdditionalterm;

	private String isfix;

	private String desciption;

	private List<TtiQuotaFeeDTO> quotafees;

	private TtiQuotaFeeDTO feeminimumproduct;

	private List<TtiQuotaFeeDTO> discountfeeproductlst;

	private List<TtiQuotapolicydetailDTO> insuranceproductaddlst;

	private TtiQuotaFeeDTO insuranceriskproduct;

	private String quotano;

	private String policytypeid;

	private Date effectivefrom;

	private Date effectiveto;

	private String status;

	private String includevat;

	private String quotapolicyNote;

	private BigDecimal netfee;

	private BigDecimal discountval;

	private BigDecimal payFee;

	private BigDecimal sumbfFee;

	private BigDecimal unitPrice;
	private BigDecimal tylephitinhtoanBase;
	private BigDecimal sotienphitinhtoanBase;
	private String wordingtype;
	private TtiQuotaFeeDTO insuranceproductlimit;
	private TtiQuotaFeeDTO insuranceproductdeductible;
	private String deductibleid_data;
	private String limitid_data;
	private List<TtiQuotaFeeDTO> productdeductiblelst;

	private List<TtiQuotaFeeDTO> insuranceproductlimitlst;

	private BigDecimal sumPriceval;

	private BigDecimal sumpricevalbf;

	private BigDecimal riskFee;

	private BigDecimal discountmoney;

	private BigDecimal discountpercent;

	private BigDecimal disbfratevatfee;
	private BigDecimal tylephitinhtoan;
	private BigDecimal sotienphitinhtoan;
	private BigDecimal sotienphithucte;
	private BigDecimal ratephithucte;
	private BigDecimal sotienphitruocVat;
	private boolean isreaddonly;
	private BigDecimal minfee;
	private BigDecimal sotienphitinhtoanold;
	private BigDecimal sotienphithucteold;
	private BigDecimal tongphigiamold;
	private BigDecimal pricevalbf;
	private BigDecimal percentvalbf;
	private Integer seatingcapacity;
	private Integer insuranceDays;

	private BigDecimal sotienphitruoc;
	private BigDecimal sotienphisau;

	private BigDecimal discountclaim;
	private BigDecimal claimRate;
	private BigDecimal sotienphiPolicy;
	private BigDecimal sotienphiPolicyold;
	private String claimcode;
	private BigDecimal taxRate;
	private String commissionproductcode;
	public Integer getSeatingcapacity() {
		return seatingcapacity;
	}

	public void setSeatingcapacity(Integer seatingcapacity) {
		this.seatingcapacity = seatingcapacity;
	}

	public Integer getInsuranceDays() {
		return insuranceDays;
	}

	public void setInsuranceDays(Integer insuranceDays) {
		this.insuranceDays = insuranceDays;
	}

	public Integer getInsuranceYears() {
		return insuranceYears;
	}

	public void setInsuranceYears(Integer insuranceYears) {
		this.insuranceYears = insuranceYears;
	}

	private Integer insuranceYears;

	public BigDecimal getPricevalbf() {
		return pricevalbf;
	}

	public void setPricevalbf(BigDecimal pricevalbf) {
		this.pricevalbf = pricevalbf;
	}

	public BigDecimal getPercentvalbf() {
		return percentvalbf;
	}

	public void setPercentvalbf(BigDecimal percentvalbf) {
		this.percentvalbf = percentvalbf;
	}

	public BigDecimal getMinfee() {
		return minfee;
	}

	public void setMinfee(BigDecimal minfee) {
		this.minfee = minfee;
	}

	public BigDecimal getSotienphitinhtoanold() {
		return sotienphitinhtoanold;
	}

	public void setSotienphitinhtoanold(BigDecimal sotienphitinhtoanold) {
		this.sotienphitinhtoanold = sotienphitinhtoanold;
	}

	public BigDecimal getSotienphithucteold() {
		return sotienphithucteold;
	}

	public void setSotienphithucteold(BigDecimal sotienphithucteold) {
		this.sotienphithucteold = sotienphithucteold;
	}

	public TtiQuotapolicydetailDTO() {
	}

	public boolean isIsreaddonly() {
		return isreaddonly;
	}

	public void setIsreaddonly(boolean isreaddonly) {
		this.isreaddonly = isreaddonly;
	}

	public Date getBegindate() {
		return this.begindate;
	}

	public void setBegindate(Date begindate) {
		this.begindate = begindate;
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

	public String getCurrencyid() {
		return this.currencyid;
	}

	public void setCurrencyid(String currencyid) {
		this.currencyid = currencyid;
	}

	public BigDecimal getDealercommission() {
		return this.dealercommission;
	}

	public void setDealercommission(BigDecimal dealercommission) {
		this.dealercommission = dealercommission;
	}

	public BigDecimal getDealersupportfee() {
		return this.dealersupportfee;
	}

	public void setDealersupportfee(BigDecimal dealersupportfee) {
		this.dealersupportfee = dealersupportfee;
	}

	public BigDecimal getDeductible() {
		return this.deductible;
	}

	public void setDeductible(BigDecimal deductible) {
		this.deductible = deductible;
	}

	public BigDecimal getDisbfvat() {
		return this.disbfvat;
	}

	public void setDisbfvat(BigDecimal disbfvat) {
		this.disbfvat = disbfvat;
	}

	public BigDecimal getDisbfvatfee() {
		return this.disbfvatfee;
	}

	public void setDisbfvatfee(BigDecimal disbfvatfee) {
		this.disbfvatfee = disbfvatfee;
	}

	public BigDecimal getDiscountamountaftervat() {
		return this.discountamountaftervat;
	}

	public void setDiscountamountaftervat(BigDecimal discountamountaftervat) {
		this.discountamountaftervat = discountamountaftervat;
	}

	public BigDecimal getDiscountbyrate() {
		return this.discountbyrate;
	}

	public void setDiscountbyrate(BigDecimal discountbyrate) {
		this.discountbyrate = discountbyrate;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getIncurreddealersupportfee() {
		return this.incurreddealersupportfee;
	}

	public void setIncurreddealersupportfee(BigDecimal incurreddealersupportfee) {
		this.incurreddealersupportfee = incurreddealersupportfee;
	}

	public BigDecimal getIncurreddrcommission() {
		return this.incurreddrcommission;
	}

	public void setIncurreddrcommission(BigDecimal incurreddrcommission) {
		this.incurreddrcommission = incurreddrcommission;
	}

	public BigDecimal getIncurreditfee() {
		return this.incurreditfee;
	}

	public void setIncurreditfee(BigDecimal incurreditfee) {
		this.incurreditfee = incurreditfee;
	}

	public BigDecimal getIncurredpremiumafvat() {
		return this.incurredpremiumafvat;
	}

	public void setIncurredpremiumafvat(BigDecimal incurredpremiumafvat) {
		this.incurredpremiumafvat = incurredpremiumafvat;
	}

	public BigDecimal getIncurredpremiumbfvat() {
		return this.incurredpremiumbfvat;
	}

	public void setIncurredpremiumbfvat(BigDecimal incurredpremiumbfvat) {
		this.incurredpremiumbfvat = incurredpremiumbfvat;
	}

	public BigDecimal getIncurredttisvcommission() {
		return this.incurredttisvcommission;
	}

	public void setIncurredttisvcommission(BigDecimal incurredttisvcommission) {
		this.incurredttisvcommission = incurredttisvcommission;
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

	public BigDecimal getItfee() {
		return this.itfee;
	}

	public void setItfee(BigDecimal itfee) {
		this.itfee = itfee;
	}

	public BigDecimal getPremiumafterdisbfvat() {
		return this.premiumafterdisbfvat;
	}

	public void setPremiumafterdisbfvat(BigDecimal premiumafterdisbfvat) {
		this.premiumafterdisbfvat = premiumafterdisbfvat;
	}

	public BigDecimal getPremiumafterdiscountafvat() {
		return this.premiumafterdiscountafvat;
	}

	public void setPremiumafterdiscountafvat(BigDecimal premiumafterdiscountafvat) {
		this.premiumafterdiscountafvat = premiumafterdiscountafvat;
	}

	public BigDecimal getPremiumaftervat() {
		return this.premiumaftervat;
	}

	public void setPremiumaftervat(BigDecimal premiumaftervat) {
		this.premiumaftervat = premiumaftervat;
	}

	public BigDecimal getPremiumrateafdisbfvat() {
		return this.premiumrateafdisbfvat;
	}

	public void setPremiumrateafdisbfvat(BigDecimal premiumrateafdisbfvat) {
		this.premiumrateafdisbfvat = premiumrateafdisbfvat;
	}

	public BigDecimal getPremiumrateafterdisafvat() {
		return this.premiumrateafterdisafvat;
	}

	public void setPremiumrateafterdisafvat(BigDecimal premiumrateafterdisafvat) {
		this.premiumrateafterdisafvat = premiumrateafterdisafvat;
	}

	public BigDecimal getPremiumrateaftervat() {
		return this.premiumrateaftervat;
	}

	public void setPremiumrateaftervat(BigDecimal premiumrateaftervat) {
		this.premiumrateaftervat = premiumrateaftervat;
	}

	public Long getQuotaid() {
		return this.quotaid;
	}

	public void setQuotaid(Long quotaid) {
		this.quotaid = quotaid;
	}

	public Long getQuotapolicyid() {
		return this.quotapolicyid;
	}

	public void setQuotapolicyid(Long quotapolicyid) {
		this.quotapolicyid = quotapolicyid;
	}

	public Long getQuotapolicyinsuranceid() {
		return this.quotapolicyinsuranceid;
	}

	public void setQuotapolicyinsuranceid(Long quotapolicyinsuranceid) {
		this.quotapolicyinsuranceid = quotapolicyinsuranceid;
	}

	public String getQuotapolicyno() {
		return this.quotapolicyno;
	}

	public void setQuotapolicyno(String quotapolicyno) {
		this.quotapolicyno = quotapolicyno;
	}

	public BigDecimal getRateexchange() {
		return this.rateexchange;
	}

	public void setRateexchange(BigDecimal rateexchange) {
		this.rateexchange = rateexchange;
	}

	public BigDecimal getSuninsure() {
		return this.suninsure;
	}

	public void setSuninsure(BigDecimal suninsure) {
		this.suninsure = suninsure;
	}

	public BigDecimal getTax() {
		return this.tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public String getTaxcode() {
		return this.taxcode;
	}

	public void setTaxcode(String taxcode) {
		this.taxcode = taxcode;
	}

	public BigDecimal getTaxinsurance() {
		return this.taxinsurance;
	}

	public void setTaxinsurance(BigDecimal taxinsurance) {
		this.taxinsurance = taxinsurance;
	}

	public BigDecimal getTaxofdealercommission() {
		return this.taxofdealercommission;
	}

	public void setTaxofdealercommission(BigDecimal taxofdealercommission) {
		this.taxofdealercommission = taxofdealercommission;
	}

	public BigDecimal getTaxofdealersupportfee() {
		return this.taxofdealersupportfee;
	}

	public void setTaxofdealersupportfee(BigDecimal taxofdealersupportfee) {
		this.taxofdealersupportfee = taxofdealersupportfee;
	}

	public BigDecimal getTaxofincurreddealercom() {
		return this.taxofincurreddealercom;
	}

	public void setTaxofincurreddealercom(BigDecimal taxofincurreddealercom) {
		this.taxofincurreddealercom = taxofincurreddealercom;
	}

	public BigDecimal getTaxofincurreddealersupfee() {
		return this.taxofincurreddealersupfee;
	}

	public void setTaxofincurreddealersupfee(BigDecimal taxofincurreddealersupfee) {
		this.taxofincurreddealersupfee = taxofincurreddealersupfee;
	}

	public BigDecimal getTaxofincurreditfee() {
		return this.taxofincurreditfee;
	}

	public void setTaxofincurreditfee(BigDecimal taxofincurreditfee) {
		this.taxofincurreditfee = taxofincurreditfee;
	}

	public BigDecimal getTaxofincurredttisvcommission() {
		return this.taxofincurredttisvcommission;
	}

	public void setTaxofincurredttisvcommission(BigDecimal taxofincurredttisvcommission) {
		this.taxofincurredttisvcommission = taxofincurredttisvcommission;
	}

	public BigDecimal getTaxofitfee() {
		return this.taxofitfee;
	}

	public void setTaxofitfee(BigDecimal taxofitfee) {
		this.taxofitfee = taxofitfee;
	}

	public BigDecimal getTaxofttisvcommission() {
		return this.taxofttisvcommission;
	}

	public void setTaxofttisvcommission(BigDecimal taxofttisvcommission) {
		this.taxofttisvcommission = taxofttisvcommission;
	}

	public BigDecimal getTtisvcommission() {
		return this.ttisvcommission;
	}

	public void setTtisvcommission(BigDecimal ttisvcommission) {
		this.ttisvcommission = ttisvcommission;
	}

	public BigDecimal getPercentval() {
		return percentval;
	}

	public void setPercentval(BigDecimal percentval) {
		this.percentval = percentval;
	}

	public BigDecimal getPriceval() {
		return priceval;
	}

	public void setPriceval(BigDecimal priceval) {
		this.priceval = priceval;
	}

	public String getTimeinsurance() {
		return timeinsurance;
	}

	public void setTimeinsurance(String timeinsurance) {
		this.timeinsurance = timeinsurance;
	}

	public String getQuotano() {
		return quotano;
	}

	public void setQuotano(String quotano) {
		this.quotano = quotano;
	}

	public String getPolicytypeid() {
		return policytypeid;
	}

	public void setPolicytypeid(String policytypeid) {
		this.policytypeid = policytypeid;
	}

	public Date getEffectivefrom() {
		return effectivefrom;
	}

	public void setEffectivefrom(Date effectivefrom) {
		this.effectivefrom = effectivefrom;
	}

	public Date getEffectiveto() {
		return effectiveto;
	}

	public void setEffectiveto(Date effectiveto) {
		this.effectiveto = effectiveto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIncludevat() {
		return includevat;
	}

	public void setIncludevat(String includevat) {
		this.includevat = includevat;
	}

	public String getQuotapolicyNote() {
		return quotapolicyNote;
	}

	public void setQuotapolicyNote(String quotapolicyNote) {
		this.quotapolicyNote = quotapolicyNote;
	}

	public BigDecimal getNetfee() {
		return netfee;
	}

	public void setNetfee(BigDecimal netfee) {
		this.netfee = netfee;
	}

	public BigDecimal getDiscountval() {
		return discountval;
	}

	public void setDiscountval(BigDecimal discountval) {
		this.discountval = discountval;
	}

	public BigDecimal getPayFee() {
		return payFee;
	}

	public void setPayFee(BigDecimal payFee) {
		this.payFee = payFee;
	}

	public BigDecimal getSumbfFee() {
		return sumbfFee;
	}

	public void setSumbfFee(BigDecimal sumbfFee) {
		this.sumbfFee = sumbfFee;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getAdditionaltermcode() {
		return additionaltermcode;
	}

	public void setAdditionaltermcode(String additionaltermcode) {
		this.additionaltermcode = additionaltermcode;
	}

	public String getAdditionaltermname() {
		return additionaltermname;
	}

	public void setAdditionaltermname(String additionaltermname) {
		this.additionaltermname = additionaltermname;
	}

	public String getIsAdditionalterm() {
		return isAdditionalterm;
	}

	public void setIsAdditionalterm(String isAdditionalterm) {
		this.isAdditionalterm = isAdditionalterm;
	}

	public String getIsfix() {
		return isfix;
	}

	public void setIsfix(String isfix) {
		this.isfix = isfix;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public String getWordingtype() {
		return wordingtype;
	}

	public void setWordingtype(String wordingtype) {
		this.wordingtype = wordingtype;
	}

	public List<TtiQuotapolicydetailDTO> getInsuranceproductaddlst() {
		return insuranceproductaddlst;
	}

	public void setInsuranceproductaddlst(List<TtiQuotapolicydetailDTO> insuranceproductaddlst) {
		this.insuranceproductaddlst = insuranceproductaddlst;
	}

	public List<TtiQuotaFeeDTO> getQuotafees() {
		return quotafees;
	}

	public void setQuotafees(List<TtiQuotaFeeDTO> quotafees) {
		this.quotafees = quotafees;
	}

	public TtiQuotaFeeDTO getFeeminimumproduct() {
		return feeminimumproduct;
	}

	public void setFeeminimumproduct(TtiQuotaFeeDTO feeminimumproduct) {
		this.feeminimumproduct = feeminimumproduct;
	}

	public List<TtiQuotaFeeDTO> getDiscountfeeproductlst() {
		return discountfeeproductlst;
	}

	public void setDiscountfeeproductlst(List<TtiQuotaFeeDTO> discountfeeproductlst) {
		this.discountfeeproductlst = discountfeeproductlst;
	}

	public TtiQuotaFeeDTO getInsuranceriskproduct() {
		return insuranceriskproduct;
	}

	public void setInsuranceriskproduct(TtiQuotaFeeDTO insuranceriskproduct) {
		this.insuranceriskproduct = insuranceriskproduct;
	}

	public TtiQuotaFeeDTO getInsuranceproductlimit() {
		return insuranceproductlimit;
	}

	public void setInsuranceproductlimit(TtiQuotaFeeDTO insuranceproductlimit) {
		this.insuranceproductlimit = insuranceproductlimit;
	}

	public TtiQuotaFeeDTO getInsuranceproductdeductible() {
		return insuranceproductdeductible;
	}

	public void setInsuranceproductdeductible(TtiQuotaFeeDTO insuranceproductdeductible) {
		this.insuranceproductdeductible = insuranceproductdeductible;
	}

	public String getPrtypedeductible() {
		return prtypedeductible;
	}

	public void setPrtypedeductible(String prtypedeductible) {
		this.prtypedeductible = prtypedeductible;
	}

	public BigDecimal getPrldeductibleval() {
		return prldeductibleval;
	}

	public void setPrldeductibleval(BigDecimal prldeductibleval) {
		this.prldeductibleval = prldeductibleval;
	}

	public BigDecimal getDeductibleval() {
		return deductibleval;
	}

	public void setDeductibleval(BigDecimal deductibleval) {
		this.deductibleval = deductibleval;
	}

	public String getDeductibleunitVal() {
		return deductibleunitVal;
	}

	public void setDeductibleunitVal(String deductibleunitVal) {
		this.deductibleunitVal = deductibleunitVal;
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

	public BigDecimal getPrlimitval() {
		return prlimitval;
	}

	public void setPrlimitval(BigDecimal prlimitval) {
		this.prlimitval = prlimitval;
	}

	public String getPrtypelimit() {
		return prtypelimit;
	}

	public void setPrtypelimit(String prtypelimit) {
		this.prtypelimit = prtypelimit;
	}

	public List<TtiQuotaFeeDTO> getProductdeductiblelst() {
		return productdeductiblelst;
	}

	public void setProductdeductiblelst(List<TtiQuotaFeeDTO> productdeductiblelst) {
		this.productdeductiblelst = productdeductiblelst;
	}

	public List<TtiQuotaFeeDTO> getInsuranceproductlimitlst() {
		return insuranceproductlimitlst;
	}

	public void setInsuranceproductlimitlst(List<TtiQuotaFeeDTO> insuranceproductlimitlst) {
		this.insuranceproductlimitlst = insuranceproductlimitlst;
	}

	public String getDeductibleid_data() {
		return deductibleid_data;
	}

	public void setDeductibleid_data(String deductibleid_data) {
		this.deductibleid_data = deductibleid_data;
	}

	public String getLimitid_data() {
		return limitid_data;
	}

	public void setLimitid_data(String limitid_data) {
		this.limitid_data = limitid_data;
	}

	public BigDecimal getSumPriceval() {
		return sumPriceval;
	}

	public void setSumPriceval(BigDecimal sumPriceval) {
		this.sumPriceval = sumPriceval;
	}

	public BigDecimal getSumpricevalbf() {
		return sumpricevalbf;
	}

	public void setSumpricevalbf(BigDecimal sumpricevalbf) {
		this.sumpricevalbf = sumpricevalbf;
	}

	public BigDecimal getRiskFee() {
		return riskFee;
	}

	public void setRiskFee(BigDecimal riskFee) {
		this.riskFee = riskFee;
	}

	public BigDecimal getDiscountmoney() {
		return discountmoney;
	}

	public void setDiscountmoney(BigDecimal discountmoney) {
		this.discountmoney = discountmoney;
	}

	public BigDecimal getDiscountpercent() {
		return discountpercent;
	}

	public void setDiscountpercent(BigDecimal discountpercent) {
		this.discountpercent = discountpercent;
	}

	public BigDecimal getDisbfratevatfee() {
		return disbfratevatfee;
	}

	public void setDisbfratevatfee(BigDecimal disbfratevatfee) {
		this.disbfratevatfee = disbfratevatfee;
	}

	public BigDecimal getTylephitinhtoan() {
		return tylephitinhtoan;
	}

	public void setTylephitinhtoan(BigDecimal tylephitinhtoan) {
		this.tylephitinhtoan = tylephitinhtoan;
	}

	public BigDecimal getSotienphitinhtoan() {
		return sotienphitinhtoan;
	}

	public void setSotienphitinhtoan(BigDecimal sotienphitinhtoan) {
		this.sotienphitinhtoan = sotienphitinhtoan;
	}

	public BigDecimal getSotienphithucte() {
		return sotienphithucte;
	}

	public void setSotienphithucte(BigDecimal sotienphithucte) {
		this.sotienphithucte = sotienphithucte;
	}

	public BigDecimal getRatephithucte() {
		return ratephithucte;
	}

	public void setRatephithucte(BigDecimal ratephithucte) {
		this.ratephithucte = ratephithucte;
	}

	public BigDecimal getTongphigiamold() {
		return tongphigiamold;
	}

	public void setTongphigiamold(BigDecimal tongphigiamold) {
		this.tongphigiamold = tongphigiamold;
	}

	public BigDecimal getSotienphitruoc() {
		return sotienphitruoc;
	}

	public void setSotienphitruoc(BigDecimal sotienphitruoc) {
		this.sotienphitruoc = sotienphitruoc;
	}

	public BigDecimal getSotienphisau() {
		return sotienphisau;
	}

	public void setSotienphisau(BigDecimal sotienphisau) {
		this.sotienphisau = sotienphisau;
	}

	public BigDecimal getDiscountclaim() {
		return discountclaim;
	}

	public void setDiscountclaim(BigDecimal discountclaim) {
		this.discountclaim = discountclaim;
	}



	public BigDecimal getClaimRate() {
		return claimRate;
	}

	public void setClaimRate(BigDecimal claimRate) {
		this.claimRate = claimRate;
	}

	public BigDecimal getSotienphiPolicy() {
		return sotienphiPolicy;
	}

	public void setSotienphiPolicy(BigDecimal sotienphiPolicy) {
		this.sotienphiPolicy = sotienphiPolicy;
	}

	public String getClaimcode() {
		return claimcode;
	}

	public void setClaimcode(String claimcode) {
		this.claimcode = claimcode;
	}

	public BigDecimal getSotienphiPolicyold() {
		return sotienphiPolicyold;
	}

	public void setSotienphiPolicyold(BigDecimal sotienphiPolicyold) {
		this.sotienphiPolicyold = sotienphiPolicyold;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public BigDecimal getSotienphitruocVat() {
		return sotienphitruocVat;
	}

	public void setSotienphitruocVat(BigDecimal sotienphitruocVat) {
		this.sotienphitruocVat = sotienphitruocVat;
	}

	public BigDecimal getTylephitinhtoanBase() {
		return tylephitinhtoanBase;
	}

	public void setTylephitinhtoanBase(BigDecimal tylephitinhtoanBase) {
		this.tylephitinhtoanBase = tylephitinhtoanBase;
	}

	public BigDecimal getSotienphitinhtoanBase() {
		return sotienphitinhtoanBase;
	}

	public void setSotienphitinhtoanBase(BigDecimal sotienphitinhtoanBase) {
		this.sotienphitinhtoanBase = sotienphitinhtoanBase;
	}

	public String getCommissionproductcode() {
		return commissionproductcode;
	}

	public void setCommissionproductcode(String commissionproductcode) {
		this.commissionproductcode = commissionproductcode;
	}
	
	
	
}