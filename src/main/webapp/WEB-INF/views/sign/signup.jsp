<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
	<jsp:useBean id="today" class="java.util.Date"/>
	<fmt:formatDate value="${today}" pattern="yyyyMMddhhmm" var="nowDate" scope="application"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/member.css"><c:param name="dt" value="${nowDate }"/></c:url>" media="all" />
	<link rel="stylesheet" type="text/css" href="http://www.bacoder.kr/webpr/css/style.css" />
	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script type="text/javascript">
	function formSubmit(){
		var pwd = $("input[name='password']").val();
		var pwd_confirm = $("input[name='password_confirm']").val();
		
		if(pwd.length < 1){
			toast({text:"비밀번호를 1자 이상으로 설정해주세요."});
			$("input[name='password']").focus();
			return false;
		}
		if(pwd != pwd_confirm){
			toast({text:"비밀번호가 일치하지 않습니다."});
			$("input[name='password_confirm']").focus();
			return false;
		}
		if(confirm("회원가입 하시겠습니까?")){
			$("form").submit();
		}
	}
	</script>
</head>
<body>
<div class="wrap">
<header><c:import url="/inc/header"></c:import></header>
<div class="container_wrap">
<div class="container">
<!-- 컨텐츠 시작 -->

<div id="join_step2" class="page member">
	<form method="post" action="<c:url value="/sign/insert"/>">
		
		<div class="info">
			<strong>회원가입</strong>
			<div>
				<dl>
					<dt>아이디</dt>
					<dd><input type="text" name="login" placeholder="아이디를 입력하세요."/></dd>
				</dl>
				<dl>
					<dt>비밀번호</dt>
					<dd>
						<input type="password" name="password"/>
					</dd>
				</dl>
				<dl>
					<dt>비밀번호 확인</dt>
					<dd><input type="password" name="password_confirm"/></dd>
				</dl>
			</div>
			<div>
				<dl>
					<dt>전화번호</dt>
					<dd><input type="text" name="user_phon" placeholder="전화번호 입력하세요"/></dd>
				</dl>
				<dl>
					<dt>이름</dt>
					<dd><input type="text" name="username" placeholder="이름을 입력하세요"/></dd>
				</dl>
				<dl>
					<dt>생년월일</dt>
					<dd><input type="text" name="birth" placeholder="생년월일을 입력하세요"/></dd>
				</dl>
				
			</div>
		</div>
			
		<input type="button" value="회원가입" class="bt1" onclick="javascript:formSubmit();"/>
	</form>
</div>
<!-- 컨텐츠 끝 -->
</div>
</div>
<footer><c:import url="/inc/footer"></c:import></footer>
</div>
</body>
</html>