package com.ttisv.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ttisv.bean.Category;

public interface CategoryService {
    
    public Serializable save(Category category);
    
    public void delete(Serializable id);
    
    public void update(Category category);
    
    public Category get(Serializable id);
    
    public List<Category> find(String hql);
    
    public List<Category> find(String hql, Map<String, Object> params);
    
    public List<Category> find(String hql, int page, int rows);
    
    public List<Category> find(String hql, Map<String, Object> params, int page, int rows);
    
    public Integer count(String hql);
    
    public Integer count(String hql, Map<String, Object> params);
    
    // Add custom business methods
    public List<Category> findActiveCategories();
    
    public List<Category> findSubCategories(Long parentId);
    
    public List<Category> findRootCategories();
} 