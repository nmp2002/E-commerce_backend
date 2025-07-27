package com.ttisv.service.system;

import java.util.List;

import com.ttisv.bean.system.PageResponse;
import com.ttisv.bean.system.TblProduct;

public interface TblProductService {
	TblProduct findByProductNameAndCategory(String productName, Long categoryId);
	List<TblProduct> getProductsByCategoryId(Long categoryId);
	TblProduct findProductById(Long id);
	List<TblProduct> searchByProductName(String keyword);

	TblProduct createProduct(TblProduct product);

	TblProduct updateProduct(TblProduct product);

	boolean deleteProduct(Long id);
	PageResponse<TblProduct> getAllProducts(int page, int size, String search, Long categoryId);

	List<TblProduct> findByGroupCode(String groupCode);
	List<TblProduct> getFeaturedProducts();
}
