<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="qnaList_body">
<div id="qnaList_container" class="qnaList_wrap">
	<form method="POST" action="QnaList.do" class="qnaList_form">
		 <table class="qnaList">
		<h1 class="qnaList_title">Q&A 게시판<span class="title_line"></span></h1>
			<thead>
				  <tr class="qnaList_subject">
					<th>No</th>
					<th>작성자</th>
					<th>제목</th>
					<th>작성일자</th>
					<th>상태</th>
				</tr>
			</thead>
			<!-- 리스트 -->
			<tbody class="qnaList_contents">
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
						</a>
					</li>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1" varStatus="status">
					<li class="${currentPage == i ? 'active':'' }">
						<a href="QnaList.do?clickedPage=${i }">
							<span class="far fa-caret-square-left"></span>
							${i }
						</a>
					</li>
				</c:forEach>
				<c:if test="${endPage != lastPage}">
					<li><a href="QnaList.do?clickedPage=${startPage + pageGroupCount }">
					<span class="far fa-caret-square-right"></span>
				</c:if>
			</ul>
		</div>
		<!-- 검색기능 -->
		<form class="searchForm" method="GET" action="QnaSearchList.do">
			<select name="searchSelect" class="searchSelect">
				<option value="name"     ${param.searchSelect=="name"?"selected":"" }  >작성자</option>
				<option value="contents" ${param.searchSelect=="contents"?"selected":"" }>내용</option>
				<option value="subject"  ${param.searchSelect=="subject"?"selected":""}>제목</option>
			</select>
			<input type="text" name="searchWord" value="${param.searchWord }" placeholder="검색어를 입력하세요.">
			<input type="submit" class="btn"  value="검색">
		</form>
		<div class="qnaList_btn">
			   <a href="QnaWriteForm.do"><span class="qnaList_write">글쓰기</span></a>
		</div>
		
	</div>

      </form>
 </div>   
<%@ include file="../include/footer.jsp"%>


