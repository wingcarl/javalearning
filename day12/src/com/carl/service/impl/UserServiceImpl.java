package com.carl.service.impl;

import com.carl.dao.UserDao;
import com.carl.dao.impl.UserDaoImpl;
import com.carl.exception.UsernameExistException;
import com.carl.model.User;
import com.carl.service.UserService;
import com.carl.util.MD5Util;

public class UserServiceImpl implements UserService {

	private UserDao ud = new UserDaoImpl();
	@Override
	public User login(String username, String password) {
		password = MD5Util.encode(password);
		
		return ud.findUser(username, password);
	}

	@Override
	public void regist(User user) throws UsernameExistException {
		User u = ud.findUserByUsername(user.getUsername());
		if(u!=null){
			throw new UsernameExistException();
		}
		user.setPassword(MD5Util.encode(user.getPassword()));
		ud.addUser(user);
	}

}
