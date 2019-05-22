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
<%--
	<%
		request.setCharacterEncoding("utf-8");
	
		Person person = new Person();
		request.setAttribute("person", person);
		
		person.setName(request.getParameter("name"));
		person.setGender(request.getParameter("gender"));
		person.setAge(Integer.parseInt(request.getParameter("age")));
	%>
 --%>
 	<%
		request.setCharacterEncoding("utf-8");
 	%>
 	
 	<jsp:useBean id="person" class="com.example.employee.domain.Person" scope="request" />
<%-- 	
 	<jsp:setProperty name="person" property="name" value='<%= request.getParameter("name") %>' />
 	<jsp:setProperty name="person" property="gender" value='<%= request.getParameter("gender") %>' />
 	<jsp:setProperty name="person" property="age" value='<%= Integer.parseInt(request.getParameter("age")) %>' />
 --%>
<%-- 	
 	<jsp:setProperty name="person" property="name" param="name" />
 	<jsp:setProperty name="person" property="gender" param="gender" />
 	<jsp:setProperty name="person" property="age" param="age" />
 --%>
 	<jsp:setProperty name="person" property="*" />
  	
	<jsp:forward page="output.jsp" />
</body>
</html>