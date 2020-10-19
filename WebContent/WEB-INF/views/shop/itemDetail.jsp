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
		<table align="center">
			<tr>
				<td width="80">음식 이름</td>
				<td colspan="2"align="center" >${article.item_name}   </td>
			</tr>
			<tr>
				<td>상품 판매 여부</td>
				<td colspan="2"align="center" >${article.selling_status}   </td>
			</tr>
			<tr>
				<td>수량</td>
				<td colspan="2"align="center" >${article.amount}   </td>
			</tr>
			<tr>
				<td>한마디 내용</td>
				<td colspan="2"align="center" >${article.comment1}   </td>
			</tr>
			<tr>
				<td>경매 단위</td>
				<td colspan="2"align="center" >${article.auction_unit}   </td>
			</tr>
			<tr>
				<td>경매 시작 시간</td>
				<td colspan="2"align="center" >${article.startDate}   </td>
			</tr>
			<tr>
				<td>경매 종료 시간</td>
				<td colspan="2"align="center" >${article.endDate}   </td>
			</tr>
			<tr>
				<td>최대가격</td>
				<td colspan="2"align="center" >${article.maxPrice}   </td>
			</tr>
			<tr>
				<td>최소가격</td>
				<td colspan="2"align="center" >${article.minPrice}   </td>
			</tr>
			<tr>
				<td>세트메뉴 or 1인</td>
				<td colspan="2"align="center" >${article.sett}   </td>
			</tr>
			<tr>
				<td colspan="2"> 
					<button onclick="window.location='/psyco/shop/itemModifyForm.com?pageNum=${pageNum}&item_num=${item_num}'">수정 하로 가기</button>
					<button onclick="window.location='/psyco/shop/itemDeleteForm.com?community_num=${community_num}&pageNum=${pageNum}&item_num=${item_num}'">삭 제</button>
					<button onclick="window.location='/psyco/shop/itemForm.com?pageNum=${pageNum}'">답 글</button>
					<button onclick="window.location='/psyco/shop/itemList.com?pageNum=1'">돌아가기</button>
				 </td>
			</tr>
		
		
		</table>
	</body>
</html>