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
	<c:set var="num1" value="100" />
	<c:set var="num2" value="50" />
	<c:if test="${num1 - num2 > 0}">
		<p>num1=${num1}이 더 큽니다...</p>
	</c:if>
	<c:choose>
		<c:when test="${num1 > 0}">
			<p>num1은 0보다 크다...</p>
		</c:when>
		<c:when test="${num1 == 0}">
			<p>num1은 0이다...</p>
		</c:when>
		<c:otherwise>
			<p>num1은 0보다 작다...</p>
		</c:otherwise>
	</c:choose>
</body>
</html>