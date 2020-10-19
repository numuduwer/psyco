<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1 align="center"> delete </h1>
		<form action="/psyco/shop/itemDeletePro.com?pageNum=${pageNum}" method="post">
		<input type="hidden" name="item_num" value="${item_num}"/>
			<table>
				<tr>
					<td>삭제를 원하시면 삭제버튼을 눌러주세요.</td>	
				</tr>
				<tr>
					<td><input type="submit" value="삭제"/></td>	
					<td><input type="button" value="삭제취소" onclick="window.location='/psyco/shop/itemDeletePro.com?pageNum=${pageNum}'"/></td>
				</tr>
			
			</table>
			
		
		
		</form>
</body>
</html>