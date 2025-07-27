package com.ttisv.bean;
import java.util.Date; 
import java.io.Serializable;
import com.ttisv.bean.City;
import com.ttisv.bean.District;
import com.ttisv.bean.Ward;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "FIELD_DETAIL")
public class Field implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SEQ_FIELD", sequenceName = "SEQ_FIELD", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FIELD")
	private Integer id;
	
	@Column(name = "FIELDNAME")
	private String fieldName;
	
	@Column(name = "CITYNAME")
	private String cityName;
	
	@Column(name = "DISTRICTNAME")
	private String districtName;
	
	@Column(name = "WARDNAME")
	private String wardName;
	
	@Column(name = "PHONENUMBERFIELD")
	private String phoneNumberField;
	
	@Column(name = "DAY")
	private Date day;

	@Column(name = "TIME_START")
	private Date timeStart;

	@Column(name = "TIME_END")
	private Date timeEnd;

	
	@Column(name = "DISTRICT_ID")
	private Integer districtId;

	@Column(name = "CITY_ID")
	private Integer cityId;

	@Column(name = "WARD_ID")
	private Integer wardId;
	@ManyToOne
	@JoinColumn(name = "DISTRICT_ID", referencedColumnName = "id", insertable = false, updatable = false)
	private District district;

	@ManyToOne
	@JoinColumn(name = "CITY_ID", referencedColumnName = "id", insertable = false, updatable = false)
	private City city;

	@OneToOne
	@JoinColumn(name = "WARD_ID", referencedColumnName = "id", insertable = false, updatable = false)
	private Ward ward;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

	public String getPhoneNumberField() {
		return phoneNumberField;
	}

	public void setPhoneNumberField(String phoneNumberField) {
		this.phoneNumberField = phoneNumberField;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public Date getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	public Date getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Field() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Field(Integer id, String fieldName,
			String phoneNumberField, Date day, Date timeStart, Date timeEnd ,District district, City city, Ward ward) {
		super();
		this.id = id;
		this.fieldName = fieldName;
		this.district = district;
		this.city = city;
		this.ward = ward;
		this.phoneNumberField = phoneNumberField;
		this.day = day;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}
	
}
