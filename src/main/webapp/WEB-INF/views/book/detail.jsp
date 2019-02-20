<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>${book.title }</title>
		<link rel="stylesheet" type="text/css" href="http://www.bacoder.kr/webpr/css/style.css" />
		<link rel="stylesheet" type="text/css" media="all" href="http://www.bacoder.kr/webpr/css/table.css">
		<body>
		<div class="wrap">
			<c:import url="/inc/header"></c:import>
			<div class="container_wrap">
				<div class="container">
				현재 보시는 화면은 ${book.title } 화면 입니다.
				</div>
			</div>
		</div>
	</body>
</html>