<%@page import="task02.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="task02.MemberVO"/>
<jsp:useBean id="dao" class="task02.MemberDAO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바빈즈 예제2</title>
</head>
<body>
	<jsp:getProperty property="name" name="member"/>
	<table>
		<%ArrayList<MemberVO> members = dao.select("홍길동");%>
		<%for(int i=0; i<members.size(); i++){ %>
			<tr>
				<td><%=members.get(i).getName()%></td>
				<td><%=members.get(i).getBirthday()%></td>
			</tr>
		<%}%>
	</table>
</body>
</html>