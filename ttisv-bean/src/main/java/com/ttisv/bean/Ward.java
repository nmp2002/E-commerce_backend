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
@Table(name = "WARD")
public class Ward implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SEQ_WARD", sequenceName = "SEQ_WARD", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_WARD")
	private Integer id;
	
	@Column(name ="WARDNAME")
	private String wardName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Ward() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ward(Integer id, String wardName) {
		super();
		this.id = id;
		this.wardName = wardName;
	}
	
	
}
