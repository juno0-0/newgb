<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean class="com.koreait.beans.TABLE_MEMBER_VO" id="vo" />
<jsp:setProperty property="*" name="vo"/>
<!-- value는 자동으로 매핑되서 들어간다. 단, 반드시 파라미터의 KEY(name)값과 해당 객체의 필드명이 일치해야 정확한 값이 들어간다. -->
<!-- 없으면 안들어간다. -->
<jsp:useBean class="com.koreait.beans.TABLE_MEMBER_DAO" id="dao" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		String url = "";
		//전달받은 데이터들을 DB에 INSERT 한다.
		if(dao.join(vo)){
			//회원가입 성공
			//sendRedirect() 방식으로 쿼리 스트링에 한글 데이터를 전달할 때 반드시 인코딩을 직접 설정해주어야 한다.
			url = "join_finish.jsp?name="+URLEncoder.encode(vo.getName(),"UTF-8");
			//전송할 때 charset을 바꿔준다.
			//URLEncoder.encode()를 사용한다.
		}else{
			//회원가입 실패
			url = "join.jsp?check=false";//check가 null이면 정상, false면 회원가입 실패
		}
		
		response.sendRedirect(url);
	%>
<%-- 	<%
		response.setContentType("text/html; charset=UTF-8;");
		
		vo.setId(request.getParameter("id"));
		vo.setName(request.getParameter("name"));
		vo.setPassword(request.getParameter("password"));
		vo.setGender(request.getParameter("gender"));
		vo.setZipcode(request.getParameter("zipcode"));
		vo.setAddress(request.getParameter("address"));
		vo.setAddressDetail(request.getParameter("address_detail"));
		vo.setAddressEtc(request.getParameter("address_etc"));
		
		if(dao.join(vo)){
			//회원가입 성공
			response.sendRedirect("join_finish.jsp?name="+vo.getName());
			System.out.print("회원가입 성공");
		}else{
			//회원가입 실패
			System.out.print("회원가입 실패");
		}
	%> --%>
</body>
</html>