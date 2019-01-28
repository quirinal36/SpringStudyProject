<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>User List</title>
	<link href="http://www.bacoder.kr/webpr/css/table.css" rel="stylesheet" type="text/css" media="all">
	<link rel="stylesheet" type="text/css" href="http://www.bacoder.kr/webpr/css/style.css" />
	
	</head>
	<body>
		<div class="wrap">
		<header>
			<div>
				<ul>
					<li><a href="<c:url value="/"/>">유저 리스트</a></li>
					<li><a href="<c:url value="/board/list"/>">게시판</a></li>
					<li><a href="<c:url value="/"/>">소개하기</a></li>
				</ul>
				<a href="<c:url value="/sign/login.jsp"/>">로그인</a>
			</div>
		</header>
		<div class="container">
			<form action="<c:url value="/board/list"/>">
				<input type="text" placeholder="작성자검색" name="writer" value="${search }"/>
				<input type="submit" value="검색"/>
				<input type="button" value="새글작성" onclick="javascript:window.location.href='/board/write'"/>
			</form>
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list }" var="item">
					<tr>
						<td>${item.id}</td>
						<td>
							<a href="/board/detail?id=${item.id}">
								${item.title}
							</a>
						</td>
						<td>${item.writer}</td>
						<td>${item.date}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</div>
			<footer>
				<p>ⓒ 회사명.</p>
			</footer>
		</div>
		
	</body>
</html>