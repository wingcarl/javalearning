package com.carl.dao.impl;

import java.util.Map;

import com.carl.dao.BookDao;
import com.carl.db.BookDb;
import com.carl.model.Book;

public class BookDaoImpl implements BookDao {

	@Override
	public Map<String, Book> findAllBooks() {
		return BookDb.findAllBooks();
	}

	@Override
	public Book findBookById(String bookId) {
		return BookDb.findBookById(bookId);
	}

}
