<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="${pageContext.request.contextPath }/sumCalculation" method="POST">
		start : <input type="text" name="start"> <br>
		end : <input type="text" name="end"> <br>
		<input type="submit" value="전송">	
	</form>


</body>
</html>