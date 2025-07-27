package com.ttisv.common.dto;

public class AuthApiResDataDTO {
	String targetUrl;
	boolean success;
	String error;
	boolean unAuthorizedRequest;
	AuthApiResDTO result;
	public String getTargetUrl() {
		return targetUrl;
	}
	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public boolean isUnAuthorizedRequest() {
		return unAuthorizedRequest;
	}
	public void setUnAuthorizedRequest(boolean unAuthorizedRequest) {
		this.unAuthorizedRequest = unAuthorizedRequest;
	}
	public AuthApiResDTO getResult() {
		return result;
	}
	public void setResult(AuthApiResDTO result) {
		this.result = result;
	}
}
