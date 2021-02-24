<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>응답 페이지</title>
</head>
<body>
	<!-- 값이니까 표현식 안에 쓴다. -->
	<p>아이디 : <%=request.getParameter("id")%></p><!-- out.write()에 들어갈 값이라서 ;을 쓰면 안된다. -->
	<p>이름 : <%=request.getParameter("name")%></p>
</body>
</html>