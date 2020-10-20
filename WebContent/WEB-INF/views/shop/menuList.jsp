<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>menu 리스트 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	
	
function onClickItemDelete(menuNum){
	
	var msg = confirm("삭제하시겠습니까? ");
	if(msg == true){
		var apiURL = '/psyco/shop/deleteMenu.com';
		console.log(apiURL);
		$.ajax({
	        type: 'POST',
	        url: apiURL,
			data: {menu_num : menuNum},
			success:function (menu_num) {
				var myobj = document.getElementById(menuNum);
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




	<h1> Menu 리스트 페이지 </h1>
	
	
	<c:if test="${count == 0}">
		<h2> 메뉴가 없어요.</h2>
	
	</c:if>
	<c:if test="${count > 0}">
	<h3> table</h3>
	
		<table>
			<tr>	
			<c:forEach var="article" items="${articleList}">
			<tr id = "${article.menu_num}">
				<td>${number} <c:set var="number" value="${number-1}" /> </td>	
				<td>${article.menu_name}</td> 
				<td>${article.content}</td>
				<td>${article.menu_img}</td>
				<td>${article.price}</td>	
				<td>${article.category}</td>
				<td>${article.season}</td>
				<td>${article.sett}</td>
				<td><button onclick="window.location='/psyco/shop/menuModify.com?menu_num=${article.menu_num}'">수  정</button></td>
				<td><a href="javascript:onClickItemDelete('${article.menu_num}')" >삭제</a>	
					
			</tr>
		</c:forEach>		
		</table>
	</c:if>
	

	
</body>
</html>
