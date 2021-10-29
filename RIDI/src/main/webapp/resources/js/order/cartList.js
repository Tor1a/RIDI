//처음 카트페이지 로딩시 카트 리스트 출력
getAllCartList();

// 사용자별 카트리스트를 출력한다.
function getAllCartList() {
	const sendData = {
		id: $("#loggedMemberId").text()
	}
	$.ajax({
		url: "GetShoppingCartList.do",
		data: sendData,
		type: "POST",
		success: function(result) {
			const shoppingCartList = result.shoppingCartList;
			$.each(shoppingCartList, function(i, item) {
				$(".cartList_left").append(`<ul class="cartList_btm" data-no="${item.no}">
                            <li>
                                <div><input class="cartCheckBox" type="checkbox" onclick="calCheckedCartList()"></div>
                            </li>
                            <li>
                                <div><img src="${item.book_Image}"></div>
                            </li>
                            <li>
                                <div><span>${item.book_Name}</span></div>
                                <div><span>${item.seller}</span></div>
                                <div><button class="cartDeleteBtn" data-no=${item.no}>삭제</button></div>
                            </li>
                            <li>
                                <div class="bookPriceBox"><span class="bookPrice">${item.price}원</span></div>
                            </li>
                        </ul>`);
			})
			calCheckedCartList();

		}
	});
};

//


// 체크된 책들의 가격의 합을 구한다.
function calCheckedCartList() {
	let cartListLength = $(".cartList_btm").length;
	let priceSum = 0;
	let selectCartListNum = 0;

	$(".cartList_btm").each(function() {
		//console.log($(this).find(".bookPrice").text());
		if ($(this).find(".cartCheckBox").prop("checked")) {
			let price = Number($(this).find(".bookPrice").text().slice(0, -1));
			priceSum = priceSum + price;
			selectCartListNum++;
		}
	});
	$(".cartList_sum > div:nth-of-type(1) span").text(`${selectCartListNum}권을 선택하셨습니다.`);
	$(".cartList_sum > div:nth-of-type(3) span").text(`${priceSum}원`);
	$(".select_btm > div:nth-of-type(2) span").text(`${priceSum}원`);


}

// OrderGroupNo를 DB에서 생성해서 받고 
// 선택한 찜한 아이템을 DB에 업데이트 해주고 결제 페이지로 넘어간다.
$("#selectedItemPayBtn").on("click", function() {
	let order_Group_No;
	let uncheckBoxInspect = 0;
	
	$(".cartCheckBox").each(function(){
		if($(this).prop("checked")){
			uncheckBoxInspect++;
		}
	})

	if(uncheckBoxInspect == 0){
		alert("최소 1개 이상 체크해주세요");
		return false;
	}
	
	$.ajax({
		url: "GetOrderGroupNo.do",
		type: "POST",
		success: function(result) {
			order_Group_No = result;
		},
		complete: function() {
			$(".cartList_btm").each(function() {
				const sendData = {
						order_Group_No: order_Group_No,
						no: $(this).data("no")
					}
				if ($(this).find(".cartCheckBox").prop("checked")) {
					$.ajax({
						url:"setOrderGroupNo.do",
						type:"POST",
						data:sendData
					})
				} else{
					$.ajax({
						url:"unsetOrderGroupNo.do",
						type:"POST",
						data:sendData
					})
				}
			})
			window.location = "OrderPayForm.do";
		}
	})



})

// 카트 리스트 전체 선택/해제 기능을 구현
$(".cartList_checkbox input").on("click", function() {
	if ($(this).prop("checked")) {
		$(this).prop("checked", true);
		$(".cartList_btm li:nth-child(1) input").prop("checked", true);
	} else {
		$(this).prop("checked", false);
		$(".cartList_btm li:nth-child(1) input").prop("checked", false);
	}
	calCheckedCartList();
})


// 찜한 아이템 삭제버튼시 DB에 찜한 내용 삭제 / View에서 해당 아이템 삭제 / 선택한 상품 총액 재계산
$(".cartList_left").on("click", ".cartDeleteBtn", function() {
	const _cartRowBox = $(this).parent("div").parent("li").parent("ul");
	const itemNo = $(this).data("no");
	const sendData = {
		itemNo: itemNo
	}
	$.ajax({
		url: "DeleteShoppingCart.do",
		data: sendData,
		type: "POST",
		success: function(result) {
			_cartRowBox.remove();
			calCheckedCartList();
		}
	})
})
