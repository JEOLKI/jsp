<%@page import="java.util.Map"%>
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
		Map<String, String[]> map = request.getParameterMap();
		map.put("newParameter", new String[]{"sllly"});
		
		out.print(request.getParameter("newParameter"));
		
	%>
</body>
</html>