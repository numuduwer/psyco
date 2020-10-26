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
	<script type="text/javascript">
		$(document).ready(function(){
			
			$.ajax({
				url: "/psyco/main/getListData.com",
				type: "post",
				dataType: "json",
				contentType: "application/json; charset=UTF-8",
				success: function(result) {
					var array = new Array(result);
					console.log(array);
					console.log(array[0]);
					console.log(typeof(array[0][0].itemList));
					
					for (var i in array[0]) {
						var itemList = JSON.parse(array[0][i].itemList);
						
						var html = '<div class="card">' +
		        		'<div class="card_content">' +
		        			'<h3 id="shop_name"></h3>' +
		        			'<h2 id="item_name"></h2>' +
		        			'<ul>' +
		        				'<li>시작 시간</li>' +
		        				'<li id="startDate"></li>' +
		        			'</ul>' +
		        			'<ul>' +
		        				'<li>종료 시간</li>' +
		        				'<li id="endDate"></li>' +	
		        			'</ul>' +
		        			'<ul>' +
		        				'<li>자동 할인시간</li>' +
		        				'<li id="discount_cycle"></li>' +
		        			'</ul>' +
		        			'<ul>' +
		        				'<li>시작 가격</li>' +
		        				'<li id="maxPrice"></li>' +
		        			'</ul>' +
		        			'<ul>' +
		        				'<li>최저 가격</li>' +
		        				'<li id="minPrice"></li>' +
		        			'</ul>'
		        			'<ul class="sale">' +
		        				'<li class="sale_item"></li>' +
		        				'<li></li>' +
		        			'</ul>' +
		        			'<ul class="price">' +
		        			'</ul>' +
		        		'</div>' +
		        	'</div>';
			        	
						$('.card-container').append(html);
						
						$('#shop_name').text(itemList.shop_name);
						$('#item_name').text(itemList.item_name);
						$('#startDate').text(itemList.startDate);
						$('#endDate').text(itemList.endDate);
						$('#discount_cycle').text(itemList.discount_cycle);
						$('#maxPrice').text(itemList.maxPrice);
						$('#minPrice').text(itemList.minPrice);
						
					}
					
					
				},
				error: function() {
					
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
            <li><a href="">1인 메뉴</a></li>
            <li><a href="">세트 메뉴</a></li>
        </ul>

    </section>

    <!-- 경매 상품 -->
    <section class="item-section">
        <div class="card-container">
            <c:forEach var="article" items="${articleListD}">
            	<div class="card">
            		<img src="/psyco/resources/img/item/one/1.jpg" alt="" class="card_img">
            		<div class="card_content">
            			<h3>${article.price}</h3>
                 		<h2>${article.amount}</h2>
                 	</div>
            	</div>
            </c:forEach>	
		</div>
        
    </section>

</body>
</html>