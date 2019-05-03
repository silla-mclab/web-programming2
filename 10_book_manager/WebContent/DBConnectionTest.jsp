<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB Connection Test</title>
</head>
<body>
	<p> Try to connect MySQL DB Server...</p>
	<%
		String msg = null;
		Connection dbConn = null;
	    
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "testuser", "1234");
			if (dbConn != null) {
				msg = "Succeed to connetc MySQL DB Server...";
			}
			else {
				msg = "Failed to connect MySQL DB Server";
				
			}
		}
		catch (ClassNotFoundException | SQLException ex) {
			msg = ex.getMessage();
		}
	%>
	<p><%= msg %></p>
	<%
		if (dbConn != null) {
			out.println("<p>Try to disconnect to DB Server...</p>");
			dbConn.close();
		}
	%>
</body>
</html>