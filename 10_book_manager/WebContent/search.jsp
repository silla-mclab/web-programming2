<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 상품 관리 프로그램</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="true" />
	
	<div align="center" style="height: 480px;">
		<h2>도서 상품 검색</h2><br>
		<form method="post" action="search.do">
			<label for="code">Code: </label>
			<input type="text" name="code" />
			<input type="submit" value="조회" />
		</form>
	</div>
	
	<jsp:include page="footer.jsp" flush="true" />	
</body>
</html>