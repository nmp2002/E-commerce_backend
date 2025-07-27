package com.ttisv.bean.system;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * The persistent class for the TBL_USER database table.
 * 
 */
@Entity
@Table(name = "TBL_USER")
@NamedQuery(name = "TblUser.findAll", query = "SELECT t FROM TblUser t")
public class TblUser implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SEQ_TBL_USER", sequenceName = "SEQ_TBL_USER", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TBL_USER")
	private Long id;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "CREATEDBY")
	private String createdby;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "DEPARTMENTCODE")
	private String departmentcode;

	@Column(name = "DEPARTMENTNAME")
	private String departmentname;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "EMAIL")
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name = "EXPIRED_PASSWORD")
	private Date expiredPassword;

	@Column(name = "FULLNAME")
	private String fullname;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "IS_RESET_PASS")
	private String isResetPass;

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;

	@Column(name = "MODIFIEDBY")
	private String modifiedby;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "ROLE_ID")
	private Long roleId;

	@Column(name = "POSITIONCODE")
	private String positioncode;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "TELEPHONE")
	private String telephone;

	@Column(name = "COUNT_LOGIN")
	private Long countLogin;

	@Column(name = "OFFICECODE")
	private String officecode;

	@Column(name = "OFFICENAME")
	private String officename;

	@Column(name = "OFFICETYPE")
	private String officetype;

	@Column(name = "AVATAR")
	private String avatar;

	@Transient
	private Long departmentId;
	
	@Transient
	private Long SupplierId;

	@Transient
	private Long roleGroupId;

	@Transient
	private String roleName;

	@Transient
	private String roleGroupName;

	@Transient
	private String parentofficecode;

	@Transient
	private String parentofficename;

	@Transient
	private List<TblUserPermission> lstPermission;

	@Transient
	private String mapRuleData;

	@Transient
	private String mapRuleAction;

	public TblUser() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDepartmentcode() {
		return this.departmentcode;
	}

	public void setDepartmentcode(String departmentcode) {
		this.departmentcode = departmentcode;
	}

	public String getDepartmentname() {
		return this.departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getExpiredPassword() {
		return this.expiredPassword;
	}

	public void setExpiredPassword(Date expiredPassword) {
		this.expiredPassword = expiredPassword;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIsResetPass() {
		return this.isResetPass;
	}

	public void setIsResetPass(String isResetPass) {
		this.isResetPass = isResetPass;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPositioncode() {
		return this.positioncode;
	}

	public void setPositioncode(String positioncode) {
		this.positioncode = positioncode;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getCountLogin() {
		return countLogin;
	}

	public void setCountLogin(Long countLogin) {
		this.countLogin = countLogin;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getRoleGroupId() {
		return roleGroupId;
	}

	public void setRoleGroupId(Long roleGroupId) {
		this.roleGroupId = roleGroupId;
	}

	public String getRoleName() {
		return roleName;
	}
	
	
	public Long getSupplierId() {
		return SupplierId;
	}

	public void setSupplierId(Long supplierId) {
		SupplierId = supplierId;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleGroupName() {
		return roleGroupName;
	}

	public void setRoleGroupName(String roleGroupName) {
		this.roleGroupName = roleGroupName;
	}

	public String getOfficecode() {
		return officecode;
	}

	public void setOfficecode(String officecode) {
		this.officecode = officecode;
	}

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

	public String getOfficetype() {
		return officetype;
	}

	public void setOfficetype(String officetype) {
		this.officetype = officetype;
	}

	public String getParentofficecode() {
		return parentofficecode;
	}

	public String getParentofficename() {
		return parentofficename;
	}

	public void setParentofficecode(String parentofficecode) {
		this.parentofficecode = parentofficecode;
	}

	public void setParentofficename(String parentofficename) {
		this.parentofficename = parentofficename;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public List<TblUserPermission> getLstPermission() {
		return lstPermission;
	}

	public void setLstPermission(List<TblUserPermission> lstPermission) {
		this.lstPermission = lstPermission;
	}

	public String getMapRuleData() {
		return mapRuleData;
	}

	public void setMapRuleData(String mapRuleData) {
		this.mapRuleData = mapRuleData;
	}

	public String getMapRuleAction() {
		return mapRuleAction;
	}

	public void setMapRuleAction(String mapRuleAction) {
		this.mapRuleAction = mapRuleAction;
	}

	public TblUser(String username, String email, String password, String fullname, String address, String telephone,
			String departmentcode, String departmentname, String status, Long roleId, String officecode,
			String officename) {
		this.userName = username;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.address = address;
		this.telephone = telephone;
		this.departmentcode = departmentcode;
		this.departmentname = departmentname;
		this.status = status;
		this.roleId = roleId;
		this.officecode = officecode;
		this.officename = officename;
	}
}