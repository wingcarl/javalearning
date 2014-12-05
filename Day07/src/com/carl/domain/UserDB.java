package com.carl.domain;

import java.util.ArrayList;
import java.util.List;


public class UserDB {

	private static List<User> users = new ArrayList<User>();
	static{
		users.add(new User("aaa","dfd"));
		users.add(new User("bbb","ggg"));
	}
	public static User findUser(String username,String password){
		User user = null;
		for(User u : users){
			if(u.getUsername().equals(username)&&u.getPassword().equals(password)){
				user = u;
			}
		}
		return user;
	}
}
