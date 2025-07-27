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
@Table(name = "TBL_PRODUCT_ATTRIBUTE")
public class TblProductAttribute implements Serializable {
	@Id
	@SequenceGenerator(name = "SEQ_product_attribute", sequenceName = "SEQ_product_attribute", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_product_attribute")
	private Long id;

	@Column(name = "PRODUCT_ID")
	private Long productId;

	@Column(name = "ATTRIBUTE_NAME")
	private String attributeName; // Ví dụ: "RAM", "CPU", "Màu sắc"

	@Column(name = "ATTRIBUTE_VALUE")
	private String attributeValue; // Ví dụ: "8GB", "Intel i5", "Đen"

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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
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

	public TblProductAttribute(Long id, Long productId, String attributeName, String attributeValue, String createby,
			String modifiedby, Date createdDate, Date modifiedDate) {
		super();
		this.id = id;
		this.productId = productId;
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
		this.createby = createby;
		this.modifiedby = modifiedby;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	public TblProductAttribute() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}