<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>맥주 추천 서비스</title>
</head>
<body>
	<div style="margin-left:200px;">
	<h1>Beer Recommendation</h1><p>
	Selected Beer Color : <%= request.getParameter("color") %><p>
	<%
		List<String> brands = (List<String>)request.getAttribute("brands");
	    Iterator<String> it = brands.iterator();
	    while (it.hasNext()) {
	%>
			Try: <%= it.next() %><br>
	<%    	
	    }
	%>
	</div>
</body>
</html>