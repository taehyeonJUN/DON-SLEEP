<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/comm/menu.jsp"></jsp:include>
<c:forEach var="vo1" items="${selectOrder}">
	<a href="${pageContext.request.contextPath}/List/list.do?orId=${vo1.orId}">
	<c:out value='${vo1.orId}'></c:out></a>
	
	<c:out value='${vo1.orUser}'></c:out>
	<c:out value='${vo1.orUname}'></c:out>
	<c:out value='${vo1.orUpn}'></c:out>
	<c:out value='${vo1.orUad}'></c:out>
	<c:out value='${vo1.orPrice}'></c:out>
	<c:out value='${vo1.orPay}'></c:out>
	<a href='${pageContext.request.contextPath}/order/Del.do?orId=${vo1.orId}'> <button type='button'>주문취소</button></a>
	<br>
	</c:forEach>
<%-- <c:forEach var="vo2" items="${selectLi}"> --%>
	
<%-- 	<c:out value='${vo2.liUser}'></c:out> --%>
<%-- 	<c:out value='${vo2.liMeid}'></c:out> --%>
<%-- 	<c:out value='${vo2.liMeprice}'></c:out> --%>
<%-- 	<c:out value='${vo2.liEa}'></c:out> --%>
<%-- 	<c:out value='${vo2.liOrNum}'></c:out> --%>
<%-- 	<c:out value='${vo2.liMename}'></c:out> --%>
<!-- 	<br> -->
<%-- 	</c:forEach> --%>
</body>
</html>