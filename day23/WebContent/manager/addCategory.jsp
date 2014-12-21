<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/manager/header.jsp" %>
<form  action="${pageContext.request.contextPath }/servlet/ManagerServlet?operation=addCategory" method="post">
	<fieldset style="">
		<legend>分类列表</legend>
		<div class="form-group">
		<label>分类名</label>
		<input type="text" name="name" class="form-control" placeholder="请输入分类名"/>		
		</div>
		<div class="form-group">
		<label>分类描述</label>
		<textarea rows="3" name="description" class="form-control" placeholder="请输入分类描述"></textarea>
		</div>
		<button type="submit" class="btn btn-default">添加</button>
	</fieldset>
</form>
</body>
</html>