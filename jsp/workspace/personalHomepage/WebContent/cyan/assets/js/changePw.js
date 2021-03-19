/**
 * 비밀번호 찾기 후 비밀번호 변경하기
 */
var checkPw = false;
var checkChangePw = false;

$("input[name='newMypagePw']").keyup(function(event){
	var newMypagePw = $("input[name='newMypagePw']").val();
	
	if(newMypagePw.length < 8 || newMypagePw.length > 16){
		$("#newMypagePw_msg").text("사용할 수 없는 비밀번호입니다.");
		$("#newMypagePw_msg").css("color","magenta");
		checkPw = false;
	}else{
		$("#newMypagePw_msg").text("사용할 수 있는 비밀번호입니다.");
		$("#newMypagePw_msg").css("color","white");
		checkPw = true;
	}
});

$("input[name='checkPw']").keyup(function(event){
	check = false;
	var pw = $("input[name='newMypagePw']").val();
	var cpw = $("input[name='checkPw']").val();
	
	if(pw != cpw){
		$("#checkPw_msg").text("비밀번호가 일치하지 않습니다.");
		$("#checkPw_msg").css("color","magenta");
		checkChangePw = false;
	}else{
		$("#checkPw_msg").text("비밀번호가 일치합니다.");
		$("#checkPw_msg").css("color","white");
		checkChangePw = true;
	}
});

function changePwCheck(){
	var frm = document.changePwForm;
	var pw = $("input[name='newMypagePw']").val();
	var cpw = $("input[name='checkPw']").val();
	
	if(pw != cpw || !checkPw || !checkChangePw){
		alert("비밀번호를 다시 확인해주세요.");
		return false;
	}
	
	frm.submit();
}