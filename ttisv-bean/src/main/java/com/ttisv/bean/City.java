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
@Table(name = "CITY")
public class City implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SEQ_CITY", sequenceName = "SEQ_CITY", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CITY")
	private Integer id;
	
	@Column(name ="CITYNAME")
	private String cityName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(Integer id, String cityName) {
		super();
		this.id = id;
		this.cityName = cityName;
	}
	
	
}
