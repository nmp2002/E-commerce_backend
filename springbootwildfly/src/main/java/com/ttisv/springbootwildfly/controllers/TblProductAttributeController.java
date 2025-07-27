package com.ttisv.springbootwildfly.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttisv.bean.system.TblProductAttribute;
import com.ttisv.service.system.TblProductAttributeService;
import com.ttisv.springbootwildfly.security.services.UserDetailsImpl;

@RestController
@RequestMapping("/api/product-attributes")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TblProductAttributeController extends BaseController {
	
	@Autowired
	private TblProductAttributeService tblProductAttributeService;
	
	// 🔍 Lấy tất cả attributes
	@GetMapping
	public ResponseEntity<List<TblProductAttribute>> getAllAttributes() {
		List<TblProductAttribute> attributes = tblProductAttributeService.getAll();
		return ResponseEntity.ok(attributes);
	}
	
	// 🔍 Lấy attribute theo ID
	@GetMapping("/{id}")
	public ResponseEntity<TblProductAttribute> getAttributeById(@PathVariable Long id) {
		TblProductAttribute attribute = tblProductAttributeService.getById(id);
		if (attribute != null) {
			return ResponseEntity.ok(attribute);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// 🔍 Lấy attributes theo productId
	@GetMapping("/product/{productId}")
	public ResponseEntity<List<TblProductAttribute>> getAttributesByProductId(@PathVariable Long productId) {
		List<TblProductAttribute> attributes = tblProductAttributeService.getByProductId(productId);
		return ResponseEntity.ok(attributes);
	}
	
	// ➕ Tạo attribute mới
	@PostMapping
	public ResponseEntity<TblProductAttribute> createAttribute(@RequestBody TblProductAttribute attribute) {
		try {
			// Lấy thông tin user hiện tại
			UserDetailsImpl currentUser = getUserInfo();
			
			// Set thông tin tạo mới
			attribute.setCreateby(currentUser.getUsername());
			attribute.setCreatedDate(new Date());
			
			TblProductAttribute created = tblProductAttributeService.create(attribute);
			if (created != null) {
				return ResponseEntity.ok(created);
			} else {
				return ResponseEntity.badRequest().build();
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	// ✏️ Cập nhật attribute
	@PutMapping("/{id}")
	public ResponseEntity<TblProductAttribute> updateAttribute(@PathVariable Long id, @RequestBody TblProductAttribute attribute) {
		try {
			// Kiểm tra attribute có tồn tại không
			TblProductAttribute existing = tblProductAttributeService.getById(id);
			if (existing == null) {
				return ResponseEntity.notFound().build();
			}
			
			// Lấy thông tin user hiện tại
			UserDetailsImpl currentUser = getUserInfo();
			
			// Set thông tin cập nhật
			attribute.setId(id);
			attribute.setModifiedby(currentUser.getUsername());
			attribute.setModifiedDate(new Date());
			
			TblProductAttribute updated = tblProductAttributeService.update(id, attribute);
			return ResponseEntity.ok(updated);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	// ❌ Xóa attribute
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAttribute(@PathVariable Long id) {
		boolean deleted = tblProductAttributeService.delete(id);
		if (deleted) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
} 