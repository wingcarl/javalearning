<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Customer</title>
</head>
<body style="text-align:center;">
	<form action="${ pageContext.request.contextPath}/UpdateCustomerServlet" method="post">
	<input type="hidden" name="id" value="${c.id }"/>
	<table border="1" width="88%">
		<tr>
			<td>Name</td>
			<td><input type="text" name="name" value="${c.name }${formBean.name}"/></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>
				<input type="radio" value="1" name="gender" ${c.gender=="1"?"checked='checked'":""}${formBean.gender=="1"?"checked='checked'":""}/>male
				<input type="radio" value="0" name="gender" ${c.gender=="0"?"checked='checked'":""}${formBean.gender=="0"?"checked='checked'":""}/>female
			</td>
		</tr>
		<tr>
			<td>Birthday</td>
			<td><input type="text" name="birthday" value="${formBean.birthday}${c.birthday }"/>${formBean.errors.birthday }</td>
		</tr>
		<tr>
			<td>cellPhone</td>
			<td><input type="text" name="cellphone" value="${c.cellphone }${formBean.cellphone }"/></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email" value="${c.email }${formBean.email }"/></td>
		</tr>
		<tr>
			<td>Hobby</td>
			<td><input type="text" name="hobby" value="${c.hobby }${formBean.hobby}"/></td>
		</tr>
		<tr>
			<td>Type</td>
			<td>
			<input type="radio" name="type" value="Normal" ${c.type=='Normal'?'checked="checked"':'' } />Normal
			<input type="radio" name="type" value="VIP" ${c.type=='VIP'?'checked="checked"':'' }/>VIP
			</td>
		</tr>
		<tr>
			<td>Description</td>
			<td>
			<textarea name="description" rows="3" cols="48"  >${c.description}</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="SUBMIT"/>
			</td>
			
		</tr>
		</table>
	</form>
</body>
</html>