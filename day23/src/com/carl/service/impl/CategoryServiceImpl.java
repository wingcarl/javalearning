package com.carl.service.impl;

import java.util.List;

import com.carl.dao.BookDao;
import com.carl.dao.CategoryDao;
import com.carl.dao.impl.BookDaoImpl;
import com.carl.dao.impl.CategoryDaoImpl;
import com.carl.model.Book;
import com.carl.model.Category;
import com.carl.service.CategoryService;
import com.carl.util.IdGenerator;

public class CategoryServiceImpl implements CategoryService{

	private CategoryDao cDao = new CategoryDaoImpl();
	private BookDao bDao = new BookDaoImpl();
	@Override
	public void addCategory(Category c) {
		c.setId(IdGenerator.genPrimaryKey());
		cDao.addCategory(c);
	}

	@Override
	public List<Category> findAllCategory() {
		return cDao.findAll();
	}

	@Override
	public void addBook(Book b) {
		b.setId(IdGenerator.genPrimaryKey());
		bDao.addBook(b);
		
	}

}
