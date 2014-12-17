package com.carl.dao;

import java.util.List;

import com.carl.model.User;

public interface UserDao {

	public List<User> listAllUsers();

	public void addUser(User u);

	public User findUserById(String userId);

	public void delMenuRelation(String userId);

	public void addMenuRelation(String userId, String[] mIds);
}
