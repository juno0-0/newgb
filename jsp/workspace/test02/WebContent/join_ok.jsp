<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="join.TABLE_MEMBER_DAO"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- DB에서 조회 -->
<!-- 여기서 DAO에 있는 결과를 사용 -->
<!-- out.println()을 사용하여 조회 결과 출력 -->
<%response.sendRedirect("join.jsp?check="+dao.dupId(request.getParameter("id")));%>
<%-- <% if(dao.dupId(request.getParameter("id"))){ out.println("중복된 아이디입니다.");}else{out.println("사용할 수 있는 아이디입니다.");}%> --%>
</body>
</html>