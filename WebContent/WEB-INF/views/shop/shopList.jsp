<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShopList 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	
	
function onClickItemDelete(shopNum){
	
	var msg = confirm("삭제하시겠습니까? ");
	if(msg == true){
		var apiURL = '/psyco/shop/deleteShop.com';
		console.log(apiURL);

		$.ajax({
	        type: 'POST',
	        url: apiURL,
			data: {shop_num : shopNum},
			success:function (shop_num) {
				var myobj = document.getElementById(shopNum);
				myobj.remove();
	        },
	        error: function (error) {
	            alert('data error');
	        }
	    });	
	}else{
		alert('삭제 취소하셨습니다, ')
	}
	
	

}	
</script>
</head>
<body>




	<h1> Shop 리스트 페이지 </h1>
	
	
	<c:if test="${count == 0}">
		<h2> 가게가 없어요.</h2>
	
	</c:if>
	<c:if test="${count > 0}">
	<h3> table</h3>
	
		<table>
			<tr>	
			<c:forEach var="article" items="${articleList}">
			<tr id = "${article.shop_num}"}>
				<td>${number} <c:set var="number" value="${number-1}" /> </td>	
			<td><a href="/psyco/shop/shopDetail.com?shop_num=${article.shop_num}" >${article.shop_name}</a></td> 
				<td>${article.shop_phone}</td>
				<td>${article.operating_time}</td>
				<td>${article.address}</td>
				
				<td>${article.origin}</td>
				<td>${article.takeout}</td>
				<td>${article.shop_img}</td>
				<td><img alt="" src="/psyco/save//${article.shop_img}"></td>
				<td>${article.license_number}</td>	
				<td>${article.request_time}</td>	
				<td>${article.approve_time}</td>
				<td>${article.status}</td>
				<td>${article.approve_status}</td>	
				<td>${article.member_num}</td>	
				<td><a href="javascript:onClickItemDelete('${article.shop_num}')" >삭제</a>	
				
							
				</td>	
			</tr>
		</c:forEach>		
		</table>
	</c:if>
	
	<%-- 게시판 목록 페이지 번호 뷰어 설정 --%>
	<div align="center">
	<c:if test="${count > 0}">
		<fmt:parseNumber var="res" value="${count / pageSize}"  integerOnly="true"/>
		<c:set var="pageCount" value="${res + (count % pageSize == 0 ? 0 : 1)}"  />
		<c:set var="pageBlock" value="10" />
		<fmt:parseNumber var="result" value="${(currPage-1)/pageBlock}" integerOnly="true" />
		<fmt:parseNumber var="startPage" value="${result * pageBlock + 1}" />
		<fmt:parseNumber var="endPage" value="${startPage + pageBlock - 1}" />
		<c:if test="${endPage > pageCount}">
			<c:set var="endPage" value="${pageCount}" />
		</c:if>
		
		<c:if test="${startPage > pageBlock}">
			<a href="/psyco/shop/shopList.com?pageNum=${startPage-pageBlock}" > &lt; </a>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
			<a href="/psyco/shop/shopList.com?pageNum=${i}" class="pageNums"> &nbsp; ${i} &nbsp; </a>
		</c:forEach>
		<c:if test="${endPage < pageCount}">
			<a href="/psyco/shop/shopList.com?pageNum=${startPage+pageBlock}" > &gt; </a>
		</c:if>
	
	</c:if>
	</div>
	
</body>
</html>