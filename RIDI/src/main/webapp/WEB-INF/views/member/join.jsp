<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<main>
	<div id="contents">
		<h2 class="contentsTitle">회원가입</h2>
		<form method="POST" action="MemberJoin.do" id="join" class="form" enctype="multipart/form-data" name="signUp">
			<table border="1" class="tdLeft">
				<cols>
					<col style="width: 200px">
					<col style="width: 600px">
				</cols>
				<tbody>
					<tr>
						<th>이름</th>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<th>주민등록번호</th>
						<td>
							<input type="text" name="rrn" placeholder="주번">
						</td>
					</tr>
					<tr>
						<th>아이디</th>
						<td>
							<input type="text" name="id" placeholder="아이디" >
						</td>
					</tr>
					<tr>
						<th>비밀번호 </th>
						<td><input type="password" name="password" placeholder="패스워드"  ></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="email"></td>
					</tr>
					<tr>
						<th>성별</th>
						<td>
							<select name="gender">
		                  		<option value="mail" selected>남자</option>
		                  		<option value="female">여자</option>
		                  	</select>
	                  	</td>
                  	</tr>
					<tr>
						<th>주소</th>
						<td>
							<div>
								<input type="number" name="zipcode" class="short" id="zipcode"> 
								<input type="button" name="addressBtn" value="우편번호" id="btnZip">
							</div>
							<div>
								<input type="text" name="address01" id="address01"><span>기본주소</span>
							</div>
							<div>
								<input type="text" name="address02" id="address02"><span>나머지주소</span>
							</div>
						</td>
					</tr>
					<tr>
						<th>휴대전화</th>
						<td><select name="phoneNumber" class="short">
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="017">017</option>
						</select> - <input type="number" name="phoneMiddleNumber" class="short">
							- <input type="number" name="phoneLastNumber" class="short"></td>
					</tr>
					<tr>
						<th>날짜 </th>
						<td><input type="date" name="creationDate" ></td>
					</tr>
				</tbody>
			</table>
			<div class="btns center">
				<input type="submit" value="회원가입" >
			</div>
		</form>
	</div>
	<!-- contents end -->
	
</main>
</body>
</html>