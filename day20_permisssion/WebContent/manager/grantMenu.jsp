<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/manager/header.jsp" %>
<h1>菜单分配</h1>
<form id="f1" action="${pageContext.request.contextPath}/MyController?operation=grantMenu2Role" method="post">
<input type="hidden" name="roleId" value="${role.id}"/>
<table width="88%" border="1">
	<tr>
		<td colspan="2">
		角色名称:${role.name}
		</td>
	</tr>
	<tr>
		<td>已有菜单</td>
		<td>
			<c:forEach items="${role.menus}" var="m">
				${m.name} <br/>
			</c:forEach>
		</td>
	</tr>
	<tr>
		<td>所有菜单</td>
		<td>
			<c:forEach items="${menus}" var="m">
				<input type="checkbox" name="mIds" value="${m.id}"/>${m.name}<br/>
			</c:forEach>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" value="保存" onclick="toSubmit()"/>
		</td>
	</tr>
</table>
</form>
<script type="text/javascript">
function toSubmit(){
	var checkBoxs = document.getElementsByName("mIds");
	var selected = false;
	for(var i=0;i<checkBoxs.length;i++){
		if(checkBoxs[i].checked){
			selected = true;
		}
	}
	if(selected){
		document.getElementById("f1").submit();
	}else{
		alert("请选择要分配的菜单")
	}
	
}
</script>
</body>
</html>