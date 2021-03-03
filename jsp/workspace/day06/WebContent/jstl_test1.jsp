<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL TEST(변수)</title>
</head>
<body>
	<h2>JSTL TEST(변수)</h2>
	<!-- var : 변수명, value : 값, scope : 영역 설정 -->
	<!-- var에 기존에 있는 변수명을 쓰면 값 수정 -->
	<c:set var="name" value="홍길동" scope="page"/>
	<c:out value="${name}"/>
	
	<!-- EL문 앞에 \를 붙이면 EL문으로 표현이 안된다. -->
	<br>\${name} ===> &dollar;${name}
	<hr>
	<!-- value에다 안넣고 태그 사이에 넣어도 된다. -->
	<c:set var="nation" scope="session">한국</c:set>
	<!-- 선언한 변수 해제시키기 -->
	<%-- <c:remove var="nation" scope="session"/> --%>
	<!-- 삭제가 되면 default가 출력, 삭제가 안되면 value가 출력 -->
	nation 삭제 후 값은 >> [<c:out value="${nation}" default="국가정보없음"/>] >> 변수 값이 삭제됨
	<br>
	<c:set var="data1" value="10"/>
	<c:set var="data2" value="${20}"/>
	<c:set var="data3">30.5</c:set>
	
	<!-- EL문 안에서 문자열이어도 숫자로만 이뤄져있으면 연산이 된다. -->
	총 합은 ${data1+data2+data3}
	
	
	
		
</body>
</html>