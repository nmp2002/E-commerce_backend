package com.ttisv.common.api;

public class ResponseDTO {
	private String result;
	private String targetUrl;
	private boolean success;
	private boolean error;
	private boolean unAuthorizedRequest;
	private boolean __abp;

	public String getResult() {
		return result;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public boolean isSuccess() {
		return success;
	}

	public boolean isError() {
		return error;
	}

	public boolean isUnAuthorizedRequest() {
		return unAuthorizedRequest;
	}

	public boolean is__abp() {
		return __abp;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public void setUnAuthorizedRequest(boolean unAuthorizedRequest) {
		this.unAuthorizedRequest = unAuthorizedRequest;
	}

	public void set__abp(boolean __abp) {
		this.__abp = __abp;
	}
}
