package com.carl.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carl.model.Cart;
import com.carl.service.BookService;
import com.carl.service.impl.BookServiceImpl;

/**
 * Servlet implementation class ChangeNumServlet
 */
public class ChangeNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeNumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private BookService bs = new BookServiceImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String bookId = request.getParameter("bookId");
			String newnum = request.getParameter("newnum");
			int num = Integer.parseInt(newnum);
			if(num<1){
				request.setAttribute("message", "<script type='text/javascript'>alert('请输入正整数')</script>");
			}else{
				request.removeAttribute("message");
			bs.findBookById(bookId);
			Cart cart = (Cart)request.getSession().getAttribute("cart");
			bs.changeCartItemNum(bookId,cart,Integer.parseInt(newnum));
			}
		} catch (NumberFormatException e) {
			request.setAttribute("message", "<script type='text/javascript'>alert('请输入正整数')</script>");
		}
		request.getRequestDispatcher("/WEB-INF/pages/showCart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
