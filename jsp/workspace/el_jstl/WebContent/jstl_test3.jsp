<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 연습3</title>
</head>
<body>
	<c:set var="id" value="asdfasd" scope="page"/>
	<c:if test="${id == 'admin'}">
		<c:out value="관리자 ${id}이다!"/>
	</c:if>
	<c:if test="${id == 'member'}">
		<c:out value="일반회원 ${id}이다!"/>
	</c:if>
	<c:if test="${id == 'dsfsf'}">
		<c:out value="비회원 ${id}이다!"/>
	</c:if>
	<br>
	<c:choose>
		<c:when test="${id == 'admin'}">
			<c:out value="관리자입니다."/>
		</c:when>
		<c:when test="${id == 'member'}">
			<c:out value="일반 회원입니다."/>
		</c:when>
		<c:otherwise>
			<c:out value="비회원입니다.${id}"/>
		</c:otherwise>
	</c:choose>
	
</body>
</html>