package com.carl.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo1
 */
public class ServletDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServletConfig config;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = config.getServletName();
		System.out.println(name);
		Enumeration<String> e = config.getInitParameterNames();
		while(e.hasMoreElements()){
			String paramName = e.nextElement();
			System.out.println(paramName+"="+config.getInitParameter(paramName));
		}
	}

	/**
	 * 获取properties资源 
	 * 1.加载ServletContext
	 * 2.加载getRealPath
	 * 3.获取Properties 并load资源 通过getProperty(键名)获取字符串 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private void test1() throws IOException, FileNotFoundException {
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/WEB-INF/a1.properties");
		Properties props = new Properties();
		props.load(new FileInputStream(path));
		String name = props.getProperty("username");
		System.out.println(name);
	}
	
	private void test2() throws IOException, FileNotFoundException {
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/WEB-INF/classes/a2.properties");
		Properties props = new Properties();
		props.load(new FileInputStream(path));
		String name = props.getProperty("username");
		System.out.println(name);
	}
	
	private void test3() throws IOException, FileNotFoundException {
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/WEB-INF/classes/com/carl/servlet/a3.properties");
		Properties props = new Properties();
		props.load(new FileInputStream(path));
		String name = props.getProperty("username");
		System.out.println(name);
	}
	
	private void test4() throws IOException, FileNotFoundException {
		ResourceBundle rb = ResourceBundle.getBundle("com.carl.servlet.a3");
		String value = rb.getString("username");
		System.out.println(value);
	}
	
	private void test5() throws IOException, FileNotFoundException {
		ClassLoader c1 = ServletDemo1.class.getClassLoader();
		InputStream in = c1.getResourceAsStream("a2.properties");
		Properties props = new Properties();
		props.load(in);
		String name = props.getProperty("username");
		System.out.println(name);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
