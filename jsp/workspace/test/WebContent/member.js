/**
 * 
 */
var check = false;
console.log("global check : "+check);
function modify(){
	document.joinForm.id.readOnly = false;
	check = false;
}

function sendIt(){
	var httpRequest = new XMLHttpRequest();
	httpRequest.open("GET", "join_ok.jsp?=id"+document.getElementById("id").value, true);
	httpRequest.send();
	
	/*httpRequest.open("POST", "join_ok.jsp", true);
	httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	httpRequest.send("id="+document.getElementById("id").value);*/
	
	httpRequest.onreadystatechange = function(){
		if(httpRequest.readyState == XMLHttpRequest.DONE){
			if(httpRequest.status == 200){
				if(httpRequest.responseText.trim() == "ok"){
					document.joinForm.id.readOnly = true;
					document.getElementById("result").innerHTML = "사용가능한 아이디입니다.";
					check = true;
				}else{
					document.getElementById("result").innerHTML = "중복된 아이디입니다.";
					check = false;
				}
			}
		}
	}
}


function join(){
	var frm = document.joinForm;
	
	if(frm.id.value == ""){
		alert("아이디를 입력해주세요.");
		frm.id.focus();//커서가 id로 이동한다.
		return false;
	}
	
	//아이디는 4자 이상, 16자 이하로 입력
	if(frm.id.value.length < 4 || frm.id.value.length > 16){
		alert("아이디는 4자 이상, 16자 이하로 입력해주세요.");
		frm.id.focus();
		return false;
	}
	
	if(frm.name.value == ""){
		alert("이름을 입력해주세요.");
		frm.name.focus();
		return false;
	}
	
	if(frm.password.value == ""){
		alert("패스워드를 입력해주세요.");
		frm.password.focus();
		return false;
	}else{
		//8자리 이상, 대문자/소문자/숫자/특수문자 모두 포함되어 있는 지 검사
		var reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
						//대문자		소문자		숫자			특수문자
		//한글은 있는 지 검사
		var hangleCheck = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		
		//test()는 정규식에서 쓰는 메소드
		if(!reg.test(frm.password.value)){
			//정규식 조건에 맞지 않으면
			alert("비밀번호는 8자리 이상이어야 하며, 대문자/소문자/숫자/특수문자 모두 포함해야 합니다.");
			frm.password.focus();
			return false;
		}
		
		//같은 문자를 4번 이상 사용할 수 없다.
		else if(/(\w)\1\1\1/.test(frm.password.value)){
			//같은 문자가 4개 이상 있다면
			alert("같은 문자를 4번 이상 사용할 수 없습니다.");
			frm.password.focus();
			return false;
		}
		
		//비밀번호에 아이디가 포함되어 있을 수 없다.
		//search()는 문자열에서 쓰는 메소드
		//indexOf()와 비슷하다.
		//포함되어 있지 않으면 -1을 리턴
		else if(frm.password.value.search(frm.id.value) > -1){
			//-1은 아이디가 비밀번호에 없다는 뜻
			//따라서 -1이 아닐 때(아이디를 비밀번호에서 찾았을 때) 들어옴
			alert("비밀번호에 아이디를 포함할 수 없습니다.");
			frm.password.focus();
			return false;
		}
		
		//한글
		else if(hangleCheck.test(frm.password.value)){
			//정규식 조건에 맞으면
			alert("비밀번호에 한글을 사용할 수 없습니다.");
			frm.password.focus();
			return false;
		}
		
		//비밀번호에 공백을 포함할 수 없다.	\s는 공백을 의미한다.
		else if(frm.password.value.search(/\s/) != -1){
			//비밀번호에서 공백을 찾았다면 
			alert("비밀번호에 공백없이 입력해주세요.");
			frm.password.focus();
			return false;
		}
		
		//비밀번호 확인
		if(frm.password.value != frm.password_re.value){
			alert("패스워드를 확인해주세요.");
			frm.password_re.foucs();
			return false;
		}
		
		//아이디 검사
		if(!check){
			alert("아이디 중복확인을 진행해주세요.");
			return false;
		}
		
		frm.submit();
	}
}