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
@Table(name = "TBL_ORDER")
public class TblOrder implements Serializable {
    @Id
    @SequenceGenerator(name = "SEQ_order", sequenceName = "SEQ_order", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_order")
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "TOTAL_AMOUNT")
    private Double totalAmount;

    @Column(name = "STATUS")
    private Long status; 
    // 0: Đang xử lý, 1: Đã xác nhận, 2: Đang giao, 3: Hoàn tất, 4: Hủy

    @Column(name = "SHIPPING_ADDRESS")
    private String shippingAddress;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ORDER_DATE")
    private Date orderDate;

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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

	public TblOrder(Long id, Long userId, Double totalAmount, Long status, String shippingAddress, String phone,
			String email, Date orderDate, String createby, String modifiedby, Date createdDate, Date modifiedDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.shippingAddress = shippingAddress;
		this.phone = phone;
		this.email = email;
		this.orderDate = orderDate;
		this.createby = createby;
		this.modifiedby = modifiedby;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	public TblOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}