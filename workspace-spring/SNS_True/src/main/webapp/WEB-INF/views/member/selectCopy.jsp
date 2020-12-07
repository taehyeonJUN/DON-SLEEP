<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.main {
	margin-top: 150px
}
body{
	text-align: center;
}
</style>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../../resources/css/1020_main.css">
<script src="https://kit.fontawesome.com/771dcbfe42.js"
	crossorigin="anonymous"></script>
<title>내 정보 보기</title>


</head>
<body>
	<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
	<div class="main">
		<form action="select" method="post">
			<div>
				아이디: <input type="text" name="memId" value="${memberList.memId}"
					readonly="readonly">
			</div>
			<div>
				비밀번호:<input type="password" name="memPass"
					value="${memberList.memPass}">
			</div>
			<div>
				이름 :<input type="text" name="memName" value="${memberList.memName}">
			</div>
			<div>
				전화번호 :<input type="tel" name="memTel" value="${memberList.memTel}">
			</div>
			<div>
				소개글:<input type="text" name="memIntro"
					value="${memberList.memIntro}" placeholder="소개글을 입력해주세요.">
			</div>
			<div class="info-btn">
				<div>
					<input type="submit" value="수정하기">
					<button type="button">
						<a href="${memberList.memId}/delete">회원탈퇴</a>
					</button>
				</div>
				</br>
			</div>
		</form>
		</br>
		<div class="join-date">
			<div>
				가입일자:
				<fmt:formatDate value="${memberList.memDate}"
					pattern="YYYY/MM/dd HH:mm:ss" />
			</div>
		</div>

		<footer class="foot">
			<div>copyright tongrami</div>
		</footer>
	</div>
</body>
</html>