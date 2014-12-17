<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/manager/header.jsp" %>
	<h1>角色列表</h1><br/>
<a href="${pageContext.request.contextPath}/manager/addRole.jsp">添加</a><br/>
<c:if test="${empty roles}">
没有角色
</c:if>
<c:if test="${!empty roles}">
<table border="1" width="88%">
	<tr>
		<th>id</th>
		<th>name</th>
		<th>description</th>
	</tr>
<c:forEach items="${roles}" var="r" varStatus="vs">
	<tr bgcolor="${vs.index%2==0?'#749AA3':'#D4FC7E' }">
		<td>${vs.count }</td>
		<td>${r.name }</td>
		<td>${r.description}</td>
		<td>
		<a href="${pageContext.request.contextPath}/MyController?operation=grantMenu2RoleUI&roleId=${r.id}">菜单分配</a>
		<a href="#">修改</a>
		<a href="#">删除</a>
</td>
	</tr>
</c:forEach>
</table>
</c:if>
</body>
</html>