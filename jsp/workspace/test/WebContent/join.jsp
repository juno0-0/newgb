<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join_db.jsp" name="joinForm">
		<p>
			<label>아이디 : <input type="text" name="id" id="id"></label>
			<input type="button" value="중복 확인" onclick="sendIt()">
		</p>
		<p id="result"></p>
		<p>
			<label>이름 : <input type="text" name="name"></label>
		</p>
		<p>
			<label>패스워드 : <input type="password" name="password"></label>
		</p>
		<p>
			<label>패스워드 확인 : <input type="password" name="password_re"></label>
		</p>
		<p>
			성별 : <label><input type="radio" name="gender" value="남자" checked></label>
			<label><input type="radio" name="gender" value="여자"></label>
		</p>
		<p>
			<input type="text" name="zipcode" class="postcodify_postcode5" value="" readonly/>
			<input type="button" id="postcodify_search_button" value="검색"><br />
		</p>
		<p>
			주소 : <input type="text" name="address" class="postcodify_address" value="" readonly/><br />
		</p>
		<p>
			상세 주소 : <input type="text" name="adress_detail" class="postcodify_details" value="" /><br />
		</p>
		<p>
			참고 항목 : <input type="text" name="adress_etc" class="postcodify_extra_info" value="" /><br />		
		</p>
		<p>
			<input type="button" value="가입 완료" onclick="join()">	
		</p>
	</form>
</body>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>
<script src="member.js"></script>
</html>