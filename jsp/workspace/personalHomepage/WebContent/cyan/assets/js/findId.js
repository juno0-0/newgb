/**
 *	아이디 찾기 
 */

var check = false;

function formSubmit(){
   var form = document.findIdForm;
   
   if(!check){
      alert("다시 확인해주세요.");
      return false;
   }
   form.submit();
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

function sms(){
	check = false;
	var phone = $("#mypagePhone").val();
	
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
