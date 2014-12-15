package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import model.Student;
import model.Teacher;

import org.junit.Test;

import dao.TeacherDaoImpl;

public class TeacherDaoImplTest {

	TeacherDaoImpl dao = new TeacherDaoImpl();
	@Test
	public void testAddTeacher() throws SQLException {
//		Teacher t1 = new Teacher();
//		t1.setId(1);
//		t1.setName("bxd");
//		t1.setMoney(20000);
//		
//		Teacher t2 = new Teacher();
//		t2.setId(2);
//		t2.setName("wzt");
//		t2.setMoney(15000);
//		
//		Student s1 = new Student();
//		s1.setId(1);
//		s1.setName("gfy");
//		s1.setGrade("A");
//		
//		Student s2 = new Student();
//		s2.setId(2);
//		s2.setName("wxy");
//		s2.setGrade("E");
//		
//		t1.getStus().add(s1);
//		t1.getStus().add(s2);
//		t2.getStus().add(s1);
//		t2.getStus().add(s2);
//		
//		dao.addTeacher(t1);
//		dao.addTeacher(t2);
		
		Teacher t = dao.findTeacher(1);
		System.out.println(t.getName());
		List<Student> stus = t.getStus();
		for(Student s:stus){
			System.out.println(s.getName());
		}
	}

}
