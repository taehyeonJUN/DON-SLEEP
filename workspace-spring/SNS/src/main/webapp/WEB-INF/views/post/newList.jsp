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

<script>
function RpList_func(a){
	let rpPostNo = a;
	let data = {rpPostNo:rpPostNo};
	$.ajax({
		type:"POST",
		url: "/rp/rpList",
		data: JSON.stringify(data),//XMLHttpRequest의 응답 데이터를 처리할 때 사용되는 함수
		dataType:"json", //서버 응답으로 받는 타입
		contentType: "application/json", //서버로 보내지는 데이터의 content-type기본값은 “application/x-www-form-urlencoded"
		success:function(data){

			
			//html을 삽입하는걸로 바꾸고 거기에서 세션아이디와 작성자의 아이디가 일치하는 경우에만 수정 삭제 기능 추가
			$(".RpList[data-poNo="+rpPostNo+"]").empty()
			for(let i=0;i<data.list.length;i++){
			$(".RpList[data-poNo="+rpPostNo+"]").append("<li data-bookid="+data.list[i].rpPostNo +"><b>"+data.list[i].rpId+"</b> "+ data.list[i].rpContent+" "+ data.list[i].rpDate+"</li>")
			}
			
			
//아이디로는 삽입이 되지 않음
		},
	
	error:{
    }
	});
}

//댓글 작성

function RpAdd_func(a){
	let postNo = a;
	let data = {rpContent:$(".comment-input[data-postNo="+postNo+"]").val(), rpPostNo:postNo};
	$.ajax({
		type:"POST",
		url:"/rp/add",
		data: JSON.stringify(data),
		dataType:"json",
		contentType: "application/json",
// 		data:data, 
		success:function(data){
			
			$("b.rpCount[data-poNo="+postNo+"]").empty();
			$("b.rpCount[data-poNo="+postNo+"]").append(data.ch +"개의 댓글이 있습니다.");
		}
	});
}

</script>
<script>


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
			$(".like_img[data-postNo="+postNo+"]").attr('src', '../../resources/images/iconmonstr-favorite-2-240.png');

			
			$(".like_count2[data-poNo="+postNo+"]").remove();
			 let html = "<b class='em'>"+ data.like +"명이 좋아합니다</b>";
			 
			 $(".like_count1[data-poNo="+postNo+"]").append(html);
		}else if(data.likeCh =="1") {
			
			$(".dislike_img[data-postNo="+postNo+"]").attr('src', '../../resources/images/iconmonstr-favorite-1-240.png');
			$(".like_count2[data-poNo="+postNo+"]").remove();
			 let html = "<b class='em'>"+ data.like +"명이 좋아합니다</b>";
			$(".like_count1[data-poNo="+postNo+"]").append(html);
		}
		
		},
	error:{
    }
	

});
}
	
	
function follow_func(a,b){
	let followI=a;
	let followY=b;
	let data= {followI:followI, followY:followY}
	
	$.ajax({
		url: "/post/follow",
		type:"POST",
		data: JSON.stringify(data),
		dataType:"json",
		contentType: "application/json",
		success:function(data){
			if(data.followCh==0){
				alert(followY+"님을 팔로우 하셨습니다.");
				
			}
			else{
				alert(followY+"님을 팔로우 해지 하셨습니다.");
			}
			
		},
		error:{
        }
		 
	});
}
	
</script>
</head>
<body>

<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>

<!-- 	<!--  -------------html 시작 --> -->
<!-- <div class="header-contanier"> -->
<!--         <div class="header-wrap"> -->
<!--             <header class="head"> -->
<!--                 <div class="logo"><a href="#"><img src="../../resources/images/Tongrami LOGO.png" alt="통그라미로고"> TONGRAMI</a></div> -->
<!--                 검색기능 시작 -->
<!-- <div class="form-group"> -->
<!-- 		<form action="newList" method="post"> -->
<!-- 			<input type="text" name="postId"  placeholder="아이디를 입력하세요."> -->
<!-- <!-- 			<input type="submit" value="검색" class="glyphicon glyphicon-search"> --> -->
<!-- 			<button type="button" value="검색" class="glyphicon glyphicon-search"></button> -->
<!-- 		</form> -->
<!-- 	</div> -->
<!-- <!-- 검색기능 끝 --> -->
<!--                 <div class="menu-btn"><a href="#"><img src="../../resources/images/iconmonstr-menu-thin-240.png" alt="메뉴버튼"></a></div> -->
<!--                 <div class="nav-btn"> -->
                
<!--                     <ul> -->
<!--                         <a href="/"><li>로그아웃</li></a> -->
<!--                         <a href="/member/select"><li>내 정보 보기</li></a> -->
<!--                         <a href="#"><li>좋아요 리스트</li></a> -->
<!--                         <a href="/post/add"><li>게시글 올리기</li></a> -->
<!--                     </ul> -->
<!--                 </div> -->
<!--             </header> -->
<!--         </div> -->
<!--     </div> -->

    
    

<c:forEach var="item" items="${newList}">
    <div class="mid-contaniner">
        <div class="mid-wrap">
            <div class="mid-head">
                <ul>
                    <li><a href="#" class="icon"><img src="../../resources/images/iconmonstr-smiley-12-240.png" alt=""></a></li>
                    <li><a href="#"><h3>${item.postId}</h3></a></li>
                    <li><a href="#"><img src="../../resources/images/iconmonstr-menu-dot-horizontal-thin-240.png" alt=""></a></li>                
                </ul>
                <div class="delete-btn">
                    <c:if test="${sessionScope.user.memId == item.postId}">
                    <a href="/post/${item.postNo}/update">수정하기</a>
                    
                    <a href="/post/${item.postNo}/delete">삭제하기</a>
                    
                    </c:if>
                </div>
            </div>
            <div class="mid-bg">
            <c:if test="${not empty item.attachList}">
            	<c:forEach var="pho" items="${item.attachList}">
                <div class="photo-area">
                    <img src="../SNS_Photo/${pho.phoPhoto}" alt="메인이미지">
                </div>
                </c:forEach>
             </c:if>
                <div class="btn-area">
                    <ul>
                    		<c:choose>
								<c:when test="${item.likeCheck==0}">
									<li><a data-postNo="${item.postNo}" href='javascript: like_func(${item.postNo},"${sessionScope.user.memId}");'><img data-postNo="${item.postNo}" src="../../resources/images/iconmonstr-favorite-1-240.png" class="like_img"></a></li>
								</c:when>
								
								<c:when test="${item.likeCheck==1}">
									<li><a data-postNo="${item.postNo}" href='javascript: like_func(${item.postNo},"${sessionScope.user.memId}");'><img data-postNo="${item.postNo}" src="../../resources/images/iconmonstr-favorite-2-240.png" class="dislike_img"></a></li>
								</c:when>
							</c:choose>
                        <li><a href="#"><img src="../../resources/images/iconmonstr-speech-bubble-12-240.png" alt="댓글"></a></li>
                        <li><a href='javascript: follow_func("${sessionScope.user.memId}","${item.postId}");'><img src="../../resources/images/iconmonstr-paper-plane-1-240.png" alt="팔로우"></a></li>
                        <li><a href="#"><img src="../../resources/images/iconmonstr-tree-2-240.png" alt=""></a></li>
                    </ul>
                </div>
            	<h5>${item.postId} 님이 게시함</h5>
<%--             	<h5>${item.postDate} 작성</h5> --%>
            	<fmt:formatDate value="${item.postDate}"
                     pattern="YYYY/MM/dd HH:mm" />
            	<br /><br />
            	<p>${item.postContent}</p>
<%--             	<input id="comment-input" value="${item.postContent}" readonly="readonly">  --%>
<%--                 <textarea>${item.postContent}</textarea> --%>

				<h5 class="like_count1" data-poNo="${item.postNo}">
					<b class="like_count2" data-poNo="${item.postNo}">${item.postLike}명이 좋아합니다</b></h5>
            </div>
<!--              +++여기부터 댓글+++ -->
            <div id="form-commentInfo"> 
            	<c:choose>
            		<c:when test="${item.rpAmount!=0}">
            		 <span id="count"><a href="javascript:RpList_func(${item.postNo});"><b class="rpCount" data-poNo="${item.postNo}">${item.rpAmount}개의 댓글이 있습니다.</b></a></span>

							<!--               	댓글이 들어가는 공간 -->
							<div>
								<ul class="RpList" data-poNo="${item.postNo}">
									<li></li>
								</ul>

							</div>
						</c:when>
            		<c:when test="${item.rpAmount==0}">
            		<span id="count">댓글이 없습니다.</span><br/>
            		</c:when>
            	</c:choose>>
          	
              	
                <input class="comment-input" placeholder="댓글을 입력해 주세요." type="text" data-postNo="${item.postNo}">
<%--                 	<input type="hidden" value="${sessionScope.user.memId}" class="memId" >  --%>
                	<input type="hidden" value="${item.postNo}" class="postNo" data-postNo="${item.postNo}"> 
                <button id="submit"><a href="javascript:RpAdd_func(${item.postNo});" data-postNo="${item.postNo}">등록</a></button> 
            </div>
        </div>
    </div>
    <script src="../../resources/js/1020_main.js"></script>
    <script src="../../resources/js/1020_reple.js"></script>
</c:forEach>
    
    <!--  -------------html 끝 -->

</body>
</html>