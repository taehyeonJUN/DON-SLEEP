<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<div>게시판 목록</div>
	 	<div>
	 		<table border="1">
	 			<thead>
	 				<tr>
	 					<th>번호</th>
	 					<th>게시판명</th>
	 					<th>생성일시</th>
	 					<th>첨부</th>
	 					<th>형식</th>
	 					<th>댓글</th>
	 					<th>읽기</th>
	 					<th>쓰기</th>
	 					<th>관리</th>
	 				</tr>
	 			</thead>
	 			<tbody>
	 				<tr>
	 					<td>등록된 게시판이 없습니다.</td>
	 				</tr>
	 			<c:forEach var="item" items="${list}">
	 				<tr>
	 					<td>${item.boardId}</td>
	 					<td>${item.boardName}</td>
	 					<td>${item.regDate}</td>
	 					<td>${item.atthType}</td>
	 					<td>${item.boradType}</td>
	 					<td>${item.replyType}</td>
	 					<td>${item.readPerm}</td>
	 					<td>${item.writePerm}</td>
	 					<td><a href="article/${item.boardId}/list">관리</a><a href="delete/${item.boardId}">삭제</a> <a href="update/${item.boardId}">수정</a></td>
	 				</tr>
	 			</c:forEach>
	 			</tbody>
	 		</table>
	 		<a href="./add">등록</a>
	 	</div>
	</div>
</body>
</html>