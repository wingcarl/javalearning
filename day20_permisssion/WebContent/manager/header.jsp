<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<style type="text/css" >
	.menu{
	background-color: red
	}
</style>
<div class="menu" >
	<a href="${pageContext.request.contextPath}/MyController?operation=listAllMenus">菜单管理</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/MyController?operation=listAllRole">角色管理</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/MyController?operation=listAllUser">用户管理</a>
</div>
<hr/>
