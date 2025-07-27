package com.ttisv.springbootwildfly.payload.request;

public class TblParamRequest {
	Long id;
	String paramcode;
	String paramname;
	String type;
	String paramgroup;
	String status;
	String value;
	String note;
	int sort;
	int size;
	int page;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParamcode() {
		return paramcode;
	}

	public void setParamcode(String paramcode) {
		this.paramcode = paramcode;
	}

	public String getParamname() {
		return paramname;
	}

	public void setParamname(String paramname) {
		this.paramname = paramname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getParamgroup() {
		return paramgroup;
	}

	public void setParamgroup(String paramgroup) {
		this.paramgroup = paramgroup;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
