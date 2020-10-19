<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<script>
	function goBack(){ 
		window.history.back();
	}
</script>
<body>
	<form action="/psyco/memberShopPro.com" method="post" enctype="multipart/form-data">
		<input type="hidden" name="member_num" value=1>
		<table>
			<tr>
				<td>가게이름</td>
				<td><input type="text" name="shop_name"/></td>
			</tr>
			<tr>
				<td>가게번호</td>
				<td><input type="text" name="shop_phone"/></td>
			</tr>
			<tr>
				<td>영업시간</td>
				<td><input type="text" name="operating_time"/></td>
			</tr>
			<tr>
				<td>가게 주소</td>
				<td><input type="text" name="address"/></td>
			</tr>
			<tr>
				<td>원산지</td>
				<td><input type="text" name="origin"/></td>
			</tr>
			<tr>
				<td>포장 여부</td>
				<td><input type="text" name="takeout" value="1"/></td>
			</tr>
			<tr>
				<td>가게 이미지</td>
				<td><input type="file" name="shop_img"/></td>
			</tr>
			<tr>
				<td>사업자 번호</td>
				<td><input type="text" name="license_number"/></td>
			</tr>
			<input type="submit" value="작성 완료">
			<input type="button" value="뒤로가기" onclick="goBack();">
		</table>
	</form>

</body>
</html>