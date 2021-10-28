// 주문상품을 화면에 출력한다.
getOrderList();
function getOrderList(){
	const sendData = {
		order_Person:$("#loggedMemberId").text(),
		payCheck:"NOPAY"
	}
	$.ajax({
		url:"getOrdersList.do",
		type:"POST",
		data:sendData,
		success:function(result){
			const orderList = result.orderList;
			$.each(orderList,function(i,item){
				$(".order_Book_Info table").append(`<tr class="orderList" data-no=${item.order_Group_No}>
		                                <td>
		                                    <div>
		                                        <a href="BookInfo.do?no=${item.book_No}"><img src="${item.book_Image}" alt=""></a>
		                                        <a href="#">${item.book_Name}</a>
		                                    </div>
		                                </td>
		                                <td><span class="bookPrice">${item.price}원</span></td>
										<td><span class="shippingFee">${item.shipping_Fee}원</span></td>
										<td><span>${item.qty}개</span></td>
		                            </tr>`);
			})
			calPriceSum();
		}
	})
}

// 주문한 예정인 상품의 가격 총합을 계산한다.
function calPriceSum(){
	let bookPriceSum = 0;
	let shippingFeeSum = 0;
	$(".bookPrice").each(function(){
		let bookPrice = Number($(this).text().slice(0, -1));
		bookPriceSum = bookPriceSum + bookPrice;
	})
	$(".shippingFee").each(function(){
		let shippingFee = Number($(this).text().slice(0,-1));
		shippingFeeSum = shippingFeeSum + shippingFee;
	})
	$("#bookPriceSum").text(`${bookPriceSum}원`);
	$("#shippingFeeSum").text(`${shippingFeeSum}원`);
	$("#totalPirceSum").text(`${bookPriceSum + shippingFeeSum}원`)
}


//  다음 카카오 주소 API를 호출한다.
$("#btnZip").on("click", function() {
	new daum.Postcode({
		oncomplete: function(data) {
			$("#zipcode").val(data.zonecode);
			$("#address01").val(data.address);

		}
	}).open();
	return false;
});

// 결제를 진행한다.
$(".order_Btn").on("click",function(){
	if(confirm("정말로 결제를 진행하시겠습니까?") == true){
		const sendData = {
			order_Group_No:$(".orderList").data("no")
		}
		$.ajax({
			url:"setPayCheck.do",
			type:"POST",
			data:sendData,
			success:function(result){
				if(result > 0){
					const sendData2={
						minusCash:$("#totalPirceSum").text().slice(0,-1),
						id:$("#loggedMemberId").text()
					}
					console.log(sendData2);
					$.ajax({
						url:"minusCash.do",
						type:"POST",
						data:sendData2,
						success:function(result){
							if(result > 0){
								alert("결제 완료되었습니다.")
								window.location.reload();	
							}
						}
					})	
				}
			}
		})
	}
})

