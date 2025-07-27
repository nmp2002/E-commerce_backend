package com.ttisv.bean.system;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the TBL_GROUP_ROLE database table.
 * 
 */
@Entity
@Table(name = "TBL_GROUP_ROLE")
public class TblGroupRole implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SEQ_TBL_GROUP_ROLE", sequenceName = "SEQ_TBL_GROUP_ROLE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TBL_GROUP_ROLE")
	@Column(name = "ID")
	private Long id;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "GROUP_ROLE_CODE")
	private String groupRoleCode;

	@Column(name = "GROUP_ROLE_NAME")
	private String groupRoleName;

	@Column(name = "DESCRIPTION")
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;

	@Column(name = "MODIFIEDBY")
	private String modifiedby;

	@Column(name = "CREATEDBY")
	private String createdby;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "GROUP_PERMISSION")
	private String groupPermission;

	public TblGroupRole() {
	}

	public TblGroupRole(String groupRoleCode, String groupRoleName, String status, String description) {
		super();
		this.status = status;
		this.groupRoleCode = groupRoleCode;
		this.groupRoleName = groupRoleName;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getGroupPermission() {
		return groupPermission;
	}

	public void setGroupPermission(String groupPermission) {
		this.groupPermission = groupPermission;
	}

}