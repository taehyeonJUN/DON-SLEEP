<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>메인</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap');
	
	.main img{
	width: 100%;
	}
	body{
	text-align: center;
	}
	
	.row{
	background-color: rgb(200,200,200);
	text-align: center;
	}
	
	.foot{
	text-align: center;
	}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/comm/menu.jsp"></jsp:include>
	
	
<!-- 	<h2>Sweet Pizza <p/><small>Welcome!</small></h2> -->
<div class="main">
<img src="${pageContext.request.contextPath}/resources/img/bg.jpg" alt="피자사진">
</div>
	<div class="row">
      <div class="caption">
        <h3>Pizza Sweet Pizza</h3>
        <p>Where can I get some?
There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.</p>
      </div>
    </div>
    
       <footer class="foot">
<address>
  <strong>Bae Beom Soo</strong><br>
  <a href="mailto:#">qoqjatn707@naver.com</a>
</address>
</footer>
</body>

</html>