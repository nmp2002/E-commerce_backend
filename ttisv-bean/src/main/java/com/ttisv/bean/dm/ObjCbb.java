package com.ttisv.bean.dm;

public class ObjCbb {
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	private String key;
	private String value;
	private String isdefault;
	private String type;
	private String tableName;

	public ObjCbb(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public ObjCbb() {
		super();
	}
}
