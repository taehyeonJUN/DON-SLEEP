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
		<div><h3>게시판 등록</h3></div>
		<div>
			<form action="add" method="post">
				<div>
					<label>제목 : </label>
					<input name="subject" type="text">
				</div>
				<div>
					<label>내용 : </label>
					<textarea name="content" cols=""></textarea>
				</div>
			
				<div>
					<input value="등록" type="submit">
				</div>
			</form>
		</div>
	</div>
</body>
</html>