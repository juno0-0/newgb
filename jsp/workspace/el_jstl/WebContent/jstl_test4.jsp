<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL TEST(반복문)</title>
</head>
<body>
	<c:forEach var="i" begin="1" end="20" step="2" varStatus="a">
		<c:out value="${i}"/>
		<c:out value="${ a.count}"/>
	</c:forEach>	
</body>
</html>