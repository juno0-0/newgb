<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 실습</title>
</head>
<body>
<!--
	사용자에게 이름을 입력받고 확인버튼을 눌렀을 때
	admin일 경우 "관리자", member일 경우 "일반 회원", 그 외에는 "비회원(전달받은 이름)"을 출력한다.
	
	※ 다른 페이지 없이 현재 페이지 하나에서만 처리하고, 결과가 출력될 때에는 input태그와 submit버튼이 나오게 해서는 안된다.
	※ form태그의 속성은 action을 생략하면 현재 페이지로 이동이 된다.
	※el과 jstl만 사용한다(자바스크립트 금지)
-->
	
	<c:set var="name" value="${param.test}" scope="request" />
	
	<c:choose>
		<c:when test="${empty name}">
		<%-- name에 아무것도 들어있지 않을 경우 <form>를 제공한다.--%>
		<%-- 처음 실행하였을 경우도 name에는 아무것도 들어있지 않기 때문에 이쪽으로 들어온다.--%>
			<form>
				<input type="text" name="test">
				<button>확인</button>
			</form>
		</c:when>
		<c:when test="${name == 'admin'}">관리자</c:when>
		<c:when test="${name == 'member'}">일반 회원</c:when>
		<c:otherwise>비회원(<c:out value="${name}"/>)</c:otherwise>
	</c:choose>
</body>
</html>