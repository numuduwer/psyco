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
	<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=bsd4urkj6r"></script>
	<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=bsd4urkj6r&submodules=geocoder"></script>
	<script type="text/javascript">
		 $(document).ready(function(){
			
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
		 })

	
		function getItemList(sett) {
			console.log(sett);
			
			$.ajax({
				url: "/psyco/main/getItemList.com",
				type: "post",
				data: {sett : sett},
				success: function(data) {
					console.log("data는 : " + data);
				},
				error: function() {
					console.log('ajax 실패!');
				}
				
			});
		}
		
	 function mapCreate(latitude, longitude) {
			var mapOptions = {
					center: new naver.maps.LatLng(latitude, longitude),
					zoom: 10,
					mapTypeId: naver.maps.MapTypeId.NORMAL
			}
			
			var map = new naver.maps.Map('map', mapOptions);
			return map;
		}
		
		function onSuccessGeolocation(position) {
		    var location = new naver.maps.LatLng(position.coords.latitude,
		                                         position.coords.longitude);
		    
		    console.log("latitude :" + position.coords.latitude);
		    console.log("longitude: " + position.coords.longitude);
			
		    var infowindow = new naver.maps.InfoWindow();
	
		    infowindow.setContent('<div style="padding:20px;">' + 'geolocation.getCurrentPosition() 위치' + '</div>');
	
		    console.log('Coordinates: ' + location.toString());
		    
		    reverseGeocode(position.coords.latitude, position.coords.longitude);
		     
		}
	
		function onErrorGeolocation() {
		    var center = map.getCenter();
	
		    infowindow.setContent('<div style="padding:20px;">' +
		        '<h5 style="margin-bottom:5px;color:#f00;">Geolocation failed!</h5>'+ "latitude: "+ center.lat() +"<br />longitude: "+ center.lng() +'</div>');
	
		    infowindow.open(map, center);
		}
		
		function geocode() {
			var query = { query : $("#address").val() };
			console.log(query);
			
			naver.maps.Service.geocode(query, function(status, response) {
				if (status !== naver.maps.Service.Status.OK) {
					return alert('Something wrong!');
				}
				
				var v2 = response.v2,
					addresses = v2.addresses;
				
				console.log(addresses);
				
				var latitude = addresses[0].y,		// ex : 37.5438733
					longitude = addresses[0].x;		// ex : 127.0681978
				
			});
		}
		
		function reverseGeocode(latitude, longitude) {
			naver.maps.Service.reverseGeocode({
		        coords: new naver.maps.LatLng(latitude, longitude),
		    }, function(status, response) {
		        if (status !== naver.maps.Service.Status.OK) {
		            return alert('Something wrong!');
		        }

		        var result = response.v2, // 검색 결과의 컨테이너
		            items = result.results, // 검색 결과의 배열
		            address = result.address; // 검색 결과로 만든 주소

		        document.getElementById('address').value = address.jibunAddress;
		    });
		}
		
		function locationSetting() {
			if (navigator.geolocation) {
				console.log(navigator.geolocation);
				navigator.geolocation.getCurrentPosition(onSuccessGeolocation, onErrorGeolocation);
			} else {
				var center = map.getCenter();
		        infowindow.setContent('<div style="padding:20px;"><h5 style="margin-bottom:5px;color:#f00;">Geolocation not supported</h5></div>');
		        infowindow.open(map, center);
			}
		}
		
	</script>
</head>


<body>

    <!--  검색베너  & 신메뉴 , 랭킹미리보기 -->
    <section id="banner_section">
      
        <div id="banner">
            <img src="/psyco/resources/img/main/banner.png" alt="">
        </div>
	    <div>
			<input type="button" value="현재 위치 설정" onclick="javascript:locationSetting();"/>
			<input type="text" name="address" id="address">
			<input type="button" value="검색" onclick="javascript:geocode();">
		</div>
 
    </section>
    <!-- 경매 카테고리 -->
    <section id="category">
        <ul>
        	<li><a href="/psyco/main/main.com?menuDivision=0">전체 메뉴</a></li>
            <li><a href="/psyco/main/main.com?menuDivision=1">1인 메뉴</a></li>
            <li><a href="/psyco/main/main.com?menuDivision=2">세트 메뉴</a></li>
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
        			<c:choose>
        				<c:when test="${item.progress_status == 1 && item.selling_status == 4}">
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
		        			<ul class="price">
		        				<li>종료된 경매 입니다.</li>
		        			</ul>
	       				</c:when>
        				<c:when test="${item.progress_status == 2 && item.selling_status == 1 }">
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
		        			<ul class="price">
		        				<li>경매 시간 전입니다.</li>
		        			</ul>
        				</c:when>
        				<c:when test="${item.progress_status == 0 && item.selling_status == 3}">
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
		     					<li>현재 가격</li>
		     					<li>${item.current_price}원</li>
		     					<li>남은 시간</li>
		     					<li id="remainder_time${item.itemList.item_num}">${item.remainder_time}분</li>
		        			</ul>
        				</c:when>
        			</c:choose>
        			
        		</div>
        	</div> 
        </c:forEach>
        </div>
   
    </section>

</body>
</html>