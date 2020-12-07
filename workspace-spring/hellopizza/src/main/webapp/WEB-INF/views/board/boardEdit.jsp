<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
</head>
<body align="center">
<jsp:include page="/WEB-INF/views/comm/menu.jsp"></jsp:include>
	<h1>글 수정</h1>
	<form action="${pageContext.request.contextPath}/board/edit.do"
		method="post">
		<input type="hidden" name="bbsId" value="${boardVo.bbsId}" />
		<table align="center">
			<tbody>
				<tr>
					<th>제목</th>
					<td><input type="text" name="bbsTitle"
						value="${boardVo.bbsTitle}" /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="10" cols="30" name="bbsText"
							value="${boardVo.bbsText}">${boardVo.bbsText}</textarea></td>
				</tr>
				<tr>
					<th>글쓴이</th>
					<td><input type="text" name="bbsUser"
						value="${boardVo.bbsUser}" readonly="readonly" /></td>
				</tr>
				<%-- <tr><th>작성자</th> <td><input type="text" value="${loginUser.memId}" readonly="readonly"></td></tr> --%>
				<!-- <tr><th>첨부파일</th> <td><input type="file" name="upfileList" /></td></tr> -->
				<!-- 보안은 백앤드(자바)에서 처리해야한다. -->
			</tbody>
		</table>
		
<!-- 		<input type="submit" value="발행">  -->
		<a
			href='${pageContext.request.contextPath}/board/viewer.do?bbsId=${boardVo.bbsId}'>
			<button type='submit'>수정</button>
		</a><br>
		<a
			href='${pageContext.request.contextPath}/board/del.do?bbsId=${boardVo.bbsId}'>
			<button type='button'>삭제</button>
		</a><br>
	</form>

</body>
</html>