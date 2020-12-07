<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--     태그이름에 form 접두어를 붙여서 스프링이 제공하는 폼 관련태그를 사용 -->
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


		<!DOCTYPE html>         
		<html>                  
		<head>                  
		<meta charset="UTF-8">  
		<title>회원 관리</title>
		</head>                 
		<body>      
		 <jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>            
			<h1>회원 가입</h1>  
	
		<div> 
		<form action = "${pageContext.request.contextPath}/member/add.do" method = "post">
			아이디 : <input type="text" name="memId" value="${memberVo.memId}"/> <br />
			비밀번호 : <input type="text" name="memPass" value="${memberVo.memPass}"/> <br />
			이름 : <input type="text" name="memName" value="${memberVo.memName}"/> <br />
			포인트 : <input type="text" name="memPoint" value="${memberVo.memPoint}"/> <br />
		<input type = "submit" value="가입" />
		</form>
		
<!-- 		정보가 저장되지 않으면 양식에 남음 -->
<!-- 스프링 form태그의 modelAttribute속성에 모델 객체의 이름을 설정하고 -->
<!-- 폼 내부의 입력 엘리먼트들의 path 속성에 모델 객체의 속성(변수) 이름을 설정하면, 입력엘리먼트들의 id,name,value 속성값을 자동으로 설정해 준다. -->
<!-- errors 태그를 사용하여, @Valid로 검증한 결과의 에러메세지를 출력 가능 -->
		<form:form modelAttribute="memberVo" action="${pageContext.request.contextPath}/member/add.do" method="post">
			아이디 : <form:input path="memId" /> <form:errors path="memId" /><br />
			비밀번호 : <form:input path="memPass"/> <form:errors path="memPass" /><br />
			이름 : <form:input path="memName"/> <form:errors path="memName" /><br />
			포인트 : <form:input path="memPoint"/> <form:errors path="memPoint" /><br />
		<input type = "submit" value="가입" />
		</form:form>
		
		</div>

		</body>                      
		</html>                      