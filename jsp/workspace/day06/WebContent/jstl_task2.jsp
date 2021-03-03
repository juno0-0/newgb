<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 실습(제어문 - 반복문)</title>
</head>
<body>
<!--
	1단 부터 100단까지 중 사용자에게 입력받은 단수로 구구단 출력하기.
	입력받은 값이 정수인지 아닌지 판단, 값을 입력했는지 안했는지 판단.
	다른 페이지 이동 없이 현재 페이지에서만 기능 구현
	자바스크립트 사용 가능(Number.isInteger(값) : boolean) 
-->
	<h2>JSTL 실습(제어문 - 반복문)</h2>
	<form name="frm">
		단수 : <input type="text" id="num" name="num" placeholder="정수 입력">
		<input type="button" value="확인" onclick="check()">
	</form>
	<c:set var="num" value="${param.num}"/>
	<!-- if : 값이 들어오지 않았을 때(버튼을 클릭하지 않았을 때 검사) -->
	<!-- otherwise : 1보다 작고 100보다 클 때 -->
	<!-- when : 입력한 값이 0보다 크고 101보다 작을 때 -->
	<c:if test="${!empty num}">
		<c:choose>
			<c:when test="${num > 0 && num < 101}">
				<c:forEach var="i" begin="1" end="9">
					<c:out value="${num} * ${i} =  ${num * i}"/><br>
				</c:forEach>
			</c:when>
			<c:otherwise>
				1~100까지만 입력하세요.
			</c:otherwise>
		</c:choose>
	</c:if>
	
	
</body>
<!-- jQuery는 사용하지 않는다. -->
<script>
	//엔터 막기, 엔터를 누르면 onclick으로 안가고 바로 submit으로 이동한다.
	//앞으로 자주 사용할 것
	document.addEventListener('keydown', function(){
		if(window.event.keyCode == 13){
			event.preventDefault();
		}
	})
	
	function check(){
		var frm = document.frm;
		var input = document.frm.num.value;/* 여기까지만 하면 문자열 타입의 숫자이기 때문에 isInteger에서 문자열로 인식하므로 Number.parseInt()를 해준다. */
		var check = input % 1 == 0;
		
		if(!check || input == "" || !Number.isInteger(Number.parseInt(input))){
			alert("정수를 입력해주세요");
			frm.num.focus();
			return false;
		}
		frm.num.value = parseInt(input);
		frm.submit();
	}
</script>
</html>