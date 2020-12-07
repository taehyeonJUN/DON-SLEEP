<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>회원 관리</title>
<style>
	#Update_one{
	margin: 0 auto;
	width: 50%;
	text-align: center;
	text-decoration: none;
	}
	
	#Update_two{
	margin: 0 auto;
	width: 50%;
	text-align: center;
	}
	
	#Update_two li input {
		outline: none;
		border: 0px;
		background: inherit;
		border-bottom: 1px solid #ddd;
		text-align: center;
	}
	
	#Update_th li{
	display: inline-block;
	text-align: center;
	margin: 0 auto;
	padding: 0px;
	}
	
	#Update_th button{
	text-align: center;
	outline: none;
	border: none;
	background: inherit;
	border-bottom: 1px solid #ddd;
	}
	
	#Update_th a{
	color: #000000;
	}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/comm/menu.jsp"></jsp:include>
<br />

	<div id="Update_one">
	<h3><span class="label label-info">Update For Member</span></h3>
	</div>	

<!-- --------List-------- -->
<div id="Update_two">
<form action='${pageContext.request.contextPath}/member/edit.do'method='post'>
<ul class="list-group">
  <li class="list-group-item list-group-item-success">
  ID : <input type='text' name='memId' value='${memVo.memId}' readonly/>
  </li>
  <li class="list-group-item list-group-item-info">
  NAME : <input type='text' name='memName'value='${memVo.memName}' />
  </li>
  <li class="list-group-item list-group-item-warning">
  PHONE : <input type='text' name='memPN' value='${memVo.memPN}' />
  </li>
</ul>

<div id="Update_th">
<ul>
	<li> <a href='${pageContext.request.contextPath}/member/del.do?memId=${memVo.memId}'> <button type='button'>회원삭제</button></a><br /></li>
	<li> <input type='submit' value='회원수정' /></li>
</ul>
</div> 

</form>
</div>
</body>
</html>