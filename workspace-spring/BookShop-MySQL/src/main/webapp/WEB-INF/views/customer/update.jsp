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
		<form method="post">
			<div>
				<label>고객번호:</label>
				<input type="number" name="custid" value="${item.custid}" readonly>
			</div>
			<div>
				<label>고객명:</label>
				<input type="text" name="name" value="${item.name}">
			</div>
			<div>
				<label>주소:</label>
				<input type="text" name="address" value="${item.address}">
			</div>
			<div>
				<label>전화번호:</label>
				<input type="text" name="phone" value="${item.phone}">
			</div>
			<div>
				<input type="submit" value="변경">
			</div>			
		</form>
	</div>
</body>
</html>