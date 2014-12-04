package com.carl.cookie.app1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowBookDetail
 */
public class ShowDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		Book book = BookDb.findBookById(id);
		out.write(book.getId()+"<br/>");
		out.write(book.getName()+"<br/>");
		out.write(book.getAuthor()+"<br/>");
		out.write(book.getPrice()+"<br/>");
		out.write(book.getDescription()+"<br/>");
		Cookie cookies[] = request.getCookies();
		String cookieValue = makeIds(request,id);
		
		Cookie cookie = new Cookie("bookHistory",cookieValue);
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(cookie);
	}

	private String makeIds(HttpServletRequest request,String id){
		Cookie cookies[] = request.getCookies();
		if(cookies==null){
			return id;
		}
		Cookie c = null;
		for(Cookie cookie : cookies){
			if("bookHistory".equals(cookie.getName())){
				c = cookie;
				break;
			}
		}
		if(c == null)
			return id;
		String value = c.getValue();
		String[] ids = value.split("\\-");
		LinkedList<String> ll = new LinkedList<String>(Arrays.asList(ids));
		if(ll.size() < 3){
			if(ll.contains(id)){
				ll.remove(id);
				ll.addFirst(id);
			}
			ll.addFirst(id);
		}
		else{
			if(ll.contains(id)){
				ll.remove(id);
			}
			else{
				ll.removeLast();
			}
			ll.addFirst(id);
		}
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<ll.size(); i++){
			if(i>0){
				sb.append("-");
			}
			sb.append(ll.get(i));
		}
		return sb.toString();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
