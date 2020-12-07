<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!DOCTYPE html>
		<html>
	<head>
	<meta charset="UTF-8">
	<title>회원관리</title>
	<style>
	
	.main{
		text-align: center;
		margin: 0 auto;
		width: 50%;
	}
	
	.main li input{
		outline: none;
		border: 0px;
		background: inherit;
		border-bottom: 1px solid #ddd;
		text-align: center;
	}
	
	#Add_one{
	margin: 0 auto;
	width: 50%;
	text-align: center;
	text-decoration: none;
	}
	
	</style>
		</head>
		<body align = 'center'>
		<jsp:include page="/WEB-INF/views/comm/menu.jsp"></jsp:include>
	<div class="main">	
		
		<div id="Add_one">
	<h3><span class="label label-info">Add For Member</span></h3>
	</div>	
		
		<!-- --------List-------- -->
<div id="Add_Two">
<form action='${pageContext.request.contextPath}/member/add.do'method='post'>
<ul class="list-group">
  <li class="list-group-item list-group-item-success">
  ID : <input type='text' name="memId">
  </li>
  <li class="list-group-item list-group-item-info">
  NAME : <input type='text' name="memName"/>
  </li>
  <li class="list-group-item list-group-item-warning">
  PW : <input type="password" name="memPW"/>
  </li>
  <li class="list-group-item list-group-item-danger">
  PHONE : <input type='text' name="memPN" />
  </li>
</ul>

<input type="hidden" name="ROL" value="USER" readonly/> <br />
	   <span class="glyphicon glyphicon-hand-down"> 
	   <br />
	   <input type="submit" value="Save" />
	   </span>
</form>
</div>
	</div>
		</body>
		</html>