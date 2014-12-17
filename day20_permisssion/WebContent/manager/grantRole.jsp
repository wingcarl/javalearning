<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/manager/header.jsp" %>
<h1>角色分配</h1>
<form action="${pageContext.request.contextPath}/MyController?operation=grantRole2User" method="post">
<input type="hidden" name="userId" value="${user.id}"/>
<table width="88%" border="1">
	<tr>
		<td colspan="2">
		用户名:${user.nick}
		</td>
	</tr>
	<tr>
		<td>已有角色</td>
		<td>
			<c:forEach items="${user.roles}" var="r">
				${r.name} <br/>
			</c:forEach>
		</td>
	</tr>
	<tr>
		<td>所有角色</td>
		<td>
			<c:forEach items="${roles}" var="m">
				<input type="checkbox" name="mIds" value="${m.id}"/>${m.name}<br/>
			</c:forEach>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="保存"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>