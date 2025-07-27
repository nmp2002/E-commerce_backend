package com.ttisv.springbootwildfly.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ttisv.bean.dm.ObjCbb;
import com.ttisv.bean.dm.TblParam;
import com.ttisv.common.utils.TtisvConstant;
import com.ttisv.service.dm.TblParamsService;
import com.ttisv.springbootwildfly.payload.request.TblParamRequest;
import com.ttisv.springbootwildfly.payload.response.MessageResponse;
import com.ttisv.springbootwildfly.security.services.UserDetailsImpl;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/category/params")
public class TblParamsController  extends BaseController {
	@Autowired
	TblParamsService tblParamsService;

	@SuppressWarnings("deprecation")
	@CrossOrigin
	@RequestMapping(value = "/list", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Page<TblParam>> findPram(@RequestBody String req, HttpServletRequest request,
			HttpServletResponse resp) {
		int sizeRecord = 10;
		TblParamRequest reqCar = gson.fromJson(req, TblParamRequest.class);
		int currentPage = reqCar.getPage();
		int pageSize = sizeRecord;

		Map<String, String> map = taoMapTraCuuPram(reqCar);
		Page<TblParam> list = tblParamsService.getListPageParam(PageRequest.of(currentPage - 1, pageSize), map);
		if (list == null) {
			return new ResponseEntity<Page<TblParam>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Page<TblParam>>(list, HttpStatus.OK);
	}

	@PostMapping("/addOrUpdate")
	public ResponseEntity<?> addOrUpdate(@Valid @RequestBody TblParam tblParamRequest) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetailsImpl userToken = getUserInfo();
			if (tblParamRequest.getId() == null) {
				tblParamRequest.setCreatedby(userToken.getUsername());
				tblParamRequest.setCreatedDate(new Date());
			} else {
				tblParamRequest.setModifiedby(userToken.getUsername());
				tblParamRequest.setModifiedDate(new Date());
			}
			tblParamsService.saveOrUpdate(tblParamRequest);
			return ResponseEntity.ok(new MessageResponse(
					tblParamRequest.getId() == null ? "Thêm mới tham số thành công!" : "Cập nhật số thành công!"));

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Thêm mới/Cập nhật tham số thất bại!"));
		}
	}

	@CrossOrigin
	@RequestMapping(value = "/getallPramcbb", method = RequestMethod.GET)
	public ResponseEntity<List<ObjCbb>> findAllPramcbb(@Valid @RequestParam("paramgroup") String paramgroup,
			@Valid @RequestParam("type") String type) {
		List<ObjCbb> list = tblParamsService.getParamCbb(paramgroup, type);
		if (list == null) {
			return new ResponseEntity<List<ObjCbb>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ObjCbb>>(list, HttpStatus.OK);
	}

	private Map<String, String> taoMapTraCuuPram(TblParamRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		if (request.getParamcode() != null && !request.getParamcode().isEmpty()) {
			map.put("paramcode", request.getParamcode());
		}
		if (request.getParamname() != null && !request.getParamname().isEmpty()) {
			map.put("paramname", request.getParamname());
		}
		map.put("page", String.valueOf(request.getPage()));
		map.put("size", String.valueOf(request.getSize()));
		return map;
	}

	@SuppressWarnings("deprecation")
	@CrossOrigin
	@RequestMapping(value = "/listPrams", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<TblParam>> findAllTtiOffice() {
		List<TblParam> list = tblParamsService.getParams();
		if (list == null) {
			return new ResponseEntity<List<TblParam>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TblParam>>(list, HttpStatus.OK);
	}

	@PutMapping("/createParam")
	public ResponseEntity<?> createParam(@Valid @RequestBody TblParamRequest paramRequest) {
		if (tblParamsService.existsByParamcode(paramRequest.getParamcode(), null)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Mã tham số đã tồn tại!"));
		}
		TblParam param = new TblParam(paramRequest.getParamcode(), paramRequest.getParamname(),
				paramRequest.getParamgroup(), paramRequest.getStatus(), paramRequest.getSort(), paramRequest.getType(),
				paramRequest.getValue(), paramRequest.getNote());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userToken = getUserInfo();
		param.setCreatedby(userToken.getUsername());
		param.setCreatedDate(new Date());
		tblParamsService.saveOrUpdate(param);
		return ResponseEntity.ok(new MessageResponse("Thêm mới tham số thành công!"));
	}

	@PutMapping("/updateParam")
	public ResponseEntity<?> updateParam(@Valid @RequestBody TblParamRequest paramRequest) {
		try {
			if (paramRequest.getId() == null) {
				return ResponseEntity.badRequest()
						.body(new MessageResponse("Lỗi: Không tìm thấy tham số để cập nhật!"));
			}
			TblParam param = tblParamsService.getParamById(paramRequest.getId());
			if (param == null) {
				return ResponseEntity.badRequest()
						.body(new MessageResponse("Lỗi: Không tìm thấy tham số để cập nhật!"));
			}
			if (tblParamsService.existsByParamcode(paramRequest.getParamcode(), paramRequest.getId())) {
				return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Mã tham số đã tồn tại!"));
			}
			param.setId(paramRequest.getId());
			param.setParamcode(paramRequest.getParamcode());
			param.setValue(paramRequest.getValue());
			param.setParamname(paramRequest.getParamname());
			param.setNote(paramRequest.getNote());
			param.setStatus(
					(paramRequest.getStatus() != null && !paramRequest.getStatus().isEmpty()) ? paramRequest.getStatus()
							: TtisvConstant.STATUS.ACTIVE);
			param.setSort(param.getSort());
			param.setType(paramRequest.getType());
			param.setParamgroup(paramRequest.getParamgroup());
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetailsImpl userToken = getUserInfo();
			param.setModifiedby(userToken.getUsername());
			param.setModifiedDate(new Date());
			tblParamsService.saveOrUpdate(param);
			return ResponseEntity.ok(new MessageResponse("Cập nhật tham số thành công!"));
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình xử lý!"));
		}
	}

	@GetMapping("/findById")
	public ResponseEntity<TblParam> findById(@Valid @RequestParam Long id) {
		try {
			TblParam param = tblParamsService.getParamById(id);
			if (param == null) {
				return new ResponseEntity<TblParam>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<TblParam>(param, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<TblParam>(HttpStatus.NOT_FOUND);
		}
	}
}
