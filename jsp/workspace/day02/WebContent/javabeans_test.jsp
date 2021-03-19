<%@page import="com.koreait.beans.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.koreait.beans.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="com.koreait.beans.MemberVO" id="member"/>
<%-- <%MemberVO vo = new MemberVO();%>와 같은 것 --%>
<jsp:useBean class="com.koreait.beans.MemberDAO" id="dao"/>
<%-- <%MemberDAO dao = new MemberDAO();%>와 같은 것 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바빈즈 예제</title>
</head>
<body>
	<!-- HTML 주석 : 여기서 주석은 HTML 주석이라서 컴파일은 되지만 표현만 되지 않는 것이라서 적용이 되버린다. -->
	<%-- JSP 주석 : 여기서 주석은 컴파일도 되지 않는다. --%>
	
	<%-- <jsp:setProperty property="name" name="member" value="한동석"/>	property는 필드명(getName 안해도 된다.), name은 객체명, value는 넣을 값
	<jsp:setProperty property="birthday" name="member" value="12-04"/> --%>
	
	<jsp:getProperty property="name" name="member"/><!-- property : 필드명, name : 객체명 -->
	<jsp:getProperty property="birthday" name="member"/>
	
	<%-- MVC 모델 중에서 model1 --%>
	<table>
	<%ArrayList<MemberVO> members = dao.select("홍길동");%>
	<%for(int i=0; i<members.size(); i++){%>
		<tr>
			<td><%=members.get(i).getName()%></td>
			<td><%=members.get(i).getBirthday()%></td>
		</tr>
	<%}%>
	</table>
</body>
</html>