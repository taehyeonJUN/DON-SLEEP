<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판추가</title>
<style type="text/css">
#templats {
	display: none;
}
</style>

</head>
<body>
	<jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>
	<h1>상세정보</h1>

	
		<form action="${pageContext.request.contextPath}/bbs/Edit.do"
			method="post">
			<input type="hidden" name="bbsNo" value="${bbsVo.bbsNo}" />
			<table border="1">
				<tbody>
					<%-- 		<tr><th>글번호</th><td><input type="text" name="bbsNo" value = "${bbsVo.bbsNo}" readonly="readonly" /></td> --%>
					<tr>
						<th>제목</th>
						<td><input type="text" name="bbsTitle"
							value="${bbsVo.bbsTitle}"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="bbsContent" rows="20" cols="30">${bbsVo.bbsContent}</textarea></td>
					</tr>

					<c:forEach var="avo" items="${bbsVo.attachList}" varStatus="stat">
						<!-- 		jstl의 forEach에서 varStatus속성을 사용하면 현재 for문의 실행상태에 대한 정보를 활용할 수 있다.
							이걸로 글번호 활용도 가능 -->
						<tr>
							<th>첨부파일 ${stat.count}</th>
							<td><a
								href="${pageContext.request.contextPath}/bbs/down.do?attNo=${avo.attNo}">${avo.attOrgName}</a></td>
						</tr>
					</c:forEach>

					<tr>
						<th>작성자</th>
						<td><c:out value='${bbsVo.bbsWriter}' /></td>
					</tr>
					<tr>
						<th>작성시간</th>
						<td><fmt:formatDate value="${bbsVo.bbsRegDate}"
								pattern="yyyy년 MM월dd일hh시mm분ss초" /></td>
					</tr>

				</tbody>
			</table>

			<input type="submit" value="글쓰기" />

		</form>
		<a
			href='${pageContext.request.contextPath}/bbs/Del.do?bbsNo=${bbsVo.bbsNo}'><button
				type='button'>삭제</button></a><br />
	




	<hr />



	<form action="" id="replyForm">

		<textarea name="repContent" rows="10" cols="30"></textarea>
		<input type="hidden" name="repBbsNo" value="${bbsVo.bbsNo}"> <input
			type="button" value="저장" id="saveBtn" />
	</form>
	<div id="replyDiv"></div>
<!-- 	로그인한 사용자가 작성한 댓글에는 삭제 버튼이 표시되도록 구현 -->
<!-- 	삭제 버튼을 클릭하면 해당 댓글이 삭제되도록 구현 -->
<!-- 	로그인한 사용자가 자신이 작성하지 않은 댓글에 대해서 삭제 요청을 보내면 삭제 금지 -->
	
	
	<div id="templates">

		<div id="replyTemplate">
			<div>
				<span data-id="repWriter"></span> <span data-id="repDate"></span>
			</div>
			<div data-id="repContent"><pre></pre></div>
			<hr />
	
	</div>


	<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
	<script type="text/javascript">
	function refreshReplyList() {
			$.ajax({
				url : "${pageContext.request.contextPath}/reply/list.do", //요청주소
				method : "GET",//요청방식
				
				data :{ repBbsNo : $('[name="repBbsNo"]').val()
				},
				dataType : "json" //응답으로 받을 데이터의 타입(text,xml,html,json...)
			}).done(function(data) { //요청에 대한 응답을 정상적으로 받을 경우 실행
				console.log(data);
				$('#replyDiv').html('');//$('#replyDiv').empty('');
				for (var  i=0 ;  i< data.length; i++) {
					var rep = data[i];// {repNo:1, repContent: '댓글내용'...}
					//작성자, 작성일자도 함께 출력
					$('#replyDiv').append('<div>');
					$('#replyDiv').append('<span>'+ rep.repWriter +'&nbsp; </span><span />');//.append로 모든 댓글 출력
		// 					$('#replyDiv').append('<span>'+ new Date(rep.repDate).toLocaleString()+'</span>');//.append로 모든 댓글 출력					$('#replyDiv').append('<span>'+rep.repDate+'</span>');//.append로 모든 댓글 출력					$('#replyDiv').append('</div>');					$('#replyDiv').append('<div><pre>'+rep.repContent+'</pre></div>');//.append로 모든 댓글 출력					$('#replyDiv').append('<hr />');
					
// 					var $d1= $('<div>')  //<div></div>
// 					$('<span>').html(rep.repWriter).appendTo($d1);//<span>rep.repWriter</span>
// 					$('<span>').html(rep.repDate).appendTo($d1);//<span>rep.repDate</span>
					
					
// 					var $d2 = $('div');
// 					$('<pre>').html(rep.repContent).appendTo($d2);
// 					var $h=$('<hr>');
// 					$('#replyDiv').append($d1).append($d2).append($h);
// 					$('#replyDiv').append([$d1,$d2,$h])
// 					$('#replyDiv').append($rdiv);
					
// <div id="Templates">

// <div id="replyTemplate"> 
//       <div><span data-id="repWriter"></span>
//       <span data-id="repDate"></span>
//       </div>
//       <div data-id="repContent"></div>
//       <hr />
//    </div>
// </div>
					
					
					var $rdiv=$('#replyTemplate').clone().appendTo('#replyDiv');
					for (var p in rep){
			
						$rdiv.find('[data-id="'+p+'"]').html(rep[p]);
					}
					
// 					$rdiv.find('[data-id="repWriter"]').html(rep.repWriter);

// 					$rdiv.find('[data-id="repDate"]').html(rep.repDate);
// 					$rdiv.find('[data-id="repContent"]').html(rep.repContent);
				}
			}).fail(function(jqXHR, textStatus) { 
			});
		
	}	
	
	
	
	$(function() {
		refreshReplyList();
			
			$('#saveBtn').on('click', function() { //click 이벤트 발생 시 실행할 함수
				$.ajax({
					url : "${pageContext.request.contextPath}/reply/add.do", //요청주소
					method : "POST",//요청방식
					//파라미터를 객체형태로 전달하면 제이쿼리가 파라미터 문자열로 만들어 전송
// 					data : {
// 						repContent : $('[name="repContent"]').val(), //요청전송시 함께 전송할 파라미터 지정
// 						repBbsNo : $('[name="repBbsNo"]').val()
					//요청전송시 함께 전송할 파라미터 지정
// 					},
				//폼 또는 입력엘리먼트들에 대해서 serialize명령을 사용하면, 선택된 폼 내부의 모든 엘리먼트들을 파라미터 문자열 형태로 변환ㄹ
					data : $('#replyForm').serialize(),
					dataType : "json" //응답으로 받을 데이터의 타입(text,xml,html,json...)
				}).done(function(data) { //요청에 대한 응답을 정상적으로 받을 경우 실행
					// 		console.log(msg);
					// 		var obj = JSON.parse(msg);
					console.log(data);
					if (data.result > 0) {
						alert("댓글 저장 성공")
						$('[name="repContent"]').val('');
						
						refreshReplyList();
						
						
						
					} else{
						alert("저장 실패");
					}
					// 			ajax요청이 dataType = json으로 지정하면, 제이쿼리가 응답으로 받은 json문자열을
					// 			자바스크립트로 변환하여 인자로 전달

					//"댓글 저장" 또는 "댓글 저장 실패" 라고 alert 창으로 출력
				}).fail(function(jqXHR, textStatus) { //요청 전송이나 응답 수신이 실패한 경우 실행
				// 				alert("Request failed: " + textStatus);
				});

			});
		});
	</script>

	<!-- $('xxx') : 현재 문서에서 태그 이름이 xxx인 엘리먼트 찾아오기<xxx></xxx> -->
	<!-- $('#xxx') : 현재 문서에서 id속성값이 xxx인 엘리먼트 찾아오기<??? id="xxx"?</???> -->
	<!-- $('.xxx') : 현재 문서에서 클래스에 xxx가 포함된 엘리먼트 찾아오기<??? class="xxx"></xxx> -->
	<!-- $('[xxx]') : 현재 문서에서 xxx속성이 존재하는 엘리먼트 찾아오기<??? xxx="???"></???> -->
	<!-- $('xxx yyy') : 현재 문서에서 xxx엘리먼트 아래(내부)로 존재하는 yyy엘리먼트 찾아오기 -->
	<!-- $('xxx > yyy') : 현재 문서에서 xxx엘리먼트 바로아래 직속자식으로 존재하는 yyy엘리먼트 찾아오기 -->
	<!-- $('xxx , yyy') : 현재 문서에서 xxx엘리먼트 와 yyy엘리먼트 모두 찾아오기 -->
	<!-- $('<xxx>') : 새 xxx엘리먼트 생성<xxx></xxx> -->
	<!-- $(function(){}) : 현재 문서를 끝까지 읽은 후(로드한 후), 해당 함수 실행 	 -->

	<!-- <xxx> -->
	<!-- 	<yyy></yyy> -->
	<!-- 	<div> -->
	<!-- 		<yyy></yyy> -->
	<!-- 	</div> -->
	<!-- </xxx> -->




</body>
</html>






<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%--    pageEncoding="UTF-8"%> --%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>게시판</title> -->
<!-- <style type="text/css"> -->
/*    #templates{ */
/*       display: none;  */
/*    } */
<!-- </style> -->
<!-- </head> -->
<!-- <body> -->
<%--    <jsp:include page="/WEB-INF/views/comm/menu.jsp"></jsp:include> --%>

<!--    <h1>☆★☆★글 상세정보☆★☆★</h1> -->
<!--    <br> -->
<%--    <form action="${pageContext.request.contextPath}/bbs/edit.do" --%>
<!--       method="post"> -->
<%--       <input type="hidden" name="bbsNo" value="${bbsVo.bbsNo}" /> --%>
<!--       <table border="1"> -->
<!--          <tbody> -->
<%--                   <tr><th>글번호</th><td><input type="text" name="bbsNo" value="${bbsVo.bbsNo}" readOnly="readOnly"/><br></td></tr> --%>
<!--             <tr> -->
<!--                <th>제목</th> -->
<!--                <td><input type="text" name="bbsTitle" -->
<%--                   value="${bbsVo.bbsTitle}" /><br></td> --%>
<!--             </tr> -->
<!--             <tr> -->
<!--                <th>내용</th> -->
<%--                <td><textarea name="bbsContent" rows="20" clos="30">${bbsVo.bbsContent}</textarea><br></td> --%>
<!--             </tr> -->
<!--             textarea는 바깥쪽에 value값을 적어줘야 엔터값이랑 내용이 쭉 나온다 -->

<!--             JSTL의 forEach에서 varStatus 속성을 사용하면, -->
<!--             현재 for문의 실행상태에 대한 정보들을 활용할 수 있다 -->
<%--             <c:forEach var="avo" items="${bbsVo.attachList}" varStatus="stat"> --%>
<!--                <tr> -->
<%--                   <th>첨부파일 ${stat.count}</th> --%>
<!--                   <td><a -->
<%--                      href="${pageContext.request.contextPath}/bbs/down.do?attNo=${avo.attNo}">${avo.attOrgName}</a><br></td> --%>
<!--                </tr> -->
<%--             </c:forEach> --%>


<!--             <tr> -->
<!--                <th>작성자</th> -->
<%--                <td><c:out value="${bbsVo.bbsWriter}"></c:out><br></td> --%>
<!--             </tr> -->
<!--             <tr> -->
<!--                <th>등록일</th> -->
<%--                <td><fmt:formatDate value="${bbsVo.bbsRegDate}" --%>
<%--                      pattern="yyyy년 MM월 dd일  HH시 mm분 ss초" /><br></td> --%>
<!--             </tr> -->

<!--          </tbody> -->
<!--       </table> -->
<!--       <input type="submit" value="저장" /> -->
<%--          <a href='${pageContext.request.contextPath}/bbs/del.do?bbsNo=${bbsVo.bbsNo}'><button type='button'>삭제</button></a> --%>
<!--       <a -->
<%--          href='${pageContext.request.contextPath}/bbs/del.do?bbsNo=${bbsVo.bbsNo}'><input --%>
<!--          type="button" value="삭제" /></a> -->
<!--    </form> -->

<!--    <hr /> -->
<!--    <h5>☆★☆★☆★☆★ 댓글 ☆★☆★☆★☆★</h5> -->
   
<!--    <form action="" id="replyform"> -->
<!--       <textarea name="repContent" rows="10" cols="30"></textarea> -->
<%--       <input type="hidden" name="repBbsNo" value="${bbsVo.bbsNo}"> <input --%>
<!--          type="button" value="저장" id="saveBtn"> -->
<!--    </form> -->
<!--    <hr/> -->
   
<!--    <div id="replyDiv"></div> -->
<!-- <!--    로그인한 사용자가 작성한 댓글에는 삭제버튼이 표시되도록 구현 --> -->
<!-- <!--    삭제버튼을 클리갛면 해당 댓글이 삭제되도록 구현 --> -->
<!-- <!--    로그인한 사용자가 자신이 작서앟지 않은 댓글에 대해서 삭제요청을 보내면 삭제금지 --> -->
<!--    <div id ="templates"> -->
<!--       <div id="replyTemplate"> -->
<!--          <div> -->
<!--             <span data-id="repWriter"></span> -->
<!--             <span data-id="repDate"></span> -->
<!--          </div> -->
<!--          <div><pre data-id="repContent"></pre></div> -->
<!--          <hr> -->
<!--       </div> -->
<!--    </div> -->


<!--    <div id="replyDiv"></div> -->
<%--    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script> --%>
<!--    <script type="text/javascript"> -->
//       function refreshReplyList(){
//          $.ajax({
//             url : "${pageContext.request.contextPath}/reply/list.do",
//             method : "GET",
//             data : {
//                   repBbsNo : $('[name="repBbsNo"]').val()
//                },
//             dataType : "json"
//          }).done(function(data) {
//             console.log(data);
//             $('#replyDiv').html(''); //$('#replyDiv').empty(); 댓글목록을 받아와서 화면에 출력하기전에 비우고 새로 넣음>그래야 중복되지않음
//             for (var i = 0; i < data.length; i++) {
//                var rep = data[i]; //repNo: 1, repContent: '댓글내용',...
//                //댓글 작성자, 작성일시 도 함께 출력
// //                $('#replyDiv').append('<div>'); //replyDiv에다가 div추가 >>> <div id="replyDiv">xxxxxx여기xxxxxx</div>
// //                $('#replyDiv').append('<span>'+ rep.repWriter + '</span>');
// //                $('#replyDiv').append('<span>'+ rep.repDate + '</span>');
// //                $('#replyDiv').append('</div>');
// //                $('#replyDiv').append('<div><pre>'+ rep.repContent + '</pre></div>');
// //                $('#replyDiv').append('<hr/>');
               
// //                var $d1 = $('<div>'); //<div></div> 생성
// //                $('<span>').html(rep.repWriter).appendTo($d1); //<span>rep.repWriter</span> 생성
// //                //<div><span>rep.repWriter</span></div>
// //                $('<span>').html(rep.repDate).appendTo($d1); //<span></span> 생성
// //                //<div><span>rep.repWriter</span><span>rep.repDate</span></div>
// //                var $d2 = $('<div>');
// //                $('<pre>').html(rep.repContent).appendTo($d2);
// //                //<div><pre>rep.repContent</pre></div>
// //                var $h = $('<hr>');
// // //                $('#replyDiv').append($d1).append($2).append($h); //각각 집어넣을 떄
// //                $('#replyDiv').append([$d1, $d2, $h]); //한꺼번에 집어넣을때
               
//                var $rdiv = $('#replyTemplate').clone().appendTo('#replyDiv');
//                for ( var p in rep) {
//                   $rdiv.find('[data-id="'+p+'"]').html(rep[p]);
                  
// //                   $rdiv.find('[data-id="repWriter"]').html(rep.repWriter);
// //                   $rdiv.find('[data-id="repDate"]').html(rep.repDate);
// //                   $rdiv.find('[data-id="repContent"]').html(rep.repContent);
// //    //                $('[data-id="repWriter"]', $rdiv).html(rep.repWriter) 위에것과 동일
// //    //                $('#replyDiv').append($rdiv);
//                }
               
//             }
//          }).fail(function(jqXHR, textStatus) {
//             alert("Request failed: " + textStatus);
//          });
         
//       }
   
//       $(function() { //문서 끝까지 모두 읽은 후 이 함수를 실행 
//          refreshReplyList();      
         
//          $('#saveBtn').on('click', function() { //'click'이벤트발생시 실행될 함수
//             $.ajax({
//                url : "${pageContext.request.contextPath}/reply/add.do", //요청주소
//                method : "POST",
//                //파라미터를 객체형태로 전달하면 jQuery가 파라미터문자열로 만들어서 전송
// //                data : {
// //                   repContent : $('[name="repContent"]').val(),
// //                   repBbsNo : $('[name="repBbsNo"]').val()
// //                },
//                //폼 또는 입력엘리먼트들에 대해서 serialize()명령을 사용하면
//                //선택된 폼 내부의 모든 엘리먼트들을 파라미터문자열 형태로 변환
//                data : $('#replyform').serialize(),
//                dataType : "json" //응답으로 받을 데이터의 타입(text,html,xml,json,...)
//             }).done(function(data) {
//                console.log(data);
//                if (data.result > 0) {
//                   alert("댓글 저장 성공");         
//                   $('[name="repContent"]').val('');
//                   refreshReplyList();      

                  
//                   //댓글목록을 받아와서 화면에 출력
//                } else {
//                   alert("댓글 저장 실패");
//                }
//             }).fail(function(jqXHR, textStatus) {
//                alert("Request failed: " + textStatus);
//             });
//          });
//       });
<!--    </script> -->
<!-- </body> -->
<!-- </html> -->







<!-- $('xxx') : 현재 문서에서 태그이름이 xxx인 엘리먼트 찾아오기 <xxx></xxx> -->
<!-- $('#xxx') : 현재 문서에서 id속성값이  xxx인 엘리먼트 찾아오기 <??? id="xxx"></???> -->
<!-- $('.xxx') : 현재 문서에서 class에  xxx가 포함된 엘리먼트 찾아오기 <??? class="xxx"></???> -->
<!-- $('[xxx="yyy"]') : 현재 문서에서 xxx속성값이 yyy인 엘리먼트 찾아오기  <??? xxx="yyy"></???> -->
<!-- $('[xxx]') : 현재 문서에서 xxx속성이 존재하는 엘리먼트 찾아오기  <??? xxx="???"></???> -->
<!-- $('xxx yyy') : 현재 문서에서 xxx엘리먼트 아래(내부)에 존재하는 yyy 엘리먼트 찾아오기  -->
<!-- $('xxx > yyy') : 현재 문서에서 xxx엘리먼트 바로아래에 직속자식으로 존재하는 yyy 엘리먼트 찾아오기 -->
<!-- $('xxx , yyy') : 현재 문서에서 xxx엘리먼트와 yyy 엘리먼트 모두 찾아오기 엘리먼트 찾아오기 -->
<!-- $('<xxx>') : 새 xxx 엘리먼트를 생성 <xxx></xxx> -->
<!-- $( function(){} ) : 현재 문서를 끝까지 일은 후(로드한 후), 해당 함수를 실행  -->


<!-- <xxx> -->
<!--    <yyy></yyy> -->

<!--    <div> -->
<!--       <yyy></yyy> -->
<!--    </div> -->

<!-- </xxx> -->
<!-- <yyy></yyy> -->








