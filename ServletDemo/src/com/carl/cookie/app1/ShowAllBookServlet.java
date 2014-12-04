package com.carl.cookie.app1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowAllBookServlet
 */
public class ShowAllBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<h1>本站有以下好书</h1>");
		Map<String,Book> books = BookDb.findAllBooks();
		for(Map.Entry<String, Book> me : books.entrySet()){
			out.write("<a href='"+request.getContextPath()+"/ShowDetailServlet?id="+me.getKey()+"' target='_blank'>"+me.getValue().getName()+"</a><br/>");
		}
		out.write("您最近的浏览记录是:<br/><hr/>");
		Cookie cookies[] = request.getCookies();
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if("bookHistory".equals(cookies[i].getName())){
				String value = cookies[i].getValue();
				String ids[] = value.split("\\-");
				for(String sid:ids){
				out.write(BookDb.findBookById(sid).getName()+"<br/>");
				}
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
