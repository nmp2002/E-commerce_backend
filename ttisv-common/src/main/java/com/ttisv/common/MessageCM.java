package com.ttisv.common;

public class MessageCM {
	public MessageCM() {
		
	}
	
	public MessageCM(String errorCode,String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}
	
	public MessageCM(String errorCode,String errorDescription,String value) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.value = value;
	}
	
	private String errorCode;
	private String errorDescription;
	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
}
