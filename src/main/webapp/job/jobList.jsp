<%@page import="kr.or.ddit.job.model.JobVo"%>
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
	
	<table border="1">
		<tr>
			<td>job_id</td>
			<td>job_title</td>
		</tr>
		
		<%
			List<JobVo> jobList = (List<JobVo>) request.getAttribute("jobList");
		
			for(JobVo job : jobList){
		%>
				
		<tr>
			<td><%= job.getJob_id() %></td>
			<td><%= job.getJob_title() %></td>
		</tr>
				
		<%
			}
		%>
		
		
	
	</table>
	
	
</body>
</html>