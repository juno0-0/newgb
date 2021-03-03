<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출력의 종류</title>
</head>
<body>
	<!-- 코드로 인식되어 실행된다. -->
	${"<script>alert('안녕')</script>"}
	
	<!-- 코드가 아닌 문자열로 인식하여 출력된다. -->
	<c:out value="<script>alert('안녕')</script>"/>
	
	<!-- escapeXml : default는 true, false로 주면 문자열이 아닌 코드로 인식되어 실행된다. -->
	<c:out value="<script>alert('안녕')</script>" escapeXml="false"/>
	
	
</body>
</html>