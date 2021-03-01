<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="join.example.MemberDAO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
	
		if(dao.login(id, pw)){
			session.setAttribute("userid", id);
			response.sendRedirect("login.jsp");
		}else{
	%>
		<script>
			alert("로그인 실패");
			location.href="login.jsp";
		</script>	
	<%	
		}
	
	%>
</body>
</html>