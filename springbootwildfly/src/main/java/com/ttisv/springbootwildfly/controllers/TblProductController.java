package com.ttisv.springbootwildfly.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.apache.http.HttpStatus;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.thoughtworks.xstream.io.path.Path;
import com.ttisv.bean.system.PageResponse;
import com.ttisv.bean.system.TblProduct;
import com.ttisv.service.system.TblProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TblProductController extends BaseController {
	@Autowired
	TblProductService tblProductService;
	
	// API mới để lấy sản phẩm theo groupCode
	@GetMapping("/group/{groupCode}")
	public ResponseEntity<List<TblProduct>> getProductByGroupCode(@PathVariable String groupCode) {
	    List<TblProduct> products = tblProductService.findByGroupCode(groupCode);
	    if (products != null && !products.isEmpty()) {
	        return ResponseEntity.ok(products);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	
	// 🔍 Lấy tất cả sản phẩm theo categoryId
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<TblProduct>> getProductsByCategory(@PathVariable Long categoryId) {
        List<TblProduct> products = tblProductService.getProductsByCategoryId(categoryId);
        return ResponseEntity.ok(products);
    }
 // ✅ Lấy danh sách sản phẩm có phân trang + tìm kiếm + lọc theo category
    @GetMapping
    public ResponseEntity<PageResponse<TblProduct>> getAllProducts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(name = "pageSize", defaultValue = "10") int size,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) Long categoryId) {

        PageResponse<TblProduct> response = tblProductService.getAllProducts(page, size, search, categoryId);
        return ResponseEntity.ok(response);
    }

    // 🔍 Tìm sản phẩm theo ID
    @GetMapping("/{id}")
    public ResponseEntity<TblProduct> getProductById(@PathVariable Long id) {
        TblProduct product = tblProductService.findProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 🔍 Tìm kiếm sản phẩm theo tên
    @GetMapping("/search")
    public ResponseEntity<List<TblProduct>> searchProduct(@RequestParam String keyword) {
        List<TblProduct> products = tblProductService.searchByProductName(keyword);
        return ResponseEntity.ok(products);
    }

    // 🌟 Lấy 4 sản phẩm có giá trị price lớn nhất làm nổi bật
    @GetMapping("/featured")
    public ResponseEntity<List<TblProduct>> getFeaturedProducts() {
        PageResponse<TblProduct> response = tblProductService.getAllProducts(1, 100, null, null);
        List<TblProduct> all = response.getItems();
        all.sort((a, b) -> Long.compare(b.getPrice() != null ? b.getPrice() : 0L, a.getPrice() != null ? a.getPrice() : 0L));
        List<TblProduct> featured = all.size() > 4 ? all.subList(0, 4) : all;
        return ResponseEntity.ok(featured);
    }

    // ➕ Tạo sản phẩm mới
    @PostMapping
    public ResponseEntity<TblProduct> createProduct(@RequestBody TblProduct product) {
        TblProduct created = tblProductService.createProduct(product);
        if (created != null) {
            return ResponseEntity.ok(created);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
  

    // ✏️ Cập nhật sản phẩm
    @PutMapping("/{id}")
    public ResponseEntity<TblProduct> updateProduct(@PathVariable Long id, @RequestBody TblProduct product) {
        TblProduct existing = tblProductService.findProductById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        // Cập nhật trường từ body vào đối tượng cũ
        product.setId(id); // đảm bảo ID khớp
        TblProduct updated = tblProductService.updateProduct(product);
        return ResponseEntity.ok(updated);
    }

    // ❌ Xóa sản phẩm
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        boolean deleted = tblProductService.deleteProduct(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
