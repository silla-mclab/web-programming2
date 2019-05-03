<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Visit Count</title>
</head>
<body>
	<%!
		int count = 0;
	    
	    int doubleCount() {
	    	return (++count) * 2;
	    }
	%>
	<h1>Visit Count</h1>
	<p>페이지 방문 회수 : <%= doubleCount() %></p>

</body>
</html>