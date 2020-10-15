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
	
	
	<c:if test="${count == 0}">

		<h1 align="center">작성된 글이 없습니다.</h1>
	</c:if>

	<c:if test="${category == 1}">
	<h1 align="center"> 자유게시판 페이지</h1>
	<table>
		<tr>
			<td colspan="6" align="center"> <button onclick="window.location='/psyco/communityForm.com?category=1&grade=11&pageNum=${pageNum}'"> 글쓰기 </button> </td>
		
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
					<c:if test="${article.re_level > 0}">
						<c:set var="wid" value="${8 * article.re_level}" />
						<img src="/psyco/resources/img/tabImg.PNG" width="${wid}" />	
						<img src="/psyco/resources/img/replyImg.png" width="11" />
					</c:if>
					<a href="/psyco/communityDetail.com?community_num=${article.community_num}&pageNum=${pageNum}&category=1" >${article.subject}</a>
				</td>
				<td><a href="mailto:${article.writer}">${article.writer}</a></td>
				<td>${article.reg}</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	
	<br />
	<c:if test="${category == 2}">
	<h1 align="center"> QnA 페이지</h1>
	<table>
		<tr>
			<td colspan="6" align="center"> <button onclick="window.location='/psyco/communityForm.com?category=2&grade=11&pageNum=${pageNum}'"> 글쓰기 </button> </td>
			<td colspan="6" align="center"> <button onclick="window.location='/psyco/help.com?category=5&grade=11&pageNum=1'"> 고객센터 </button> </td>		
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
					<c:if test="${article.re_level > 0}">
						<c:set var="wid" value="${8 * article.re_level}" />
						<img src="/psyco/resources/img/tabImg.PNG" width="${wid}" />	
						<img src="/psyco/resources/img/replyImg.png" width="11" />
					</c:if>
					<a href="/psyco/communityDetail.com?community_num=${article.community_num}&pageNum=${pageNum}&category=2" >${article.subject}</a>
				</td>
				<td><a href="mailto:${article.writer}">${article.writer}</a></td>
				<td>${article.reg}</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	
	<c:if test="${category == 3}">
	<h1 align="center"> 홍보 페이지 </h1>
	<table>
		<tr>
			<td colspan="6" align="center"> <button onclick="window.location='/psyco/communityForm.com?category=3&grade=11&pageNum=${pageNum}'"> 글쓰기 </button> </td>
		
		</tr>
		<tr>
			<td>No.</td>
			<td>제  목</td>
			<td>작성자</td>
			<td>시  간</td>
			<td>사 진 </td>

		</tr>
		<c:forEach var="article" items="${articleList}">
		
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
					<a href="/psyco/communityDetail.com?community_num=${article.community_num}&pageNum=${pageNum}&category=3" >${article.subject}</a>
				</td>
				<td><a href="mailto:${article.writer}">${article.writer}</a></td>
				<td>${article.reg}</td>	
				<td><img src="/psyco/save//${article.community_img}" width=200></td>	
			</tr>
		</c:forEach>

	</table>
	</c:if>
	<br />
	
	<c:if test="${category == 4}">
	<h1 align="center"> 음식점 추천 페이지</h1>
	<table>
		<tr>
			<td colspan="6" align="center"> <button onclick="window.location='/psyco/communityForm.com?category=4&grade=11&pageNum=${pageNum}'"> 글쓰기 </button> </td>
		
		</tr>
		<tr>
			<td>No.</td>
			<td>제  목</td>
			<td>작성자</td>
			<td>시  간</td>
			<td>사  진</td>

		</tr>
		<c:forEach var="article" items="${articleList}">
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
					<a href="/psyco/communityDetail.com?community_num=${article.community_num}&pageNum=${pageNum}&category=4" >${article.subject}</a>
				</td>
				<td><a href="mailto:${article.writer}">${article.writer}</a></td>
				<td>${article.reg}</td>
				<td><img src="/psyco/save//${article.community_img}" width=200></td>
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
					<a href="/psyco/communityList.com?pageNum=${startPage-pageBlock}&category=${category}" > &lt; </a>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
					<a href="/psyco/communityList.com?pageNum=${i}&category=${category}" class="pageNums"> &nbsp; ${i} &nbsp; </a>
				</c:forEach>
				<c:if test="${endPage < pageCount}">
					<a href="/psyco/communityList.com?pageNum=${startPage+pageBlock}&category=${category}" > &gt; </a>
				</c:if>
			
			</c:if>
			</div>
	
</body>
</html>