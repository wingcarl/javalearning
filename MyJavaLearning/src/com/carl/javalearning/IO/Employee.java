package com.carl.javalearning.IO;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Employee {

	public void writeData(PrintWriter out){
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(hireDay);
		out.println(name+"|"+salary+"|"+calendar.get(Calendar.YEAR)+"|"+(calendar.get(Calendar.MONTH)+1)+"|"+calendar.get(Calendar.DAY_OF_MONTH));
	}
	public void readData(Scanner in){
		String line = in.nextLine();
		String[] tokens = line.split(("\\|"));
		name = tokens[0];
		salary = Double.parseDouble(tokens[1]);
		int y = Integer.parseInt(tokens[2]);
		int m = Integer.parseInt(tokens[3]);
		int d = Integer.parseInt(tokens[4]);
		GregorianCalendar calendar = new GregorianCalendar(y,m-1,d);
		hireDay = calendar.getTime();
 	}
	
	public Employee(String name, double salary, int y,int m,int d) {
		super();
		this.name = name;
		this.salary = salary;
		GregorianCalendar calendar = new GregorianCalendar(y,m-1,d);
		this.hireDay = calendar.getTime();
	}

	private String name;
	private double salary;
	private Date hireDay;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getHireDay() {
		return hireDay;
	}
	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", hireDay="
				+ hireDay + "]";
	}
	
	
}
