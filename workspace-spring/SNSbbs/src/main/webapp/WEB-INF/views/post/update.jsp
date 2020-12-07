<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<div>
		<h1>포스트 변경</h1>
		<form method="post">
			<div>
				<label>작성 글</label> 
					<textarea name="postContent" rows="20" cols="30">${postData.postContent}</textarea>
			</div>
			<div>
				<label>작성자:</label> <input name="publisher" type="text"
					value="${postData.postId}" readonly="readonly">
			</div>

			<div>
				<label>게시일:</label> <input name="price" type="date"
					value="${postData.postDate}" readonly="readonly">
			</div>
			<div>
				<input type="submit" value="변경">
			</div>
		</form>
	</div>

</body>
</html>