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
		<h1>도서 주문정보 변경</h1>
		<form method="post">
			<div>
				<label>주문번호:</label>
				<input name="orderid" type="number" value="${item.orderid}" readonly>
			</div>
			<div>
				<label>고객번호:</label>
				<input name="custid" type="number" value="${item.custid}">
			</div>
			<div>
				<label>판매가격:</label>
				<input name="saleprice" type="number" value="${item.saleprice}">
			</div>
			<div>
				<label>주문일자:</label>
				<input name="orderdate" type="date" value="${item.orderdate}">
			</div>
			<div>
				<input type="submit" value="변경">
			</div>			
		</form>
	</div>
</body>
</html>