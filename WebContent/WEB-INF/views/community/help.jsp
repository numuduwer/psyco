<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center"> 고객센터 </h1>	
	<table>
		<tr>
			<td>
				<button onclick="window.location='/psyco/helpForm.com'"> 문의하기 </button> <br/>
			</td>
		</tr>
		<tr>
			<td>
				<button onclick="window.location='/psyco/myHelpList.com?category=5'"> 내 문의 리스트 </button> <br/>
			</td>
		</tr>
	</table>
	
	<br /><br />
	
	<%-- 게시글이 없을 때 --%>
	<c:if test="${map.count == 0 }">
		<table>
			<tr>
				<td>
					게시글이 없습니다.
				</td>
			</tr>
		</table>
	</c:if>
	<c:if test="${map.count > 0 }">
		<table>
			<tr>
				<td>No.</td>
				<td>제  목</td>
				<td>작성자</td>
				<td>시  간</td>
				<td>조회수</td>
			</tr>
			<c:forEach var="article" items="${map.helpList}">
				<tr>
					<td>
						${map.number}
					</td>						
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
					<td>${article.ref}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
		<%-- 게시판 목록 페이지 번호 뷰어 설정 --%>
			<div align="center">
			<c:if test="${map.count > 0}">
				<fmt:parseNumber var="res" value="${map.count / map.pageSize}"  integerOnly="true"/>
				<c:set var="pageCount" value="${res + (map.count % map.pageSize == 0 ? 0 : 1)}"  />
				<c:set var="pageBlock" value="10" />
				<fmt:parseNumber var="result" value="${(map.currPage-1)/pageBlock}" integerOnly="true" />
				<fmt:parseNumber var="startPage" value="${result * pageBlock + 1}" />
				<fmt:parseNumber var="endPage" value="${startPage + pageBlock - 1}" />
				<c:if test="${endPage > pageCount}">
					<c:set var="endPage" value="${pageCount}" />
				</c:if>
				
				<c:if test="${startPage > pageBlock}">
					<a href="/psyco/help.com?pageNum=${startPage-pageBlock}&category=${category}" > &lt; </a>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
					<a href="/psyco/help.com?pageNum=${i}&category=${category}" class="pageNums"> &nbsp; ${i} &nbsp; </a>
				</c:forEach>
				<c:if test="${endPage < pageCount}">
					<a href="/psyco/help.com?pageNum=${startPage+pageBlock}&category=${category}" > &gt; </a>
				</c:if>
			
			</c:if>
			</div>
	
	
</body>
</html>
