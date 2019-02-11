<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>관리자</title>
	<link rel="stylesheet" type="text/css" media="all" href="http://www.bacoder.kr/webpr/css/table.css" >
	<link rel="stylesheet" type="text/css" href="http://www.bacoder.kr/webpr/css/style.css" />
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script type="text/javascript">
	function updateUser(select, id){
		var selectedVal = $(select).val();
		console.log("selectedVal: " + selectedVal);
		console.log("id: " + id);
		
		swal({
			title:"권한변경",
			text :"권한을 변경하시겠습니까?",
			type : "question",
			confirmButtonText : "확인",
			showCancelButton : true,
			cancelButtonText : "취소"
		}).then(function(isYes){
			if(isYes.value){
				$.ajax({
					url : "/admin/update",
					data : {user_role : selectedVal, id: id},
					type : "GET"
				}).done(function(resp){
					alert("수정성공\n" + resp);
					window.location.reload();
				});
			}
		})
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
								<th>id</th>
								<th>로그인</th>
								<th>이름</th>
								<th>권한</th>
								
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${list }" var="item">
							<tr>
								<td>${item.id}</td>
								<td>
									<a href="<c:url value="/admin/detail?id=${item.id}"/>">
										${item.login}
									</a>
								</td>
								<td>${item.username}</td>
								<td>
									<select id="user_role_select" onchange="updateUser(this, ${item.id})">
										<option value="1" <c:if test="${item.user_role==1}">selected</c:if>>관리자</option>
										<option value="2" <c:if test="${item.user_role==2}">selected</c:if>>유저</option>
									</select>
								</td>
								
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>