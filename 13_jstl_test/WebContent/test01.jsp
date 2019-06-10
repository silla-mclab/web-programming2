<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="currentTip" value="<b></b> tags make things bold!" />
	
	<h1>JSTL Core Tags</h1><br>
	<div>
		<b>Tip of the Day</b><br><br>
<%--		
		<p>${currentTip}</p>
 --%>
		<p><c:out value="${currentTip}" escapeXml="true" /></p>
		<p>Hello, <c:out value="${guest}" default="Guest" />!.</p>
	</div>
	
	<c:remove var="currentTip" />
	
	<c:set target="${requestScope}" property="greeting" value="Welcome to JSTL World!" />
	<p><c:out value="${requestScope.greeting}" /></p>
</body>
</html>