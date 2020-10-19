<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리 뷰 폼!</title>
</head>
<script type="text/javascript">
	function goBack(){
		window.history.back();
	}
</script>
<body>
	<!-- 가게 리뷰에 필요한 페이지  -->
	<!--현재 접속한 세션을 불러와 넣어준다. shop_num 을 전페이지 에서부터 끌어온다  session 부분 nickname으로 바꿔야 할듯 ㅠ -->
	<form action="/psyco/user/reviewPro.com" method="post" enctype="multipart/form-data">
	<input type="hidden" name="writer" value="${nickname}"/>
	<input type="hidden" name="item_num" value="${item_num}">
	
	
		<table>
			<tr>
				<td>작성자</td>
				<td>${nickname}</td>
				<td>
					<select name="category">
						<option value="0">없음</option>
						<option value="1">가성비 좋은집</option>
						<option value="2">맛 좋은 집</option>
						<option value="3">중독성 있는 집</option>
					</select>
					<select name="grade">
						<option value="0">없음</option>
						<option value="★">★</option>
						<option value="★★">★★</option>
						<option value="★★★">★★★</option>
						<option value="★★★★">★★★★</option>
						<option value="★★★★★">★★★★★</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="file" name="review_img"/></td>
				<td>내용</td>
				<td><input type="text" name="content"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="확인"/></td>
				<td><input type="button" value="뒤로가기" onclick="goback();"/></td>
			</tr>
		</table>
	</form>

</body>
</html>