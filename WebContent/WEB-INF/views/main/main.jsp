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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
	<script type="text/javascript">
	 /* $(document).ready(function(){
		
		 $.ajax({
			url : "/psyco/main/getEnrollEvent.com",
			type: "post",
			dataType: "text",
			success:function(result){
				console.log("success 여부는   : " + result);
				if(result == 'ok'){
					alert(" 승인 처리되셨습니다. !  오른쪽 위  버튼을   확인해주세요 !");
				}
				
			},
			error: function() {
				console.log(' ajax  실패');
			}
			
		 });
		 
	 }) */
	
	
		/* $(document).ready(function(){
			console.log("연결 ? ");
			$.ajax({
				url: "psyco/main/getEnrollEvent.com",
				type: "post",
				dataType:"json",
				success: function(){
					alert('사업자 가입에 승인처리되었다. 가게등록을 해보세요 .');

				}
			};	
			
		}) */
		
		
		$(document).ready(function(){
			
			$.ajax({
				url: "/psyco/main/getListData.com",
				type: "post",
				dataType: "json",
				success: function(result) {
					console.log(result);
					var array = new Array(result);
					for (var i in array[0]) {
						
						var item = JSON.parse(array[0][i].itemList);
						var progress_status;
						
					}

				},
				error: function() {
					console.log('ajax 실패');
				}
			});

		})
	
		
	

	/* 	$('#btn1').on('click', function(){
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
		}); */

	
		function getItemList(sett) {
			
			$.ajax({
				url: "/psyco/member/getItemList.com",
				type: "post",
				data: sett,
				success: function(data) {
					console.log(data);
				},
				error: function() {
					alert('ajax 실패!');
				}
				
			});
		}
		
		
	</script>
</head>


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
        	<li><a href="/psyco/main/main.com">전체 메뉴</a></li>
            <li><a href="/psyco/main/main.com?num='1'">1인 메뉴</a></li>
            <li><a href="/psyco/main/main.com?num='2'">세트 메뉴</a></li>
        </ul>
        
    </section>

    <!-- 경매 상품 -->
    <section class="item-section">
        <div class="card-container">
        <c:forEach var="item" items="${itemMapList}">
        	<div class="card">
        		<img src="/psyco/resources/${item.itemList.menu_img}" alt="" class="card_img">
        		<div class="card_content">
        			<h3 id="shop_name"><a href="/psyco/shop/shopDetail.com?shop_num=${item.itemList.shop_num}">${item.itemList.shop_name}</a></h3>
        			<h2 id="item_name"><a href="/psyco/shop/itemDetail.com?item_num=${item.itemList.item_num}&current_price=${item.current_price}&discount_price=${item.discount_price}&discount_rate=${item.discount_rate}">${item.itemList.item_name}</a></h2>
        			<ul>
        				<li>시작 시간</li>
        				<li>${fn:substring(item.itemList.startDate,0,16)}</li>
        			</ul>
        			<ul>
        				<li>종료 시간</li>
        				<li>${fn:substring(item.itemList.endDate,0,16)}</li>
        			</ul>
        			<ul>
        				<li>자동 할인시간</li>
        				<li><fmt:parseNumber var="discount_cycle" value="${item.itemList.discount_cycle / 60}" integerOnly="true"/>${discount_cycle} 분</li>
        			</ul>
        			<ul>
        				<li>시작 가격</li>
        				<li>${item.itemList.maxPrice}</li>
        			</ul>
        			<ul>
        				<li>종료 가격</li>
        				<li>${item.itemList.minPrice}</li>
        			</ul>
        			<ul class="sale">
        				<li class="sale_item"><fmt:formatNumber var="discount_rate" value="${item.discount_rate}" type="percent" pattern=".0" />${discount_rate} %</li>
        				<li>${item.discount_price}원 할인</li>
        			</ul>
        			<ul class="price">
	       				<c:choose>
	       					<c:when test="${item.progress_status == 1}">
	       						<li>종료된 경매입니다.</li>
	       					</c:when>
	       					<c:when test="${item.progress_status == 0}">
	       						<li>현재 가격</li>
	       						<li>${item.current_price}원</li>
	       						<li>남은 시간</li>
	       						<li id="remainder_time${item.itemList.item_num}">${item.remainder_time}분</li>
	       					</c:when>
	       				</c:choose>
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