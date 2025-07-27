package com.ttisv.springbootwildfly.controllers;

import java.util.ArrayList;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.reflect.TypeToken;
import com.ttisv.bean.system.TblSupplier;
import com.ttisv.bean.system.TblUser;
import com.ttisv.bean.system.TblUserPermission;
import com.ttisv.common.utils.StringUtils;
import com.ttisv.common.utils.TtisvConstant;
import com.ttisv.service.system.TblSupplierService;
import com.ttisv.service.system.TblUserPermissionService;
import com.ttisv.service.system.TblUserService;
import com.ttisv.springbootwildfly.common.Constants;
import com.ttisv.springbootwildfly.payload.request.RegisterRequest;
import com.ttisv.springbootwildfly.payload.request.UserRequest;
import com.ttisv.springbootwildfly.payload.response.MessageResponse;
import com.ttisv.springbootwildfly.security.services.UserDetailsImpl;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/user")
public class UserController  extends BaseController{

	
	@Autowired
	TblUserService tblUserService;

	@Autowired
	PasswordEncoder encoder;
	   @Autowired
	    TblSupplierService tblSupplierService;

	@Autowired
	TblUserPermissionService tblUserPermissionService;

	@PutMapping("/registerUser")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest signUpRequest) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//	UserDetailsImpl userToken = getUserInfo(); // (1) comment khi chay API, bo cmt khi ghep voi frontend
			if (tblUserService.existsByUsername(signUpRequest.getUsername())) {
				return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Tên đăng nhập đã tồn tại !"));
			}
			if (tblUserService.existsByEmail(signUpRequest.getEmail(), null)) {
				return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Thư điện tử đã được sử dụng !"));
			}
			TblUser user = new TblUser(signUpRequest.getUsername(), signUpRequest.getEmail(),
					encoder.encode(signUpRequest.getPassword()), signUpRequest.getFullname(),
					signUpRequest.getAddress(), signUpRequest.getTelephone(), signUpRequest.getDepartmentcode(),
					signUpRequest.getDepartmentname(), Constants.STATUS.ACTIVE, signUpRequest.getRoleId(),
					signUpRequest.getOfficecode(), signUpRequest.getOfficename());
			List<TblUserPermission> lstPermission = gson.fromJson(signUpRequest.getLstPermission(),
					new TypeToken<List<TblUserPermission>>() {
					}.getType());
			user.setOfficetype(signUpRequest.getOfficetype());
		//	user.setCreatedby(userToken.getUsername());// (2) comment khi chay API, bo cmt khi ghep voi frontend
			TblUser userSaved = tblUserService.createUser(user, lstPermission);
			if (userSaved != null) {
				TblSupplier supplier = tblSupplierService.saveorUpdate(userSaved.getId(), userSaved.getFullname(), userSaved.getUserName());
				return ResponseEntity.ok(new MessageResponse("Thêm mới người dùng thành công !"));
			} else {
				return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Thêm mới người dùng thất bại !"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình xử lý !"));
	}

	@PutMapping("/updateUser")
	public ResponseEntity<?> updateUser(@Valid @RequestBody RegisterRequest signUpRequest) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetailsImpl userToken = getUserInfo();
			if (signUpRequest.getId() == null || signUpRequest.getId().isEmpty()) {
				return ResponseEntity.badRequest()
						.body(new MessageResponse("Lỗi: Không tìm thấy người dùng để cập nhật!"));
			}
			if (tblUserService.existsByEmail(signUpRequest.getEmail(), Long.valueOf(signUpRequest.getId()))) {
				return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Thư điện tử đã được sử dụng!"));
			}
			TblUser user = tblUserService.findById(Long.valueOf(signUpRequest.getId()));
			if (user == null) {
				return ResponseEntity.badRequest()
						.body(new MessageResponse("Lỗi: Không tìm thấy người dùng để cập nhật!"));
			}
			user.setDepartmentcode(signUpRequest.getDepartmentcode());
			user.setDepartmentname(signUpRequest.getDepartmentname());
			user.setFullname(signUpRequest.getFullname());
			user.setAddress(signUpRequest.getAddress());
			user.setTelephone(signUpRequest.getTelephone());
			user.setEmail(signUpRequest.getEmail());
			user.setRoleId(signUpRequest.getRoleId());
			user.setOfficecode(signUpRequest.getOfficecode());
			user.setOfficename(signUpRequest.getOfficename());
			user.setOfficetype(signUpRequest.getOfficetype());
			user.setModifiedby(userToken.getUsername());
			List<TblUserPermission> lstPermission = gson.fromJson(signUpRequest.getLstPermission(),
					new TypeToken<List<TblUserPermission>>() {
					}.getType());
			TblUser userUpdated = tblUserService.updateUser(user, lstPermission);
			if (userUpdated != null) {
				return ResponseEntity.ok(new MessageResponse("Cập nhật người dùng thành công !"));
			} else {
				return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Cập nhật người dùng thất bại !"));
			}
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình xử lý!"));
		}
	}
	@PostMapping("/publicRegister")
	public ResponseEntity<?> publicRegister(@Valid @RequestBody RegisterRequest signUpRequest) {
	    try {
	        if (tblUserService.existsByUsername(signUpRequest.getUsername())) {
	            return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Tên đăng nhập đã tồn tại !"));
	        }
	        if (tblUserService.existsByEmail(signUpRequest.getEmail(), null)) {
	            return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Thư điện tử đã được sử dụng !"));
	        }

	        // Tạo tài khoản với quyền mặc định, ví dụ ROLE_USER
	        TblUser user = new TblUser(
	                signUpRequest.getUsername(),
	                signUpRequest.getEmail(),
	                encoder.encode(signUpRequest.getPassword()),
	                signUpRequest.getFullname(),
	                signUpRequest.getAddress(),
	                signUpRequest.getTelephone(),
	                null, // departmentcode
	                null, // departmentname
	                Constants.STATUS.ACTIVE,
	                4L, // Giả sử 2L là ROLE_USER
	                null, null
	        );
	        user.setCreatedby(signUpRequest.getUsername()); // Hoặc null nếu chưa đăng nhập
	        user.setCreatedDate(new Date());

	        // Không cần phân quyền chi tiết (lstPermission), chỉ lưu tài khoản cơ bản
	        TblUser saved = tblUserService.createUser(user, new ArrayList<>());

	        return ResponseEntity.ok(new MessageResponse("Đăng ký tài khoản thành công!"));
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình đăng ký!"));
	    }
	}

	@GetMapping("/countActiveUsers")
    public ResponseEntity<Long> countActiveUsers() {
        try {
            long activeUserCount = tblUserService.countActiveUsers();
            return ResponseEntity.ok(activeUserCount);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0L);
        }
    }

    @GetMapping("/countInactiveUsers")
    public ResponseEntity<Long> countInactiveUsers() {
        try {
            long inactiveUserCount = tblUserService.countInactiveUsers();
            return ResponseEntity.ok(inactiveUserCount);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0L);
        }
    }
	@PutMapping("/changePassword")
	public ResponseEntity<?> changePassword(@Valid @RequestBody RegisterRequest signUpRequest) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetailsImpl userToken = getUserInfo();
			if (signUpRequest.getId() == null || signUpRequest.getId().isEmpty()) {
				return ResponseEntity.badRequest()
						.body(new MessageResponse("Lỗi: Không tìm thấy người dùng để đổi mật khẩu!"));
			}
			TblUser user = tblUserService.findById(Long.valueOf(signUpRequest.getId()));
			if (user == null) {
				return ResponseEntity.badRequest()
						.body(new MessageResponse("Lỗi: Không tìm thấy người dùng để đổi mật khẩu!"));
			}
			user.setModifiedby(userToken.getUsername());
			user.setModifiedDate(new Date());
			user.setCountLogin(TtisvConstant.ZERO);
			user.setIsResetPass(Objects.equals(userToken.getUsername(), user.getUserName()) ? "N" : "Y");
			user.setPassword(encoder.encode(signUpRequest.getPassword()));
			tblUserService.saveorUpdate(user);
			return ResponseEntity.ok(new MessageResponse("Đổi mật khẩu người dùng thành công!"));
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình xử lý!"));
		}
	}

	@PutMapping("/uploadAvatar")
	public ResponseEntity<?> uploadAvatar(@Valid @RequestBody RegisterRequest signUpRequest) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetailsImpl userToken = getUserInfo();
			if (signUpRequest.getId() == null || signUpRequest.getId().isEmpty()) {
				return ResponseEntity.badRequest()
						.body(new MessageResponse("Lỗi: Không tìm thấy người dùng để thay đổi hình đại diện !"));
			}
			TblUser user = tblUserService.findById(Long.valueOf(signUpRequest.getId()));
			if (user == null) {
				return ResponseEntity.badRequest()
						.body(new MessageResponse("Lỗi: Không tìm thấy người dùng để đổi mật khẩu!"));
			}
			user.setModifiedDate(new Date());
			user.setModifiedby(userToken.getUsername());
			user.setAvatar(signUpRequest.getBase64Data());
			tblUserService.saveorUpdate(user);
			return ResponseEntity.ok(new MessageResponse("Đổi hình đại diện người dùng thành công!"));
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình xử lý!"));
		}
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<Page<TblUser>> findAllUser(@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		int sizeRecord = 10;
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(sizeRecord);
		Map<String, String> map = new HashMap<>();
		Page<TblUser> list = tblUserService.getListPageUser(PageRequest.of(currentPage - 1, pageSize), map);
		if (list == null) {
			return new ResponseEntity<Page<TblUser>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Page<TblUser>>(list, HttpStatus.OK);
	}

	@SuppressWarnings("deprecation")
	@CrossOrigin
	@RequestMapping(value = "/paging", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Page<TblUser>> findAllUser(@RequestBody String req, HttpServletRequest request,
			HttpServletResponse resp) {
		UserRequest acctreq = gson.fromJson(req, UserRequest.class);
		int currentPage = acctreq.getPage();
		int pageSize = 10;
		Map<String, String> map = taoMapTraCuu(acctreq);
		Page<TblUser> list = tblUserService.getListPageUser(PageRequest.of(currentPage - 1, pageSize), map);
		if (list == null) {
			return new ResponseEntity<Page<TblUser>>(HttpStatus.NOT_FOUND);
		}
		String s = gson.toJson(list);
		System.out.println(list.getNumber());
		System.out.println(s);
		return new ResponseEntity<Page<TblUser>>(list, HttpStatus.OK);
	}

	@GetMapping("/delete")
	public ResponseEntity<?> deleteUser(@Valid @RequestParam String userName) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userToken = getUserInfo();
		if (!tblUserService.existsByUsername(userName)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Tên tài khoản không tồn tại!"));
		}
		try {
			tblUserService.updateStatusUser(userName, Constants.STATUS.DELETE, userToken.getUsername());
			return ResponseEntity.ok(new MessageResponse("Xóa người dùng thành công!"));
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình xử lý!"));
		}
	}

	@GetMapping("/lock")
	public ResponseEntity<?> lockUser(@Valid @RequestParam String userName) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userToken = getUserInfo();
		if (!tblUserService.existsByUsername(userName)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Tên người dùng không tồn tại !"));
		}
		try {
			TblUser user = tblUserService.updateStatusUser(userName, Constants.STATUS.INACTIVE,
					userToken.getUsername());
			return ResponseEntity.ok(user != null ? new MessageResponse("Khóa người dùng thành công !")
					: new MessageResponse("Khóa người dùng thất bại !"));
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình xử lý !"));
		}
	}
	
	
	@GetMapping("/unlock")
	public ResponseEntity<?> unlockUser(@Valid @RequestParam String userName) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userToken = getUserInfo();
		if (!tblUserService.existsByUsername(userName)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Tên người dùng không tồn tại!"));
		}
		try {
			TblUser user = tblUserService.updateStatusUser(userName, Constants.STATUS.ACTIVE, userToken.getUsername());
			return ResponseEntity.ok(user != null ? new MessageResponse("Mở khóa người dùng thành công !")
					: new MessageResponse("Mở khóa người dùng thất bại !"));
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình xử lý!"));
		}
	}

	@GetMapping("/findById")
	public ResponseEntity<TblUser> findById(@Valid @RequestParam Long id) {
		try {
			TblUser user = tblUserService.findById(id);
			return new ResponseEntity<TblUser>(user, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<TblUser>(HttpStatus.NOT_FOUND);
		}
	}

	private Map<String, String> taoMapTraCuu(UserRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userName", !StringUtils.isEmpty(request.getUserName()) ? request.getUserName() : null);
		map.put("fullName", !StringUtils.isEmpty(request.getFullname()) ? request.getFullname() : null);
		map.put("departmentname",
				!StringUtils.isEmpty(request.getDepartmentname()) ? request.getDepartmentname() : null);
		map.put("status",
				!StringUtils.isEmpty(request.getStatus())
						&& !Objects.equals(request.getStatus(), Constants.STATUS.DEFAULT.toString())
								? String.valueOf(request.getStatus())
								: null);
		map.put("email", !StringUtils.isEmpty(request.getEmail()) ? request.getEmail() : null);
		return map;
	}
}
