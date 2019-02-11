<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Spring Framework 를 배워보자</title>
	<link rel="stylesheet" type="text/css" href="http://www.bacoder.kr/webpr/css/style.css" />
	<link rel="stylesheet" type="text/css" href="http://www.bacoder.kr/webpr/css/table.css" />
	</head>
<body>
	<div class="wrap">
		<c:import url="/inc/header"></c:import>
		<div class="container_wrap">
			<div class="container">
				<sec:authorize access="isAuthenticated()">
				<table>
					<thead>
						<tr>
							<th colspan="2">
							현재 사용자 
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>username</td>
							<td><sec:authentication property="principal.username"/></td>
						</tr>
						<tr>
							<td>password</td>
							<td><sec:authentication property="principal.password"/></td>
						</tr>
						<tr>
							<td>enabled</td>
							<td><sec:authentication property="principal.enabled"/></td>
						</tr>
						<tr>
							<td>accountNonExpired</td>
							<td><sec:authentication property="principal.accountNonExpired"/></td>
						</tr>
						<tr>
							<td>user role</td>
							<td><sec:authentication property="principal.authorities"/></td>
						</tr>
					</tbody>
				</table>
				</sec:authorize>
				
				<sec:authorize access="isAnonymous()">
					환영합니다.
				</sec:authorize>
			</div>
		</div>
		<footer>
			<p>ⓒ 회사명.</p>
		</footer>
	</div>
</body>
</html>