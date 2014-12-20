package com.carl.dao;

import java.util.List;

import com.carl.model.Category;

public interface CategoryDao {

	void addCategory(Category c);
	List<Category> findAll();
	
}
