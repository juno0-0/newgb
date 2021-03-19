<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		if(name == null || age == null){
			response.sendRedirect("post_test.jsp");
		}else{
	%>
	<form action="get_test.jsp" name="test" method="get">
		<input type="text" name="name" value="iu">
		<input type="text" name="age" value="29">
		<input type="submit" value="POST방식으로 이동!">
	</form>
	<p><%=name%>, <%= age%></p>
	<%}%>
</body>
</html>