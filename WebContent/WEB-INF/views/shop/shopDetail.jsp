<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 리스트디테일 페이지</h1>
	
	<div>
		<h3>[shop_name]</h3>
		${article.shop_name}
	</div>
	<div>
		<h3>[shop_num]</h3>
		${article.shop_num}
	</div>
	<div>
		<h3>[shop_num]</h3>
		${article.approve_status}
	</div>
	<button onclick="window.location='/psyco/shop/shopModify.com?shop_num=${article.shop_num}'">수  정</button>

</body>
</html>