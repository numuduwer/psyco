<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center"> 찜 목록 </h1>	
	<table>
	<%-- 찜이 없을 때 --%>
	<c:if test="${count == 0 }">
		<table>
			<tr>
				<td>
					찜한 것이 없습니다.ㅠㅠ
				</td>
			</tr>
		</table>
	</c:if>
	<c:if test="${count > 0 }">
		<table>
			<tr>
				<td>No.</td>
				<td>사    진</td>
				<td>가게이름</td>
			</tr>
			<c:forEach var="article" items="${zzimList}">
				<tr>
					<td>
						<%-- ${number} --%>
						<%-- <c:set var="number" value="${number -1}"></c:set> --%>
					</td>
					
					<td align="left">
					
						<c:set var="wid" value="0"></c:set>
						<c:if test="${article.re_level > 0}">
							<c:set var="wid" value="${8 * article.re_level }"></c:set>
							<img src="/psyco/resources/img/tabImg.PNG" width="${wid}" />
							<img src="/psyco/resources/img/replyImg.png" width="11" />
						</c:if>
						<a href="/psyco/zzimDetail.com?community_num=${article.community_num}&pageNum=${pageNum}">${article.subject}</a>
					</td>
					<td>${article.가게이름}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<%-- 게시판 목록 페이지 번호 뷰어 --%>
	<div align="center">
		<c:if test="${count > 0}">
			<fmt:parseNumber var="res" value="${count / pageSize}" integerOnly="true" />
			<c:set var="pageCount" value="${res + (count % pageSize == 0 ? 0 : 1)}" />
			<c:set var="pageBlock" value="10" />
			<fmt:parseNumber var="result" value="${(pageSize -1)/pageBlock}" integerOnly="true" />
			<fmt:parseNumber var="startPage" value="${result * pageBlock + 1}" />
			<fmt:parseNumber var="endPage" value="${startPage + pageBlock -1}" />
			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}" />
			</c:if>
			
			<c:if test="${startPage > pageBlock}">
				<a href="/psyco/zzim.com?pageNum=${startPage - pageBlock}"> &lt; </a>
			</c:if>
			
			<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
				<a href="/psyco/zzim.com?pageNum=${i}" class="pageNums">&nbsp;${i}&nbsp;</a>
			</c:forEach>
			
			<c:if test="${endPage < pageBlock}">
				<a href="/psyco/zzim.com?pageNum=${startPage + pageBlock}"> &gt; </a>
			</c:if>
			
		</c:if>
	
	</div>
	
	
</body>
</html>