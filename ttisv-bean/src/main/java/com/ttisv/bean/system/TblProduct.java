package com.ttisv.bean.system;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TBL_PRODUCT")
public class TblProduct implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_product", sequenceName = "SEQ_product", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_product")
	private Long id;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "CATEGORY_ID")
	private Long categoryId; // FK to TBL_PRODUCT_CATEGORY

	@Column(name = "GROUP_CODE")
	private String groupCode;
	@Column (name ="PRICE")
	private Long price;
	@Column(name = "BRAND")
	private String brand;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "IMAGE")
	private String image;

	@Column(name = "STATUS")
	private Long status; // 1: active, 0: inactive

	@Column(name = "STOCK_QUANTITY")
	private Integer stockQuantity;

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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getCategoryId() {
		return categoryId;
	}
	
	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}
	

	public Integer getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
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

	public TblProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TblProduct(Long id, String productName, Long categoryId, String groupCode, Long price, String brand,
			String description, String image, Long status, Integer stockQuantity, String createby, String modifiedby,
			Date createdDate, Date modifiedDate) {
		super();
		this.id = id;
		this.productName = productName;
		this.categoryId = categoryId;
		this.groupCode = groupCode;
		this.price = price;
		this.brand = brand;
		this.description = description;
		this.image = image;
		this.status = status;
		this.stockQuantity = stockQuantity;
		this.createby = createby;
		this.modifiedby = modifiedby;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}



	
	
}
