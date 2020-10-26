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
	   <!-- 경매 상품 -->
    <section class="item-section">
        <div class="admin">
            <ul class="admin_btn2">
                <li><a href="/psyco/super/memberList.com">회원관리</a></li>
                <li><a href="/psyco/super/shopEnrollList.com">서비스 등록 현황</a></li>
                <li><a href="/psyco/super/shopList.com">가게관리</a></li>
                <li><a href="/psyco/help.com">문의하기 관리</a></li>
            </ul>
        </div>
    </section>
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
	<div class="admin_content2">
		<br><br>
	<h2> 고객 문의 리스트   </h2>
		<br>
		<table>
			<tr>
				<th>No.</th>
				<th>제  목</th>
				<th>작성자</th>
				<th>시  간</th>
				<th>조회수</th>
				<th>처리 여부  </th>
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
					<td>${article.ref}</td>
					<c:if test="${article.re_level > 0}">
						<td class= "admin_delete">처리완료</td>	
					</c:if>
					<c:if test="${article.re_level == 0}">
						<td >확인 중 </td>	
					</c:if>
				
				</tr>
			</c:forEach>
		</table>
	<br><br><br>
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
	<br>
	</div>
	<br>
		</div>
	</c:if>

	
	
</body>
</html>
