<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 데이터를 전달하는 곳에서 인코딩 설정을 해준다. -->
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>param 액션 태그</title>
</head>
<body>
	<h3>param 액션 태그</h3>
	<hr>
	<jsp:forward page="paramP.jsp">
		<jsp:param value="admin" name="id"/><!-- <input>처럼 name이 key, value가 value -->
		<jsp:param value="관리자" name="name"/>
	</jsp:forward>
</body>
</html>