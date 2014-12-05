package com.carl.service;

import java.util.Map;

import com.carl.model.Book;
import com.carl.model.Cart;

public interface BookService {
	Map<String,Book> findAllBooks();
	Book findBookById(String id);
	void addBook2Cart(Cart cart,Book book);
	void deleteBook(Cart cart,String id);
	void changeCartItemNum(String bookId, Cart cart, int newnum);
}
