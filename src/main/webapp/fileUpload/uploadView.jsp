<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${cp }/fileUpload" method="POST" enctype="multipart/form-data">
		userId : <input type="text" name="userid" value="brown"/> <br>
		file : <input type="file" name="img" /> <br>
		<!-- 값을 미리 설정하는게 불가능 : 보안문제 때문에 브라우저에서 제공하지 않는다 -->
		<button type="submit" >전송</button>
	</form>
</body>
</html>