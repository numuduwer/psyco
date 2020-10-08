<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글 수정 </title>
		<link href="/spring/resources/style.css" rel="stylesheet" type="text/css">
</head>



	<body>
		<br/>
		<h1 align="center"> modify article  </h1>
			<form action="/spring/board/modifyPro.git?pageNum=${pageNum}" method="post">
			<input type="hidden" name="num" value= "${article.num}"/>

		
		
			<table>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer" value="${article.writer}"/></td>
				</tr>
				<tr>
					<td>제 목</td>
					<td><input type="text" name="subject" value="${article.subject}"/></td>
				</tr>
				<tr>
					<td>e-mail</td>
					<td><input type="text" name="email" value="${article.email}"/></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="20" cols="70" name="content" >${article.content}</textarea></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정" /> 
			
						<input type="button" value="리스트보기"  onclick="window.location='/spring/board/list.git?pageNum=${pageNum}'"/>
					</td>
				</tr>
			</table>
		</form>
		
	</body>
</html>