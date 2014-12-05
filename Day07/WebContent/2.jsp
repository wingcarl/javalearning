<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件下载</title>
</head>
<body>
<%
 InputStream in = new FileInputStream(application.getRealPath("/logo.png"));
 response.setHeader("Content-Disposition", "attachment;filenae=logo.png");
 
 OutputStream sout = response.getOutputStream();
 int len = -1;
 byte b[] = new byte[1024];
 while((len=in.read(b))!=-1){
	 sout.write(b);
 }
 in.close();
%>
</body>
</html>