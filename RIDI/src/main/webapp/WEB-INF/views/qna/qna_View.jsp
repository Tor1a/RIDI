<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="contents">
	<h2 class="contentsTitle">VIEW</h2>
	<div class="form">
		<table class="tdLeft">
			<tbody>
				<tr>
					<th>writerId</th>
					<td>${qnaDto.writerId }</td>
					<th>hit</th>
					<td>${qnaDto.readCount }</td>
				</tr>
				<tr>
					<th>subject</th>
					<td colspan="3">${qnaDto.subject }</td>
				</tr>
				<tr>
					<th>contents</th>
					<td class="txtContents" colspan="3">${qnaDto.contents }</td>
				</tr>
			</tbody>
		</table>
		
		<div class="prevAndNext">
			<div class="item">
				<span class="inner">PREV <span class="material-icons">expand_less</span></span>
				<a href="QnaView02.do?no=${prevQnaDto.no}&num=${prevQnaDto.num}">${prevQnaDto.subject }</a>
			</div>
			<div class="item"><span class="inner">NEXT <span class="material-icons">expand_more</span></span>
				<a href="QnaView02.do?no=${nextQnaDto.no}&num=${nextQnaDto.num}">${nextQnaDto.subject }</a>
			</div>
		</div>
		<div class="btns center">
			<a href="QnaReplyForm02.do?no=${qnaDto.no }&reGroup=${qnaDto.reGroup}&reStep=${qnaDto.reStep}&reLevel=${qnaDto.reLevel}">답글달기</a>
			<a href="">삭제</a>
			<a href="">수정</a>
			<a href="QnaList02.do?clickedPage=1">목록</a>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>



