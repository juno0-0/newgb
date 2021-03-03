<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 연습</title>
</head>
<body>
	<c:set var="name" value="이지은" scope="page"/>
	<c:out value="${name}"/>
	<hr>
	\${name} --> &dollar;${name}
	<c:set var="id" scope="request">iu</c:set>
	<c:out value="${id}"/><br>
	
	<c:remove var="id" scope="request"/>
	삭제 후 값은 => <c:out value="${id}" default="조유리"/>
	
	<c:set var="data1" value="10"/>
	<c:set var="data2" value="100"/>
	<c:set var="data3" value="1000"/>
	
	<c:out value="${data1+data2+data3}"/>
</body>
</html>