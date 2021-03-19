<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="object_ok.jsp" name="test">
		<fieldset>
			<legend>연습중</legend>
			<input type="text" name="name">
			<input type="text" name="birthday">
			<input type="button" onclick="sendIt()" value="확인">
		</fieldset>
	</form>
</body>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	$("input[name='name']").click(function(){
		$("input[name='name']").removeAttr("style");
		$("input[name='name']").removeAttr("placeholder");		
	});
	
	$("input[name='birthday']").click(function(){
		$("input[name='birthday']").removeAttr("style");
	});
	
	function sendIt(){
		var frm = document.test;
		var check = false;
		
		if(frm.name.value == ""){
			$("input[name='name']").css("border-color","red");
			$("input[name='name']").attr("placeholder","이름을 입력하세요.");
			check = true;
		}
		
		if(frm.birthday.value == ""){
			$("input[name='birthday']").css("border-color","red");
			$("input[name='birthday']").attr("placeholder","생일을 입력하세요.");
			check = true;
		}
		
		if(check){
			return false;
		}
		
		frm.submit();
		
		return true;
		
	}
</script>
</html>