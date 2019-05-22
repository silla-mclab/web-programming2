<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.employee.domain.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<%
		request.setCharacterEncoding("utf-8");
 	%>
 	
 	<jsp:useBean id="person" class="com.example.employee.domain.Employee" scope="request" />
 	<jsp:setProperty name="person" property="*" />
  	
	<jsp:forward page="output.jsp" />
</body>
</html>