package com.carl.service;

import com.carl.exception.UsernameExistException;
import com.carl.model.User;

public interface UserService {
	User login(String username,String password);
	/**
	 * �ж��û����Ƿ����
	 * @param user
	 * @throws UsernameExistException �û������׳��쳣
	 */
	void regist(User user) throws UsernameExistException;
}
