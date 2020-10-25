<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글내용</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=bsd4urkj6r"></script>
	<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=bsd4urkj6r&submodules=geocoder"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			IMP.init('imp29075190');
			
			var query = { query : '${shopInfo.address}' };
			
			function mapCreate(latitude, longitude) {
				if (typeof latitude == "undefined" || latitude == null || latitude == "") {
					latitude = 37.3595704;
					longitude = 127.105399;
				}
				
				var mapOptions = {
						center: new naver.maps.LatLng(latitude, longitude),
						zoom: 10
				};
				
				var map = new naver.maps.Map('map', mapOptions);
				return map;
			}
			
			naver.maps.Service.geocode(query, function(status, response) {
				if (status !== naver.maps.Service.Status.OK) {
					return alert('Something wrong!');
				}
				
				var v2 = response.v2,
					addresses = v2.addresses;
				
				var latitude = addresses[0].y,		// ex : 37.5438733
					longitude = addresses[0].x;		// ex : 127.0681978
		
				var changeMap = mapCreate(latitude, longitude);
				changeMap.setZoom(17, true);
				var marker = new naver.maps.Marker({
					position: new naver.maps.LatLng(latitude, longitude),
					map: changeMap
				});
			});
			
		
			
		})
		
		function getParam(sname) {
			var params = location.search.substr(location.search.indexOf("?")+1);
			var sval = "";
			params = params.split("&");
			for (var i = 0; i < params.length; i++) {
				temp = params[i].split("=");
				if (temp[0] == sname) {
					sval = temp[1];
				}
			}
			return sval;
		}
		
		function getToday() {
			var date = new Date();
			var year = date.getFullYear();
			var month = new String(date.getMonth() + 1);
			var day = new String(date.getDate());
			
			if (month.length == 1) {
				month = "0" + month;
			}
			if (day.length == 1) {
				day = "0" + day;
			}
			return year + "" + month + "" + day;
		}
		
		// 호출 전 db에 주문 정보를 전달하고 서버가 생성 한 주문 번호를 param의 merchant_uid 속성에 지정하기 
		function payment(mem_num) {
			
			$.ajax({
				url: "/psyco/member/getUserInfo.com",
				method: "post",
				data: {"mem_num": mem_num},
				dataType: "json",
				success: function(result){
							
					// IMP.request_pay(param, callback) 호출
					IMP.request_pay({ // param
						pg: "html5_inicis",
						payment_method: "card",					
						//merchant_uid: 'psyco' + getToday() + '-' + ${article.item_num},	// 주문 번호, 한번 결제 완료된 주문번호는 다시 사용할 수 없는 듯
						merchant_uid: 'psyco20201023-001285',
						name: '${article.item_name}',
						amount: getParam("current_price"),
						buyer_email: result.email,
						buyer_name: result.name,
						buyer_tel: result.phone_Num,
						buyer_addr: '${shopInfo.address}',
						//buyer_postcode: "00308"
					}, function(response) {
						// 결제 후 호출되는 callback 함수
						if (response.success) {
							console.log(response);
							
							var obj = new Object();
							obj.price = response.paid_amount;
							obj.amount = document.getElementById('quantity').value;
							obj.discount_rate = getParam("discount_rate"),
							obj.gender = result.gender;
							obj.member_num = result.member_Num;
							obj.menu_num = ${article.menu_num};
							obj.item_num = ${article.item_num};
							
							var jsonData = JSON.stringify(obj);
							console.log(jsonData);
							
							$.ajax({
								url: "/psyco/shop/paymentInsert.com",
								method: "post",
								//headers: {"ContentType": "application/json"},
								data: jsonData,
								dataType: "text",
								success: function(result){
									if (result == '1') {
										alert('결제가 완료 되었습니다.');
									} else {
										result == '오류 발생';
									}
									
								}
							});							
							
						} else {
							var msg = "결재가 실패하였습니다.";
							msg += '에러내용 :' + response.error_msg;
							console.log(msg);
						}
					})
				},
				error: function(){
					
				}
			});
		}
		
		function change(num){
			var quantity = Number(document.getElementById('quantity').value) + num;
			if (quantity < 1) quantity = 1;
			if (quantity >= ${article.amount}) quantity = ${article.amount};
			document.getElementById('quantity').value = quantity;
		}
		
	</script>
	
</head>
	



	<section id="buy_info">
        <div class="buy_img">
            <img src="/psyco/resources/img/item/one/1.jpg" alt="" class="card_img">
            <div class="map" id="map"></div>
        </div>
        <div class="buy_content">
            <div class="buy_title">
                <h1>${article.item_name}</h1>
            </div>
            <div class="shop_title">
                <ul>
                    <li>${shopInfo.shop_name}</li>
                    <li>${fn:substring(item.itemList.startDate,0,16)}</li>
                    <li>${fn:substring(item.itemList.endDate,0,16)}</li>
                </ul>
                <ul>
                    <li>${shopInfo.shop_phone}</li>
                    <li>${shopInfo.address}</li>
                    <li></li>
                </ul>

            </div>
            <div class="buy_detail">
                <ul>
                    <li>시작일</li>
                    <li>10/18</li>
                </ul>
                <ul>
                    <li>할인 주기</li>
                    <li>${article.discount_cycle}</li>
                </ul>
                <ul>
                    <li>경매 단위</li>
                    <li>${article.auction_unit}</li>

                </ul>
                <ul>
                    <li>남은 수량</li>
                    <li>${article.amount}</li>

                </ul>
            </div>
            <div class="buy_price">
                <div class="start_price">
                    <ul>
                        <li>시작 가격</li>
                        <li>${article.maxPrice}</li>

                    </ul>
                    <ul>
                        <li class="nprice">시작가격</li>
                        <li class=price_percent>
                            <fmt:formatNumber var="discount_rate" value="${param.discount_rate}" type="percent" pattern=".0" />${discount_rate} %
                        </li>


                    </ul>
                </div>
                <div class="now_price">
                    <ul>
                        <li>현재 가격</li>
                        <li>${param.current_price}원</li>
                    </ul>
                </div>
                <div>
                	<input type="text" name="quantity" id="quantity" value="1">
                	<input type="button" value="-" onclick="javascript:change(-1)">
                	<input type="button" value="+" onclick="javascript:change(1)">
                </div>
            </div>
            <button class="buy_btn" onclick="javascript:payment(${sessionScope.memNum})">
                <h2>구매하기</h2>
            </button>
        </div>

    </section>
    
    
    <section class="shop_info">
        <div class="items_info">
            <div class="ing_info">
                <h2>이 가게에서 진행중인 경매</h2>
                <div class="info_items">
                    <img src="/img/item/one/1.jpg" alt="">
                    <img src="/img/item/one/2.jpg" alt="">
                    <img src="/img/item/one/3.jpg" alt="">
                    <img src="/img/item/one/4.jpg" alt="">
                </div>
            </div>
            <div class="ing_info">
                <h2>이 가게에서 진행예정 경매</h2>
                <div class="info_items">
                    <img src="" alt="">
                    <img src="" alt="">
                    <img src="" alt="">
                    <img src="" alt="">
                </div>
            </div>
        </div>
        <div class="shop_comment">
            <h2>사장님 오늘의 한마디</h2>
            <h3>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Officiis mollitia odio illum suscipit.
                Laboriosam
                qui temporibus,</h3>
        </div>

    </section>
    <div class="shopCotent_btn">
        <div class="tabs">
            <div class="tab" data-tab-target="#tab1">
                <p>메뉴</p>
            </div>
            <div class="tab" data-tab-target="#tab2">
                <p>가게정보</p>
            </div>
            <div class="tab" data-tab-target="#tab3">
                <p>리뷰</p>
            </div>
        </div>
    </div>
    <div class="content">
        <div id="tab1" data-tab-content class="items active">
            <div class="tab1_item">
                <img src="/img/item/one/1.jpg" alt="">
                <div class="shopinfo_info">
                    <h2>제육볶음</h2>
                    <h3>멘트??</h3>
                    <p>5000원</p>
                </div>
            </div>
            <div class="tab1_item">
                <img src="/img/item/one/1.jpg" alt="">
                <div class="shopinfo_info">
                    <h2>제육볶음</h2>
                    <h3>멘트??</h3>
                    <p>5000원</p>
                </div>
            </div>

        </div>
        <div id="tab2" data-tab-content class="items">
            <div class="tab2_item">
                <img src="/img/item/one/1.jpg" alt="">
                <div class="shopinfo_info">
                    <h2>${shopInfo.shop_name}</h2>
                    <ul>
                        <li>
                            <h3>전화번호 :</h3>
                        </li>
                        <li>
                            <h3>${shopInfo.shop_phone}</h3>
                        </li>
                    </ul>

                    <ul>
                        <li>
                            <h3>영업시간 :</h3>
                        </li>
                        <li>
                            <h3>${shopInfo.operating_time}</h3>
                        </li>
                    </ul>
                    <ul>
                        <li>
                            <h3>포장여부 :</h3>
                        </li>
                        <li>
                        <c:if test="${shopInfo.takeout == '1'}">
                        	<h3>가능</h3>		
                        </c:if>
                        <c:if test="${shopInfo.takeout == '0'}">
                        	<h3>불가능</h3>
                        </c:if>
                            
                        </li>
                    </ul>
                    <ul>
                        <li>
                            <h3>주소 :</h3>
                        </li>
                        <li>
                            <h3>${shopInfo.address}</h3>
                        </li>
                    </ul>


                </div>
            </div>
        </div>
        <div id="tab3" data-tab-content class="items">
            <div class="tab3_item">
                <h2>최근 리뷰</h2>
                <table>
                    <tr>
                        <th>no.</th>
                        <th>제목</th>
                        <th>별점</th>
                        <th>작성시간</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>테스트 제목</td>
                        <td>별은 몇개</td>
                        <td>테스트 작성시간 </td>
                    </tr>
                </table>

            </div>
        </div>
    </div>
    <!-- <script>
        const tabs = document.querySelectorAll("[data-tab-target]");
        const tabcon = document.querySelectorAll("[data-tab-content]");
        tabs.forEach((tab) => {
            tab.addEventListener("click", () => {
                const target = document.querySelector(tab.dataset.tabTarget);
                tabcon.forEach((tabc_all) => {
                    tabc_all.classList.remove("active");
                });

                target.classList.add("active");
            });
        });

    </script>
		 -->
		
		
	</body>
</html>