package com.ttisv.common.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class TtiQuotaDTO {

	private String error;
	
	private String mess;
	
	private Long quoteid;

	private String agentcode;

	private String agentname;

	private Date appDate;

	private Date applieddate;

	private String approveby;

	private Date approvedate;

	private String bankaccount;

	private String bankcode;

	private String beneficiaryaddress;

	private String beneficiaryname;

	private String beneficiarytel;

	private String beneficiaryemail;

	private String beneficiaryterms;

	private String beneficiaryrepresent;

	private String beneficiarypos;

	private Long branchinsuranceid;

	private String cancelby;

	private Date canceldate;

	private String cancelreason;

	private String ccy;

	private String contactaddress;

	private String contactname;

	private Date modifiedDate;

	private String modifiedby;

	private String createdby;

	private Date createdDate;

	private String customercode;

	private String customername;

	private Date cutofdate;

	private Date typingdate;

	private Integer cutofday;

	private String cwdid;

	private String cwdtype;

	private Date contractdate;

	private String deletedby;

	private Date deleteddate;

	private String deletedreason;

	private BigDecimal exchangerate;

	private Long insurancecompanyid;

	private String insuredaddress;

	private String insuredname;

	private String isapprove;

	private String iscancel;

	private String isdeleted;

	private String isfree;

	private String isrestore;

	private String issend;

	private Date issueddate;

	private Long lastcontractid;

	private Integer quotastatus;

	private Date quotedate;
	
	private Date quotedateorg;
	

	private String quoteno;

	private String orgContractno;

	private String preContractno;

	private String quotatype;

	private String quotesubject;

	private String restoreby;

	private String restoredate;

	private String restoredreason;

	private String salecode;

	private String salename;

	private Date trandate;

	private String officebrcd;

	private String officebrcdName;

	private String tiCode;

	private String tenantcode;

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

	private String bankaccountname;

	private String contacttel;

	private String contactemail;

	private String insuredtel;

	private String insuredemail;

	private String officecode;

	private String officename;

	private String vinnumber;

	private String enginenumber;

	private String licenseplates;

	private String quotatypeid;

	private String brandcode;

	private String brandname;

	private String capacity;

	private Integer seatingcapacity;

	private Date registrationdate;

	private Date deliverydate;

	private String mgfdate;

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
	
	private String lineOffDate;

	private String vehicletypeid;

	private String vehicletypename;

	private String purposeofusename;

	private Long quotavehicleid;

	private BigDecimal tonnage;

	private Long quotapolicyid;

	private String quotapolicyno;

	private String policytypeid;

	private Long nextaddtionalid;

	private Long previousaddtionalid;

	private Long orginaladdtionalid;

	private String orginaladdquoteno;

	private String previousaddtionalquoteno;

	private String campaignid;

	private String discountid;

	private Long programid;

	private Date effectivefrom;

	private Date effectiveto;

	private String effectivefromtm;

	private String effectivetotm;

	private String wordingtype;

	private String deductibleCode;

	private String includevat;

	private String note;

	private List<TtiQuotapolicydetailDTO> quotapolicydetails;

	private TtiQuotevehicleDTO quotevehicle;

	private List<TtiQuotapolicyDTO> quotapolicys;

	private List<TtiQuotaFeeDTO> quotafeesDisfee;

	private List<TtiQuotaFeeDTO> quotafeesDKBS;

	private List<TtiQuotaFeeDTO> quotafeesFeemin;

	private List<TtiQuotaFeeDTO> quotafeesInsurancerisk;

	private String previousquotapolicyno;

	private String previouspolicyno;

	private int totalRow;

	private Long tongthoigian;
	
	private Long npolicy;

	private String quotetypeorg;

	private String countrycode;
	
	private String countryname;
	
	private Long	nextquoteid;
	private Long previousquoteid;
	
	public String getQuotetypeorg() {
		return quotetypeorg;
	}

	public void setQuotetypeorg(String quotetypeorg) {
		this.quotetypeorg = quotetypeorg;
	}

	public Long getQuoteid() {
		return quoteid;
	}

	public void setQuoteid(Long quoteid) {
		this.quoteid = quoteid;
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

	public Date getAppDate() {
		return appDate;
	}

	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}

	public Date getApplieddate() {
		return applieddate;
	}

	public void setApplieddate(Date applieddate) {
		this.applieddate = applieddate;
	}

	public String getApproveby() {
		return approveby;
	}

	public void setApproveby(String approveby) {
		this.approveby = approveby;
	}

	public Date getApprovedate() {
		return approvedate;
	}

	public void setApprovedate(Date approvedate) {
		this.approvedate = approvedate;
	}

	public String getBankaccount() {
		return bankaccount;
	}

	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
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

	public String getBeneficiaryrepresent() {
		return beneficiaryrepresent;
	}

	public void setBeneficiaryrepresent(String beneficiaryrepresent) {
		this.beneficiaryrepresent = beneficiaryrepresent;
	}

	public String getBeneficiarypos() {
		return beneficiarypos;
	}

	public void setBeneficiarypos(String beneficiarypos) {
		this.beneficiarypos = beneficiarypos;
	}

	public Long getBranchinsuranceid() {
		return branchinsuranceid;
	}

	public void setBranchinsuranceid(Long branchinsuranceid) {
		this.branchinsuranceid = branchinsuranceid;
	}

	public String getCancelby() {
		return cancelby;
	}

	public void setCancelby(String cancelby) {
		this.cancelby = cancelby;
	}

	public Date getCanceldate() {
		return canceldate;
	}

	public void setCanceldate(Date canceldate) {
		this.canceldate = canceldate;
	}

	public String getCancelreason() {
		return cancelreason;
	}

	public void setCancelreason(String cancelreason) {
		this.cancelreason = cancelreason;
	}

	public String getCcy() {
		return ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
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

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
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

	public Date getCutofdate() {
		return cutofdate;
	}

	public void setCutofdate(Date cutofdate) {
		this.cutofdate = cutofdate;
	}

	public Date getTypingdate() {
		return typingdate;
	}

	public void setTypingdate(Date typingdate) {
		this.typingdate = typingdate;
	}

	public Integer getCutofday() {
		return cutofday;
	}

	public void setCutofday(Integer cutofday) {
		this.cutofday = cutofday;
	}

	public String getCwdid() {
		return cwdid;
	}

	public void setCwdid(String cwdid) {
		this.cwdid = cwdid;
	}

	public String getCwdtype() {
		return cwdtype;
	}

	public void setCwdtype(String cwdtype) {
		this.cwdtype = cwdtype;
	}

	public Date getContractdate() {
		return contractdate;
	}

	public void setContractdate(Date contractdate) {
		this.contractdate = contractdate;
	}

	public String getDeletedby() {
		return deletedby;
	}

	public void setDeletedby(String deletedby) {
		this.deletedby = deletedby;
	}

	public Date getDeleteddate() {
		return deleteddate;
	}

	public void setDeleteddate(Date deleteddate) {
		this.deleteddate = deleteddate;
	}

	public String getDeletedreason() {
		return deletedreason;
	}

	public void setDeletedreason(String deletedreason) {
		this.deletedreason = deletedreason;
	}

	public BigDecimal getExchangerate() {
		return exchangerate;
	}

	public void setExchangerate(BigDecimal exchangerate) {
		this.exchangerate = exchangerate;
	}

	public Long getInsurancecompanyid() {
		return insurancecompanyid;
	}

	public void setInsurancecompanyid(Long insurancecompanyid) {
		this.insurancecompanyid = insurancecompanyid;
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

	public String getIsapprove() {
		return isapprove;
	}

	public void setIsapprove(String isapprove) {
		this.isapprove = isapprove;
	}

	public String getIscancel() {
		return iscancel;
	}

	public void setIscancel(String iscancel) {
		this.iscancel = iscancel;
	}

	public String getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getIsfree() {
		return isfree;
	}

	public void setIsfree(String isfree) {
		this.isfree = isfree;
	}

	public String getIsrestore() {
		return isrestore;
	}

	public void setIsrestore(String isrestore) {
		this.isrestore = isrestore;
	}

	public String getIssend() {
		return issend;
	}

	public void setIssend(String issend) {
		this.issend = issend;
	}

	public Date getIssueddate() {
		return issueddate;
	}

	public void setIssueddate(Date issueddate) {
		this.issueddate = issueddate;
	}

	public Long getLastcontractid() {
		return lastcontractid;
	}

	public void setLastcontractid(Long lastcontractid) {
		this.lastcontractid = lastcontractid;
	}

	public Integer getQuotastatus() {
		return quotastatus;
	}

	public void setQuotastatus(Integer quotastatus) {
		this.quotastatus = quotastatus;
	}

	public Date getQuotedate() {
		return quotedate;
	}

	public void setQuotedate(Date quotedate) {
		this.quotedate = quotedate;
	}

	
	
	public Date getQuotedateorg() {
		return quotedateorg;
	}

	public void setQuotedateorg(Date quotedateorg) {
		this.quotedateorg = quotedateorg;
	}

	public String getQuoteno() {
		return quoteno;
	}

	public void setQuoteno(String quoteno) {
		this.quoteno = quoteno;
	}

	public String getQuotatype() {
		return quotatype;
	}

	public void setQuotatype(String quotatype) {
		this.quotatype = quotatype;
	}

	public String getQuotesubject() {
		return quotesubject;
	}

	public void setQuotesubject(String quotesubject) {
		this.quotesubject = quotesubject;
	}

	public String getRestoreby() {
		return restoreby;
	}

	public void setRestoreby(String restoreby) {
		this.restoreby = restoreby;
	}

	public String getRestoredate() {
		return restoredate;
	}

	public void setRestoredate(String restoredate) {
		this.restoredate = restoredate;
	}

	public String getRestoredreason() {
		return restoredreason;
	}

	public void setRestoredreason(String restoredreason) {
		this.restoredreason = restoredreason;
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

	public Date getTrandate() {
		return trandate;
	}

	public void setTrandate(Date trandate) {
		this.trandate = trandate;
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

	public String getTiCode() {
		return tiCode;
	}

	public void setTiCode(String tiCode) {
		this.tiCode = tiCode;
	}

	public String getTenantcode() {
		return tenantcode;
	}

	public void setTenantcode(String tenantcode) {
		this.tenantcode = tenantcode;
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

	public String getBankaccountname() {
		return bankaccountname;
	}

	public void setBankaccountname(String bankaccountname) {
		this.bankaccountname = bankaccountname;
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

	public String getMgfdate() {
		return mgfdate;
	}

	public void setMgfdate(String mgfdate) {
		this.mgfdate = mgfdate;
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

	public String getPolicytypeid() {
		return policytypeid;
	}

	public void setPolicytypeid(String policytypeid) {
		this.policytypeid = policytypeid;
	}

	public TtiQuotevehicleDTO getQuotevehicle() {
		return quotevehicle;
	}

	public void setQuotevehicle(TtiQuotevehicleDTO quotevehicle) {
		this.quotevehicle = quotevehicle;
	}

	public List<TtiQuotaFeeDTO> getQuotafeesDisfee() {
		return quotafeesDisfee;
	}

	public void setQuotafeesDisfee(List<TtiQuotaFeeDTO> quotafeesDisfee) {
		this.quotafeesDisfee = quotafeesDisfee;
	}

	public List<TtiQuotaFeeDTO> getQuotafeesDKBS() {
		return quotafeesDKBS;
	}

	public void setQuotafeesDKBS(List<TtiQuotaFeeDTO> quotafeesDKBS) {
		this.quotafeesDKBS = quotafeesDKBS;
	}

	public List<TtiQuotaFeeDTO> getQuotafeesFeemin() {
		return quotafeesFeemin;
	}

	public void setQuotafeesFeemin(List<TtiQuotaFeeDTO> quotafeesFeemin) {
		this.quotafeesFeemin = quotafeesFeemin;
	}

	public List<TtiQuotaFeeDTO> getQuotafeesInsurancerisk() {
		return quotafeesInsurancerisk;
	}

	public void setQuotafeesInsurancerisk(List<TtiQuotaFeeDTO> quotafeesInsurancerisk) {
		this.quotafeesInsurancerisk = quotafeesInsurancerisk;
	}

	public List<TtiQuotapolicyDTO> getQuotapolicys() {
		return quotapolicys;
	}

	public void setQuotapolicys(List<TtiQuotapolicyDTO> quotapolicys) {
		this.quotapolicys = quotapolicys;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public String getCusttaxno() {
		return custtaxno;
	}

	public void setCusttaxno(String custtaxno) {
		this.custtaxno = custtaxno;
	}

	public Long getNextaddtionalid() {
		return nextaddtionalid;
	}

	public void setNextaddtionalid(Long nextaddtionalid) {
		this.nextaddtionalid = nextaddtionalid;
	}

	public Long getPreviousaddtionalid() {
		return previousaddtionalid;
	}

	public void setPreviousaddtionalid(Long previousaddtionalid) {
		this.previousaddtionalid = previousaddtionalid;
	}

	public Long getOrginaladdtionalid() {
		return orginaladdtionalid;
	}

	public void setOrginaladdtionalid(Long orginaladdtionalid) {
		this.orginaladdtionalid = orginaladdtionalid;
	}

	public String getOrginaladdquoteno() {
		return orginaladdquoteno;
	}

	public void setOrginaladdquoteno(String orginaladdquoteno) {
		this.orginaladdquoteno = orginaladdquoteno;
	}

	public String getPreviousaddtionalquoteno() {
		return previousaddtionalquoteno;
	}

	public void setPreviousaddtionalquoteno(String previousaddtionalquoteno) {
		this.previousaddtionalquoteno = previousaddtionalquoteno;
	}

	public String getPreviousquotapolicyno() {
		return previousquotapolicyno;
	}

	public void setPreviousquotapolicyno(String previousquotapolicyno) {
		this.previousquotapolicyno = previousquotapolicyno;
	}

	public String getPreviouspolicyno() {
		return previouspolicyno;
	}

	public void setPreviouspolicyno(String previouspolicyno) {
		this.previouspolicyno = previouspolicyno;
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

	public String getWordingtype() {
		return wordingtype;
	}

	public void setWordingtype(String wordingtype) {
		this.wordingtype = wordingtype;
	}

	public String getDeductibleCode() {
		return deductibleCode;
	}

	public void setDeductibleCode(String deductibleCode) {
		this.deductibleCode = deductibleCode;
	}

	public String getIncludevat() {
		return includevat;
	}

	public void setIncludevat(String includevat) {
		this.includevat = includevat;
	}

	public List<TtiQuotapolicydetailDTO> getQuotapolicydetails() {
		return quotapolicydetails;
	}

	public void setQuotapolicydetails(List<TtiQuotapolicydetailDTO> quotapolicydetails) {
		this.quotapolicydetails = quotapolicydetails;
	}

	public String getOrgContractno() {
		return orgContractno;
	}

	public void setOrgContractno(String orgContractno) {
		this.orgContractno = orgContractno;
	}

	public String getPreContractno() {
		return preContractno;
	}

	public void setPreContractno(String preContractno) {
		this.preContractno = preContractno;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}

	public Long getTongthoigian() {
		return tongthoigian;
	}

	public void setTongthoigian(Long tongthoigian) {
		this.tongthoigian = tongthoigian;
	}

	public Long getNpolicy() {
		return npolicy;
	}

	public void setNpolicy(Long npolicy) {
		this.npolicy = npolicy;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public Long getNextquoteid() {
		return nextquoteid;
	}

	public void setNextquoteid(Long nextquoteid) {
		this.nextquoteid = nextquoteid;
	}

	public Long getPreviousquoteid() {
		return previousquoteid;
	}

	public void setPreviousquoteid(Long previousquoteid) {
		this.previousquoteid = previousquoteid;
	}

	public String getLineOffDate() {
		return lineOffDate;
	}

	public void setLineOffDate(String lineOffDate) {
		this.lineOffDate = lineOffDate;
	}

}
