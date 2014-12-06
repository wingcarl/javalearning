package com.carl.dao;

import com.carl.model.User;

public interface UserDao {

	public void addUser(User user);
//	public void deleteUser(String username);
//	public void changeUser(User user);
	public User findUserByUsername(String username);
	public User findUser(String username, String password);
}
