package com.ttisv.common.dto;

import java.math.BigDecimal;

public class TtiClaimQuotePolicyDTO {
	private BigDecimal rateLoss;
	private Integer    claimLoss;
	private BigDecimal amttv;
	private Integer ndaysSinterruption;
	public BigDecimal getRateLoss() {
		return rateLoss;
	}
	public void setRateLoss(BigDecimal rateLoss) {
		this.rateLoss = rateLoss;
	}
	public Integer getClaimLoss() {
		return claimLoss;
	}
	public void setClaimLoss(Integer claimLoss) {
		this.claimLoss = claimLoss;
	}
	public BigDecimal getAmttv() {
		return amttv;
	}
	public void setAmttv(BigDecimal amttv) {
		this.amttv = amttv;
	}
	public Integer getNdaysSinterruption() {
		return ndaysSinterruption;
	}
	public void setNdaysSinterruption(Integer ndaysSinterruption) {
		this.ndaysSinterruption = ndaysSinterruption;
	}
	
	
}
