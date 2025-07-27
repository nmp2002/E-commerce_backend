package com.ttisv.bean.system;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
 * The persistent class for the TBL_MENU database table.
 * 
 */
@Entity
@Table(name = "TBL_MENU")
public class TblMenu implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SEQ_TBL_MENU", sequenceName = "SEQ_TBL_MENU", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TBL_MENU")
	@Column(name = "MENU_ID")
	private Long menuId;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "PARENT_ID")
	private Long parentId;

	@Column(name = "MENU_CODE")
	private String menuCode;

	@Column(name = "MENU_NAME")
	private String menuName;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "ICON")
	private String icon;

	@Column(name = "URL")
	private String url;

	@Column(name = "COLOR")
	private String color;

	@Column(name = "TEXT")
	private String text;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "ORDER_NUMBER")
	private Long orderNumber;

	@Column(name = "IS_HAVE_BUTTON")
	private String isHaveButton;

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
	private List<TblMenu> children;

	@Transient
	private List<TblMenuBtn> lstBtn;

	@Transient
	private String menuBtn;

	public TblMenu() {
	}

	public TblMenu(String menuCode, String menuName, Long parentId, String status, String description, String icon,
			String url, Long orderNumber, String title, String isHaveButton) {
		super();
		this.status = status;
		this.parentId = parentId;
		this.menuCode = menuCode;
		this.menuName = menuName;
		this.description = description;
		this.icon = icon;
		this.url = url;
		this.orderNumber = orderNumber;
		this.isHaveButton = isHaveButton;
		this.title = (title != null && !title.isEmpty()) ? title : null;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<TblMenu> getChildren() {
		return children;
	}

	public void setChildren(List<TblMenu> children) {
		this.children = children;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public List<TblMenuBtn> getLstBtn() {
		return lstBtn;
	}

	public void setLstBtn(List<TblMenuBtn> lstBtn) {
		this.lstBtn = lstBtn;
	}

	public String getIsHaveButton() {
		return isHaveButton;
	}

	public void setIsHaveButton(String isHaveButton) {
		this.isHaveButton = isHaveButton;
	}

	public String getMenuBtn() {
		return menuBtn;
	}

	public void setMenuBtn(String menuBtn) {
		this.menuBtn = menuBtn;
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