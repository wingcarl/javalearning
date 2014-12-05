package com.carl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carl.domain.User;
import com.carl.domain.UserDB;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();	
		User user = (User)request.getSession().getAttribute("user");
		if(user == null){
			out.write("<a href='"+request.getContextPath()+"/login.html'>µÇÂ¼</a>");
		}
		else{
			out.write("»¶Ó­Äú: "+user.getUsername());
			out.write("<a href='"+request.getContextPath()+"/LogoutServlet'>×¢Ïú</a>");
		}
		out.write("<hr/>ÕâÊÇÖ÷Ò³");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
