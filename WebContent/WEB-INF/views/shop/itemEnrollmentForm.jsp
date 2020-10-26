<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>경매 등록</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		function selectMenu(memNum) {
			
			var options = 'width=500, height=600, top=30, left=30, resizeable=yes, scrollbars=yes, location=no';
			window.open('', 'pop', options);
			
			var form = document.frm;
			form.action = "/psyco/shop/MyMenuList.com";
			form.method = "post";
			form.target = 'pop';
			form.submit();
			
			/* var options = 'width=500, height=600, top=30, left=30, resizeable=yes, scrollbars=yes, location=no';
			window.open('/psyco/shop/menuList.com', 'selectMenu', options); */
			
		}
		
		function enrollment(form) {
			var itemData = new Object();
			var item_name = form.item_name.value;
			
			itemData.item_name = form.item_name.value;
			itemData.content = form.content.value;
			itemData.amount = form.amount.value;
			itemData.startDate = form.startDate1.value + " " + form.startDate2.value + ":00";
			itemData.endDate = form.endDate1.value + " " + form.endDate2.value + ":00";
			itemData.discount_cycle = form.discount_cycle.value;
			itemData.maxPrice = form.maxPrice.value;
			itemData.minPrice = form.minPrice.value;
			itemData.auction_unit = form.aution_unit.value;
			itemData.sett = form.sett.value;
			itemData.comment = form.menu_content.value;
			itemData.menu_num = form.menu_num.value;
			itemData.shop_num = form.shop_num.value;
			
			var jsonData = JSON.stringify(itemData);
			console.log(jsonData);
			
			$.ajax({
				url: "/psyco/shop/itemEnrollmentPro.com",
				type: "post",
				dataType: "text",
				data: jsonData,
				contentType: "application/json; charset=UTF-8",
				success: function(result) {
					console.log(result);
					alert('등록 되었습니다.');
					window.location.href='/psyco/shop/itemList.com';
				},
				error: function() {
					
				}
			});
		}
	
	</script>
</head>
<body>
	<form name="frm" align = "center">
		<div id="wrap">
		<br><br><br><br>
			<!-- 
				넘어가는 값 : item_name, content, amount, startDate, endDate, discount_cycle, maxPrice, minPrice, aution_unit, sett, comment, menu_num
				sett, menu_num 은 menu 테이블의 레코드 값 가져와서 히든으로 넘겨주자.
			 -->
			<label for="item_name">TITLE</label> <br>
			<input type="text" name="item_name" id="item_name"> <br> <br>
			<label for="content">CONTENT(경매 내용)</label> <br>
			<textarea rows="15" cols="25" name="content" id="content"></textarea> <br> <br>
			<label for="menu_name">MENU</label>
			<input type="button" id="btn1" value="메뉴선택" onclick="javascript:selectMenu(${sessionScope.memNum})"><br>
			<input type="text" id="menu_name" readonly> <br> <br>
			<label for="menu_price">PRICE</label> <br>
			<input type="text" id="menu_price" readonly> <br> <br>
			<label for="menu_content">MENU_EXPLAIN</label> <br>
			<textarea rows="10" cols="20" id="menu_content"></textarea> <br>
			<label for="amount">AMOUNT</label> <br>
			<input type="text" name="amount" id="amount"> <br>
			<label for="startDate">경매 시작 일</label> <br>
			<input type="date" name="startDate1" id="startDate1"> <input type="time" name="startDate2" id="startDate2">  <br>
			<label for="endDate">경매 종료 일</label> <br>
			<input type="date" name="endDate1" id="endDate1"> <input type="time" name="endDate2" id="endDate2"><br>
			<label for="auction_unit">AUTION_UNIT(경매 단위 - 가격)</label> <br>
			<input type="text" name="aution_unit" id="auction_unit"> <br>
			<label for="maxPrice">최대가격</label> <br>
			<input type="text" name="maxPrice" id="maxPrice" readonly> <br>
			<label for="minPrice">최소가격</label> <br>
			<input type="text" name="minPrice" id="minPrice"> <br>
			<label for="discount_cycle">할인 주기(시간)</label> <br>
			<select id="discount_cycle" name="discount_cycle">
				<option value="300">5분</option>
				<option value="600">10분</option>
				<option value="1000">30분</option>
			</select> <br>
			<label for="sett">세트 여부<input type="checkbox" id="sett" value="1"></label> <br>		
			<img alt="이미지를 삽입해주세요" src="" id="menu_img"> <br>
			<input type="button" value="저장" onclick="javascript:enrollment(this.form);">
			
			<input type="hidden" id="menu_num" value="">
			<input type="hidden" id="shop_num" value="">
		</div>
	</form>
</body>
</html>