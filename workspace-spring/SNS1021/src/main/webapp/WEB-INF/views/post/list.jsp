<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../resources/css/1020_main.css">
    <link rel="stylesheet" type="text/css" media="screen" href="../../resources/css/1020_reple.css"> 
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap" rel="stylesheet">


<title></title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>


<script type="text/javascript">

		function like_func(a,b){
		let postId = b;
		let postNo = a;
		let data= {postId:postId, postNo:postNo}
		$.ajax({
			url: "/post/like",
			type:"POST",
			data: JSON.stringify(data),
			dataType:"json",
			contentType: "application/json",
			success:function(data){
				//여기서 a태그에 달린 이미지를 변경해야함
				$('.em').remove();
				if (data.likeCh =="0") {
					$(".like_img[data-postNo="+postNo+"]").attr('src', 'https://w7.pngwing.com/pngs/337/920/png-transparent-red-heart-illustration-red-curry-heart-heart-no-background-love-logo-red.png');
// 					$(".like_img[data-postNo="+postNo+"]").remove();
// 					let img = "<img data-postNo="+postNo+"]" src ="https://w7.pngwing.com/pngs/337/920/png-transparent-red-heart-illustration-red-curry-heart-heart-no-background-love-logo-red.png">";
// 					$("td[data-postNo="+postNo+"]").append(img);
					
					$(".like_count2[data-poNo="+postNo+"]").remove();
					 let html = "<span class='em'>"+ data.like +"</span>";
					 $(".like_count1[data-poNo="+postNo+"]").append(html);
// 					 $(html).appendTo(".like_count1[data-poNo="+postNo+"]");
				}else if(data.likeCh =="1") {
					
					
					$(".dislike_img[data-postNo="+postNo+"]").attr('src', 'https://w7.pngwing.com/pngs/518/473/png-transparent-heart-symbol-heart-line-love-text-heart.png');
					$(".like_count2[data-poNo="+postNo+"]").remove();
					 let html = "<span class='em'>"+ data.like +"</span>";
					 $(".like_count1[data-poNo="+postNo+"]").append(html);
				}
				
				},
			error:{
            }
			

		});
		}

</script>
</head>
<body>


	
	
<!--  -------------html 시작 -->
<div class="header-contanier">
        <div class="header-wrap">
            <header class="head">
                <div class="logo"><a href="#"><img src="../../resources/images/Tongrami LOGO.png" alt="통그라미로고"> TONGRAMI</a></div>
                <!-- 검색기능 시작 -->
<div class="form-group">
		<form action="newList" method="post">
			<input type="text" name="postId"  placeholder="아이디를 입력하세요.">
<!-- 			<input type="submit" value="검색"> -->
			<button type="button" value="검색" class="glyphicon glyphicon-search"></button>
		</form>
	</div>
<!-- 검색기능 끝 -->
                <div class="menu-btn"><a href="#"><img src="../../resources/images/iconmonstr-menu-thin-240.png" alt="메뉴버튼"></a></div>
                <div class="nav-btn">
                
                    <ul>
                        <a href="/"><li>로그아웃</li></a>
                        <a href="/member/select"><li>내 정보 보기</li></a>
                        <a href="#"><li>좋아요 리스트</li></a>
                        <a href="/post/add"><li>게시글 올리기</li></a>
                    </ul>
                </div>
            </header>
        </div>
    </div>
    
    


    <div class="mid-contaniner">
        <div class="mid-wrap">
            <div class="mid-head">
                <ul>
                    <li><a href="#" class="icon"><img src="../../resources/images/iconmonstr-smiley-12-240.png" alt=""></a></li>
                    <li><a href="#"><h3>ID_TONGRAMI</h3></a></li>
                    <li><a href="#"><img src="../../resources/images/iconmonstr-menu-dot-horizontal-thin-240.png" alt=""></a></li>                
                </ul>
                <div class="delete-btn">
                    <a href="#">수정하기</a>
                    <a href="#">삭제하기</a>
                </div>
            </div>
            <div class="mid-bg">
                <div class="photo-area">
                    <img src="../../resources/images/jeju.jpg" alt="메인이미지">
                </div>
                <div class="btn-area">
                    <ul>
                        <li><a href="#"><img src="../../resources/images/iconmonstr-favorite-1-240.png" alt=""></a></li>
                        <li><a href="#"><img src="../../resources/images/iconmonstr-speech-bubble-12-240.png" alt=""></a></li>
                        <li><a href="#"><img src="../../resources/images/iconmonstr-paper-plane-1-240.png" alt=""></a></li>
                        <li><a href="#"><img src="../../resources/images/iconmonstr-tree-2-240.png" alt=""></a></li>
                    </ul>
                </div>
            </div>
            <div id="form-commentInfo"> 
                <div id="comment-count">댓글 <span id="count">0</span></div> 
                <input id="comment-input" placeholder="댓글을 입력해 주세요."> 
                <button id="submit">등록</button> 
            </div>
        </div>
    </div>
    <script src="../../resources/js/1020_main.js"></script>
    <script src="../../resources/js/1020_reple.js"></script>
    
    <!--  -------------html 끝 -->
    



	
	<div>
		<div>
			<table>
				<thead>
				
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
							<td><textarea>${item.postContent}</textarea></td>
							
						</tr>
					
						<tr>
							<td>작성자 : ${item.postId}</td>
							
							
							<td id="postNo" >글 번호(나중에 감춤) : ${item.postNo}</td>
						</tr>
						<tr>
							<td class="like_count1" data-poNo="${item.postNo}">좋아요 : <span class="like_count2" data-poNo="${item.postNo}">${item.postLike}</span>
							</td>
							<td data-postNo="${item.postNo}">
							<c:choose>
							<c:when test="${item.likeCheck==0}">
							<a href='javascript: like_func(${item.postNo},${sessionScope.user.memId});'><img data-postNo="${item.postNo}" src="https://w7.pngwing.com/pngs/518/473/png-transparent-heart-symbol-heart-line-love-text-heart.png" width="50px" class="like_img"></a>
							</c:when>
							<c:when test="${item.likeCheck==1}">
							<a href='javascript: like_func(${item.postNo},${sessionScope.user.memId});'><img data-postNo="${item.postNo}" src="https://w7.pngwing.com/pngs/337/920/png-transparent-red-heart-illustration-red-curry-heart-heart-no-background-love-logo-red.png" width="50px" class="dislike_img"></a>
							</c:when>
							</c:choose>
							
							<td/>
						</tr>
						<tr>
							<td>${item.postDate}</td>
						</tr>
						
						<tr><td colspan="2"> </td><td><a href="${item.postNo}/delete">삭제</a> <a href="${item.postNo}/update">변경</a></td></tr>
						<tr><td><button><a href="../rp/${item.postNo}/rpList">댓글</a></button></td></tr>
						<tr><td><a class="dropdown-item" data-toggle="modal"
								data-target="#moaModal">modal댓글<i class="fas fa-arrow-right"></i></a></td></tr>
						<div>
						</div>
						
						
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