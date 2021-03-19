<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 넘겨주는 쪽에서 인코딩 타입을 맞춰준다. -->
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="paramP.jsp">
		<jsp:param value="이지은" name="name"/>
		<jsp:param value="가수" name="job"/>
	</jsp:forward>
</body>
</html>