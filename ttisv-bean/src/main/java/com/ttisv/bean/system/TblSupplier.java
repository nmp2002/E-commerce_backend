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
@Table(name ="TBL_SUPPLIER")
public class TblSupplier implements Serializable {
		private static final long serialVersionUID = 1L;
		@Id
		@SequenceGenerator(name = "SEQ_TBL_SUPPLIER", sequenceName = "SEQ_TBL_SUPPLIER", initialValue = 1, allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TBL_SUPPLIER")
		@Column(name ="SUPPLIERID")
		private Long supplierId;
		
		@Column(name = "FIELD_ID")
		private String fieldId;
		
	 	@Column(name = "CREATEDBY", length = 100)
	    private String createdBy;

	    @Column(name = "CREATED_DATE")
	    private Date createdDate;
	 
	    @Column(name = "MODIFIED_DATE")
	    private Date modifiedDate;

	    @Column(name = "MODIFIEDBY", length = 100)
	    private String modifiedBy;

	    @Column(name = "SUPPLIERNAME", length = 255)
	    private String supplierName;

	    @Column(name = "SUPPLIER_PHONE", length = 255)
	    private String supplierPhone;

	    @Column(name = "FIELDNAME", length = 255)
	    private String fieldName;

	    @Column(name = "SUPPLIER_ADDRESS", length = 255)
	    private String supplierAddress;
	    @Column(name = "SUPPLIERNAMELOGIN", length = 255)
	    private String supplierNameLogin;

	

		public Long getSupplierId() {
			return supplierId;
		}

		public void setSupplierId(Long supplierId) {
			this.supplierId = supplierId;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
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

		public String getModifiedBy() {
			return modifiedBy;
		}

		public void setModifiedBy(String modifiedBy) {
			this.modifiedBy = modifiedBy;
		}

		public String getSupplierName() {
			return supplierName;
		}

		public void setSupplierName(String supplierName) {
			this.supplierName = supplierName;
		}

		public String getSupplierPhone() {
			return supplierPhone;
		}

		public void setSupplierPhone(String supplierPhone) {
			this.supplierPhone = supplierPhone;
		}

		public String getFieldName() {
			return fieldName;
		}

		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}

		public String getSupplierAddress() {
			return supplierAddress;
		}

		public void setSupplierAddress(String supplierAddress) {
			this.supplierAddress = supplierAddress;
		}

		
		public String getFieldId() {
			return fieldId;
		}

		public void setFieldId(String fieldId) {
			this.fieldId = fieldId;
		}

		public String getSupplierNameLogin() {
			return supplierNameLogin;
		}

		public void setSupplierNameLogin(String supplierNameLogin) {
			this.supplierNameLogin = supplierNameLogin;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		public TblSupplier() {
			super();
			
		}

		public TblSupplier(Long supplierId, String fieldId, String createdBy, Date createdDate, Date modifiedDate,
				String modifiedBy, String supplierName, String supplierPhone, String fieldName, String supplierAddress,
				String supplierNameLogin) {
			super();
			this.supplierId = supplierId;
			this.fieldId = fieldId;
			this.createdBy = createdBy;
			this.createdDate = createdDate;
			this.modifiedDate = modifiedDate;
			this.modifiedBy = modifiedBy;
			this.supplierName = supplierName;
			this.supplierPhone = supplierPhone;
			this.fieldName = fieldName;
			this.supplierAddress = supplierAddress;
			this.supplierNameLogin = supplierNameLogin;
		}

	
	    
}
