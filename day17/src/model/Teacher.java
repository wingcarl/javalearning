package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Teacher implements Serializable{

	private Integer id;
	private String name;
	private float money;
	private List<Student> stus = new ArrayList<Student>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public List<Student> getStus() {
		return stus;
	}
	public void setStus(List<Student> stus) {
		this.stus = stus;
	}
	
	
}
