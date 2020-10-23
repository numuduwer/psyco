<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!--  기능  타이틀 -->
    <div class="myPage_mainTitle">
        <h1>마이페이지</h1>
        <div class="myPage_userTitle">
            <h2>김신</h2><span>님 환영합니다.</span>
            <ul>
                <li>랭킹</li>
                <li>-<span>등</span></li>
            </ul>
            <ul>
                <li>최고 할인기록</li>
                <li>40 <span>%</span></li>
            </ul>

        </div>
    </div>


 
    <!--   탭 버튼-->
    <div class="myPage">
        <div class="myPage_content">
            <div class="myPage_main">
                <div class="tabs">
                    <div class="tab" data-tab-target="#tab1">
		               	<form action="myPageList.com">
                    
                        <input type="hidden" name="page" value="1">
                       <p>전체 구매내역</p>
                        
			        	
                   		</form>
                    </div>
                    <div class="tab" data-tab-target="#tab2" >
		               	<form action="myPageList.com">
		               	<input type="hidden" name="page" value="2">
		               	<p>내가쓴 후기</p>
                        
                   		</form>
                    </div>
                    
                </div>
            </div>

            <div class="content">
                <!--   탭 1 내용-->
        	<div id="tab1" data-tab-content class="items active">
	        	<div class="userpage_tab1">
                		<%-- 구매 없을때 --%>
					<c:if test="${count == 0}">
						<table>
							<tr>
								<td> 구매내역이 없습니다. </td>
							</tr>
						</table>
					</c:if>
		<%-- 구매 있을 때 --%>
					<c:if test="${count > 0}">
						
		                <c:forEach var="article" items="${articleList}">	
		                	<ul class="reg">
		                   		<li>주문일  ${article.reg}</li>
		                        <li><a href="">주문 상세보기 >></a> </li>
		                    </ul>
		                    <div class="myPage_item_info">
		                    	<img src="/img/item/one/1.jpg" alt="">
		                        <ul>
		                           <li><a href="psyco/main/content.com?item_num=${article.item_num}&shop_num=${article.shop_num}&pageNum=${pageNum}">${article.item_name}</a></li>
		                           <li> 할인률 ${article.discount_rate}%</li>
		                           <li>
		                               <span>${article.amount}/${article.price}원</span>
		                           </li>
		                       </ul>
		                            <button><a href="/psyco/user/reviewForm.com?item_num=${article.item_num}&shop_num=${article.shop_num}&pageNum=${pageNum}">후기 쓰러가기</a> </button>
		                        </div>
		            	</c:forEach> 
					</c:if>
		        </div>  
        	</div>

                <!--   탭 2 내용-->
      
                <div id="tab2" data-tab-content class="items">
                   <div class="userpage_tab2">
                   		<c:if test="${reviewCount == 0}">
							<table>
								<tr>
									<td> 후기가 없습니다. </td>
								</tr>
							</table>
						</c:if>
                        <h2>최근 리뷰</h2>
                        <c:if test="${count > 0}">
	                        <table>
	                            <tr>
	                                <th>no.</th>
	                                <th>제목</th>
	                                <th>별점</th>
	                                <th>작성시간</th>
	                            </tr>
	                        	<c:forEach var="article" items="${reviewArticleList}">
	                            	<tr>
		                            	<td>${reviewNumber}
											<c:set var="number" value="${reviewNumber-1}" />
										</td>
										<td align="left">
											<a href="/psyco/user/reviewDetail.com?review_num=${article.review_num}&pageNum=${pageNum}" >${article.item_name}</a>
										</td>
										<td>${article.grade}</td>
										<td>${article.reg}</td>
										<td><input type="button" value="삭제" onclick="window.location='reviewDelete.com?review_num=${article.review_num}&pageNum=${pageNum}'"/></td>
									</tr>
	                       		</c:forEach>
	                        </table>
                        </c:if>
                    </div>
                </div>
            </div>
    
    
    <script>
        const tabs = document.querySelectorAll("[data-tab-target]");
        const tabcon = document.querySelectorAll("[data-tab-content]");
        tabs.forEach((tab) => {
            tab.addEventListener("click", () => {
                const target = document.querySelector(tab.dataset.tabTarget);
                tabcon.forEach((tabc_all) => {
                    tabc_all.classList.remove("active");
                });
                target.classList.add("active");
            });
        });
    </script>

</body>
</html>