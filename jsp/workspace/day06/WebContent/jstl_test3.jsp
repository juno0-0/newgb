<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL TEST(제어문-조건문)</title>
</head>
<body>
	<c:set var="id" value="admin"/>
	<%-- <c:if test="조건식"/> --%>
	<!-- 조건식 : 참 또는 거짓 중 하나의 결과가 나오는 식 -->
	<c:if test="${id == 'admin'}">
		현재 로그인 된 계정은 <c:out value="${id}"/> 계정입니다.
	</c:if>
	<c:if test="${id == 'member'}">
		현재 로그인 된 계정은 일반 계정입니다.
	</c:if>
	<hr>
	<c:set var="id">hds1234</c:set>
	choose문 사용(else if, else는 choose문으로 표현한다).<br>
	
	<!-- 위에가 참이면 밑에꺼는 실행안됨. -->
	<c:choose>
		<c:when test="${id=='admin'}">관리자</c:when>
		<c:when test="${id=='member'}">회원</c:when>
		<c:otherwise>비회원</c:otherwise>
	</c:choose>
</body>
</html>