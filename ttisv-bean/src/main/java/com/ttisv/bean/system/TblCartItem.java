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
@Table(name = "TBL_CART_ITEM")
public class TblCartItem implements Serializable {
    @Id
    @SequenceGenerator(name = "SEQ_cart_item", sequenceName = "SEQ_cart_item", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_cart_item")
    private Long id;

    @Column(name = "CART_ID")
    private Long cartId;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "PRICE")
    private Double price;

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

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	public TblCartItem(Long id, Long cartId, Long productId, Integer quantity, Double price, String createby,
			String modifiedby, Date createdDate, Date modifiedDate) {
		super();
		this.id = id;
		this.cartId = cartId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.createby = createby;
		this.modifiedby = modifiedby;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	public TblCartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}