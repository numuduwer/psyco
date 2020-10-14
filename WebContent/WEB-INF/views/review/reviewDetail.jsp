<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript"></script>
<script>
	function goBack(){ 
		window.history.back();
	}
</script>
<body>
	<table>
		<tr>
			<td rowspan="2">${article.review_img}</td>
			<td>${article.shop_name} ${article.grade} ${article.category}</td>		
			<td>${article.reg}</td>
		</tr>
		<tr>
			<td>${article.content}</td>
		</tr>
		<tr>
			<td><input type="button" value="수정" onclick="window.location='reviewModify.com?review_num=${article.review_num}&pageNum=${pageNum}'"/></td>
			<td><input type="button" value="삭제" onclick="window.location='reviewDelete.com'"/></td>
			<td><input type="button" value="뒤로가기" onclick/></td>
		</tr>
	</table>

</body>
</html>