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

@Entity
@Table(name = "TBL_PRODUCT_CATEGORY")
public class TblProductCategory implements Serializable {
	@Id
	@SequenceGenerator(name = "SEQ_category", sequenceName = "SEQ_category", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_category")
	private Long id;

	@Column(name = "CATEGORY_NAME")
	private String categoryName; // Ví dụ: "Laptop", "Điện thoại", "Phụ kiện"

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "CREATEBY")
	private String createby;

	@Column(name = "MODIFIEDBY")
	private String modifiedby;

	
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public TblProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TblProductCategory(Long id, String categoryName, String description, String createby, String modifiedby,
			Date createdDate, Date modifiedDate) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.description = description;
		this.createby = createby;
		this.modifiedby = modifiedby;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
	
	
}