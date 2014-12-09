package com.carl.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carl.model.Customer;
import com.carl.model.Pager;
import com.carl.service.CustomerService;
import com.carl.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class ShowAllCustomersServlet
 */
public class ShowAllCustomersServlet extends HttpServlet {
	private CustomerService s = new CustomerServiceImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllCustomersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Customer> cs = s.findAll();
//		request.setAttribute("cs", cs);
//		request.getRequestDispatcher("/listCustomers.jsp").forward(request, response);
		String pageNum = request.getParameter("pageNum");
		Pager page = s.findPageRecords(pageNum);
		page.setServletUrl("ShowAllCustomersServlet");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/listCustomers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
