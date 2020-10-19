<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 수정폼</title>
</head>
<body>
<form action="reviewModifyPro.com?pageNum=${pageNum}" method="post" enctype="multipart/form-data">
	<input type="hidden" name="writer" value="${article.writer}"/>
	<input type="hidden" name="item_num" value="${article.item_num}"/>
	<input type="hidden" name="review_num" value="${article.review_num}"/>
	<input type="hidden" name="ref" value="${article.ref}"/>
	<input type="hidden" name="confirm" value="${article.confirm}"/>
	<input type="hidden" name="reply_content" value="${article.reply_content}"/>
	<input type="hidden" name="item_name" value="${article.item_name}"/>
	<input type="hidden" name="member_id" value="${article.member_id}"/>
		<table>
			<tr>
				<td>작성자</td>
				<td>${article.writer}</td>
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
				<td><input type="file" name="review_img" valuew="${article.review_img}"/></td>
				<td>내용</td>
				<td><input type="text" name="content" value="${article.content}"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="확인"/></td>
				<td><input type="button" value="뒤로가기" onclick="goback();"/></td>
			</tr>
		</table>
	</form>
	

</body>
</html>