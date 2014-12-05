package com.carl.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carl.model.Book;
import com.carl.service.BookService;
import com.carl.service.impl.BookServiceImpl;

/**
 * Servlet implementation class ShowAllBooksServlet
 */
//控制器，查询所有的书籍
public class ShowAllBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookService bs = new BookServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,Book> books = bs.findAllBooks();
		request.setAttribute("books", books);
		request.getRequestDispatcher("/WEB-INF/pages/listBooks.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
