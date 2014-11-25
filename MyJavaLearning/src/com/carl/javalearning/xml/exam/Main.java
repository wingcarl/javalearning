package com.carl.javalearning.xml.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args)  {
		try {
			StudentDao dao = new StudentDao();
			System.out.println("a、添加学生\tb、删除学生\tc、查询成绩");
			System.out.print("请输入操作类型：");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String operation = br.readLine();
			if("a".equals(operation)){
				System.out.println("请输入学生姓名");
				String name = br.readLine();
				System.out.println("请输入学生准考证号");
				String examid = br.readLine();
				System.out.println("请输入学生身份证号");
				String idcard = br.readLine();
				System.out.println("请输入学生所在地");
				String location = br.readLine();
				System.out.println("请输入学生成绩");
				String grade = br.readLine();
				Student s = new Student();
				s.setName(name);
				s.setGrade(Float.parseFloat(grade));
				s.setExamid(examid);
				s.setIdcard(idcard);
				s.setLocation(location);
				dao.addStudent(s);
				
			}else if("b".equals(operation)){
				
			}else if("c".equals(operation)){
				
			}else{
				System.out.println("请输入正确的操作类型");
			}
		} catch (IOException e) {
			System.out.println("对不起，服务器忙");
		}
	}
}
