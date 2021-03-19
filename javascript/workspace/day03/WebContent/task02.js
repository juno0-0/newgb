/**
 * 자동차 주행에 필요한 js
 */
var onAndOff = false;
var cnt = 0;

var inputTag = document.getElementById("pw");
var textareaTag = document.getElementById("info");
var imgTag = document.getElementById("img");
var onTag = document.getElementById("on");
var offTag = document.getElementById("off");


function SuperCar(){
	this.brand = "Ferrari";
	this.color = "red";
	this.price = 15000;
}

//완성한 것
function activeEnter(){
	if(window.event.keyCode == 13){//enter는 13번
		//시동 켜기
		SuperCar.engineStart();
	}
}

SuperCar.prototype.pw = prompt("자동차 초기 비밀번호 입력");//필드는 prototype을 붙여준다.

//onclick에서 얘를 실행
SuperCar.showInput = function(){//메소드는 바로 메소드 이름을 쓴다. 시동켜기버튼에서 사용

	
	if(!onAndOff){
		//시동을 켤 수 있는 상태
		inputTag.style.visibility="visible";
	}else{
		//시동이 이미 켜져있는 상태
		textareaTag.value = "시동이 이미 켜져 있습니다."; 
	}
}

//프로토타입의 메소드 사용 방법
//SuperCar.engineStart();
SuperCar.engineStart = function(){
	
	//비밀번호 검사(SuperCar.prototype.pw : 초기 비밀번호)
	//연속 3회 오류 시 경찰 출동
	if(inputTag.value == SuperCar.prototype.pw){
		textareaTag.value = "시동 켜짐";
		img.src = "on.gif";
		onAndOff = true;
		
		cnt = 0;
	}else{
		++cnt;
		if(cnt == 3){
			textareaTag.value = "경찰 출동";
			img.src = "police.png";
			onTag.style.visibility = "hidden";
			offTag.style.visibility = "hidden";
			inputTag.style.visibility= "hidden";
			return;
		}
		textareaTag.value = "비밀번호 오류 : "+cnt;
	}
}

SuperCar.engineStop = function(){
	//시동을 끌 수 있는 상태
	//시동이 이미 꺼져있는 상태
}