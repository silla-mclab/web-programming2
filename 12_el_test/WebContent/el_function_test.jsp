<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="m" uri="math_functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Function Test</title>
</head>
<body>
	<p>Sqrt of 4 = ${m:squareroot(4)}</p>
	<p>Rolling dice ... => ${m:rollIt()}</p>
</body>
</html>