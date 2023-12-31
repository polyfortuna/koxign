<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<h2>비밀번호 찾기</h2>
<p>회원가입 시 등록한 정보를 입력해주세요.</p>

<div class="bg-area change_box">
	<form id="frm" name="frm" action="/partner/findPasswordRegist.do" method="post" onsubmit="return checkForm(this)" >
		<fieldset>
			<legend>아이디찾기 폼</legend>
			<div class="change_inp">
				<div>
					<label for="partnerEmail">아이디</label>
					<input type="text" name="partnerEmail" class="inp" id="partnerEmail"/>
				</div>
				<div>
					<label for="userNm">회원명</label>
					<input type="text" name="partnerNm" class="inp" id="partnerNm"/>
				</div>
				
			</div>
			<div class="btn-cont">
				<button type="submit" class="btn spot">확인</button>
				<button type="reset" class="btn">취소</button>
			</div>
		</fieldset>
	</form>
</div>

<script>
<c:if test="${not empty message}">
	alert("${message}");
</c:if>	

function checkForm(){
	if(!$("#userNm").val()){
		alert("회원명을 입력해주세요.");
		return false;
	}
}
	
</script>
</body>
</html>