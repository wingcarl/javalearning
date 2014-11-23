package com.carl.javalearning.IO;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class RandomAccessTest {

	public static void main(String[] args) throws IOException {
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Carl Cracker",75000,1987,12,15);
		staff[1] = new Employee("Harry Hacker",50000,1989,10,1);
		staff[2] = new Employee("Tony Tester",40000,1990,3,15);
		
		try(DataOutputStream out = new DataOutputStream(new FileOutputStream("employee.dat"))){
			writeData(staff,out);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try(RandomAccessFile in = new RandomAccessFile("employee.dat","r")){
			int n = (int) (in.length()/Employee.RECORD_SIZE);
			Employee[] newStaff = new Employee[n];
			 for (int i = n - 1; i >= 0; i--)
	         {  
	            newStaff[i] = new Employee();
	            in.seek(i * Employee.RECORD_SIZE);
	            newStaff[i] = readEmployee(in);
	         }
	         
	         // print the newly read employee records
	         for (Employee e : newStaff) 
	            System.out.println(e);
			
			
 		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}
	
	public static void writeData(Employee[] employees,DataOutput out) throws IOException{
		for(Employee employee : employees){
			writeEmployee(employee,out);
		}
	}
	public static void writeEmployee(Employee employee,DataOutput out) throws IOException{
		DataIO.writeFixedString(employee.getName(), Employee.NAME_SIZE, out);
		out.writeDouble(employee.getSalary());
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(employee.getHireDay());
		out.writeInt(calendar.get(Calendar.YEAR));
		out.writeInt(calendar.get(Calendar.MONTH)+1);
		out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	
	public static Employee readEmployee(DataInput in) throws IOException{
		String name = DataIO.readFixedString(Employee.NAME_SIZE, in);
		double salary = in.readDouble();
		int y = in.readInt();
		int m = in.readInt();
		int d = in.readInt();
		return new Employee(name,salary,y,m-1,d);
		
	}
	
}
