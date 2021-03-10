/**
 *	회원가입 
 */
var check = false;

$("#checkbox-alpha").click(function(){
	
	var cb = document.joinForm.checkbox.checked;
	
	if(!cb){
		check = false;
		alert("약관에 동의해주세요.");
		console.log(check);
	}else{
		check = true;
		console.log(check);
	}
	
});


//회원가입 버튼을 누르면 동작하는 함수
function formSubmit(){
	console.log(check);
   var form = document.joinForm;
   
   if(!check){
      alert("다시 확인해주세요.");
      form.mypageId.focus();
      return false;
   }
   form.submit();
}



function checkId(){
	check = false;
	var id = $("input[name='mypageId']").val();

	if(id == ""){
		$("#checkId_msg").text("아이디를 입력해주세요.");
		document.joinForm.mypageId.focus();
		return false;
	}else{
		console.log(contextPath);
		$.ajax({
			url:contextPath+"/mypage/MyPageCheckIdOk.mp?id="+id,
			type:"get",
			dataType:"text",
			success:function(result){
				if(result.trim() == "ok"){
					check = true;
					$("#checkId_msg").text("사용할 수 있는 아이디입니다.");
				}else{
					$("#checkId_msg").text("중복된 아이디입니다.");
				}
			},
			error:function(){
				console.log("오류");
			}
		});
	}
}

$("input[name='mypagePw']").keyup(function(event){
	check = false;
	var pw = $("input[name='mypagePw']").val();
	if(pw == ""){
		$("#checkPw_msg").text("비밀번호를 입력해주세요.");
		return false;
	}
	if(pw.length < 8 || pw.length > 16){
		$("#checkPw_msg").text("사용할 수 없는 비밀번호입니다.");
		$("#checkPw_msg").css("color", "magenta");
		return false;
	}else{
		$("#checkPw_msg").text("사용할 수 있는 비밀번호입니다.");
		$("#checkPw_msg").css("color", "white");
		check = true;
	}
});

$("input[name='checkPw']").keyup(function(event){
	check = false;
	var pw = $("input[name='mypagePw']").val();
	var checkPw = $("input[name='checkPw']").val();
	
	if(pw != checkPw){
		$("#equalPw_msg").text("비밀번호가 일치하지 않습니다.");
		$("#equalPw_msg").css("color", "magenta");
		return false;
	}else{
		$("#equalPw_msg").text("비밀번호가 일치합니다.");
		$("#equalPw_msg").css("color", "white");
		check = true;
	}
});

var temp;

function sms(){
	check = false;
	var phone = $("#mypagePhone").val();
	
	alert("인증번호가 발송되었습니다.");
	
	if(phone.length != 11 || phone == ""){
		alert("핸드폰 번호를 다시 확인해주세요.");
		return false;
	}else{
		$("#checkPhone").removeAttr("readonly");
		$("#certified").removeAttr("disabled");
		$.ajax({
			url:contextPath+"/mypage/MyPageSMS.mp?phone="+phone,
			type:"get",
			dataType:"text",
			success:function(result){
				check = true;
				temp = result.trim();
				console.log("result"+result.trim());
				console.log("성공");
			},
			error:function(a,b,c){
				console.log("sms오류");
			}
		});
	}
}

function certifiedCheck(){
	check = false;
	var checkPhone = $("input[name='checkPhone']").val();
	
	console.log("temp : "+temp);
	console.log("checkPhone : "+checkPhone);
	
	if(temp == checkPhone){
		alert("인증되었습니다.");
		check = true;
		return false;
	}else{
		alert("인증번호가 틀렸습니다.");
		return false;
	}
}



