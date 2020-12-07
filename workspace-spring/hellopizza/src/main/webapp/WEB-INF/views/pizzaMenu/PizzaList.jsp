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
<h1>주문내역</h1>
 
<c:forEach var="vo2" items="${selectLiEdit}">
	
	<c:out value='${vo2.liUser}'></c:out>
	<c:out value='${vo2.liMeid}'></c:out>
	<c:out value='${vo2.liMeprice}'></c:out>
	<c:out value='${vo2.liEa}'></c:out>
	<c:out value='${vo2.liOrNum}'></c:out>
	<c:out value='${vo2.liMename}'></c:out>
<%-- 	<a href='${pageContext.request.contextPath}/list/Del.do?liOrNum=${vo2.liOrNum}'> <button type='button'>주문취소</button></a> --%>
	<br>
	</c:forEach>
	총 금액 : ${price}

</body>
</html>