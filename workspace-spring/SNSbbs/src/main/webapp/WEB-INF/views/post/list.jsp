<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#title {
	text-align: center;
}
</style>
<meta charset="UTF-8">
<title></title>
<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
	crossorigin="anonymous"></script>
<script type="text/javascript">
function like_func(a,b){
	let postId = b;
	let postNo =a;
	let data= {postId:postId, postNo:postNo}
	alert(postNo);
	$.ajax({
		url: "/post/like",
		type:"POST",
		data: JSON.stringify(data),
		dataType:"json",
		contentType: "application/json",
		success:function(data){
			//여기서 a태그에 달린 이미지를 변경해야함
			alert("좋아요성공"+data.likeCh)
			if (data.likeCh =="0") {
//					if("${item.postNo}"==postNo){
					
				$('img#dislike_img').attr('src', 'https://w7.pngwing.com/pngs/337/920/png-transparent-red-heart-illustration-red-curry-heart-heart-no-background-love-logo-red.png');
				alert("like");
//					}
				
			}else
				$('img#like_img').attr('src', 'https://w7.pngwing.com/pngs/518/473/png-transparent-heart-symbol-heart-line-love-text-heart.png');
				alert("dislike");
			
			},
		error:{
//             alert("좋아요실패");
        }

	});
	}
	
	
</script>
</head>
<body>

	<div class="form-group row">
		<form action="newList" method="post">
			<input type="text" name="postId"  placeholder="아이디를 입력하세요.">
			<input type="submit" value="검색">
		</form>
	</div>

	<div>
		<h1 id="title">Post List</h1>
		<div>
			<table border="1" align=center>
				<thead>
					<tr>
						<th>작성자</th>
						<th>내용</th>
						<th>사진</th>
						<th>좋아요</th>
						<th>작성일자</th>
						<th>글번호</th>
						<th>비고</th>
						<th>Quick</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${list}">
						<c:if test="${not empty item.attachList}">
							<c:forEach var="pho" items="${item.attachList}">
								<tr>
									<td><img src="../SNS_Photo/${pho.phoPhoto}" width="300px"></td>
								</tr>
							</c:forEach>
						</c:if>
						<tr>

							<td>${item.postId}</td>

							<td><textarea>${item.postContent}</textarea></td>

							<td>사진자리</td>

							<td>좋아요 : <span class="like_count">${item.postLike}</span> <c:choose>
									<c:when test="${item.likeCheck==0}">
										<a
											href='javascript: like_func(${item.postNo},${item.postId});'><img
											src="https://w7.pngwing.com/pngs/518/473/png-transparent-heart-symbol-heart-line-love-text-heart.png"
											width="50px" id="dislike_img"></a>
									</c:when>
									<c:when test="${item.likeCheck==1}">
										<a
											href='javascript: like_func(${item.postNo},${item.postId});'><img
											src="https://w7.pngwing.com/pngs/337/920/png-transparent-red-heart-illustration-red-curry-heart-heart-no-background-love-logo-red.png"
											width="50px" id="like_img"></a>
									</c:when>
								</c:choose>
							
							<td>
							<fmt:formatDate value="${item.postDate}"
							pattern="YYYY/MM/dd HH:mm:ss" />
							</td>

							<td>${item.postNo}</td>

							<td><a href="${item.postNo}/delete">삭제</a> <a
								href="${item.postNo}/update">변경</a>
								 <a href="../rp/${item.postNo}/rpList">댓글</a> <%-- 								<a href="../rp/${item.postNo}/rpList">댓글</a> --%>
								</td>
								
								<td>
								<a class="dropdown-item" data-toggle="modal"
								data-target="#moaModal">전체댓글보기<i class="fas fa-arrow-right"></i>
							</a>
								</td>
							</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>

	 <!-- Moa Modal-->
  <div class="modal fade" id="moaModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">전체댓글보기</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">x</span>
          </button>
        </div>
        <div class="modal-body">
						<table>
						<thead>
							<tr>
								<th>Notice</th>
							</tr>
						</thead>
							<tbody>
								<tr>
									<td>
							 			<small>준비중입니다.</small> 
									</td>
								</tr>
							</tbody>
						</table>
						
        </div>
        <div class="modal-footer">
          <button class="btn btn-primary" type="button" data-dismiss="modal">Cancel</button>
        </div>
      </div>
    </div>
  </div>
	</div>

</body>
</html>