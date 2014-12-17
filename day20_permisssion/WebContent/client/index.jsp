<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎光临</title>
</head>
<body>
<c:if test="${sessionScope.user==null}">
	<a href="">登录</a>
</c:if>
<c:if test="${!sessionScope.user==null}">
	欢迎您：${sessionScope.user.nick}&nbsp;&nbsp;<a href="">注销</a>
</c:if>
<hr/>
<c:forEach items="${menus }" var="m">
	<c:url value="${m.uri }" var="url"></c:url>
	<a href="${url }">${m.name }</a>&nbsp;&nbsp;

</c:forEach>
</body>
</html>