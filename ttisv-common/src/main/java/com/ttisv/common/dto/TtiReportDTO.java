package com.ttisv.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TtiReportDTO  implements Serializable {

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

	private BigDecimal invoiceprice;

	private BigDecimal marketprice;

	private String purposeofuseid;

	private String purposeofusename;

	private String vehicletypeid;

	private String vehicletypename;

	private String note;

	private Long quotavehicleid;

	private String noclaim;

	private String campaignid;

	private String discountid;

	private Long programid;

	private String includevat;

	private String insuranceproductcodeTV;

	private String insuranceproductnameTV;

	private String deductibleCode;

	private String feerateTV;

	private String feeAfterVatTV;

	private String feetaxTV;

	private String feeBeforeVatTV;

	private String insuranceproductcodeTL;

	private String insuranceproductnameTL;

	private String feeAfterVatTL;

	private String feetaxTL;

	private String feeBeforeVatTL;

	private String insuranceproductcodeTTNH;

	private String insuranceproductnameTTNH;

	private String feeAfterVatTTNH;

	private String feetaxTTNH;

	private String feeBeforeVatTTNH;

	private String feeAfterVatBTNH;

	private String feetaxBTNH;

	private String feeBeforeVatBTNH;

	private String feeAfterVatTotal;

	private String feetaxTotal;

	private String feeBeforeVatTotal;

	private String feeIncurredCommission;

	private String feeTaxIncurredCommission;

	private String feeIncurredSupport;

	private String feeTaxIncurredSupport;

	private String feeIncurredCommissionTTISV;

	private String feeTaxIncurredCommissionTTISV;

	private String feeIncurredCommissionIT;

	private String feeTaxIncurredIT;

	private String feeIncurredCommissionOther1;

	private String feeTaxIncurredOther1;

	private String feeIncurredCommissionOther2;

	private String feeTaxIncurredOther2;

	private int totalRow;

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

	public String getFeerateTV() {
		return feerateTV;
	}

	public void setFeerateTV(String feerateTV) {
		this.feerateTV = feerateTV;
	}

	public String getFeeAfterVatTV() {
		return feeAfterVatTV;
	}

	public void setFeeAfterVatTV(String feeAfterVatTV) {
		this.feeAfterVatTV = feeAfterVatTV;
	}

	public String getFeetaxTV() {
		return feetaxTV;
	}

	public void setFeetaxTV(String feetaxTV) {
		this.feetaxTV = feetaxTV;
	}

	public String getFeeBeforeVatTV() {
		return feeBeforeVatTV;
	}

	public void setFeeBeforeVatTV(String feeBeforeVatTV) {
		this.feeBeforeVatTV = feeBeforeVatTV;
	}

	public String getInsuranceproductcodeTL() {
		return insuranceproductcodeTL;
	}

	public void setInsuranceproductcodeTL(String insuranceproductcodeTL) {
		this.insuranceproductcodeTL = insuranceproductcodeTL;
	}

	public String getInsuranceproductnameTL() {
		return insuranceproductnameTL;
	}

	public void setInsuranceproductnameTL(String insuranceproductnameTL) {
		this.insuranceproductnameTL = insuranceproductnameTL;
	}

	public String getFeeAfterVatTL() {
		return feeAfterVatTL;
	}

	public void setFeeAfterVatTL(String feeAfterVatTL) {
		this.feeAfterVatTL = feeAfterVatTL;
	}

	public String getFeetaxTL() {
		return feetaxTL;
	}

	public void setFeetaxTL(String feetaxTL) {
		this.feetaxTL = feetaxTL;
	}

	public String getFeeBeforeVatTL() {
		return feeBeforeVatTL;
	}

	public void setFeeBeforeVatTL(String feeBeforeVatTL) {
		this.feeBeforeVatTL = feeBeforeVatTL;
	}

	public String getInsuranceproductcodeTTNH() {
		return insuranceproductcodeTTNH;
	}

	public void setInsuranceproductcodeTTNH(String insuranceproductcodeTTNH) {
		this.insuranceproductcodeTTNH = insuranceproductcodeTTNH;
	}

	public String getInsuranceproductnameTTNH() {
		return insuranceproductnameTTNH;
	}

	public void setInsuranceproductnameTTNH(String insuranceproductnameTTNH) {
		this.insuranceproductnameTTNH = insuranceproductnameTTNH;
	}

	public String getFeeAfterVatTTNH() {
		return feeAfterVatTTNH;
	}

	public void setFeeAfterVatTTNH(String feeAfterVatTTNH) {
		this.feeAfterVatTTNH = feeAfterVatTTNH;
	}

	public String getFeetaxTTNH() {
		return feetaxTTNH;
	}

	public void setFeetaxTTNH(String feetaxTTNH) {
		this.feetaxTTNH = feetaxTTNH;
	}

	public String getFeeBeforeVatTTNH() {
		return feeBeforeVatTTNH;
	}

	public void setFeeBeforeVatTTNH(String feeBeforeVatTTNH) {
		this.feeBeforeVatTTNH = feeBeforeVatTTNH;
	}

	public String getFeeAfterVatBTNH() {
		return feeAfterVatBTNH;
	}

	public void setFeeAfterVatBTNH(String feeAfterVatBTNH) {
		this.feeAfterVatBTNH = feeAfterVatBTNH;
	}

	public String getFeetaxBTNH() {
		return feetaxBTNH;
	}

	public void setFeetaxBTNH(String feetaxBTNH) {
		this.feetaxBTNH = feetaxBTNH;
	}

	public String getFeeBeforeVatBTNH() {
		return feeBeforeVatBTNH;
	}

	public void setFeeBeforeVatBTNH(String feeBeforeVatBTNH) {
		this.feeBeforeVatBTNH = feeBeforeVatBTNH;
	}

	public String getFeeAfterVatTotal() {
		return feeAfterVatTotal;
	}

	public void setFeeAfterVatTotal(String feeAfterVatTotal) {
		this.feeAfterVatTotal = feeAfterVatTotal;
	}

	public String getFeetaxTotal() {
		return feetaxTotal;
	}

	public void setFeetaxTotal(String feetaxTotal) {
		this.feetaxTotal = feetaxTotal;
	}

	public String getFeeBeforeVatTotal() {
		return feeBeforeVatTotal;
	}

	public void setFeeBeforeVatTotal(String feeBeforeVatTotal) {
		this.feeBeforeVatTotal = feeBeforeVatTotal;
	}

	public String getFeeIncurredCommission() {
		return feeIncurredCommission;
	}

	public void setFeeIncurredCommission(String feeIncurredCommission) {
		this.feeIncurredCommission = feeIncurredCommission;
	}

	public String getFeeTaxIncurredCommission() {
		return feeTaxIncurredCommission;
	}

	public void setFeeTaxIncurredCommission(String feeTaxIncurredCommission) {
		this.feeTaxIncurredCommission = feeTaxIncurredCommission;
	}

	public String getFeeIncurredSupport() {
		return feeIncurredSupport;
	}

	public void setFeeIncurredSupport(String feeIncurredSupport) {
		this.feeIncurredSupport = feeIncurredSupport;
	}

	public String getFeeTaxIncurredSupport() {
		return feeTaxIncurredSupport;
	}

	public void setFeeTaxIncurredSupport(String feeTaxIncurredSupport) {
		this.feeTaxIncurredSupport = feeTaxIncurredSupport;
	}

	public String getFeeIncurredCommissionTTISV() {
		return feeIncurredCommissionTTISV;
	}

	public void setFeeIncurredCommissionTTISV(String feeIncurredCommissionTTISV) {
		this.feeIncurredCommissionTTISV = feeIncurredCommissionTTISV;
	}

	public String getFeeTaxIncurredCommissionTTISV() {
		return feeTaxIncurredCommissionTTISV;
	}

	public void setFeeTaxIncurredCommissionTTISV(String feeTaxIncurredCommissionTTISV) {
		this.feeTaxIncurredCommissionTTISV = feeTaxIncurredCommissionTTISV;
	}

	public String getFeeIncurredCommissionIT() {
		return feeIncurredCommissionIT;
	}

	public void setFeeIncurredCommissionIT(String feeIncurredCommissionIT) {
		this.feeIncurredCommissionIT = feeIncurredCommissionIT;
	}

	public String getFeeTaxIncurredIT() {
		return feeTaxIncurredIT;
	}

	public void setFeeTaxIncurredIT(String feeTaxIncurredIT) {
		this.feeTaxIncurredIT = feeTaxIncurredIT;
	}

	public String getFeeIncurredCommissionOther1() {
		return feeIncurredCommissionOther1;
	}

	public void setFeeIncurredCommissionOther1(String feeIncurredCommissionOther1) {
		this.feeIncurredCommissionOther1 = feeIncurredCommissionOther1;
	}

	public String getFeeTaxIncurredOther1() {
		return feeTaxIncurredOther1;
	}

	public void setFeeTaxIncurredOther1(String feeTaxIncurredOther1) {
		this.feeTaxIncurredOther1 = feeTaxIncurredOther1;
	}

	public String getFeeIncurredCommissionOther2() {
		return feeIncurredCommissionOther2;
	}

	public void setFeeIncurredCommissionOther2(String feeIncurredCommissionOther2) {
		this.feeIncurredCommissionOther2 = feeIncurredCommissionOther2;
	}

	public String getFeeTaxIncurredOther2() {
		return feeTaxIncurredOther2;
	}

	public void setFeeTaxIncurredOther2(String feeTaxIncurredOther2) {
		this.feeTaxIncurredOther2 = feeTaxIncurredOther2;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

}
