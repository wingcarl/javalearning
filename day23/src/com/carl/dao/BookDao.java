package com.carl.dao;

import java.util.List;

import com.carl.model.Book;

public interface BookDao {
	void addBook(Book b);
	List<Book> findAll();
	Book findBookById(String id);
}
