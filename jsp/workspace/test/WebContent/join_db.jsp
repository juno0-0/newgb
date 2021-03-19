<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="dao" class="join.example.MemberDAO"/>
<jsp:useBean id="vo" class="join.example.MemberVO"/>
<jsp:setProperty property="*" name="vo"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		String url = "";
		if(dao.join(vo)){
			url = "join_finish.jsp?name="+URLEncoder.encode(vo.getName(), "UTF-8");
		}else{
			url = "join.jsp?check=false";
		}
		response.sendRedirect(url);
	%>
</body>
</html>