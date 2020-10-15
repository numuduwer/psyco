<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>경매 등록</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('input:button[id="btn1"]').click(function(){
				var options = 'width=500, height=600, top=30, left=30, resizeable=yes, scrollbars=yes, location=no';
				window.open('', '', options);
			})
		});
	</script>
</head>
<body>
	<form>
		<div id="wrap">
			<!-- 
				넘어가는 값 : item_name, content, amount, startDate, endDate, discount_cycle, maxPrice, minPrice, aution_unit, sett, comment, menu_num
				sett, menu_num 은 menu 테이블의 레코드 값 가져와서 히든으로 넘겨주자.
			 -->
			<label for="item_name">TITLE</label> <br>
			<input type="text" name="item_name" id="item_name"> <br>
			<label for="content">CONTENT(경매 내용)</label> <br>
			<textarea rows="15" cols="25" name="CONTENT" id="CONTENT"></textarea> <br>
			<label for="menu_name">MENU</label>
			<input type="button" id="btn1" value="메뉴선택"><br>
			<input type="text" id="menu_name" readonly> <br>
			<label for="menu_price">PRICE</label> <br>
			<input type="text" id="menu_price" readonly> <br>
			<label for="menu_content">MENU_EXPLAIN</label> <br>
			<textarea rows="10" cols="20" id="menu_content"></textarea> <br>
			<label for="amount">AMOUNT</label> <br>
			<input type="text" name="amount" id="amount"> <br>
			<label for="startDate">경매 시작 일</label> <br>
			<input type="date" name="startDate" id="startDate"> <br>
			<label for="endDate">경매 종료 일</label> <br>
			<input type="date" name="endDate" id="endDate"> <br>
			<label for="aution_unit">AUTION_UNIT(경매 단위)</label> <br>
			<input type="text" name="aution_unit" id="aution_unit"> <br>
			<label for="maxPrice">최대가격</label> <br>
			<input type="text" name="maxPrice" id="maxPrice" readonly> <br>
			<label for="minPrice">최소가격</label> <br>
			<input type="text" name="minPrice" id="minPrice"> <br>
			
			<label for="discount_cycle">할인 주기</label> <br>
			<input type="text" name="discount_cycle" id="discount_cycle"> <br>
			
		</div>
	</form>
</body>
</html>