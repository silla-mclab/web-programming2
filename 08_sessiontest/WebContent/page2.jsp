<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Favorite Info Registration</title>
</head>
<body>
	<div align="center">
		<%@ include file="/header.jsp" %>
 		<form method="post" action=<%=response.encodeURL("page3.do")%>>
			당신이 좋아하는 동물은?
			<select name="pet">
				<option>강아지</option>
				<option>고양이</option>
				<option>햄스터</option>
			</select>
			<input type="submit" value="확인" />
		</form>
	</div>
</body>
</html>