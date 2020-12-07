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
	<div>
		<div>
			<label>조회수:</label>
			<div>${item.viewCount}</div>
		</div>
		<div>
			<label>제목:</label>
			<div>${item.subject}</div>
		</div>
		<div>
			<label>내용:</label>
			<div>${item.content}</div>
		</div>
	</div>
	<hr>
	<div>
		<div>
			<form method="post">
				<input name="writer" type="hidden" value="익명">
				<input name="content" type="text">
				<input value="댓글" type="submit">
			</form>
		</div>
	
		<c:if test="${reply.size()<1}">
			<div>댓글이 없습니다.</div>
		</c:if>
		<c:forEach var="item" items="${reply}">
			<li>
				<span>${item.writer}</span>
				<span>${item.content}</span>
				<span>${item.regDate}</span>
			</li>
		
		</c:forEach>
	</div>
	
	
	<div>
		<span><a href="delete">삭제</a></span>
		<span><a href="update">변경</a></span>
		<a href="../list">목록</a>
	</div>
</div>
</body>
</html>