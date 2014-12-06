package com.carl.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.carl.exception.UsernameExistException;
import com.carl.model.User;
import com.carl.service.UserService;
import com.carl.service.impl.UserServiceImpl;

public class UserServiceImplTest {

	private UserService s = new UserServiceImpl();
	@Test
	public void testLogin() {
		User user = s.login("zql", "ccc");
		assertNotNull(user);
	}

	@Test(expected=com.carl.exception.UsernameExistException.class)
	public void testRegist() throws UsernameExistException {
		User user = new User();
		user.setUsername("fdf");
		user.setEmail("222@sss.com");
		user.setNickname("ddd");
		user.setBirthday(new Date());
		user.setPassword("ccc");
		s.regist(user);
	}
	
	@Test
	public void testRegist1() throws UsernameExistException {
		User user = new User();
		user.setUsername("zql");
		user.setEmail("222@sss.com");
		user.setNickname("ddd");
		user.setBirthday(new Date());
		user.setPassword("ccc");
		s.regist(user);
	}

}
