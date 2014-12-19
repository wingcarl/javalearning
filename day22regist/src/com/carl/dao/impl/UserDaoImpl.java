package com.carl.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.carl.dao.UserDao;
import com.carl.model.User;
import com.carl.util.DBCPUtil;

public class UserDaoImpl implements UserDao {

	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	@Override
	public void addUser(User user)  {
		try {
			qr.update(
					"insert into user(id,username,nick,password,email,actived,code) values (?,?,?,?,?,?,?)",
					user.getId(), user.getUsername(), user.getNick(),
					user.getPassword(), user.getEmail(), user.isActived(),
					user.getCode());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	@Override
	public User findUser(String username, String password) {
		try {
			return qr.query("select * from user where username=? and password=?", new BeanHandler<User>(User.class),username,password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	@Override
	public User findUserByCode(String code) {
		try {
			return qr.query("select * from user where code=?", new BeanHandler<User>(User.class),code);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void updateUser(User user) {
		try {
			qr.update(
					"update user set username=?,nick=?,password=?,email=?,actived=?,code=? where id=?",
					user.getUsername(), user.getNick(), user.getPassword(),
					user.getEmail(), user.isActived(), user.getCode(), user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

}
