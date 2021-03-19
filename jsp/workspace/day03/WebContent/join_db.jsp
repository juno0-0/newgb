<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="com.koreait.beans.TABLE_MEMBER_VO"></jsp:useBean>
<jsp:useBean id="dao" class="com.koreait.beans.TABLE_MEMBER_DAO"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		member.setId(request.getParameter("id")); 
		member.setName(request.getParameter("name"));
		member.setPassword(request.getParameter("password"));
		member.setGender(request.getParameter("gender"));
		member.setZipcode(request.getParameter("zipcode"));
		member.setAddress(request.getParameter("address"));
		member.setAddressDetail(request.getParameter("adress_detail"));
		member.setAddressEtc(request.getParameter("adress_etc"));
		
		if(dao.join(member) != 0){
			response.sendRedirect("join_finish.jsp");
		}else{
	%>
			alert("회원가입 실패");
	<%		
			response.sendRedirect("join.jsp");
		}
	%>
</body>
</html>