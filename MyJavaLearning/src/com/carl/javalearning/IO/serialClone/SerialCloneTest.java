package com.carl.javalearning.IO.serialClone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 利用序列化来实现深度拷贝（拷贝之后的对象与原来的对象是独立的栈空间）
 * 方法实现一个SerialClone并实现Cloneable和Serializable
 * @author dell-pc
 *
 */
public class SerialCloneTest {
	
	public static void main(String[] args){
		Employee harry = new Employee("Harry Hacker",35000,1989,10,1);
		Employee harry2 = (Employee)harry.clone();
		
		harry.raiseSalary(10);
		System.out.println(harry);
		System.out.println(harry2);
		
	}
}
	class SerialClone implements Cloneable,Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Object clone(){
			try{
				ByteArrayOutputStream bout = new ByteArrayOutputStream();
				ObjectOutputStream out = new ObjectOutputStream(bout);
				out.writeObject(this);
				out.close();
				
				ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
				ObjectInputStream in = new ObjectInputStream(bin);
				Object ret = in.readObject();
				return ret;
			}catch(Exception e){
				return null;
			}
		}
	}
	
	class Employee extends SerialClone
	{
	   private String name;
	   private double salary;
	   private Date hireDay;

	   public Employee()
	   {
	   }

	   public Employee(String n, double s, int year, int month, int day)
	   {
	      name = n;
	      salary = s;
	      GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
	      hireDay = calendar.getTime();
	   }

	   public String getName()
	   {
	      return name;
	   }

	   public double getSalary()
	   {
	      return salary;
	   }

	   public Date getHireDay()
	   {
	      return hireDay;
	   }

	   public void raiseSalary(double byPercent)
	   {
	      double raise = salary * byPercent / 100;
	      salary += raise;
	   }

	   public String toString()
	   {
	      return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay
	            + "]";
	   }
	   public static final int NAME_SIZE = 40;
	   public static final int RECORD_SIZE = 2 * NAME_SIZE + 8 + 4 + 4 + 4;
	} 
