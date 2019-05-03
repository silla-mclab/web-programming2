<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Visit Count</title>
</head>
<body>
	<%!
		public void jspInit() {
			String email = getServletConfig().getInitParameter("admin_email");
			getServletContext().setAttribute("email", email);
		}
	%>
	<%!
		int count = 0;
	    
	    int doubleCount() {
	    	return (++count) * 2;
	    }
	%>
	<%
		RequestDispatcher header = request.getRequestDispatcher("header.jsp");
		header.forward(request, response);	
	%>
<%--	
	<%
		pageContext.forward("header.jsp");
	%>a
	<jsp:forward page="header.jsp" />
 --%>
 	<h1>Visit Count</h1>
	<p>페이지 방문 회수 : <%= doubleCount() %></p>
	<br><br>
	<p>관리자 이메일 주소 : <%= application.getAttribute("email") %></p>
</body>
</html>