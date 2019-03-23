<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>게시판</title>
	<link rel="stylesheet" type="text/css" media="all" href="http://www.bacoder.kr/webpr/css/table.css" >
	<link rel="stylesheet" type="text/css" href="http://www.bacoder.kr/webpr/css/style.css" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/board.css"/>" />
	<script src="<c:url value="/resources/js/board.js"><c:param name="dt" value="${nowDate }"/></c:url>"></script>
	
	<script type="text/javascript">
	function orderSubmit(order){
		order = order > 0 ? 0 : 1;
		
		$("input[name='orderById']").val(order);
		$("form").submit();
	}
	</script>
	
	</head>
	<body>
		<div class="wrap">
		<c:import url="/inc/header"></c:import>
			<div class="container_wrap">
				<div class="container">
					<form action="<c:url value="/board/list"/>">
						<input type="text" placeholder="작성자/제목 검색" name="search" value="${board.search }"/>
						<input type="submit" value="검색"/>
						<sec:authorize access="isAuthenticated()">
							<input type="button" value="새글작성" onclick="javascript:window.location.href='<c:url value='/board/write'/>'"/>
						</sec:authorize>
						<sec:authorize access="isAnonymous()">
							글을 작성하시려면 로그인해주세요
						</sec:authorize>
						<input type="button" value="정렬" onclick="javascript:orderSubmit('${board.orderById}');"/>
						<input type="hidden" value="${board.orderById }" name="orderById"/>
						<input type="hidden" value="${board.pageNo }" name="page"/>
						<span style="float:right;">총<c:out value="${board.totalCount }"/>개의 게시글</span>
					</form>
					
					<c:set var="textNum" value="번호" scope="page"/>
					<c:set var="textTitle" value="제목" scope="page"/>
					<c:set var="textWriter" value="글쓴이" scope="page"/>
					<c:set var="textDate" value="날짜" scope="page"/>
					<table>
						<thead>
							<tr>
								<th><c:out value="${textNum }"/></th>
								<th><c:out value="${textTitle }"/></th>
								<th><c:out value="${textWriter }"/></th>
								<th><c:out value="${textDate }"/></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${list }" var="item">
							<tr>
								<td>${item.id}</td>
								<td>
									<a href="<c:url value="/board/detail?id=${item.id}"/>">
										${item.title}
									</a>
								</td>
								<td>${item.username}</td>
								<td>${item.wdate}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					
					<div class="board-list-page">
						<c:forEach begin="1" end="${board.endPageNo }" varStatus="status">
							<a href="javascript:movePage('${status.index }')" class="fc-blue board-list-page-num<c:if test="${pageNum == status.index}">-on</c:if>">${status.index}</a>
						</c:forEach>
					</div>

				</div>
			</div>
			<footer>
				<p>ⓒ 회사명.</p>
			</footer>
		</div>
		
	</body>
</html>