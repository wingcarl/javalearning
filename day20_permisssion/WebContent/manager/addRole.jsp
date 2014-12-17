<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/manager/header.jsp" %>
<h1>添加角色</h1>
<form action="${pageContext.request.contextPath}/MyController?operation=addRole" method="post">
	<table width="88%" border=1>
	<tr>
		<td>角色名称</td>
		<td>
			<input type="text" name="name"/>
		</td>
	</tr>
	<tr>
		<td>描述</td>
		<td>
			<textarea rows="3" cols="38" name="description"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="保存">
		</td>
	</tr>
	</table>
	<a href="${pageContext.request.contextPath}/MyController?operation=listAllRole">返回</a>
</form>
</body>
</html>