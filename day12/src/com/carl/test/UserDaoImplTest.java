/**
 * 
 */
package com.carl.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.carl.dao.UserDao;
import com.carl.dao.impl.UserDaoImpl;
import com.carl.model.User;

/**
 * @author dell-pc
 *
 */
public class UserDaoImplTest {

	private UserDao dao = new UserDaoImpl();
	/**
	 * Test method for {@link com.carl.dao.impl.UserDaoImpl#addUser(com.carl.model.User)}.
	 */
	@Test
	public void testAddUser() {
		User user = new User();
		user.setUsername("fdf");
		user.setEmail("222@sss.com");
		user.setNickname("ddd");
		user.setBirthday(new Date());
		user.setPassword("ccc");
		dao.addUser(user);
	}

	/**
	 * Test method for {@link com.carl.dao.impl.UserDaoImpl#findUserByUsername(java.lang.String)}.
	 */
	@Test
	public void testFindUserByUsername() {
		User u  = dao.findUserByUsername("fdf");
		assertNotNull(u);
		User u1 = dao.findUserByUsername("fdfee");
		assertNull(u1);
		User u2 = dao.findUserByUsername("");
		assertNull(u2);
		
	}

	/**
	 * Test method for {@link com.carl.dao.impl.UserDaoImpl#findUser(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testFindUser() {
		User u  = dao.findUser("fdf","ccc");
		assertNotNull(u);
		User u1 = dao.findUser("eee","ccc");
		assertNull(u1);
		User u2 = dao.findUser("fdf","cdc");
		assertNull(u2);
		User u3 = dao.findUser("fdff","cddc");
		assertNull(u3);
		
	}

}
