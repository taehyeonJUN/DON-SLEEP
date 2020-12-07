<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<title>회원가입</title>
<style>
body {
	text-align: center;
}
</style>
<script>
/*
	function fn_idChk() {
		//아이디 중복체크
		let form = document.getElementById("form");
		
		let xhr = new XMLHttpRequest();
		
		xhr.open("GET","checkId?memberId="+form.memId.value,false);  
		// false면 동기방식//checkId의 파라미터의 값을 일치
		
		xhr.send(); 
		//get방식으로 checkId 컨트롤러(?)로 보냄.. form에 checkId인진 확실X
		
		let result = xhr.responseText; 
		
		alert("checkId :" + result);
		
		if(result == "TRUE"){
			alert("이용 가능");	
			form.checkId.value = form.memId.value; 
		}else(result == "FALSE"){
			alert("이용 불가능");
		}
	}
*/
	
	//비동기
	function fn_AsidChk() {
		let form = document.getElementById("form");
		let xhr = new XMLHttpRequest();
		xhr.open("GET", "checkId?memberId="+form.memId.value,true);
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState == XMLHttpRequest.DONE){
				if(xhr.status == 200){
					let result = xhr.responseText;
					
					if(result=="TRUE"){
						
						alert("[비동기]사용가능 아디");
						form.checkId.value = form.memId.value;
					}else
						alert("[비동기]사용할 수 없는 아디");
				}
			}
		}
		xhr.send();
	}
	
	
	
	function submit(){
		let form = document.getElementById("form");
		
		if(form.checkId.value == "false"){
			alert("중복검사 해야합니다.");
			return;  // 무의미한 return 작성
		}
		
		if(form.memId.value == ""){
			alert("아이디입력");
			form.memId.focus();
			return;
		}

		if(form.memName.value == ""){
			alert("이름입력");
			form.memName.focus();
			return;
		}
		
		if(form.memPass.value == ""){
			alert("비번입력");
			form.memPass.focus();
			return;
		}
		
		if(form.memTel.value == ""){
			alert("번호입력");
			form.memTel.focus();
			return;
		}
		
		form.submit();
	}
</script>
</head>

<body>

	<div>

		<form method="post" id="form">

				<input name="checkId" type="hidden" value="false">
			<div>
				<label>아이디:</label> 
				<input type="text" placeholder="아이디" name="memId"> <a href="javascript:fn_AsidChk()">중복검사</a>
			</div>
			<div>
				<label>이름:</label> 
				<input type="text" placeholder="이름" name="memName">
			</div>

			<div>
				<label>비밀번호:</label> 
				<input type="password" placeholder="비밀번호" name="memPass">
			</div>

			<div>
				<label>전화번호:</label> 
				<input type="tel" placeholder="전화번호" name="memTel">
			</div>


		</form>
			<div>
<!-- 				<input type="submit" value="가입하기"> -->
		<button onclick="submit()">가입</button>
			</div>
	</div>



</body>
</html>