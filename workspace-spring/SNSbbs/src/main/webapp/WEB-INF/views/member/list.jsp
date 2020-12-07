<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memList</title>
<style>
.main{
	text-align: center;
	margin: 0 auto;
}
.title{
text-align: center;
}

</style>
</head>
<body>

	<div>
		<div class="title">
			<h3>유저목록</h3>
		</div>
		<div>
			<table border="1" class="main">
				<thead>
					<tr>
						<th>유저아이디</th>
						<th>유저비번</th>
						<th>유저이름</th>
						<th>유저전화번호</th>
						<th>권한</th>
						<th>상태메시지</th>
						<th>가입일</th>
						<th>팔로우</th>
						<th>팔로워</th>
					</tr>
				</thead>
				<tbody>
				 <c:forEach var="item" items="${memList}">
				 	<tr>
				 	<td>${item.memId}</td>
				 	<td>${item.memPass}</td>
				 	<td>${item.memName}</td>
				 	<td>${item.memTel}</td>
				 	<td>${item.memAuthor}</td>
				 	<td>${item.memIntro}</td>
				 	<td><fmt:formatDate value="${item.memDate}" pattern="YYYY-MM-dd"/></td>
				 	<td>${item.memFollow}</td>
				 	<td>${item.memFollower}</td>
				 	</tr>
				 </c:forEach>
				</tbody>
</table>
</div>

</div>
</body>
</html>