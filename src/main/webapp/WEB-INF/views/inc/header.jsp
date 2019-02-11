<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<script src="<c:url value="/resources/js/sweetalert2.all.min.js"><c:param name="dt" value="${nowDate }"/></c:url>"></script>
<script type="text/javascript">
function logoutClick(){
	swal({
		title : "로그아웃",
		text : "로그아웃 하시겠습니까?",
		type : "question",
		confirmButtonText : "확인",
		showCancelButton : true,
		cancelButtonText : "취소"
	}).then(function(isYes){
		if(isYes.value){
			window.location.replace("<c:url value='/j_spring_security_logout'/>");
		}
	});
}
</script>
<header>
	<div>
		<ul>
			<li><a href="<c:url value="/"/>">첫화면</a></li>
			<li><a href="<c:url value="/board/list"/>">게시판</a></li>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="<c:url value="/admin/list"/>">관리자</a></li>
			</sec:authorize>
		</ul>
		<sec:authorize access="isAnonymous()">
			<a href="<c:url value="/sign/login"/>">로그인</a>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<a href="javascript:logoutClick();">로그아웃</a>
			<span>${user.username }님 </span>
		</sec:authorize>
	</div>
</header>