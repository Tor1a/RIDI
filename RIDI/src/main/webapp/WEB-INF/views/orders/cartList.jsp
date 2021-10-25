<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	<div class="cartList_wrapper">   
            <div class="cartList_inner">
                <div class="cartList_container">
                    <div class="cartList_left">
                        <div class="cartList_top">
                            <div><i class="fas fa-shopping-cart"></i><span>장바구니</span></div>
                        </div>
                        <div class="cartList_middle">
                            <div class="cartList_checkbox">
                                <div><input type="checkbox" checked></div>
                                <div><span>전체선택</span></div>
                            </div>
                        </div>
                        <ul class="cartList_btm">
                            <li>
                                <div><input type="checkbox" checked></div>
                            </li>
                            <li>
                                <div><img src="./images/newBookCover02.JPG"></div>
                            </li>
                            <li>
                                <div><span>내게 새겨진 장면들</span></div>
                                <div><span>이음</span></div>
                                <div><button>삭제</button></div>
                            </li>
                            <li>
                                <div><span>9600원</span></div>
                            </li>
                        </ul>
                    </div>
                    <div class="cartList_right">
                        <div class="cartList_select">
                            <div class="cartList_sum">
                                <div><span>1권을 선택하셨습니다.</span></div>
                                <div><span>총 상품 금액</span></div>
                                <div><span>9600원</span></div>
                                <div class="select_btm">
                                    <div><span>합계</span></div>
                                    <div><span>9600원</span></div>
                                </div>
                            </div>
                            <div class="cartList_selectBtn">
                                <div><button>선택구매</button></div>
                            </div>
                        </div>
                    </div><!--cartList_right-->
                </div> <!--cartList_container-->
        </div>   <!--cartList_inner-->
</div> <!--cartList_wrapper-->
<link rel="stylesheet" property="stylesheet" href="./css/cartList.css"></link>
<%@ include file="../include/footer.jsp"%>