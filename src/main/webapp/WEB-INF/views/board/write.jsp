<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>form action</title>
	
	<link rel="stylesheet" type="text/css" href="http://www.bacoder.kr/webpr/css/style.css" />
	<link href="http://www.bacoder.kr/webpr/css/table.css" rel="stylesheet" type="text/css" media="all">
	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script type="text/javascript">
	function insertBoard(){
		if(confirm("저장하시겠습니까?")){
			$("form").submit();
		}
	}
	function openFileUpload(){
		var child = window.open("/photo_upload",
				"mywindow","menubar=1,resizable=1,width=380,height=250");
	}
	</script>
</head>
<body>
	<div class="wrap">
		<c:import url="/inc/header"></c:import>
		<div class="container_wrap">
			<div class="container">
				<form id="write" action="/board/insertBoard">
					<table>
						<thead>
							<tr>
								<th>
									<input name="title" placeholder="제목을 입력해 주세요."/>
								</th>
								<th>
									<input name="" placeholder="작성자" value="${user.username }" readonly>
									<input type="hidden" name="writer" value="${user.id}" /> 
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>사진업로드</td>
								<td>
									<input type="button" onclick="openFileUpload();" value="사진올리기"/>	
									<input type="hidden" id="targetUpload" name="photoUrl"/>							
								</td>
							<tr>
								<td colspan="2">
									<textarea rows="20" cols="100" name="content" placeholder="내용입력"></textarea>
								</td>
							</tr>
						</tbody>
					</table>
					<input type="button" value="글작성" onclick="javascript:insertBoard();">
				</form>
			</div>
		</div>
	</div>
</body>
</html>