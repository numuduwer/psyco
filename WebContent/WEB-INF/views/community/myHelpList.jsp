<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 문의 글</title>
</head>
<body>
	<h1 align="center"> 나의 문의 글 </h1>	
	<table>
		<tr>
			<td>
				<button onclick="window.location='/psyco/helpForm.com'"> 문의하기 </button> <br/>
			</td>
		</tr>
	</table>
	
	<br /><br />
	
	<%-- 게시글이 없을 때 --%>
	<c:if test="${count == 0 }">
		<table>
			<tr>
				<td>
					게시글이 없습니다.
				</td>
			</tr>
		</table>
	</c:if>
	<c:if test="${count > 0 }">
		<table>
			<tr>
				<td>No.</td>
				<td>제  목</td>
				<td>작성자</td>
				<td>작성 시간</td>
			</tr>
			<c:forEach var="article" items="${articleList}">
				<tr>
					<td>${number} <c:set var="number" value="${number-1}" /> </td>				
					<td align="left">
					
						<c:set var="wid" value="0"></c:set>
						<c:if test="${article.re_level > 0}">
							<c:set var="wid" value="${8 * article.re_level }"></c:set>
							<img src="/psyco/resources/img/tabImg.PNG" width="${wid}" />
							<img src="/psyco/resources/img/replyImg.png" width="11" />
						</c:if>
						<a href="/psyco/helpDetail.com?community_num=${article.community_num}&pageNum=${pageNum}">${article.subject}</a>
					</td>
					<td><a href="mailto:${article.writer}">${article.writer}</a></td>
					<td><fmt:formatDate value="${article.reg}" type="both"/></td>
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
			<a href="/psyco/myHelpList.com?pageNum=${startPage-pageBlock}&category=${category}" > &lt; </a>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
			<a href="/psyco/myHelpList.com?pageNum=${i}&category=${category}" class="pageNums"> &nbsp; ${i} &nbsp; </a>
		</c:forEach>
		<c:if test="${endPage < pageCount}">
			<a href="/psyco/myHelpList.com?pageNum=${startPage+pageBlock}&category=${category}" > &gt; </a>
		</c:if>
	
	</c:if>
	</div>
	
	
</body>
</html>
