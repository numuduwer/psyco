<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center"> 문의하기 작성  </h1>
		<form action="/psyco/helpPro.com" method="post" enctype="multipart/form-data">
		
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value="${sessionScope.memId}"></td>
			</tr>
			<tr>
				<td>제 목</td>
				<td>
					<input type="text" name="subject"/>				
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="50" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="전송" /> 
					<input type="reset" value="재작성" />
				</td>
			</tr>
		</table>
	</form>


</body>
</html>