<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<style>
body {
	text-align: center;
}
</style>

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

	<div>
	
		<form action="add" method="post" enctype="multipart/form-data">
			<div>
				<label>사진</label>
				<input name="upfileList" type="file" multiple="multiple">
					
			</div>

 			<button type="button" id="btnAdd">사진추가</button> 
 			
			<div id='addInput'> 
				
			</div> 
				
			
			<div>
				<textarea name='postContent' placeholder="내용 입력하세요" rows="20"
					cols="30"></textarea>
			</div>

			<div>
				<input type="submit" value="작성">
			</div>
		</form>
	</div>



</body>
</html>