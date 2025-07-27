package com.ttisv.common.dto;

import java.util.Date;

public class ResCheckQuotaDTO {

	int countgcn;
    Long orginalpolicyid;
	Long quotaid;
	Integer days;
	String policyid;
	private String message;
	private Date effectiveto;
	private String effectivetotm;
	private Date effectivefrmnew;
	private Date effectivetonew;
	String code = "00";
	public Long getOrginalpolicyid() {
		return orginalpolicyid;
	}

	public void setOrginalpolicyid(Long orginalpolicyid) {
		this.orginalpolicyid = orginalpolicyid;
	}

	public Long getQuotaid() {
		return quotaid;
	}

	public void setQuotaid(Long quotaid) {
		this.quotaid = quotaid;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public int getCountgcn() {
		return countgcn;
	}

	public void setCountgcn(int countgcn) {
		this.countgcn = countgcn;
	}

	public String getPolicyid() {
		return policyid;
	}

	public void setPolicyid(String policyid) {
		this.policyid = policyid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getEffectiveto() {
		return effectiveto;
	}

	public void setEffectiveto(Date effectiveto) {
		this.effectiveto = effectiveto;
	}

	public String getEffectivetotm() {
		return effectivetotm;
	}

	public void setEffectivetotm(String effectivetotm) {
		this.effectivetotm = effectivetotm;
	}

	public Date getEffectivefrmnew() {
		return effectivefrmnew;
	}

	public void setEffectivefrmnew(Date effectivefrmnew) {
		this.effectivefrmnew = effectivefrmnew;
	}

	public Date getEffectivetonew() {
		return effectivetonew;
	}

	public void setEffectivetonew(Date effectivetonew) {
		this.effectivetonew = effectivetonew;
	}

	
}
