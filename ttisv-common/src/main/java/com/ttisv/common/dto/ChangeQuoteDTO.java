package com.ttisv.common.dto;


public class ChangeQuoteDTO {
	private Long quotapolicyid;
	private int changenumber;
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getQuotapolicyid() {
		return quotapolicyid;
	}
	public void setQuotapolicyid(Long quotapolicyid) {
		this.quotapolicyid = quotapolicyid;
	}
	public int getChangenumber() {
		return changenumber;
	}
	public void setChangenumber(int changenumber) {
		this.changenumber = changenumber;
	}
	
	
}
