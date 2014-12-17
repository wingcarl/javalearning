package com.carl.service;

import java.util.List;

import com.carl.model.Menu;
import com.carl.model.Role;
import com.carl.model.User;

public interface BusinessService {

	public void addMenu(Menu m);
	public List<Menu> findAllMenu();
	public Menu findMenuById(String menuId);
	public List<Role> findAllRole();
	public void addRole(Role r);
	public void addUser(User u);
	public Role findRoleById(String roleId);
	public void grantMenu2Role(String roleId, String[] mIds);
	public List<User> listAllUsers();
	public User findUserById(String userId);
	public void grantRole2User(String userId, String[] mIds);
}
