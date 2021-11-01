<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="qnaList_body">
<div id="qnaList_container" class="qnaList_wrap">
	<div class="qnaList_form">
		 <table class="qnaList">
		<h1 class="qnaList_title">Q&A 게시판<span class="title_line"></span></h1>
			<thead>
				  <tr class="qnaList_subject">
					<th>No</th>
					<th>작성자</th>
					<th>제목</th>
					<th>작성일자</th>
					<th>조회수</th>
				</tr>
			</thead>
			
			<!-- 리스트 -->
			<tbody>
				<c:forEach var="qnaDto" items="${qnaList }" varStatus = "status">
					 <tr class="contentsContainer">
						<td>${total - (currentPage-1)*listPerCount - status.index }</td>
						<td>${qnaDto.writerId}</td>
						<td>
							<a href="QnaView.do?no=${qnaDto.no }&clickedPage=${currentPage}&num=${qnaDto.num}">${qnaDto.subject }</a>
						</td>
						<td>
							<fmt:formatDate pattern="yy-MM-dd" value="${qnaDto.regDate }" />
						</td>
						<td>${qnaDto.readCount }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<!-- 페이지 넘기기 기능 -->
		<div class="qnaList_page">
			<ul class="pageContainer">
				<c:if test="${startPage!=1 }">
					<li>
						<a href="QnaList.do?clickedPage=${startPage - pageGroupCount }">
							<span class="far fa-caret-square-left"></span>
						</a>
					</li>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1" varStatus="status">
					<li class="${currentPage == i ? 'active':'' }">
					<a href="QnaList.do?clickedPage=${i }">${i }</a></li>
				</c:forEach>
				<c:if test="${endPage != lastPage}">
					<li><a href="QnaList.do?clickedPage=${startPage + pageGroupCount }">
					<span><i class="fas fa-chevron-square-right"></i></span></a></li>
				</c:if>
			</ul>
		</div>
		
		<!-- 검색기능 -->
		<div>
		<form class="searchForm" name="searchForm" method="GET" action="QnaSearchList.do">
			<select class="searchField" name="searchField" class="searchSelect">
				<option value="writerId" ${param.searchSelect=="writerId"?"selected":"" }  >작성자</option>
				<option value="contents" ${param.searchSelect=="contents"?"selected":"" }>내용</option>
				<option value="subject"  ${param.searchSelect=="subject"?"selected":""}>제목</option>
			</select>
			<input class="searchWord" type="text" name="searchWord" value="${param.searchWord }" placeholder="검색어를 입력하세요.">
			<input class="searchBtn" type="submit" id="searchBtn" class="btn"  value="검색">
		</form>
		
		<!-- 글 작성 -->
		<div class="qnaList_btn">
			   <a href="QnaWriteForm.do"><span class="qnaList_write">글쓰기</span></a>
		</div>
	</div>
	</div>

      </div>
 </div>   
<%@ include file="../include/footer.jsp"%>


