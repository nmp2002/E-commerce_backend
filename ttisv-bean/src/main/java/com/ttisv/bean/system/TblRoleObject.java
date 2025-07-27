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

@Entity
@Table(name = "TBL_ROLE_OBJECT")
public class TblRoleObject implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SEQ_TBL_ROLE_OBJECT", sequenceName = "SEQ_TBL_ROLE_OBJECT", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TBL_ROLE_OBJECT")
	@Column(name = "ROLE_OBJECT_ID")
	private Long roleObjectId;

	@Column(name = "ROLE_ID")
	private Long roleId;

	@Column(name = "GROUP_ROLE_ID")
	private Long groupRoleId;

	@Column(name = "OBJECT_ID")
	private Long objectId;

	@Column(name = "MENU_BTN")
	private String menuBtn;

	@Column(name = "CREATEDBY")
	private String createdby;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	public TblRoleObject() {
		super();
	}

	public TblRoleObject(Long objectId, Long groupRoleId, Long roleId) {
		super();
		this.roleId = roleId;
		this.groupRoleId = groupRoleId;
		this.objectId = objectId;
	}

	public Long getRoleObjectId() {
		return roleObjectId;
	}

	public void setRoleObjectId(Long roleObjectId) {
		this.roleObjectId = roleObjectId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getGroupRoleId() {
		return groupRoleId;
	}

	public void setGroupRoleId(Long groupRoleId) {
		this.groupRoleId = groupRoleId;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public String getMenuBtn() {
		return menuBtn;
	}

	public void setMenuBtn(String menuBtn) {
		this.menuBtn = menuBtn;
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