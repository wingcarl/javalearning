package com.carl.service.impl;
import java.util.UUID;

import com.carl.dao.UserDao;
import com.carl.dao.impl.UserDaoImpl;
import com.carl.exception.CodeInvalidateException;
import com.carl.model.User;
import com.carl.service.UserService;


public class UserServiceImpl implements UserService {

	private UserDao uDao = new UserDaoImpl();
	@Override
	public User login(String username, String password) {
		User u = uDao.findUser(username, password);
		if(u!=null){
			if(u.isActived())
				return u;
			else
				return null;
		}
		return null;
	}

	@Override
	public void regist(User user) {
		user.setId(UUID.randomUUID().toString());
		uDao.addUser(user);

	}

	@Override
	public void active(String code) throws CodeInvalidateException {
		User user = uDao.findUserByCode(code);
		if(user == null)
			throw new CodeInvalidateException();
		user.setActived(true);
		uDao.updateUser(user);

	}

}
