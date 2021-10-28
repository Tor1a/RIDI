$("#dibs").on("click",function(){
	if($("#loggedMemberId").text() == ""){
		alert("로그인 후 이용하실 수 있습니다.");
		return false;
	}
	const sendData = {
		book_Name: $(".book_Tag ul li:nth-child(2)").text(),
		QTY:1,
		price: $("#bookDtoPrice").text(),
		order_Person:$("#loggedMemberId").text(),
		shipping_Address:$("#loggedMemberAddress").text(),
		shipping_Stage:"주문 접수중",
		seller:"RIDI",
		payCheck: "nopay",
		book_Image: $("#bookDtoImage").text(),
		book_No: $("#bookDtoBookNo").text()
	}

	$.ajax({
		url:"PutInShoppingCart.do",
		type:"POST",
		data:sendData,
		success:function(result){
			alert("카트에 정상적으로 담겼습니다.");
		}
	})
	
})