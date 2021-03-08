/**
 *	회원가입 
 */
var check = false;

//회원가입 버튼을 누르면 동작하는 함수
function formSubmit(){
   var form = document.joinForm;
   
   //아이디 검사
   if(form.mypageId.value == "" || !check){
      alert("아이디를 확인해주세요.");
      form.mypageId.focus();
      return false;
   }
   form.submit();
}



function checkId(){
	var id = $("input[name='mypageId']").val();

	check = false;
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
	var pw = $("input[name='mypagePw']").val();
	if(pw == ""){
		$("#checkPw_msg").text("비밀번호를 입력해주세요.");
		check = false;
		return false;
	}
	if(pw.length < 8 || pw.length > 16){
		$("#checkPw_msg").text("사용할 수 없는 비밀번호입니다.");
		$("#checkPw_msg").css("color", "magenta");
		check = false;
		return false;
	}else{
		$("#checkPw_msg").text("사용할 수 있는 비밀번호입니다.");
		$("#checkPw_msg").css("color", "white");
		check = true;
	}
});

$("input[name='checkPw']").keyup(function(event){
	var pw = $("input[name='mypagePw']").val();
	var checkPw = $("input[name='checkPw']").val();
	
	if(pw != checkPw){
		$("#equalPw_msg").text("비밀번호가 일치하지 않습니다.");
		$("#equalPw_msg").css("color", "magenta");
		check = false;
		return false;
	}else{
		$("#equalPw_msg").text("비밀번호가 일치합니다.");
		$("#equalPw_msg").css("color", "white");
		check = true;
	}
});

function sms(){
	
	var phone = $("#mypagePhone").val();
	
	if(phone.length != 11 || phone == ""){
		alert("비밀번호를 다시 확인해주세요.");
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
			},
			error:function(){
				console.log("sms오류");
			}
		});
	}
}

function certifiedCheck(){
	var temp = $("input[name='test']").val();
	var checkPhone = $("input[name='checkPhone']").val();
	
	console.log("temp : "+temp);
	console.log("checkPhone : "+checkPhone);
	
	if(temp == checkPhone){
		alert("인증되었습니다.");
		check = true
	}else{
		alert("인증번호가 틀렸습니다.");
		return false;
	}
}


