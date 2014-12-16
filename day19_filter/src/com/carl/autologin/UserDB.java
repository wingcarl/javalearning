
package com.carl.autologin;

import java.util.ArrayList;
import java.util.List;

public class UserDB {

	private static List<User> users = new ArrayList<User>();
	static{
		users.add(new User("gfy","ge","123"));
	}
	public static User findUser(String username,String password){
		User user = null;
		for(User u:users){
			if(username.equals(u.getUsername())&& password.equals(u.getPassword())){
				user = u;
				break;
			}
		}
		return user;
	}
	public static User findUser(String username){
		User user = null;
		for(User u:users){
			if(username.equals(u.getUsername())){
				user = u;
				break;
			}
		}
		return user;
	}
}
