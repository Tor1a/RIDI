<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="contents">
	<h2 class="contentsTitle">목록</h2>
	<div class="form">
		<table>
			
			<thead>
				<tr>
					<th>No</th>
					<th>작성자</th>
					<th class="left">제목</th>
					<th>작성일자</th>
					<th>상태</th>
				</tr>
			</thead>
			<tbody class="qnaList_contents">
				<c:forEach var="QnaDto" items="${qnaList }" begin="0" end="${qnaList.size()}" step="1" varStatus="status" >
					 <tr class="contentsContainer">
						<td>${total - (currentPage-1)*listPerCount - status.index }</td>
						<td>${qnaDto.writerId}</td>
						<td class="left space${qnaDto.reStep }">
							<c:if test="${qnaDto.reStep > 1 }">
								<span class="material-icons"></span>
							</c:if>
							<a href="QnaView.do?no=${qnaDto.no }&clickedPage=${currentPage}&num=${qnaDto.num}">${qnaDto.subject }</a>
						</td>
						<td>
							<fmt:formatDate pattern="yy-MM-dd hh:mm:ss" value="${qnaDto.regDate }" />
							<p>${qnaDto.regDate}</p>
						</td>
						<td>${qnaDto.readCount }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="paginationBox">
			<ul>
				<c:if test="${startPage!=1 }">
					<li>
						<a href="QnaSearchList.do?clickedPage=${startPage - pageGroupCount }&searchSelect=${param.searchSelect }&searchWord=${param.searchWord }">
							<span class="material-icons">chevron_left</span>
						</a>
					</li>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1" varStatus="status">
					<li class="${currentPage == i ? 'active':'' }">
						<a href="QnaSearchList.do?clickedPage=${i }&searchSelect=${param.searchSelect }&searchWord=${param.searchWord }">
							${i }
						</a>
					</li>
				</c:forEach>
				<c:if test="${endPage != lastPage}">
					<li>
						<a href="QnaSearchList.do?clickedPage=${startPage + pageGroupCount }&searchSelect=${param.searchSelect }&searchWord=${param.searchWord }">
							<span class="material-icons">chevron_right</span>
						</a>
					</li>
				</c:if>
			</ul>
		</div>
		<form class="searchForm" method="GET" action="QnaSearchList.do">
			<select name="searchSelect" class="searchSelect">
				<option value="name"     ${param.searchSelect=="name"?"selected":"" }  >작성자</option>
				<option value="contents" ${param.searchSelect=="contents"?"selected":"" }>내용</option>
				<option value="subject"  ${param.searchSelect=="subject"?"selected":""}>제목</option>
			</select>
			<input type="text" name="searchWord" value="${param.searchWord }" placeholder="검색어를 입력하세요.">
			<input type="submit" class="btn"  value="검색">
		</form>
		<div class="btns center">
			<a href="QnaWriteForm.do">글쓰기</a>
		</div>
		
	</div>
</div>
<%@ include file="../include/footer.jsp"%>










