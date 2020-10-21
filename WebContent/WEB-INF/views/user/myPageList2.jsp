<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">

		function popupOpen(){		
			var popUrl = "/psyco/user/zzimDelete.com";	//팝업창에 출력될 페이지 URL		
			var popOption = "width=370, height=360, left=500,top=500, resizable=no, scrollbars=no, status=no";    //팝업창 옵션		
				window.open(popUrl,"",popOption);
			}
		
</script>


	   <!--  기능  타이틀 -->
    <div class="myPage_mainTitle">
        <h1>마이페이지</h1>
        <div class="myPage_userTitle">
            <h2 class="myPage_subTitle">찜 리스트 / 문의하기 </h2>
        </div>
    </div>
    <!--   탭 버튼-->
    <div class="myPage">
        <div class="myPage_content">
            <div class="myPage_main">
                <div class="tabs">
                    <div class="tab" data-tab-target="#tab1">
                        <p>찜 상품 리스트</p>
                    </div>
                    <div class="tab" data-tab-target="#tab2">
                        <p>문의내역 확인 </p>
                    </div>
                    <div class="tab" data-tab-target="#tab3">
                        <p>커뮤니티 관리</p>
                    </div>
                </div>
            </div>

            <div class="content">
                <!--   탭 1 내용-->
                <div id="tab1" data-tab-content class="items active">
                    <div class="userZZimpage_tab1">
                        <ul class="zzim_reg">
                            <li><input type="checkbox" name="" id=""> 전체선택</li>
                            <li><a href="">선택 삭제</a> </li>
                        </ul>
                  
                        <c:forEach var="zzim"  items="${myPageZzim}">
                        <div class="myPage_item_info">
                            <a href="/psyco/shop/menuList.com?shop_num=${zzim.shop_num}"><img src="${zzim.menu_img}"> </a>
                            <ul>
                                <li><a href="/psyco/shop/menuList.com?shop_num=${zzim.shop_num}">${zzim.menu_name}</a></li>
                                <li> 가격 </li>
                                <li>
                                    <span> ${zzim.price}</span>
                                </li>
                            </ul>
                            <button><a href="javascript:popupOpen()" id="zzim_num" value="${zzim.zzim_num}"> 삭제 </a></button>
                        </div>
                        </c:forEach>    
 
                                             
                    </div>


                </div>


                <!--   탭 2 내용-->
                <div id="tab2" data-tab-content class="items">
                    <div class="userpage_tab2">
                        <h2>문의 내역 리스트</h2>
                        <table>
                            <tr>
                                <th>no.</th>
                                <th>제목</th>
                                <th>커뮤니티</th>
                                <th>작성시간</th>
                            </tr>
                            <c:forEach var="article" items="${articleList}">
                            <tr>
                            <td>${number} <c:set var="number" value="${number-1}" /> </td>	
                                <td><a href="/psyco/helpDetail.com?community_num=${article.community_num}&pageNum=2&category=${article.category}">${article.subject}</a></td>
                                <c:if test="${article.category == 5 }">
                                <td>고객센터</td>
                                </c:if>
                                <td>${article.reg}</td>
                            </tr>
                            </c:forEach>
                        </table>
                    </div>
                   </div> 
                    
                    
      			 <!--   탭 3 내용-->
                <div id="tab3" data-tab-content class="items">
                    <div class="userpage_tab2">
                        <h2> 커뮤니티 리스트</h2>
                        <table>
                            <tr>
                                <th>no.</th>
                                <th>제목</th>
                                <th>별점</th>
                                <th>작성시간</th>
                            </tr>
                             <c:forEach var="article2" items="${articleList2}">
                            <tr>
                            <td>${numbers} <c:set var="numbers" value="${numbers-1}" /> </td>	
                                <td><a href="/psyco/communityDetail.com?community_num=${article2.community_num}&pageNum=2&category=${article2.category}">${article2.subject}</a></td>
                                <c:if test="${article2.category == 1 }">
                                <td>자유게시판</td>
                                </c:if>
                                <c:if test="${article2.category == 2 }">
                                <td>QnA</td>
                                </c:if>
                                <c:if test="${article2.category == 3 }">
                                <td>홍보</td>
                                </c:if>
                                <c:if test="${article2.category == 4 }">
                                <td>음식점추천</td>
                                </c:if>
                                <td>${article2.reg}</td>
                            </tr>
                            </c:forEach>
                        </table>
                    </div>
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