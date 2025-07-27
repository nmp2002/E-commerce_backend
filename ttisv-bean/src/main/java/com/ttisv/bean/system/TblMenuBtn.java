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
@Table(name = "TBL_MENU_BTN")
public class TblMenuBtn implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SEQ_TBL_MENU_BTN", sequenceName = "SEQ_TBL_MENU_BTN", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TBL_MENU_BTN")
	@Column(name = "ID")
	private Long id;

	@Column(name = "MENU_ID")
	private Long menuId;

	@Column(name = "BTN_CODE")
	private String btnCode;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "BTN_NAME")
	private String btnName;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "ICON")
	private String icon;

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
	private String menuName;

	@Transient
	private boolean isSelected;

	public TblMenuBtn(Long menuId, String btnCode, String btnName, String status, String description, String icon) {
		super();
		this.menuId = menuId;
		this.btnCode = btnCode;
		this.status = status;
		this.btnName = btnName;
		this.description = description;
		this.icon = icon;
	}

	public TblMenuBtn() {
		super();
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

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getBtnCode() {
		return btnCode;
	}

	public void setBtnCode(String btnCode) {
		this.btnCode = btnCode;
	}

	public String getBtnName() {
		return btnName;
	}

	public void setBtnName(String btnName) {
		this.btnName = btnName;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
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