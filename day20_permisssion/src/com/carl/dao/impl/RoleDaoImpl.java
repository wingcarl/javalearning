package com.carl.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.carl.dao.RoleDao;
import com.carl.exception.DaoException;
import com.carl.model.Menu;
import com.carl.model.Role;
import com.carl.util.DBCPUtil;

public class RoleDaoImpl implements RoleDao {

	QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	@Override
	public List<Role> findAllRole() {
		try {
		 return	qr.query("select * from role", new BeanListHandler<Role>(Role.class));
		} catch (SQLException e) {
			throw new DaoException();
		}
		
	}
	@Override
	public void addRole(Role r) {
		try{
			qr.update("insert into role(id,name,description) values(?,?,?)",r.getId(),r.getName(),r.getDescription()); 
		}catch(SQLException e){
			throw new DaoException();
		}
		
	}
	@Override
	public Role findRoleById(String roleId) {
		try {
			 Role r = qr.query("select * from role where id=?", new BeanHandler<Role>(Role.class),roleId);
			 if(r!=null){
				List<Menu> menus =  qr.query("select * from menu where id in (select m_id from menu_role where r_id=?)", new BeanListHandler<Menu>(Menu.class),roleId);
				r.setMenus(menus);
			 }
			 return r;
		} catch (SQLException e) {
			e.printStackTrace();	
			throw new DaoException();
			}
	}
	@Override
	public void delMenuRelation(String roleId) {
		try {
			qr.update("delete from menu_role where r_id=?",roleId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
		
	}
	@Override
	public void addMenuRelation(String roleId, String[] mIds) {
	try{
		Object params[][] = new Object[mIds.length][];
		for(int i=0;i<mIds.length;i++){
			params[i] = new Object[]{mIds[i],roleId};
		}
		qr.batch("insert into menu_role(m_id,r_id) values(?,?)",params);
	}catch(SQLException e) {
		e.printStackTrace();
		throw new DaoException();
	}
		
	}

}
