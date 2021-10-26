<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="headerCategoryLine">
	<nav class="headerCategoryInner">
		<ul class="headerCategory">
			<li><i class="fas fa-caret-right"></i></li>
			<li><a href="MoneyBookForm.do">재테크</a></li>
			<li><a href="ComicBookForm.do">만화</a></li>
			<li><a href="EssayBookForm.do">에세이</a></li>
		</ul>
	</nav>
</div>
<div id="sub_Content">
	<!--  SLIDER CLASS NAME 변경  -->
	<div class="best_slider"></div>
	<div class="main_Time">
		<div class="time"></div>
		<h3>
			사람들이 지금 많이 읽고 있는 책 <i class="fas fa-chevron-right"></i>
		</h3>
		<div class="main_Time_Inner">
			<ul class="gridMoney">

			</ul>
		</div>
	</div>
	<div class="main_Recom">
		<div class="main_Recom">
			<div class="main_Recom_Inner">
				<h4>오늘의 추천</h4>
				<div class="recomBook_Slide"></div>
			</div>
		</div>
	</div>
	<div class="main_movie">
		<div class="ad_inner">
			<iframe width="1200" height="393"
				src="https://www.youtube.com/embed/mSuoqRNpj_c"
				title="YouTube video player" frameborder="0"
				allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
				allowfullscreen></iframe>
		</div>
	</div>
</div>

<script defer>
$(".headerCategory li:nth-child(2) a").addClass("on");
</script>
<%@ include file="../include/footer.jsp"%>