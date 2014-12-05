package com.carl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.carl.domain.User;
import com.carl.domain.UserDB;

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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String code = request.getParameter("code");
		User user = UserDB.findUser(username, password);
		if(code.equals(request.getSession().getAttribute("code"))){
		if(user != null){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//转向主页：IndexServlet
			response.sendRedirect(request.getContextPath()+"/IndexServlet");
			
		}
		else{
			out.write("错误的用户名和密码");
			return;
		}
		}
		else{
			out.write("错误的验证码");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/login.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
