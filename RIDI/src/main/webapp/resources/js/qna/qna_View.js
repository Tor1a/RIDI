replySelectAll();

function qnaPassword(no){
   let password = prompt("Qna 패스워드를 입력하세요");
   window.location=`QndDelete.do?no=${no}&password=${password}`;
   return false;
}




// <button class="btnDelete"><span class="material-icons">delete</span></button> 
// 댓글을 DB에 저장한다.
$(".btnReply").on("click",function(){
	const _parent = $(this).parent();
	const sendData = {
		boardId:$("#qnaNo").text(),
		reply:_parent.find("#reply").val()
	}
	$.ajax({
		url:"ReplyWrite.do",
		type:"POST",
		data:sendData,
		success:function(resultData){
			console.log(resultData);
			$(".replyList .list").html("");
			replySelectAll();
		},
		error:function(errorMsg){
			console.log(errorMsg);
		}
	});
});

// 댓글 입력 글자수를 제한한다.
$(".replyBox textarea").on("keydown", function(e){
	const content = $(this).val();
	if(content.length > 300) {
		alert("300자까지 입력 가능합니다.");
		$(this).val(content.substr(300));
	} else {
		$("#currentCount").text(content.length);
	}
});



// 모든 댓글을 출력한다.
function replySelectAll(){
	const sendData = {
		boardId:$("#qnaNo").text()
	}
	$.ajax({
		url:"ReplySelectAll.do",
		type:"POST",
		data:sendData,
		success:function(resultData){
			console.log(resultData);
			$(".replyList .list").html(""); // 기존꺼 지우기
            const list=$(".replyList .list");
            const replyList = resultData.replyList;
            $.each(replyList,function(i,item){
                list.append(`
                <li data-no="${item.no}" data-boardid="${item.boardId}">
                	<div class="txt">${item.reply} </div>
                	<button><span class="material-icons">delete</span></button>
                </li>
                `)
            });
		}
	});
}
