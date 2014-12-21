<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="text-align: center">
<br/>
<h1>网上书店后台管理</h1>
<div align="left" style="background-color: #CFCFCF">
	&nbsp;&nbsp;<a href="javascript:showMenu('category')">分类管理</a>&nbsp;&nbsp;
	&nbsp;&nbsp;<a href="javascript:showMenu('book')">图书管理</a>&nbsp;&nbsp;
	&nbsp;&nbsp;<a href="javascript:showMenu('order')">订单管理</a>&nbsp;&nbsp;
</div>
<div align="left" id="category" style="display:none";background-color: #CFCFCF>
	&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/manager/addCategory.jsp">添加分类</a>&nbsp;&nbsp;
	&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/servlet/ManagerServlet?operation=showAllCategory">查询分类</a>&nbsp;&nbsp;
</div>
<div align="left" id="book" style="display:none";background-color: #CFCFCF>
	&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/servlet/ManagerServlet?operation=showAllBookUI">添加图书</a>&nbsp;&nbsp;
	&nbsp;&nbsp;<a href="#">查询图书</a>&nbsp;&nbsp;
</div>
<div align="left" id="order" style="display:none";background-color: #CFCFCF>
	&nbsp;&nbsp;<a href="#">待处理订单</a>&nbsp;&nbsp;
	&nbsp;&nbsp;<a href="#">已处理订单</a>&nbsp;&nbsp;
</div>

<script type="text/javascript">

	function showMenu(divId){
		var divObj = document.getElementById(divId);
		divObj.style.display='block';
	}
</script>
 <script src="${pageContext.request.contextPath}/dist/js/jquery-1.11.2.min.js"></script>
 <script src="${pageContext.request.contextPath}/dist/js/bootstrap.min.js"></script>