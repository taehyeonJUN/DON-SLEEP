<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<title>댓글</title>
<style type="text/css">
#templates {
	display: none;
}
</style>
</head>
<body text align="center">
	<h1>댓글 구현 화면</h1>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>작성자:</th>
					<th>글내용:</th>
					<th>좋아요:</th>
					<th>날짜:</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${postData.postId}</td>
					<td><textarea>${postData.postContent}</textarea></td>
					<td>${postData.postLike}</td>
					<td>${postData.postDate}</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- 	-------------------댓글 --------------------- -->

	<!-- -----------댓글 작성 정보 폼 시작 ----------- -->
	<hr />
	<form action="" id="rpform">
		<div>
			<input type="text" name="rpId" value="${user.memId}"
				readonly="readonly">
		</div>
		<div>
			<textarea name="rpContent" rows="15" cols="23" placeholder="댓글란"></textarea>
		</div>
		<input type="hidden" name="rpPostNo" value="${postData.postNo}">
		<input type="button" value="저장" id="saveBtn" />
	</form>
	<!-- --------------댓글 작성 정보 폼 끝 --------- -->

	<!-- ------------댓글 리스트 ---------------- -->

	<hr />
	<div id="rpDiv"></div>
	<div id="bodyContents"></div>
	<div id="templates">
		<div id="rpTemplate">
			<div>
				<span data-id="rpId"></span> <span data-id="rpDate"></span>
				<!-- 				<div data-id="rpContent"></div> -->
				</br> 
				<div>
<!-- 				<textarea data-id = "rpContent" name="rpContent" cols="10"></textarea> -->
				<div data-id = "rpContent" name="rpContent"> </div>
				</div>
				<c:if test="${user.memId == postData.postId}">
					<button type="button" class="delBtn">삭제</button>
					<button type="button" class="upBtn">수정</button>
				</c:if>
				<hr />
			</div>
		</div>
		<!-- 엔터처리를 깔끔하게 해주는 pre 태그 -->
	</div>
	<!-- ------------댓글 리스트 끝 ---------------- -->




	<!---------------function 기능 생성 시작---------------------->
	<script type="text/javascript">
		function refreshReplyList() {
			$.ajax({
				url : "../replyList", // 리스트 요청
				method : "GET",
				data : {
					rpPostNo : $('[name="rpPostNo"]').val()
				// 값 읽어오기
				},
				dataType : "json"
			}).done(function(data) {
				console.log(data);
				$('#rpDiv').html(''); // 목록 초기화
				for (var i = 0; i < data.length; i++) {
					var rep = data[i];
					// 			#rpTemplate의 값을 가지는 요소를 복제하여 #rpDiv에 삽입
					// 			var $tdiv = $('#rpTemplate').clone().appendTo('#rpDiv');		
					var $tdiv = $('#rpTemplate').clone().appendTo('#rpDiv');

					for ( var p in rep) {
						$tdiv.find('[data-id="' + p + '"]').html(rep[p]);
					}
					// 			error발생시 rpId를 rpNo으로 수정 후 해보기
					$tdiv.find('button.delBtn').attr('data-no', rep.rpNo);
					$tdiv.find('button.upBtn').attr('data-no', rep.rpNo);
				}
			}).fail(function(jqXHR, textStatus) {
				alert("refreshReplyList Request failed: " + textStatus);
			});

		}

		//function기능 생성 종료
		$(function() { //문서 끝까지 모두 읽은 후 이 함수를 실행
			refreshReplyList();

			// ------------저장 버튼  실행---------------	
			$('#saveBtn').on('click', function() { // 저장버튼 클릭시 실행 함수
				$.ajax({
					url : "../add",
					method : "POST",
					data : $('#rpform').serialize(), // 폼 또는 입력 엘리먼트들에 대해서 serialize()명령을 사용하면 선택된 폼 내부의 모든 엘리먼트들을 파라미터 문자열 형태로 변환	
					dataType : "json"
				}).done(function(data) {
					console.log(data);
					if (data.result > 0) {
						alert("성공");
						$('[name="rpContent"]').val('');
						refreshReplyList() //성공처리한 후 새로고침
					} else {
						alert("실패");
					}
				}).fail(function(jqXHR, testStatus) {
					alert("Request failed: " + testStatus);
				});
			});

			// --------------------삭제 버튼 실행----------------
			$('#rpDiv').on('click', '.delBtn', function() {
				$.ajax({
					url : "../delete",
					data : {
						rpNo : $(this).attr('data-no')
					},
					datatype : "json"
				}).done(function(data) {
					console.log(data);
					if (data.result > 0) {
						alert('댓글 삭제 성공')
						refreshReplyList()
					} else {
						alert('댓글 삭제 실패')
					}
				}).fail(function(jqXHR, textStatus) {
					alert("Request Failed :" + textStatus);
				});
			});

			// --------------------수정 버튼 실행----------------
			$('#rpDiv').on('click', '.upBtn', function() {
				$.ajax({
					url : "../update",
					data : {
						rpNo : $(this).attr('data-no')
					},
					datatype : "json"
				}).done(function(data) {
					console.log(data);
					if (data.result.rpNo > 0) {
						alert('리드 성공')
						refreshReplyList()
					} else {
						alert('리드 실패')
					}
				}).fail(function(jqXHR, textStatus) {
					alert("Request Failed :" + textStatus);
				});
			});
		})
		
		
	</script>


</body>
</html>