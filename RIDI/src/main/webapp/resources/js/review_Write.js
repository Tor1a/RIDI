$.ajax({
	url:"ReviewList.do",
	type:"POST",
	success:function(result){
		const reviewList = result.reviewList;
		$.each(reviewList,function(i,item){
			$(".reviewList").append(`<tr class="reviewInfo reviewInfo${item.no}" data-no=${item.no}></tr>`);
			$(`.reviewInfo${item.no}`).append(`<td>${item.no}</td>
																					<td>${item.book_No}</td>
																					<td>${item.contents}</td>
																					<td>${item.writer_Id}</td>
																					<td id="starScore${item.no}" style="color:#FF5356"></td>
																					<td>${item.password}</td>
																					<td>${item.review_Date}</td>
																					<td><button class="reviewDeleteBtn">댓글삭제</button></td>`);
			for(var i=1; i<=5; i++){
				if(i <= `${item.star_Rating}`){
					$(`#starScore${item.no}`).append(`<i class="fas fa-star">`);
				} else{
					$(`#starScore${item.no}`).append(`<i class="far fa-star">`);
				}
			}

			
		})
	}
})

$(".reviewList").on("click",".reviewDeleteBtn",function(){
	const reviewRow = $(this).parent().parent();
	const reviewNo = reviewRow.data("no");
	const sendData = {
		no:reviewNo
	}
	$.ajax({
		url:"ReviewDelete.do",
		data:sendData,
		type:"POST",
		success:function(){
			reviewRow.remove();
		}
	})
})

$("#star").on("click","a",function(){
	$("#star").html("");
	var star_num = $(this).attr("value");
	for(var i=1; i<=5; i++){
		if(i <= star_num){
			$("#star").append(`<a href="#" value="${i}" style="font-size:20px; color:#FF5356"><i class="fas fa-star"></a>`)
		}else{
			$("#star").append(`<a href="#" value="${i}" style="font-size:20px; color:#FF5356"><i class="far fa-star"></a>`)
		}
	}
	$("#star_Rating").val(star_num);
})