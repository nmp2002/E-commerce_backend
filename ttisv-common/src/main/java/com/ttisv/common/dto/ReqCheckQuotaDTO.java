package com.ttisv.common.dto;

import java.util.Date;

public class ReqCheckQuotaDTO {
	Long quotaid;
	String vinnumber;
	String tiCode;
	String wordingtype;
	Date effectivefrom;
	Date effectiveto;
	public Long getQuotaid() {
		return quotaid;
	}
	public void setQuotaid(Long quotaid) {
		this.quotaid = quotaid;
	}
	
	public String getVinnumber() {
		return vinnumber;
	}
	public void setVinnumber(String vinnumber) {
		this.vinnumber = vinnumber;
	}
	public String getTiCode() {
		return tiCode;
	}
	public void setTiCode(String tiCode) {
		this.tiCode = tiCode;
	}
	public String getWordingtype() {
		return wordingtype;
	}
	public void setWordingtype(String wordingtype) {
		this.wordingtype = wordingtype;
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
	
}
