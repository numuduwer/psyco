<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	
	<h1> 나는 메인이다.</h1>
	
	
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
				<td>할인 주기</td>
				<td>경매 단위</td>
				<td>한마디</td>
				<td>세트메뉴 or 1인</td>
				<td>결제 진행여부</td>
				<td>상품 판매여부</td>
			</tr>
			<c:forEach var="article" items="${articleList}">
			<tr>
				<td>${number} <c:set var="number" value="${number-1}" /> </td>	
		
				<td>${article.amount}</td> 
				<td><a href="/psyco/main/shopDetail.com" >${article.item_name}</a></td>
				<td>${article.discount_cycle}</td>
				<td>${article.auction_unit}</td>				
				<td>${article.comment1}</td>
				<td>${article.sett}</td>
				<td>${article.progress_status}</td>
				<td>${article.selling_status}</td>
			</tr>
		</c:forEach>		
		</table>
	</c:if>

	<button id="bt1"></button>
	<div id="result">
	
	</div>

</body>
</html>