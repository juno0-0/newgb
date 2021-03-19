<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 성공</title>
</head>
<body>
	<%=request.getParameter("name")%>님 환영합니다.
	<a href="login.jsp">로그인 페이지로 이동</a>

<%-- 	<%
		String name = request.getParameter("name");
	%>
	<input type="hidden" name="name" value=<%=name %>>
	
	<h2>회원가입에 성공</h2>
	<p><b id="printName"></b>님 반갑습니다.</p> --%>
</body>
<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script>
	var name = $("input[name='name']").val();
	$("#printName").text(name);
</script> -->
</html>