<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="http://www.bacoder.kr/webpr/css/style.css" />
</head>
<body>
<div class="wrap">
<header><c:import url="/inc/header"></c:import></header>
	<div class="container_wrap">
		<div class="container">
		<!-- 컨텐츠 시작 -->
		<div id="login" class="member">
			<form class="form1" action="<c:url value="/j_spring_security_check"/>" method="post">
				<dl>
					<dd><input type="text" name="loginid" value="${loginid }" required placeholder="아이디를 입력하세요."/></dd>
				</dl>
				<dl>
					<dd><input type="password" name="loginpwd" 	placeholder="비밀번호를 입력하세요." required 
								value="${loginpwd }"/></dd>
				</dl>
				<c:if test="${not empty securityexceptionmsg }">
					<span id="error_msg" class="error" >${securityexceptionmsg}</span>
				</c:if>
				<input type="hidden" name="loginRedirect" value="${loginRedirect }"/>
				<input type="submit" value="로그인" class="bt1" />
			</form>
			<a href="/sign/find">아이디/비밀번호 찾기</a>
			<a href="/sign/signup">회원가입</a>
		</div>
		<!-- 컨텐츠 끝 -->
		</div>
	</div>
<footer><c:import url="/inc/footer"></c:import></footer>
</div>
</body>
</html>