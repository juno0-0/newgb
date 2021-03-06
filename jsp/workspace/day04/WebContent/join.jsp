<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<!-- 만약 회원가입에 실패해서 join.jsp로 왔다면, check에 false가 담겨있다. -->
	<!-- 하단의 JS부분에서 처리해준다. -->
	<input type="hidden" value="<%=request.getParameter("check")%>" name="joinCheck">
	<form action="join_db.jsp" name="joinForm">
		<p>
			<!-- 아이디를 입력하는 input태그를 클릭하면 사용자가 수정을 시도하는 것으로 판단 -->
			<label>아이디: <input type="text" name="id" id="id" onclick="modifyId()"></label>
			<input type="button" name="idCheckBtn" value="중복 확인" onclick="sendIt()">
		</p>
		<p id="result"></p>
		<p>
			<label>이름: <input type="text" name="name"></label>
		</p>
		<p>
			<label>패스워드: <input type="password" name="password"></label>
		</p>
		<p>
			<label>패스워드 확인: <input type="password" name="password_re"></label>
		</p>
		<p>
			성별:<label>남자<input type="radio" name="gender" value="남자" checked></label>
			<label>여자<input type="radio" name="gender" value="여자"></label>
		</p>
		<p>
			<!-- 주소와 우편번호를 입력할 <input>들을 생성하고 적당한 name과 class를 부여한다 -->
			우편번호: <input type="text" name="zipcode" class="postcodify_postcode5" value="" readonly/>
			<input type="button" id="postcodify_search_button" value="검색"><br />
		</p>
		<p>
			주소: <input type="text" name="address" class="postcodify_address" value="" readonly/><br />
		</p>
		<p>
			상세주소: <input type="text" name="addressDetail" class="postcodify_details" value="" /><br />
		</p>
		<p>
			참고항목: <input type="text" name="addressEtc" class="postcodify_extra_info" value="" /><br />
		</p>
		<p>
			<input type="button" value="가입 완료" onclick="join()">
		</p>
	</form>
</body>
<!-- jQuery와 Postcodify를 로딩한다 -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<!-- "검색" 단추를 누르면 팝업 레이어가 열리도록 설정한다 -->
<script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>
<script type="text/javascript" src="member.js"></script>
<script>
	if($("input[name='joinCheck']").val()=='false'){alert("회원가입 실패. 잠시 후 다시 시도해주세요.");}
</script>
</html>