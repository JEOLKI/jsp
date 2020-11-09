<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript">

	$(document).ready(function(){
		$('#updateBtn').on('click', function(){

			var userid = $(this).data("userid");
			document.location="/member/update?userid=" + userid;
			
		});

		$("#profileDownBtn").on('click', function(){
			// 사용자 한명의 정보이기 때문에 url에 바로 EL을 사용하여 한명의 정보를 받아올 수 있다.
			document.location="/profileDownload?userid=${memberVo.userid}";
		})
		
	});

</script>

<form class="form-horizontal" role="form">
	tiles

	
	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
		<div class="col-sm-10">
			<%-- <img src="${cp }/profile/${memberVo.filename}"/> --%>
			
			<img src="${cp }/profileImgView?userid=${memberVo.userid }"/> <br>
			<button id="profileDownBtn" type="button" class="btn btn-default">다운로드 : ${memberVo.realFilename }</button>
		</div>
	</div>
	
	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
		<div class="col-sm-10">
			<label class="control-label">${memberVo.userid }</label>
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
		<div class="col-sm-10">
			<label class="control-label">${memberVo.usernm }</label>
		</div>
	</div>
	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">별명</label>
		<div class="col-sm-10">
			<label class="control-label">${memberVo.alias }</label>
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">Password</label>
		<div class="col-sm-10">
			<label class="control-label">********</label>
		</div>
	</div>
	<div class="form-group">
		<label for="addr1" class="col-sm-2 control-label">주소</label>
		<div class="col-sm-10">
			<label class="control-label">${memberVo.addr1 }</label>
		</div>
	</div>
	<div class="form-group">
		<label for="addr2" class="col-sm-2 control-label">상세주소</label>
		<div class="col-sm-10">
			<label class="control-label">${memberVo.addr2 }</label>
		</div>
	</div>
	<div class="form-group">
		<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
		<div class="col-sm-10">
			<label class="control-label">${memberVo.zipcode }</label>
		</div>
	</div>
	<div class="form-group">
		<label for="reg_dt" class="col-sm-2 control-label">등록일자</label>
		<div class="col-sm-10">
			<label class="control-label"><fmt:formatDate value="${memberVo.reg_dt }" pattern="YYYY-MM-dd"/></label>
		</div>
	</div>


	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button id="updateBtn" type="button" class="btn btn-default" data-userid="${memberVo.userid }">사용자 수정</button>
		</div>
	</div>
</form>

