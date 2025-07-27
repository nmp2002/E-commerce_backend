package com.ttisv.springbootwildfly.payload.request;

public class FieldTypeRequest {
    private Long fieldId;
    private String fieldTypeName;
    private Long totalNumberField;
	public Long getFieldId() {
		return fieldId;
	}
	public void setFieldId(Long fieldId) {
		this.fieldId = fieldId;
	}
	public String getFieldTypeName() {
		return fieldTypeName;
	}
	public void setFieldTypeName(String fieldTypeName) {
		this.fieldTypeName = fieldTypeName;
	}
	public Long getTotalNumberField() {
		return totalNumberField;
	}
	public void setTotalNumberField(Long totalNumberField) {
		this.totalNumberField = totalNumberField;
	}
    
}
