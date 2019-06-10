<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tag File Test</title>
</head>
<body>
	<jsp:include page="/Header.jsp">
		<jsp:param name="subTitle" value="We take the sting out of SOAP." />
	</jsp:include>
	<br>
	Contact us at: ${initParam.mainEmail}
</body>
</html>