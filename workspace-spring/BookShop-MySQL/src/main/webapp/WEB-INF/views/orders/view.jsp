<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<div><h3>주문상세</h3></div>
		<div>
			<table border="1">
				<tbody>
					<tr>
						<td colspan="2">주문번호</td>
						<td colspan="3">${item.orderid}</td>
					</tr>
					<tr>
						<td colspan="2">고객명</td>
						<td colspan="3">${item.name}</td>
					</tr>
					<tr>
						<td colspan="2">판매금액</td>
						<td colspan="3"><fmt:formatNumber pattern="#,###" value="${item.saleprice}"></fmt:formatNumber></td>
					</tr>
					<tr>
						<td colspan="2">구매일자</td>
						<td colspan="3"><fmt:formatDate value="${item.orderdate}" pattern="yyyy-MM-dd"/></td>
					</tr>
					<tr>
						<td colspan="5">상세내역</td>
					</tr>
					<tr>
						<td>상세번호</td>
						<td>도서번호</td>
						<td>단가</td>
						<td>수량</td>						
						<td>소계</td>
					</tr>
					<c:forEach var="item" items="${item.detail}">
						<tr>
							<td>${item.detailid}</td>
							<td>${item.bookname}</td>
							<td><fmt:formatNumber pattern="#,###" value="${item.price}"></fmt:formatNumber></td>
							<td>${item.amount}</td>						
							<td><fmt:formatNumber pattern="#,###" value="${item.price * item.amount}"></fmt:formatNumber></td>
						</tr>
					</c:forEach>					
					<c:if test="${item.detail == null || item.detail.size() < 1}">
						<tr>
							<td colspan="5">주문내역이 없습니다</td>
						</tr>
					</c:if>									
				</tbody>
			</table>
		</div>
		<div>
			<a href="../list">이전으로</a>
		</div>
	</div>
</body>
</html>