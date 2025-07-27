package com.ttisv.bean.system;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the TBL_USER_PERMISSION database table.
 * 
 */
@Entity
@Table(name = "TBL_USER_PERMISSION")
@NamedQuery(name = "TblUserPermission.findAll", query = "SELECT t FROM TblUserPermission t")
public class TblUserPermission implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SEQ_TBL_USER_PERMISSION", sequenceName = "SEQ_TBL_USER_PERMISSION", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TBL_USER_PERMISSION")
	private Long id;

	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "CREATEBY")
	private String createby;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "OFFICECODE")
	private String officecode;

	@Column(name = "OFFICENAME")
	private String officename;

	@Column(name = "OFFICETYPE")
	private String officetype;
	
	@Column(name = "ACTIVE")
	private String active;

	public TblUserPermission() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getOfficecode() {
		return officecode;
	}

	public void setOfficecode(String officecode) {
		this.officecode = officecode;
	}

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

	public String getOfficetype() {
		return officetype;
	}

	public void setOfficetype(String officetype) {
		this.officetype = officetype;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
}