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
	<br />
	<h1 align="center">Detail</h1>
	<table>
		<tr>
			<td width="80" align="center">제 목</td>
		</tr>
		<tr>
			<td colspan="2" align="center"> ${article.subject} </td>
		</tr>
		<tr>
			<td align="center">작성 내용</td>
		</tr>
		<tr>
			<td colspan="2" align="center" height="300">${article.content}   </td>
		</tr>
		<tr>
			<td colspan="50"> posted by <a href="mailto:${article.writer}">${article.writer}</a> at ${article.reg} </td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="window.location.href='/psyco/help.com?category=5'">문의 리스트 돌아가기</button>
			</td>
		</tr>
	</table>
</body>
</html>