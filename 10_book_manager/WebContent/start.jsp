<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 상품 관리 프로그램</title>
</head>
<body>
	<jsp:include page="/header.jsp" flush="true" />
	

	<div align="center" style="height: 480px;">
		<h2>도서 상품 관리</h2><br>
		<p><a href="op/list">1. 도서 상품 목록</a></p>
		<p><a href="op/search">2. 도서 상품 조회</a></p>
		<p><a href="op/insert">3. 도서 상품 추가</a></p>
	</div>
	
	<jsp:include page="/footer.jsp" flush="true" />	
</body>
</html>