package com.ttisv.common.dto;

import java.math.BigDecimal;

public class PhigocDTO {
	String itemcode;
	BigDecimal itemmFee;
	public String getItemcode() {
		return itemcode;
	}
	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}
	public BigDecimal getItemmFee() {
		return itemmFee;
	}
	public void setItemmFee(BigDecimal itemmFee) {
		this.itemmFee = itemmFee;
	}
	
}
