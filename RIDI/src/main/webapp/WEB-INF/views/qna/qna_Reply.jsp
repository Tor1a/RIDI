<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="contents">
	<h2 class="contentsTitle">글쓰기</h2>
	<form method="POST" action="QnaReplyWrite02.do" class="form">
		<table class="tdLeft">
			<tbody>
				<tr>
					<th>name</th>
					<td><input type="text" name="writerId" placeholder="이름을 쓰세요"></td>
				</tr>
				<tr>
					<th>subject</th>
					<td><input type="text" name="subject" placeholder="제목을 쓰세요"></td>
				</tr>
				<tr>
					<th>password</th>
					<td><input type="password" name="password"
						placeholder="패스워드를 쓰세요"></td>
				</tr>
				<tr>
					<th>contents</th>
					<td><textarea rows="" cols="" name="contents"
							placeholder="내용을 쓰세요" id="summernote"></textarea></td>
				</tr>
			</tbody>
		</table>
		<div class="btns center">
			<input type="hidden" name="no" value="${no }"> <input
				type="hidden" name="reGroup" value="${reGroup }"> <input
				type="hidden" name="reStep" value="${reStep }"> <input
				type="hidden" name="reLevel" value="${reLevel }"> <input
				type="submit" value="확인"> <input type="button" value="취소">
		</div>
	</form>
</div>
<script>
	$("#summernote").summernote({
		height : 400,
		callbacks : {
			onImageUpload : function(files) {
				//$summernote.summernote('insertNode', imgNode);
				uploadImg(files[0], this);
			}
		}
	});
	function uploadImg(file, editor) {
		sendData = new FormData(); // 자바스크립트에서 <form>에 들어가 있지 않은 데이터 받기.
		sendData.append("uploadFile", file); // form  <input type="text" name="userName">
		$.ajax({
			data : sendData,
			type : "POST",
			url : "SummerNoteFileUpload.do", // fileupload   cos.jar
			cache : false,
			contentType : false,// true  multipartformdata    
			processData : false,
			dataType : "json",
			success : function(data) {
				//console.log(data);
				$(editor).summernote("editor.insertImage", data.url);
			}
		})

	}
</script>
<%@ include file="../include/footer.jsp"%>



