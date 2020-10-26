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


	<br /><br /><br /><br /><br /><br /><br />

		<div class="admin_content2">
	<table align="center">
			
		<tr>
			<th width="80">제 목</th>
			<td colspan="20" align="center" > ${article.subject}  </td>
		</tr>
		<tr>
			<th>작성 내용</th>
			<td colspan="2"align="center" height="300">${article.content}   </td>
		</tr>
		<tr>
			<td colspan="2" > 
				<button class="admin_dtn2_content2" onclick="window.location.href='/psyco/help.com?category=5'"> 답글 달기  </button>
				<button class="admin_dtn2_content2" onclick="window.location.href='/psyco/help.com?category=5'">리스트로 </button>
			</td>
		</tr>
		
	</table>
	</div>
</body>
</html>