<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/error.jsp" %>
<%@ page import="com.example.bookmgr.model.*, java.util.List" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 상품 관리 프로그램</title>
<style>
.th {
	text-align: center;
	background-color: LightSkyBlue;
}

.td {
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" flush="true" />
	
	<div align="center" style="height: 480px;">
		<h2>도서 상품 목록</h2><br>
	<%
		List<Book> bookList = (List<Book>)request.getAttribute("list");
	%>	
		<form method="post" action="update">
			<table border="1">
				<tr>
					<th class="th" width="75">코 드</th>
					<th class="th" width="250">제 목</th>
					<th class="th" width="150">저 자</th>
					<th class="th" width="75">가 격</th>
				</tr>
	<%
		for (Book book : bookList) {
	%>			
				<tr>
					<td class="td"><%= book.getCode() %></td>
					<td style="padding-left: 5px;"><%= book.getTitle() %></td>
					<td class="td"><%= book.getWriter() %></td>
					<td class="td"><%= book.getPrice() %></td>
				</tr>
	<%
		}
	%>			
			</table><br>
 			<input type="button" value="첫 페이지 >>" onclick="window.location.href='${pageContext.request.contextPath}/start';"/>
		</form>
	</div>
	
	<jsp:include page="footer.jsp" flush="true" />	
</body>
</html>