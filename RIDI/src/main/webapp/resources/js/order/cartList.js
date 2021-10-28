//처음 카트페이지 로딩시 카트 리스트 출력
getAllCartList();

// 사용자별 카트리스트를 출력한다.
function getAllCartList(){
	const sendData = {
		id : $("#loggedMemberId").text()
	}
	$.ajax({
		url:"GetShoppingCartList.do",
		data: sendData,
		type:"POST",
		success:function(result){
			const shoppingCartList = result.shoppingCartList;
			$.each(shoppingCartList,function(i,item){
				$(".cartList_left").append(`<ul class="cartList_btm">
                            <li>
                                <div><input id="cartCheckBox${i}" type="checkbox" onclick="calCheckedCartList()"></div>
                            </li>
                            <li>
                                <div><img src="${item.book_Image}"></div>
                            </li>
                            <li>
                                <div><span>${item.book_Name}</span></div>
                                <div><span>${item.seller}</span></div>
                                <div><button onclick="deleteCartItem(${item.no})">삭제</button></div>
                            </li>
                            <li>
                                <div class="bookPriceBox"><span class="bookPrice" id="bookPrice${i}">${item.price}원</span></div>
                            </li>
                        </ul>`);
			})
			calCheckedCartList();
		}
	});
};

//


// 체크된 책들의 가격의 합을 구한다.
function calCheckedCartList(){
	// let cartListLength = $(".bookPriceBox").length;
	// console.log(cartListLength);
	// let priceSum = 0;
	// let selectCartListNum = 0;
	// $.each($(".bookPriceBox"),function(i,item){
	// 	console.log(item);
	// })

	
	let cartListLength = $(".bookPrice").length;
	let priceSum = 0;
	let selectCartListNum = 0;
	for(var i = 0; i < cartListLength; i++){
		if($(`#cartCheckBox${i}`).prop("checked")){
			let price = Number($(`#bookPrice${i}`).text().slice(0,-1));
			priceSum = priceSum + price;
			selectCartListNum++;
		}
	};
	$(".cartList_btm").each(function() {
		console.log($(this));
	});
	$(".cartList_sum > div:nth-of-type(1) span").text(`${selectCartListNum}권을 선택하셨습니다.`);
	$(".cartList_sum > div:nth-of-type(3) span").text(`${priceSum}원`);
	$(".select_btm > div:nth-of-type(2) span").text(`${priceSum}원`);
	
	console.log($(".bookPrice"));
	$(".bookPrice").each(function(i,item){
		if($(this).find("input[type='checkbox']").prop("checked")){
			console.log($(this).find)
		}
	})
}



// 카트 리스트 전체 선택/해제 기능을 구현
$(".cartList_checkbox input").on("click",function(){
	if($(this).prop("checked")){
		$(this).prop("checked",true);
		$(".cartList_btm li:nth-child(1) input").prop("checked",true);
	} else{
		$(this).prop("checked",false);
		$(".cartList_btm li:nth-child(1) input").prop("checked",false);
	}
	calCheckedCartList();
})



function deleteCartItem(itemNo){
	const _parent = $(this).parent().parent();
	const sendData = {
		itemNo:itemNo
	}
	$.ajax({
		url:"DeleteShoppingCart.do",
		data:sendData,
		type:"POST",
		success:function(result){
			$(".cartList_btm").remove();
			getAllCartList();
			calCheckedCartList();
		}
	})
}