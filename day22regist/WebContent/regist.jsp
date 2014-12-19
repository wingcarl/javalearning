<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/RegistServlet" method="post">
		<table border="1" width="88%">
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>昵称</td>
				<td><input type="text" name="nick"/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"/></td>
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