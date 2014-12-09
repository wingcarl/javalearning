<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有用户列表</title>
</head>
<body>
<form id="f1" action="${pageContext.request.contextPath }/DelMultiServlet" method="post">
<table border="0" width="88%" style="text-align:center">
	<tr>
		<td>
			<a href="${pageContext.request.contextPath}/addCustomer.jsp">ADD</a>&nbsp;&nbsp;
			<a href="javascript:delMulti()">DELETE</a>
		</td>
	</tr>
	<tr>
		<td>
		<c:if test="${empty page.records}">
			No customer information!
		</c:if>
		<c:if test="${!empty page.records}">
			<table width="100%">
				<tr>
					<th>选择</th>
					<th>姓名</th>
					<th>性别</th>
					<th>生日</th>
					<th>电话</th>
					<th>邮箱</th>
					<th>爱好</th>
					<th>类型</th>
					<th>描述</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${page.records}" var="c" varStatus="vs">
				<tr bgcolor="${vs.index%2==0?'#C9C9C9':'#6192B0' }">
					<td>
						<input type="checkbox" name="ids" value="${c.id }"/>
					</td>
					<td>${c.name }</td>
					<td>${c.gender=="1"?"MALE":"FEMALE" }</td>
					<td>${c.birthday }</td>
					<td>${c.cellphone }</td>
					<td>${c.email }</td>
					<td>${c.hobby }</td>
					<td>${c.type }</td>
					<td>${c.description }</td>
					<td>
						<a href="${pageContext.request.contextPath}/UpdateCustomerServletUI?customerId=${c.id}">UPDATE</a>&nbsp;&nbsp;
						<a href="javascript:delOne('${c.id }')">DELETE</a>
					</td>
				</tr>
				</c:forEach>
				
			</table>
		</c:if>
		</td>
	</tr>
	<tr>
	<td align="center">
	<%@ include file="/commons/page.jsp"%>
	</td>
	</tr>
</table>
</form>
<script type="text/javascript">
function delOne(id){
	var sure = window.confirm("Are u sure delete?");
	if(sure){
		window.location.href = "${pageContext.request.contextPath}/DeleteCustomerServlet?customerId="+id;
	}
}
function delMulti(){
	var idsObj = document.getElementsByName("ids");
	var selected = false;
	for(var i=0; i<idsObj.length; i++){
		if(idsObj[i].checked){
			selected = true;
			break;
		}
	}
	if(selected){
	var sure = window.confirm("Are u sure delete?");
	if(sure){
		document.getElementById("f1").submit();
	}
	}
	else{
		alert("Please choose at least one item to delete!");
	}
}
</script>
</body>
</html>