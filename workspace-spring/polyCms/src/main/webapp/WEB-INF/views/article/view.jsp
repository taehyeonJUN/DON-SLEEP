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
				<div>
					<label>조회수 : </label>
					<div>${item.viewCount}</div>
				</div>
				<div>
					<label>제목 : </label>
					<div>${item.subject}</div>
				</div>
				<div>
					<label>내용 : </label>
					<div>${item.content}</div>
				</div>
				<div>
					<a href="delete">삭제</a>
					<a href="update">변경</a>
					<a href="../list">목록</a>
				</div>
				
		</div>
	
</body>
</html>