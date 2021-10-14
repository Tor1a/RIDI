<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/RIDI.css">
    <link rel="stylesheet" href="./css/layout.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
    <link rel="shortcut icon" href="./images/favicon.ico">
    <title>Document</title>
</head>
<body>
    <div id="wrap">
        <header id="header">
            <div class="headerInner">
                <div class="headerTop">
                    <div class="logoSearch">
                        <h1 class="logo"><a href="/RIDI">RIDI <span class="headerToneDown">RIDI</span></a></h1>
                        <form action="" method="POST">
                            <input type="text" name="searchBox" id="searchBox" placeholder="제목, 저자, 출판사검색">
                        </form>
                    </div>
                    <div id="logJoin">
                        <a href="MemberJoinForm.do" class="HDJoin">회원가입</a>
                        <a href="MemberLoginForm.do" class="HDLogin">로그인</a>
                    </div>
                </div>
                <nav>
                    <ul class="headerMenu">
                        <li><a href="/RIDI"><i class="fas fa-home"></i>홈</a></li>
                        <li><a href="#"><i class="fas fa-shopping-cart"></i>카트</a></li>
                        <li><a href="#"><i class="fas fa-box"></i>주문/배송조회</a></li>
                        <li><a href="#"><i class="far fa-user"></i>마이리디</a></li>
                        <li><a href="#"><i class="fab fa-quora"></i>QnA</a></li>
                    </ul>
                </nav>
            </div>
        </header>
        <nav class="headerCategoryInner">
            <ul class="headerCategory">
                <li><i class="fas fa-caret-right"></i></li>
                <li><a href="#">재태크</a></li>
                <li><a href="#">만화</a></li>
                <li><a href="#">에세이</a></li>
            </ul>
        </nav>
    </div>

