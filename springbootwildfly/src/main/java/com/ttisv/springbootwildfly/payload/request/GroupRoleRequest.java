package com.ttisv.springbootwildfly.payload.request;

import java.io.Serializable;

public class GroupRoleRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	Long id;
	String groupRoleCode;
	String groupRoleName;
	String status;
	String description;
	String groupPermission;
	int page;
	int size;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupRoleCode() {
		return groupRoleCode;
	}

	public void setGroupRoleCode(String groupRoleCode) {
		this.groupRoleCode = groupRoleCode;
	}

	public String getGroupRoleName() {
		return groupRoleName;
	}

	public void setGroupRoleName(String groupRoleName) {
		this.groupRoleName = groupRoleName;
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

	public String getGroupPermission() {
		return groupPermission;
	}

	public void setGroupPermission(String groupPermission) {
		this.groupPermission = groupPermission;
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
