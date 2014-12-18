package com.carl.listener;

public class Student {

	private String name;
	private StudentListener listener;
	public Student(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void eat(){
		if(listener != null){
			listener.preEat(new StudentEvent(this));
		}
		System.out.println("��ʼ��");
	}
	public void study(){
		if(listener != null){
			listener.preStudy(new StudentEvent(this));
		}

		System.out.println("��ʼѧ");
	}
	public void addStudentListener(StudentListener listener){
		this.listener = listener;
	}
	
}
