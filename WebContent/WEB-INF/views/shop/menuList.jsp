 q<%@ page language="java" contentType="text/html; charset=UTF-8"%>
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
  <!--  기능  타이틀 -->
    <div class="myPage_mainTitle">
        <h1>사장님 마이페이지</h1>

        <div class="myPage_shopTitle ">
            <h2 class="myPage_subTitle">내 메뉴  관리하기 </h2>
        </div>
    </div>
      <div id="tab5" data-tab-content class="items active">


	<c:if test="${count == 0}">
		<h2> 메뉴가 없어요.</h2>
	<br><br>	

		
		<ul class="shop_menu2">
			<li><a href="/psyco/member/menuSignupForm.com?shop_num=${param.shop_num}&member_num=${sessionScope.memNum}">메뉴  등록하기   </a></li>
			<li> <a href="javascript:history.back();">돌아가기 </a>  </li>
		</ul>
			
	</c:if>
	<c:if test="${count > 0}">
	   
		<div class="admin_content2">
		<br><br>	

		
		<ul class="shop_menu2">
				<li><a href="/psyco/member/menuSignupForm.com?shop_num=${param.shop_num}&member_num=${sessionScope.memNum}">메뉴  등록하기   </a></li>
			<li> <a href="javascript:history.back();">돌아가기 </a>  </li>
		</ul>
			
			<br>
	

                   
		<table>
			<tr>
				<th>메뉴 명</th>
				<th>메뉴 소개 </th>
				<th>메뉴 가격  </th>
				<th>세트 여부  </th>
				<th>계절 메뉴  </th>
				<th>수정  </th>
				<th>삭제   </th>
			</tr>
			<c:forEach var="article" items="${articleList}">
			<tr id = "${article.menu_num}">
				<td>${article.menu_name}</td> 
				<td>${article.content}</td>
				<td>${article.price}</td>	
				<td>${article.season}</td>
				<td>${article.sett}</td>
				<td><button onclick="window.location='/psyco/shop/menuModify.com?menu_num=${article.menu_num}'">수  정</button></td>
				<td><a href="javascript:onClickItemDelete('${article.menu_num}')" >삭제</a>		
			</tr>
		</c:forEach>		
		</table><br><br><br>
		</div>
	</c:if>
	
</div>
	
</body>
</html>
