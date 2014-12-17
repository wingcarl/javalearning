package com.carl.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.carl.dao.UserDao;
import com.carl.exception.DaoException;
import com.carl.model.Menu;
import com.carl.model.Role;
import com.carl.model.User;
import com.carl.util.DBCPUtil;

public class UserDaoImpl implements UserDao {

	QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	@Override
	public List<User> listAllUsers() {
		try {
			return qr.query("select * from user",new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}
	@Override
	public void addUser(User u) {
		try {
			qr.update("insert into user(id,username,password,nick) values (?,?,?,?)",u.getId(),u.getUsername(),u.getPassword(),u.getNick());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}
	@Override
	public User findUserById(String userId) {
		try {
			 User u = qr.query("select * from user where id=?", new BeanHandler<User>(User.class),userId);
			 if(u!=null){
				List<Role> roles =  qr.query("select * from role where id in (select r_id from role_user where u_id=?)", new BeanListHandler<Role>(Role.class),userId);
				u.setRoles(roles);
			 }
			 return u;
		} catch (SQLException e) {
			e.printStackTrace();	
			throw new DaoException();
			}
	}
	@Override
	public void delMenuRelation(String userId) {
		try {
			qr.update("delete from role_user where u_id=?",userId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
		
	}
	@Override
	public void addMenuRelation(String userId, String[] mIds) {
		try{
			Object params[][] = new Object[mIds.length][];
			for(int i=0;i<mIds.length;i++){
				params[i] = new Object[]{mIds[i],userId};
			}
			qr.batch("insert into role_user(r_id,u_id) values(?,?)",params);
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
		
	}
	

}
