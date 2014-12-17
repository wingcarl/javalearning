package com.carl.dao;

import java.util.List;

import com.carl.model.Menu;

public interface MenuDao {

	public void addMenu(Menu m);
	public List<Menu> findAllMenu();
	public Menu findMenuById(String menuId);
	public void updateMenu(Menu m);
	public void deleteMenu(String id);
}
