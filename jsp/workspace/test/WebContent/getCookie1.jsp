<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%response.setCharacterEncoding("UTF-8");%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 확인 및 쿠키 수정</title>
</head>
<body>
	<%
		String cookie = request.getHeader("Cookie");
		String id = null;
		
		if(cookie != null){
			Cookie[] cookies = request.getCookies();
			for(Cookie c : cookies){
				if(c.getName().equals("id")){
					id = c.getValue();
	%>
					<p><%=id %></p>
	<% 
					Cookie new_cookie = new Cookie("id","아이유");
					response.addCookie(new_cookie);
					break;
				}
			}
		}
	%>
	<a href="getCookie2.jsp">변경된 쿠키값 확인</a>
</body>
</html>