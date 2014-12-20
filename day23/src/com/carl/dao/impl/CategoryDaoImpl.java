package com.carl.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.carl.dao.CategoryDao;
import com.carl.exception.DaoException;
import com.carl.model.Category;
import com.carl.util.DBCPUtil;

public class CategoryDaoImpl implements CategoryDao {

	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	@Override
	public void addCategory(Category c) {
		try {
			qr.update("insert into category(id,name,description) values(?,?,?)",c.getId(),c.getName(),c.getDescription());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		
		
	}

	@Override
	public List<Category> findAll() {
		try {
			return qr.query("select * from category", new BeanListHandler<Category>(Category.class));
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	
}
