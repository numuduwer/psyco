<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="/psyco/resources/css/mainLayout.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@400;600;700&display=swap"
        rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>





<body>
	 <div id="top">
            <ul class="login_menu">
                <li><a href="#">고객센터</a></li>
                <c:if test="${sessionScope.memId == null}">
                <li><a href="/psyco/member/loginForm.com">로그인</a></li>
               	<li><a href="/psyco/member/signupSelect.com">회원가입</a></li>
               	</c:if>
               	
               	<c:if test="${sessionScope.memId != null}">
               		<li><a href="/psyco/member/logout.com">로그아웃</a></li>
               		<li><c:out value="${sessionScope.memId}" /> 님 환영합니다.</li>
               		<li><a href="/psyco/user/myPageList.com">마이페이지</a></li>
				</c:if>
				 	<c:if test="${sessionScope.shopCheck != null}">
               		  <li><a href="/psyco/shop/shopPageList.com?member_num=${sessionScope.memNum}">내 가게 관리가기</a></li>
             		  <li><a href="/psyco/shop/shopPageList2.com">경매상품 올리기 </a></li>     		

				</c:if>
				
            </ul>
        </div>

 	<tiles:insertAttribute name="tile_header" />  
   	<section>
    	<div id="content_box">
        	<tiles:insertAttribute name="tile_body"/>
   		</div>
   </section>
   
  	<tiles:insertAttribute name="tile_footer" />  

</body>
</html>