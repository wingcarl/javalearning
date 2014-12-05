<%@page import="com.carl.servlet.Book"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍列表</title>
</head>
<body>
<h1>本站有以下好书</h1>
<table border="1" width="88%">
	<tr>
		<th>书名</th>
		<th>作者</th>
		<th>售价</th>
		<th>简介</th>
	</tr>
	<%
		Map<String,Book> books = (Map<String,Book>)request.getAttribute("books");
	for(Map.Entry<String,Book> me:books.entrySet()){
		Book book = me.getValue();
	
	
	%>
	<tr>
		<td><%=book.getName() %></td>
		<td><%=book.getAuthor() %></td>
		<td><%=book.getPrice() %></td>
		<td><%=book.getDescription() %></td>
	</tr>
	<%
	}
	%>
</table>
</body>
</html>