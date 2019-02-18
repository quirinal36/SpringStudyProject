<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>form action</title>
	<link rel="stylesheet" type="text/css" href="http://www.bacoder.kr/webpr/css/style.css" />
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<link href="http://www.bacoder.kr/webpr/css/table.css" rel="stylesheet" type="text/css" media="all">
	<script type="text/javascript">
	function saveInfo(){
		if(confirm("저장하시겠습니까?")){
			$("form").submit();
		}
	}
	</script>
</head>
<body>
	<div class="wrap">
		<c:import url="/inc/header"></c:import>
		<div class="container_wrap">
			<div class="container">
				<form id="write" action="/board/updateBoard">
					<table>
						<thead>
							<tr>
								<th>글쓴이: </th><th>${board.username }</th>
							</tr>
							<tr>
								<th>제목: </th><th><input name="title" placeholder="제목을 입력해 주세요." value="${board.title }"/></th>
							</tr>
						</thead>
						<tbody>
							<tr><td colspan="2">내용</td></tr>
							<tr>
								<td colspan="2">
									<textarea rows="20" cols="100" name="content" placeholder="내용입력">${board.content }</textarea>
								</td>
							</tr>
						</tbody>
					</table>
					<input type="hidden" name="id" value="${board.id }">
					<input type="button" value="저장" onclick="javascript:saveInfo();">
				</form>
			</div>
		</div>
	</div>
</body>
</html>