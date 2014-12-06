<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XX论坛</title>
</head>
<body>
<c:if test="${sessionScope.user==null }">
	<a href="${pageContext.request.contextPath}/login.jsp">login</a>
	<a href="${pageContext.request.contextPath}/regist.jsp">regist</a>
</c:if>
<c:if test="${sessionScope.user!=null }">
欢迎您：${sessionScope.user.nick==""?sessionScope.user.username:sessionScope.user.nick}&nbsp;&nbsp; <a href="#"></a>
</c:if>
<hr/>
<h1>欢迎光临</h1>
</body>
</html>