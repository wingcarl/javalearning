<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/manager/header.jsp" %>

<h1>菜单列表</h1><br/>
<a href="${pageContext.request.contextPath}/manager/addMenu.jsp">添加</a>
<c:if test="${empty menus}">
对不起，没有任何菜单
</c:if> 
<c:if test="${!empty menus}">
<table border="1" width="88%">
<tr>
<th>序号</th>
<th>菜单名称</th>
<th>URI</th>
<th>描述</th>
<th>操作</th>
</tr>
<c:forEach items="${menus }" var="m" varStatus="vs">
<tr bgcolor="${vs.index%2==0?'#749AA3':'#D4FC7E' }">
<td>${vs.count }</td>
<td>${m.name }</td>
<td>${m.uri }</td>
<td>${m.description }</td>
<td>
	<a href="#">修改</a>
	<a href="#">删除</a>
</td>
</tr>
</c:forEach>
</table>
</c:if>
</body>
</html>