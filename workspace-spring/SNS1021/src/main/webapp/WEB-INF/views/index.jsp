<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SNS</title>
<style>
	body{
		text-align: center;
	}
</style>
</head>
<body>
		<div><h1>메인 페이지에 오신걸 환영합니다!</h1></div>
	<c:if test="${sessionScope.user != null}">
	<div><h1>${sessionScope.user.memId}님환영합니다!</h1></div>

	<div>
		<form action="logout">
		<div>
			<input type="submit" value="로그아웃">
		</div>
		
		
		</form>
	
	<div><h3><a href="member/list">회원목록</a></h3></div>	
	<div><h3><a href="member/select">내정보보기</a></h3></div>	
	<div><h3><a href="/post/list">글목록</a></h3></div>	
	<div><h3><a href="/post/add">글작성</a></h3></div>
	
	</div>
	</c:if>
	
	<c:if test="${sessionScope.user == null}">
	<div>
	<form>
			<div><a href="login">로그인 페이지로 이동</a></div>
			<div><a href="register">회원가입하기</a></div>
	</form>
	</div>
	</c:if>
	
			
</body>
</html>