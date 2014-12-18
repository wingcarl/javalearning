package com.carl.listener;

public class StudentEvent {

	private Object source;

	public Object getSource() {
		return source;
	}
	
	public StudentEvent(Object source){
		this.source = source;
	}
}
