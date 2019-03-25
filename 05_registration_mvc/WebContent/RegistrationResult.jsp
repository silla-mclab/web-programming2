<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.registration2.PersonalInfoDO" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인 정보 등록 결과</title>
</head>
<body>
<%
	PersonalInfoDO pi = (PersonalInfoDO)request.getAttribute("pinfo");
%>
	<h1>개인 정보 등록 결과</h1><hr>
	<p>1. 이름 : <%= pi.getName() %></p>
	<p>2. 아이디 : <%= pi.getId() %></p>
	<p>3. 패스워드 : <%= pi.getPasswd() %></p>
	<p>4. 성별 : <%= (pi.getGender().equals("male") ? "남" : "여") %></p>
	<p>5. 메일 수신 : <%= pi.isInotice() ? "공지메일 " : "" %>
					<%= pi.isCnotice() ? "광고메일 " : "" %>
					<%= pi.isDnotice() ? "배송메일 " : "" %></p>
	<p>6. 직업 : <%= pi.getJob() %></p>
	<p>7. 자기소개 : <%= pi.getIntro() %></p>
	<p><button onclick='window.history.back();'>이전 페이지 가기</button></p>
</body>
</html>