<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
Locale locale = Locale.US;
ResourceBundle rb = ResourceBundle.getBundle("resources.msg",locale);
%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=rb.getString("jsp.login.title") %></title>
</head>
<body>
<form action="">
	<%=rb.getString("jsp.login.username") %><input/><br/>
	<%=rb.getString("jsp.login.password") %><input type="password"/><br/>
	<input type="submit" value="<%=rb.getString("jsp.login.submit") %>"/>
</form>
</body>
</html>