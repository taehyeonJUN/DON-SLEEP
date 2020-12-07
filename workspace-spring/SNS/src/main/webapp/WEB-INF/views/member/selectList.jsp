<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
	body{
	text-align: center;
	}
</style>
</head>
<body>
	
	<div><h2>정보보기</h2></div>

	<form action="select" method="post">
	<div>
	<div>아이디: <input type="text" name="memId" value="${memberList.memId}" readonly="readonly"></div>	
	<div>비밀번호:<input type="password" name="memPass" value="${memberList.memPass}"></div>
	<div>이름 :<input type="text" name="memName" value="${memberList.memName}"></div>
	<div>전화번호 :<input type="tel" name="memTel" value="${memberList.memTel}"></div>
	<div>소개글:<input type="text" name="memIntro" value="${memberList.memIntro}" placeholder="소개글을 입력해주세요."></div>
	</br>
	<div>가입일자:<fmt:formatDate value="${memberList.memDate}"
							pattern="YYYY/MM/dd HH:mm:ss" /></div>
	<div><input type="submit" value="수정하기"></div> </br>
	</div>
	</form>
	
	<button type="button"><a href="${memberList.memId}/delete">회원탈퇴</a></button>
		
</body>
</html>