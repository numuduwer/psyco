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

	<br/>
		<h1 align="center"> content </h1>
		<table align="center">
			<tr>
				<td width="80">제 목 </td>
				<td colspan="20" align="center" > ${article.subject} </td>
			</tr>
			<br />
			<tr>
				<td>작성 내용</td>
				<td colspan="2"align="center" height="300">${article.content}   </td>
			</tr>
		
			<tr>
			
				<td> posted by <a href="mailto:${article.writer}">${article.writer}</a> at ${article.reg} </td>
				
			</tr>
			<c:if test="${category == 3 || category == 4}">
				<tr>
					<td><img src="/psyco/save//${article.community_img}" width="400"></td>
				</tr>
			</c:if>
			<tr>
				<td>댓글</td>
				<td colspan="2"align="center" height="300">${article.content}   </td>
			</tr>
			<tr>
				<td colspan="2"> 
				<c:if test="${category == 1 || category == 2}">
					<button onclick="window.location='/psyco/communityModifyForm1.com?&community_num=${community_num}&pageNum=${pageNum}&category=${category}'">수 정</button>
				</c:if>
				<c:if test="${category == 3 || category == 4}">
					<button onclick="window.location='/psyco/communityModifyForm.com?&community_num=${community_num}&pageNum=${pageNum}&category=${category}'">수 정</button>
				</c:if>
					<button onclick="window.location='/psyco/communityDeleteForm.com?community_num=${community_num}&pageNum=${pageNum}'">삭 제</button>
					<button onclick="window.location='/psyco/communityForm.com?community_num=${community_num}&ref=${article.ref}&re_step=${article.re_step}&re_level=${article.re_level}&category=6'">답 글</button>
					<button onclick="window.location='/psyco/communityList.com?pageNum=${pageNum}'">리스트</button>
				 </td>
			</tr>
		
		
		</table>
	</body>
</html>