<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="./js/jquery-3.6.0.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js" defer></script>
    <link rel="shortcut icon" href="./images/favicon.ico">
    <title>RIDI</title>
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
						<input type="text" name="id" placeholder="아이디" class="join_box" id="id">
						<p id="idCheckResult"></p>
						<input type="button" name="idDuplicateCheck" value="중복 체크" id="idDuplicateCheck" class="join_btnBox" onClick="checkIdDuplicate()">
					</li>
                    <div class="pw_container">
                        <li class="join_pw">
                            <input type="password" name="password" placeholder="패스워드"  id="userPw" class="join_box">
                        </li>
                        <li class="join_pw2">
                                <input type="password" name="password02" placeholder="패스워드 확인" id="userPw02" class="join_box" onkeyup="checkPw()">
                        </li>
                        <p id="pwCheckResult"></p>
                    </div>
                    <li class="join_name">
                        <input type="text" name="name" placeholder="이름" class="join_box" id="name">
                    </li>
                    <li class="join_rrd">
                            <div class="rrd-container">
                                <input type="text" name="rrn_First" placeholder="주민번호 앞자리" id="rrn_First"> -
                                <input type="text" name="rrn_Last" placeholder="주민번호 뒷자리" id="rrn_Last">
                            </div>
                    </li>
                    <li class="join_gender">
                        <label class="gender_box"><input type="radio" name="gender" value="man" checked><span>남</span></label>
                        <label class="gender_box"><input type="radio" name="gender" value="woman"><span>여</span></label>
                    </li>
                    <li class="join_adress">
						<div class="zipcode_container">
							<input type="number" name="zipcode" class="short box" id="zipcode" placeholder="우편번호" id="zipcode" readonly>
							<input type="button" name="zipCodeBtn" value="우편번호 검색" id="btnZip" onClick="findAddr()" >
						</div>
                           <div class="address_container">
                           <div class="address01_container">
                               <input type="text" name="address01" id="address01" placeholder="기본주소" class="join_box" readonly>
                           </div>
						<div class="address02_container">
							<input type="text" name="address02" id="address02" placeholder="나머지주소" class="join_box">
						</div>
					</li>
					<li class="join_ph">
						<div><select name="phoneNumber" class="ph_container">
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="017">017</option>
							</select> - <input type="number" name="phoneMiddleNumber" class="short" placeholder="번호 앞자리" id="phoneMiddleNumber">
							- <input type="number" name="phoneLastNumber" class="short" placeholder="번호 뒷자리" id="phoneLastNumber">
						</div>
					</li>
					<li class="join_email">
						<input type="text" name="email" placeholder="이메일" class="join_box" id="email">
						<input type="text" name="emailCheck" placeholder="이메일 인증번호" class="join_box" id="emailCheck">
						<input type="button" name="addressBtn" value="메일 인증" id="btnEmail" class="join_btnBox" onclick="generateEmailAuthNum()">
					</li>
					<li>
					<div class="join_btn">
						<input type="submit" value="회원가입 완료" class="join_btnBox" onclick="return checkEmptyInput()">
					</div>
					</li>
				</ul>
		</form>
	</div>
	<script>
		let emailAuthNum;
		function checkIdDuplicate(){
			const sendData = {
					id : $("#id").val()
			}
			$.ajax({
				type:"POST",
				url:"idDuplicationCheck.do",
				data:sendData,
				success: function(result){
					if(result.id == $("#id").val()){
						$("#idCheckResult").text("이미 사용중인 아이디 입니다.");
					} else {
						$("#idCheckResult").text("사용가능한 아이디 입니다.");
					}
				},
				error: function(error){
					console.log(error)
				}
			})
		}
		function findAddr(){
			new daum.Postcode({
	            oncomplete: function(data) {
	            	$("#zipcode").val(data.zonecode);
	            	$("#address01").val(data.address);
	            }
	        }).open();
	        return false;	
		}
		
		function checkPw(){
			if($("#userPw02").val().length >= $("#userPw").val().length){
				if($("#userPw02").val() == $("#userPw").val()){
					$("#pwCheckResult").text("패스워드가 일치합니다.");
				} else {
					$("#pwCheckResult").text("패스워드가 서로 다릅니다. 확인해주세요.");
				}
			}
		}
		
		$(".gender_box input").on("click",function(){
			$(".gender_box input").attr('checked',false);
			$(".gender_box input").parent().attr("style","background-color:#fff");
			$(".gender_box input").parent().children("span").attr("style","color:#d1d5d9");
			$(this).attr('checked',true);
			$(this).parent().attr("style","background-color:#1f8ce6;");
			$(this).parent().children("span").attr('style','color:#fff');
		})
		
		function checkEmptyInput(){
			if($.trim($("#id").val()) == ""){
				alert("아이디를 입력해주세요");
				$("#id").focus();
				return false;
			} else if($.trim($("#userPw").val()) == ""){
				alert("패스워드를 입력해주세요");
				$("#userPw").focus();
				return false;
			} else if($.trim($("#userPw02").val()) == ""){
				alert("확인용 패스워드를 입력해주세요");
				$("#userPw02").focus();
				return false;
			} else if($.trim($("#name").val()) == ""){
				alert("본인의 성함을 입력해주세요");
				$("#name").focus();
				return false;
			} else if($.trim($("#rrn_First").val()) == ""){
				alert("주민번호 앞자리를 입력하세요");
				$("#rrn_First").focus();
				return false;
			} else if($.trim($("#rrn_Last").val()) == ""){
				alert("주민번호 뒷자리를 입력하세요");
				$("#rrn_Last").focus();
				return false;
			} else if($.trim($("#zipcode").val()) == ""){
				alert("주소를 입력해주세요");
				$("#zipcode").focus();
				return false;
			} else if($.trim($("#address02").val()) == ""){
				alert("나머지 주소를 입력해주세요");
				$("#address02").focus();
				return false;
			} else if($.trim($("#phoneMiddleNumber").val()) == ""){
				alert("핸드폰 중간 4자리를 입력하세요");
				$("#phoneMiddleNumber").focus();
				return false;
			} else if($.trim($("#phoneLastNumber").val()) == ""){
				alert("핸드폰 끝 4자리를 입력하세요");
				$("#phoneLastNumber").focus();
				return false;
			} else if($.trim($("#email").val()) == ""){
				alert("이메일을 입력해주세요");
				$("#email").focus();
				return false;
			}
		}
		
		function generateEmailAuthNum(){
			$.ajax({
				url:"generateEmailAuthNum.do",
				Data:sendData,
				success:function(result){
					emailAuthNum = result
					console.log(emailAuthNum);
				}
			})
			alert("인증메일을 발송했습니다. 메일함을 확인해주세요");
		}
	</script>
</body>
</html>