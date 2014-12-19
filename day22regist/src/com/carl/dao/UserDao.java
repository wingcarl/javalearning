package com.carl.dao;

import com.carl.model.User;

public interface UserDao {

	void addUser(User user);
	User findUser(String username,String password);
	User findUserByCode(String code);
	void updateUser(User user);
}
