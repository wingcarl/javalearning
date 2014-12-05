package com.carl.dao;

import java.util.Map;

import com.carl.model.Book;

public  interface BookDao {
	/**
	 * 查询所有的书
	 * @return
	 */
	Map<String,Book> findAllBooks();
	/**
	 * 根据书籍的Id查询某一本书籍
	 * @param bookId
	 * @return
	 */
	Book findBookById(String bookId);
}
