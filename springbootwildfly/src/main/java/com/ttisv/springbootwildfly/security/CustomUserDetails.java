package com.ttisv.springbootwildfly.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ttisv.bean.system.TblUser;
import com.ttisv.springbootwildfly.common.Constants;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String username;
	private String password;
	private String status;
	private String email;
	private String officecode;
	private String officename;
	private String parentofficecode;
	private String parentofficename;
	private String deptName;
	private Long deptId;
	private Long roleId;
	private Long roleGroupId;
	private String avatar;
	private String telephone;
	private String address;
	private String fullname;
	private String mapRuleData;
	private String mapRuleAction;
	String officetype;
	private Collection<? extends GrantedAuthority> roles;

	public CustomUserDetails(Long id, String username, String password, Collection<? extends GrantedAuthority> roles,
			String status, String email, String deptName, Long deptId, Long roleId, Long roleGroupId, String officecode,
			String officename, String parentofficecode, String parentofficename, String avatar, String telephone,
			String address, String fullname, String mapRuleData, String mapRuleAction, String officetype) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.status = status;
		this.email = email;
		this.deptId = deptId;
		this.deptName = deptName;
		this.roleId = roleId;
		this.roleGroupId = roleGroupId;
		this.officecode = officecode;
		this.officename = officename;
		this.parentofficecode = parentofficecode;
		this.parentofficename = parentofficename;
		this.avatar = avatar;
		this.telephone = telephone;
		this.address = address;
		this.fullname = fullname;
		this.mapRuleAction = mapRuleAction;
		this.mapRuleData = mapRuleData;
		this.officetype=officetype;
	}

	public static CustomUserDetails build(TblUser user) {
		List<GrantedAuthority> roles = new ArrayList<>();
		return new CustomUserDetails(user.getId(), user.getUserName(), user.getPassword(), roles, user.getStatus(),
				user.getEmail(), user.getDepartmentname(), user.getDepartmentId(), user.getRoleId(),
				user.getRoleGroupId(), user.getOfficecode(), user.getOfficename(), user.getParentofficecode(),
				user.getParentofficename(), user.getAvatar(), user.getTelephone(), user.getAddress(),
				user.getFullname(), user.getMapRuleData(), user.getMapRuleAction(), user.getOfficetype());
	}

	
	public String getOfficetype() {
		return officetype;
	}

	public void setOfficetype(String officetype) {
		this.officetype = officetype;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<? extends GrantedAuthority> getRoles() {
		return roles;
	}

	public void setRoles(Collection<? extends GrantedAuthority> roles) {
		this.roles = roles;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getRoleGroupId() {
		return roleGroupId;
	}

	public void setRoleGroupId(Long roleGroupId) {
		this.roleGroupId = roleGroupId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return roles;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return !Objects.equals(this.status, Constants.STATUS.LOCK);
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		return !Objects.equals(this.status, Constants.STATUS.UNLOCK);
	}

	public boolean isNewAccount() {
		return Objects.equals(this.status, Constants.STATUS.ACTIVE);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
