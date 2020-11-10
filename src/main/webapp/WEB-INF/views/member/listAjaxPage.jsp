<%@page import="kr.or.ddit.member.model.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script>

	// 해당 html이 로딩이 완료 되었을 때 실해오디는 이벤트 핸들러 함수
	$(document).ready(function() {

		//memberListAjax(1)
		memberListAjaxHTML(1)

		// delegate 방식 : 이미 존재하는 태그(#memberList)에 이벤트를 거는것 
		$("#memberList").on("click", "tr", function() {
			//console.log("memberList tr click");

			// data-userid
			var userid = $(this).data("userid");
			console.log("userid : " + userid);

			document.location = "/member/memberAjaxPage?userid=" + userid;

		});
		
	});

	function memberListAjax(p){
		// 비동기
		// ajax call을 통해 1페이지에 해당하는 사용자 정보를 json으로 받는다.
		$.ajax({url : "/member/listAjax",
				data : {page : p, pageSize : 5}, // 파라미터형태 => 폼전송과 같다
				//data : "page=1&pageSize=5", // 파라미터의 형태로 전송
				//data : JSON.stringify({page : 1, pageSize : 5}), 
				// 			json문자열 Controller에서 @RequestBody로 받아야함  JSON <--> JAVA OBJECT
				method : "get",
				success : function(data){
					var i = 0;

					// memberList tbody 영역에 들어갈 html 문자열 생성
					var html = "";
					for(var i = 0; i < data.memberList.length ; i++){
						var member = data.memberList[i];
						html += "<tr data-userid='"+ member.userid +"'>";
						html += "	<td>"+ member.userid +"</td>";			
						html += "	<td>"+ member.usernm +"</td>";			
						html += "	<td>"+ member.alias +"</td>";			
						html += "	<td>"+ member.fmt_reg_dt +"</td>"; // value 객체에 설정
						html += "</tr>";
					}
						//<td><fmt:formatDate value="${member.reg_dt }" pattern="yyyy-MM-dd" /></td> => 서버사이드에서 실행이되고 사용자에게는 문자열만 온다.
						// ajax success는 클라이언트사이드에서 실행되기 때문에 서버사이드에서 실행되는 코드는 작동하지 않는다.
						// 반대로 서버쪽에의 변수를 클라이언트에 할당하는것은 가능하다.
						// var length = ${memberList.size()}; // 서버에서실행
						// var length = 5; // 실제로 오는값
					$("#memberList").html(html);

					//페이지 내비게이션 html 문자열 동적으로 생성하기
					
					var html = "";
					for(var i = 1 ; i <= data.pages ; i++){

						if(i == data.pageVo.page){
							html += '<li class="active"><span>'+ i +'</span></li>';
						} else {
							html += '<li><a href="javascript:memberListAjax('+i+');">'+ i +'</a></li>'; // <a href="javascript:memberListAjax(1);"/>
						}
					}

					$("ul.pagination").html(html);
					
				}
		});
	}

	function memberListAjaxHTML(p){
		$.ajax({url : "/member/listAjaxHTML",
				data : {page : p, pageSize : 5}, // 파라미터형태 => 폼전송과 같다
				method : "get",
				success : function(data){
					
					$("#memberList").html(data.split("$$$SEPERATOR$$$")[0]);
					$("ul.pagination").html(data.split("$$$SEPERATOR$$$")[1]);
				}
		});
	}
	
</script>


<div class="row">
	tiles : memberListContent.jsp
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>사용자 아이디</th>
						<th>사용자 이름</th>
						<th>사용자 별명</th>
						<th>등록일시</th>
					</tr>
				</thead>
				<tbody id="memberList">
					
				</tbody>
			</table>
		</div>

		<a class="btn btn-default pull-right" href="${cp }/member/regist">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
				
			</ul>
		</div>
	</div>
</div>
