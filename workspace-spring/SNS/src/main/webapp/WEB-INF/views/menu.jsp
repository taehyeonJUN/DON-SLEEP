<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
    <!-- ëê¸ css & ëê¸ ë¶í¸ì¤í¸ë©-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Main css -->
     <link rel="stylesheet" href="../../resources/css/main_dark_2.css">
     <link rel="stylesheet" href="../../resources/css/main_reple_2.css">
     <link rel="stylesheet" href="../../resources/css/main_default.css">
    <!-- logo í°í¸ -->
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <!-- ëëê³ ë í°í¸ -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap" rel="stylesheet">
    <!-- í ê¸, ì¤ë¥´ë¥µ jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
    <title>:::::: Tongrami ::::::</title>
</head>
<body>

    <div class="header-contanier">
        <div class="header-wrap">
            <header class="head">
                <div class="logo"><a href="#"><img src="../../resources/images/Tongrami LOGO.png" alt="íµê·¸ë¼ë¯¸ë¡ê³ "> Tongrami</a></div>
                           <!-- ê²ìê¸°ë¥ ìì -->
<div class="form-group">
      <form action="newList" method="post">
         <input type="text" name="postId"  placeholder="아이디를 검색하세요">
<!--          <input type="submit" value="ê²ì" class="glyphicon glyphicon-search"> -->
         <button type="button" value="ê²ì" class="glyphicon glyphicon-search"></button>
      </form>
   </div>
<!-- ê²ìê¸°ë¥ ë -->
                <!-- <input type="text" value="ddfdf"> -->
                <!-- íë²ê±° ìì -->
                <div class="menuicon-contaniner">
                    <input type="checkbox" id="menuicon">
                    <label for="menuicon">
                        <span></span>
                        <span></span>
                        <span></span>
                    </label>
                    <div class="sidebar">
                        <div class="menu-1">
                            <ul>
                                <a href="/post/list"><li>Home</li></a>
                                <a href="/member/select"><li>My info</li></a>
                                <a href="/post/add"><li>Post</li></a>
                                <a href="/"><li>Logout</li></a>
                                <c:if test="${sessionScope.user.memAuthor == 'ADMIN'}">
                                <a href="/member/list"><li>Users</li></a>
                                </c:if>
                            </ul>
                            <div class="checkbox-wrap">
                                <input type="checkbox" class="checkbox" id="checkbox">
                                <label for="checkbox" class="label">
                                    <div class="ball"></div>
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- íë²ê±° ë -->
            </header>
        </div>
 
    </div> 
    <!-- main ìë°ì¤í¬ë¦½í¸ -->  
    <script src="../../resources/js/main_toggle.js"></script>
    <script src="../../resources/js/main_reple.js"></script>
    <script src="../../resources/js/main_srr.js"></script>
    <script src="../../resources/js/main_dark.js"></script>
</body>
</html>