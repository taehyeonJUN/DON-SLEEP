<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<h1>주문 등록</h1>
		<form method="post">
			<div>
				<label>주문번호:</label>
				<input name="orderid" type="number">
			</div>
			<div>
				<label>고객번호:</label>
				<input name="custid" type="number">
			</div>
			<div>
				<label>도서번호:</label>
				<input name="bookid" type="number">
			</div>
			<div>
				<label>판매가격:</label>
				<input name="saleprice" type="number">
			</div>
			<div>
				<label>주문일자:</label>
				<input name="orderdate" type="date">
			</div>
			<div>
				<input type="submit" value="등록">
			</div>			
		</form>
	</div>
</body>
</html>