package com.carl.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.carl.model.Customer;
import com.carl.service.CustomerService;
import com.carl.service.impl.CustomerServiceImpl;
import com.carl.util.FormBeanUtil;
import com.carl.web.formbean.CustomerFormBean;

/**
 * Servlet implementation class UpdateCustomerServlet
 */
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerService service = new CustomerServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try{
		CustomerFormBean formBean = FormBeanUtil.fillFormBean(CustomerFormBean.class, request);
		if(!formBean.validate()){
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/editCustomer.jsp").forward(request, response);
			return;
		}
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		Customer c = new Customer();
		BeanUtils.copyProperties(c, formBean);
		service.updateCustomer(c);
		request.setAttribute("message", "修改成功");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		}catch(Exception e){
			request.setAttribute("message", "对不起！服务器忙");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
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
