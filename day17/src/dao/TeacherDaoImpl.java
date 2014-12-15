package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import util.DbcpUtil;
import model.Student;
import model.Teacher;

public class TeacherDaoImpl {

	/**
	 * 保存老师的基本信息
	 * 判断t中是否有学生
	 * 有学生，判断是否在student表中
	 * 在第三方表中建立老师学生的关联关系
	 * @param t 
	 */
	private QueryRunner qr = new QueryRunner(DbcpUtil.getDataSource());
	public void addTeacher(Teacher t) throws SQLException{
		qr.update("insert into teacher(id,name,money) values(?,?,?)",t.getId(),t.getName(),t.getMoney());
		List<Student> stus = t.getStus();
		if(stus!= null && stus.size()>0){
			for(Student s:stus){
				Long num = (Long)qr.query("select count(*) from student where id=?", new ScalarHandler(1),s.getId());
				if(num < 1){
					qr.update("insert into student(id,name,grade) values(?,?,?)",s.getId(),s.getName(),s.getGrade());
				}
				qr.update("insert into teacher_student(t_id,s_id) values(?,?)", t.getId(),s.getId());
			}
		}
		
		
	}
	public Teacher findTeacher(Integer id) throws SQLException{

		Teacher t = qr.query("select * from teacher where id=?", new BeanHandler<Teacher>(Teacher.class),id);
		if(t!=null){
			List<Student> stus = qr.query("select * from student where id in(select s_id from teacher_student where t_id=?)", new BeanListHandler<Student>(Student.class),id);
			t.setStus(stus);
		}
		return t;
	}
}
