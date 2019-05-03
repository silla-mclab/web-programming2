<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/error.jsp" %>
<%@ page import="com.example.bookmgr.model.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 상품 관리 프로그램</title>
<style>
.td1 {
	text-align: center;
	width: 75px;
	background-color: LightSkyBlue;
}
.td2 {
    padding-left: 5px;
	text-align: left;
	width: 200px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" flush="true" />
	
	<div align="center" style="height: 480px;">
		<h2>도서 상품 검색 결과</h2><br>
	<%
		Book book = (Book)request.getAttribute("book");
		if (book != null) {
	%>	
		<form method="post" action="update">
			<table border="1">
				<tr>
					<td class="td1">코 드:</td>
					<td class="td2"><input type="text" name="code" value="<%= book.getCode() %>"></td>
				</tr>
				<tr>
					<td class="td1">제 목:</td>
					<td class="td2"><input type="text" name="title" value="<%= book.getTitle() %>" size="35"></td>
				</tr>
				<tr>
					<td class="td1">저 자:</td>
					<td class="td2"><input type="text" name="writer" value="<%= book.getWriter() %>"></td>
				</tr>
				<tr>
					<td class="td1">가 격:</td>
					<td class="td2"><input type="text" name="price" value="<%= book.getPrice() %>"></td>
				</tr>
			</table><br>
			<input type="submit" value="수정" />
			<input type="button" value="삭제" onclick=<%= "'window.location.href=&quot;delete?code="+ book.getCode() +"&quot;';" %> />
			<input type="button" value="첫 페이지 >>" onclick="window.location.href='${pageContext.request.contextPath}/start';"/>
		</form>
	<%
		}
		else {
	%>	
			<h3>검색 결과가 없습니다!...</h3>
			<input type="button" value="<< 이전 페이지" onclick="window.history.go(-1);" />
			<input type="button" value="첫 페이지 >>" onclick="window.location.href='${pageContext.request.contextPath}/start';"/>
	<%
		}
	%>
	</div>
	
	<jsp:include page="footer.jsp" flush="true" />	
</body>
</html>