<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>main</title>
</head>
<script type="text/javascript">

$('#btn1').on('click', function(){
    var form = {
            name: "jamong",
            age: 23
    }
    $.ajax({
        url: "/psyco/main.com",
        type: "POST",
        data: form,
        success: function(data){
            $('#result').text(data);
        },
        error: function(){
            alert("simpleWithObject err");
        }
    });
});



</script>
<body>


    <!--  검색베너  & 신메뉴 , 랭킹미리보기 -->
    <section id="banner_section">
      
        <div id="banner">
            <img src="/psyco/resources/img/main/banner.png" alt="">
        </div>
 
    </section>
    <!-- 경매 카테고리 -->
    <section id="category">
        <ul>
            <li><a href="">1인 메뉴</a></li>
            <li><a href="">세트 메뉴</a></li>
        </ul>

    </section>

    <!-- 경매 상품 -->
    <section class="item-section">
        <div class="card-container">
        
        <c:forEach var="item" items="${itemList}">
        	<div class="card">
        		<img src="/psyco/resources/${item.menu_img}" alt="" class="card_img">
        		<div class="card_content">
        			<h3>${item.shop_name}</h3>
        			<h2>${item.item_name}</h2>
        			<ul>
        				<li>시작 시간</li>
        				<li>${fn:substring(item.startDate,0,16)}</li>	
        			</ul>
        			<ul>
        				<li>종료 시간</li>
        				<li>${fn:substring(item.endDate,0,16)}</li>	
        			</ul>
        			<ul>
        				<li>자동 할인시간</li>
        				<li><fmt:parseNumber var="discount_cycle" value="${item.discount_cycle / 60}" integerOnly="true"/>${discount_cycle} 분</li>
        			</ul>
        			<ul>
        				<li>시작 가격</li>
        				<li>${item.maxPrice}</li>
        			</ul>
        			<ul>
        				<li>종료 가격</li>
        				<li>${item.minPrice}</li>
        			</ul>
        			
        			<ul class="sale">
        				<li class="sale_item"></li>
        				<li></li>
        			</ul>
        			<ul class="price">
        				<li></li>
        				<li></li>
        			</ul>
        		</div>
        	</div>
        
        </c:forEach>
        </div>
        
            <!-- <div class="card">
                <img src="/psyco/resources/img/item/one/1.jpg" alt="" class="card_img">
                <div class="card_content">
                    <h3>김밥천국</h3>
                    <h2>제육덮밥</h2>
                    <ul>
                        <li>시작일</li>
                        <li>2010.10.18</li>
                    </ul>
                    <ul>
                        <li>자동 할인시간 </li>
                        <li>30분</li>
                    </ul>
                    <ul>
                        <li>시작 가격</li>
                        <li>5000원</li>
                    </ul>

                    <ul class="sale">
                        <li class="sale_item">8% &darr;</li>
                        <li>(현재 400원 할인)</li>
                    </ul>
                    <ul class="price">
                        <li>
                            현재가격
                        </li>
                        <li class="price_data">
                            4000원
                        </li>
                    </ul>

                </div>
            </div>
            <div class="card">
                <img src="/psyco/resources/img/item/one/2.jpg" alt="" class="card_img">
                <div class="card_content">
                    <h3>김밥천국</h3>
                    <h2>제육덮밥</h2>
                    <ul>
                        <li>시작일</li>
                        <li>2010.10.18</li>
                    </ul>
                    <ul>
                        <li>자동 할인시간 </li>
                        <li>30분</li>
                    </ul>
                    <ul>
                        <li>시작 가격</li>
                        <li>5000원</li>
                    </ul>

                    <ul class="sale">
                        <li class="sale_item">8% &darr;</li>
                        <li>(현재 400원 할인)</li>
                    </ul>
                    <ul class="price">
                        <li>
                            현재가격
                        </li>
                        <li class="price_data">
                            4000원
                        </li>
                    </ul>

                </div>
            </div>
            <div class="card">
                <img src="/psyco/resources/img/item/one/3.jpg" alt="" class="card_img">
                <div class="card_content">
                    <h3>김밥천국</h3>
                    <h2>제육덮밥</h2>
                    <ul>
                        <li>시작일</li>
                        <li>2010.10.18</li>
                    </ul>
                    <ul>
                        <li>자동 할인시간 </li>
                        <li>30분</li>
                    </ul>
                    <ul>
                        <li>시작 가격</li>
                        <li>5000원</li>
                    </ul>

                    <ul class="sale">
                        <li class="sale_item">8% &darr;</li>
                        <li>(현재 400원 할인)</li>
                    </ul>
                    <ul class="price">
                        <li>
                            현재가격
                        </li>
                        <li class="price_data">
                            4000원
                        </li>
                    </ul>

                </div>
            </div>
            <div class="card">
                <img src="/psyco/resources/img/item/one/4.jpg" alt="" class="card_img">
                <div class="card_content">
                    <h3>김밥천국</h3>
                    <h2>제육덮밥</h2>
                    <ul>
                        <li>시작일</li>
                        <li>2010.10.18</li>
                    </ul>
                    <ul>
                        <li>자동 할인시간 </li>
                        <li>30분</li>
                    </ul>
                    <ul>
                        <li>시작 가격</li>
                        <li>5000원</li>
                    </ul>

                    <ul class="sale">
                        <li class="sale_item">8% &darr;</li>
                        <li>(현재 400원 할인)</li>
                    </ul>
                    <ul class="price">
                        <li>
                            현재가격
                        </li>
                        <li class="price_data">
                            4000원
                        </li>
                    </ul>

                </div>
            </div>
            <div class="card">
                <img src="/psyco/resources/img/item/one/5.png" alt="" class="card_img">
                <div class="card_content">
                    <h3>김밥천국</h3>
                    <h2>제육덮밥</h2>
                    <ul>
                        <li>시작일</li>
                        <li>2010.10.18</li>
                    </ul>
                    <ul>
                        <li>자동 할인시간 </li>
                        <li>30분</li>
                    </ul>
                    <ul>
                        <li>시작 가격</li>
                        <li>5000원</li>
                    </ul>

                    <ul class="sale">
                        <li class="sale_item">8% &darr;</li>
                        <li>(현재 400원 할인)</li>
                    </ul>
                    <ul class="price">
                        <li>
                            현재가격
                        </li>
                        <li class="price_data">
                            4000원
                        </li>
                    </ul>

                </div>
            </div>
            <div class="card">
                <img src="/psyco/resources/img/item/one/6.jpg" alt="" class="card_img">
                <div class="card_content">
                    <h3>김밥천국</h3>
                    <h2>제육덮밥</h2>
                    <ul>
                        <li>시작일</li>
                        <li>2010.10.18</li>
                    </ul>
                    <ul>
                        <li>자동 할인시간 </li>
                        <li>30분</li>
                    </ul>
                    <ul>
                        <li>시작 가격</li>
                        <li>5000원</li>
                    </ul>

                    <ul class="sale">
                        <li class="sale_item">8% &darr;</li>
                        <li>(현재 400원 할인)</li>
                    </ul>
                    <ul class="price">
                        <li>
                            현재가격
                        </li>
                        <li class="price_data">
                            4000원
                        </li>
                    </ul>

                </div>
            </div>
            <div class="card">
                <img src="/psyco/resources/img/item/one/7.jpg" alt="" class="card_img">
                <div class="card_content">
                    <h3>김밥천국</h3>
                    <h2>제육덮밥</h2>
                    <ul>
                        <li>시작일</li>
                        <li>2010.10.18</li>
                    </ul>
                    <ul>
                        <li>자동 할인시간 </li>
                        <li>30분</li>
                    </ul>
                    <ul>
                        <li>시작 가격</li>
                        <li>5000원</li>
                    </ul>

                    <ul class="sale">
                        <li class="sale_item">8% &darr;</li>
                        <li>(현재 400원 할인)</li>
                    </ul>
                    <ul class="price">
                        <li>
                            현재가격
                        </li>
                        <li class="price_data">
                            4000원
                        </li>
                    </ul>

                </div>
            </div>
            <div class="card">
                <img src="/psyco/resources/img/item/one/8.jpg" alt="" class="card_img">
                <div class="card_content">
                    <h3>김밥천국</h3>
                    <h2>제육덮밥</h2>
                    <ul>
                        <li>시작일</li>
                        <li>2010.10.18</li>
                    </ul>
                    <ul>
                        <li>자동 할인시간 </li>
                        <li>30분</li>
                    </ul>
                    <ul>
                        <li>시작 가격</li>
                        <li>5000원</li>
                    </ul>

                    <ul class="sale">
                        <li class="sale_item">8% &darr;</li>
                        <li>(현재 400원 할인)</li>
                    </ul>
                    <ul class="price">
                        <li>
                            현재가격
                        </li>
                        <li class="price_data">
                            4000원
                        </li>
                    </ul>

                </div>
            </div>


        </div> -->

    </section>

</body>
</html>