<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 상품 관리 프로그램</title>
</head>
<body>
	<%
		int result = ((Integer)request.getAttribute("result")).intValue();
	%>
	<script>
	    var resultVal = <%= result %>;
		if (resultVal < 0) {		
			window.onload = function() {
				alert("요청 작업[${job}] 실행에 실패하였습니다...");
				window.history.go(-1);
			}
		}
		else {
			window.onload = function() {
				alert("요청 작업[${job}]을 성공적으로 수행하였습니다...");
				window.location.href='${pageContext.request.contextPath}/start';
			}
		}
	</script>
</body>
</html>