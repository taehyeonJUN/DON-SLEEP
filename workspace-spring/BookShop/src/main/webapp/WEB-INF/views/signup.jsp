<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script>
//동기 방식
	function checkID_Sync() {
		//사용자 입력 아이디값 입력
		let form = document.getElementById("form");
		
		//에이젝은 XMLHttpRequest이 있어야 함

		let xhr = new XMLHttpRequest(); //객체 생성, 서버로 리퀘스트를 보냄
	
		//오픈메서드에 파라미터 입력, false사용 원래는 안됨 교육용으로 사용= 동기방식을 의미?
		xhr.open("GET", "checkID?id="+form.name.value, false);
		
		xhr.send();//리퀘스트 전송
		
		let result = xhr.responseText;
		
		if(result=="OK"){
			alert("[동기방식]사용 가능한 아이디 입니다 ");//응답 값 출력
			form.checkID.value = form.name.value;
		}
		else
			alert("[동기방식]사용할 수 없는 아이디 입니다 ");
	}
	//비동기 방식
	function checkID_ASync() {
		let form = document.getElementById("form");
		let xhr = new XMLHttpRequest();
		xhr.open("GET", "checkID?id="+form.name.value, true);//비동기 방식으로 설정
		
		//상태가 변했을때 호출되는 이벤트 핸들러 메소드
		//이벤트 발생시 마다 저장된 함수가 호출됨
		//리퀘스트 완료 되었을떄의 일을 미리 설정
		xhr.onreadystatechange = function(){
			if(xhr.readyState == XMLHttpRequest.DONE){
				if(xhr.status == 200){
					let result = xhr.responseText; 
					
					if(result=="OK"){
						
						alert("[비동기방식]사용가능한 아이디 입니다 ");
						from.checkID.value = form.name.value;
					} else
						alert("[비동기방식]사용할 수 없는 아이디 입니다 ");
				}
			}
		};

		xhr.send();
		//비동기 방식은 응답을 기다리지않음. 
		
		
	}
	////
	
	function submit() {
		let form = document.getElementById("form");
		
		if(form.checkID.value != form.name.value){
			alert("중복검사를 해야합니다")
			return
		};
		
		if(form.name.value==""){
			alert("아이디를 입력해 주세요")
			form.name.focus();
			return;
		};
		if(form.phone.value==""){
			alert("비밀번호를 입력해 주세요")
			form.phone.focus();
			return;
		};
		if(form.address.value==""){
			alert("주소를 입력해 주세요")
			form.address.focus();
			return;
		};
		
		form.submit();
		alert("제출")
	}
</script>
</head>
<body>
	<div>
		<h1>회원등록</h1>
		<form method="post" id="form">
			<input name="checkID" type="hidden" value="0">
			<div>
				<label>아이디:</label>
				<input name="name" type="text"><a href="javascript:checkID_ASync()">중복검사</a>
			</div>
			<div>
				<label>비밀번호:</label>
				<input name="phone" type="text">
			</div>
			<div>
				<label>주소:</label>
				<input name="address" type="text">
			</div>
					
		</form>
			<div>
				<button onclick="submit()">회원가입</button>
			</div>	
	</div>
</body>
</html>