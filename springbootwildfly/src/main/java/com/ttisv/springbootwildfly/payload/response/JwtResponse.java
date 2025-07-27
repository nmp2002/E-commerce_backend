package com.ttisv.springbootwildfly.payload.response;

import java.util.List;

import com.ttisv.springbootwildfly.payload.request.MenuNavRequest;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private Long roleId;
	private Long groupRoleId;
	private String deptName;
	private Long deptId;
	private String username;
	private String email;
	private String telephone;
	private String address;
	private String fullname;
	private String officecode;
	private String officename;
	private String parentofficecode;
	private String parentofficename;
	private String avatar;
	private boolean isPermissApprove;
	private List<String> roles;
	private List<MenuNavRequest> lstMenuTree;
	private List<MenuNavRequest> lstMenu;
	private String mapRuleData;
	private String mapRuleAction;

	public JwtResponse(String accessToken, Long id, String username, Long roleId, Long groupRoleId, Long deptId,
			String deptName, String email, List<String> roles, List<MenuNavRequest> lstMenuTree,
			List<MenuNavRequest> lstMenu, String officecode, String officename, String parentofficecode,
			String parentofficename, boolean isPermissApprove, String avatar, String telephone, String address,
			String fullname, String mapRuleData, String mapRuleAction) {
		this.token = accessToken;
		this.id = id;
		this.groupRoleId = groupRoleId;
		this.roleId = roleId;
		this.deptName = deptName;
		this.deptId = deptId;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.lstMenu = lstMenu;
		this.lstMenuTree = lstMenuTree;
		this.officecode = officecode;
		this.officename = officename;
		this.parentofficecode = parentofficecode;
		this.parentofficename = parentofficename;
		this.isPermissApprove = isPermissApprove;
		this.avatar = avatar;
		this.telephone = telephone;
		this.address = address;
		this.fullname = fullname;
		this.mapRuleAction = mapRuleAction;
		this.mapRuleData = mapRuleData;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public List<MenuNavRequest> getLstMenu() {
		return lstMenu;
	}

	public void setLstMenu(List<MenuNavRequest> lstMenu) {
		this.lstMenu = lstMenu;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getGroupRoleId() {
		return groupRoleId;
	}

	public void setGroupRoleId(Long groupRoleId) {
		this.groupRoleId = groupRoleId;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setParentofficename(String parentofficename) {
		this.parentofficename = parentofficename;
	}

	public boolean isPermissApprove() {
		return isPermissApprove;
	}

	public void setPermissApprove(boolean isPermissApprove) {
		this.isPermissApprove = isPermissApprove;
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

	public List<MenuNavRequest> getLstMenuTree() {
		return lstMenuTree;
	}

	public void setLstMenuTree(List<MenuNavRequest> lstMenuTree) {
		this.lstMenuTree = lstMenuTree;
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

}
