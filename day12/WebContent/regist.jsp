<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Regist</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/CenterController?operation=regist" method="post">
		<table border="1" width="58%">
			<tr>
			<td>*用户名(3-8字母)</td>
			<td>
				<input type="text" name="username" value="${formBean.username }"/>${formBean.errors.username }
			</td>
			</tr>
			<tr>
			<td>昵称</td>
			<td>
				<input type="text" name="nickname" value="${formBean.nickname }"/>
			</td>
			</tr>
			<tr>
			<td>*密码</td>
			<td>
				<input type="password" name="password" value=""/>${formBean.errors.password }
			</td>
			</tr>
			<tr>
			<td>*重复密码</td>
			<td>
				<input type="password" name="password1" value=""/>${formBean.errors.password1 }
			</td>
			</tr>
			<tr>
			<td>邮箱</td>
			<td>
				<input type="text" name="email" value="${formBean.email }"/>${formBean.errors.email }
			</td>
			</tr>
			<tr>
			<td>*出生日期</td>
			<td>
				<input type="text" name="birthday" value="${formBean.birthday }"/>${formBean.errors.birthday }
			</td>
			</tr>
			<tr>
			<td colspan="2" align="center">
			<input type="submit" value="提交"/>
			</td>
			</tr>
		</table>
	</form>
</body>
</html>