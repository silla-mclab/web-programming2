<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.text.*" %>
    
<div>
    <div style="display: inline-block;">
		<img src="resources/JSP-logo.jpg" width="300" height="150" />
	</div>
	<div style="display: inline-block;">
		<p><font size="15" color="blue">Java Servlet & JSP</font></p>
		<p><font size="3" color="green">
		<%
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
		%>
		[<%= format.format(new Date()) %>]
		</font></p>
	</div>
</div>