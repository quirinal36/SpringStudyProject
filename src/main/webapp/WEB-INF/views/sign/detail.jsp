<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>${board.title }</title>
		<link rel="stylesheet" type="text/css" href="http://www.bacoder.kr/webpr/css/style.css" />
		<link rel="stylesheet" type="text/css" media="all" href="http://www.bacoder.kr/webpr/css/table.css">
		<script type="text/javascript">
		
		</script>
	</head>
	<body>
		<div class="wrap">
			<c:import url="/inc/header"></c:import>
			<div class="container_wrap">
				<div class="container">
						<table>
							<thead>
								<tr>
									<th colspan="2">내정보</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>아이디</td>
									<td>${user.login }</td>
								</tr>
								<tr>
									<td>이름</td>
									<td>${user.username }</td>
								</tr>
							</tbody>
						</table>
						
						<input type="button" value="수정하기" onclick="location.href='/sign/update'"/>
				</div>
			</div>
		</div>
	</body>
</html>