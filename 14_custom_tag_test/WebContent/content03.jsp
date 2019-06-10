<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tag File Test 03</title>
</head>
<body>
	<myTags:Header subTitle="We take the sting out of SOAP." fontColor="#660099">
		We take the sting out of SOAP. OK, so it's not Jini,<br>
		but we'll help you get through it with the least<br>
		frustration and hair loss.
	</myTags:Header>
	<br>
	Contact us at: ${initParam.mainEmail}
</body>
</html>