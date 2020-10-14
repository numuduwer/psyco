<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 문의 하기 리스트</title>
</head>
<body>

<body>
	<br />
	<h1 align="center"> ${sessionScope.memId}님 안녕하세요 </h1>
	<%-- 게시글이 없을때 --%>
	<c:if test="${count == 0}">
		<h2 align="center">${sessionScope.memId}님의 문의사항이 없습니다.</h2>
		<table>
			<tr>
				<td> 문의사항이 없습니다. </td>
			</tr>
			<tr>
				<td> <button onclick="window.location='/psyco/helpForm.com'"> 문의 글쓰기 </button> </td>
			</tr>
			<tr>
			<td colspan="6" align="center"> <button onclick="window.location='/psyco/help.com'">문의 리스트 보기 </button> </td>
		</tr>
		</table>
	</c:if>
	<%-- 게시글이 있을때 --%>
	<c:if test="${count == 1}">
	<table>
		<tr>
			<td>No.</td>
			<td>제  목</td>
			<td>작성자</td>
			<td>시  간</td>
			<td>조회수</td>
			
		</tr>
		<c:forEach var="article" items="${list}">
			<tr>
				<td>${number}
					<c:set var="number" value="${number-1}" />
				</td>
				<td align="left">
					<c:set var="wid" value="0" />
					<c:if test="${article.re_level > 0}">
						<c:set var="wid" value="${8 * article.re_level}" />
						<img src="/psyco/resources/img/tabImg.PNG" width="${wid}" />	
						<img src="/psyco/resources/img/replyImg.png" width="11" />
					</c:if>
					<a href="/psyco/myHelpDetail.com?num=${article.num}&pageNum=${pageNum}" >${article.subject}</a>
				</td>
				<td><a href="mailto:${article.writer}">${article.writer}</a></td>
				<td>${article.reg}</td>
				<td>${article.ref}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="center"> <button onclick="window.location='/psyco/help.com'">문의 리스트 보기 </button> </td>
		</tr>
		<tr>
			<td colspan="6" align="center"> <button onclick="window.location='/psyco/helpForm.com'"> 글쓰기 </button> </td>
		
		</tr>
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
			<a href="/psyco/myHelpList.com?pageNum=${startPage-pageBlock}" > &lt; </a>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
			<a href="/psyco/myHelpList.com?pageNum=${i}" class="pageNums"> &nbsp; ${i} &nbsp; </a>
		</c:forEach>
		<c:if test="${endPage < pageCount}">
			<a href="/psyco/myHelpList.com?pageNum=${startPage+pageBlock}" > &gt; </a>
		</c:if>
	
	</c:if>
	</div>
	
</body>
</html>