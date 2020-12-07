<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script>
	$(function(){
		$.ajax({
			type:"GET",
			url:"/review/${item.bookid}/reviews",
			success: function(data){
				$("#reviews").html(data);
			}
		});
		
		$("button").click(function() {
	         let data = { star: $("#star option:selected").val(), content: $("#content").val() };
	         
	         $.ajax({
	            type: "POST",
	            url: "/review/${item.bookid}/review",            
	            data: data,   
	            success: function(data) {
	               $("#reviews").html( data );
	            }
	         });
	      });
	
	});
</script>
</head>
<body>
	<div>
		<div>
			<span>도서번호 :</span>
			<span>${item.bookid}</span>
		</div>
		<div>
			<span>도서명 :</span>
			<span>${item.bookname}</span>
		</div>
		<div>
			<span>출판사 :</span>
			<span>${item.publisher}</span>
		</div>
		<div>
			<span>가격 :</span>
			<span>${item.price}</span>
		</div>
		<div>
			<img src="/upload/${item.cover}">
		</div>
		<div>
			<ul id="reviews">
				<li> </li>
			</ul>
		</div>
		<div>
			
			<span><input type="text" id="content"></span>
			<span><select id="star">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select></span>
			<span><button onclick="review(${item.bookid})">평가</button></span>
			
		</div>
		<div><a href="../list">목록</a></div>
	</div>
</body>
</html>