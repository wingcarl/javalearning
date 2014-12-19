package com.carl.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carl.exception.CodeInvalidateException;
import com.carl.service.UserService;
import com.carl.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ActivitedServlet
 */
public class ActivitedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivitedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		if(code!=null){
			try{
				us.active(code);
			}catch(CodeInvalidateException e){
				request.setAttribute("message", e.getMessage());
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}
			request.setAttribute("message", "激活成功");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}else{
			request.setAttribute("message", "激活码不存在");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
