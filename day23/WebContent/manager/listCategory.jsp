<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/manager/header.jsp" %>
<c:if test="${empty cs }">
	没有分类，请先添加！
</c:if>
<c:if test="${!empty cs}">
<table class="table table-striped">
  <tr>
  	<th>选择</th>
    <th>分类名称</th>
    <th>分类描述</th>
    <th>操作</th>
  </tr>
 <c:forEach items="${cs}" var="cs" varStatus="vs">
  <tr>
  	<td>
  		<input type="checkbox" name="ids" value="${cs.id}"/>
  	</td>
    <td>${cs.name}</td>
    <td>${cs.description}</td>
    <td>
    	<a href="#">修改</a>
		 <a href="#">删除</a>
    </td>
  </tr>
  </c:forEach>
</table>
</c:if>
</body>
</html>
</body>
</html>