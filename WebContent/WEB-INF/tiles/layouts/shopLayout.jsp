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
    <link href="/psyco/resources/css/userLayout.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@400;600;700&display=swap"
        rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>





<body>
		 	 <div id="top">
            <ul class="login_menu">
                <c:if test="${sessionScope.memId == null}">
                	<li><a href="/psyco/member/loginForm.com">로그인</a></li>
               		<li><a href="/psyco/member/signupSelect.com">회원가입</a></li>               	
               	</c:if>
               	  	
               	
               	<c:if test="${sessionScope.memId != null}">
               		<li><c:out value="${sessionScope.memId}" /> 님 환영합니다.</li>
               		<li><a href="/psyco/member/logout.com">로그아웃</a></li>             
				</c:if>
			</ul>
			<c:if test="${sessionScope.business == 2}">	
			<ul class="shop_menu">
                <li><a href="/psyco/shop/itemEnrollmentForm.com">경매등록</a></li>
                <li><a href="/psyco/shop/shopPageList2.com?member_num=${sessionScope.memNum}">경매 현황</a></li>
                 <li><a href="/psyco/shop/shopPageList.com?member_num=${sessionScope.memNum}">가게 관리</a></li>
            </ul>
         	 </c:if>
        </div>
       <c:if test="${sessionScope.business == 0}">
         	<ul class="shop_signup">
            	<li>사장님이세요?</li>
            	<li><a href="/psyco/member/businessSignupForm.com">가게 등록하러가기</a></li>
        	</ul>
        </c:if>        

 	<tiles:insertAttribute name="tile_header" />
 	<tiles:insertAttribute name="tile_shopHeader" />  
 	
   	<section>
    	<div id="content_box">
        	<tiles:insertAttribute name="tile_body"/>
   		</div>
   </section>
   
   
   
   
   
  	<tiles:insertAttribute name="tile_footer" />  
</body>
</html>