package com.carl.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carl.model.Book;
import com.carl.model.Category;
import com.carl.service.CategoryService;
import com.carl.service.impl.CategoryServiceImpl;
import com.carl.util.WebUtil;

/**
 * Servlet implementation class ManagerServlet
 */
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private CategoryService cs = new CategoryServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if("addCategory".equals(operation))
			addCategory(request,response);
		if("showAllCategory".equals(operation))
			showAllCategory(request,response);
		if("showAllBookUI".equals(operation))
			showAllBookUI(request,response);
		if("addBook".equals(operation))
			addBook(request,response);
	}

	private void addBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Book b = WebUtil.fillBean(request, Book.class);	
		cs.addBook(b);
		request.getRequestDispatcher("/manager/addCategory.jsp").forward(request, response);
		
	}

	private void showAllBookUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Category> lc = cs.findAllCategory();
		request.setAttribute("cs", lc);
		request.getRequestDispatcher("/manager/addBook.jsp").forward(request, response);
		
	}

	private void showAllCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			List<Category> lc = cs.findAllCategory();
			request.setAttribute("cs", lc);
			request.getRequestDispatcher("/manager/listCategory.jsp").forward(request, response);

		
	}

	private void addCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Category c = WebUtil.fillBean(request, Category.class);
		cs.addCategory(c);
		request.getRequestDispatcher("/manager/addCategory.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
