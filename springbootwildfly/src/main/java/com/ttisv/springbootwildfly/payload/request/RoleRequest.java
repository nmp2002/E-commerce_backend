package com.ttisv.springbootwildfly.payload.request;

import java.io.Serializable;

public class RoleRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	Long id;
	Long groupRoleId;
	String roleCode;
	String roleName;
	String status;
	String description;
	int page;
	int size;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGroupRoleId() {
		return groupRoleId;
	}

	public void setGroupRoleId(Long groupRoleId) {
		this.groupRoleId = groupRoleId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
