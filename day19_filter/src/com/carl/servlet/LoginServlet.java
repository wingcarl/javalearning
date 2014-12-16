package com.carl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carl.autologin.MD5Util;
import com.carl.autologin.User;
import com.carl.autologin.UserDB;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = UserDB.findUser(username, password);
		if(user != null){
			request.getSession().setAttribute("user", user);
			String checked = request.getParameter("autologin");
			if(checked!=null){
				Cookie c = new Cookie("logininfo", username+"_"+MD5Util.md5(password));
				c.setMaxAge(Integer.MAX_VALUE);
				c.setPath(request.getContextPath());
				response.addCookie(c);
			}
		}
		response.sendRedirect(request.getContextPath()+"/autologin/index.jsp");
	}
		
}
