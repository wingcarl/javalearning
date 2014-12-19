<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
	<c:if test="${sessionScope.user==null }">
		<a href="${pageContext.request.contextPath}/login.jsp">登录</a>&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath}/regist.jsp">还木有账号</a>
	</c:if>
	<c:if test="${sessionScope.user != null }">
		欢迎您:${sessionScope.user.nick}&nbsp;&nbsp;
	</c:if>
</body>
</html>