<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>도서리스트</title>
	<link rel="stylesheet" type="text/css" media="all" href="http://www.bacoder.kr/webpr/css/table.css" >
	<link rel="stylesheet" type="text/css" href="http://www.bacoder.kr/webpr/css/style.css" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/board.css"/>" />
	<script src="<c:url value="/resources/js/board.js"><c:param name="dt" value="${nowDate }"/></c:url>"></script>
	</head>
	<body>
		<div class="wrap">
		<c:import url="/inc/header"></c:import>
			<div class="container_wrap">
				<div class="container">
				
					<form action="<c:url value="/book/list"/>">
						<input type="text" placeholder="작성자/제목 검색" name="search" value="${book.search }"/>
						<input type="submit" value="검색"/>
						<sec:authorize access="isAuthenticated()">
							<input type="button" value="새글작성" onclick="javascript:window.location.href='<c:url value='/book/write'/>'"/>
						</sec:authorize>
						<sec:authorize access="isAnonymous()">
							글을 작성하시려면 로그인해주세요
						</sec:authorize>
						<input type="button" value="정렬" onclick="javascript:orderSubmit('${book.orderById}');"/>
						<input type="hidden" value="${book.orderById }" name="orderById"/>
						<input type="hidden" value="${book.pageNo }" name="page"/>
						<span style="float:right;">총<c:out value="${book.totalCount }"/>개의 게시글</span>
					</form>
					
					<c:set var="textNum" value="번호" scope="page"/>
					<c:set var="textTitle" value="제목" scope="page"/>
					<c:set var="textWriter" value="글쓴이" scope="page"/>
					<c:set var="textPrice" value="가격" scope="page"/>
					<table>
						<colgroup>
							<col width="10%">
							<col width="50%">
							<col width="20%">
							<col width="10%">
						</colgroup>
						<thead>
							<tr>
								<th><c:out value="${textNum }"/></th>
								<th><c:out value="${textTitle }"/></th>
								<th><c:out value="${textWriter }"/></th>
								<th><c:out value="${textPrice }"/></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${list }" var="item">
							<tr>
								<td>${item.id}</td>
								<td>
									<a href="<c:url value="/book/detail?id=${item.id}"/>">
										${item.title}
									</a>
								</td>
								<td>${item.writer}</td>
								<td>${item.price}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					
					<div class="board-list-page">
						<c:forEach begin="1" end="${book.endPageNo }" varStatus="status">
							<a href="javascript:movePage('${status.index }')" class="fc-blue board-list-page-num<c:if test="${pageNum == status.index}">-on</c:if>">${status.index}</a>
						</c:forEach>
					</div>
					
				</div>
			</div>
		</div>
	</body>
</html>