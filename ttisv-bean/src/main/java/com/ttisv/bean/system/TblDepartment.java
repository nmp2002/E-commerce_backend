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
 * The persistent class for the TBL_DEPARTMENT database table.
 * 
 */
@Entity
@Table(name = "TBL_DEPARTMENT")
public class TblDepartment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SEQ_TBL_DEPARTMENT", sequenceName = "SEQ_TBL_DEPARTMENT", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TBL_DEPARTMENT")
	@Column(name = "ID")
	private Long id;

	@Column(name = "P_ID")
	private Long pId;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "DEPARTMENT_CODE")
	private String departmentCode;

	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;

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

	public TblDepartment() {
	}

	public TblDepartment(Long pId, String departmentCode, String departmentName, String description, String status) {
		super();
		this.pId = pId;
		this.status = status;
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
		this.description = description;
	}

	public String getDepartmentCode() {
		return this.departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPId() {
		return this.pId;
	}

	public void setPId(Long pId) {
		this.pId = pId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
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