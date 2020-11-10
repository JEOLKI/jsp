<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript">

	$(document).ready(function(){
		
		//client side에서는 서버사이드 변수나 값을 사용가능
		memberAjax("${param.userid}")
		//memberAjax(${param.userid})으로 하게되면 문자열로 인식하지않는다 잘못된코드
		
		$('#updateBtn').on('click', function(){
			
			var userid = $(this).data("userid");
			document.location="/member/update?userid=" + userid;
			
		});

		$("#profileDownBtn").on('click', function(){
			// 사용자 한명의 정보이기 때문에 url에 바로 EL을 사용하여 한명의 정보를 받아올 수 있다.
			document.location="/profileDownload?userid=${userid}";
		})

		
	});

	function memberAjax(userid){
		$.ajax({url : "/member/memberAjax",
			data : {userid : userid},
			method : "get",
			success : function(data){
				
				$('#proimg').attr('src', '${cp }/profileImgView?userid=' + data.memberVo.userid);
				$('#profileDownBtn').text("다운로드 : " + data.memberVo.realFilename);
				$('#userid').html(data.memberVo.userid);
				$('#usernm').html(data.memberVo.usernm);
				$('#alias').html(data.memberVo.alias);
				$('#addr1').html(data.memberVo.addr1);
				$('#addr2').html(data.memberVo.addr2);
				$('#reg_dt').html(data.memberVo.fmt_reg_dt);
				$('#updateBtn').attr('data-userid', data.memberVo.userid);
				
			}
		});
	}

</script>

<form class="form-horizontal" role="form">
	tiles

	
	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
		<div class="col-sm-10">
			<img id="proimg" src=""/><br>
			<button id="profileDownBtn" type="button" class="btn btn-default">dd</button>
		</div>
	</div>
	
	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
		<div class="col-sm-10">
			<label class="control-label" id="userid"></label>
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
		<div class="col-sm-10">
			<label class="control-label" id="usernm"></label>
		</div>
	</div>
	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">별명</label>
		<div class="col-sm-10">
			<label class="control-label" id="alias"></label>
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
			<label class="control-label" id="addr1"></label>
		</div>
	</div>
	<div class="form-group">
		<label for="addr2" class="col-sm-2 control-label">상세주소</label>
		<div class="col-sm-10">
			<label class="control-label" id="addr2"></label>
		</div>
	</div>
	<div class="form-group">
		<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
		<div class="col-sm-10">
			<label class="control-label" id="zipcode"></label>
		</div>
	</div>
	<div class="form-group">
		<label for="reg_dt" class="col-sm-2 control-label">등록일자</label>
		<div class="col-sm-10">
			<label class="control-label" id="reg_dt"></label>
		</div>
	</div>


	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10" id="updateBtndiv">
			<button id="updateBtn" type="button" class="btn btn-default" data-userid="">사용자 수정</button>
		</div>
	</div>
</form>

