<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Menu 수정하는 페이지</h1>
	<form action="/psyco/shop/menuModifyPro.com" method="post" enctype="multipart/form-data" >
		<input type="hidden" name="menu_num" value="${article.menu_num}" />
		<input type="hidden" name="category" value="${article.category}" />
		<input type="hidden" name="sett" value="${article.sett}" />
		<input type="hidden" name="shop_num" value="${article.shop_num}" />
		<input type="hidden" name="reg" value="${article.reg}" />
		<table>
			<tr>
				<td>메뉴 이름  </td>
				<td><input type="text" name="menu_name" value="${article.menu_name}" /></td>
			</tr>
			<tr>
				<td>메뉴 내용 </td>
				<td><input type="text" name="content" value="${article.content}" /></td>
			</tr>
			<tr>
				<td>메뉴 이미지 </td>
				<td><input type="file" name="menu_img" value="${article.menu_img}" /></td>
			</tr>
			<tr>
				<td>메뉴 가격 </td>
				<td><input type="text" name="price" value="${article.price}" /></td>
			</tr>
			<tr>
				<td>메뉴 시즌</td>
				<td><input type="text" name="season" value="${article.season}" /></td>
			</tr>
			<tr>
		</table>
		<input type="submit" value="수정" />	
	</form>

</body>
</html>