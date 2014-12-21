<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/manager/header.jsp" %>
<form  action="${pageContext.request.contextPath }/servlet/ManagerServlet?operation=addBook" method="post" enctype="multipart/form-data">
	<fieldset style="">
		<legend>添加图书</legend>
		<div class="form-group">
			<label>图书名</label>
			<input type="text" name="name" class="form-control" placeholder="请输入分类名"/>		
		</div>
		<div class="form-group">
			<label>作者</label>
			<input type="text" name="author" class="form-control" placeholder="请输入分类名"/>		
		</div>
		<div class="form-group">
			<label>售价</label>
			<input type="text" name="price" class="form-control" placeholder="请输入分类名"/>		
		</div>
		<div class="form-group">
			<label>图片</label>
			<input type="file" name="image"/>
		</div>
		<div class="form-group">
			<label>描述</label>
			<textarea rows="3" name="description" class="form-control" placeholder="请输入分类描述"></textarea>
		</div>
		<div class="form-group">
			<label>所属分类</label>
			<select>
			<c:forEach items="${cs}" var="c">
				<option value="${c.id }">${c.name }</option>
			</c:forEach>
			</select>
		</div>
		<button type="submit" class="btn btn-default">添加</button>
	</fieldset>
</form>
</body>
</html>