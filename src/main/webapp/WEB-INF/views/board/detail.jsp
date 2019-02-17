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
		function deleteBoard(id){
			if(confirm("삭제 하시겠습니까?")){
				window.location.replace("/board/deleteBoard?id="+id);
			}
		}
		function moveUpdatePage(id){
			if(confirm("수정페이지로 이동 하시겠습니까?")){
				window.location.replace("/board/update?id="+id);
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
								<th>글쓴이: </th><th>${board.writer }</th>
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
					<input type="button" value="수정" onclick="javascript:moveUpdatePage('${board.id}')">
					<input type="button" value="삭제" onclick="javascript:deleteBoard('${board.id}')">
				</div>
			</div>
		</div>
	</body>
</html>