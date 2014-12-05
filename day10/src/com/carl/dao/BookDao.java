package com.carl.dao;

import java.util.Map;

import com.carl.model.Book;

public  interface BookDao {
	/**
	 * ��ѯ���е���
	 * @return
	 */
	Map<String,Book> findAllBooks();
	/**
	 * �����鼮��Id��ѯĳһ���鼮
	 * @param bookId
	 * @return
	 */
	Book findBookById(String bookId);
}
