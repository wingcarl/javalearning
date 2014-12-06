package com.carl.web.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegistFormBean {

	private String username;
	private String nickname;
	private String password;
	private String password1;
	private String email;
	private String birthday;
	
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}

	private Map<String,String> errors = new HashMap<String,String>();
	public boolean validate(){
		if(username==null||"".equals(username.trim())){
			errors.put("username", "请输入用户名");
		}else{
			if(!username.matches("[a-zA-Z]{3,8}")){
			errors.put("username", "用户必须是3-8位字母");
		}
		if(password==null||"".equals(password.trim())){
				errors.put("password", "请输入密码");
			}else{
				if(!password.matches("\\d{3,8}")){
				errors.put("password", "密码必须是3-8位字母");
			}
		}
		if(!password.equals(password1)){
			errors.put("password1", "两次密码必须一致");
		}
		if(email==null||"".equals(email.trim())){
			errors.put("email", "请输入邮箱");
		}else{
			if(!email.matches("\\w+@\\w+(.\\w+)+")){
			errors.put("email", "请输入正确的邮箱");
		}
	}
		}
		if(birthday==null||"".equals(birthday.trim())){
			errors.put("birthday", "请输入出生日期");
		}else{
			DateLocaleConverter dlc = new DateLocaleConverter();
			try{
				dlc.convert(birthday);
			}catch(Exception e){
				errors.put("birthday", "请输入正确的出生日期");
			}
		}
		return errors.isEmpty();
	}
	
}
