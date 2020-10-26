<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글내용</title>

	
</head>
	<body>
<!--  검색베너  & 신메뉴 , 랭킹미리보기 -->
    <section id="banner_section">
      
        <div id="banner">
            <img src="/psyco/resources/img/main/community.jpg" alt="">
        </div>
 
    </section>
	<br/>
<div class="admin_content">
		<table align="center">
			<tr >
				<th width="80">제 목 </th>
				<td colspan="20" align="center" > ${article.subject}  </td>
			</tr>
			<tr>
			<th> 작성자 </th> 
			<td>
			 <a href="mailto:${article.writer}">${article.writer}</a>
			 </td>
			</tr>
			<tr>
				<th>작성 내용</th>
				<td colspan="2"align="center" height="300">${article.content}   </td>
	
			</tr>
			<c:if test="${category == 3 || category == 4}">
				<tr>
					<td><img src="/psyco/save//${article.community_img}" width="400"></td>
				</tr>
			</c:if>

				<tr>
					<td>댓글</td>
					<td>댓글내용</td>
					<td>작성자</td>
				</tr>
				<c:forEach var="article" items="${articleDabgle}">
					<tr>
						<td>${DabgleCount}<c:set var="DabgleCount" value="${DabgleCount-1}" /></td>
						<td colspan="2"align="center" height="30">${article.content}</td>
						<td colspan="2"align="center" height="30">${article.writer}</td>
					</tr>
				</c:forEach>

			

			
			<tr>
				<td colspan="2" > 
				
			<c:if test="${sessionScope.memId != article.writer }">
				<c:if test="${category == 1 || category == 2 || category == 6}">
					<button class="admin_dtn2_content" onclick="window.location='/psyco/communityModifyForm1.com?&community_num=${community_num}&pageNum=${pageNum}&category=${category}'">수 정</button>
				</c:if>
				<c:if test="${category == 3 || category == 4}">
					<button class="admin_dtn2_content"  onclick="window.location='/psyco/communityModifyForm.com?&community_num=${community_num}&pageNum=${pageNum}&category=${category}'">수 정</button>
				</c:if>
					<button class="admin_dtn2_content" onclick="window.location='/psyco/communityDeleteForm.com?community_num=${community_num}&pageNum=${pageNum}&category=${category}'">삭 제</button>
				</c:if>
					<button class="admin_dtn2_content" onclick="window.location='/psyco/communityForm.com?community_num=${community_num}&ref=${article.ref}&re_step=${article.re_step}&re_level=${article.re_level}&category=${category}'">댓 글 작성 </button>
					<button class="admin_dtn2_content" onclick="window.location='/psyco/communityList.com?pageNum=1&category=${category}'">리스트로 </button>
				 </td>
			</tr>
		
		
		</table>
		</div>
	</body>
</html>