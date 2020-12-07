<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
    <!-- 댓글 css & 댓글 부트스트랩-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Main css -->
     <link rel="stylesheet" href="../../resources/css/main_dark_2.css">
     <link rel="stylesheet" href="../../resources/css/main_reple_2.css">
     <link rel="stylesheet" href="../../resources/css/main_default.css">
    <!-- logo 폰트 -->
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <!-- 나눔고딕 폰트 -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap" rel="stylesheet">
    <!-- 토글, 스르륵 jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    
    <title>:::::: Tongrami ::::::</title>
</head>
<body>

	<div class="header-contanier">
		<div class="header-wrap">
			<header class="head">
				<div class="logo">
					<a href="#"><img src="../../resources/images/iconmonstr-beer-11-240.png" alt="통그라미로고"> </a>
				</div>
				<div class="logo-font">
					<p>Tongrami</p>
				</div>
				<!-- 검색기능 시작 -->
				<div class="form-group">
					<form action="newList" method="post">
						<input type="text" name="postId" placeholder="     아이디를 입력하세요.">
						<button type="button" value="검색" class="glyphicon glyphicon-search"><img src="../../resources/images/free-icon-search-107122.png" alt="search"></button>
					</form>
				</div>
				<!-- 검색기능 끝 -->
				<!-- 햄버거 시작 -->
				<div class="menuicon-contaniner">
					<input type="checkbox" id="menuicon"> 
					<label for="menuicon">
						<span></span> 
						<span></span> 
						<span></span>
					</label>
					<div class="sidebar">
						<div class="menu-1">
							<ul>
								<li><a href="/post/list">Home</a></li>
								<li><a href="/member/select">My info</a></li>
								<li><a href="/post/add">Post</a></li>
								<li><a href="/">Logout</a></li>
								<c:if test="${sessionScope.user.memAuthor == 'ADMIN'}">
									<li><a href="/member/list">Users</a></li>
								</c:if>
							</ul>
							<div class="checkbox-wrap">
								<input type="checkbox" class="checkbox" id="checkbox"> 
								<label for="checkbox" class="label">
									<div class="ball"></div>
								</label>
							</div>
						</div>
					</div>
				</div>
				<!-- 햄버거 끝 -->
			</header>
		</div>
	</div>
	<!-- main 자바스크립트 -->  
    <script src="../../resources/js/main_toggle.js"></script>
    <script src="../../resources/js/main_reple.js"></script>
    <script src="../../resources/js/main_srr.js"></script>
    <script src="../../resources/js/main_dark.js"></script>
    <script src="../../resources/js/main_like.js"></script>
    <script src="../../resources/js/main_follow.js"></script>
<!--     <script src="../../resources/js/main_Rp.js"></script> -->
    <script src="../../resources/js/main_Rpadd.js"></script>
</body>
</html>