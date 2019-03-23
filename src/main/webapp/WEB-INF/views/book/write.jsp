<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseUrl" value="${pageContext.request.contextPath}"></c:set>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>도서 작성</title>
	
	<link rel="stylesheet" type="text/css" href="http://www.bacoder.kr/webpr/css/style.css" />
	<link href="http://www.bacoder.kr/webpr/css/table.css" rel="stylesheet" type="text/css" media="all">
	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script type="text/javascript">
	function ConvertSystemSourcetoHtml(str){
		 str = str.replace(/</g,"&lt;");
		 str = str.replace(/>/g,"&gt;");
		 str = str.replace(/\"/g,"&quot;");
		 str = str.replace(/\'/g,"&#39;");
		 str = str.replace(/\n/g,"<br />");
		 console.log(str);
		 return str;
	}
	function insertBook(){
		//var body = ConvertSystemSourcetoHtml($("textarea").val());
		//$("textarea").val(body);
		
		if(confirm("저장하시겠습니까?")){
			$("form").submit();
		}
	}
	function openFileUpload(homeUrl){
		var child = window.open(homeUrl+"/photo_upload",
				"mywindow","menubar=1,resizable=1,width=380,height=250");
	}
	</script>
</head>
<body>
	<div class="wrap">
		<c:import url="/inc/header"></c:import>
		<div class="container_wrap">
			<div class="container">
				<form id="write" action="${baseUrl}/book/insertBook">
					<table>
						<thead>
							<tr>
								<th colspan="2">도서정보 입력하기</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>제목</td>
								<th>
									<input name="title" placeholder="제목을 입력해 주세요."/>
								</th>
							</tr>
							<tr>
								<td>글쓴이
								</td>
								<th>
									<input name="writer" placeholder="작성자" type="text"/>
								</th>
							</tr>
							<tr>
								<td>가격</td>
								<td><input type="text" name="price" placeholder="가격"/></td>
							</tr>
							<tr>
								
							
								<td colspan="2">
									<input type="button" onclick="openFileUpload('${baseUrl}');" value="사진올리기"/>	
									<input type="hidden" id="targetUpload" name="photoUrl"/>
									<img src="" id="temp_src" width="300"/>
								</td>
							</tr>
						</tbody>
					</table>
					<input type="button" value="글작성" onclick="javascript:insertBook();">
				</form>
			</div>
		</div>
	</div>
</body>
</html>