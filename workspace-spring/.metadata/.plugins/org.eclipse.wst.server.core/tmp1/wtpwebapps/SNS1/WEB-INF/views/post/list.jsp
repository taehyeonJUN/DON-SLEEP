<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<div>
		<div>
			<table>
				<thead>

				</thead>
				<tbody>
					<c:forEach var="item" items="${list}">
					
						<c:if test="${not empty item.postPhoto}">
						<tr>
						<td><img src="../SNS_Photo/${item.postPhoto}" width="300px"></td>
						</tr>
						</c:if>
						<tr>
							<td><textarea>${item.postContent}</textarea></td>
							
						</tr>
					
						<tr>
							<td>작성자 : ${item.postId}</td>
						</tr>
						<tr>
							<td>좋아요  ${item.postLike}</td>
						</tr>
						<tr>
							<td>${item.postDate}</td>
						</tr>
						
						<tr><td colspan="2"> </td><td><a href="${item.postNo}/delete">삭제</a> <a href="${item.postNo}/update">변경</a></td></tr>
						<div></div>
						
					</c:forEach>
				
				</tbody>
			</table>
		</div>
	</div>




</body>
</html>