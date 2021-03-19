<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>거쳐갑니당</title>
</head>
<body>
	<% 
		String site = request.getParameter("test");
		String temp = "";
		
		if(site.equals("네이버")){
			temp = "naver.jsp";
		}else if(site.equals("구글")){
			temp = "";
		}else{
			temp = "";
		}
	%>
	<jsp:forward page="<%=temp%>"/>
</body>
</html>