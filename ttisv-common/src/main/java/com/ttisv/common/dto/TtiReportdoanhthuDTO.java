package com.ttisv.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TtiReportdoanhthuDTO implements Serializable {

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

	private String quotastatus;

	private String contractstatus;

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

	private String discountval;

	private Long programid;

	private String includevat;

	private String insuranceproductcodeTV;

	private String insuranceproductnameTV;

	private String deductibleCode;
	private String deductiblename;
	private BigDecimal deductibleval_tv;
	private BigDecimal deductibleval_TL;
	private BigDecimal deductibleval_TTNDSTN;
	private BigDecimal deductibleval_TTNDSBB;
	private BigDecimal deductibleval;
	private Integer claimLoss;
	private BigDecimal amttvClaim;
	private BigDecimal rateLoss;

	private BigDecimal feerateTV;

	private String feeAfterVatTV;

	private BigDecimal feetaxTV;

	private String feeBeforeVatTV;

	private String insuranceproductcodeTNNNTX;// Tai nạn người ngồi trên xe

	private String insuranceproductnameTNNNTX;

	private BigDecimal feeAfterVatTL;

	private BigDecimal feetaxTL;

	private BigDecimal feeBeforeVatTL;

	private String insuranceproductcodeTTNDSTN;// Trách nhiệm dân sự tự nguyện

	private String insuranceproductnameTTNDSTN;// Trách nhiệm dân sự bắt buộc

	private String insuranceproductnameTTNDSBB;// Trách nhiệm dân sự bắt buộc

	private BigDecimal feeAfterVatTTNDSTN;

	private BigDecimal feetaxTTNDSTN;

	private BigDecimal feeBeforeVatTTNDSTN;

	private BigDecimal feeAfterVatTTNDSBB;

	private BigDecimal feetaxTTNDSBB;

	private BigDecimal feeBeforeVatTTNDSBB;

	private String feeAfterVatTotal;

	private String feetaxTotal;

	private String feeBeforeVatTotal;
	

	private BigDecimal feeIncurredCommission;

	private BigDecimal feeTaxIncurredCommission;

	private BigDecimal feeIncurredSupport;

	private BigDecimal feeTaxIncurredSupport;

	private BigDecimal feeIncurredCommissionTTISV;

	private BigDecimal feeTaxIncurredCommissionTTISV;

	private BigDecimal feeIncurredCommissionIT;

	private BigDecimal feeTaxIncurredIT;

	private BigDecimal feeIncurredCommissionOther1;

	private BigDecimal feeTaxIncurredOther1;

	private BigDecimal feeIncurredCommissionOther2;

	private BigDecimal feeTaxIncurredOther2;
	

	private Date issueddate;
	private String policyTT;
	private String quotenoTt;
	private BigDecimal tongsotienphithucte;
	private String insurancefeenameTt;
	private String insurancefeecodeTt;
	private String deductiblecodeTt;
	private String deductiblenameTt;
	private String insuranceValue;
	private String thoigianconlai;
	private BigDecimal deductiblevalTt;
	private BigDecimal sotienphiPolicy;
	private BigDecimal sotienphiPolicyVat;
	private BigDecimal sotienphitinhtoanTt;
	private BigDecimal sotienphithucteTt;
	private int totalRow;

	private BigDecimal sotienphiPolicysum;
	private BigDecimal sotienphiPolicyvatsum;
	private BigDecimal feetaxSum;

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

	public BigDecimal getFeerateTV() {
		return feerateTV;
	}

	public void setFeerateTV(BigDecimal feerateTV) {
		this.feerateTV = feerateTV;
	}

	public String getFeeAfterVatTV() {
		return feeAfterVatTV;
	}

	public void setFeeAfterVatTV(String feeAfterVatTV) {
		this.feeAfterVatTV = feeAfterVatTV;
	}

	public BigDecimal getFeetaxTV() {
		return feetaxTV;
	}

	public void setFeetaxTV(BigDecimal feetaxTV) {
		this.feetaxTV = feetaxTV;
	}

	public String getFeeBeforeVatTV() {
		return feeBeforeVatTV;
	}

	public void setFeeBeforeVatTV(String feeBeforeVatTV) {
		this.feeBeforeVatTV = feeBeforeVatTV;
	}

	public String getInsuranceproductcodeTNNNTX() {
		return insuranceproductcodeTNNNTX;
	}

	public void setInsuranceproductcodeTNNNTX(String insuranceproductcodeTNNNTX) {
		this.insuranceproductcodeTNNNTX = insuranceproductcodeTNNNTX;
	}

	public String getInsuranceproductnameTNNNTX() {
		return insuranceproductnameTNNNTX;
	}

	public void setInsuranceproductnameTNNNTX(String insuranceproductnameTNNNTX) {
		this.insuranceproductnameTNNNTX = insuranceproductnameTNNNTX;
	}

	public BigDecimal getFeeAfterVatTL() {
		return feeAfterVatTL;
	}

	public void setFeeAfterVatTL(BigDecimal feeAfterVatTL) {
		this.feeAfterVatTL = feeAfterVatTL;
	}

	public BigDecimal getFeetaxTL() {
		return feetaxTL;
	}

	public void setFeetaxTL(BigDecimal feetaxTL) {
		this.feetaxTL = feetaxTL;
	}

	public BigDecimal getFeeBeforeVatTL() {
		return feeBeforeVatTL;
	}

	public void setFeeBeforeVatTL(BigDecimal feeBeforeVatTL) {
		this.feeBeforeVatTL = feeBeforeVatTL;
	}

	public String getInsuranceproductcodeTTNDSTN() {
		return insuranceproductcodeTTNDSTN;
	}

	public void setInsuranceproductcodeTTNDSTN(String insuranceproductcodeTTNDSTN) {
		this.insuranceproductcodeTTNDSTN = insuranceproductcodeTTNDSTN;
	}

	public String getInsuranceproductnameTTNDSTN() {
		return insuranceproductnameTTNDSTN;
	}

	public void setInsuranceproductnameTTNDSTN(String insuranceproductnameTTNDSTN) {
		this.insuranceproductnameTTNDSTN = insuranceproductnameTTNDSTN;
	}

	public BigDecimal getFeeAfterVatTTNDSTN() {
		return feeAfterVatTTNDSTN;
	}

	public void setFeeAfterVatTTNDSTN(BigDecimal feeAfterVatTTNDSTN) {
		this.feeAfterVatTTNDSTN = feeAfterVatTTNDSTN;
	}

	public BigDecimal getFeetaxTTNDSTN() {
		return feetaxTTNDSTN;
	}

	public void setFeetaxTTNDSTN(BigDecimal feetaxTTNDSTN) {
		this.feetaxTTNDSTN = feetaxTTNDSTN;
	}

	public BigDecimal getFeeBeforeVatTTNDSTN() {
		return feeBeforeVatTTNDSTN;
	}

	public void setFeeBeforeVatTTNDSTN(BigDecimal feeBeforeVatTTNDSTN) {
		this.feeBeforeVatTTNDSTN = feeBeforeVatTTNDSTN;
	}

	public BigDecimal getFeeAfterVatTTNDSBB() {
		return feeAfterVatTTNDSBB;
	}

	public void setFeeAfterVatTTNDSBB(BigDecimal feeAfterVatTTNDSBB) {
		this.feeAfterVatTTNDSBB = feeAfterVatTTNDSBB;
	}

	public BigDecimal getFeetaxTTNDSBB() {
		return feetaxTTNDSBB;
	}

	public void setFeetaxTTNDSBB(BigDecimal feetaxTTNDSBB) {
		this.feetaxTTNDSBB = feetaxTTNDSBB;
	}

	public BigDecimal getFeeBeforeVatTTNDSBB() {
		return feeBeforeVatTTNDSBB;
	}

	public void setFeeBeforeVatTTNDSBB(BigDecimal feeBeforeVatTTNDSBB) {
		this.feeBeforeVatTTNDSBB = feeBeforeVatTTNDSBB;
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

	public BigDecimal getFeeIncurredCommission() {
		return feeIncurredCommission;
	}

	public void setFeeIncurredCommission(BigDecimal feeIncurredCommission) {
		this.feeIncurredCommission = feeIncurredCommission;
	}

	public BigDecimal getFeeTaxIncurredCommission() {
		return feeTaxIncurredCommission;
	}

	public void setFeeTaxIncurredCommission(BigDecimal feeTaxIncurredCommission) {
		this.feeTaxIncurredCommission = feeTaxIncurredCommission;
	}

	public BigDecimal getFeeIncurredSupport() {
		return feeIncurredSupport;
	}

	public void setFeeIncurredSupport(BigDecimal feeIncurredSupport) {
		this.feeIncurredSupport = feeIncurredSupport;
	}

	public BigDecimal getFeeTaxIncurredSupport() {
		return feeTaxIncurredSupport;
	}

	public void setFeeTaxIncurredSupport(BigDecimal feeTaxIncurredSupport) {
		this.feeTaxIncurredSupport = feeTaxIncurredSupport;
	}

	public BigDecimal getFeeIncurredCommissionTTISV() {
		return feeIncurredCommissionTTISV;
	}

	public void setFeeIncurredCommissionTTISV(BigDecimal feeIncurredCommissionTTISV) {
		this.feeIncurredCommissionTTISV = feeIncurredCommissionTTISV;
	}

	public BigDecimal getFeeTaxIncurredCommissionTTISV() {
		return feeTaxIncurredCommissionTTISV;
	}

	public void setFeeTaxIncurredCommissionTTISV(BigDecimal feeTaxIncurredCommissionTTISV) {
		this.feeTaxIncurredCommissionTTISV = feeTaxIncurredCommissionTTISV;
	}

	public BigDecimal getFeeIncurredCommissionIT() {
		return feeIncurredCommissionIT;
	}

	public void setFeeIncurredCommissionIT(BigDecimal feeIncurredCommissionIT) {
		this.feeIncurredCommissionIT = feeIncurredCommissionIT;
	}

	public BigDecimal getFeeTaxIncurredIT() {
		return feeTaxIncurredIT;
	}

	public void setFeeTaxIncurredIT(BigDecimal feeTaxIncurredIT) {
		this.feeTaxIncurredIT = feeTaxIncurredIT;
	}

	public BigDecimal getFeeIncurredCommissionOther1() {
		return feeIncurredCommissionOther1;
	}

	public void setFeeIncurredCommissionOther1(BigDecimal feeIncurredCommissionOther1) {
		this.feeIncurredCommissionOther1 = feeIncurredCommissionOther1;
	}

	public BigDecimal getFeeTaxIncurredOther1() {
		return feeTaxIncurredOther1;
	}

	public void setFeeTaxIncurredOther1(BigDecimal feeTaxIncurredOther1) {
		this.feeTaxIncurredOther1 = feeTaxIncurredOther1;
	}

	public BigDecimal getFeeIncurredCommissionOther2() {
		return feeIncurredCommissionOther2;
	}

	public void setFeeIncurredCommissionOther2(BigDecimal feeIncurredCommissionOther2) {
		this.feeIncurredCommissionOther2 = feeIncurredCommissionOther2;
	}

	public BigDecimal getFeeTaxIncurredOther2() {
		return feeTaxIncurredOther2;
	}

	public void setFeeTaxIncurredOther2(BigDecimal feeTaxIncurredOther2) {
		this.feeTaxIncurredOther2 = feeTaxIncurredOther2;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public Date getIssueddate() {
		return issueddate;
	}

	public void setIssueddate(Date issueddate) {
		this.issueddate = issueddate;
	}

	public String getPolicyTT() {
		return policyTT;
	}

	public void setPolicyTT(String policyTT) {
		this.policyTT = policyTT;
	}

	public String getQuotenoTt() {
		return quotenoTt;
	}

	public void setQuotenoTt(String quotenoTt) {
		this.quotenoTt = quotenoTt;
	}

	public BigDecimal getTongsotienphithucte() {
		return tongsotienphithucte;
	}

	public void setTongsotienphithucte(BigDecimal tongsotienphithucte) {
		this.tongsotienphithucte = tongsotienphithucte;
	}

	public String getInsurancefeenameTt() {
		return insurancefeenameTt;
	}

	public void setInsurancefeenameTt(String insurancefeenameTt) {
		this.insurancefeenameTt = insurancefeenameTt;
	}

	public String getInsurancefeecodeTt() {
		return insurancefeecodeTt;
	}

	public void setInsurancefeecodeTt(String insurancefeecodeTt) {
		this.insurancefeecodeTt = insurancefeecodeTt;
	}

	public String getDeductiblecodeTt() {
		return deductiblecodeTt;
	}

	public void setDeductiblecodeTt(String deductiblecodeTt) {
		this.deductiblecodeTt = deductiblecodeTt;
	}

	public String getDeductiblenameTt() {
		return deductiblenameTt;
	}

	public void setDeductiblenameTt(String deductiblenameTt) {
		this.deductiblenameTt = deductiblenameTt;
	}

	public BigDecimal getDeductiblevalTt() {
		return deductiblevalTt;
	}

	public void setDeductiblevalTt(BigDecimal deductiblevalTt) {
		this.deductiblevalTt = deductiblevalTt;
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

	public String getDiscountval() {
		return discountval;
	}

	public void setDiscountval(String discountval) {
		this.discountval = discountval;
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

	public BigDecimal getSotienphiPolicy() {
		return sotienphiPolicy;
	}

	public void setSotienphiPolicy(BigDecimal sotienphiPolicy) {
		this.sotienphiPolicy = sotienphiPolicy;
	}

	public BigDecimal getSotienphiPolicyVat() {
		return sotienphiPolicyVat;
	}

	public void setSotienphiPolicyVat(BigDecimal sotienphiPolicyVat) {
		this.sotienphiPolicyVat = sotienphiPolicyVat;
	}

	public BigDecimal getRateLoss() {
		return rateLoss;
	}

	public void setRateLoss(BigDecimal rateLoss) {
		this.rateLoss = rateLoss;
	}

	public BigDecimal getSotienphitinhtoanTt() {
		return sotienphitinhtoanTt;
	}

	public void setSotienphitinhtoanTt(BigDecimal sotienphitinhtoanTt) {
		this.sotienphitinhtoanTt = sotienphitinhtoanTt;
	}

	public BigDecimal getSotienphithucteTt() {
		return sotienphithucteTt;
	}

	public void setSotienphithucteTt(BigDecimal sotienphithucteTt) {
		this.sotienphithucteTt = sotienphithucteTt;
	}

	public String getQuotastatus() {
		return quotastatus;
	}

	public void setQuotastatus(String quotastatus) {
		this.quotastatus = quotastatus;
	}

	public String getContractstatus() {
		return contractstatus;
	}

	public void setContractstatus(String contractstatus) {
		this.contractstatus = contractstatus;
	}

	public BigDecimal getDeductibleval_tv() {
		return deductibleval_tv;
	}

	public void setDeductibleval_tv(BigDecimal deductibleval_tv) {
		this.deductibleval_tv = deductibleval_tv;
	}

	public BigDecimal getDeductibleval_TL() {
		return deductibleval_TL;
	}

	public void setDeductibleval_TL(BigDecimal deductibleval_TL) {
		this.deductibleval_TL = deductibleval_TL;
	}

	public BigDecimal getDeductibleval_TTNDSTN() {
		return deductibleval_TTNDSTN;
	}

	public void setDeductibleval_TTNDSTN(BigDecimal deductibleval_TTNDSTN) {
		this.deductibleval_TTNDSTN = deductibleval_TTNDSTN;
	}

	public BigDecimal getDeductibleval_TTNDSBB() {
		return deductibleval_TTNDSBB;
	}

	public void setDeductibleval_TTNDSBB(BigDecimal deductibleval_TTNDSBB) {
		this.deductibleval_TTNDSBB = deductibleval_TTNDSBB;
	}

	public String getInsuranceproductnameTTNDSBB() {
		return insuranceproductnameTTNDSBB;
	}

	public void setInsuranceproductnameTTNDSBB(String insuranceproductnameTTNDSBB) {
		this.insuranceproductnameTTNDSBB = insuranceproductnameTTNDSBB;
	}

	public BigDecimal getSotienphiPolicysum() {
		return sotienphiPolicysum;
	}

	public void setSotienphiPolicysum(BigDecimal sotienphiPolicysum) {
		this.sotienphiPolicysum = sotienphiPolicysum;
	}

	public BigDecimal getSotienphiPolicyvatsum() {
		return sotienphiPolicyvatsum;
	}

	public void setSotienphiPolicyvatsum(BigDecimal sotienphiPolicyvatsum) {
		this.sotienphiPolicyvatsum = sotienphiPolicyvatsum;
	}

	public BigDecimal getFeetaxSum() {
		return feetaxSum;
	}

	public void setFeetaxSum(BigDecimal feetaxSum) {
		this.feetaxSum = feetaxSum;
	}

}
