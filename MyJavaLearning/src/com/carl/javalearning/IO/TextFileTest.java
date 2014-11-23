package com.carl.javalearning.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TextFileTest {

	public static void main(String[] args){
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Carl Cracker",75000,1987,12,15);
		staff[1] = new Employee("Harry Hacker",50000,1989,10,1);
		staff[2] = new Employee("Tony Tester",40000,1990,3,15);
		
		try(PrintWriter out = new PrintWriter("employee.dat","UTF-8")){
			writeData(staff,out);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try(Scanner in = new Scanner(new FileInputStream("employee.dat"),"UTF-8")){
			Employee[] newStaff = readData(in);
			in.close();
			for(Employee e : newStaff) {
				System.out.println(e);
			}
 		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}
	
	public static void writeData(Employee[] employees,PrintWriter out){
		out.println(employees.length);
		for(Employee employee : employees){
			writeEmployee(employee,out);
		}
	}
	public static void writeEmployee(Employee employee,PrintWriter out){
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(employee.getHireDay());
		out.println(employee.getName()+"|"+employee.getSalary()+"|"
	+calendar.get(Calendar.YEAR)+"|"+(calendar.get(Calendar.MONTH)+1)+"|"+calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	public static Employee[] readData(Scanner in) {
		int n = in.nextInt();
		in.nextLine();
		Employee[] employees = new Employee[n];
		for(int i=0; i<n; i++){
			employees[i] = readEmployee(in);
		}
		return employees;
	}
	public static Employee readEmployee(Scanner in){
		
		String line = in.nextLine();
		String[] tokens = line.split("\\|");
		Employee employee = new Employee(tokens[0],Double.parseDouble(tokens[1]),Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3])-1,Integer.parseInt(tokens[4]));
		return employee;
	}
	
}
