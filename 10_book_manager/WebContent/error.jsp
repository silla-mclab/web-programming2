<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
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
		요청한 서비스가 없거나 처리 과정에서 오류가 발생하였습니...<br>		
		<br><br>
		<input type="button" value="첫페이지 >>" onclick="window.location.href='${pageContext.request.contextPath}/start';" />
		<br><br><br><br><br>	
	</div>
	
	<jsp:include page="/footer.jsp" flush="true"/>	
</body>
</html>