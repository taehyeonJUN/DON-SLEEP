<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문정보</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/comm/menu.jsp"></jsp:include>
<h1>주문 정보 입력</h1>
<form action='${pageContext.request.contextPath}/order/list.do'method='post'>

주문번호 : <input type='text' name='orId' value='${selectOrList.orId}' readonly /><br /> 
주문회원 : <input type='text' name='orUser'value='${selectOrList.orUser}' /> <br />
성명 : <input type='text' name='orUname'value='${selectOrList.orUname}' /> <br />
연락처 : <input type='text' name='orUpn'value='${selectOrList.orUpn}' /> <br />
주소 : <input type='text' name='orUad'value='${selectOrList.orUad}' /> <br />
결제금액 : <input readonly="readonly" type='text' name='orPrice'value='${price}' /> <br />
<%-- 결제수단 : <input type='text' name='orPay'value='${selectOrList.orPay}' /> <br /> --%>
 결제수단 : <select name='orPay'>
 	<option selected="selected" value="CARD">CARD</option>
 	<option value="CASH">CASH</option>
 	<option value="SAMSUNG_PAY">SAMSUNG_PAY</option>
 </select>
<input type='submit' value='저장' /> 

<br>
<c:forEach var="vo2" items="${selectLiEdit}">
	
주문번호 : <c:out value='${vo2.liOrNum}'></c:out>
메뉴 : <c:out value='${vo2.liMename}'></c:out>
가격 : <c:out value='${vo2.liMeprice}'></c:out>
수량 : <c:out value='${vo2.liEa}'></c:out>
<%-- 	<a href='${pageContext.request.contextPath}/member/del.do?memId=${memVo.memId}'> <button type='button'>주문취소</button></a> --%>
	<br>
	<br>
	</c:forEach>
	총 금액 : ${price}
	
<%-- 주문회원 : <input type='text' name='orId' value='${selectLiEdit.liUser}' readonly /><br />  --%>
<%-- 주문id : <input type='text' name='orUser'value='${selectLiEdit.liMeid}' /> <br /> --%>
<%-- 가격 : <input type='text' name='orUname'value='${selectLiEdit.liMeprice}' /> <br /> --%>
<%-- 수량 : <input type='text' name='orUpn'value='${selectLiEdit.liEa}' /> <br /> --%>
<%-- 주문번호 : <input type='text' name='orUad'value='${selectLiEdit.liOrNum}' /> <br /> --%>
<%-- 메뉴 : <input type='text' name='orPrice'value='${selectLiEdit.liMename}' /> <br /> --%>
 

<%-- 		<a href='${pageContext.request.contextPath}/member/del.do?memId=${memVo.memId}'> <button type='button'>삭제</button></a><br /> --%>
<!-- 	</form> -->




</body>
</html>