<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>myMenuList</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		function pushMenuInfo(menu_num) {
			$.ajax({
				url: "/psyco/shop/getMenuInfoFromMenuNum.com",
				type: "post",
				dataType: "json",
				data: {"menu_num": menu_num},
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				success: function(result) {
					console.log(result);
					window.opener.document.getElementById("menu_name").value = result.menu_name;
					window.opener.document.getElementById("menu_price").value = result.price;
					$("#menu_content", opener.document).val(result.content);
					$("#maxPrice", opener.document).val(result.price);
					$("#menu_img", opener.document).attr("src", result.menu_img);
					$("#menu_num", opener.document).val(result.menu_num);
					$("#shop_num", opener.document).val(result.shop_num);
					window.close();
				},
				error : function() {
					
				}
			});
			
			
			/* var menu_name = $("#menu_name"+idx).text();
			var menu_content = $("#menu_content"+idx).text();
			var menu_price = $("#menu_price"+idx).text();
			
			window.opener.document.getElementById("menu_name").value = menu_name;
			window.opener.document.getElementById("menu_content").value = menu_content;
			window.opener.document.getElementById("menu_price").value = menu_price; */
		}
	</script>
</head>
<body>
	<div class="myMenuList">
		<table border="1">
			<tr>
				<td>사진</td>
				<td>이름</td>
				<td>내용 </td>
				<td>가격</td>
				<td>선택란</td>
			</tr>
			<c:forEach var="menu" items="${menuList}" varStatus="status">
			<tr>
				<td><img src="/psyco/save/${menu.menu_img}"></td>
				<td>${menu.menu_name}</td>
				<td>${menu.content}</td>
				<td>${menu.price}</td>
				<td><input type="button" value="선택" onclick="pushMenuInfo(${menu.menu_num})"></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>