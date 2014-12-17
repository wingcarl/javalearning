package com.carl.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.carl.dao.MenuDao;
import com.carl.exception.DaoException;
import com.carl.model.Menu;
import com.carl.util.DBCPUtil;

public class MenuDaoImpl implements MenuDao {

	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	@Override
	public void addMenu(Menu m) {
		try {
			qr.update("insert into menu (id,name,uri,description) values (?,?,?,?)",m.getId(),m.getName(),m.getUri(),m.getDescription());
		} catch (SQLException e) {
			throw new DaoException();
		}
		
	}

	@Override
	public List<Menu> findAllMenu() {
		try {
			return qr.query("select * from menu", new BeanListHandler<Menu>(Menu.class));
		} catch (SQLException e) {
			throw new DaoException();
		}
	}

	@Override
	public Menu findMenuById(String menuId) {
		try {
			return qr.query("select * from menu where id=?", new BeanHandler<Menu>(Menu.class),menuId);
		} catch (SQLException e) {
			throw new DaoException();
		}
	}

	@Override
	public void updateMenu(Menu m) {
		throw new AbstractMethodError();
		
	}

	@Override
	public void deleteMenu(String id) {
		throw new AbstractMethodError();
		
	}

}
