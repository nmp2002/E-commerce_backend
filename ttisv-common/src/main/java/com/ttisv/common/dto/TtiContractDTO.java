package com.ttisv.common.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TtiContractDTO {

	private String errorcode = "";
	private String mess;

	private Long contractid;

	private String agentcode;

	private String customercode;

	private String customername;

	private String bankaccount;

	private String bankname;

	private Long branchinsuranceid;

	private String cancelby;

	private Date canceldate;

	private Long companyid;

	private Long companyinsuranceid;

	private String contactaddress;

	private String contactemail;

	private String contactname;

	private String contacttel;

	private Date contractdate;

	private Long contractgroupid;

	private Long contractnextid;

	private String contractno;

	private Long contractpreviousid;

	private String contractstatus;

	private String contractsubject;

	private String contracttypeid;

	private String createdby;

	private String currency;

	private BigDecimal exchangerate;

	private Long guestid;

	private Long guesttypeid;

	private String iscancel;

	private String note;

	private Integer num;

	private Long quoteid;

	private String salecode;

	private String salename;

	private String updatedby;

	private Date updateddate;

	private Long quotapolicyid;

	private String quotapolicyno;

	private String quoteno;

	private Date quotedate;
	private Date createdDate;
	private String enginenumber;

	private String vinnumber;

	private String licenseplates;

	private String brandcode;

	private String brandname;

	private String officecode;

	private String officename;

	private int totalRow;

	private String agentname;

	private Date appDate;

	private Date applieddate;

	private String approveby;

	private Date approvedate;

	private String bankcode;

	private String beneficiaryaddress;

	private String beneficiaryname;

	private String beneficiarytel;

	private String beneficiaryemail;

	private String beneficiaryterms;

	private String beneficiaryrepresent;

	private String beneficiarypos;

	private String cancelreason;

	private String ccy;

	private Date cutofdate;

	private Date typingdate;

	private Integer cutofday;

	private String cwdid;

	private Integer cwdtype;

	private String deletedby;

	private Date deleteddate;

	private String deletedreason;

	private Long insurancecompanyid;

	private String insuredaddress;

	private String insuredname;

	private String isapprove;

	private String isdeleted;

	private String isfree;

	private String isrestore;

	private String issend;

	private Date issueddate;

	private Long lastcontractid;

	private Integer quotastatus;

	private String quotatype;

	private String quotesubject;

	private String restoreby;

	private String restoredate;

	private String restoredreason;

	private Date trandate;

	private String officebrcd;

	private String officebrcdName;

	private String custtype;

	private String custtypeName;

	private String custaddress;

	private String custemail;

	private String custtel;

	private String custidno;

	private String custprovincecd;

	private String custprovinceName;

	private String custdistrictcd;

	private String custdistrictName;

	private String custwardcd;

	private String custwardName;

	private String countrycode;

	private String countryname;

	private String bankaccountname;

	private String insuredtel;

	private String insuredemail;

	private String quotatypeid;

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

	private String vehicletypeid;

	private String vehicletypename;

	private String purposeofusename;

	private Long quotavehicleid;

	private BigDecimal tonnage;

	private String policytypeid;

	private String tiCode;

	private TtiQuotevehicleDTO quotevehicle;

	private List<TtiQuotapolicyDTO> quotapolicys;

	private List<TtiQuotaFeeDTO> quotafeesDisfee;

	private List<TtiQuotaFeeDTO> quotafeesDKBS;

	private List<TtiQuotaFeeDTO> quotafeesFeemin;

	private List<TtiQuotaFeeDTO> quotafeesInsurancerisk;

	public TtiContractDTO() {
	}

	public Long getContractid() {
		return this.contractid;
	}

	public void setContractid(Long contractid) {
		this.contractid = contractid;
	}

	public String getAgentcode() {
		return agentcode;
	}

	public void setAgentcode(String agentcode) {
		this.agentcode = agentcode;
	}

	public String getBankaccount() {
		return this.bankaccount;
	}

	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}

	public String getBankname() {
		return this.bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public Long getBranchinsuranceid() {
		return this.branchinsuranceid;
	}

	public void setBranchinsuranceid(Long branchinsuranceid) {
		this.branchinsuranceid = branchinsuranceid;
	}

	public String getCancelby() {
		return this.cancelby;
	}

	public void setCancelby(String cancelby) {
		this.cancelby = cancelby;
	}

	public Date getCanceldate() {
		return this.canceldate;
	}

	public void setCanceldate(Date canceldate) {
		this.canceldate = canceldate;
	}

	public Long getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(Long companyid) {
		this.companyid = companyid;
	}

	public Long getCompanyinsuranceid() {
		return this.companyinsuranceid;
	}

	public void setCompanyinsuranceid(Long companyinsuranceid) {
		this.companyinsuranceid = companyinsuranceid;
	}

	public String getContactaddress() {
		return this.contactaddress;
	}

	public void setContactaddress(String contactaddress) {
		this.contactaddress = contactaddress;
	}

	public String getContactemail() {
		return this.contactemail;
	}

	public void setContactemail(String contactemail) {
		this.contactemail = contactemail;
	}

	public String getContactname() {
		return this.contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname;
	}

	public String getContacttel() {
		return this.contacttel;
	}

	public void setContacttel(String contacttel) {
		this.contacttel = contacttel;
	}

	public Date getContractdate() {
		return this.contractdate;
	}

	public void setContractdate(Date contractdate) {
		this.contractdate = contractdate;
	}

	public Long getContractgroupid() {
		return this.contractgroupid;
	}

	public void setContractgroupid(Long contractgroupid) {
		this.contractgroupid = contractgroupid;
	}

	public Long getContractnextid() {
		return this.contractnextid;
	}

	public void setContractnextid(Long contractnextid) {
		this.contractnextid = contractnextid;
	}

	public String getContractno() {
		return this.contractno;
	}

	public void setContractno(String contractno) {
		this.contractno = contractno;
	}

	public Long getContractpreviousid() {
		return this.contractpreviousid;
	}

	public void setContractpreviousid(Long contractpreviousid) {
		this.contractpreviousid = contractpreviousid;
	}

	public String getContractstatus() {
		return this.contractstatus;
	}

	public void setContractstatus(String contractstatus) {
		this.contractstatus = contractstatus;
	}

	public String getContractsubject() {
		return this.contractsubject;
	}

	public void setContractsubject(String contractsubject) {
		this.contractsubject = contractsubject;
	}

	public String getContracttypeid() {
		return this.contracttypeid;
	}

	public void setContracttypeid(String contracttypeid) {
		this.contracttypeid = contracttypeid;
	}

	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getExchangerate() {
		return this.exchangerate;
	}

	public void setExchangerate(BigDecimal exchangerate) {
		this.exchangerate = exchangerate;
	}

	public Long getGuestid() {
		return this.guestid;
	}

	public void setGuestid(Long guestid) {
		this.guestid = guestid;
	}

	public Long getGuesttypeid() {
		return this.guesttypeid;
	}

	public void setGuesttypeid(Long guesttypeid) {
		this.guesttypeid = guesttypeid;
	}

	public String getIscancel() {
		return this.iscancel;
	}

	public void setIscancel(String iscancel) {
		this.iscancel = iscancel;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Long getQuoteid() {
		return this.quoteid;
	}

	public void setQuoteid(Long quoteid) {
		this.quoteid = quoteid;
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

	public String getUpdatedby() {
		return this.updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public Date getUpdateddate() {
		return this.updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
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

	public String getEnginenumber() {
		return enginenumber;
	}

	public void setEnginenumber(String enginenumber) {
		this.enginenumber = enginenumber;
	}

	public String getVinnumber() {
		return vinnumber;
	}

	public void setVinnumber(String vinnumber) {
		this.vinnumber = vinnumber;
	}

	public String getLicenseplates() {
		return licenseplates;
	}

	public void setLicenseplates(String licenseplates) {
		this.licenseplates = licenseplates;
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

	public String getAgentname() {
		return agentname;
	}

	public Date getAppDate() {
		return appDate;
	}

	public Date getApplieddate() {
		return applieddate;
	}

	public String getApproveby() {
		return approveby;
	}

	public Date getApprovedate() {
		return approvedate;
	}

	public String getBankcode() {
		return bankcode;
	}

	public String getBeneficiaryaddress() {
		return beneficiaryaddress;
	}

	public String getBeneficiaryname() {
		return beneficiaryname;
	}

	public String getBeneficiarytel() {
		return beneficiarytel;
	}

	public String getBeneficiaryemail() {
		return beneficiaryemail;
	}

	public String getBeneficiaryterms() {
		return beneficiaryterms;
	}

	public String getCancelreason() {
		return cancelreason;
	}

	public String getCcy() {
		return ccy;
	}

	public Date getCutofdate() {
		return cutofdate;
	}

	public Integer getCutofday() {
		return cutofday;
	}

	public String getCwdid() {
		return cwdid;
	}

	public Integer getCwdtype() {
		return cwdtype;
	}

	public String getDeletedby() {
		return deletedby;
	}

	public Date getDeleteddate() {
		return deleteddate;
	}

	public String getDeletedreason() {
		return deletedreason;
	}

	public Long getInsurancecompanyid() {
		return insurancecompanyid;
	}

	public String getInsuredaddress() {
		return insuredaddress;
	}

	public String getInsuredname() {
		return insuredname;
	}

	public String getIsapprove() {
		return isapprove;
	}

	public String getIsdeleted() {
		return isdeleted;
	}

	public String getIsfree() {
		return isfree;
	}

	public String getIsrestore() {
		return isrestore;
	}

	public String getIssend() {
		return issend;
	}

	public Date getIssueddate() {
		return issueddate;
	}

	public Long getLastcontractid() {
		return lastcontractid;
	}

	public Integer getQuotastatus() {
		return quotastatus;
	}

	public String getQuotatype() {
		return quotatype;
	}

	public String getQuotesubject() {
		return quotesubject;
	}

	public String getRestoreby() {
		return restoreby;
	}

	public String getRestoredate() {
		return restoredate;
	}

	public String getRestoredreason() {
		return restoredreason;
	}

	public Date getTrandate() {
		return trandate;
	}

	public String getOfficebrcd() {
		return officebrcd;
	}

	public String getOfficebrcdName() {
		return officebrcdName;
	}

	public String getCusttype() {
		return custtype;
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

	public String getCustemail() {
		return custemail;
	}

	public String getCusttel() {
		return custtel;
	}

	public String getCustidno() {
		return custidno;
	}

	public String getCustprovincecd() {
		return custprovincecd;
	}

	public String getCustprovinceName() {
		return custprovinceName;
	}

	public String getBankaccountname() {
		return bankaccountname;
	}

	public String getInsuredtel() {
		return insuredtel;
	}

	public String getInsuredemail() {
		return insuredemail;
	}

	public String getQuotatypeid() {
		return quotatypeid;
	}

	public String getCapacity() {
		return capacity;
	}

	public Integer getSeatingcapacity() {
		return seatingcapacity;
	}

	public Date getRegistrationdate() {
		return registrationdate;
	}

	public Date getDeliverydate() {
		return deliverydate;
	}

	public String getMgfdate() {
		return mgfdate;
	}

	public String getEditioncode() {
		return editioncode;
	}

	public String getEditionname() {
		return editionname;
	}

	public BigDecimal getInvoiceprice() {
		return invoiceprice;
	}

	public BigDecimal getMarketprice() {
		return marketprice;
	}

	public String getModelcode() {
		return modelcode;
	}

	public String getModelname() {
		return modelname;
	}

	public String getModelyear() {
		return modelyear;
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

	public String getVehicletypeid() {
		return vehicletypeid;
	}

	public String getVehicletypename() {
		return vehicletypename;
	}

	public String getPurposeofusename() {
		return purposeofusename;
	}

	public Long getQuotavehicleid() {
		return quotavehicleid;
	}

	public BigDecimal getTonnage() {
		return tonnage;
	}

	public String getPolicytypeid() {
		return policytypeid;
	}

	public TtiQuotevehicleDTO getQuotevehicle() {
		return quotevehicle;
	}

	public List<TtiQuotapolicyDTO> getQuotapolicys() {
		return quotapolicys;
	}

	public List<TtiQuotaFeeDTO> getQuotafeesDisfee() {
		return quotafeesDisfee;
	}

	public List<TtiQuotaFeeDTO> getQuotafeesDKBS() {
		return quotafeesDKBS;
	}

	public List<TtiQuotaFeeDTO> getQuotafeesFeemin() {
		return quotafeesFeemin;
	}

	public List<TtiQuotaFeeDTO> getQuotafeesInsurancerisk() {
		return quotafeesInsurancerisk;
	}

	public void setAgentname(String agentname) {
		this.agentname = agentname;
	}

	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}

	public void setApplieddate(Date applieddate) {
		this.applieddate = applieddate;
	}

	public void setApproveby(String approveby) {
		this.approveby = approveby;
	}

	public void setApprovedate(Date approvedate) {
		this.approvedate = approvedate;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public void setBeneficiaryaddress(String beneficiaryaddress) {
		this.beneficiaryaddress = beneficiaryaddress;
	}

	public void setBeneficiaryname(String beneficiaryname) {
		this.beneficiaryname = beneficiaryname;
	}

	public void setBeneficiarytel(String beneficiarytel) {
		this.beneficiarytel = beneficiarytel;
	}

	public void setBeneficiaryemail(String beneficiaryemail) {
		this.beneficiaryemail = beneficiaryemail;
	}

	public void setBeneficiaryterms(String beneficiaryterms) {
		this.beneficiaryterms = beneficiaryterms;
	}

	public void setCancelreason(String cancelreason) {
		this.cancelreason = cancelreason;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

	public void setCutofdate(Date cutofdate) {
		this.cutofdate = cutofdate;
	}

	public void setCutofday(Integer cutofday) {
		this.cutofday = cutofday;
	}

	public void setCwdid(String cwdid) {
		this.cwdid = cwdid;
	}

	public void setCwdtype(Integer cwdtype) {
		this.cwdtype = cwdtype;
	}

	public void setDeletedby(String deletedby) {
		this.deletedby = deletedby;
	}

	public void setDeleteddate(Date deleteddate) {
		this.deleteddate = deleteddate;
	}

	public void setDeletedreason(String deletedreason) {
		this.deletedreason = deletedreason;
	}

	public void setInsurancecompanyid(Long insurancecompanyid) {
		this.insurancecompanyid = insurancecompanyid;
	}

	public void setInsuredaddress(String insuredaddress) {
		this.insuredaddress = insuredaddress;
	}

	public void setInsuredname(String insuredname) {
		this.insuredname = insuredname;
	}

	public void setIsapprove(String isapprove) {
		this.isapprove = isapprove;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public void setIsfree(String isfree) {
		this.isfree = isfree;
	}

	public void setIsrestore(String isrestore) {
		this.isrestore = isrestore;
	}

	public void setIssend(String issend) {
		this.issend = issend;
	}

	public void setIssueddate(Date issueddate) {
		this.issueddate = issueddate;
	}

	public void setLastcontractid(Long lastcontractid) {
		this.lastcontractid = lastcontractid;
	}

	public void setQuotastatus(Integer quotastatus) {
		this.quotastatus = quotastatus;
	}

	public void setQuotatype(String quotatype) {
		this.quotatype = quotatype;
	}

	public void setQuotesubject(String quotesubject) {
		this.quotesubject = quotesubject;
	}

	public void setRestoreby(String restoreby) {
		this.restoreby = restoreby;
	}

	public void setRestoredate(String restoredate) {
		this.restoredate = restoredate;
	}

	public void setRestoredreason(String restoredreason) {
		this.restoredreason = restoredreason;
	}

	public void setTrandate(Date trandate) {
		this.trandate = trandate;
	}

	public void setOfficebrcd(String officebrcd) {
		this.officebrcd = officebrcd;
	}

	public void setOfficebrcdName(String officebrcdName) {
		this.officebrcdName = officebrcdName;
	}

	public void setCusttype(String custtype) {
		this.custtype = custtype;
	}

	public void setCustaddress(String custaddress) {
		this.custaddress = custaddress;
	}

	public void setCustemail(String custemail) {
		this.custemail = custemail;
	}

	public void setCusttel(String custtel) {
		this.custtel = custtel;
	}

	public void setCustidno(String custidno) {
		this.custidno = custidno;
	}

	public void setCustprovincecd(String custprovincecd) {
		this.custprovincecd = custprovincecd;
	}

	public void setCustprovinceName(String custprovinceName) {
		this.custprovinceName = custprovinceName;
	}

	public void setBankaccountname(String bankaccountname) {
		this.bankaccountname = bankaccountname;
	}

	public void setInsuredtel(String insuredtel) {
		this.insuredtel = insuredtel;
	}

	public void setInsuredemail(String insuredemail) {
		this.insuredemail = insuredemail;
	}

	public void setQuotatypeid(String quotatypeid) {
		this.quotatypeid = quotatypeid;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public void setSeatingcapacity(Integer seatingcapacity) {
		this.seatingcapacity = seatingcapacity;
	}

	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}

	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}

	public void setMgfdate(String mgfdate) {
		this.mgfdate = mgfdate;
	}

	public void setEditioncode(String editioncode) {
		this.editioncode = editioncode;
	}

	public void setEditionname(String editionname) {
		this.editionname = editionname;
	}

	public void setInvoiceprice(BigDecimal invoiceprice) {
		this.invoiceprice = invoiceprice;
	}

	public void setMarketprice(BigDecimal marketprice) {
		this.marketprice = marketprice;
	}

	public void setModelcode(String modelcode) {
		this.modelcode = modelcode;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public void setModelyear(String modelyear) {
		this.modelyear = modelyear;
	}

	public void setPurposeofuseid(String purposeofuseid) {
		this.purposeofuseid = purposeofuseid;
	}

	public void setVehicletypeid(String vehicletypeid) {
		this.vehicletypeid = vehicletypeid;
	}

	public void setVehicletypename(String vehicletypename) {
		this.vehicletypename = vehicletypename;
	}

	public void setPurposeofusename(String purposeofusename) {
		this.purposeofusename = purposeofusename;
	}

	public void setQuotavehicleid(Long quotavehicleid) {
		this.quotavehicleid = quotavehicleid;
	}

	public void setTonnage(BigDecimal tonnage) {
		this.tonnage = tonnage;
	}

	public void setPolicytypeid(String policytypeid) {
		this.policytypeid = policytypeid;
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

	public Date getTypingdate() {
		return typingdate;
	}

	public void setTypingdate(Date typingdate) {
		this.typingdate = typingdate;
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

	public void setQuotevehicle(TtiQuotevehicleDTO quotevehicle) {
		this.quotevehicle = quotevehicle;
	}

	public void setQuotapolicys(List<TtiQuotapolicyDTO> quotapolicys) {
		this.quotapolicys = quotapolicys;
	}

	public void setQuotafeesDisfee(List<TtiQuotaFeeDTO> quotafeesDisfee) {
		this.quotafeesDisfee = quotafeesDisfee;
	}

	public void setQuotafeesDKBS(List<TtiQuotaFeeDTO> quotafeesDKBS) {
		this.quotafeesDKBS = quotafeesDKBS;
	}

	public void setQuotafeesFeemin(List<TtiQuotaFeeDTO> quotafeesFeemin) {
		this.quotafeesFeemin = quotafeesFeemin;
	}

	public void setQuotafeesInsurancerisk(List<TtiQuotaFeeDTO> quotafeesInsurancerisk) {
		this.quotafeesInsurancerisk = quotafeesInsurancerisk;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}

	public String getTiCode() {
		return tiCode;
	}

	public void setTiCode(String tiCode) {
		this.tiCode = tiCode;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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
}