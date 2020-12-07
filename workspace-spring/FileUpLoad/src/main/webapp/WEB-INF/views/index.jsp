<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<title>Home</title>

<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
  	<script>
  	$(function() {
  		$('#upload').click(function() {
			//const?
  			//$()안에서 폼 태그를 선택 #은 아이디 .은 클래스 
  			const form = document.getElementById("form");//document.getElementTagname('form')과 같음//$('form')여기는 제이쿼리 객체 
  			const formData = new FormData(form); //폼데이터는 자바스크립트의 내장객체, 자바스크립트 데이터로 변환한걸 에이잭스 통하여 서버로 전달
  			
  			$.ajax({
  				type:'POST',
  				url: 'upload_ajax', //이 주소로 전송( 아직 만들지 않음)
  				enctype: 'multipart/form-data', //폼데이터를 멀티파트 형식으로 받음.
  				data: formData,
  				async : true,
  				cache:false,
  				contentType:false, //false가 아니면 이상동작함.
  				processData:false,
  				success: function(data) {
					$('ul').html(data); //폼데이터를 ul태그로 떄려박음
				}
  				
  			});
		});
	});
  
  </script>
</head>
<body>
	<div>
		<div>
			<h3>이미지 갤러리</h3>
		</div>
		<div>
			<ul>
				<c:forEach var="item" items="${list}">

					<li><span>${item.title}</span> <span>
					<img src="upload/${item.image}"></span></li>
				</c:forEach>
				<c:if test="${list.size() < 1}">
					<li>
						<div>등록된 이미지가 없습니다</div>
					</li>
				</c:if>
			</ul>
		</div>
		<div>
			<!-- 	enctype="multipart/form-data" 이 타입으로의 인코딩을 요청 (파일 조각형태로) -->
			<form action="upload" id="form" method="post" enctype="multipart/form-data">
				<div>
					<label>제목</label> <input name="title" type="text">
				</div>
				<div>
					<input name="uploadFile" type="file">
				</div>
				<div>
					<input value="등록" type="submit">
				</div>
			</form>
		</div>
	<div>
		<button id="upload">[AJAX]등록</button>
	</div>

	</div>
</body>
</html>
