package com.carl.javalearning.xml.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args)  {
		try {
			StudentDao dao = new StudentDao();
			System.out.println("a�����ѧ��\tb��ɾ��ѧ��\tc����ѯ�ɼ�");
			System.out.print("������������ͣ�");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String operation = br.readLine();
			if("a".equals(operation)){
				System.out.println("������ѧ������");
				String name = br.readLine();
				System.out.println("������ѧ��׼��֤��");
				String examid = br.readLine();
				System.out.println("������ѧ�����֤��");
				String idcard = br.readLine();
				System.out.println("������ѧ�����ڵ�");
				String location = br.readLine();
				System.out.println("������ѧ���ɼ�");
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
				System.out.println("��������ȷ�Ĳ�������");
			}
		} catch (IOException e) {
			System.out.println("�Բ��𣬷�����æ");
		}
	}
}
