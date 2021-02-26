/**
 * 회원 가입 세부 설정 
 */
let idCheck = false;

//사용가능한 아이디를 수정했을 때
function modifyId(){
	//중복확인 후 수정이 불가능했던 input태그를 다시 수정가능하게 변경해준다.
	document.joinForm.id.readOnly = false;
	//수정을 시도했기 때문에 회원가입 진행을 막아준다.
	idCheck = false;
}

function sendIt(){
	//Ajax
	var id = document.joinForm.id.value;
	var httpRequest = new XMLHttpRequest();
	
	httpRequest.open("POST", "join_ok.jsp", true);
	httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	httpRequest.send("id="+id);
	httpRequest.onreadystatechange = function(){//onreadystatechange : 상태가 변할 때마다 호출되는 함수
		if(httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200){//readyState : 현재 상태를 리턴한다. status : 실패했으면 404나 500을 리턴
			//요청한 파일에는 값만 존재하는 것이 처리하기 편하다.
			//responseText로 전달받은 값의 앞 뒤 공백을 없애주기 위해 trim()을 사용한다.
			if(httpRequest.responseText.trim() == "ok"){//responseText : 응답받은 값을 가지고 있다.
				//중복검사를 한 아이디 input태그에 수정을 막아준다.
				document.joinForm.id.readOnly = true;//아이디를 수정할 수 없게 막아준다.
				//중복검사의 결과값을 화면에 뿌려준다.
				document.getElementById("result").innerHTML = "사용가능한 아이디입니다.";
				//회원가입을 진행할 수 있도록 FLag를 true로 변경해준다.
				idCheck = true;
			}else{
				document.getElementById("result").innerHTML = "중복된 아이디입니다.";
				//중복된 아이디라면 check를 false로 설정해준다.
				idCheck = false;
			}
		}
	}
}

function join(){
	var frm = document.joinForm;
	
	if(frm.id.value == ""){
		alert("아이디를 입력해주세요.");
		//id로 커서 이동
		form.id.focus();
		return false;
	}
	//아이디는 4자 이상 16자 이하
	if(frm.id.value.length < 4 || frm.id.value.length > 16){
		alert("아이디는 4자 이상, 16자 이하로 입력해주세요.");
		frm.id.focus();
		return false;
	}
	
	if(frm.name.value == ""){
		alert("이름을 입력해주세요.");
		//id로 커서 이동
		form.name.focus();
		return false;
	}
	
	if(frm.password.value == ""){
		alert("패스워드를 입력해주세요.");
		frm.password.focus();
	}else{
		//8자리 이상, 대문자/소문자/숫자/특수문자 모두 포함되어 있는 지 검사
		var reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
		//한글이 있는 지 검사
		var hangleCheck = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		
		//test는 정상이면 true, 한가지라도 잘못되면 false
		if(!reg.test(frm.password.value)){
			//정규식 조건에 맞지 않으면
			alert("비밀번호는 8자리 이상이어야 하며, 대문자/소문자/숫자/특수문자 모두 포함해야 합니다.");
			frm.password.focus();
			return false;
		}
		
		//같은 문자를 4번 이상 사용할 수 없다.
		else if(/(\w)\1\1\1/.test(frm.password.value)){
			//같은 문자가 4개 이상 있다면
			alert("비밀번호는 같은 문자를 4번 이상 사용할 수 없습니다.");
			frm.password.focus();
			return false;
		}
		
		//비밀번호에 아이디가 포함되어 있을 수 없다.
		else if(frm.password.value.search(frm.id.value) > -1){
			//-1은 아이디가 비밀번호에 없는 뜻. 따라서 -1이 아닐 때(아이디를 비밀번호에서 찾았을 때)
			alert("비밀번호에 아이디를 포함할 수 없습니다.")
			frm.password.pocus();
			return false;
		}
		
//		else if(!hangleCheck.test(frm.password.value)){
//			//정규식 조건에 맞으면
//			alert("비밀번호에 한글을 사용할 수 없습니다.")
//			frm.password.pocus();
//			return false;
//		}
		
		//비밀번호에 공백을 포함할 수 없다.
		else if(frm.password.value.search(/\s/) != -1){
			//비밀번호에서 공백을 찾았다면
			alert("비밀번호에 공백 없이 입력해 주세요.");
			frm.password.pocus();
			return false;
		}
		
		//비밀번호 확인
		if(frm.password.value != frm.password_re.value){
			alert("패스워드를 확인해주세요");
			frm.password_re.focus();
			return false;
		}
		
		if(!idCheck){
			alert("아이디 중복 확인을 해주세요.")
			frm.id.focus();
			return false;
		}
		
		frm.submit();
	}
}