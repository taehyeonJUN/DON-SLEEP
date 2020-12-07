<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
	.main{
	align-content: center;
	text-align: center;
	width: 30%;
	margin: 0 auto;
	padding-top: 50px;
	}
	.title{
	text-decoration: underline;
	width: 100%;
	}

</style>
</head>
<body align="center">
<jsp:include page="/WEB-INF/views/comm/menu.jsp"></jsp:include>
		
<div class="main">
<div class="title">
<h1>Sweet Pizza</h1>
</div>
					<!-- --부트스트랩 -->
<form action="${pageContext.request.contextPath}/member/login.do" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Fill in Your ID</label>
    <input type="text" name="memId" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Id">
    <small id="IdHelp" class="form-text text-muted">We'll never share your Id with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" name="memPW" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
  <button type="submit" class="btn btn-primary">Login</button>
</form>
</div>

</body>
</html>