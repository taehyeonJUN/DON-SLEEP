<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clock</title>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
<script type="text/javascript">
	setInterval(function() {
		//    location.href = 'http://localhost:7999/kopo/clock.do'; 
		//    location.reload(); // 위에 방법도 동일한방법

		$.ajax({
			url : "${pageContext.request.contextPath}/data.do", //요청주소
			// 		   method: "POST",//요청방식
			// 		   data: { id : menuId }, //요청전송시 함께 전송할 파라미터 지정
			dataType : "json" //응답으로 받을 데이터의 타입(text,xml,html,json...)
		}).done(function(data) { //요청에 대한 응답을 정상적으로 받을 경우 실행
// 		console.log(msg);
// 		var obj = JSON.parse(msg);
		console.log(data);
			$('#time').html(data.now);
			$('#no').html(data.num);
		
// 			ajax요청이 dataType = json으로 지정하면, 제이쿼리가 응답으로 받은 json문자열을
// 			자바스크립트로 변환하여 인자로 전달

		})
		.fail(function(jqXHR, textStatus) { //요청 전송이나 응답 수신이 실패한 경우 실행
			alert("Request failed: " + textStatus);
		});

	}, 1000);

	//    제이쿼리를 사용하여 id가 test인 엘리먼트의 내용을 abc로 설정
// 	document.getElementById("test").innerHTML="ABC";
// 	document.getElementById("test").textContent="ABC";
// 	document.querySelector("#test").innerHTML="ABC";
// 	document.querySelector("#test").textContent ="ABC";
// 	$('#test').html("ABC")
// 	$('#test').text("ABC")
	$(function(){
	$('#test').html('${now}');
	});
</script>
</head>
<body>
<!-- 	<div id="test"></div> -->
	<h1>엄청 많은 태그들이 존재.</h1>
	<h2>현재 시간 :<span id="time"></h2>
	<h2>행운의 숫자 :<span id="no"></h2>
	<h1>엄청 많은 태그들이 존재.</h1>
</body>
</html>