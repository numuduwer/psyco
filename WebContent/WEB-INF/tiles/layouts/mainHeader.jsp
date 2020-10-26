<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
	<div id="logo">
		<h1><a href="/psyco/main/main.com"> 오늘 뭐먹지 ?</a> </h1>
	</div>
</header>


 <!-- ë©ì¸ ë©ë´ -->
<nav id="main_menu">
	<ul class="main_menu_ul">
		<li><a href="/psyco/main/main.com">
			<h2>진행중인 경매 </h2>
		</a></li>
		<li><a href="/psyco/main/endContent.com">
			<h2>완료된 경매 목록 </h2>
		</a></li>
		<li><a href="/psyco/community.com">
			<h2>커뮤니티 </h2>
		</a></li>
		<li><a href="#">
			<h2>고객센터 </h2>
		</a></li>
		<c:if test="${sessionScope.memId == 'admin'}">
		<li><a href="/psyco/super/memberList.com">
			<h2>관리자 페이지 </h2>
		</a></li>
	</c:if>
		
	</ul>
 </nav>