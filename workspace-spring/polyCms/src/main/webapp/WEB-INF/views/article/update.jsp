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
			<form method="post">
					<div>
					<label>제목 : </label>
					<input name="subject" type="text" value="${item.subject}">
					</div>
					
				<div>
					<label>내용 : </label>
					<textarea name="content" row="20" col="100">${item.content}</textarea>
					</div>
		
				
				<div>
					<label>읽기권한 : </label>
					<input value="변경" type="submit">
				</div>
				
			</form>
		</div>
	
</body>
</html>