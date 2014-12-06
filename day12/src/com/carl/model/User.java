package com.carl.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3318591934506162496L;
	private String username; //不能重复
	private String nickname;
	private String password; //要加密
	private String email;
	private Date birthday;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public User(String username, String nickname, String password,
			String email, Date birthday) {
		super();
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.email = email;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", nickname=" + nickname
				+ ", password=" + password + ", email=" + email + ", birthday="
				+ birthday + "]";
	}
	public User(){
		
	}
}
