package com.carl.service;

import com.carl.exception.CodeInvalidateException;
import com.carl.model.User;

public interface UserService {

	User login(String username,String password);
	void regist(User user);
	void active(String code) throws CodeInvalidateException;
}
