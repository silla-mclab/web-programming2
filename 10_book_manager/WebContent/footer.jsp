<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
	%>
	<div align="center">
		<hr>
		데이터베이스 JDBC 프로그래밍에 대한 예제 프로그램입니다. [<%= formatter.format(new Date()) %>]
	</div>
</body>
</html>