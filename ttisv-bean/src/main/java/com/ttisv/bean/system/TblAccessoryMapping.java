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
@Table(name = "TBL_ACCESSORY_MAPPING")
public class TblAccessoryMapping implements Serializable {
	@Id
	@SequenceGenerator(name = "SEQ_map", sequenceName = "SEQ_map", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_map")
	private Long id;

	@Column(name = "MAIN_PRODUCT_ID")
	private Long mainProductId; // Ví dụ: Laptop hoặc Điện thoại

	@Column(name = "ACCESSORY_PRODUCT_ID")
	private Long accessoryProductId; // Là một sản phẩm thuộc danh mục phụ kiện

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

	public Long getMainProductId() {
		return mainProductId;
	}

	public void setMainProductId(Long mainProductId) {
		this.mainProductId = mainProductId;
	}

	public Long getAccessoryProductId() {
		return accessoryProductId;
	}

	public void setAccessoryProductId(Long accessoryProductId) {
		this.accessoryProductId = accessoryProductId;
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

	public TblAccessoryMapping(Long id, Long mainProductId, Long accessoryProductId, String createby, String modifiedby,
			Date createdDate, Date modifiedDate) {
		super();
		this.id = id;
		this.mainProductId = mainProductId;
		this.accessoryProductId = accessoryProductId;
		this.createby = createby;
		this.modifiedby = modifiedby;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	public TblAccessoryMapping() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}