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
	
			<c:if test="${list.size()<1}">			
				<li>등록된 리뷰가 없습니다.</li>
			</c:if>
			
			<c:forEach var="item" items="${list}">
				<li>내용:${item.content} 작성자아이디:${item.custid} 별점:${item.star}</li>
			</c:forEach>

</body>
</html>