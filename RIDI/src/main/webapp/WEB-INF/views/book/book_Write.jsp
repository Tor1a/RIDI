<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div>
	<h2>Book</h2>
	<form method="POST" action="BookWrite.do" class="form" 
	id="book" name="signUp" enctype="multipart/form-data">
		<table class="tdLeft">
			<cols>
			<col style="width: 150px;">
			<col>
			</cols>
			<tbody>
				<tr>
					<th>name</th>
					<td><input type="text" name="name" placeholder="이름을 쓰세요"></td>
				</tr>
				<tr>
					<th>email</th>
					<td><input type="text" name="email" placeholder="메일을 쓰세요"></td>
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
				<tr>
                  <th>책 이미지</th>
                  <td><input type="file" name="multipartFile" id="bookImg"></td>
               </tr>
			</tbody>
		</table>
		<div class="btns center">
			<input type="submit" value="확인"> <input type="button"
				value="취소">
		</div>
	</form>
</div>
	
	
<%@ include file="../include/footer.jsp"%>