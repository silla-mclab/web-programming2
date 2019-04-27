<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
	<script>
		window.onload = function() {
			alert("없는 페이지를 요청하였습니다...\n첫 페이지로 이동합니다.");
			window.location.href="/08_sessiontest/start2.html";
		}
	</script>
</body>
</html>