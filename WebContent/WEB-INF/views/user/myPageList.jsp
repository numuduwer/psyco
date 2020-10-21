<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 리스트</title>
</head>
<body>
	<br />
		<h1 align="center"> board </h1>
		<%-- 후기 없을때 --%>
		<c:if test="${count == 0}">
			<table>
				<tr>
					<td> 후기가 없습니다. </td>
				</tr>
			</table>
		</c:if>
		<%-- 후기 있을 때 --%>
		<c:if test="${count > 0}">
		<table>
			<tr>
				<td>No.</td>
				<td>이미지</td>
				<td>제목</td>
				<td>별점</td>
				<td>시  간</td>
			</tr>
			<c:forEach var="article" items="${articleList}">
				<tr>
					<td>${number}
						<c:set var="number" value="${number-1}" />
					</td>
					<td><img src="../save/'${article.menu_img }'" width="80" height="100"></td>
					<td align="left">
						<a href="/psyco/main/content.com?item_num=${article.item_num}&pageNum=${pageNum}" >${article.item_name}</a>
					</td>
					${article.item_name}
					<td>${article.reg}</td>
					<td><input type="button" value="후기작성" onclick="window.location='reviewForm.com?item_num=${article.item_num}&pageNum=${pageNum}'"/></td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
		<br />
		
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
				<a href="/psyco/reivew/reivewList.com?pageNum=${startPage-pageBlock}" > &lt; </a>
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
				<a href="/psyco/reivew/reivewList.com?pageNum=${i}" class="pageNums"> &nbsp; ${i} &nbsp; </a>
			</c:forEach>
			<c:if test="${endPage < pageCount}">
				<a href="/psyco/reivew/reivewList.com?pageNum=${startPage+pageBlock}" > &gt; </a>
			</c:if>
		
		</c:if>
		</div>
	
</body>
</html>



