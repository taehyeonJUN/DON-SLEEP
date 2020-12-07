<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../resources/css/login.css">
    <title>로그인</title>
</head>
<body>
    <div id="main-container">
        <h1 class="logo" style="font-family: 'Lobster', cursive; font-size: 60px;">Tongrami</h1>
        <div>
        <form action="login" method="POST">
            <div class="int-area">
                <input type="text" name="memId" id="id" autocomplete="off" required>
                <label for="id">USER NAME</label>
            </div>
            <div class="int-area">
                <input type="password" name="memPass" id="pw" autocomplete="off" required>
                <label for="pw">PASSWORD</label>
            </div>
            <div class="btn-area">
                <button type="submit">LOGIN</button>
            </div>
        </form>
        </div>
		</br>
		<form action="register" method="GET">
            <span class="btn-area">
                <button type="submit">CREATE ID</button>
            </span>
           </form>	
		
<!--         <div class="caption"> -->
<!--             <button onclick="">Forgot Password?</button> -->
<!--         </div> -->
		<br>
        <div class="caption">
            <a href="">Forgot Password?</a>
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