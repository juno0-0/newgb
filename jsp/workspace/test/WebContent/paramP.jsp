<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>이름 : <%=request.getParameter("name")%></p>
	<p>직업 : <%=request.getParameter("job")%></p>
</body>
</html>