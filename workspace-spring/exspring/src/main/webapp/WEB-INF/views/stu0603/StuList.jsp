<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>학생관리</title>
</head>
<body>
 <jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>
	<h1>학생 목록</h1>
	<a href='${pageContext.request.contextPath}/student/add.do'><button>학생추가</button></a>
	<br />

	<c:forEach var="vo" items="${StuList}">

	<a href ='${pageContext.request.contextPath}/student/edit.do?stuNo=${vo.stuNo}'><c:out value='${vo.stuNo}' /></a> : <c:out value='${vo.stuName}' />:<c:out value='${vo.stuScore}' />
	<br />
	</c:forEach>

	<%-- 			<a href='<%=request.getContextPath()%>/stu0603/StuDel.do?stuNo=<%=vo.getStuNo()%>'><button type='button'>삭제</button></a><br /> --%>



</body>
</html>
