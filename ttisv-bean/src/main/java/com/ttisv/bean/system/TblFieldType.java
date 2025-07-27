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
@Table(name = "TBL_FIELD_TYPE")
public class TblFieldType  implements Serializable {
    @Id
    @SequenceGenerator(name = "SEQ_TBL_FIELD_TYPE", sequenceName = "SEQ_TBL_FIELD_TYPE", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TBL_FIELD_TYPE")
	@Column(name = "FIELDTYPEID")
	private Long fieldTypeId;
    
    @Column(name ="FIELDID")
    private Long fieldId;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    
    @Column(name = "CREATEDBY")
    private String createdBy;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;
    
    @Column(name = "MODIFIEDBY")
    private String modifiedBy;
    
    @Column(name = "TOTALNUMBERFIELD")
    private Long totalNumberField;
    
    @Column(name = "FIELDMONEY")
    private String fieldMoney;
    
    @Column(name = "FIELDTYPENAME")
    private String fieldTypeName;

	public Long getFieldTypeId() {
		return fieldTypeId;
	}

	public void setFieldTypeId(Long fieldTypeId) {
		this.fieldTypeId = fieldTypeId;
	}

	public Long getFieldId() {
		return fieldId;
	}

	public void setFieldId(Long fieldId) {
		this.fieldId = fieldId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	public Long getTotalNumberField() {
		return totalNumberField;
	}

	public void setTotalNumberField(Long totalNumberField) {
		this.totalNumberField = totalNumberField;
	}

	public String getFieldMoney() {
		return fieldMoney;
	}

	public void setFieldMoney(String fieldMoney) {
		this.fieldMoney = fieldMoney;
	}

	public String getFieldTypeName() {
		return fieldTypeName;
	}

	public void setFieldTypeName(String fieldTypeName) {
		this.fieldTypeName = fieldTypeName;
	}
	
	public TblFieldType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TblFieldType(Long fieldTypeId, Long fieldId, Date createdDate, String createdBy, Date modifiedDate,
			String modifiedBy,Long totalNumberField, String fieldMoney, String fieldTypeName) {
		super();
		this.fieldTypeId = fieldTypeId;
		this.fieldId = fieldId;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.totalNumberField = totalNumberField;
		this.fieldMoney = fieldMoney;
		this.fieldTypeName = fieldTypeName;
	}
    
    
}
