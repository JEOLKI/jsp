<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 
	1. import 태그를 사용한 위치에 url에서 반환하는 값을 삽입
	2. 단 var 속성을 설정하게 되면 url에서 반환하는 값을 var 변수에 저장한다.
		-> var 속성이 있으면 결과값이 var 담겨있어서 출력을 해주어야 화면이 나온다.
--%>
 
<%-- 1 --%>
<%-- <c:import url="https://www.naver.com/"></c:import> --%>

<%-- 2 --%>
<%-- <c:import url="https://www.naver.com/" var="naver_html"></c:import>
${naver_html } --%>

<%-- 3 --%>
<%-- https://search.naver.com/search.naver?
sm=tab_sug.top&where=nexearch&query=covid19
&oquery=%EC%BD%94%EB%A1%9C%EB%82%98&tqi=UGPSNsprvOsssdpUus0ssssstkd-371089&acq=co&acr=2&qdt=0

https://search.naver.com/search.naver?query=covid19 --%>

<c:import url="https://search.naver.com/search.naver">
	<c:param name="query" value="covid19"/>
</c:import>
