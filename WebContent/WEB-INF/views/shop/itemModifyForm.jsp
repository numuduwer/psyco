<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글내용</title>

	
</head>
	<body>
	<br/>
		<h1 align="center"> content </h1>
		<form action="/psyco/shop/itemModifyPro.com" method="post">
		<input type="hidden" name="item_num" value="${item_num}" />
		<table align="center">
			<tr>
				<td>음식 이름</td>
				<td><input type="text" name="item_name" value="${article.item_name}"/>   </td>
			</tr>
			<tr>
				<td>상품 판매 여부</td>
				<td><input type="text" name="selling_status" value="${article.selling_status}"/>   </td>
			</tr>
			<tr>
				<td>수량</td>
				<td><input type="text" name="amount" value="${article.amount}"/>   </td>
			</tr>
			<tr>
				<td>할인 주기</td>
				<td><input type="text" name="discount_cycle" value="${article.discount_cycle}"/></td>
			</tr>
			<tr>
				<td>한마디 내용</td>
				<td><textarea rows="5" cols="20"  name="comment1">${article.comment1}</textarea>   </td>
			</tr>
			<tr>
				<td>경매 단위</td>
				<td><input type="text" name="auction_unit" value="${article.auction_unit}"/>  </td>
			</tr>
			<tr>
				<td>경매 시작 시간</td>
				<td><input type="date" name="startDate1" value="${article.startDate}"/> <input type="time" name="startDate2">  </td>
			</tr>
			<tr>
				<td>경매 종료 시간</td>
				<td><input type="date" name="endDate1" value="${article.endDate}"/> <input type="time" name="endDate2">  </td>
			</tr>
			<tr>
				<td>세트메뉴 or 1인</td>
				<td><input type=radio name="sett" value="0" checked/>1인</td>
				<td><input type=radio name="sett" value="1"/>2인 이상 </td>
			</tr>
			<tr>
				<td><input type="submit" value="수정하기" />   </td>
				<td><input type="reset" value="초기화" />   </td>
			</tr>
				</table>
			</form>
			<tr>
				<td colspan="2"> 
					<button onclick="window.location='/psyco/shop/itemDetail.com?item_num=${item_num}'">돌아가기</button>
				 </td>
			</tr>
		
		
	</body>
</html>