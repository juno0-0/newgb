<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GET 방식의 요청</title>
</head>
<body>
	<h1>GET 방식의 요청</h1>
	<%
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		
		if(city == null || zipcode == null){
			response.sendRedirect("post_test.jsp");	/* sendRedirect() : 매개값으로 받은 url로 이동 */	
		}else{
	%>
	<form action="get_test.jsp" method="get">	<!-- method에 get인지 post인지 적을 수 있다. 생략하면 get -->
		<input type="text" name="city" value="Seoul" readonly>
		<input type="text" name="zipcode" value="06141" readonly>
		<button type="submit">GET 방식으로 요청 보내기!</button>
	</form>
	<p><%=city%>,<%=zipcode%></p>
	<%}%>
</body>
</html>