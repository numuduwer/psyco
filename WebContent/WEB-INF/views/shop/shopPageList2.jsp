<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!--  기능  타이틀 -->
    <div class="myPage_mainTitle">
        <h1>사장님 마이페이지</h1>

        <div class="myPage_shopTitle ">
            <h2 class="myPage_subTitle">내 가게 관리하기 </h2>
        </div>
    </div>


    <!--  기능  타이틀 -->
    <div class="main_shopItem">
        <div class="tabs_shopItem">
            <div class="tab_shopItem" data-tab-target="#tab1">
                <p>진행중인 경매</p>
            </div>
            <div class="tab_shopItem" data-tab-target="#tab2">
                <p>진행 예정 경매</p>
            </div>
            <div class="tab_shopItem" data-tab-target="#tab3">
                <p>진행 완료 경매 </p>
            </div>
        </div>
    </div>
    <div class="content_shopItem">
        <div id="tab1" data-tab-content class="items2 active">
            <div class="ltem2_shopItembox">
            <c:forEach var="item" items="${itemMapList}">
               	<div class="content_shopItem_listBox">            	
	                    <div class="shopItem_img">
	                        <img src="/psyco/save/${item.itemList.menu_img}" >
	                    </div>
	                    <ul>
	                        <li>
	                            <h3 class="content_shopItem_title"><a href="">상품 명 : ${item.itemList.item_name}</a></h3>
	                        </li>
	                        <li> 수량 : ${item.itemList.amount}</li>
	                    </ul>
	                    <ul>
	                        <li>
	                            시작시간 : ${item.itemList.startDate}
	                        </li>
	                        <li>종료시간 : ${item.itemList.endDate}</li>
	                    </ul>
	                    <ul>
	        				<li>자동 할인시간</li>
	        				<li><fmt:parseNumber var="discount_cycle" value="${item.itemList.discount_cycle / 60}" integerOnly="true"/>${discount_cycle} 분</li>
        				</ul>
        				<ul>
	        				<li>시작 가격</li>
	        				<li>${item.itemList.maxPrice}</li>
        				</ul>
	        			<ul class="sale">
	        				<li class="sale_item"><fmt:formatNumber var="discount_rate" value="${item.discount_rate}" type="percent" pattern=".0" />${discount_rate} %</li>
	        				<li>${item.discount_price}원 할인</li>
	        			</ul>
	                    <ul class="content_shopItem_btn">
	                        <li><a href="">수정</a></li>
	                        <li><a href="">삭제</a></li>
	                    </ul>            
                </div>
             </c:forEach>
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
			<a href="/psyco/shop/shopList.com?pageNum=${startPage-pageBlock}" > &lt; </a>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
			<a href="/psyco/shop/shopList.com?pageNum=${i}" class="pageNums"> &nbsp; ${i} &nbsp; </a>
		</c:forEach>
		<c:if test="${endPage < pageCount}">
			<a href="/psyco/shop/shopList.com?pageNum=${startPage+pageBlock}" > &gt; </a>
		</c:if>
	
	</c:if>
	</div>
            </div>
        </div>
        <div id="tab2" data-tab-content class="items2">
            <div class="ltem2_shopItembox">
             <c:forEach var="item" items="${articleListA}">
                <div class="content_shopItem_listBox">
                    <div class="shopItem_img">
                        <img src="/psyco/save/${item.menu_img}" alt="">
                    </div>
                    <ul>
                        <li>
                            시작시간 : ${item.startDate}
                        </li>
                        <li>종료시간 : ${item.endDate}</li>
                    </ul>
                    <ul>
                        <li>
                            <h3 class="content_shopItem_title"><a href="">상품 명 :${item.item_name} </a></h3>
                        </li>
                        <li> 수량 : ${item.amount}</li>
                    </ul>
                    <ul class="content_shopItem_btn">
                        <li><a href="">수정</a></li>
                        <li><a href="">삭제</a></li>

                    </ul>
                </div>  
             </c:forEach>
            </div>
        </div>
        <div id="tab3" data-tab-content class="items2">
            <div class="ltem2_shopItembox">
      		<c:forEach var="item" items="${articleListD}">
                <div class="content_shopItem_listBox">
                    <div class="shopItem_img">
                        <img src="/psyco/save/${item.menu_img}" alt="">
                    </div>
                    <ul>
                        <li>
                            시작시간 : ${item.startDate}
                        </li>
                        <li>종료시간 : ${item.endDate}</li>
                    </ul>
                    <ul>
                        <li>
                            <h3 class="content_shopItem_title"><a href="">상품 명 :${item.item_name} </a></h3>
                        </li>
                        <li> 수량 : ${item.amount}</li>
                    </ul>
                    <ul class="content_shopItem_btn">
                        <li><a href="">수정</a></li>
                        <li><a href="">삭제</a></li>

                    </ul>
                </div>  
             </c:forEach>
              
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
				<a href="/psyco/shop/shopList.com?pageNum=${startPage-pageBlock}" > &lt; </a>
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
				<a href="/psyco/shop/shopList.com?pageNum=${i}" class="pageNums"> &nbsp; ${i} &nbsp; </a>
			</c:forEach>
			<c:if test="${endPage < pageCount}">
				<a href="/psyco/shop/shopList.com?pageNum=${startPage+pageBlock}" > &gt; </a>
			</c:if>
		
		</c:if>
		</div>
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