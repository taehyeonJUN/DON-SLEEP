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
		<div><h3>도서 목록</h3></div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th>도서번호</th>
						<th>도서명</th>
						<th>출판사</th>
						<th>가격</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="5">등록 된 도서가 없습니다</td>
						</tr>
					</c:if>
					
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.bookid}</td>
							<td><a href="${item.bookid}/view">${item.bookname}</a></td>
							<td>${item.publisher}</td>
							<td>${item.price}</td>
							<td><a href="../upload/${item.cover}" target="_blank">확인</a></td>
							<td><a href="${item.bookid}/delete">삭제</a> <a href="${item.bookid}/update">변경</a> <a href="cart?bookid=${item.bookid}">장바구니</a> <a href="/review/${item.bookid}/list">리뷰</a></td>
						</tr>					
					</c:forEach>
					
				</tbody>
			</table>
		</div>
		<div><a href="add">등록</a></div>
		<div><a href="cart">장바구니</a></div>
		<div><a href="..">처음으로</a></div>
		<div><a href="dummy">대량등록</a></div>
		<div><a href="init">초기화</a></div>
	</div>
</body>
</html>