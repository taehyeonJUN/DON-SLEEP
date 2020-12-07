<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- upload 화면 css --> 
    <link rel="stylesheet" href="../../resources/css/add.css">
    <!-- logo 폰트 -->
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <!-- 나눔고딕 폰트 -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap" rel="stylesheet">

    <title>게시글 올리기</title>


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
				<div class="upload-box">
					<form action="add" method="post" enctype="multipart/form-data">
						 <span class="table-head"><h3>Upload Page</h3></span>
						
                    <table class="upload-table">
                        <tr>
                            <th scope="row">사진</th>
                            <td><input name="upfileList" type="file" multiple="multiple"></td>
                        </tr>
                        <tr>
                            <th scope="row">게시글</th>
                            <td><textarea name="postContent" id="text" rows="10" placeholder=" 게시글을 입력해주세요."></textarea></td>
                        </tr>
                    </table>
                    <div class="table-bottom">
                        <a href=""><button>취소</button></a>
                        <input type="submit" value="등록">
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
    </footer>
    <!-- 라이트/다크 js -->
    <script src="../../js/main/1021_main_lightDarkTheme.js"></script>
</body>
</html>