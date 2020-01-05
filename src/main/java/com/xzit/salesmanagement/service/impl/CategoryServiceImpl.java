package com.xzit.salesmanagement.service.impl;

import com.xzit.salesmanagement.entity.Category;
import com.xzit.salesmanagement.mapper.CategoryMapper;
import com.xzit.salesmanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public Category getCategory(int id) {
        return categoryMapper.getCategory(id);
    }

    @Override
    public List<Category> listCategory() {
        return categoryMapper.findAllCategory();
    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }

    @Override
    public void add(Category category) {
        categoryMapper.add(category);
    }


}
