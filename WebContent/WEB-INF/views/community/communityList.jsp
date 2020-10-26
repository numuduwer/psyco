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
		<h2 align="center"> 자유게시판 페이지 입니다.</h2>
		<br><br>
		<div class="ssss">
		<button class="admin_dtn2_content"  onclick="window.location='/psyco/communityForm.com?category=1&grade=11&pageNum=${pageNum}'"> 글쓰기 </button> 
		<button class="admin_dtn2_content" onclick="window.location='/psyco/communityMyArticle.com?category=1&grade=11&pageNum=${pageNum}'"> 내가 쓴 글  </button>
		</div>
		<div class="admin_content">

		<br>
		<table>
			
			<tr>
				<th>No.</th>
				<th>제  목</th>
				<th>작성자</th>
				<th>시  간</th>
			</tr>
			<c:forEach var="article" items="${articleList}">
				<tr>
					<td>${number}
					<c:set var="number" value="${number-1}" />
					</td>
					<td>
						<a href="/psyco/communityDetail.com?community_num=${article.community_num}&pageNum=${pageNum}&category=1" >${article.subject}</a>
					</td>
					<td><a href="mailto:${article.writer}">${article.writer}</a></td>
					<td>${article.reg}</td>
				</tr>
			</c:forEach>
		</table>
		<%-- 게시판 목록 페이지 번호 뷰어 설정 --%>
			<div class="paging">
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
					<a href="/psyco/communityList.com?pageNum=${startPage-pageBlock}&category=${category}" > &lt; </a>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
					<a href="/psyco/communityList.com?pageNum=${i}&category=${category}" class="pageNums"> &nbsp; ${i} &nbsp; </a>
				</c:forEach>
				<c:if test="${endPage < pageCount}">
					<a href="/psyco/communityList.com?pageNum=${startPage+pageBlock}&category=${category}" > &gt; </a>
				</c:if>
			
			</c:if>
			</div>
		</div>
	</c:if>


	<c:if test="${category == 2}">
		<h2 align="center"> QnA 페이지</h2>
		<div class="ssss">
		<button class="admin_dtn2_content"  onclick="window.location='/psyco/communityForm.com?category=2&grade=11&pageNum=${pageNum}'"> 글쓰기 </button> 
		<button class="admin_dtn2_content" onclick="window.location='/psyco/communityMyArticle.com?category=2&grade=11&pageNum=${pageNum}'"> 내가 쓴 글  </button>
		</div>
		<div class="admin_content">
		<table>
		<br>
			<tr>
				<th>No.</th>
				<th>제  목</th>
				<th>작성자</th>
				<th>시  간</th>
			</tr>
			<c:forEach var="article" items="${articleList}">
				<tr>
					<td>${number}
					<c:set var="number" value="${number-1}" />
					</td>
					<td>
					<a href="/psyco/communityDetail.com?community_num=${article.community_num}&pageNum=${pageNum}&category=2" >${article.subject}</a>
					</td>
					<td><a href="mailto:${article.writer}">${article.writer}</a></td>
					<td>${article.reg}</td>
				</tr>
			</c:forEach>
		</table>
		<%-- 게시판 목록 페이지 번호 뷰어 설정 --%>
			<div class="paging">
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
					<a href="/psyco/communityList.com?pageNum=${startPage-pageBlock}&category=${category}" > &lt; </a>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
					<a href="/psyco/communityList.com?pageNum=${i}&category=${category}" class="pageNums"> &nbsp; ${i} &nbsp; </a>
				</c:forEach>
				<c:if test="${endPage < pageCount}">
					<a href="/psyco/communityList.com?pageNum=${startPage+pageBlock}&category=${category}" > &gt; </a>
				</c:if>
			
			</c:if>
			</div>
		</div>
	</c:if>
	
	<c:if test="${category == 3}">
		<h2 align="center"> 홍보 페이지 </h2>
		<div class="ssss">
		<button class="admin_dtn2_content"  onclick="window.location='/psyco/communityForm.com?category=3&grade=11&pageNum=${pageNum}'"> 글쓰기 </button> 
		<button class="admin_dtn2_content" onclick="window.location='/psyco/communityMyArticle.com?category=3&grade=11&pageNum=${pageNum}'"> 내가 쓴 글  </button>
		</div>
		<div class="admin_content">
		<br>
		<table>
			<tr>
				<th>No.</th>
				<th>제  목</th>
				<th>작성자</th>
				<th>시  간</th>
				<th>사 진 </th>
			</tr>
			<c:forEach var="article" items="${articleList}">		
			<tr>
				<td>${number}
				<c:set var="number" value="${number-1}" />
				</td>
				<td>
					<a href="/psyco/communityDetail.com?community_num=${article.community_num}&pageNum=${pageNum}&category=3" >${article.subject}</a>
				</td>
				<td><a href="mailto:${article.writer}">${article.writer}</a></td>
				<td>${article.reg}</td>	
				<td><img src="/psyco/save//${article.community_img}" width=200></td>	
			</tr>
		</c:forEach>
		</table>
		<%-- 게시판 목록 페이지 번호 뷰어 설정 --%>
			<div class="paging">
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
					<a href="/psyco/communityList.com?pageNum=${startPage-pageBlock}&category=${category}" > &lt; </a>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
					<a href="/psyco/communityList.com?pageNum=${i}&category=${category}" class="pageNums"> &nbsp; ${i} &nbsp; </a>
				</c:forEach>
				<c:if test="${endPage < pageCount}">
					<a href="/psyco/communityList.com?pageNum=${startPage+pageBlock}&category=${category}" > &gt; </a>
				</c:if>
			
			</c:if>
			</div>
		</div>
	</c:if>

	
	<c:if test="${category == 4}">
		<h2 align="center"> 음식점 추천 페이지</h2>
		<div class="ssss">
		<button class="admin_dtn2_content"  onclick="window.location='/psyco/communityForm.com?category=4&grade=11&pageNum=${pageNum}'"> 글쓰기 </button> 
		<button class="admin_dtn2_content" onclick="window.location='/psyco/communityMyArticle.com?category=4&grade=11&pageNum=${pageNum}'"> 내가 쓴 글  </button>
		</div>
		<div class="admin_content">
		<br>
		<table>	
		<tr>
			<th>No.</th>
			<th>제  목</th>
			<th>작성자</th>
			<th>시  간</th>
			<th>사  진</th>
		</tr>
		<c:forEach var="article" items="${articleList}">
			<tr>
				<td>${number}
					<c:set var="number" value="${number-1}" />
				</td>
				<td>
					<a href="/psyco/communityDetail.com?community_num=${article.community_num}&pageNum=${pageNum}&category=4" >${article.subject}</a>
				</td>
				<td><a href="mailto:${article.writer}">${article.writer}</a></td>
				<td>${article.reg}</td>
				<td><img src="/psyco/save//${article.community_img}" width=200></td>
			</tr>
		</c:forEach>
		</table>
		<%-- 게시판 목록 페이지 번호 뷰어 설정 --%>
			<div class="paging">
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
					<a href="/psyco/communityList.com?pageNum=${startPage-pageBlock}&category=${category}" > &lt; </a>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
					<a href="/psyco/communityList.com?pageNum=${i}&category=${category}" class="pageNums"> &nbsp; ${i} &nbsp; </a>
				</c:forEach>
				<c:if test="${endPage < pageCount}">
					<a href="/psyco/communityList.com?pageNum=${startPage+pageBlock}&category=${category}" > &gt; </a>
				</c:if>
			
			</c:if>
			</div>
		</div>
	</c:if>

	
	
			
	
	
</body>
</html>