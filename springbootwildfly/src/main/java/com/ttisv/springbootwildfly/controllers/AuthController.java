package com.ttisv.springbootwildfly.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ttisv.bean.system.TblMenu;
import com.ttisv.common.utils.StringUtils;
import com.ttisv.service.RoleService;
import com.ttisv.service.UserSerivce;
import com.ttisv.service.system.TblRoleObjectService;
import com.ttisv.springbootwildfly.common.Constants;
import com.ttisv.springbootwildfly.payload.request.LoginRequest;
import com.ttisv.springbootwildfly.payload.request.MenuNavRequest;
import com.ttisv.springbootwildfly.payload.request.MenuNavRequest.Badge;
import com.ttisv.springbootwildfly.payload.request.MenuNavRequest.IconComponent;
import com.ttisv.springbootwildfly.payload.response.JwtResponse;
import com.ttisv.springbootwildfly.payload.response.MessageResponse;
import com.ttisv.springbootwildfly.security.CustomAuthProvider;
import com.ttisv.springbootwildfly.security.CustomUserDetails;
import com.ttisv.springbootwildfly.security.jwt.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	CustomAuthProvider authenticationManagerCustom;
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	@Autowired
	UserSerivce userSerivce;

	@Autowired
	RoleService roleService;


	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	TblRoleObjectService tblRoleObjectService;

	@Value("${config.officecode}")
	private String officecode;

	@PostMapping("/hello")
	public String hello() {
		return "hello";
	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		try {
			Authentication authentication = authenticationManagerCustom.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);
			System.out.println(jwt);
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
	
			List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
					.collect(Collectors.toList());
			Map<String, String> map = new HashMap<>();
			map.put("groupRoleId", userDetails.getRoleGroupId().toString());
			List<TblMenu> lst = tblRoleObjectService.getListMenuByRoleObject(map);
			List<MenuNavRequest> lstMenuTree = new ArrayList<>();
			List<MenuNavRequest> lstMenu = new ArrayList<>();
				for (TblMenu menu : lst) { //day la loi so 1 => em khong co menu nao trong list ca, nen khong cos phan quyen nao duoc gan vao session, anh dang xem ly do sao 2 nut kia hien
				if (menu.getParentId() != null && !Objects.equals(menu.getTitle(), Constants.STATUS.ACTIVE)) {
				} else {
					MenuNavRequest menuNavRequest = convertMenuToNav(menu);
					createChildMenuNav(menuNavRequest, menu, lst, lstMenu);
					lstMenuTree.add(menuNavRequest);
				}
			}
//			createParentMenu2(lst, lstMenuTree, lstMenu);
			return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
					userDetails.getRoleId(), userDetails.getRoleGroupId(), userDetails.getDeptId(),
					userDetails.getDeptName(), userDetails.getEmail(), roles, lstMenuTree, lstMenu,
					userDetails.getOfficecode(), userDetails.getOfficename(), userDetails.getParentofficecode(),
					userDetails.getParentofficename(), Objects.equals(officecode, userDetails.getOfficecode()),
					userDetails.getAvatar(), userDetails.getTelephone(), userDetails.getAddress(),
					userDetails.getFullname(), userDetails.getMapRuleData(), userDetails.getMapRuleAction()));
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(new MessageResponse(ex.getMessage()));
		}
	}

	private void createParentMenu(List<TblMenu> lstmenu, List<MenuNavRequest> lstMenuTree, List<MenuNavRequest> lst) {
		int i = 0;
		while (lstmenu.size() > 0 && i < lstmenu.size()) {

			if (lstmenu.get(i).getParentId() != null && !lstmenu.get(i).getParentId().equals(0l)
					&& !Objects.equals(lstmenu.get(i).getTitle(), Constants.STATUS.ACTIVE)) {
				i++;
			} else {

				MenuNavRequest menuNavRequestChild = convertMenuToNav(lstmenu.get(i));

				Collections.sort(lstMenuTree, Comparator.comparing(MenuNavRequest::getStt));
				lstMenuTree.add(menuNavRequestChild);

				lstmenu.remove(i);
				List<MenuNavRequest> lstChildNav = new ArrayList<>();
				taomenu(lstmenu, lstChildNav, lst);
				// i--;
			}
			/*
			 * if (lstmenu.get(i).getParentId() == null ||
			 * lstmenu.get(i).getParentId().equals(0l)) { MenuNavRequest menuNavRequestChild
			 * = convertMenuToNav(lstmenu.get(i)); Collections.sort(lstMenuTree,
			 * Comparator.comparing(MenuNavRequest::getStt));
			 * lstMenuTree.add(menuNavRequestChild); lstmenu.remove(i); // i--; } else {
			 * i++; }
			 */

		}

	}

	private void createParentMenu2(List<TblMenu> lstmenu, List<MenuNavRequest> lstMenuTree, List<MenuNavRequest> lst) {
		int i = 0;
		while (lstmenu.size() > 0 && i < lstmenu.size()) {

			if (lstmenu.get(i).getParentId() == null) {
				MenuNavRequest menuNavRequestChild = convertMenuToNav(lstmenu.get(i));

				// Collections.sort(lstMenuTree, Comparator.comparing(MenuNavRequest::getStt));
				lstMenuTree.add(menuNavRequestChild);

				lstmenu.remove(i);
				List<MenuNavRequest> lstChildNav = new ArrayList<>();
				lstChildNav = taomenu2(lstmenu, menuNavRequestChild, lst);
				if (lstChildNav != null && lstChildNav.size() > 0)
					lstMenuTree.addAll(lstChildNav);
				// i--;
			} else {
				i++;
			}

		}

	}

	public List<MenuNavRequest> taomenu2(List<TblMenu> lstmenu, MenuNavRequest currentNav,
			List<MenuNavRequest> lstMenuNav) {

		List<MenuNavRequest> lst = createlstMenuTree(lstmenu, currentNav, lstMenuNav);
		if (lst != null && lst.size() > 0) {

			taomenu(lstmenu, lst, lstMenuNav);
		}
		return lst;
	}

	public List<MenuNavRequest> createlstMenuTree2(List<TblMenu> lstmenu, MenuNavRequest menuNav,
			List<MenuNavRequest> lstMenuNav) {
		List<MenuNavRequest> lstMenuTree = new ArrayList<>();
		int i = 0;
		while (lstmenu.size() > 0 && i < lstmenu.size()) {
			if (lstmenu.get(i).getParentId().intValue() == menuNav.getMenuId().intValue()) {

				// if (lstmenu.get(i).getParentId().intValue() ==
				// menuNav.getMenuId().intValue()&&!Objects.equals(lstmenu.get(i).getTitle(),
				// Constants.STATUS.ACTIVE)) {
				MenuNavRequest menuNavRequestChild = convertMenuToNav(lstmenu.get(i));
				if (!StringUtils.isNullOrEmpty(menuNavRequestChild.getUrl())) {
					lstMenuNav.add(menuNavRequestChild);
				}
				if (!Objects.equals(lstmenu.get(i).getTitle(), Constants.STATUS.ACTIVE)) {

					lstMenuTree.add(menuNavRequestChild);
					Collections.sort(lstMenuTree, Comparator.comparing(MenuNavRequest::getStt));

					lstmenu.remove(i);
				}
				// i--;
			} else {
				i++;
			}
		}
		return lstMenuTree;
	}

	public List<MenuNavRequest> taomenu(List<TblMenu> lstmenu, List<MenuNavRequest> lstMenuTree,
			List<MenuNavRequest> lstMenuNav) {
		for (int i = 0; i < lstMenuTree.size(); i++) {
			List<MenuNavRequest> lst = createlstMenuTree(lstmenu, lstMenuTree.get(i), lstMenuNav);
			if (lst != null && lst.size() > 0) {
				lstMenuTree.get(i).setChildren(lst);
				taomenu(lstmenu, lst, lstMenuNav);
			}
		}
		return lstMenuTree;
	}

	public List<MenuNavRequest> taomenu3(List<TblMenu> lstmenu, List<MenuNavRequest> lstMenuTree,
			List<MenuNavRequest> lstMenuNav) {
		for (int i = 0; i < lstMenuTree.size(); i++) {
			List<MenuNavRequest> lst = createlstMenuTree(lstmenu, lstMenuTree.get(i), lstMenuNav);
			if (lst != null && lst.size() > 0) {
				lstMenuTree.get(i).setChildren(lst);
				// taomenu3(lstmenu, lst, lstMenuNav);
			}
		}
		return lstMenuTree;
	}

	public List<MenuNavRequest> createlstMenuTree(List<TblMenu> lstmenu, MenuNavRequest menuNav,
			List<MenuNavRequest> lstMenuNav) {
		List<MenuNavRequest> lstMenuTree = new ArrayList<>();
		int i = 0;
		while (lstmenu.size() > 0 && i < lstmenu.size()) {
			if (lstmenu.get(i).getParentId() != null
					&& lstmenu.get(i).getParentId().intValue() == menuNav.getMenuId().intValue()) {

				// if (lstmenu.get(i).getParentId().intValue() ==
				// menuNav.getMenuId().intValue()&&!Objects.equals(lstmenu.get(i).getTitle(),
				// Constants.STATUS.ACTIVE)) {
				MenuNavRequest menuNavRequestChild = convertMenuToNav(lstmenu.get(i));
				if (!StringUtils.isNullOrEmpty(menuNavRequestChild.getUrl())) {
					lstMenuNav.add(menuNavRequestChild);
				}
				// if (!Objects.equals(lstmenu.get(i).getTitle(), Constants.STATUS.ACTIVE)) {

				lstMenuTree.add(menuNavRequestChild);
				Collections.sort(lstMenuTree, Comparator.comparing(MenuNavRequest::getStt));

				// }
				lstmenu.remove(i);
				// i--;
			} else {
				i++;
			}
		}
		return lstMenuTree;
	}

	public void createChildMenuNav(MenuNavRequest menuNav, TblMenu currentMenu, List<TblMenu> list,
			List<MenuNavRequest> lstMenu) {
		List<MenuNavRequest> lstChildNav = new ArrayList<>();
		System.out.println("000000000");
		int i = 0;

		for (TblMenu menu : list) {
			if (Objects.equals(menu.getParentId(), currentMenu.getMenuId())) {
				MenuNavRequest menuNavRequestChild = convertMenuToNav(menu);

				if (!StringUtils.isNullOrEmpty(menuNavRequestChild.getUrl())) {
					lstMenu.add(menuNavRequestChild);
				}

				if (!Objects.equals(menu.getTitle(), Constants.STATUS.ACTIVE)) {
					lstChildNav.add(menuNavRequestChild);
					createChildMenuNav(menuNavRequestChild, menu, list, lstMenu);
					menuNav.setChildren(lstChildNav);
				}
			}
		}
	}

	public MenuNavRequest convertMenuToNav(TblMenu menu) {
		MenuNavRequest menuNav = new MenuNavRequest();
		menuNav.setMenuId(menu.getMenuId() != null ? menu.getMenuId() : null);
		menuNav.setMenuBtn(menu.getMenuBtn() != null && !menu.getMenuBtn().isEmpty() ? menu.getMenuBtn() : null);
		menuNav.setName(menu.getMenuName() != null && !menu.getMenuName().isEmpty() ? menu.getMenuName() : "");
		menuNav.setUrl(menu.getUrl() != null && !menu.getUrl().isEmpty() ? menu.getUrl() : "  ");

		menuNav.setStt(menu.getOrderNumber() != null ? menu.getOrderNumber().intValue() : 0);
		if (menu.getIcon() != null && !menu.getIcon().isEmpty()) {
			IconComponent iconComponent = menuNav.new IconComponent();
			iconComponent.setName(menu.getIcon() != null && !menu.getIcon().isEmpty() ? menu.getIcon() : "");
			menuNav.setIconComponent(iconComponent);
		}
		if ((menu.getColor() != null && !menu.getColor().isEmpty())
				|| (menu.getText() != null && !menu.getText().isEmpty())) {
			Badge badge = menuNav.new Badge();
			badge.setColor(menu.getColor() != null && !menu.getColor().isEmpty() ? menu.getColor() : "");
			badge.setText(menu.getText() != null && !menu.getText().isEmpty() ? menu.getText() : "");
			menuNav.setBadge(badge);
		}
		menuNav.setTitle(menu.getParentId() == null && menu.getTitle() != null && !menu.getTitle().isEmpty()
				? Objects.equals(menu.getTitle(), Constants.STATUS.ACTIVE)
				: false);
		menuNav.setParentId(menu.getParentId());
		return menuNav;
	}


}
