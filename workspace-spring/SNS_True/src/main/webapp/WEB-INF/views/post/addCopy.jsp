<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<link rel="stylesheet" href="../../resources/css/upload.css">
<style>
.check{
text-align: center;
}
</style>


<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>


<script type="text/javascript"> 

$(function(){
    $("#btnAdd").click(function(){ 
       
      var html ='<tr><td><input type="file" name="upfileList" multiple="multiple"></td>'; 
      html += '<td><button type="button" class="btnRemove">사진 삭제</button></td></tr>';
     $("#addInput").append(html);
      }); 
      $("#addInput").on("click",".btnRemove",function(){
       $(this).parent().parent().remove();  
      });
});
 </script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>

	<div class="mid-contaniner">
		<div class="mid-wrap">
			<div class="mid-head">
				<h3>사진</h3>

				<div class="upload-box">
					<form action="add" method="post" enctype="multipart/form-data">
						<h3><strong>파일을선택해주세요.</strong></h3>
						<span><h5><input name="upfileList" type="file" multiple="multiple"></h5></span>

						<span><button type="button" id="btnAdd" class="glyphicon glyphicon-plus"></button></span>

						<h5><div id='addInput'></div></h5>
				</div>
				<div class="text-box">
					<h3>게시글 작성</h3>
					<textarea name="postContent" id="text" cols="55" rows="13"
						placeholder="내용 입력하세요"></textarea>
				</div>
				<div class="check">
					<input type="submit" value="추가하기">
				</div>
				</form>
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