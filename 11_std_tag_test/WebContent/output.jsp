<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.employee.domain.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고용인 정보 입력 결과</title>
</head>
<body>
<%--
	<%
		Person person = (Person)request.getAttribute("person");
	%>
 --%>
 	<div align="center">
		<h1>고용인 정보 입력 결과</h1><hr><br>
	</div>
	<div align="center">
		<p>고용인 정보가 등록되었습니다...</p>
		<table border="1">
<%--		
			<tr>
				<td style="width:60px; text-align:center;">이름</td>
				<td style="width:200px; text-align:center;"><%= person.getName() %></td>
			</tr>
			<tr>
				<td style="width:60px; text-align:center;">성별</td>
				<td style="width:200px; text-align:center;"><%= person.getGender() %></td>
			</tr>
			<tr>
				<td style="width:60px; text-align:center;">나이</td>
				<td style="width:200px; text-align:center;"><%= person.getAge() %></td>
			</tr>
 --%>
 <%--
            <jsp:useBean id="person" class="com.example.employee.domain.Person" scope="request" />
--%>    
            <jsp:useBean id="person" type="com.example.employee.domain.Person" scope="request" />
            
			<tr>
				<td style="width:60px; text-align:center;">이름</td>
				<td style="width:200px; text-align:center;"><jsp:getProperty name="person" property="name" /></td>
			</tr>
			<tr>
				<td style="width:60px; text-align:center;">성별</td>
				<td style="width:200px; text-align:center;"><jsp:getProperty name="person" property="gender" /></td>
			</tr>
			<tr>
				<td style="width:60px; text-align:center;">나이</td>
				<td style="width:200px; text-align:center;"><jsp:getProperty name="person" property="age" /></td>
			</tr>
 
  		</table><br>
		<input type="button" value="첫페이지>>" onclick="window.location.href='input.html';">
	</div>

</body>
</html>