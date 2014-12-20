<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/manager/header.jsp" %>
<h4>添加新分类</h4>
<form action="${pageContext.request.contextPath }/servlet/ManagerServlet?operation=addCategory" method="post">
	<table border="1" width="66%">
		<tr>
			<td>分类名称</td>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>描述</td>
			<td><textarea row="3" cols="38" name="description"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"></td>
			<td>
				<input type="submit" value="保存"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>