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
                                <div><input type="checkbox" checked="false"></div>
                            </li>
                            <li>
                                <div><img src="${item.book_Image}"></div>
                            </li>
                            <li>
                                <div><span>${item.book_Name}</span></div>
                                <div><span>${item.seller}</span></div>
                                <div><button>삭제</button></div>
                            </li>
                            <li>
                                <div><span>${item.price}원</span></div>
                            </li>
                        </ul>`);
			})
			
		}
	});
};

// 
$(".cartList_checkbox input").on("click",function(){
	console.log($(this).attr("checked"));
	// $(this).attr("checked",true);

	if($(this).attr("checked") == "false"){
		$(this).attr("checked","true")
		$(".cartList_btm li:nth-child(1) input").attr("checked","true");	
	} else if($(this).attr("checked") == "true"){
		$(this).attr("checked","false")
		$(".cartList_btm li:nth-child(1) input").attr("checked","false");
	}
	
})