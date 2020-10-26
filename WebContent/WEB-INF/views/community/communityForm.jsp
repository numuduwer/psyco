<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<!--  검색베너  & 신메뉴 , 랭킹미리보기 -->
    <section id="banner_section">
      
        <div id="banner">
            <img src="/psyco/resources/img/main/community.jpg" alt="">
        </div>
 
    </section>
<br/>
		<h1 align="center"> 글 작성  </h1>
		<form action="/psyco/communityPro.com" method="post" enctype="multipart/form-data">
			<input type="hidden" name="ref" value= "${ref}"/>
			<input type="hidden" name="re_step" value= "${re_step}"/>
			<input type="hidden" name="re_level" value= "${re_level}"/>
			<input type="hidden" name="category" value= "${category}"/>
			<input type="hidden" name="grade" value= "${grade}"/>
			<input type="hidden" name="pageNum" value= "${pageNum}"/>
			<input type="hidden" name="community_num" value= "${community_num}"/>
			<input type="hidden" name="writer" value= "${writer}"/>
	<div class="admin_content">
		<table>
			
			<tr>
				<th>제 목</th>
				<c:if test="${community_num == null}">
					<td>
						<input type="text" name="subject"/>				
					</td>
				</c:if>
				<c:if test="${community_num != null}">
					<td>
						<input type="radio" name="subject" value="[댓글]" checked/>	댓글		
					</td>
				</c:if>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="20" cols="70" name="content"></textarea></td>
			</tr>
			<c:if test="${category == 3 || category == 4}">
			<tr>
				<th>음식점 사진</th>
			</tr>
			<tr>
		       	<th><img id="imgpreview" src="/psyco/save//${article.community_img}" width="100" height="100"></th>
		       	<td><label>이미지 변경하기</label><input type="file" onchange="imagepreview(this);" name="img"/></td>
			</tr>	

			</c:if>
			<tr>
				<td colspan="2">
					<input class="admin_dtn2_content" type="submit" value="저장" /> 
				
					<c:if test="${community_num != null}">
						<input class="admin_dtn2_content" type="button" value="돌아가기"  onclick="window.location='/psyco/communityDetail.com?community_num=${community_num}&category=${category}'"/>
					</c:if>
					<c:if test="${community_num == null}">
						<input class="admin_dtn2_content" type="button" value="리스트보기"  onclick="window.location='/psyco/communityList.com?category=${category}'"/>
					</c:if>
				</td>
			</tr>
		</table>
		</div>
	</form>
	




</body>
</html>