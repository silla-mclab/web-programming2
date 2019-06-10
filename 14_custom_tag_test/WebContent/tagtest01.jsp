<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="simpletags" prefix="myTags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] movies = {"Amilie", "Return of the King", "Mean Girls"};
		request.setAttribute("movies", movies);
	%>
	<c:set var="title" value="custom tag test" />
	<myTags:simple1 />
	<div>
		<myTags:simple2>
			This is a custom tag with a body-content.<br>
			${title}
		</myTags:simple2>
	</div>
	<myTags:simple3 color="#ff0000">
		This is a custom tag with a body-content.<br>
		${title}
	</myTags:simple3>
    <br><br>
    <table border="1">
		<myTags:simple4 var="movie" items="${movies}">
			<tr><td>${movie}</td></tr>
		</myTags:simple4>
	</table><br>
	<p>This is the last line...</p>
</body>
</html>