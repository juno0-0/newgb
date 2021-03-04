/**
 * 회원가입
 */

var check = false;

//회원가입 버튼을 누르면 동작하는 함수
function formSubmit(){
   var form = document.joinForm;
   
   //아이디 검사
   if(form.memberId.value == "" || !check){
      alert("아이디를 확인해주세요.");
      form.memberId.focus();
      return false;
   }
   
   form.submit();
}

function checkId(id){
   //아이디 검사에서 true로 바뀌어 있는 check를 false로 초기화시켜준다.
   check = false;
   if(id == ""){
	  //비어있을 경우 <p>에 있는 콘텐츠를 변경한다.
      $("#idCheck_text").text("아이디를 작성해주세요.");
   }else{
	  //jQuery를 사용한 Ajax
      $.ajax({
    	 //joinForm.jsp에서 선언한 절대경로가 담긴 contextPath 변수
    	 //url을 작성하면 서블릿이 web.xml을 가서 확장자를 비교하여 일치하는 Front-Controller로 이동
         url:contextPath + "/member/MemberCheckIdOk.me?id="+id,
         //get방식으로 전송
         type:"get",
         //텍스트 한줄을 리턴받을 것이다.
         dataType:"text",
         //성공할 경우 CallBack함수를 사용
         //결과를 매개변수로 받은 함수
         success:function(result){
            if(result.trim() == "ok"){
               check = true;
               $("#idCheck_text").text("사용할 수 있는 아이디입니다.");
            }else{
               $("#idCheck_text").text("중복된 아이디입니다.");
            }
         },
         //실패할 경우 success가 아닌 error 함수를 실행
         error:function(){
            console.log("오류");
         }
      });
   }
}

//키 이벤트 함수
$("input[name='memberId']").keyup(function(event){
   var id = $("input[name='memberId']").val();
   checkId(id);
});