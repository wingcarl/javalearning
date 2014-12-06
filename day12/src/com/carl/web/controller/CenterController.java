package com.carl.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.carl.exception.UsernameExistException;
import com.carl.model.User;
import com.carl.service.UserService;
import com.carl.service.impl.UserServiceImpl;
import com.carl.util.WebFormBeanUtils;

/**
 * Servlet implementation class CenterController
 */
public class CenterController extends HttpServlet {
	private String encoding = "UTF-8";
	private static final long serialVersionUID = 1L;
    private UserService us = new UserServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CenterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		String operation = request.getParameter("operation");
		if("regist".equals(operation)){
			regist(request,response);
		}
	}

	private void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String result;
		try {
			result = "";
			RegistFormBean formBean = WebFormBeanUtils.fillFormBean(request, RegistFormBean.class); 
			
			if(!formBean.validate()){
				request.setAttribute("formBean", formBean);
				result = "/regist.jsp";
			}else{
				User user = new User();
				ConvertUtils.register(new DateLocaleConverter(), Date.class);
				BeanUtils.copyProperties(user, formBean);
				us.regist(user);
			}
			request.getRequestDispatcher(result).forward(request, response);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsernameExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
