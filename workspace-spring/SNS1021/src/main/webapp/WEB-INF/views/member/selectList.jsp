<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../resources/css/1019_info.css">
    <script src="https://kit.fontawesome.com/771dcbfe42.js" crossorigin="anonymous"></script>
    <title>내 정보 보기</title>


</head>
<body>
	<header id="navbar">
        <nav class="navbar__wrap">
            <div class="navbar__logo">
                <!-- <i class="fab fa-fly"></i> -->
                <img src="../../resources/images/Tongrami LOGO.png" alt="logo">
                <a href="#">tongrami</a>
            </div>
            <ul class="navbar__menu__icon">
                <li><a href="#"><i class="fas fa-home"></i></a></li>
                <li><a href="#"><i class="far fa-envelope"></i></a></li>
                <li><a href="#"><i class="far fa-thumbs-up"></i></a></li>
                <li><a href="#"><i class="far fa-smile"></i></a></li>
            </ul>
            <ul class="navbar__menu__text">
                <li><a href="#">home</a></li>
                <li><a href="#">message</a></li>
                <li><a href="#">like</a></li>
                <li><a href="#">setting</a></li>
            </ul>
            <a href="#" class="navbar__toogleBtn">
                <i class="fas fa-bars"></i>
            </a>
        </nav>
    </header>
	
	<main class="main-container">
        <div class="main-wrap">
	<div class="info-head">
		<h1>정보보기</h1>
	</div>
<section class="basic-info">

	<form action="select" method="post">
	<div>
	<div>아이디: <input type="text" name="memId" value="${memberList.memId}" readonly="readonly"></div>	
	<div>비밀번호:<input type="password" name="memPass" value="${memberList.memPass}"></div>
	<div>이름 :<input type="text" name="memName" value="${memberList.memName}"></div>
	<div>전화번호 :<input type="tel" name="memTel" value="${memberList.memTel}"></div>
	<div>소개글:<input type="text" name="memIntro" value="${memberList.memIntro}" placeholder="소개글을 입력해주세요."></div>
	</br>
	 </section>
	   <section class="join-date">
	<div>가입일자:<fmt:formatDate value="${memberList.memDate}"
							pattern="YYYY/MM/dd HH:mm:ss" /></div>
							</section>
	   <section class="info-btn">
	<div>
	<input type="submit" value="수정하기">
	<button type="button"><a href="${memberList.memId}/delete">회원탈퇴</a></button>
	</div> </br>
	</div>
	        </section>
	</form>
	
	<footer class="foot">
        <div>copyright tongrami</div>
    </footer>
</body>
</html>