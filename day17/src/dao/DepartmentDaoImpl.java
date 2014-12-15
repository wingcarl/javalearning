/**
 * 
 */
package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import util.DbcpUtil;
import model.Department;
import model.Employee;

/**
 * @author dell-pc
 *
 */
public class DepartmentDaoImpl {

	private QueryRunner qr = new QueryRunner(DbcpUtil.getDataSource()); 
	public void addDepartment(Department dept) throws SQLException{
		qr.update("insert into department (id,name) values(?,?)",dept.getId(),dept.getName());
		List<Employee> emps = dept.getEmps();
		if(emps != null && emps.size()>0){
			Object params[][] = new Object[emps.size()][];
			for(int i=0;i<params.length;i++){
				params[i] = new Object[]{emps.get(i).getId(),emps.get(i).getName(),emps.get(i).getSalary(),dept.getId()};
			}
			qr.batch("insert into employee(id,name,salary,dept_id) values(?,?,?,?)", params);
		}
	}
	public Department findDempartment(Integer id) throws SQLException{
		Department d = qr.query("select * from department where id=?", new BeanHandler<Department>(Department.class),id);
		if(d!=null){
			List<Employee> emps = qr.query("select * from employee where dept_id = ?", new BeanListHandler<Employee>(Employee.class),id);
			d.setEmps(emps);
		}
		return d;
	}
}
