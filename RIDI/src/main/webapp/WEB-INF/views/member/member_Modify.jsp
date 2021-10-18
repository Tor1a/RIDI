<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	 <div id="infoContent">
        <div class="infoInner">
            <div class="infoSub">
                <div class="infoTableLine">
                    <h2 class="infoTable">마이리디</h2>
                </div>
                <ul class="infoList">
                    <li><a href="#">마이리디홈</a></li>
                    <li><a href="#">문의하기</a></li>
                    <li><a href="MemberInfoModifyForm.do">정보 조회 & 변경</a></li>
                </ul>
            </div>
            <div id="modifyForm">
                <h4>정보 조회 & 변경</h4>
                <form action="MemberInfoModify.do" method="post">
                    <table>
                        <tbody>
                            <tr>
                                <th>이름</th>
                                <td class="modifyName"><span>${sessionScope.loggedMember.name }</span><a href="MemberDeleteForm.do" class="deleteBtn" onClick="return checkRealDelete();">회원탈퇴</a></td>
                            </tr>
                            <tr>
                                <th>아이디</th>
                                <td><span>${sessionScope.loggedMember.id }</span></td>
                            </tr>
                            <tr>
                                <th>이메일</th>
                                <td><span>${sessionScope.loggedMember.email }</span></td>
                            </tr>
                            <tr>
                                <th>휴대폰 번호</th>
                                <td class="modifyPhBox">
                                    <select name="phoneNumber" class="modifyPh">
                                        <option value="010">010</option>
                                        <option value="011">011</option>
                                        <option value="017">017</option>
                                    </select> - <input type="number" name="phoneMiddleNumber" class="short" value="${ fn:substring(sessionScope.loggedMember.hp,4,8)}">
                                    - <input type="number" name="phoneLastNumber" class="short" value="${ fn:substring(sessionScope.loggedMember.hp,9,13)}">
                                </td>
                            </tr>
                            <tr>
                                <th>비밀번호 변경</th>
                                <td class="modifyPwBox">
                                    <ul>
                                        <li class="modify_pw">
                                            <input type="password" name="password" placeholder="현재 비밀번호"  id="userPw" class="modify_box">
                                        </li>
                                        <li class="modify_pw2">
                                            <input type="password" name="password02" placeholder="새 비밀번호" id="userPw02" class="modify_box">
                                        </li>
                                    </ul>
                                </td>
                            </tr>
                            <tr>
                                <th>주소변경</th>
                                <td class="modifyAdd">
                                    <div class="zipcode_container">
                                        <input type="number" name="zipcode" class="zipcodeBox" id="zipcode" value="${sessionScope.loggedMember.zipcode }" > 
                                        <input type="button" name="zipCodeBtn" value="우편번호 검색" id="btnZip" class="zipcodeBtn" onClick="findAddr()")>
                                    </div>
                                    <div class="address_container">
                                    <div class="address01_container">
                                        <input type="text" name="address01" id="address01" value="${fn:substringBefore(sessionScope.loggedMember.address,'/') }"  class="modify_box1">
                                    </div>
                                    <div class="address02_container">
                                        <input type="text" name="address02" id="address02" value="${fn:substringAfter(sessionScope.loggedMember.address,'/') }" class="modify_box2">
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="modifyBtnBox">
                        <input type="submit" value="회원수정" class="modifyBtn">
                        <a href="#" class="modifyCancel">취소</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script>
		function findAddr(){
			new daum.Postcode({
	            oncomplete: function(data) {
	            	$("#zipcode").val(data.zonecode);
	            	$("#address01").val(data.address);
	            }
	        }).open();
	        return false;	
		}
	   
	    function checkRealDelete(){
	    	if(confirm("정말 탈퇴를 진행하시겠습니까?") == true){
	    		return true;
	    	} else{
	    		return false;
	    	}
	    	
	    }
    </script>
<%@ include file="../include/footer.jsp"%>