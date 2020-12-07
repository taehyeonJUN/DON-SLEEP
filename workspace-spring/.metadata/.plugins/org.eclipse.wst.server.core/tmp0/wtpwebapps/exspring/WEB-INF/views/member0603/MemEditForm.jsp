<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>학생정보</title>
</head>
<body>
 <jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>
	<h1>학생정보 수정</h1>
	<div> 
	<form action ='${pageContext.request.contextPath}/member/edit.do' method = 'post'>
	아이디 : <input type='text' name='memId' value='${memVo.memId}' readonly /><br />
	이름 : <input type='text' name='memName'  value='${memVo.memName}'/> <br />
	포인트 : <input type='text' name='memPoint' value='${memVo.memPoint}'/> <br />
	<input type = 'submit' value='제출'/>
	
	</form>
	<a href='${pageContext.request.contextPath}/member/del.do?memId=${memVo.memId}'><button type='button'>삭제</button></a><br />
	</div> 
	
</body>
</html>

