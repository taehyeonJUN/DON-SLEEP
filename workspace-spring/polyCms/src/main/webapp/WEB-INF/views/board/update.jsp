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
			<form action="update" method="post">
				<div>
					<label>번호 : </label>${item.boardId}
				</div>
				<div>
					<label>게시판명 : </label>
					<input name="boardName" type="text" value="${item.boardName}">
				</div>
		
				<div>
					<label>형식 : </label>
					<select name="boradType">
						<option value="0" ${boradType ==0 ? 'selected' : '' }>공지사항</option>
						<option value="1" ${boradType ==1 ? 'selected' : '' }>답변형</option>
						<option value="2" ${boradType ==2 ? 'selected' : '' }>자유형</option>
						<option value="3" ${boradType ==3 ? 'selected' : '' }>갤러리</option>
					</select>
				</div>
				
				<div>
					<label>첨부파일 : </label>
					<select name="atthType">
						<option value="0" ${atthType ==0 ? 'selected' : '' }>없음</option>
						<option value="1" ${atthType ==1 ? 'selected' : '' }>단일</option>
						<option value="2" ${atthType ==2 ? 'selected' : '' }>다중</option>
					</select>
				</div>
				<div>
					<label>댓글 : </label>
					<select name="replyType">
						<option value="0" ${replyType ==0 ? 'selected' : '' }>없음</option>
						<option value="1" ${replyType ==1 ? 'selected' : '' }>단일</option>
						<option value="2" ${replyType ==2 ? 'selected' : '' }>다중</option>
					</select>
				</div>
				
				<div>
					<label>읽기권한 : </label>
					<input value="${item.readPerm}" type="number">
				</div>
				<input type="submit" value="수정">
				
			</form>
		</div>
	
</body>
</html>