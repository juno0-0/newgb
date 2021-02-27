<%@page import="javabeans.example.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="vo" class="javabeans.example.MemberVO"/>
<jsp:useBean id="dao" class="javabeans.example.MemberDAO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <jsp:setProperty property="name" name="vo" value="이지은"/>
	<jsp:setProperty property="birthday" name="vo" value="12-25"/>
	
	<jsp:getProperty property="name" name="vo"/>
	<jsp:getProperty property="birthday" name="vo"/> --%>
	
	<table>
		<% ArrayList<MemberVO> list =  dao.select("조유리");
			for(int i=0; i<list.size(); i++){%>
			<tr>
				<td>이름 : <%=list.get(i).getName()%></td>
				<td>생일 : <%=list.get(i).getBirthday()%></td>
			</tr>		
		<%}%>
	</table>
</body>
</html>