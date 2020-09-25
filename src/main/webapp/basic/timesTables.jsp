<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

	td{
		border: 1px solid black;
		padding: 10px;
	}

</style>

</head>
<body>

	<table>
	<% for(int i = 1; i<10 ; i++){ %>
		<tr>			
			<% for(int j = 2; j < 10; j++){ %>
				<td><%= j %> * <%= i %>  = <%= i*j %></td>
			<% } %>
		</tr>	
	<% } %>
	</table>

</body>
</html>