<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판</title>
</head>

<body>


	<!--  검색베너  & 신메뉴 , 랭킹미리보기 -->
    <section id="banner_section">
      
        <div id="banner">
            <img src="/psyco/resources/img/main/community.jpg" alt="">
        </div>
 
    </section>
	
	<c:if test="${count == 0}">

		<h1 align="center">작성된 글이 없습니다.</h1>
	</c:if>
    <!-- 경매 상품 -->
    <section class="item-section">
        <div class="admin">
            <ul class="admin_btn">
                <li><a href="/psyco/communityList.com?category=1">자유게시판</a></li>
                <li><a href="/psyco/communityList.com?category=2">QnA</a></li>
                <li><a href="/psyco/communityList.com?category=3">홍보</a></li>
                <li><a href="/psyco/communityList.com?category=4">음식점추천</a></li>
            </ul>
        
         
        </div>
    </section>
    <c:if test="${category == 1}">
   
    <div class="nContent">
        <div class="ntable2">
            <div class="table_title">
                <h2>자유게시판 </h2>
                
            </div>
            
            <table class="table_box2">

                <tr>
                    <td width=80 class="table_box_title">조회수</td>
                    <td width=550 class="table_box_title">제목</td>
                    <td width=70 class="table_box_title">작성자</td>
                    <td width=100 class="table_box_title">작성일</td>

                </tr>
                <c:forEach var="article" items="${articleList}">
                <tr>
                    <td>${number}
                    <c:set var="number" value="${number-1}" />
                    </td>
                    <td><a href="/psyco/communityDetail.com?community_num=${article.community_num}&pageNum=${pageNum}&category=1" >${article.subject}</a></td>
                    <td><a href="mailto:${article.writer}">${article.writer}</a></td>
                    <td>${article.reg}</td>

                </tr>
                </c:forEach>
             </table>
             	<br>	
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
             
             <div class="ssss">
				<button class="admin_dtn2_content"  onclick="window.location='/psyco/communityForm.com?category=1&grade=11&pageNum=${pageNum}'"> 글쓰기 </button> 
				<button class="admin_dtn2_content" onclick="window.location='/psyco/communityMyArticle.com?category=1&grade=11&pageNum=${pageNum}'"> 내가 쓴 글  </button>
			</div>
			
			
		</div>
	</div>
	</c:if>
	
	<c:if test="${category == 2}">
   
    <div class="nContent">
        <div class="ntable2">
            <div class="table_title">
                <h2>QnA 게시판  </h2>
                
            </div>
            
            <table class="table_box2">

                <tr>
                    <td width=80 class="table_box_title">조회수</td>
                    <td width=550 class="table_box_title">제목</td>
                    <td width=70 class="table_box_title">작성자</td>
                    <td width=100 class="table_box_title">작성일</td>

                </tr>
                <c:forEach var="article" items="${articleList}">
                <tr>
                    <td>${number}
                    <c:set var="number" value="${number-1}" />
                    </td>
                    <td><a href="/psyco/communityDetail.com?community_num=${article.community_num}&pageNum=${pageNum}&category=1" >${article.subject}</a></td>
                    <td><a href="mailto:${article.writer}">${article.writer}</a></td>
                    <td>${article.reg}</td>

                </tr>
                </c:forEach>
             </table>
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
             
             <div class="ssss">
				<button class="admin_dtn2_content"  onclick="window.location='/psyco/communityForm.com?category=2&grade=11&pageNum=${pageNum}'"> 글쓰기 </button> 
				<button class="admin_dtn2_content" onclick="window.location='/psyco/communityMyArticle.com?category=2&grade=11&pageNum=${pageNum}'"> 내가 쓴 글  </button>
			</div>
			
			
		</div>
	</div>
	</c:if>
	
	
	<c:if test="${category == 3}">
   
    <div class="nContent">
        <div class="ntable2">
            <div class="table_title">
                <h2>홍보게시판  </h2>
                
            </div>
            
            <table class="table_box2">

                <tr>
                    <td width=80 class="table_box_title">조회수</td>
                    <td width=550 class="table_box_title">제목</td>
                    <td width=70 class="table_box_title">작성자</td>
                    <td width=100 class="table_box_title">작성일</td>

                </tr>
                <c:forEach var="article" items="${articleList}">
                <tr>
                    <td>${number}
                    <c:set var="number" value="${number-1}" />
                    </td>
                    <td><a href="/psyco/communityDetail.com?community_num=${article.community_num}&pageNum=${pageNum}&category=1" >${article.subject}</a></td>
                    <td><a href="mailto:${article.writer}">${article.writer}</a></td>
                    <td>${article.reg}</td>

                </tr>
                </c:forEach>
             </table>
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
             
             
             <div class="ssss">
				<button class="admin_dtn2_content"  onclick="window.location='/psyco/communityForm.com?category=3&grade=11&pageNum=${pageNum}'"> 글쓰기 </button> 
				<button class="admin_dtn2_content" onclick="window.location='/psyco/communityMyArticle.com?category=3&grade=11&pageNum=${pageNum}'"> 내가 쓴 글  </button>
			</div>
			
			
		</div>
	</div>
	</c:if>
	
	
	<c:if test="${category == 4}">
   
    <div class="nContent">
        <div class="ntable2">
            <div class="table_title">
                <h2>음식점 추천 게시판  </h2>
                
            </div>
            
            <table class="table_box2">

                <tr>
                    <td width=80 class="table_box_title">조회수</td>
                    <td width=550 class="table_box_title">제목</td>
                    <td width=70 class="table_box_title">작성자</td>
                    <td width=100 class="table_box_title">작성일</td>

                </tr>
                <c:forEach var="article" items="${articleList}">
                <tr>
                    <td>${number}
                    <c:set var="number" value="${number-1}" />
                    </td>
                    <td><a href="/psyco/communityDetail.com?community_num=${article.community_num}&pageNum=${pageNum}&category=1" >${article.subject}</a></td>
                    <td><a href="mailto:${article.writer}">${article.writer}</a></td>
                    <td>${article.reg}</td>

                </tr>
                </c:forEach>
             </table>
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
             	
	
             
             <div class="ssss">
				<button class="admin_dtn2_content"  onclick="window.location='/psyco/communityForm.com?category=4&grade=11&pageNum=${pageNum}'"> 글쓰기 </button> 
				<button class="admin_dtn2_content" onclick="window.location='/psyco/communityMyArticle.com?category=4&grade=11&pageNum=${pageNum}'"> 내가 쓴 글  </button>
			</div>
			
			
		</div>
	</div>
	</c:if>
	
	

			
	
	
</body>
</html>