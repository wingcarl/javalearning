<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/manager/header.jsp" %>
<h1>添加用户</h1>
<form action="${pageContext.request.contextPath}/MyController?operation=addUser" method="post">
	<table width="88%" border=1>
	<tr>
		<td>用户名</td>
		<td>
			<input type="text" name="username"/>
		</td>
	</tr>
	<tr>
		<td>用户密码</td>
		<td>
			<input type="password" name="password"/>
		</td>
	</tr>
	<tr>
		<td>昵称</td>
		<td>
			<input type="text" name="nick"/>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="保存">
		</td>
	</tr>
	</table>
	<a href="${pageContext.request.contextPath}/MyController?operation=listAllUser">返回</a>
</form>
</body>
</html>