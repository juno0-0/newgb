<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%response.setContentType("text/html; charset=UTF-8");%>
<%response.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="get_test.jsp" name="test" method="post">
		<input type="text" name="name" value="이지은">
		<input type="text" name="age" value="29">
		<input type="submit" value="GET방식으로 이동!">
	</form>
</body>
</html>