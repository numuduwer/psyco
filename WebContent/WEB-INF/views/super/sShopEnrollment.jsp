<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member 관리 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	


function onClickItemDelete(memberNum){
	
	var msg = confirm("삭제하시겠습니까? ");
	if(msg == true){
		var apiURL = '/psyco/super/deleteMember.com';
		console.log(apiURL);

		$.ajax({
	        type: 'POST',
	        url: apiURL,
			data: {member_Num : memberNum},
			success:function (member_Num) {
				var myobj = document.getElementById(memberNum);
				myobj.remove();
	        },
	        error: function (error) {
	            alert('data error');
	        }
	    });	
	}else{
		alert('삭제 취소하셨습니다, ')
	}
	
	

}	
	
</script>



</head>
<body>



	
	    <!-- 경매 상품 -->
    <section class="item-section">
        <div class="admin">
            <ul class="admin_btn2">
                <li><a href="/psyco/super/memberList.com">회원관리</a></li>
                <li><a href="/psyco/super/shopEnrollList.com">서비스 등록 현황</a></li>
                <li><a href="/psyco/communityList.com?category=3">가게관리</a></li>
                <li><a href="/psyco/communityList.com?category=4">문의하기 관리</a></li>
            </ul>
        
         
        </div>
    </section>
	<c:if test="${count == 0}">
		<h2> 멤버가 없어요.</h2>
	
	</c:if>
	<c:if test="${count > 0}">
	<div class="admin_content2">
		<br>	<br>
		
	<h2>회원 리스트  </h2>
		<br>
			<table>
			<tr>
			     <th>No.</th>
			     <th>ID</th>
			     <th>사업자 등록 번호</th>
			     <th>이름</th>
			     <th>생년월일</th>
			     <th>핸드폰</th>
			     <th>성별</th>
			     <th>가입날짜</th>
			     <th>등록</th>
			     <th>삭제하기</th>
			</tr>	
			<c:forEach var="article" items="${articleList}">
			<tr id = "${article.member_Num}"}>
				<td>${number} <c:set var="number" value="${number-1}" /> </td>		
				<td>${article.member_Id}</td>
				<td>${article.license_number}</td>
				<td>${article.name}</td>
				<td>${article.birth}</td>
				<td>${article.phoneNum}</td>
				<td>${article.gender}</td>
				<td>${article.reg}</td>
				<td>
				<a class= "admin_delete" href="/psyco/super/shopEnrollPro.com?member_Num=${article.member_Num}" >등록 </a>				
				
				</td>	
				<td>
				<a class= "admin_delete" href="javascript:onClickItemDelete('${article.member_Num}')" >삭제</a>				
				</td>		
			</tr>
		</c:forEach>		
		</table><br><br><br>
		<%-- 게시판 목록 페이지 번호 뷰어 설정 --%>
	<div align="center">
	<c:if test="${count > 0}">
		<fmt:parseNumber var="res" value="${count / pageSize}"  integerOnly="true"/>
		<c:set var="pageCount" value="${res + (count % pageSize == 0 ? 0 : 1)}"  />
		<c:set var="pageBlock" value="10" />
		<fmt:parseNumber var="result" value="${(currPage-1)/pageBlock}" integerOnly="true" />
		<fmt:parseNumber var="startPage" value="${result * pageBlock + 1}" />
		<fmt:parseNumber var="endPage" value="${startPage + pageBlock - 1}" />
		<c:if test="${endPage > pageCount}">
			<c:set var="endPage" value="${pageCount}" />
		</c:if>
		
		<c:if test="${startPage > pageBlock}">
			<a href="/psyco/super/memberList.com?pageNum=${startPage-pageBlock}" > &lt; </a>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
			<a href="/psyco/super/memberList.com?pageNum=${i}" class="pageNums"> &nbsp; ${i} &nbsp; </a>
		</c:forEach>
		<c:if test="${endPage < pageCount}">
			<a href="/psyco/super/memberList.com?pageNum=${startPage+pageBlock}" > &gt; </a>
		</c:if>
	
	</c:if>
	<br>
	</div>
	<br>
		</div>
		
		
		
	</c:if>
	
	
	
</body>
</html>