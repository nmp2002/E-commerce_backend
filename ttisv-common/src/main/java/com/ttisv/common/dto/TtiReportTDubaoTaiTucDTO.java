package com.ttisv.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TtiReportTDubaoTaiTucDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String agentcode;

	private String agentname;

	private String areacode;

	private String areaname;

	private String officebrcd;

	private String officebrcdName;

	private String officecode;

	private String officename;

	private Long quoteid;

	private String quoteno;

	private Date quotedate;

	private String quotatypeid;

	private Long quotapolicyid;

	private String quotapolicyno;

	private Long contractid;

	private String contractno;

	private Date contractdate;

	private String wordingtype;

	private String policytypeid;
	
	private String policytype;


	private Date effectivefrom;

	private Date effectiveto;

	private String effectivefromtm;

	private String effectivetotm;

	private String status;

	private String createdby;

	private String salecode;

	private String salename;

	private String customercode;

	private String customername;

	private String custtype;

	private String custtypeName;

	private String custaddress;

	private String custemail;

	private String custtel;

	private String custidno;

	private String custtaxno;

	private String custprovincecd;

	private String custprovinceName;

	private String custdistrictcd;

	private String custdistrictName;

	private String custwardcd;

	private String custwardName;

	private String countrycode;

	private String countryname;
	
	private String custaddressfull;

	private String insuredname;

	private String insuredtel;

	private String insuredaddress;

	private String insuredemail;

	private String licenseplates;

	private String vinnumber;

	private String enginenumber;

	private String brandcode;

	private String brandname;

	private String modelcode;

	private String modelname;

	private String editioncode;

	private String editionname;

	private String classcode;

	private String classname;

	private String modelyear;

	private String mgfdate;

	private BigDecimal tonnage;

	private Integer seatingcapacity;

	private String capacity;

	private Date registrationdate;

	private Date lineoffmonth;

	private Date deliverydate;
	
	private Date salesdate;
	
	private String grade; 
	private String gradepro; 
	private String katashiky;
	

	private BigDecimal invoiceprice;

	private BigDecimal marketprice;

	private String purposeofuseid;

	private String purposeofusename;

	private String vehicletypeid;

	private String vehicletypename;

	private String note;

	private Long quotavehicleid;

	private String noclaim;
	private String noclaimcode;

	private String campaignid;

	private String discountid;

	private String discountval;

	private Long programid;

	private String includevat;

	private String insuranceproductcodeTV;
	private String policyTT;
	private String insuranceproductnameTV;
	private BigDecimal sotienphiPolicyVat;
	private String deductibleCode;
	private String deductiblename;
	private BigDecimal deductibleval;
	private Integer claimLoss;
	private BigDecimal amttvClaim;
	private BigDecimal rateLoss;
	private String insuranceValue;
	private String thoigianconlai;
	private Date issueddate;
	private BigDecimal giatt;
	///gói bạc
	private BigDecimal rateSilverTV; //Tỷ lệ phí tái tục bạc
	private BigDecimal sumpricevalSilverTV; //Phí trước giảm gói bạc
	private BigDecimal disbffeeSilverTV; //Giảm phí có thể áp dụng gói bạc
	private BigDecimal sotienphiSilverTV; //Số tiền phi sau giảm gói bạc(phí phải trả)
	private BigDecimal disbfratevatfeeSilverTV;
	
	///gói vang
	private BigDecimal rateGoldTV; //Tỷ lệ phí tái tục vang
	private BigDecimal sumpricevalGoldTV; //Phí trước giảm gói vang
	private BigDecimal disbffeeGoldTV; //Giảm phí có thể áp dụng gói vang
	private BigDecimal sotienphiGoldTV; //Số tiền phi sau giảm gói vang(phí phải trả)
	private BigDecimal disbfratevatfeeGoldTV;
	
	///gói kim cương
	private BigDecimal rateDiamondTV; //Tỷ lệ phí tái tục vang
	private BigDecimal sumpricevalDiamondTV; //Phí trước giảm gói vang
	private BigDecimal disbffeeDiamondTV; //Giảm phí có thể áp dụng gói vang
	private BigDecimal sotienphiDiamondTV; //Số tiền phi sau giảm gói vang(phí phải trả)
	private BigDecimal disbfratevatfeeDiamondTV;
	
	
	public String getAgentcode() {
		return agentcode;
	}
	
	public void setAgentcode(String agentcode) {
		this.agentcode = agentcode;
	}
	public String getAgentname() {
		return agentname;
	}
	public void setAgentname(String agentname) {
		this.agentname = agentname;
	}
	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getOfficebrcd() {
		return officebrcd;
	}
	public void setOfficebrcd(String officebrcd) {
		this.officebrcd = officebrcd;
	}
	public String getOfficebrcdName() {
		return officebrcdName;
	}
	public void setOfficebrcdName(String officebrcdName) {
		this.officebrcdName = officebrcdName;
	}
	public String getOfficecode() {
		return officecode;
	}
	public void setOfficecode(String officecode) {
		this.officecode = officecode;
	}
	public String getOfficename() {
		return officename;
	}
	public void setOfficename(String officename) {
		this.officename = officename;
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
	public Date getQuotedate() {
		return quotedate;
	}
	public void setQuotedate(Date quotedate) {
		this.quotedate = quotedate;
	}
	public String getQuotatypeid() {
		return quotatypeid;
	}
	public void setQuotatypeid(String quotatypeid) {
		this.quotatypeid = quotatypeid;
	}
	public Long getQuotapolicyid() {
		return quotapolicyid;
	}
	public void setQuotapolicyid(Long quotapolicyid) {
		this.quotapolicyid = quotapolicyid;
	}
	public String getQuotapolicyno() {
		return quotapolicyno;
	}
	public void setQuotapolicyno(String quotapolicyno) {
		this.quotapolicyno = quotapolicyno;
	}
	public Long getContractid() {
		return contractid;
	}
	public void setContractid(Long contractid) {
		this.contractid = contractid;
	}
	public String getContractno() {
		return contractno;
	}
	public void setContractno(String contractno) {
		this.contractno = contractno;
	}
	public Date getContractdate() {
		return contractdate;
	}
	public void setContractdate(Date contractdate) {
		this.contractdate = contractdate;
	}
	public String getWordingtype() {
		return wordingtype;
	}
	public void setWordingtype(String wordingtype) {
		this.wordingtype = wordingtype;
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
	public String getEffectivefromtm() {
		return effectivefromtm;
	}
	public void setEffectivefromtm(String effectivefromtm) {
		this.effectivefromtm = effectivefromtm;
	}
	public String getEffectivetotm() {
		return effectivetotm;
	}
	public void setEffectivetotm(String effectivetotm) {
		this.effectivetotm = effectivetotm;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getSalecode() {
		return salecode;
	}
	public void setSalecode(String salecode) {
		this.salecode = salecode;
	}
	public String getSalename() {
		return salename;
	}
	public void setSalename(String salename) {
		this.salename = salename;
	}
	public String getCustomercode() {
		return customercode;
	}
	public void setCustomercode(String customercode) {
		this.customercode = customercode;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCusttype() {
		return custtype;
	}
	public void setCusttype(String custtype) {
		this.custtype = custtype;
	}
	public String getCusttypeName() {
		return custtypeName;
	}
	public void setCusttypeName(String custtypeName) {
		this.custtypeName = custtypeName;
	}
	public String getCustaddress() {
		return custaddress;
	}
	public void setCustaddress(String custaddress) {
		this.custaddress = custaddress;
	}
	public String getCustemail() {
		return custemail;
	}
	public void setCustemail(String custemail) {
		this.custemail = custemail;
	}
	public String getCusttel() {
		return custtel;
	}
	public void setCusttel(String custtel) {
		this.custtel = custtel;
	}
	public String getCustidno() {
		return custidno;
	}
	public void setCustidno(String custidno) {
		this.custidno = custidno;
	}
	public String getCusttaxno() {
		return custtaxno;
	}
	public void setCusttaxno(String custtaxno) {
		this.custtaxno = custtaxno;
	}
	public String getCustprovincecd() {
		return custprovincecd;
	}
	public void setCustprovincecd(String custprovincecd) {
		this.custprovincecd = custprovincecd;
	}
	public String getCustprovinceName() {
		return custprovinceName;
	}
	public void setCustprovinceName(String custprovinceName) {
		this.custprovinceName = custprovinceName;
	}
	public String getCustdistrictcd() {
		return custdistrictcd;
	}
	public void setCustdistrictcd(String custdistrictcd) {
		this.custdistrictcd = custdistrictcd;
	}
	public String getCustdistrictName() {
		return custdistrictName;
	}
	public void setCustdistrictName(String custdistrictName) {
		this.custdistrictName = custdistrictName;
	}
	public String getCustwardcd() {
		return custwardcd;
	}
	public void setCustwardcd(String custwardcd) {
		this.custwardcd = custwardcd;
	}
	public String getCustwardName() {
		return custwardName;
	}
	public void setCustwardName(String custwardName) {
		this.custwardName = custwardName;
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getCountryname() {
		return countryname;
	}
	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}
	public String getCustaddressfull() {
		return custaddressfull;
	}
	public void setCustaddressfull(String custaddressfull) {
		this.custaddressfull = custaddressfull;
	}
	public String getInsuredname() {
		return insuredname;
	}
	public void setInsuredname(String insuredname) {
		this.insuredname = insuredname;
	}
	public String getInsuredtel() {
		return insuredtel;
	}
	public void setInsuredtel(String insuredtel) {
		this.insuredtel = insuredtel;
	}
	public String getInsuredaddress() {
		return insuredaddress;
	}
	public void setInsuredaddress(String insuredaddress) {
		this.insuredaddress = insuredaddress;
	}
	public String getInsuredemail() {
		return insuredemail;
	}
	public void setInsuredemail(String insuredemail) {
		this.insuredemail = insuredemail;
	}
	public String getLicenseplates() {
		return licenseplates;
	}
	public void setLicenseplates(String licenseplates) {
		this.licenseplates = licenseplates;
	}
	public String getVinnumber() {
		return vinnumber;
	}
	public void setVinnumber(String vinnumber) {
		this.vinnumber = vinnumber;
	}
	public String getEnginenumber() {
		return enginenumber;
	}
	public void setEnginenumber(String enginenumber) {
		this.enginenumber = enginenumber;
	}
	public String getBrandcode() {
		return brandcode;
	}
	public void setBrandcode(String brandcode) {
		this.brandcode = brandcode;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getModelcode() {
		return modelcode;
	}
	public void setModelcode(String modelcode) {
		this.modelcode = modelcode;
	}
	public String getModelname() {
		return modelname;
	}
	public void setModelname(String modelname) {
		this.modelname = modelname;
	}
	public String getEditioncode() {
		return editioncode;
	}
	public void setEditioncode(String editioncode) {
		this.editioncode = editioncode;
	}
	public String getEditionname() {
		return editionname;
	}
	public void setEditionname(String editionname) {
		this.editionname = editionname;
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
	public String getModelyear() {
		return modelyear;
	}
	public void setModelyear(String modelyear) {
		this.modelyear = modelyear;
	}
	public String getMgfdate() {
		return mgfdate;
	}
	public void setMgfdate(String mgfdate) {
		this.mgfdate = mgfdate;
	}
	public BigDecimal getTonnage() {
		return tonnage;
	}
	public void setTonnage(BigDecimal tonnage) {
		this.tonnage = tonnage;
	}
	public Integer getSeatingcapacity() {
		return seatingcapacity;
	}
	public void setSeatingcapacity(Integer seatingcapacity) {
		this.seatingcapacity = seatingcapacity;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public Date getRegistrationdate() {
		return registrationdate;
	}
	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}
	public Date getLineoffmonth() {
		return lineoffmonth;
	}
	public void setLineoffmonth(Date lineoffmonth) {
		this.lineoffmonth = lineoffmonth;
	}
	public Date getDeliverydate() {
		return deliverydate;
	}
	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}
	public BigDecimal getInvoiceprice() {
		return invoiceprice;
	}
	public void setInvoiceprice(BigDecimal invoiceprice) {
		this.invoiceprice = invoiceprice;
	}
	public BigDecimal getMarketprice() {
		return marketprice;
	}
	public void setMarketprice(BigDecimal marketprice) {
		this.marketprice = marketprice;
	}
	public String getPurposeofuseid() {
		return purposeofuseid;
	}
	public void setPurposeofuseid(String purposeofuseid) {
		this.purposeofuseid = purposeofuseid;
	}
	public String getPurposeofusename() {
		return purposeofusename;
	}
	public void setPurposeofusename(String purposeofusename) {
		this.purposeofusename = purposeofusename;
	}
	public String getVehicletypeid() {
		return vehicletypeid;
	}
	public void setVehicletypeid(String vehicletypeid) {
		this.vehicletypeid = vehicletypeid;
	}
	public String getVehicletypename() {
		return vehicletypename;
	}
	public void setVehicletypename(String vehicletypename) {
		this.vehicletypename = vehicletypename;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Long getQuotavehicleid() {
		return quotavehicleid;
	}
	public void setQuotavehicleid(Long quotavehicleid) {
		this.quotavehicleid = quotavehicleid;
	}
	public String getNoclaim() {
		return noclaim;
	}
	public void setNoclaim(String noclaim) {
		this.noclaim = noclaim;
	}
	public String getCampaignid() {
		return campaignid;
	}
	public void setCampaignid(String campaignid) {
		this.campaignid = campaignid;
	}
	public String getDiscountid() {
		return discountid;
	}
	public void setDiscountid(String discountid) {
		this.discountid = discountid;
	}
	public String getDiscountval() {
		return discountval;
	}
	public void setDiscountval(String discountval) {
		this.discountval = discountval;
	}
	public Long getProgramid() {
		return programid;
	}
	public void setProgramid(Long programid) {
		this.programid = programid;
	}
	public String getIncludevat() {
		return includevat;
	}
	public void setIncludevat(String includevat) {
		this.includevat = includevat;
	}
	public String getInsuranceproductcodeTV() {
		return insuranceproductcodeTV;
	}
	public void setInsuranceproductcodeTV(String insuranceproductcodeTV) {
		this.insuranceproductcodeTV = insuranceproductcodeTV;
	}
	public String getInsuranceproductnameTV() {
		return insuranceproductnameTV;
	}
	public void setInsuranceproductnameTV(String insuranceproductnameTV) {
		this.insuranceproductnameTV = insuranceproductnameTV;
	}
	public String getDeductibleCode() {
		return deductibleCode;
	}
	public void setDeductibleCode(String deductibleCode) {
		this.deductibleCode = deductibleCode;
	}
	public String getDeductiblename() {
		return deductiblename;
	}
	public void setDeductiblename(String deductiblename) {
		this.deductiblename = deductiblename;
	}
	public BigDecimal getDeductibleval() {
		return deductibleval;
	}
	public void setDeductibleval(BigDecimal deductibleval) {
		this.deductibleval = deductibleval;
	}
	public Integer getClaimLoss() {
		return claimLoss;
	}
	public void setClaimLoss(Integer claimLoss) {
		this.claimLoss = claimLoss;
	}
	public BigDecimal getAmttvClaim() {
		return amttvClaim;
	}
	public void setAmttvClaim(BigDecimal amttvClaim) {
		this.amttvClaim = amttvClaim;
	}
	public BigDecimal getRateLoss() {
		return rateLoss;
	}
	public void setRateLoss(BigDecimal rateLoss) {
		this.rateLoss = rateLoss;
	}
	public BigDecimal getRateSilverTV() {
		return rateSilverTV;
	}
	public void setRateSilverTV(BigDecimal rateSilverTV) {
		this.rateSilverTV = rateSilverTV;
	}
	public BigDecimal getSumpricevalSilverTV() {
		return sumpricevalSilverTV;
	}
	public void setSumpricevalSilverTV(BigDecimal sumpricevalSilverTV) {
		this.sumpricevalSilverTV = sumpricevalSilverTV;
	}
	public BigDecimal getDisbffeeSilverTV() {
		return disbffeeSilverTV;
	}
	public void setDisbffeeSilverTV(BigDecimal disbffeeSilverTV) {
		this.disbffeeSilverTV = disbffeeSilverTV;
	}
	public BigDecimal getSotienphiSilverTV() {
		return sotienphiSilverTV;
	}
	public void setSotienphiSilverTV(BigDecimal sotienphiSilverTV) {
		this.sotienphiSilverTV = sotienphiSilverTV;
	}
	public BigDecimal getRateGoldTV() {
		return rateGoldTV;
	}
	public void setRateGoldTV(BigDecimal rateGoldTV) {
		this.rateGoldTV = rateGoldTV;
	}
	public BigDecimal getSumpricevalGoldTV() {
		return sumpricevalGoldTV;
	}
	public void setSumpricevalGoldTV(BigDecimal sumpricevalGoldTV) {
		this.sumpricevalGoldTV = sumpricevalGoldTV;
	}
	public BigDecimal getDisbffeeGoldTV() {
		return disbffeeGoldTV;
	}
	public void setDisbffeeGoldTV(BigDecimal disbffeeGoldTV) {
		this.disbffeeGoldTV = disbffeeGoldTV;
	}
	public BigDecimal getSotienphiGoldTV() {
		return sotienphiGoldTV;
	}
	public void setSotienphiGoldTV(BigDecimal sotienphiGoldTV) {
		this.sotienphiGoldTV = sotienphiGoldTV;
	}
	public BigDecimal getRateDiamondTV() {
		return rateDiamondTV;
	}
	public void setRateDiamondTV(BigDecimal rateDiamondTV) {
		this.rateDiamondTV = rateDiamondTV;
	}
	public BigDecimal getSumpricevalDiamondTV() {
		return sumpricevalDiamondTV;
	}
	public void setSumpricevalDiamondTV(BigDecimal sumpricevalDiamondTV) {
		this.sumpricevalDiamondTV = sumpricevalDiamondTV;
	}
	public BigDecimal getDisbffeeDiamondTV() {
		return disbffeeDiamondTV;
	}
	public void setDisbffeeDiamondTV(BigDecimal disbffeeDiamondTV) {
		this.disbffeeDiamondTV = disbffeeDiamondTV;
	}
	public BigDecimal getSotienphiDiamondTV() {
		return sotienphiDiamondTV;
	}
	public void setSotienphiDiamondTV(BigDecimal sotienphiDiamondTV) {
		this.sotienphiDiamondTV = sotienphiDiamondTV;
	}

	public String getInsuranceValue() {
		return insuranceValue;
	}

	public void setInsuranceValue(String insuranceValue) {
		this.insuranceValue = insuranceValue;
	}

	public String getThoigianconlai() {
		return thoigianconlai;
	}

	public void setThoigianconlai(String thoigianconlai) {
		this.thoigianconlai = thoigianconlai;
	}

	public Date getIssueddate() {
		return issueddate;
	}

	public void setIssueddate(Date issueddate) {
		this.issueddate = issueddate;
	}

	public Date getSalesdate() {
		return salesdate;
	}

	public void setSalesdate(Date salesdate) {
		this.salesdate = salesdate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
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

	public String getPolicytype() {
		return policytype;
	}

	public void setPolicytype(String policytype) {
		this.policytype = policytype;
	}

	public String getNoclaimcode() {
		return noclaimcode;
	}

	public void setNoclaimcode(String noclaimcode) {
		this.noclaimcode = noclaimcode;
	}

	public BigDecimal getDisbfratevatfeeSilverTV() {
		return disbfratevatfeeSilverTV;
	}

	public void setDisbfratevatfeeSilverTV(BigDecimal disbfratevatfeeSilverTV) {
		this.disbfratevatfeeSilverTV = disbfratevatfeeSilverTV;
	}

	public BigDecimal getDisbfratevatfeeGoldTV() {
		return disbfratevatfeeGoldTV;
	}

	public void setDisbfratevatfeeGoldTV(BigDecimal disbfratevatfeeGoldTV) {
		this.disbfratevatfeeGoldTV = disbfratevatfeeGoldTV;
	}

	public BigDecimal getDisbfratevatfeeDiamondTV() {
		return disbfratevatfeeDiamondTV;
	}

	public void setDisbfratevatfeeDiamondTV(BigDecimal disbfratevatfeeDiamondTV) {
		this.disbfratevatfeeDiamondTV = disbfratevatfeeDiamondTV;
	}

	public BigDecimal getGiatt() {
		return giatt;
	}

	public void setGiatt(BigDecimal giatt) {
		this.giatt = giatt;
	}

	public BigDecimal getSotienphiPolicyVat() {
		return sotienphiPolicyVat;
	}

	public void setSotienphiPolicyVat(BigDecimal sotienphiPolicyVat) {
		this.sotienphiPolicyVat = sotienphiPolicyVat;
	}

	public String getPolicyTT() {
		return policyTT;
	}

	public void setPolicyTT(String policyTT) {
		this.policyTT = policyTT;
	}


}
