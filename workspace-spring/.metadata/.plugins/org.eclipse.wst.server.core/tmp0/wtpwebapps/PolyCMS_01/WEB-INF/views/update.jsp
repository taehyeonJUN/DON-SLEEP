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
		<form method="POST">
			<div>
				<label>번호: </label>${item.boardId}
			</div>
			
			<div>
				<label>게시판명: </label>
				<input name="boardName" type="text" value="${item.boardName}">
			</div>
			
			<div>
				<label>형식: </label>
				<select name="boardType">
					<option value="0" ${boardType == 0 ? 'selected' : ''}>공지형</option>
					<option value="1" ${boardType == 1 ? 'selected' : ''}>답변형</option>
					<option value="2" ${boardType == 2 ? 'selected' : ''}>자유형</option>
					<option value="3" ${boardType == 3 ? 'selected' : ''}>갤러리</option>
				</select>
			</div>
			
			<div>
				<label>첨부파일: </label>
				<select name="attachType">
					<option value="0" ${boardType == 0 ? 'selected' : ''}>없음</option>				
					<option value="1" ${boardType == 1 ? 'selected' : ''}>단일</option>				
					<option value="2" ${boardType == 2 ? 'selected' : ''}>다중</option>				
				</select>
			</div>
			
			<div>
				<label>댓글: </label>
				<select name="replyType">
					<option value="0" ${boardType == 0 ? 'selected' : ''}>없음</option>				
					<option value="1" ${boardType == 1 ? 'selected' : ''}>가능</option>				
					<option value="2" ${boardType == 2 ? 'selected' : ''}>다중</option>				
				</select>
			</div>
			
			<div>
				<label>읽기권한: </label>
				<input type="number" value="${item.readPerm}">
			</div>
			
			<div>
				<label>쓰기권한: </label>
				<input type="number" value="${item.writePerm}">
			</div>
			
			<div>
				<input type="submit" value="변경">
			</div>
			
		</form>
	</div>
</div>
</body>
</html>