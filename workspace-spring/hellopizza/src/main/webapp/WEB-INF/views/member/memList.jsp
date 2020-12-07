<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.page_nation{
	text-align: center;
	}
	#List_one{
	text-align: center;
	}
	.List_two{
	margin: 0 auto;
	width: 50%;
	}
	
</style>
<meta charset='UTF-8'>
<title>회원관리</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/comm/menu.jsp"></jsp:include>
	<br />

<!-- ----------title------------------ -->
<div id="List_one">
<h3><span class="label label-info">Member List</span></h3>
<span class="label label-success"><a href='${pageContext.request.contextPath}/member/add.do'>Add Member</a></span>
</div>
</br>

<!-- ----table---- -->
<div class="List_two">
<table class="table table-striped">
 <thead>
   <tr class="warning">
      <th>ID</th>
      <th>이름</th>
      <th>전화번호</th>
   </tr>
 </thead>
 <tbody>
<c:forEach var="vo" items="${memList}">
   <tr>
      <td> <a href='${pageContext.request.contextPath}/member/edit.do?memId=${vo.memId}'>
	<c:out value="${vo.memId}" />
</a></td>
      <td><c:out value="${vo.memName}" /></td>
      <td><c:out value="${vo.memPN}" /></td>
   </tr>
  </c:forEach>
 </tbody> 
</table>

<div class="page_nation">
${searchInfo.pageHTML}

<form action="list.do" id="searchForm">
		<select name="searchType">
			<option value="id" ${searchInfo.searchType=='id'?'selected':''}>아이디</option>
			<option value="name" ${searchInfo.searchType=='name'?'selected':''}>이름</option>
			<option value="id_Name"
				${searchInfo.searchType=='id_Name'?'selected':''}>아이디+이름</option>
		</select> <input type="text" name="searchWord" value="${searchInfo.searchWord}" />
		<input type="submit" value="검색" /> <input type="hidden" name="page"
			value="1" />
	</form>
	
	<script>
		function goPage(p) {
			document.querySelector('[name="page"]').value = p;
			document.querySelector('#searchForm').submit();
		}
	</script>

</div>

</div>

</body>
</html>
