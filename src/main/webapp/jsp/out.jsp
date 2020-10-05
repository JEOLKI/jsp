<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
 		List<String> rangers = (List<String>) request.getAttribute("rangers");
		for(String ranger : rangers) {
			out.write(ranger); %>
			<br>			
	<%
		}
	%>



</body>
</html>