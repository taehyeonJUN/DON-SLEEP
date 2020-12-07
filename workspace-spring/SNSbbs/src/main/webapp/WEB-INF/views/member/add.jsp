<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
body {
	text-align: center;
}
</style>

</head>

<body>

	<div>

		<form action="add" method="post">

			<div>
				<label>아이디:</label> 
				<input name="memId" type="text" placeholder="아이디">
			</div>

			<div>
				<label>이름:</label> <input type="text" placeholder="이름"
					name="memName">
			</div>

			<div>
				<label>비밀번호:</label> <input type="password" placeholder="비밀번호"
					name="memPass">
			</div>

			<div>
				<label>전화번호:</label> <input type="tel" placeholder="전화번호"
					name="memTel">
			</div>


			<div>
				<input type="submit" value="가입하기">
			</div>
		</form>
	</div>



</body>
</html>