<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 디렉티브 태그 예제</title>
</head>
<body>
	<!-- 헤더 영역 -->
	<%@ include file = "header.jsp" %><!-- 디렉티브 include -->
	<hr>
	<h4>-----------현재 페이지 영역-------------</h4>
	<hr>
	<!-- 푸터 영역 -->
	<jsp:include page = "footer.jsp" /><!-- 액션 include 얘를 좀 더 잘 쓴다.--> 
</body>
</html>