package com.carl.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.carl.dao.BookDao;
import com.carl.exception.DaoException;
import com.carl.model.Book;
import com.carl.util.DBCPUtil;

public class BookDaoImpl implements BookDao {

	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	@Override
	public void addBook(Book b) {
		try {
			qr.update("insert into book(id,name,author,price,image,description,category_id) values(?,?,?,?,?,?,?",b.getId(),b.getName(),b.getAuthor(),b.getPrice(),b.getImage(),b.getDescription(),b.getCategory_id());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}

	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findBookById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
