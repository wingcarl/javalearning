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
	<c:if test="${sessionScope.user==null}">
		<a href="${pageContext.request.contextPath}/autologin/login.jsp">登录</a>
	</c:if>
	<c:if test="${sessionScope.user!=null}">
		欢迎你：${sessionScope.user.nick }
	</c:if>
	<hr/>
	网站主页<br/>
	<a href="${pageContext.request.contextPath}/autologin/1.jsp">其他页面</a>
</body>
</html>