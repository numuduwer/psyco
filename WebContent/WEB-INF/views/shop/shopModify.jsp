<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>shop정보 수정하는 페이지</h1>
	<h2>${article.approve_status}</h2>
	<form action="/psyco/shop/shopModifyPro.com?pageNum=${pageNum}" method="post" enctype="multipart/form-data">
		<input type="hidden" name="shop_num" value="${article.shop_num}" />
		<input type="hidden" name="takeout" value="${article.takeout}" />
		<input type="hidden" name="address" value="${article.address}" />
		<input type="hidden" name="license_number" value="${article.license_number}" />
		<input type="hidden" name="request_time" value="${article.request_time}" />
		<input type="hidden" name="approve_time" value="${article.approve_time}" />
		<input type="hidden" name="member_num" value="${article.member_num}" />
		<input type="hidden" name="approve_status" value="${article.approve_status}" />
		<input type="hidden" name="shop_img" value="${article.shop_img}" />
		
		<table>
			<tr>
				<td>식 당 </td>
				<td><input type="text" name="shop_name" value="${article.shop_name}" /></td>
			</tr>
			<tr>
				<td> 전화번호  </td>
				<td><input type="text" name="shop_phone" value="${article.shop_phone}" /></td>
			</tr>
			<tr>
				<td> 영업시간 </td>
				<td><input type="text" name="operating_time" value="${article.operating_time}" /></td>
			</tr>
			<tr>
				<td> 주소 </td>
				<td>${article.address}</td>
			</tr>
			<tr>
				<td>원산지</td>
				<td><input type="text" name="origin" value="${article.origin}" /></td>
			</tr>
			<tr>
				<td>가게 사진 </td>
				<td><input type="file" name="shop_img2"  /></td>
			
			</tr>
			<tr>
				<td>상태 </td>
				<td><input type="text" name="status" value="${article.status}" /></td>

			</tr>
			
	
			<tr>
				<td colspan="2">
					<input type="submit" value="수정" />										
					<input type="button" value="리스트 보기" onclick="window.location='/psyco/shop/shopList.com?pageNum=${pageNum}'" />					
				</td>
			</tr>
		</table>
	</form>
	
	
	
</body>
</html>