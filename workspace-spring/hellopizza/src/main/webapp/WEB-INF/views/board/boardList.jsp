<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body align="center">
	<jsp:include page="/WEB-INF/views/comm/menu.jsp"></jsp:include>
	<h1>🎵글 목록🎵</h1>
	<a href='${pageContext.request.contextPath}/board/add.do'><button>새글쓰기</button></a>
	<br />
	<br />
	<table align="center" border="1">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
			<%-- 		${bbsList.get(0).bbs뫄뫄} 를 써야하는데 forEach를 해서 간단하게 만들었다 --%>
			<c:forEach var="vo" items="${boardList}">
				<tr>
					<td>${vo.bbsId}</td>
					<td><a
						href="${pageContext.request.contextPath}/board/viewer.do?bbsId=${vo.bbsId}"><c:out
								value="${vo.bbsTitle}"></c:out></a></td>
					<td><c:out value="${vo.bbsUser}" /></td>
					<td><fmt:formatDate value="${vo.bbsDate}"
							pattern="YYYY/MM/dd HH:mm:ss" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	${searchInfo.pageHTML}

	<form action="list.do" id="searchForm">
		<select name="searchType">
			<option value="title" ${searchInfo.searchType=='title'?'selected':''}>제목</option>
			<option value="writer"
				${searchInfo.searchType=='writer'?'selected':''}>작성자</option>
			<option value="title_Writer"
				${searchInfo.searchType=='title_Writer'?'selected':''}>제목+작성자</option>
		</select> <input type="text" name="searchWord" value="${searchInfo.searchWord}" />
		<input type="submit" value="검색" /> <input type="hidden" name="page"
			value="1" />
	</form>
</body>
</html>