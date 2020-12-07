<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
body {
	text-align: center;
}
</style>
</head>
<body>

	<div>
	
		<form action="add" method="post" enctype="multipart/form-data">
			<div>
				<label>사진</label>
				<input name="upfileList" type="file">
			</div>
			<div>
				<label>사진2</label>
				<input name="upfileList" type="file">
			</div>

			<div>
				<textarea name='postContent' placeholder="내용 입력하세요" rows="20"
					cols="30"></textarea>
			</div>

			<div>
				<input type="submit" value="작성">
			</div>
		</form>
	</div>



</body>
</html>