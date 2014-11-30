package com.carl.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseDemo
 */
public class ResponseDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		test2(response);
		
	}

	private void test1(HttpServletResponse response) throws IOException {
		String s = "ss���͵�·�ڸ���";
		ServletOutputStream out = response.getOutputStream();
		out.write(s.getBytes());
	}
	//���ֽ�����UTF-8���
	private void test2(HttpServletResponse response) throws IOException {
		String s = "ss���͵�·�ڸ���";
		ServletOutputStream out = response.getOutputStream();
		//��ʽһ֪ͨ���������ĳ�ֱ��뷽ʽ����
		//response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//��ʽ��
		out.write("<meta http-equiv='Content-Type' content='text/html;charset=UTF-8'>".getBytes("UTF-8"));
		out.write(s.getBytes("UTF-8"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
