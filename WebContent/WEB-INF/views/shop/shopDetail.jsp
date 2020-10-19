<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 가게 상세 페이지</h1>
	
	<h2>가게 정보들 쫘악 나온다.</h2>
	<h3>
	<strong> 가게 메뉴 </strong>
	<button onclick="window.location='/psyco/shop/menuList.com?shop_num=${article.shop_num}&pageName=menuList'">가게 메뉴판</button>
	</h3>
	<button onclick="window.location='/psyco/shop/shopModify.com?shop_num=${article.shop_num}'">수정</button>

</body>
</html>