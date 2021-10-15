<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	<div id="infoContent">
        <div class="infoInner">
            <div class="infoSub">
                <div class="infoTableLine">
                    <h2 class="infoTable">마이리디</h2>
                </div>
                <ul class="infoList">
                    <li><a href="#">마이리디홈</a></li>
                    <li><a href="#">문의하기</a></li>
                    <li><a href="#">정보변경</a></li>
                </ul>
            </div>
            <div id="modify_check">
                <form action="" method="post">
                    <h4>정보 변경</h4>
                    <p>보안을 위해 비밀번호를 한번 더 입력해 주세요.</p>
                    <input type="passwrod" name="password" id="userPw" class="modifyChInput">
                    <input type="submit"  value="확인" class="modifyChBtn">
                </form>
            </div>
        </div>
    </div>
<%@ include file="../include/footer.jsp"%>