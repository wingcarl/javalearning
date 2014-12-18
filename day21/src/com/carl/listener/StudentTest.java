package com.carl.listener;

public class StudentTest {

	public static void main(String[] args){
		Student s = new Student("GFY");
		s.addStudentListener(new StudentListener(){

			@Override
			public void preEat(StudentEvent e) {
				Student s = (Student)e.getSource();
				System.out.println("ma");
				
			}

			@Override
			public void preStudy(StudentEvent e) {
				Student s = (Student)e.getSource();
				System.out.println(s.getName()+"ma");
				
			}
			
		});
		s.eat();
		s.study();
	}
}
