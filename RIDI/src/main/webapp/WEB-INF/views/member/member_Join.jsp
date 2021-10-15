<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./css/RIDI.css">
</head>
<body class="join_body">
    <div id="join_contents" class="join_container">
		<header class="join_title">
			<div class="innerL">
					<h1 class="logoB"><a href="/RIDI">RIDI</a></h1>
			</div>
        </header>
		<form method="POST" action="MemberJoin.do" id="join" class="join_form" name="signUp" enctype="multipart/form-data">
				<ul class="join_info">
					<li class="join_id .box">
						<input type="text" name="id" placeholder="아이디" class="join_box">
					</li>
                    <div class="pw_container">
                        <li class="join_pw">
                            <input type="password" name="password" placeholder="패스워드"  id="userPw" class="join_box">
                        </li>
                        <li class="join_pw2">
                                <input type="password" name="password02" placeholder="패스워드 확인" id="userPw02" class="join_box">
                        </li>
                    </div>
                    <li class="join_name">
                        <input type="text" name="name" placeholder="이름" class="join_box">
                    </li>
                    <li class="join_rrd">
                            <div class="rrd-container">
                                <input type="text" name="rrn_first" placeholder="주민번호 앞자리"> -
                                <input type="text" name="rrn_last" placeholder="주민번호 뒷자리">
                            </div>
                    </li>
                    <li class="join_gender">
                        <label class="gender_box"><input type="radio" name="gender" value="man" checked><span>남</span></label>
                        <label class="gender_box"><input type="radio" name="gender" value="woman"><span>여</span></label>
                    </li>
                    <li class="join_adress">
							<div class="zipcode_container">
								<input type="number" name="zipcode" class="short box" id="zipcode" placeholder="우편번호" > 
								<input type="button" name="zipCodeBtn" value="우편번호 검색" id="btnZip" >
							</div>
                            <div class="address_container">
                            <div class="address01_container">
                                <input type="text" name="address01" id="address01" placeholder="기본주소" class="join_box">
                            </div>
							<div class="address02_container">
								<input type="text" name="address02" id="address02" placeholder="나머지주소" class="join_box">
							</div>
                            <div>
							<input type="button" name="addressBtn" value="주소 검색" id="btnAdress" class="join_btnBox">
                            </div>
					</li>
					<li class="join_ph">
						<div><select name="phoneNumber" class="ph_container">
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="017">017</option>
							</select> - <input type="number" name="phoneMiddleNumber" class="short" placeholder="번호 앞자리">
							- <input type="number" name="phoneLastNumber" class="short" placeholder="번호 뒷자리">
						</div>
					</li>
					<li class="join_email">
						<input type="text" name="email" placeholder="이메일" class="join_box">
					</li>
					<li>
					<div class="join_btn">
						<input type="submit" value="회원가입 완료" class="join_btnBox">
					</div>
					</li>
				</ul>
		</form>
	</div>
</body>
</html>