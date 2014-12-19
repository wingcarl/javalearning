package com.carl.web.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carl.model.User;
import com.carl.service.UserService;
import com.carl.service.impl.UserServiceImpl;
import com.carl.util.SendMailThread;
import com.carl.util.WebUtil;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private UserService us = new UserServiceImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = WebUtil.fillBean(request, User.class);
		
		String code = UUID.randomUUID().toString();
		user.setCode(code);
		//发送邮件：启动一个新的线程
		SendMailThread smt  = new SendMailThread(user);
		smt.run();
		us.regist(user);
		response.sendRedirect(request.getContextPath());
		
		
	}

}
