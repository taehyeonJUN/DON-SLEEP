<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	
	<!DOCTYPE html>         
	<html>                  
	<head>                  
	<meta charset='UTF-8'>  
	<title>학생 관리</title>
	</head>                 
	<body>       
	 <jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>           
		<h1>학생 추가</h1>  
	
	

	<div> 
	<form action = '${pageContext.request.contextPath}/student/add.do' method = 'post'>
	학생 번호 : <input type='text' name='stuNo' /> <br />
	이름 : <input type='text' name='stuName' /> <br />
	점수 : <input type='text' name='stuScore' /> <br />
	<input type = 'submit' value='추가' />
	</form>
	</div> 
	</body>                    
	</html>                    