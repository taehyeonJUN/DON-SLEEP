<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Poly cms2020</title>
</head>
<body>
<div>
	<div></div>
	<div>
		<ul>
		 <li><a href="board/list">게시판 관리</a></li>
		</ul>
	</div>
	
	<div>
		<div>공지사항</div>
			<ul>
				<c:if test="${notice.size()<1}">
					<li>등록된 게시물이 없습니다</li>
				</c:if>
				<c:forEach var="item" items="${notice}">
					<li>
						<span>${item.articleId}</span>
						<span><a href="board/article/7/${item.articleId}/view">${item.subject}</a></span>
						<span><fmt:formatDate value="${item.regDate}" pattern="yyyy-MM-dd" /> </span>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div>자주하는 질문</div>
			<ul>
				<c:if test="${feq.size()<1}">
					<li>등록된 게시물이 없습니다</li>
				</c:if>
				<c:forEach var="item" items="${notice}">
					<li>
						<span>${item.articleId}</span>
						<span><a href="board/article/7/${item.articleId}/view">${item.subject}</a></span>
						<span><fmt:formatDate value="${item.regDate}" pattern="yyyy-MM-dd" /> </span>
					</li>
				</c:forEach>
			</ul>
		</div>
</div>
</body>
</html>