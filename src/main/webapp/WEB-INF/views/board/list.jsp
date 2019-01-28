<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>User List</title>
	<link rel="stylesheet" type="text/css" media="all" href="http://www.bacoder.kr/webpr/css/table.css" >
	<link rel="stylesheet" type="text/css" href="http://www.bacoder.kr/webpr/css/style.css" />
	
	</head>
	<body>
		<div class="wrap">
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
			<div class="container_wrap">
				<div class="container">
					<form action="<c:url value="/board/list"/>">
						<input type="text" placeholder="작성자검색" name="writer" value="${board.writer }"/>
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
								<td>${item.wdate}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<footer>
				<p>ⓒ 회사명.</p>
			</footer>
		</div>
		
	</body>
</html>