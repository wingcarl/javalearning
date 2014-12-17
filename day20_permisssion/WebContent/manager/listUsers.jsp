<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/manager/header.jsp" %>
	<h1>用户列表</h1><br/>
<a href="${pageContext.request.contextPath}/manager/addUser.jsp">添加</a><br/>
<c:if test="${empty users}">
没有用户
</c:if>
<c:if test="${!empty users}">
<table border="1" width="88%">
	<tr>
		<th>id</th>
		<th>username</th>
		<th>nick</th>
	</tr>
<c:forEach items="${users}" var="r" varStatus="vs">
	<tr bgcolor="${vs.index%2==0?'#749AA3':'#D4FC7E' }">
		<td>${vs.count }</td>
		<td>${r.username }</td>
		<td>${r.nick}</td>
		<td>
		<a href="${pageContext.request.contextPath}/MyController?operation=grantRole2UserUI&userId=${r.id}">菜单分配</a>
		<a href="#">修改</a>
		<a href="#">删除</a>
</td>
	</tr>
</c:forEach>
</table>
</c:if>
</body>
</html>