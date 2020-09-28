<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<%-- jsp 스크립트 : 서버에서 실행됨 <% %>, <%= %> --%>
	
		<% String str = "message";%>
		<% String str2 = "";%>
		<% String str3 = "hello";%>

<script>

	/* 서버 사이드 변수에 클라이언트 사이드 값을 대입하는 경우(X)
	   서버 사이드 스크립트가 먼저 실행되므로 논리적으로 말이 안된다. */
	   
	<%= str %> = 'test'; <!-- message 라는 변수의 test가 선언된것이 된다.-->
	//<%= str2 %> = 'test'; <!-- 오류 : 스크립트 주석은 실행이된후 클라이언트에 도달한다.-->
	<%-- <%= str2 %> = 'test'; --%> <!-- jsp 주석은 서버에서 실행되기 때문에 클라이언트에 도달하지 않는다.-->

	
	/* 클라이언트 사이드 변수에 서버 사이드 변수 값을 대입
	   서버 사이드 스크립트가 먼저 실행되므로 논리적으로 말이 된다 */
	var msg = '<%= str3 %>';

	/*	스크립트는 서버에서 실행이 되기 때문에 "" = test 가 된다.
		서버쪽 변수에 클라이언트 쪽의 변수를 넣는것은 불가능하다.
		서버에서 미리 실행되기 때문에 */

</script>
	
</body>
</html>