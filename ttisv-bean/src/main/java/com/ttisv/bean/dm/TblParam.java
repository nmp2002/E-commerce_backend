package com.ttisv.bean.dm;

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
 * The persistent class for the TBL_PARAMS database table.
 * 
 */
@Entity
@Table(name = "TBL_PARAMS")
@NamedQuery(name = "TblParam.findAll", query = "SELECT t FROM TblParam t")
public class TblParam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_TBL_PARAM", sequenceName = "SEQ_TBL_PARAM", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TBL_PARAM")
	private Long id;

	private String paramcode;

	private String paramgroup;

	private String paramname;

	@Column(name = "\"SORT\"")
	private int sort;

	private String status;

	@Column(name = "\"TYPE\"")
	private String type;

	@Column(name = "\"VALUE\"")
	private String value;

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

	public TblParam(String paramcode, String paramname, String paramgroup, String status, int sort, String type,
			String value, String note) {
		super();
		this.paramcode = paramcode;
		this.paramgroup = paramgroup;
		this.paramname = paramname;
		this.sort = sort;
		this.status = status;
		this.type = type;
		this.value = value;
		this.note = note;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	private String note;

	public TblParam() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParamcode() {
		return this.paramcode;
	}

	public void setParamcode(String paramcode) {
		this.paramcode = paramcode;
	}

	public String getParamgroup() {
		return this.paramgroup;
	}

	public void setParamgroup(String paramgroup) {
		this.paramgroup = paramgroup;
	}

	public String getParamname() {
		return this.paramname;
	}

	public void setParamname(String paramname) {
		this.paramname = paramname;
	}

	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
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