<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script>
	// 동기방식
	function checkID_Sync() {
		let form = document.getElementById("form");
		
		let xhr = new XMLHttpRequest();
				
		xhr.open("GET", "checkID?id=" + form.name.value, false);
		xhr.send();	
		
		let result = xhr.responseText;

		if(result == "OK") {
			alert("[동기방식] 사용 가능한 아이디 입니다");
			
			form.checkID.value = form.name.value;
		} else
			alert("[동기방식] 사용 할 수 없는 아이디 입니다");
			
	}
	
	// 비동기방식
	function checkID_ASync() {
		let form = document.getElementById("form");
		
		let xhr = new XMLHttpRequest();
		
		xhr.open("GET", "checkID?id=" + form.name.value, true);	

		xhr.onreadystatechange = function() {
            if(xhr.readyState == XMLHttpRequest.DONE) {
                if(xhr.status == 200) {
                    let result = xhr.responseText;
		
                    if(result == "OK") {
            			alert("[비동기방식] 사용 가능한 아이디 입니다");
            			
            			form.checkID.value = form.name.value;
            		} else
            			alert("[비동기방식] 사용 할 수 없는 아이디 입니다");
                }
            }
        };
		
		xhr.send();
	}
	
	function submit() {
		let form = document.getElementById("form");
		
		if(form.checkID.value != form.name.value) {
			alert("중복검사를 하셔야 합니다");
			return;
		}
		
		if(form.name.value == "") {
			alert("회원번호를 입력 해 주세요");			
			form.name.focus();
			return;
		}
		
		if(form.phone.value == "") {
			alert("비밀번호를 입력 해 주세요");			
			form.phone.focus();
			return;
		}
		
		if(form.address.value == "") {
			alert("주소를 입력 해 주세요");			
			form.address.focus();
			return;
		}
		
		form.submit();
	}
</script>
</head>
<body>
	<div>
		<form method="post" id="form">	
			<input name="checkID" type="hidden" value="0">		
			<div>
				<label>아이디:</label>
				<input type="text" name="name"> <a href="javascript:checkID_ASync()">중복검사</a>
			</div>
			<div>
				<label>비밀번호:</label>
				<input type="text" name="phone">
			</div>
			<div>
				<label>주소:</label>
				<input type="text" name="address">
			</div>								
		</form>
		<div>
			<button onclick="submit()">회원가입</button>
		</div>
	</div>
</body>
</html>