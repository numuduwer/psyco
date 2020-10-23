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
        <h1>사장님 마이페이지</h1>

        <div class="myPage_shopTitle ">
            <h2 class="myPage_subTitle">내 가게 관리하기 </h2>
        </div>
    </div>



    <!--   탭 버튼-->
    <div class="myPage">
        <div class="myPage_content">
            <div class="myPage_main">
                <div class="tabs">
                    <div class="tab" data-tab-target="#tab1">
                        <p>내 가게 리스트</p>
                    </div>
                    <div class="tab" data-tab-target="#tab2">
                        <p>내 가게 리뷰목록 </p>
                    </div>
                    <div class="tab" data-tab-target="#tab3">
                        <p>서비스 탈퇴하기</p>
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
                        <c:if test="${count == 0}">
							<table>
								<tr>
									<td> 후기가 없습니다. </td>
								</tr>
							</table>
						</c:if>
                        <h2>가게 리스트</h2>
                        <c:if test="${count > 0}">
	                       <c:forEach var="article" items="${articleList}">
		                        <div class="myPage_item_info">
		                            <img src="/img/item/one/1.jpg" alt="">
		                            <ul>
		                                <li><a href="">가게 이름 : ${article.shop_name}</a></li>
		                                <li>
		                                    <span> 주소 : ${article.address}</span>
		                                </li>
		                                <li>
		                                    <span> 영업시간 : ${article.operating_time}</span>
		                                </li>
		                            </ul>
		                            <ul class="myPage_item_info_btnList">
		                                <li><button class="shop_btn"><a href="psyco/shop/shopModify.com">수정</a> </button></li>
		                                <li><button class="shop_btn"><a href="psyco/shop/deleteShop.com">삭제</a> </button></li>
		                            </ul>
		                        </div>
                        </c:forEach>
                   	</c:if>
                    </div>


                </div>


                <!--   탭 2 내용-->
                <div id="tab2" data-tab-content class="items">
                    <div class="userpage_tab2">
                        <h2>가게리뷰 리스트</h2>
                        <table>
                            <tr>
                                <th>no.</th>
                                <th>제목</th>
                                <th>별점</th>
                                <th>작성시간</th>
                            </tr>
                         <c:if test="${count == 0}">
							<table>
								<tr>
									<td> 후기가 없습니다. </td>
								</tr>
							</table>
						</c:if>
                        <h2>리뷰 리스트</h2>
                        <c:if test="${count > 0}">
                         	<c:forEach var="article" items="${rarticleList}">
                         	
                            <tr>
                                <td>${rnumber}
                                	<c:set var="number" value="${number-1}"/>
                                </td>	
                                <td align="left">
											<a href="/psyco/user/reviewDetail.com?review_num=${article.review_num}&pageNum=${pageNum}" >${article.shop_name}</a>
								</td>
                             	<td>${article.grade}</td>
								<td>${article.reg}</td>
                            </tr>
                            </c:forEach>
                         </c:if>
                        </table>
                    </div>
                </div>

                <!--   탭 3 내용-->
                <div id="tab3" data-tab-content class="items">
                    <div class="form_box">
                        <form action="" class="form">
                            <div class=form_tab>
                                <label for="" class="form_title"> 아이디</label>
                                <input type="text" class="form_input" />
                            </div>
                            <div class=form_tab>
                                <label for="" class="form_title"> 패스워드</label>
                                <input type="text" class="form_input" />
                            </div>


                            <div class=form_tab>
                                <input type="button" class="form_btn" value="제출" />
                                <input type="button" class="form_btn" value="뒤로" />
                            </div>
                        </form>
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