<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>${board.title }</title>
		<link rel="stylesheet" type="text/css" href="http://www.bacoder.kr/webpr/css/style.css" />
		<link rel="stylesheet" type="text/css" media="all" href="http://www.bacoder.kr/webpr/css/table.css">
		
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script type="text/javascript">
		function deleteBoard(url, id){
			if(confirm("삭제 하시겠습니까?")){
				window.location.replace(url + "?id=" + id);
			}
		}
		function moveUpdatePage(url, id){
			if(confirm("수정페이지로 이동 하시겠습니까?")){
				window.location.replace(url +"?id=" + id);
			}
		}
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
								<th>제목: </th><th>${board.title }</th>
							</tr>
							<tr>
								<th>글쓴이: </th><th>${board.username }</th>
							</tr>
							<tr>
								<th>작성일: </th><th>${board.wdate }</th>
							</tr>
						</thead>
						<tbody>
							<tr><td colspan="2">내용</td></tr>
							<tr>
								<td colspan="2">
								${board.content }
								</td>
							</tr>
							<tr>
								<td colspan="2">
								<img src="<c:url value="${board.photoUrl }"/>"/>
								</td>
							</tr>
						</tbody>
					</table>
					<c:if test="${user.id == board.writer }">
						<input type="button" value="수정" onclick="javascript:moveUpdatePage('${updateDir}','${board.id}')">
						<input type="button" value="삭제" onclick="javascript:deleteBoard('${deleteDir}','${board.id}')">
					</c:if>
				</div>
			</div>
		</div>
	</body>
</html>