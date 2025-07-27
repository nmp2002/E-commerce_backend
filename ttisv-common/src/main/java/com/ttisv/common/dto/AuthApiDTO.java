package com.ttisv.common.dto;

public class AuthApiDTO {
	String userNameOrEmailAddress;
	String password;
	public String getUserNameOrEmailAddress() {
		return userNameOrEmailAddress;
	}
	public void setUserNameOrEmailAddress(String userNameOrEmailAddress) {
		this.userNameOrEmailAddress = userNameOrEmailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
