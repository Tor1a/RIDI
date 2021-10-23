let sendNo;
let clickedItem;
//$(document).ready(function(){ $(".slick-sample").slick({ }); }); 
/*var $opts = 
           { 
                slidesToShow: 1,
                slidesToScroll: 1,
                infinite : true,
                autoplay: true,
                autoplaySpeed: 1000,
                arrows: true,
                prevArrow: $('#aro1_prev'),
                nextArrow: $('#aro1_next')
        	};*/

/* 메인 슬라이더 */
$(document).ready(function(){
	$.ajax({
		type : 'GET',
		url:"BookJsonSliderList.do",
		dataType : 'json',
		success:function(resultData){
			console.log(resultData.bookList);
			const bookList = resultData.bookList;
			$(".main_slider").append(`<ul class="list"></ul>`);
			$.each(bookList, function(i, item){
				$(".main_slider .list").append(`	<li>	
														<a href="BookInfo.do?no=${item.no}">
															<img src="${item.book_Image}">
														</a>
													</li>
											`);
			});
			$(".main_slider").removeClass("slick-initialized slick-slider");
			
			$(".main_slider .list").slick({
	            slidesToShow: 1,
                slidesToScroll: 1,
                infinite : true,
                autoplay: true,
                autoplaySpeed: 1000,
                arrows: false,
                dots: true
	         });
		}
	});
 }); 


/* 신작 */

$(document).ready(function(){
	$.ajax({
		type : 'GET',
		url:"NewBookJsonList.do",
		dataType : 'json',
		success:function(resultData){
			console.log(resultData.newBookList);
			const newBookList = resultData.newBookList;
			//$(".newBook_Slide").append(`<div class="newBookList"></div>`);
			$.each(newBookList, function(i, item){
				$(".newBook_Slide").append(`
													<div class="newBookList">
														<a href="BookInfo.do?no=${item.no}">
															<img src="${item.book_Image}">
															<div class="new_Book_Line">
																<span>${item.book_Name}</span>
																<span>${item.author}</span>
															</div>
														</a>
													</div>
											`);
			});
			 $(".newBook_Slide").removeClass("slick-initialized slick-slider");
			
	         $(".newBook_Slide").slick({
	            dots: false,
                infinite: true,
                speed: 300,
                slidesToShow: 6,
                slidesToScroll: 6,
                arrows: true
	         });	
		}
	});	
	
}); 














/*$.ajax({
	url:"BookJsonList.do",
	success:function(resultData){
		console.log(resultData.bookList);
		const bookList = resultData.bookList;
		$("#bookList").append(`<ul class="list"></ul>`);
		$.each(bookList, function(i, item){
			const categories = item.category.replaceAll(",", " "); // 배열로 들어올때 콤마(,)를 공백으로 처리
			$("#bookList ul").append(`
										<li class="item ${categories}" data-no=${item.no}>
											<div class="imgBox">
												<a href="BookInfo.do?no=${item.no}">
													<img src="${item.book_Image}">
												</a>
											</div>
											<div class="info">
												<h2>${item.book_Name}</h2>
												<p>${item.price}</p>
												<p>${item.stock}</p>
												<p>${item.star_Rating}</p>
												<p>${item.estimated_Time}</p>
												<p>${item.shipping_Price}</p>
												<p>${item.publication_Date}</p>
												<p>${item.pages}</p>
												<p>${item.author}</p>
												<p>${item.book_Intro}</p>
											</div>
										</li>
										`);
		});
		/*$("#bookList").imagesLoaded( function() {
			const grid = $("#bookList .list").isotope({
			  itemSelector: '.item',
			  layoutMode: 'masonry'
			});
			$("#filterList li").on("click", function(){
				$(this).addClass("on").siblings().removeClass("on");
				const selectedClass = $(this).data("filter");
				grid.isotope({ filter: `.${selectedClass}` });
			});
			
		});
	}
});*/



/*<a href="BookInfo.do?no=${item.no}"></a>
<li class="item ${categories}" data-no=${item.no}>*/
