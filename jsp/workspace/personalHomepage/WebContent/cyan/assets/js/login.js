/**
 * 로그인
 */

function login(){
	var form = document.loginForm;
	var id = form.mypageId.value;
	var pw = form.mypagePw.value;
	
	if(id == "" || pw == ""){
		alert("ID/PW를 입력해주세요.");
		return false;
	}
	
	form.submit();
	
}