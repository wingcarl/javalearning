package com.carl.javalearning.xml.exam;

public class StudentDaoTest {
	public static void main(String[] args){
		StudentDao dao = new StudentDao();
//		Student s = new Student();
//		s.setIdcard("555");
//		s.setExamid("999");
//		s.setName("AZA");
//		s.setLocation("BLR");
//		s.setGrade(100);
//		dao.addStudent(s);
		dao.deleteStudent("999");
	}
}
