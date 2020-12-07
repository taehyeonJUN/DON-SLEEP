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
				<label>제목:</label>
				<input name="subject" type="text" value="${item.subject}">
			</div>
			<div>
				<label>내용:</label>
				<textarea name="content" rows="20" cols="100">${item.content}</textarea>
			</div>
			<div>
				<input type="submit" value="변경">
			</div>
		</form>
	</div>
</body>
</html>