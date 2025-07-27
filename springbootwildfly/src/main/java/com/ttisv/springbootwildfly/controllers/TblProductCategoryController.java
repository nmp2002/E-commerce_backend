package com.ttisv.springbootwildfly.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttisv.bean.system.TblProductCategory;
import com.ttisv.service.system.TblProductCategoryService;

@RestController
@RequestMapping("/api/categories")
public class TblProductCategoryController extends BaseController {

    @Autowired
    private TblProductCategoryService categoryService;

    // Tạo mới danh mục
    @PostMapping
    public ResponseEntity<TblProductCategory> createCategory(@RequestBody TblProductCategory category) {
        TblProductCategory created = categoryService.save(category);
        return ResponseEntity.ok(created);
    }

    // Cập nhật danh mục
    @PutMapping("/{id}")
    public ResponseEntity<TblProductCategory> updateCategory(@PathVariable Long id,
                                                             @RequestBody TblProductCategory category) {
        category.setId(id);
        TblProductCategory updated = categoryService.updates(category);
        return ResponseEntity.ok(updated);
    }

    // Xoá danh mục
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        boolean deleted = categoryService.delete(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Lấy danh sách tất cả danh mục
    @GetMapping
    public ResponseEntity<List<TblProductCategory>> getAllCategories() {
        List<TblProductCategory> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    // Lấy danh mục theo ID
    @GetMapping("/{id}")
    public ResponseEntity<TblProductCategory> getCategoryById(@PathVariable Long id) {
        TblProductCategory category = categoryService.findById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Tìm danh mục theo tên
    @GetMapping("/search")
    public ResponseEntity<List<TblProductCategory>> searchCategoryByName(@RequestParam String name) {
        List<TblProductCategory> results = categoryService.findByName(name);
        return ResponseEntity.ok(results);
    }
}