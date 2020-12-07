<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
 <jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>
<div>
<form action="${pageContext.request.contextPath}/member/login.do" method = "post">
<table border="1">
	<tr><th><input name="memId" type="text" /></th></tr>
	<tr><th><input name="memPass" type="text" /></th></tr>
 
<input type = "submit" value="로그인" />
</table>
</form>
</div>
</body>
</html>