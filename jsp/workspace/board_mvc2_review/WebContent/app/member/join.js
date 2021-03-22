/**
 * 회원가입
 */

var check = false;

function formSubmit(){
	if(!check){
		alert("아이디를 다시 확인해주세요.");
	}
	joinForm.submit();
}

function checkId(id){
	check = false;
	console.log("checkId : "+id);
	console.log("contextPath : "+contextPath);
	//id가 비어있으면
	if(id == ""){
		$("#idCheck_text").text("아이디를 작성해주세요.");
	}else{
		//console.log("ajax안에 id : "+memberId);
		$.ajax({
			url : contextPath + "/member/MemberCheckIdOk.me?id="+id,
			type : "get",
			dataType : "text",
			success : function(result){
				console.log("result : "+result);
				if(result.trim() == "ok"){
					check = true;
					$("#idCheck_text").text("사용할 수 있는 아이디입니다.");
				}else{
					$("#idCheck_text").text("중복된 아이디입니다.");
				}
			},
			error : function(){
				console.log("오류");
			}
		});
	}
}

$("input[name='memberId']").keyup(function(event){
	var id = $("input[name='memberId']").val();
	checkId(id);
});