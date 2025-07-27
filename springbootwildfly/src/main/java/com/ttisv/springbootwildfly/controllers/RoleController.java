package com.ttisv.springbootwildfly.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttisv.bean.system.TblGroupRole;
import com.ttisv.bean.system.TblRole;
import com.ttisv.service.FieldService;
import com.ttisv.service.system.TblGroupRoleService;
import com.ttisv.service.system.TblRoleService;
import com.ttisv.springbootwildfly.common.Constants;
import com.ttisv.springbootwildfly.payload.request.RoleRequest;
import com.ttisv.springbootwildfly.payload.response.MessageResponse;
import com.ttisv.springbootwildfly.security.services.UserDetailsImpl;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/role")
public class RoleController  extends BaseController{
	@Autowired
    private  FieldService fieldService;

	@Autowired
	TblRoleService tblRoleService;
	
	@CrossOrigin
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<TblRole>> findAllRole() {
		Map<String, String> map = new HashMap<>();
		List<TblRole> list = tblRoleService.getListRole(map);
		if (list == null) {
			return new ResponseEntity<List<TblRole>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TblRole>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/paging", method = RequestMethod.GET)
	public ResponseEntity<Page<TblRole>> findAllRole(@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		int currentPage = page.orElse(1);
		int pageSize = 10;
		Map<String, String> map = new HashMap<>();
		Page<TblRole> list = tblRoleService.getListPageRole(PageRequest.of(currentPage - 1, pageSize), map);
		if (list == null) {
			return new ResponseEntity<Page<TblRole>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Page<TblRole>>(list, HttpStatus.OK);
	}

	@SuppressWarnings("deprecation")
	@CrossOrigin
	@RequestMapping(value = "/list", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Page<TblRole>> findRole(@RequestBody String req, HttpServletRequest request,
			HttpServletResponse resp) {

		RoleRequest searchForm = gson.fromJson(req, RoleRequest.class);
		int currentPage = searchForm.getPage();
		int pageSize = 10;
		Map<String, String> map = convertSearchToMap(searchForm);
		Page<TblRole> list = tblRoleService.getListPageRole(PageRequest.of(currentPage - 1, pageSize), map);
		if (list == null) {
			return new ResponseEntity<Page<TblRole>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Page<TblRole>>(list, HttpStatus.OK);
	}

	private Map<String, String> convertSearchToMap(RoleRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		if (request.getGroupRoleId() != null && request.getGroupRoleId() > 0) {
			map.put("groupRoleId", request.getGroupRoleId().toString());
		}
		if (request.getRoleCode() != null && !request.getRoleCode().isEmpty()) {
			map.put("roleCode", request.getRoleCode());
		}
		if (request.getRoleName() != null && !request.getRoleName().isEmpty()) {
			map.put("roleName", request.getRoleName());
		}
		if (request.getStatus() != null && !request.getStatus().isEmpty()
				&& !Objects.equals(request.getStatus(), Constants.STATUS.DEFAULT.toString())) {
			map.put("status", request.getStatus());
		}
		return map;
	}

	@PutMapping("/createRole")
	public ResponseEntity<?> createRole(@Valid @RequestBody RoleRequest roleRequest) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userToken = getUserInfo();
		if (tblRoleService.existsByRoleCode(roleRequest.getRoleCode(), null)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Mã vai trò đã tồn tại!"));
		}
		TblRole role = new TblRole(roleRequest.getRoleCode(), roleRequest.getRoleName(), roleRequest.getGroupRoleId(),
				roleRequest.getStatus(), roleRequest.getDescription());
		role.setCreatedby(userToken.getUsername());
		role.setCreatedDate(new Date());
		tblRoleService.saveorUpdate(role);
		return ResponseEntity.ok(new MessageResponse("Thêm mới vai trò thành công!"));
	}

	@PutMapping("/updateRole")
	public ResponseEntity<?> updateRole(@Valid @RequestBody RoleRequest roleRequest) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetailsImpl userToken = getUserInfo();
			if (roleRequest.getId() == null) {
				return ResponseEntity.badRequest()
						.body(new MessageResponse("Lỗi: Không tìm thấy vai trò để cập nhật!"));
			}
			TblRole role = tblRoleService.findById(roleRequest.getId());
			if (role == null) {
				return ResponseEntity.badRequest()
						.body(new MessageResponse("Lỗi: Không tìm thấy vai trò để cập nhật!"));
			}
			if (tblRoleService.existsByRoleCode(roleRequest.getRoleCode(), roleRequest.getId())) {
				return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Mã vai trò đã tồn tại!"));
			}
			role.setModifiedby(userToken.getUsername());
			role.setModifiedDate(new Date());
			role.setGroupRoleId(roleRequest.getGroupRoleId());
			role.setRoleCode(roleRequest.getRoleCode());
			role.setRoleName(roleRequest.getRoleName());
			role.setDescription(roleRequest.getDescription());
			role.setStatus(roleRequest.getStatus());
			tblRoleService.saveorUpdate(role);
			return ResponseEntity.ok(new MessageResponse("Cập nhật vai trò thành công!"));
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình xử lý!"));
		}
	}

	@GetMapping("/delete")
	public ResponseEntity<?> deleteRole(@Valid @RequestParam Long roleId) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetailsImpl userToken = getUserInfo();
			TblRole role = tblRoleService.findById(roleId);
			if (role == null) {
				return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Không tìm thấy vai trò để xóa!"));
			}
			role.setModifiedby(userToken.getUsername());
			role.setModifiedDate(new Date());
			role.setStatus(Constants.STATUS.DELETE);
			tblRoleService.saveorUpdate(role);
			return ResponseEntity.ok(new MessageResponse("Xóa vai trò thành công!"));
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình xử lý!"));
		}
	}

	@GetMapping("/lock")
	public ResponseEntity<?> lockRole(@Valid @RequestParam Long roleId) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetailsImpl userToken = getUserInfo();
			TblRole role = tblRoleService.findById(roleId);
			if (role == null) {
				return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Không tìm thấy vai trò để khóa!"));
			}
			role.setModifiedby(userToken.getUsername());
			role.setModifiedDate(new Date());
			role.setStatus(Constants.STATUS.INACTIVE);
			tblRoleService.saveorUpdate(role);
			return ResponseEntity.ok(new MessageResponse("Khóa vai trò thành công!"));
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình xử lý!"));
		}
	}

	@GetMapping("/findById")
	public ResponseEntity<TblRole> findById(@Valid @RequestParam Long roleId) {
		try {
			TblRole role = tblRoleService.findById(roleId);
			if (role == null) {
				return new ResponseEntity<TblRole>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<TblRole>(role, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<TblRole>(HttpStatus.NOT_FOUND);
		}
	}
	


}
