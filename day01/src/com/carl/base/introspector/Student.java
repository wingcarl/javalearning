package com.carl.base.introspector;

import java.util.Date;

public class Student {
	
	private String name = "Vika";//�ֶ�
	private int age;
	private Date birthday;
	public String getName() {
		return name;
	}
	public void setName(String name) { //������ָsetter�Ͷ�ȡgetter�ֶεķ���
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
