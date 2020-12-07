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
	<h1>학생 정보 상세조회</h1>


	<div>
		<form action='${pageContext.request.contextPath}/student/edit.do'
			method='post'>
			학생번호 : <input type='text' name='stuNo' value='${stuVo.stuNo}'readonly /><br /> 
			이름 : <input type='text' name='stuName'value='${stuVo.stuName}' /> <br /> 
			성적 : <input type='text'name='stuScore' value='${stuVo.stuScore}' /> <br /> 
			<input type='submit' value='수정' /> 
			<a href='${pageContext.request.contextPath}/student/del.do?stuNo=${stuVo.stuNo}'><button
			type='button'>삭제</button></a><br />
		</form>
	</div>



</body>
</html>
