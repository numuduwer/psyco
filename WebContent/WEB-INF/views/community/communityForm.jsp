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
<br/>
		<h1 align="center"> 글 작성  </h1>
		<form action="/psyco/communityPro.com" method="post" enctype="multipart/form-data">
			<input type="hidden" name="community_num" value= "${community_num}"/>
			<input type="hidden" name="ref" value= "${ref}"/>
			<input type="hidden" name="re_step" value= "${re_step}"/>
			<input type="hidden" name="re_level" value= "${re_level}"/>
			<input type="hidden" name="category" value= "${category}"/>
			<input type="hidden" name="grade" value= "${grade}"/>
		

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
				<td>e-mail</td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="20" cols="70" name="content"></textarea></td>
			</tr>
			<c:if test="${category == 3 || category == 2}">
			<tr>
				<td>음식점 사진</td>
				<td><input type="file" name="img"/></td>	
			</tr>
			</c:if>
			<tr>
				<td colspan="2">
					<input type="submit" value="저장" /> 
					<input type="reset" value="재작성" />
					<input type="button" value="리스트보기"  onclick="window.location='/psyco/communityList.com'"/>
				</td>
			</tr>
		</table>
	</form>




</body>
</html>