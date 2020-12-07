<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../../resources/css/myInfo.css">
<title>내 정보 보기</title>

 <script>
        function onlyAlphabet(ele) {
     ele.value = ele.value.replace(/[^\\!-z]/gi,"");
    };
    </script>

</head>
<body>
	  <jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
  
    <div class="mid-contaniner">
        <div class="mid-wrap">
            <div class="mid-head">
                <form action="select" method="post">
                   
                    <span class="table-head"><h3>My Information</h3></span>
                    <table class="myinfo-table">
                        <tr>
                            <th scope="row">가입일자</th>
                            <td><fmt:formatDate value="${memList.memDate}"
					pattern="YYYY/MM/dd HH:mm:ss" /></td> 
                        </tr>
                       
                        <tr>
                            <th scope="row">이름 </th>
                            <td><input type="text" name="memName" value="${memList.memName}"></td>
                        </tr>
                        
                        <tr>
                            <th scope="row">아이디</th>
                            <td><span><input type="text" name="memId"  minlength="5" maxlength=30 onkeydown="onlyAlphabet(this)" value="${memList.memId}" placeholder="             영문 + 숫자"></span>
                                <span><small>* 최소 6 ~ 16자까지 가능합니다.</small></span>
                            </td>
                        </tr>
                       
                        <tr>
                            <th scope="row">비밀번호</th>
                            <td><span><input type="password" name="memPass" minlength="5" maxlength=20 placeholder="" value="${memList.memPass}"></span>
                                <span><small>* 특수기호 포함 20자까지 가능합니다.</small></span>
                            </td>
                        </tr>
                       
                        <tr>
                            <th scope="row">전화번호</th>
                            <td><span><input type="tel" name="memTel" value="${memList.memTel}"></span>
                                <span><small>* 010-0000-0000</small></span> 
                            </td>
                        </tr>
                       
                        <tr>
                            <th scope="row">소개글</th>
                            <td><input type="text" minlength="3" maxlength=50 class="last-input"  name="memIntro"
					value="${memList.memIntro}" placeholder="소개글을 입력해주세요."></td>
                        </tr>
                    
                    </table>
                    <div class="table-bottom">
                        <button>수정하기</button> 
                        <button type="button"><a href="${memList.memId}/delete">회원탈퇴</a></button>
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