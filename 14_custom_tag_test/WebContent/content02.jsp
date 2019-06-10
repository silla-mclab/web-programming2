<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tag File Test</title>
</head>
<body>
	<c:import url="/Header.jsp">
		<c:param name="subTitle" value="We take the sting out of SOAP." />
	</c:import>
	<br>
	Contact us at: ${initParam.mainEmail}
</body>
</html>