<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판추가</title>
</head>
<body>
 <jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>
	<h1>새 글쓰기</h1>
<!-- 	폼에 파일(업로드)이 포함되는 경우에는 enctype="multipart/form-data"> 속성을 지정 -->
	
		<div>
		<form action="${pageContext.request.contextPath}/bbs/add.do" method = "post" enctype="multipart/form-data">
		<table border="1">
		<tbody>
		<tr><th>제목</th><td><input type="text" name="bbsTitle"></td>
		<tr><th>내용</th><td><textarea name='bbsContent' rows="20" cols="30"></textarea></td>
		<tr><th>첨부파일1</th><td><input type="file" name="upfileList" /></td>
		<tr><th>첨부파일2</th><td><input type="file" name="upfileList" /></td>
<%-- 		<tr><th>작성자</th><td><input type="text" name="bbsWriter" value ="${sessionScope.loginUser.memId}" ></td> 보안상 좋지않음 --%>
		
		</tr>
		
		</tbody>
		
		</table>
<!-- 			제목 : <input type="text" name="bbsTitle" /> <br /> -->
<!-- 			내용 : <input type="text" name="bbsContent" /> <br /> -->
<!-- 					<textarea rows="20" cols="30"></textarea> -->
<!-- 			작성자 : <input type="text" name="bbsWriter" /> <br /> -->
		<input type = "submit" value="글쓰기" />
			
		</form>	
		</div>




</body>
</html>