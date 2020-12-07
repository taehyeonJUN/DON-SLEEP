<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table border="1">
		 <thead>
		 	<tr>
		 		<th>리뷰번호</th>
		 		<th>작성자</th>
		 		<th>내용</th>
		 		<th>평점</th>
		 		<th>작성일시</th>
		 	</tr>
		 </thead>
		<tbody>
			<c:if test="${list.size()<1}">			
			<tr>
				<td>등록된 리뷰가 없습니다.</td>
			</tr>
			</c:if>
			
			<c:forEach var="item" items="${list}">
			<tr>
				<td>${item.reviewId}</td>
				<td>${item.custid}</td>
				<td>${item.content}</td>
				<td>${item.star}</td>
				<td>${item.regdate}</td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
	</div>
</body>
</html>