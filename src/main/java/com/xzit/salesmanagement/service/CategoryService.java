package com.xzit.salesmanagement.service;

import com.xzit.salesmanagement.entity.Category;

import java.util.List;

public interface CategoryService {
    public Category getCategory(int id);

    public List<Category> listCategory();

    void update(Category category);

    void add(Category category);
}
