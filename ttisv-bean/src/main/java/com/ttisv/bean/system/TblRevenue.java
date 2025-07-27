package com.ttisv.bean.system;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "TBL_REVENUE")
public class TblRevenue  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQ_REVENUE", sequenceName = "SEQ_REVENUE", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REVENUE")
    @Column(name = "REVENUE_ID")
    private Long revenueId;
    
    @Column(name = "FIELD_ID")
    private Long fieldId;
    
    @Column(name = "PERIOD")
    private String period;
    
    @Column(name = "TOTALPAYMENTREVENUE")
    private Long totalPaymentRevenue;
    
    
    
	public Long getRevenueId() {
		return revenueId;
	}

	public void setRevenueId(Long revenueId) {
		this.revenueId = revenueId;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Long getTotalPaymentRevenue() {
		return totalPaymentRevenue;
	}

	public void setTotalPaymentRevenue(Long totalPaymentRevenue) {
		this.totalPaymentRevenue = totalPaymentRevenue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TblRevenue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TblRevenue(Long revenueId, String period, Long totalPaymentRevenue) {
		super();
		this.revenueId = revenueId;
		this.period = period;
		this.totalPaymentRevenue = totalPaymentRevenue;
	}
    
    
}
