<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 출력, 쿠키 수정</title>
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
				break;
			}
		}
	
%>
	<p>아이디 : <%=id %></p>
<% 
		for(Cookie c : cookies){
			if(c.getName().equals("id")){//수정할 id가 있는지 확인
				//key에 value가 없으면 추가
				//key에 value가 있으면 수정
				Cookie new_cookie = new Cookie("id", "banana");
				response.addCookie(new_cookie);
				break;
			}
		}
	}
%>
	<a href="getCookie2.jsp">변경된 쿠기 값 확인</a>
</body>
</html>