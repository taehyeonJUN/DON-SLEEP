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
		<h1>도서 주문</h1>
		<form method="post">			
			<div>
				<label>고객번호:</label>
				<input name="custid" type="number">
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