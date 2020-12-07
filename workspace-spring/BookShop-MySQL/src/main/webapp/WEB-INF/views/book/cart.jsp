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
		<div><h3>장바구니</h3></div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th>도서번호</th>
						<th>도서명</th>
						<th>출판사</th>
						<th>가격</th>
						<th>주문량</th>
						<th>주문금액</th>						
					</tr>
				</thead>
				<tbody>					
					<c:if test="${sessionScope.cart.isEmpty()}">
						<tr>
							<td colspan="7">장바구니에 주문 정보가 없습니다</td>
						</tr>
					</c:if>
					<c:forEach var="item" items="${sessionScope.cart}">
						<tr>
							<td>${item.key}</td>
							<td>${item.value.bookname}</td>
							<td>${item.value.publisher}</td>
							<td>${item.value.price}</td>
							<td>${item.value.amount}</td>
							<td>${item.value.price * item.value.amount}</td>
						</tr>
					</c:forEach>					
				</tbody>
			</table>
		</div>
		<div><a href="order">주문하기</a></div>
		<div><a href="list">목록으로</a></div>
	</div>
</body>
</html>