package com.ttisv.springbootwildfly.payload.request;

import java.io.Serializable;

public class RoleObjectRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	Long roleGroupId;
	Long roleId;
	String arrMenu;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getRoleGroupId() {
		return roleGroupId;
	}

	public void setRoleGroupId(Long roleGroupId) {
		this.roleGroupId = roleGroupId;
	}

	public String getArrMenu() {
		return arrMenu;
	}

	public void setArrMenu(String arrMenu) {
		this.arrMenu = arrMenu;
	}
}
