<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

 <div id="content_Book_Info">
        <div id="book_Info_Box">
            <div class="book_Info_Inner">
                <div class="book_Img">
                    <img src="${bookDto.book_Image}" alt="">
                </div>
                <div class="book_Info">
                    <div class="book_Info_Line">
                        <div class="book_Tag">
                            <ul>
                                <li>${bookDto.category}</li>
                                <li>${bookDto.book_Name}</li>
                                <li>${bookDto.star_Rating}</li>
                                <li>${bookDto.author}</li>
                                <li style="width:100px; height:20px; text-overflow: clip; overflow: hidden;">${bookDto.publication_Date }</li>
                            </ul>
                        </div>
                         <div class="book_parcel_Box">
                            <table class="book_parcel_Box_table">
                                <tbody>
                                    <tr class="book_Price">
                                        <th>구매</th>
                                        <td><div><span>판매가</span><span>${bookDto.price }원</span></div></td>
                                    </tr>
                                    <tr>
                                        <th>배송비</th>
                                        <td>${bookDto.shipping_Price }</td>
                                    </tr>
                                    <tr>
                                        <th>배송예정시간</th>
                                        <td>${bookDto.estimated_Time }</td>
                                    </tr>
                                    <tr>
                                        <th>재고수</th>
                                        <td>${bookDto.stock }</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="book_Btn">
                            <a href="#"><i class="fas fa-shopping-cart"></i></a>
                            <a href="#">구매하기</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="book_Introduction">
            <h2>작품소개</h2>
            <p>${bookDto.book_Intro}</p>
        </div>
        <div class="book_Review">
            <h3>리뷰</h3>
            <div class="starRating_container">
                <form class="starRating_form" action="#">
                  <div class="startRating_wrapper">
                    <div class="starRate_num"><span>평점</span></div>
                    <div class="star-rating space-x-4 mx-auto">
                        <input type="radio" id="5-stars" name="star_Rating" value="5" v-model="ratings"/>
                        <label for="5-stars" class="star pr-4">★</label>
                        <input type="radio" id="4-stars" name="star_Rating" value="4" v-model="ratings"/>
                        <label for="4-stars" class="star">★</label>
                        <input type="radio" id="3-stars" name="star_Rating" value="3" v-model="ratings"/>
                        <label for="3-stars" class="star">★</label>
                        <input type="radio" id="2-stars" name="star_Rating" value="2" v-model="ratings"/>
                        <label for="2-stars" class="star">★</label>
                        <input type="radio" id="1-star" name="star_Rating" value="1" v-model="ratings" />
                        <label for="1-star" class="star">★</label>
                    </div>
                </div>
                <div class="starRating_contents">
                    <textarea name="contents" placeholder="리뷰를 입력해주세요."  style="resize: none;"></textarea>
                </div>
                <div class="starRating_btn"><button type="submit">리뷰등록</button></div>
              </form>
            </div><!--starRating_container-->
            <ul class="bookContents_wrapper">
                <li class="book_contents">
                    <div><span>구매</span></div>
                    <div><p>${reviewDto.contents}</p></div>
                </li>
                <li class="book_writer">
                    <div><span>${reviewDto.star_Rating}</span></div>
                    <c:choose>
                        <c:when test="${reviewDto.star_Rating == 1}">
                            <div><span><label class="star">★</label></span></div>
                        </c:when>
                        <c:when test="${reviewDto.star_Rating == 2}">
                            <div><span><label class="star">★★</label></span></div>
                        </c:when>
                        <c:when test="${reviewDto.star_Rating == 3}">
                            <div><span><label class="star">★★★</label></span></div>
                        </c:when>
                        <c:when test="${reviewDto.star_Rating == 4}">
                            <div><span><label class="star">★★★★</label></span></div>
                        </c:when>
                        <c:when test="${reviewDto.star_Rating == 5}">
                            <div><span><label class="star">★★★★★</label></span></div>
                        </c:when>                                                                                                
                    </c:choose>
                    <div><span>${reviewDto.writer_Id}</span></div>
                    <div><span>${reviewDto.review_Date}</span></div>
                </li>
            </ul>
        </div><!--book_Review-->
       <div class="book_Bottom_Btn"> 
         <a href="BookDelete.do?no=${ bookDto.no }">삭제</a>
		 <a href="BookModifyForm.do?no=${ bookDto.no }&book_Name=${bookDto.book_Name}">수정</a>
       </div>
    </div>
    

<%@ include file="../include/footer.jsp"%>