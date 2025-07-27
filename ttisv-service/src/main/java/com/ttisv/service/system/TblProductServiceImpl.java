package com.ttisv.service.system;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttisv.bean.system.PageResponse;
import com.ttisv.bean.system.TblProduct;
import com.ttisv.dao.system.TblProductDao;

@Service
@Transactional
public class TblProductServiceImpl implements TblProductService{
	@Autowired
	TblProductDao tblProductDao;

	@Override
	public TblProduct findByProductNameAndCategory(String productName, Long categoryId) {
		// TODO Auto-generated method stub
		return tblProductDao.findByProductNameAndCategory(productName, categoryId);
	}

	@Override
	public List<TblProduct> getProductsByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return tblProductDao.getProductsByCategoryId(categoryId);
	}

	@Override
	public TblProduct findProductById(Long id) {
		// TODO Auto-generated method stub
		return tblProductDao.findProductById(id);
	}

	@Override
	public List<TblProduct> searchByProductName(String keyword) {
		// TODO Auto-generated method stub
		return tblProductDao.searchByProductName(keyword);
	}

	@Override
	public TblProduct createProduct(TblProduct product) {
		// TODO Auto-generated method stub
		return tblProductDao.createProduct(product);
	}

	@Override
	public TblProduct updateProduct(TblProduct product) {
		return tblProductDao.updateProduct(product);
		
	}

	@Override
	public boolean deleteProduct(Long id) {
		return tblProductDao.deleteProduct(id);
		
	}

	@Override
	public PageResponse<TblProduct> getAllProducts(int page, int size, String search, Long categoryId) {
		// TODO Auto-generated method stub
		return tblProductDao.getAllProducts(page, size, search, categoryId);
	}

	@Override
	public List<TblProduct> findByGroupCode(String groupCode) {
		// TODO Auto-generated method stub
		return tblProductDao.findByGroupCode(groupCode);
	}

    @Override
    public List<TblProduct> getFeaturedProducts() {
        return tblProductDao.getFeaturedProducts();
    }
	
}
