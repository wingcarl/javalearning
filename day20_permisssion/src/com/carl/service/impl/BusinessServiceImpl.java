package com.carl.service.impl;
import java.util.List;
import java.util.UUID;

import com.carl.dao.MenuDao;
import com.carl.dao.RoleDao;
import com.carl.dao.UserDao;
import com.carl.dao.impl.MenuDaoImpl;
import com.carl.dao.impl.RoleDaoImpl;
import com.carl.dao.impl.UserDaoImpl;
import com.carl.model.Menu;
import com.carl.model.Role;
import com.carl.model.User;
import com.carl.service.BusinessService;


public class BusinessServiceImpl implements BusinessService {

	private MenuDao mDao = new MenuDaoImpl();
	private RoleDao rDao = new RoleDaoImpl();
	private UserDao uDao = new UserDaoImpl();
	@Override
	public void addMenu(Menu m) {
		m.setId(UUID.randomUUID().toString());
		mDao.addMenu(m);

	}

	@Override
	public List<Menu> findAllMenu() {
		return mDao.findAllMenu();
	}

	@Override
	public Menu findMenuById(String menuId) {
		return mDao.findMenuById(menuId);
	}

	@Override
	public List<Role> findAllRole() {
		return rDao.findAllRole();
	}

	@Override
	public void addRole(Role r) {
		r.setId(UUID.randomUUID().toString());
		rDao.addRole(r);
		
	}

	@Override
	public void addUser(User u) {
		u.setId(UUID.randomUUID().toString());
		uDao.addUser(u);
		
	}

	@Override
	public Role findRoleById(String roleId) {
		
		return rDao.findRoleById(roleId);
	}

	@Override
	public void grantMenu2Role(String roleId, String[] mIds) {
		rDao.delMenuRelation(roleId);
		rDao.addMenuRelation(roleId,mIds);
	}

	@Override
	public List<User> listAllUsers() {
		return uDao.listAllUsers();
	}

	@Override
	public User findUserById(String userId) {
		return uDao.findUserById(userId);
	}

	@Override
	public void grantRole2User(String userId, String[] mIds) {
		uDao.delMenuRelation(userId);
		uDao.addMenuRelation(userId,mIds);
		
	}

	
}
