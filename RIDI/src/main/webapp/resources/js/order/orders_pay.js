// 주문상품을 화면에 출력한다.
getOrderList();
function getOrderList(){
	const sendData = {
		order_Person:$("#loggedMemberId").text(),
		payCheck:"nopay"
	}
	console.log(sendData);
	$.ajax({
		url:"getOrdersList.do",
		type:"POST",
		data:sendData,
		success:function(result){
			const orderList = result.orderList;
			$.each(orderList,function(i,item){
				$(".order_Book_Info table").append(`<tr>
		                                <td>
		                                    <div>
		                                        <a href="#"><img src="${item.book_Image}" alt=""></a>
		                                        <a href="#">책제목</a>
		                                    </div>
		                                </td>
		                                <td><span>가격원</span><span>수량n개</span></td>
		                            </tr>`);
			})
		}
	})
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

