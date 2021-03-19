<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="join.example.MemberDAO"/>
	<%if(dao.dupCheck(request.getParameter("id"))){
		out.print("ok");
	}else{
		out.print("not-ok");
	}%>