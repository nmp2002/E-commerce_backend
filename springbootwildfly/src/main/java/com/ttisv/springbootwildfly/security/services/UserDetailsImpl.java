package com.ttisv.springbootwildfly.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ttisv.bean.Role;
import com.ttisv.bean.system.TblUser;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String email;

	@JsonIgnore
	private String officecode;

	@JsonIgnore
	private String officetype;

	@JsonIgnore
	private String officename;
	private String parentofficecode;
	private Long deptId;
	private Long roleId;
	private Long roleGroupId;
	@JsonIgnore
	private String password;

	private String mapRuleData;

	private String mapRuleAction;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id, String username, String email, String password, String officecode,
			String officename, String officetype, String mapRuleData, String mapRuleAction,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.officecode = officecode;
		this.officename = officename;
		this.officetype = officetype;
		this.authorities = authorities;
		this.mapRuleData = mapRuleData;
		this.mapRuleAction = mapRuleAction;
	}

	public static UserDetailsImpl build(TblUser user, List<Role> roles) {
		List<GrantedAuthority> authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(user.getId(), user.getUserName(), user.getEmail(), user.getPassword(),
				user.getOfficecode(), user.getOfficename(), user.getOfficetype(), user.getMapRuleData(),
				user.getMapRuleAction(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
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
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}

	public String getParentofficecode() {
		return parentofficecode;
	}

	public void setParentofficecode(String parentofficecode) {
		this.parentofficecode = parentofficecode;
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
	
	
}
