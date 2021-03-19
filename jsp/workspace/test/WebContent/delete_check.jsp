<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 삭제 확인</title>
</head>
<body>
	<% 
		String cookie = request.getHeader("Cookie");
		if(cookie == null){
	%>
		<p>비어있음!</p>
	<%
		}
	%>
</body>
</html>