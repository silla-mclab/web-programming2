<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/error.jsp" %>
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
		<h2>도서 상품 추가</h2><br>
		<form method="post" action="insert.do">
			<table border="1">
				<tr>
					<td class="td1">코 드:</td>
					<td class="td2"><input type="text" name="code" required autofocus></td>
				</tr>
				<tr>
					<td class="td1">제 목:</td>
					<td class="td2"><input type="text" name="title" size="35" required></td>
				</tr>
				<tr>
					<td class="td1">저 자:</td>
					<td class="td2"><input type="text" name="writer" required></td>
				</tr>
				<tr>
					<td class="td1">가 격:</td>
					<td class="td2"><input type="text" name="price"></td>
				</tr>
			</table><br>
			<input type="submit" value="도서 추가" />
			<input type="button" value="첫페이지 >>" onclick="window.location.href='${pageContext.request.contextPath}/start';" />
		</form>
	</div>
	
	<jsp:include page="footer.jsp" flush="true" /></body>
</html>