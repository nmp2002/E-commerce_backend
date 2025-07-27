package com.ttisv.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttisv.bean.Category;
import com.ttisv.dao.CategoryDao;
import com.ttisv.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Serializable save(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public void delete(Serializable id) {
        categoryDao.delete(id);
    }

    @Override
    public void update(Category category) {
        categoryDao.update(category);
    }

    @Override
    public Category get(Serializable id) {
        return categoryDao.get(id);
    }

    @Override
    public List<Category> find(String hql) {
        return categoryDao.find(hql);
    }

    @Override
    public List<Category> find(String hql, Map<String, Object> params) {
        return categoryDao.find(hql, params);
    }

    @Override
    public List<Category> find(String hql, int page, int rows) {
        return categoryDao.find(hql, page, rows);
    }

    @Override
    public List<Category> find(String hql, Map<String, Object> params, int page, int rows) {
        return categoryDao.find(hql, params, page, rows);
    }

    @Override
    public Integer count(String hql) {
        return categoryDao.count(hql);
    }

    @Override
    public Integer count(String hql, Map<String, Object> params) {
        return categoryDao.count(hql, params);
    }

    @Override
    public List<Category> findActiveCategories() {
        String hql = "from Category where isActive = true";
        return categoryDao.find(hql);
    }

    @Override
    public List<Category> findSubCategories(Long parentId) {
        String hql = "from Category where parentId = :parentId and isActive = true";
        Map<String, Object> params = new HashMap<>();
        params.put("parentId", parentId);
        return categoryDao.find(hql, params);
    }

    @Override
    public List<Category> findRootCategories() {
        String hql = "from Category where parentId is null and isActive = true";
        return categoryDao.find(hql);
    }
} 