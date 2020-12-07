<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!DOCTYPE html>     
		<html>                  
		<head>                  
		<meta charset='UTF-8'>  
		<title>회원정보</title>
		</head>                 
		<body>       
<!-- 		다른 jsp파일(또는 서블릿 출력)을 현재 위치에 포함 -->

<%--  		<%@include%> : 다른jsp파일의 내용을 복사하여 현재 위치에 붙여넣기 한 것과 동일  --%>
<%-- 		<%@include file="/WEB-INF/jsp/common/menu.jsp" %> --%>
		
		  <jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>
<%-- 		  <jsp:include /> : 다른 jsp파일로 이동하여 실행한 후 다시 현재 위치로 돌아옴(forward와 유사)  --%>
		  
<%-- 		  <c:import url="/WEB-INF/jsp/common/menu.jsp"></c:import> --%>
 <%-- 		  <c:import /> : <jsp:include />와 유사하지만, 외부의 다른 사이트까지 포함 가능 --%> 
		  
		  
		  
		  
			<h1>회원목록</h1>   
<%-- 		<a href='<%=request.getContextPath()%>/member/addform.do'><button>회원추가</button></a><br /> --%>
		<a href='${pageContext.request.contextPath}/member/add.do'><button>회원추가</button></a>
		<a href='${pageContext.request.contextPath}/member/login.do'><button>로그인</button></a><br />

			<c:forEach var="vo" items="${memList}">
			<a href ='${pageContext.request.contextPath}/member/edit.do?memId=${vo.memId}'><c:out value='${vo.memId}' /></a> 
			<c:out value='${vo.memName}' />
			

<br /> 
			</c:forEach>
		
	${searchInfo.pageHTML}
	<form action="list.do" id="searchForm">
	<select name="searchType">
		<option value="id" ${searchInfo.searchType=='id'?'selected':''}>아이디</option>
		<option value="name" ${searchInfo.searchType=='name'?'selected':''}>이름</option>
		<option value="id+name" ${searchInfo.searchType=='id+name'?'selected':''}>아이디+이름</option>
		</select>
		
<!-- 		위의 방법 또는 아래의 밥법 택일해서 사용 -->
<!-- 		<script type="text/javascript"> -->
<!-- 			document.querySelector('[name="searchType"]').value='$[searchInfo.searchType]'; -->
		
<!-- 		</script> -->
		
		
		<input type="text" name="searchWord" value="${searchInfo.searchWord}" />
		<input type="submit" value="검색" />
		<input type="hidden" name="page" value="1" />
		</form>



<!-- 1111111111111111111111111111111111111111111111111111111111111111111 -->
<!-- 다음페이지 넘어가도 검색조건유지 -->
<script>
	function goPage(p) {
		document.querySelector('[name="page"]').value=p;
// 		document.forms.searchForm.page.value=p;
		document.querySelector('#searchForm').submit();
// 		document.forms.searchForm.page.submit();
	}
	
</script>

<!-- 1. 아이디+이름 검색조건 추가 -->
<!-- 2. 대소문자 구분없이 검색 -->
이전페이지와 다음페이지가 없을경우, [이전][다음]에 링크가 걸리지 않도록 수정
		</body> 
		</html>   




