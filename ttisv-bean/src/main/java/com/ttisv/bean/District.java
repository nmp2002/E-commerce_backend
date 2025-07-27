package com.ttisv.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DISTRICT")
public class District implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SEQ_DISTRICT", sequenceName = "SEQ_DISTRICT", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DISTRICT")
	private Integer id;
	
	@Column(name ="DISTRICTNAME")
	private String districtName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public District() {
		super();
		// TODO Auto-generated constructor stub
	}

	public District(Integer id, String districtName) {
		super();
		this.id = id;
		this.districtName = districtName;
	}
	
	
}
