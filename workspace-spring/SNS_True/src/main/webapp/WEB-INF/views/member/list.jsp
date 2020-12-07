<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="../../resources/css/userlist.css">
<title>관리자 모드 - 유저 관리</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>

	<div class="mid-contaniner">
		<div class="mid-wrap">
			<div class="mid-head">
				<h3>유저 목록</h3>
				<table border="2" class="user-table">
					<thead>
						<tr>
							<th>유저아이디</th>
							<th>유저비번</th>
							<th>유저이름</th>
							<th>유저전화번호</th>
							<th>권한</th>
							<th>상태메시지</th>
							<th>가입일</th>
							<th>비고</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${memList}">
							<tr class="warning">
								<td>${item.memId}</td>
								<td>${item.memPass}</td>
								<td>${item.memName}</td>
								<td>${item.memTel}</td>
								<td>${item.memAuthor}</td>
								<td>${item.memIntro}</td>
								<td><fmt:formatDate value="${item.memDate}"
										pattern="YYYY-MM-dd" /></td>
								<td><a href="/member/${item.memId}/delete">강제탈퇴</a> <a
									href="/member/${item.memId}/AdminUpdate">수정</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="bottom-contaniner">
		<div class="bottom-wrap">
			<footer class="bottom">
				<h5>Copyright ⓒ 2020 Tongrami. All rights reserved.</h5>
			</footer>
		</div>
	</div>
</body>
</html>