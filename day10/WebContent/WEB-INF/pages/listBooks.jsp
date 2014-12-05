<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有书籍列表</title>
</head>
<body style="text-align: center;">
<br/>
<h1>本站有以下好书</h1>
<table border="1" width="88%">
	<tr>
		<th>序号</th>
		<th>ISBN</th>
		<th>书名</th>
		<th>作者</th> 
		<th>单价</th>
		<th>描述</th>
		<th>购买</th>
	</tr>
	<c:forEach items="${books }" var="me" varStatus="vs">
		<tr bgcolor="${vs.index%2==0?'#CCCCCC':'#6081A3' }">
		<td>${vs.count}</td>
		<td>${me.value.isbn }</td>
		<td>${me.value.name }</td>
		<td>${me.value.author }</td>
		<td>${me.value.price }</td>
		<td>${me.value.description }</td>
		<td>
		[<a href="${pageContext.request.contextPath}/BuyServlet?bookId=${me.key}">购买</a>]
		</td>
	</tr>
	</c:forEach>
</table>
<a href="${pageContext.request.contextPath}/ShowCartServlet">查看购物车</a>

</body>
</html>