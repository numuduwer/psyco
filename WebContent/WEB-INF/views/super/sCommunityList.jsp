<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 & 헬프 관리 페이지</title>


<script>
	
	
$("a").click(function(e){
	event.stopPropagation();
	
});
	
</script>



</head>
<body>




	
	
	<c:if test="${count == 0}">
		<h2>글이 없어요.</h2>
	
	</c:if>
	<c:if test="${count > 0}">
		<table>
			<tr>
			
			
			<c:forEach var="article" items="${articleList}">
			
			<tr>
				<td>${number} <c:set var="number" value="${number-1}" /> </td>
				<td>${article.subject}</td>
				
				<td>${article.writer}</td>
				<td>${article.grade}</td>
				
				<td>${article.community_img}</td>
				<td>${article.confirm}</td>
				<td><a href="/psyco/super/sShopDelete.com?pageNum=${pageNum}&shop_num=${article.community_num}">삭제</a></td>
			
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
			<a href="/psyco/super/memberList.com?pageNum=${startPage-pageBlock}" > &lt; </a>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
			<a href="/psyco/super/memberList.com?pageNum=${i}" class="pageNums"> &nbsp; ${i} &nbsp; </a>
		</c:forEach>
		<c:if test="${endPage < pageCount}">
			<a href="/psyco/super/memberList.com?pageNum=${startPage+pageBlock}" > &gt; </a>
		</c:if>
	
	</c:if>
	</div>
	
</body>
</html>