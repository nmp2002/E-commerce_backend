package com.ttisv.common.dto;

public class AuthApiResDTO {
	String accessToken;
	String encryptedAccessToken;
	String expireInSeconds;
	String userId;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getEncryptedAccessToken() {
		return encryptedAccessToken;
	}
	public void setEncryptedAccessToken(String encryptedAccessToken) {
		this.encryptedAccessToken = encryptedAccessToken;
	}
	public String getExpireInSeconds() {
		return expireInSeconds;
	}
	public void setExpireInSeconds(String expireInSeconds) {
		this.expireInSeconds = expireInSeconds;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
