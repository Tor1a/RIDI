let sendNo;
let clickedItem;
let plusNum;
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
			//console.log(resultData.bookList);
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
			//console.log(resultData.newBookList);
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


/* 재태크페이지 메인 베스트 슬라이더 출력(미완) */
$(document).ready(function(){
	$.ajax({
		type : 'GET',
		url:"MoneyBestBookJsonList.do",
		dataType : 'json',
		success:function(resultData){
			//console.log(resultData.moneyBestBookList);
			const moneyBestBookList = resultData.moneyBestBookList;
			$(".best_slider").append(`<ul class="list"></ul>`);
			$.each(moneyBestBookList, function(i, item){
				$(".best_slider .list").append(`	<li>	
														<a href="BookInfo.do?no=${item.no}">
															<img src="${item.book_Image}">
														</a>
													</li>
											`);
			});
			$(".best_slider").removeClass("slick-initialized slick-slider");
			
			$(".best_slider .list").slick({
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
/* 재태크페이지 지금시간페이지 출력(미완) */

/* 현재 시간 출력 */
let now = new Date();
const hour = now.getHours();
const minutes = now.getMinutes();
let time = hour + "시 " + minutes + "분";
console.log(time);

$.ajax({
		type : 'GET',
		url:"MoneyTimeBookJsonList.do",
		dataType : 'json',
		success:function(resultData){
			console.log(resultData.moneyTimeBookList);
			const moneyTimeBookList = resultData.moneyTimeBookList;
			$(".time").append(time);
			$.each(moneyTimeBookList, function(i, item){
				$(".gridMoney").append(`	<li class="img_Box${i+1}">
				                         <a href="BookInfo.do?no=${item.no}">
				                             <div>
				                                 <img src="${item.book_Image}">
				                             </div>
				                         </a>
				                         <div>
				                             <h4>${i+1}</h4>
				                             <div>
				                                 <a href="BookInfo.do?no=${item.no}">${item.book_Name}</a>
				                                 <span>${item.author}</span>
				                             </div>
				                         </div>
				                     </li>`
									);
			});
			
		}
	});

/* 재태크페이지 리디 추천 슬라이더 출력(미완) */

$(document).ready(function(){
	$.ajax({
		type : 'GET',
		url:"MoneyRecomBookJsonList.do",
		dataType : 'json',
		success:function(resultData){
			console.log(resultData.moneyRecomBookList);
			const moneyRecomBookList = resultData.moneyRecomBookList;
			$.each(moneyRecomBookList, function(i, item){
				$(".recomBook_Slide").append(`
													<div class="recomBookList">
														<a href="BookInfo.do?no=${item.no}">
															<img src="${item.book_Image}">
															<div class="recom_Book_Line">
																<span>${item.book_Name}</span>
																<span>${item.author}</span>
															</div>
														</a>
													</div>
											`);
			});
			 $(".recomBook_Slide").removeClass("slick-initialized slick-slider");
			
	         $(".recomBook_Slide").slick({
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


//오성식 추가
//베스트 셀러를 출력한다.
$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"BestSellerJsonList.do",
		dataType:"json",
		success:function(result){
			const bestSellerList = result.bestSellerList;
			$.each(bestSellerList,function(i,item){
				$(".grid").append(`<li class="img_Box${i+1}">
                         <a href="BookInfo.do?no=${item.no}">
                             <div>
                                 <img src="${item.book_Image}" alt="">
                             </div>
                         </a>
                         <div>
                             <h4>${i+1}</h4>
                             <div>
                                 <a href="BookInfo.do?no=${item.no}">${item.book_Name}</a>
                                 <span>${item.author}</span>
                                 <span></span>
                             </div>
                         </div>
                     </li>`);
				for(var x=1; x<=5; x++){
					if(x<=`${item.star_Rating}`){
						$(`.grid .img_Box${i+1} > div > div span:nth-child(3)`).append("★");
						$(`.grid .img_Box${i+1} > div > div span:nth-child(3)`).attr("style","font-size:20px; color:gold;");
					} else {
						$(`.grid .img_Box${i+1} > div > div span:nth-child(3)`).append("☆");
						$(`.grid .img_Box${i+1} > div > div span:nth-child(3)`).attr("style","font-size:20px; color:gold;");
					}
				}		
			});
		},
		error:function(){
			alert("실패함");
		}
	})
})










