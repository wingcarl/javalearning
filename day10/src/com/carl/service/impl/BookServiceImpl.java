package com.carl.service.impl;

import java.util.Map;

import com.carl.dao.BookDao;
import com.carl.dao.impl.BookDaoImpl;
import com.carl.model.Book;
import com.carl.model.Cart;
import com.carl.model.CartItem;
import com.carl.service.BookService;

public class BookServiceImpl implements BookService{

	private BookDao dao = new BookDaoImpl();
	@Override
	public Map<String, Book> findAllBooks() {
		return dao.findAllBooks();
	}
	@Override
	public Book findBookById(String id) {
		// TODO Auto-generated method stub
		return dao.findBookById(id);
	}
	@Override
	public void addBook2Cart(Cart cart,Book book) {
		cart.addBook2Cart(book);
		
	}
	@Override
	public void deleteBook(Cart cart,String id) {
		cart.deleteBook(id);
	}
	@Override
	public void changeCartItemNum(String bookId, Cart cart, int newnum) {
		CartItem item = cart.getItems().get(bookId);
		item.setNum(newnum);
		
	}

}
