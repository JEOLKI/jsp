<%@page import="kr.or.ddit.job.model.JobVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Job</title>

<%@ include file="/layout/commonLib.jsp" %>

</head>

<body>

	
<%@ include file="/layout/header.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3 col-md-2 sidebar">
			<%@ include file="/layout/left.jsp" %>
		</div>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<div class="row">
			<div class="col-sm-8 blog-main">
				<h2 class="sub-header">Jobs</h2>
					<div class="table-responsive">
						<table class="table table-striped">
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
					</div>
				</div>
			</div>
		</div>
	</div>
</div>	
	
</body>
</html>