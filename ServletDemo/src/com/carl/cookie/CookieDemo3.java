package com.carl.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 展示登录界面，读取指定的cookie
 */
public class CookieDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieDemo3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String username = "";
		String checked = "";
		for(int i=0; cookies!=null&&i<cookies.length; i++){
			Cookie c = cookies[i];
			if(c.getName().equals("username")){
				username = c.getValue();
				checked = "checked='checked'";
				break;
			}
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<form action='"+request.getContextPath()+"/CookieDemo2' method='post'>");
		out.write("username:<input type='text' name='username' value='"+username+"'/><br/>");
		out.write("password:<input type='password' name='password' value=''/><br/>");
		out.write("remember:<input type='checkbox' name='remember' value=''"+checked+"/><br/>");
		out.write("<input type='submit' value='save'/></form>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
