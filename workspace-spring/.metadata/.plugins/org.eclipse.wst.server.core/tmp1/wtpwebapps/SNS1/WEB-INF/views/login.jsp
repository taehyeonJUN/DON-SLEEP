<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link rel="stylesheet" href="../css/index_ver2.css">

    <style>
        @import url('https://fonts.googleapis.com/css2?family=Lobster&display=swap');
        body {
            background : #f8f8f8;
        }
        #main-container {
            background : #ffffff;
            border: 1px solid #dddddd;
            width: 500px;
            height: 580px;
            text-align: center;
            margin: 0 auto;
            margin-top: 150px;
            padding-top: 50px;
        }

        .int-area {
            top: 80px;
            left: 50px;
            width: 375px; 
            position: relative;
            margin-top: 20px;
            color: goldenrod;
            
            /* text-shadow: 2px 2px rgb(134, 11, 11);; */
        } /*텍스트창에 id/pw 글귀 넣기*/
        .int-area input {
            
            width: 100%;
            padding: 20px 10px 10px;    /*텍스트창 크기*/
            background-color: transparent;  /*input창 배경과 합치기*/
            border: none;
            border-bottom: 1px solid #999999;
            font-size: 19px; 
            color: #999999;
            outline: none; /*텍스트창 선택했을 때 테두리 안 나오게*/
        }
        .int-area label {
            position: absolute; 
            left: 10px;
            top: 15px; /*텍스트창에 id/pw 글귀 위치 설정*/
            font-size: 14px; 
            color: #999999;
            transition: all 0.5s ease;
        }
        .int-area input:focus + label, 
        .int-area input:valid + label { /*텍스트창에 id/pw 글귀 클릭시 움직임*/
            top: -2px;
            font-size: 12px; 
            color: #166cea;    /*텍스트창 클릭하면 색깔바뀌면서 작아짐*/
        }

        .btn-area {
            margin-top: 155px;
        } /*로그인버튼 꾸미기*/

        .btn-area button {
            width: 50%; 
            height: 30px;
            background-color: rgb(223, 179, 86);
            color: #999999;
            /* border: none; */
            border-radius: 25px;
            cursor: pointer; /*마우스올리면손가락표시*/
        }

        .btn-area input {
            width: 50%; 
            height: 30px;
            background-color: rgb(223, 179, 86);
            color: #999999;
            /* border: none; */
            border-radius: 25px;
            cursor: pointer; /*마우스올리면손가락표시*/
        }

        .caption { /*캡션 꾸미기*/
            margin-top: 60px;
            text-align: center;
        }
        .caption a {
            font-size: 15px;
            color: #999999;
            /* text-decoration: none; 캡션 밑에 밑줄 */
        }
    </style>
</head>
<body>
    <div id="main-container">
        <h1 class="logo" style="font-family: 'Lobster', cursive; font-size: 60px;">tongrami</h1>
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
                <input type="submit" value="LOGIN">
                <button type="submit">JOIN</button>
            </div>
        </form>
        </div>

        <div class="caption">
            <a href="">Forgot Password?</a>
        </div>
    </div>
</body>
</html>