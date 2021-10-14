<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./css/RIDI.css">
</head>
<body id=loginBack>
    <header id="loginHeader">
        <div class="loginInner">
                <h1 class="loginLogo"><a href="#">RIDI</a></h1>
        </div>
    </header>
    <div class="loginFormInner">
        <form>
            <div class="loginInput">
                <input type="text" name="id" class="loginId" placeholder="아이디">
                <input type="password" name="password" class="loginPassword" placeholder="비밀번호">
                <input type="submit" value="로그인" class="loginBtn">
                <a href="#" type="button" class="joinBtn">회원가입</a>
            </div>
        </form>
    </div>
</body>
</html>