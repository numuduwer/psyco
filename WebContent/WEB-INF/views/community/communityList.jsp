<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판</title>
</head>

<body>
	<br />
	<h1 align="center">님 안녕하세요 </h1>
	<%-- 게시글이 없을때 --%>
	<c:if test="${count == 0}">
		<h2 align="center">님 글 쓰세요</h2>
		<table>
			<tr>
				<td> <button onclick="window.location='/spring/board/writeForm.com'"> 글쓰기 </button> </td>
			
			</tr>
			<tr>
				<td> 게시글이 없습니다. </td>
			</tr>
		</table>
	</c:if>
	<%-- 게시글이 있을때 --%>
	<c:if test="${count == 1}">
	<table>
		<tr>
			<td colspan="6" align="center"> <button onclick="window.location='/psyco/communityForm.com'"> 글쓰기 </button> </td>
		
		</tr>
		<tr>
			<td>No.</td>
			<td>제  목</td>
			<td>작성자</td>
			<td>시  간</td>

		</tr>
		<c:forEach var="article" items="${articleList}">
			<tr>
				<td>${number}
					<c:set var="number" value="${number-1}" />
				</td>
				<td align="left">
					<c:set var="wid" value="0" />
					<c:if test="${article.RE_LEVEL > 0}">
						<c:set var="wid" value="${8 * article.RE_LEVEL}" />
						<img src="/spring/resources/img/tabImg.PNG" width="${wid}" />	
						<img src="/spring/resources/img/replyImg.png" width="11" />
					</c:if>
					<a href="/spring/board/content.git?community_num=${article.COMMUNITY_NUM}&pageNum=${pageNum}" >${article.SUBJECT}</a>
				</td>
				<td><a href="mailto:${article.WRITER}">${article.WRITER}</a></td>
				<td>${article.REG}</td>

				
			
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
			<a href="/spring/board/list.git?pageNum=${startPage-pageBlock}" > &lt; </a>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
			<a href="/spring/board/list.git?pageNum=${i}" class="pageNums"> &nbsp; ${i} &nbsp; </a>
		</c:forEach>
		<c:if test="${endPage < pageCount}">
			<a href="/spring/board/list.git?pageNum=${startPage+pageBlock}" > &gt; </a>
		</c:if>
	
	</c:if>
	</div>
	
</body>
</html>