package com.carl.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carl.model.Customer;
import com.carl.service.CustomerService;
import com.carl.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class UpdateCustomerServletUI
 */
public class UpdateCustomerServletUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerServletUI() {
        super();
        // TODO Auto-generated constructor stub
    }
    private CustomerService service = new CustomerServiceImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerId = request.getParameter("customerId");
		Customer c = service.findCustomerById(customerId);
		request.setAttribute("c", c);
		request.getRequestDispatcher("/editCustomer.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
