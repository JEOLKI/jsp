<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	http://localhost/jsp/test.jsp  <br>
	jsp 프로젝트 jsp/test.jsp<br>
	<br>
	jsp 프로젝트 (contextPath ROOT(/))의 webapp/jsp/test.jsp를 접근하기 위해서는<br>
	http://localhost/jsp/test.jsp 로 요청.<br>
	<br>
	jsp2 프로젝트 (contextPath jsp)의 webapp.test.jsp를 접근하기 위해서는<br>
	http://localhost/jsp/test.jsp 로 요청.<br>
	<br>
	즉 두개의 리소스가 동일한 url을 갖는다.<br>
	이럴때 contextPath를 우선시하여 처리. (이게 중요한 것은 아님)<br>
	<br>
	url만 보고서 경로에 나오는 path가 contextPath인지, webapp 폴더 하위의 디렉토리 인지는 알 수가 없다.<br>
	
	
</body>
</html>