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
import javax.persistence.Transient;

/**
 * The persistent class for the TBL_ROLE database table.
 * 
 */
@Entity
@Table(name = "TBL_ROLE")
public class TblRole implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SEQ_TBL_ROLE", sequenceName = "SEQ_TBL_ROLE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TBL_ROLE")
	@Column(name = "ID")
	private Long id;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "GROUP_ROLE_ID")
	private Long groupRoleId;

	@Column(name = "ROLE_CODE")
	private String roleCode;

	@Column(name = "ROLE_NAME")
	private String roleName;

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

	@Transient
	private String groupRoleName;

	public TblRole() {
	}

	public TblRole(String roleCode, String roleName, Long groupRoleId, String status, String description) {
		super();
		this.status = status;
		this.groupRoleId = groupRoleId;
		this.roleCode = roleCode;
		this.roleName = roleName;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGroupRoleName() {
		return groupRoleName;
	}

	public void setGroupRoleName(String groupRoleName) {
		this.groupRoleName = groupRoleName;
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
}