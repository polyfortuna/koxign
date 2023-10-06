<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="ko">
<meta http-equiv="X-UA-Compatible" content="IE-edge"/>
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>회원가입</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<a href="/main" class="d-block auth-logo">
   <img src="../resources/assets/img/koxign-logo.png" alt="koxign" height="80"> <span class="logo-txt"></span>
</a>
<h2 class="icon1">회원정보입력</h2>
<p class="mB20">회원가입을 위해 아래의 정보를 입력해 주십시오. <br class="m-block"/><strong class="star">*</strong>표시는 필수 입력사항입니다.</p>

<h3 class="icon2 hidden">기본정보</h3>
<form id="frm" name="frm" method="post" action="/join/insertMember.do" onsubmit="return regist();">
	<input type="hidden" id="idCheckAt" value="N"/>
	
	<table class="join_chart">
		
		<colgroup>
			<col style="width:200px"/>
			<col/>
		</colgroup>
		<tbody>
			<tr>
				<th><strong class="star">*</strong><label for="partnerEmail">Email</label></th>
				<td>
					<input type="text" id="emplyrId" name="emplyrId" required/>
					<a href="#" id="btn-id-check" class="btn-sm spot fn" title="중복확인(새창열림)"><span>중복확인</span></a>
				</td>
			</tr>
			<tr>
				<th><strong class="star">*</strong><label for="userNm">Username</label></th>
				<td><input type="text" id="userNm" name="userNm" required/></td>
			</tr>
			<tr>
				<th><strong class="star">*</strong><label for="password">Password</label></th>
				<td><input type="password" id="password" name="password" required/></td>
			</tr>
		</tbody>
	</table>
	
	<div class="btn-cont ac">
		<button type="submit" class="btn spot">가입</button>
	</div>
</form>

<script>
$(document).ready(function(){
	//아이디 중복 검사
	$("#btn-id-check").click(function(){
		var emplyrId =$("#emplyrId").val();
		
		if(emplyrId){
			$.ajax({
				url : "/join/duplicateCheck.do",
				type : "post",
				data : {"emplyrId" : emplyrId},
				dataType : "json",
				success : function(data){
					if(data.successYn == "Y"){
						alert("사용가능한 ID입니다.");
						$("#idCheckAt").val("Y");
					}else{
						alert(data.message);
						$("#idCheckAt").val("N");
					}
				}, error : function(){
					alert("error");
				}
			});
		}else{
			alert("ID를 입력해주세요.");
		}
		
		return false;
	});
	
	//이메일
	$("#domain").change(function(){
		let domain = $(this).val();
		
		$("#emailDomain").val(domain);
	});
});

//validation 체크
function regist(){
	 if($("#idCheckAt").val() != "Y"){
		alert("아이디 중복 검사를 해주세요.");
		return false;
	}else if(!$("#emplyrId").val()){
		alert("아이디를 입력해주세요.");
		return false;
	}else if(!$("#userNm").val()){
		alert("이름을 입력해주세요.");
		return false;
	}else if(!$("#password").val()){
		alert("비밀번호를 입력해주세요.");
		return false;
	
	}
	
	if($("#password").val()){
		var pw = $("#password").val(),
			message = "",
			//대소문자, 특수문자, 숫자는 8자리 이상 정규형
			passwordRules1 = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,30}$/,
			//대수문자, 숫자는 10자리 이상 정규형
			passwordRules2 = /^(?=.*[a-zA-Z])(?=.*[0-9]).{10,30}$/,
			result = false;
			
		if(pw.length <10){
			if(!passwordRules1.test(pw)){
				message = "영문, 숫자, 특수문자 등 3가지 사용시 8자리 이상, 2가지 사용시 10자리 이상";	
			}else{
				result = true;
			}
		}
		if(!passwordRules2.test(pw) && !result){
			message = "영문, 숫자, 특수문자 등 3가지 사용시 8자리 이상, 2가지 사용시 10자리 이상";	
		}else{
			result = true;
		}
		if(message.length > 0){
			alert(message + " 입력해주세요.");
			return false;
		}
	}
}

</script>
</body>
</html>