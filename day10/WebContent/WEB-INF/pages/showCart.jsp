<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示购物车</title>
<script type="text/javascript">
	function changeNum(inputObj,bookId,oldNum){
		var newnum = inputObj.value;
		var sure = window.confirm("Are you sure to change the book number to"+newnum+"?");
		if(sure){
			window.location.href="${pageContext.request.contextPath}/ChangeNumServlet?bookId="+bookId+"&newnum="+newnum;
		}
		else{
			inputObj.value = oldNum;
		}
	}
</script>
</head>
<body style="text-align: center;">
	<h1>您购买的商品如下</h1>
	<c:if test="${empty sessionScope.cart.items }">
		Sorry,you didn't buy any items.
	</c:if>
	<c:if test="${!empty sessionScope.cart.items }">
		<table border="1" width="88%">
			<tr>
				<th>序号</th>
				<th>书名</th>
				<th>单价</th>
				<th>数量</th>
				<th>小计</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${sessionScope.cart.items}" var="me" varStatus="vs">
			<tr bgcolor="${vs.index%2==0?'#CCCCCC':'#6081A3' }">
				<td>${vs.count }</td>
				<td>${me.value.book.name }</td>
				<td>${me.value.book.price }</td>
				<td><input type="text" name="num" value=${me.value.num} size="3" onchange="changeNum(this,'${me.key}',${me.value.num})"></td>
				<td>${me.value.price }</td>
				<td><a href="${pageContext.request.contextPath}/DeleteCartServlet?bookId=${me.key}" >删除</a></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="2"><a href="#">清空购物车</a></td>
				<td colspan="2"><a href="#">总计</a></td>
				<td colspan="2">${sessionScope.cart.price}<a href="#"/></td>
			</tr>
		</table>
	</c:if>
	<a href="${pageContext.request.contextPath}">继续购物</a>
	${message } 
</body>
</html>