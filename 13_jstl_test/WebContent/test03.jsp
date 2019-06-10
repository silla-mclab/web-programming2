<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] movies = {"Amelie", "Return of the King", "Mean Girls"};
		request.setAttribute("movies", movies);
	%>
	<table border="1">
		<tr>
		<c:forEach begin="1" end="10">
			<td>test</td>
		</c:forEach>
		</tr>
	</table><br>
	<table border="1">
		<tr>
		<c:forEach var="cnt" begin="1" end="10">
			<td>test ${cnt}</td>
		</c:forEach>
		</tr>
	</table><br>
	<table border="1">
		<tr>
		<c:forEach var="cnt" begin="1" end="10" step="2">
			<td>test ${cnt}</td>
		</c:forEach>
		</tr>
	</table><br>
	<table border="1">
		<c:forEach var="movie" items="${movies}" >
		<tr>
			<td>${movie}</td>
		</tr>
		</c:forEach>
	</table><br>
	<table border="1">
		<c:forEach var="movie" items="${movies}" varStatus="loopCnt">
		<tr>
			<td>${loopCnt.count}</td>
			<td>${movie}</td>
		</tr>
		</c:forEach>
	</table><br>
	<c:catch var="ex">
		<h3><c:out value="catch core tag test" /></h3>
		<p>Calculating...</p>
		<p>Result = ${100/"AB"}</p>
		<p>Continue...</p>
	</c:catch>
	<c:if test="${ex ne null}">
		<p>There was an exception: ${ex.message}</p>
	</c:if>
	<p>If you see this, we survived.</p>
</body>
</html>