<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<br><br><br><br><br><br><br><br><br><br><br><br>
		<h2 align="center"> 삭제하시겠습니까? </h2>
		<form action="/psyco/communityDeletePro.com?pageNum=${pageNum}" method="post">
		<input type="hidden" name="community_num" value="${community_num}"/>
		<input type="hidden" name="category" value="${category}"/>
		
				<br><br><br>
				
					<input  class="form_btn" type="submit" value="삭제"/>
					<input  class="form_btn" type="button" value="삭제취소" onclick='history.back(-1);'/>
				
			
		
		
		</form>
		<br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>