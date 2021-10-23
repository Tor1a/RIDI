<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="qnaView_body">	
	<div id="qna_View" class="qna_View">
	        <div class="qnaView_form">
	            <div class="qnaView_container">
	                <ul class="qnaView_inner">
	                    <li>
	                    	<div><sapn>제목</sapn></div>
	                        <div>${qnaDto.subject}</div>
	                    </li>
	                    <li>
	                        <div><span>조회수</span></div>
	                        <div>${qnaDto.readCount}</div>
	                    </li>
	                    <li>
	                        <div><span>작성일자</span></div>
	                        <div>${qnaDto.regDate}</div>
	                    </li>
	                    <li>
	                        <div><span>작성자</span></div>
	                        <div>${qnaDto.writerId}</div>
	                    </li>
	                    <li>
	                        <div class="txtContents"><span>내용</span></div>
	                        <div>${qnaDto.contents}</div>
	                    </li>
	                </ul>
	            </div>
	            <div class="prevAndNext">
	                <div class="item">
	                    <span class="inner">PREV&nbsp;<span class="fas fa-angle-up"></span></span>
	                     <a href="QnaView.do?no=${prevQnaDto.no}&clickedPage=1&num=${prevQnaDto.num}">${prevQnaDto.subject }</a>
	                </div>
	                <div class="item"><span class="inner">NEXT <span class="fas fa-angle-down"></span></span>
	                   <a href="QnaView.do?no=${nextQnaDto.no}&clickedPage=1&num=${nextQnaDto.num}">${nextQnaDto.subject }</a>
	                </div>
	            </div>
	            <div class="qnaView_btn">
	                <a href="QnaReplyForm02.do?no=${qnaDto.no }&reGroup=${qnaDto.reGroup}&reStep=${qnaDto.reStep}&reLevel=${qnaDto.reLevel}">답글달기</a>
	                <a href="QnaList.do?clickedPage=1">목록</a>
	               <a href="#" id="qnaDeleteBtn" onclick="return qnaPassword(${qnaDto.no})">삭제</a>
	            </div>
	        </div>
    </div>
</div>    
<script src="./js/qna/qna_View.js"></script>
<%@ include file="../include/footer.jsp"%>



