<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<c:if test="${list.size()<1}">
		<li>등록된 댓글이 없습니다.</li>
	</c:if>
	<c:forEach var="item" items="${rpList}">
		<li>${item.rpId}{item.rpContent} {item.rpDate} 수정 삭제</li>
	</c:forEach>
</body>
</html>