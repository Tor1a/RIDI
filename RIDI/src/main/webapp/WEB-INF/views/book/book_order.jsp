<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="order_Content">
        <div class="order_Inner">
            <div id="order_Form">
                <h4 class="order_Title">주문/결제</h4>
                <p>배송/결제 정보를 정확히 입력해 주세요.</p>
                <div class="order_Form_Inner">
                    <form action="" method="post">
                        <div class="order_Input">
                            <input type="text" name="name" placeholder="이름" class="order_Name">
                            <input type="text" name="email" placeholder="이메일" class="join_Email">
                            <div class="order_Ph_Box">
                                <select name="hp" class="order_Ph">
                                    <option value="010">010</option>
                                    <option value="011">011</option>
                                    <option value="017">017</option>
                                </select><p>-</p><input type="number" name="hp_Middel" class="short" placeholder="번호 앞자리">
                                <p>-</p><input type="number" name="hp_Last" class="short" placeholder="번호 뒷자리">
                            </div>
                            <input type="text" name="id" class="login_Id" placeholder="아이디">
                            <input type="password" name="password" placeholder="비밀번호" id="userPw" class="join_Password">
                            <input type="password" name="password02" placeholder="비밀번호 확인" id="userPw02" class="join_Password">
                            <div class="zipcode_Container">
                                <input type="number" name="zipcode" class="zipcode_Box" id="zipcode" placeholder="우편번호">
                                <input type="button" name="zipCode_Btn" value="우편번호 검색" id="btnZip" class="zipcode_Btn" >
                            </div>
                            <div class="address_Container">
                                <div class="address01_Container">
                                    <input type="text" name="address01" id="address01" placeholder="기본주소" class="order_box1">
                                </div>
                                <div class="address02_Container">
                                    <input type="text" name="address02" id="address02" placeholder="나머지주소" class="order_box2">
                                </div>
                            </div>
                        </div>
                    </form>
                    <div class="order_Book_Info">
                        <!--장바구니 작동되게할지 안할지몰라서 다중선택은 일단 빼둘게요-->
                        <h4>주문상품</h4>
                        <table>
                            <thead>
                                <tr>
                                    <th>상품정보</th>
                                    <th>판매가</th>
                                </tr>
                            </thead>
                            <tr>
                                <td>
                                    <div>
                                        <a href="#"><img src="../images/slide/book.JPG" alt=""></a>
                                        <a href="#">책제목</a>
                                    </div>
                                </td>
                                <td><span>가격원</span><span>수량n개</span></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="order_Btn_Box">
                <div class="order_Btn_Box_Inner">
                    <ul>
                        <li>
                            <div><span>상품금액</span><span>가격원</span></div>
                        </li>
                        <li>
                            <div><span>배송비</span><span>가격원</span></div>
                        </li>
                    </ul>
                    <div class="order_result_price"><div><span>최종 결제금액</span><span>가격원</span></div></div>
                </div>
                <input type="submit" value="결제하기" class="order_Btn">
                <a href="#" class="cart_Back">장바구니 가기</a>
            </div>
        </div>
    </div>
    <script>
        $("#btnZip").on("click",function(){
            new daum.Postcode({
                oncomplete: function(data) {
                    $("#zipcode").val(data.zonecode);
                    $("#address01").val(data.address);
                    
                }
            }).open();
            return false;
        });
    </script>
<%@ include file="../include/footer.jsp"%>