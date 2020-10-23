<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글 수정 </title>
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script>

		function imagepreview(input){
		       if(input.files && input.files[0]){
		           var filerd = new FileReader();
		           filerd.onload=function(e){
		               $('#imgpreview').attr('src', e.target.result);
		           };
		           filerd.readAsDataURL(input.files[0]);
		       }
		     }

</script>
	
		
</head>
	


	<body>
		<br/>
		<h1 align="center"> modify article  </h1>
			<form action="/psyco/communityModifyPro.com?pageNum=${pageNum}" method="post" enctype="multipart/form-data">
			<input type="hidden" name="community_num" value= "${community_num}"/>
			<input type="hidden" name="category" value= "${category}"/>
			
			
			<table>
				<tr>
					<td>작성자</td>
					<td>${article.writer}</td>
				</tr>
				<tr>
					<td>제 목</td>
					<td><input type="text" name="subject" value="${article.subject}"/></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="20" cols="70" name="content" >${article.content}</textarea></td>
				</tr>
					<tr>
						<td>기존 이미지</td>
					</tr>
					<tr>
		       			<th><img id="imgpreview" src="/psyco/save//${article.community_img}" width="100" height="100"></th>
		       			<td><label>이미지 변경하기</label><input type="file" onchange="imagepreview(this);" name="community_img"/></td>
					</tr>
				<tr>												
					<td colspan="2">
						<input type="submit" value="수정" /> 
			
						<input type="button" value="리스트보기"  onclick="window.location='/psyco/communityDetail.com?community_num=${community_num}&category=${category}'"/>
					</td>
				</tr>
			
			

			
			
			
			
			
			
			
			
			
			</table>
		</form>
		


	</body>
</html>