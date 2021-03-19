/**
 * 자동차 주행에 필요한 js
 */
//시동이 on인지 off인지 확인하는 flag
var check = false;
var policeCnt = 0;

function SuperCar(){
	this.brand = "Ferrari";
	this.color = "red";
	this.price = 15000;
}

$("#pw").on("keydown",function(key){
	if(key.keyCode == 13){
		SuperCar.engineStart();
	}
});

//완성한 것
/*function activeEnter(){
	if(window.event.keyCode == 13){//enter는 13번
		//시동 켜기
		SuperCar.engineStart();
	}
}*/


SuperCar.prototype.pw = prompt("자동차 초기 비밀번호 입력");//필드는 prototype을 붙여준다.

//const result = document.getElementById("result");
const result = $("#result");

//onclick에서 얘를 실행
SuperCar.showInput = function(){//메소드는 바로 메소드 이름을 쓴다. 시동켜기버튼에서 사용

	if(!check){
		//시동을 켤 수 있는 상태
		//input태그 visible
		//const inputTag = document.getElementById("pw");
		const inputTag = $("#pw");
		//inputTag.style.visibility="visible";
		inputTag.css("visibility", "visible");
	}else{
		//시동이 이미 켜져있는 상태
		//result.value = "시동이 이미 켜져 있습니다.";
		result.text("시동이 이미 켜져 있습니다.");
	}
}

//프로토타입의 메소드 사용 방법
//SuperCar.engineStart();
SuperCar.engineStart = function(){
	//const img = document.getElementById("stat");
	const img = $("#stat");
	//const inputTag = document.getElementById("pw");
	const inputTag = $("#pw");
	
	//var pw = inputTag.value;
	var pw = inputTag.val();
	
	//비밀번호 검사(SuperCar.prototype.pw : 초기 비밀번호)
	if(SuperCar.prototype.pw == pw){
		policeCnt = 0;
		//img.src = "on.gif";
		img.attr("src", "on.gif");	//attr : Attribute
		//inputTag.value = "비밀번호 입력";
		inputTag.text("비밀번호 입력");
		//inputTag.style.visibility = "hidden";
		//inputTag.css("visibility", "hidden");
		inputTag.hide();
		//result.innerHTML = "시동 켜짐";
		result.text("시동 켜짐");
		check = true;
	}else{
		//연속 3회 오류 시 경찰 출동
		policeCnt++;
		
		if(policeCnt == 3){
			//img.src = "police.png";
			img.attr("src", "police.png");
			//document.getElementById("on").style.display = "none";
			$("#on").css("display", "none");
			//document.getElementById("off").style.display = "none";
			$("#off").css("display", "none");
			//inputTag.style.display = "none";
			inputTag.css("display", "none");
			//result.innerHTML = "경찰 출동";
			result.text("경찰 출동");
			return;
		}
		//result.innerHTML = "비밀번호 오류 : " + policeCnt + "회";
		result.text("비밀번호 오류 : " + policeCnt + "회");
	}
}

SuperCar.engineStop = function(){
	if(check){
		//시동을 끌 수 있는 상태
		//const img = document.getElementById("stat");
		const img = $("#stat");
		//img.src = "off.gif";
		img.attr("src", "off.gif");
		//result.innerHTML = "시동 꺼짐";
		result.text("시동 꺼짐");
		check = false;
	}else{
		//시동이 이미 꺼져있는 상태
		//result.innerHTML = "이미 시동이 꺼져 있습니다.";
		result.text("이미 시동이 꺼져 있습니다.");
	}
}