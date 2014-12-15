package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import model.Department;
import model.Employee;

import org.junit.Test;

import dao.DepartmentDaoImpl;

public class DepartmentDaoImplTest {

	private DepartmentDaoImpl dao = new DepartmentDaoImpl();
	@Test
	public void testAddDepartment() throws SQLException {
		Department d= new Department();
		d.setId(1);
		d.setName("¿ª·¢²¿");
		
		Employee e1 = new Employee();
		e1.setId(1);
		e1.setName("gfy");
		e1.setSalary(8000);
		
		Employee e2 = new Employee();
		e2.setId(2);
		e2.setName("wxy");
		e2.setSalary(8000);
		
		d.getEmps().add(e1);
		d.getEmps().add(e2);
		
		dao.addDepartment(d);
	}

	@Test
	public void testFindDempartment() throws SQLException {
		Department d = dao.findDempartment(1);
		System.out.println(d.getName());
		List<Employee> emps = d.getEmps();
		for(Employee e:emps){
			System.out.println(e.getName());
		}
	}

}
