package com.carl.javalearning.xml.exam;

public class Student {

	private String idcard;
	private String examid;
	private String name;
	private String location;
	private float grade;
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getExamid() {
		return examid;
	}
	public void setExamid(String examid) {
		this.examid = examid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getGrade() {
		return grade;
	}
	public void setGrade(float grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Student [idcard=" + idcard + ", examid=" + examid + ", name="
				+ name + ", location=" + location + ", grade=" + grade + "]";
	}
	
}
