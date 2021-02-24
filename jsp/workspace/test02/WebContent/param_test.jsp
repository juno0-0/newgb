<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>param 예제</title>
</head>
<body>
	<jsp:forward page="paramP.jsp">
		<jsp:param value="이지은" name="iu"/>
		<jsp:param value="29" name="age"/>
	</jsp:forward>
</body>
</html>