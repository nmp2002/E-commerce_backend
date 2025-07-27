package com.ttisv.common.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TtiQuotapolicyDTO {

	private Long quotapolicyid;

	private String agentcode;

	private String agentname;

	private String campaignid;

	private String discountid;

	private Date effectivefrom;

	private Date effectiveto;

	private String effectivefromtm;

	private String effectivetotm;

	private String includevat;

	private Long lastendorsementpolicyid;

	private Long nextendorsementpolicyid;

	private Long nextpolicyid;

	private Long orginalpolicyid;

	private String policytypeid;

	private Long previousendorsementpolicyid;

	private Long previouspolicyid;

	private Long programid;

	private Long quotaid;

	private String quotano;

	private String status;

	private String contractstatus;

	private String transferstatus;

	private String quotapolicyno;

	private BigDecimal netfee;

	private BigDecimal tax;

	private BigDecimal discountval;

	private BigDecimal payFee;

	private BigDecimal sumbfFee;

	private String quotapolicyNote;

	private Integer insuranceYears;

	private Integer insuranceDays;

	private String customercode;

	private String customername;

	private String brandcode;

	private String brandname;

	private String vinnumber;

	private String enginenumber;

	private String licenseplates;

	private String quotatypeid;

	private String capacity;

	private Integer seatingcapacity;

	private Date registrationdate;

	private Date deliverydate;

	private String manufacturingdate;

	private String editioncode;

	private String editionname;

	private BigDecimal invoiceprice;

	private BigDecimal marketprice;

	private String modelcode;

	private String modelname;

	private String modelyear;

	private String classcode;

	private String classname;

	private String purposeofuseid;

	private String vehicletypeid;

	private String vehicletypename;

	private String purposeofusename;

	private Long quotavehicleid;

	private BigDecimal tonnage;

	private Long quoteid;

	private Long quoteno;

	private int totalRow;

	private String officecode;

	private String officebrcd;

	private String officebrcdname;

	private String custtype;

	private String custtypeName;

	private String custaddress;

	private String custemail;

	private String custtel;

	private String custidno;

	private String custprovincecd;

	private String custprovinceName;

	private String custdistrictName;

	private String custdistrictcd;

	private String custwardName;

	private String custwardcd;

	private String countrycode;

	private String countryname;

	private String bankaccount;

	private String bankaccountname;

	private String bankcode;

	private String bankname;

	private String beneficiaryaddress;

	private String beneficiaryname;

	private String beneficiarytel;

	private String beneficiaryemail;

	private String beneficiaryterms;

	private Long branchinsuranceid;

	private String contactaddress;

	private String contactname;

	private String insuredaddress;

	private String insuredname;

	private String contacttel;

	private String contactemail;

	private String insuredtel;

	private String insuredemail;

	private String insuranceitemcode;

	private String insuranceitemname;

	private Date preEffectivefrom;

	private Date preEffectiveto;

	private Date lastEffectivefrom;

	private Date lastEffectiveto;

	private String lastEffectivefromtm;

	private String lastEffectivetotm;

	private BigDecimal netfeeRefunds;

	private BigDecimal taxRefunds;

	private BigDecimal sumbfFeeRefunds;

	private Long policyrefundsid;

	private String reasoncode;

	private String reasonname;

	private String note;

	private Date canceldate;

	private String canceluser;

	private Date typingdate;
	private String quotetypeorg;
	private String noclaim;

	private Integer claimLoss;

	private Integer ndaysSinterruption;

	private BigDecimal amttv;

	private BigDecimal rateLoss;

	private Date issueddate;

	private Date issueddateorg;

	private List<TtiQuotaFeeDTO> quotafees;

	private List<TtiQuotaFeeDTO> feeminimumproduct;

	private List<TtiQuotaFeeDTO> discountfeeproductlst;

	private List<TtiQuotaFeeDTO> insuranceriskproduct;

	private List<TtiQuotapolicydetailDTO> insuranceproductaddlst;

	private List<TtiQuotapolicydetailDTO> insuranceproductlst;

	private List<TtiQuotapolicyinsuranceDTO> quotapolicyinsuranceItems;

	List<TtiQuoteaccessoryDTO> quoteaccessorylst;

	List<PhigocDTO> phigocdtolst;

	private String wordingtype;

	private BigDecimal payfeepre;

	private String insuranceproductcode;

	private String insuranceproductname;

	public Long getQuotapolicyid() {
		return quotapolicyid;
	}

	public void setQuotapolicyid(Long quotapolicyid) {
		this.quotapolicyid = quotapolicyid;
	}

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

	public String getIncludevat() {
		return includevat;
	}

	public void setIncludevat(String includevat) {
		this.includevat = includevat;
	}

	public Long getLastendorsementpolicyid() {
		return lastendorsementpolicyid;
	}

	public void setLastendorsementpolicyid(Long lastendorsementpolicyid) {
		this.lastendorsementpolicyid = lastendorsementpolicyid;
	}

	public Long getNextendorsementpolicyid() {
		return nextendorsementpolicyid;
	}

	public void setNextendorsementpolicyid(Long nextendorsementpolicyid) {
		this.nextendorsementpolicyid = nextendorsementpolicyid;
	}

	public Long getNextpolicyid() {
		return nextpolicyid;
	}

	public void setNextpolicyid(Long nextpolicyid) {
		this.nextpolicyid = nextpolicyid;
	}

	public Long getOrginalpolicyid() {
		return orginalpolicyid;
	}

	public void setOrginalpolicyid(Long orginalpolicyid) {
		this.orginalpolicyid = orginalpolicyid;
	}

	public String getPolicytypeid() {
		return policytypeid;
	}

	public void setPolicytypeid(String policytypeid) {
		this.policytypeid = policytypeid;
	}

	public Long getPreviousendorsementpolicyid() {
		return previousendorsementpolicyid;
	}

	public void setPreviousendorsementpolicyid(Long previousendorsementpolicyid) {
		this.previousendorsementpolicyid = previousendorsementpolicyid;
	}

	public Long getPreviouspolicyid() {
		return previouspolicyid;
	}

	public void setPreviouspolicyid(Long previouspolicyid) {
		this.previouspolicyid = previouspolicyid;
	}

	public Long getProgramid() {
		return programid;
	}

	public void setProgramid(Long programid) {
		this.programid = programid;
	}

	public Long getQuotaid() {
		return quotaid;
	}

	public void setQuotaid(Long quotaid) {
		this.quotaid = quotaid;
	}

	public String getQuotano() {
		return quotano;
	}

	public void setQuotano(String quotano) {
		this.quotano = quotano;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContractstatus() {
		return contractstatus;
	}

	public void setContractstatus(String contractstatus) {
		this.contractstatus = contractstatus;
	}

	public String getTransferstatus() {
		return transferstatus;
	}

	public void setTransferstatus(String transferstatus) {
		this.transferstatus = transferstatus;
	}

	public String getQuotapolicyno() {
		return quotapolicyno;
	}

	public void setQuotapolicyno(String quotapolicyno) {
		this.quotapolicyno = quotapolicyno;
	}

	public BigDecimal getNetfee() {
		return netfee;
	}

	public void setNetfee(BigDecimal netfee) {
		this.netfee = netfee;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
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

	public String getQuotapolicyNote() {
		return quotapolicyNote;
	}

	public void setQuotapolicyNote(String quotapolicyNote) {
		this.quotapolicyNote = quotapolicyNote;
	}

	public Integer getInsuranceYears() {
		return insuranceYears;
	}

	public void setInsuranceYears(Integer insuranceYears) {
		this.insuranceYears = insuranceYears;
	}

	public Integer getInsuranceDays() {
		return insuranceDays;
	}

	public void setInsuranceDays(Integer insuranceDays) {
		this.insuranceDays = insuranceDays;
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

	public String getLicenseplates() {
		return licenseplates;
	}

	public void setLicenseplates(String licenseplates) {
		this.licenseplates = licenseplates;
	}

	public String getQuotatypeid() {
		return quotatypeid;
	}

	public void setQuotatypeid(String quotatypeid) {
		this.quotatypeid = quotatypeid;
	}

	public String getCapacity() {
		return capacity;
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

	public Date getRegistrationdate() {
		return registrationdate;
	}

	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}

	public Date getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}

	public String getManufacturingdate() {
		return manufacturingdate;
	}

	public void setManufacturingdate(String manufacturingdate) {
		this.manufacturingdate = manufacturingdate;
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

	public String getModelyear() {
		return modelyear;
	}

	public void setModelyear(String modelyear) {
		this.modelyear = modelyear;
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

	public String getPurposeofuseid() {
		return purposeofuseid;
	}

	public void setPurposeofuseid(String purposeofuseid) {
		this.purposeofuseid = purposeofuseid;
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

	public String getPurposeofusename() {
		return purposeofusename;
	}

	public void setPurposeofusename(String purposeofusename) {
		this.purposeofusename = purposeofusename;
	}

	public Long getQuotavehicleid() {
		return quotavehicleid;
	}

	public void setQuotavehicleid(Long quotavehicleid) {
		this.quotavehicleid = quotavehicleid;
	}

	public BigDecimal getTonnage() {
		return tonnage;
	}

	public void setTonnage(BigDecimal tonnage) {
		this.tonnage = tonnage;
	}

	public Long getQuoteid() {
		return quoteid;
	}

	public void setQuoteid(Long quoteid) {
		this.quoteid = quoteid;
	}

	public Long getQuoteno() {
		return quoteno;
	}

	public void setQuoteno(Long quoteno) {
		this.quoteno = quoteno;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public String getOfficecode() {
		return officecode;
	}

	public void setOfficecode(String officecode) {
		this.officecode = officecode;
	}

	public String getOfficebrcd() {
		return officebrcd;
	}

	public void setOfficebrcd(String officebrcd) {
		this.officebrcd = officebrcd;
	}

	public String getOfficebrcdname() {
		return officebrcdname;
	}

	public void setOfficebrcdname(String officebrcdname) {
		this.officebrcdname = officebrcdname;
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

	public String getCustprovincecd() {
		return custprovincecd;
	}

	public void setCustprovincecd(String custprovincecd) {
		this.custprovincecd = custprovincecd;
	}

	public String getCustprovinceName() {
		return custprovinceName;
	}

	public void setCustprovincename(String custprovinceName) {
		this.custprovinceName = custprovinceName;
	}

	public void setCustprovinceName(String custprovinceName) {
		this.custprovinceName = custprovinceName;
	}

	public String getCustdistrictName() {
		return custdistrictName;
	}

	public String getCustdistrictcd() {
		return custdistrictcd;
	}

	public String getCustwardName() {
		return custwardName;
	}

	public String getCustwardcd() {
		return custwardcd;
	}

	public void setCustdistrictName(String custdistrictName) {
		this.custdistrictName = custdistrictName;
	}

	public void setCustdistrictcd(String custdistrictcd) {
		this.custdistrictcd = custdistrictcd;
	}

	public void setCustwardName(String custwardName) {
		this.custwardName = custwardName;
	}

	public void setCustwardcd(String custwardcd) {
		this.custwardcd = custwardcd;
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

	public String getBankaccount() {
		return bankaccount;
	}

	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}

	public String getBankaccountname() {
		return bankaccountname;
	}

	public void setBankaccountname(String bankaccountname) {
		this.bankaccountname = bankaccountname;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getBeneficiaryaddress() {
		return beneficiaryaddress;
	}

	public void setBeneficiaryaddress(String beneficiaryaddress) {
		this.beneficiaryaddress = beneficiaryaddress;
	}

	public String getBeneficiaryname() {
		return beneficiaryname;
	}

	public void setBeneficiaryname(String beneficiaryname) {
		this.beneficiaryname = beneficiaryname;
	}

	public String getBeneficiarytel() {
		return beneficiarytel;
	}

	public void setBeneficiarytel(String beneficiarytel) {
		this.beneficiarytel = beneficiarytel;
	}

	public String getBeneficiaryemail() {
		return beneficiaryemail;
	}

	public void setBeneficiaryemail(String beneficiaryemail) {
		this.beneficiaryemail = beneficiaryemail;
	}

	public String getBeneficiaryterms() {
		return beneficiaryterms;
	}

	public void setBeneficiaryterms(String beneficiaryterms) {
		this.beneficiaryterms = beneficiaryterms;
	}

	public Long getBranchinsuranceid() {
		return branchinsuranceid;
	}

	public void setBranchinsuranceid(Long branchinsuranceid) {
		this.branchinsuranceid = branchinsuranceid;
	}

	public String getContactaddress() {
		return contactaddress;
	}

	public void setContactaddress(String contactaddress) {
		this.contactaddress = contactaddress;
	}

	public String getContactname() {
		return contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname;
	}

	public String getInsuredaddress() {
		return insuredaddress;
	}

	public void setInsuredaddress(String insuredaddress) {
		this.insuredaddress = insuredaddress;
	}

	public String getInsuredname() {
		return insuredname;
	}

	public void setInsuredname(String insuredname) {
		this.insuredname = insuredname;
	}

	public String getContacttel() {
		return contacttel;
	}

	public void setContacttel(String contacttel) {
		this.contacttel = contacttel;
	}

	public String getContactemail() {
		return contactemail;
	}

	public void setContactemail(String contactemail) {
		this.contactemail = contactemail;
	}

	public String getInsuredtel() {
		return insuredtel;
	}

	public void setInsuredtel(String insuredtel) {
		this.insuredtel = insuredtel;
	}

	public String getInsuredemail() {
		return insuredemail;
	}

	public void setInsuredemail(String insuredemail) {
		this.insuredemail = insuredemail;
	}

	public String getInsuranceitemcode() {
		return insuranceitemcode;
	}

	public void setInsuranceitemcode(String insuranceitemcode) {
		this.insuranceitemcode = insuranceitemcode;
	}

	public String getInsuranceitemname() {
		return insuranceitemname;
	}

	public void setInsuranceitemname(String insuranceitemname) {
		this.insuranceitemname = insuranceitemname;
	}

	public List<TtiQuotaFeeDTO> getQuotafees() {
		return quotafees;
	}

	public void setQuotafees(List<TtiQuotaFeeDTO> quotafees) {
		this.quotafees = quotafees;
	}

	public List<TtiQuotaFeeDTO> getDiscountfeeproductlst() {
		return discountfeeproductlst;
	}

	public void setDiscountfeeproductlst(List<TtiQuotaFeeDTO> discountfeeproductlst) {
		this.discountfeeproductlst = discountfeeproductlst;
	}

	public List<TtiQuotapolicydetailDTO> getInsuranceproductaddlst() {
		return insuranceproductaddlst;
	}

	public void setInsuranceproductaddlst(List<TtiQuotapolicydetailDTO> insuranceproductaddlst) {
		this.insuranceproductaddlst = insuranceproductaddlst;
	}

	public List<TtiQuotapolicydetailDTO> getInsuranceproductlst() {
		return insuranceproductlst;
	}

	public void setInsuranceproductlst(List<TtiQuotapolicydetailDTO> insuranceproductlst) {
		this.insuranceproductlst = insuranceproductlst;
	}

	public List<TtiQuotaFeeDTO> getFeeminimumproduct() {
		return feeminimumproduct;
	}

	public void setFeeminimumproduct(List<TtiQuotaFeeDTO> feeminimumproduct) {
		this.feeminimumproduct = feeminimumproduct;
	}

	public List<TtiQuotaFeeDTO> getInsuranceriskproduct() {
		return insuranceriskproduct;
	}

	public void setInsuranceriskproduct(List<TtiQuotaFeeDTO> insuranceriskproduct) {
		this.insuranceriskproduct = insuranceriskproduct;
	}

	public List<TtiQuoteaccessoryDTO> getQuoteaccessorylst() {
		return quoteaccessorylst;
	}

	public void setQuoteaccessorylst(List<TtiQuoteaccessoryDTO> quoteaccessorylst) {
		this.quoteaccessorylst = quoteaccessorylst;
	}

	public List<TtiQuotapolicyinsuranceDTO> getQuotapolicyinsuranceItems() {
		return quotapolicyinsuranceItems;
	}

	public void setQuotapolicyinsuranceItems(List<TtiQuotapolicyinsuranceDTO> quotapolicyinsuranceItems) {
		this.quotapolicyinsuranceItems = quotapolicyinsuranceItems;
	}

	public String getWordingtype() {
		return wordingtype;
	}

	public void setWordingtype(String wordingtype) {
		this.wordingtype = wordingtype;
	}

	public Date getPreEffectivefrom() {
		return preEffectivefrom;
	}

	public void setPreEffectivefrom(Date preEffectivefrom) {
		this.preEffectivefrom = preEffectivefrom;
	}

	public Date getPreEffectiveto() {
		return preEffectiveto;
	}

	public void setPreEffectiveto(Date preEffectiveto) {
		this.preEffectiveto = preEffectiveto;
	}

	public Date getLastEffectivefrom() {
		return lastEffectivefrom;
	}

	public void setLastEffectivefrom(Date lastEffectivefrom) {
		this.lastEffectivefrom = lastEffectivefrom;
	}

	public Date getLastEffectiveto() {
		return lastEffectiveto;
	}

	public void setLastEffectiveto(Date lastEffectiveto) {
		this.lastEffectiveto = lastEffectiveto;
	}

	public String getLastEffectivefromtm() {
		return lastEffectivefromtm;
	}

	public void setLastEffectivefromtm(String lastEffectivefromtm) {
		this.lastEffectivefromtm = lastEffectivefromtm;
	}

	public String getLastEffectivetotm() {
		return lastEffectivetotm;
	}

	public void setLastEffectivetotm(String lastEffectivetotm) {
		this.lastEffectivetotm = lastEffectivetotm;
	}

	public List<PhigocDTO> getPhigocdtolst() {
		return phigocdtolst;
	}

	public void setPhigocdtolst(List<PhigocDTO> phigocdtolst) {
		this.phigocdtolst = phigocdtolst;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public BigDecimal getNetfeeRefunds() {
		return netfeeRefunds;
	}

	public void setNetfeeRefunds(BigDecimal netfeeRefunds) {
		this.netfeeRefunds = netfeeRefunds;
	}

	public BigDecimal getTaxRefunds() {
		return taxRefunds;
	}

	public void setTaxRefunds(BigDecimal taxRefunds) {
		this.taxRefunds = taxRefunds;
	}

	public BigDecimal getSumbfFeeRefunds() {
		return sumbfFeeRefunds;
	}

	public void setSumbfFeeRefunds(BigDecimal sumbfFeeRefunds) {
		this.sumbfFeeRefunds = sumbfFeeRefunds;
	}

	public Long getPolicyrefundsid() {
		return policyrefundsid;
	}

	public void setPolicyrefundsid(Long policyrefundsid) {
		this.policyrefundsid = policyrefundsid;
	}

	public String getReasoncode() {
		return reasoncode;
	}

	public void setReasoncode(String reasoncode) {
		this.reasoncode = reasoncode;
	}

	public String getReasonname() {
		return reasonname;
	}

	public void setReasonname(String reasonname) {
		this.reasonname = reasonname;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCanceldate() {
		return canceldate;
	}

	public void setCanceldate(Date canceldate) {
		this.canceldate = canceldate;
	}

	public String getCanceluser() {
		return canceluser;
	}

	public void setCanceluser(String canceluser) {
		this.canceluser = canceluser;
	}

	public Date getTypingdate() {
		return typingdate;
	}

	public void setTypingdate(Date typingdate) {
		this.typingdate = typingdate;
	}

	public String getQuotetypeorg() {
		return quotetypeorg;
	}

	public void setQuotetypeorg(String quotetypeorg) {
		this.quotetypeorg = quotetypeorg;
	}

	public String getNoclaim() {
		return noclaim;
	}

	public void setNoclaim(String noclaim) {
		this.noclaim = noclaim;
	}

	public Integer getClaimLoss() {
		return claimLoss;
	}

	public void setClaimLoss(Integer claimLoss) {
		this.claimLoss = claimLoss;
	}

	public Integer getNdaysSinterruption() {
		return ndaysSinterruption;
	}

	public void setNdaysSinterruption(Integer ndaysSinterruption) {
		this.ndaysSinterruption = ndaysSinterruption;
	}

	public BigDecimal getAmttv() {
		return amttv;
	}

	public void setAmttv(BigDecimal amttv) {
		this.amttv = amttv;
	}

	public BigDecimal getRateLoss() {
		return rateLoss;
	}

	public void setRateLoss(BigDecimal rateLoss) {
		this.rateLoss = rateLoss;
	}

	public Date getIssueddate() {
		return issueddate;
	}

	public void setIssueddate(Date issueddate) {
		this.issueddate = issueddate;
	}

	public Date getIssueddateorg() {
		return issueddateorg;
	}

	public void setIssueddateorg(Date issueddateorg) {
		this.issueddateorg = issueddateorg;
	}

	public BigDecimal getPayfeepre() {
		return payfeepre;
	}

	public void setPayfeepre(BigDecimal payfeepre) {
		this.payfeepre = payfeepre;
	}

	public String getInsuranceproductcode() {
		return insuranceproductcode;
	}

	public void setInsuranceproductcode(String insuranceproductcode) {
		this.insuranceproductcode = insuranceproductcode;
	}

	public String getInsuranceproductname() {
		return insuranceproductname;
	}

	public void setInsuranceproductname(String insuranceproductname) {
		this.insuranceproductname = insuranceproductname;
	}
}
