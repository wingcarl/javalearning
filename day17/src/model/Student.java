package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable{

	private Integer id;
	private String name;
	private String grade;
	private List<Teacher> ts = new ArrayList<Teacher>();
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public List<Teacher> getTs() {
		return ts;
	}
	public void setTs(List<Teacher> ts) {
		this.ts = ts;
	}
	
}
