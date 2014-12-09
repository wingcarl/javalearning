<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
第${page.pageNum}页/共${page.totalPage}页&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/${page.servletUrl}">First</a>
	<a href="${pageContext.request.contextPath}/${page.servletUrl}?pageNum=${page.pageNum-1==0?1:page.pageNum-1}">Previous</a>
	&nbsp;&nbsp;
	<c:forEach begin="${page.startPage}" end="${page.endPage}" var="num">
	<a href="${pageContext.request.contextPath}/${page.servletUrl}?pageNum=${num}">${num}</a>
	
	</c:forEach>
	<a href="${pageContext.request.contextPath}/${page.servletUrl}?pageNum=${page.pageNum+1>page.totalPage?page.totalPage:page.pageNum+1}">Next</a>
	<a href="${pageContext.request.contextPath}/${page.servletUrl}?pageNum=${page.totalPage}">Last</a>
	<select id="s1">
		<c:forEach begin="1" end="${page.totalPage }" var="num">
			<option value="${num }" ${page.pageNum==num?'selected="selected"':''}>${num }</option>
		</c:forEach>
	</select>
	<a href="javascript:jump()">JUMP</a>
	<script type="text/javascript">
		function jump(){
			var num = document.getElementById("s1").value;
			window.location.href="${pageContext.request.contextPath}/${page.servletUrl}?pageNum="+num;
		}
	</script>