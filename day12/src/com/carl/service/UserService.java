package com.carl.service;

import com.carl.exception.UsernameExistException;
import com.carl.model.User;

public interface UserService {
	User login(String username,String password);
	/**
	 * 判断用户名是否存在
	 * @param user
	 * @throws UsernameExistException 用户存在抛出异常
	 */
	void regist(User user) throws UsernameExistException;
}
