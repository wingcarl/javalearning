package com.carl.dao;

import java.util.List;

import com.carl.model.Role;

public interface RoleDao {

	public List<Role> findAllRole();
	public void addRole(Role r);
	public Role findRoleById(String roleId);
	public void delMenuRelation(String roleId);
	public void addMenuRelation(String roleId, String[] mIds);
}
