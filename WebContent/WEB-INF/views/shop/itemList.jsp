<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>main</title>
</head>
<script type="text/javascript">

$('#btn1').on('click', function(){
    var form = {
            name: "jamong",
            age: 23
    }
    $.ajax({
        url: "/psyco/main.com",
        type: "POST",
        data: form,
        success: function(data){
            $('#result').text(data);
        },
        error: function(){
            alert("simpleWithObject err");
        }
    });
});

</script>
<body>
	
	<h1> 나의 경매 상품 목록</h1>
	
	
	<c:if test="${count == 0}">
		<h2> 가게가 없어요.</h2>
	
	</c:if>
	<c:if test="${count > 0}">
	<h3> table</h3>
	
		<table>
	
			<tr>
				<td>NO.1</td>
				<td>수량</td>
				<td>음식 이름</td>
				<td>상품 판매 여부</td>
				<td>경매 단위</td>
				<td>경매 시작 시간</td>
				<td>경매 종료 시간</td>
				<td>할인주기</td>
				<td>최대가격</td>
				<td>최소가격</td>
				<td>세트메뉴 or 1인</td>
				<td>한마디</td>

			</tr>
			<c:forEach var="article" items="${articleList}">
			<tr>
				<td>${number} <c:set var="number" value="${number-1}" /> </td>	
		
				<td>${article.amount}</td> 
				<td><a href="/psyco/shop/itemDetail.com?item_num=${article.item_num}" >${article.item_name}</a></td>
				<td>${article.selling_status}</td>
				<td>${article.auction_unit}</td>
				<td>${article.startDate}</td>
				<td>${article.endDate}</td>				
				<td>${article.discount_cycle}</td>				
				<td>${article.maxPrice}</td>				
				<td>${article.minPrice}</td>				
				<td>${article.sett}</td>
				<td>${article.comment1}</td>

			</tr>
		</c:forEach>		
		</table>
	</c:if>
	
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
					<a href="/psyco/shop/itemList.com?pageNum=${startPage-pageBlock}" > &lt; </a>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
					<a href="/psyco/shop/itemList.com?pageNum=${i}" class="pageNums"> &nbsp; ${i} &nbsp; </a>
				</c:forEach>
				<c:if test="${endPage < pageCount}">
					<a href="/psyco/shop/itemList.com?pageNum=${startPage+pageBlock}" > &gt; </a>
				</c:if>
			
			</c:if>
		</div>
			
	<button id="bt1"></button>
	<div id="result">
	
	</div>


</body>
</html>