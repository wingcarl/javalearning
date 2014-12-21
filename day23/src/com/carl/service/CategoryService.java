package com.carl.service;

import java.util.List;

import com.carl.model.Category;

public interface CategoryService {
	void addCategory(Category c);
	List<Category> findAllCategory();
}
