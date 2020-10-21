<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>main</title>
</head>

<body>
    <section id="buy_info">
        <div class="buy_img">
            <img src="/psyco/resources/img/item/one/1.jpg" alt="" class="card_img">
            <div class="map">ddddd</div>
        </div>
        <div class="buy_content">
            <div class="buy_title">
                <h1>제육볶음</h1>
            </div>
            <div class="shop_title">
                <ul>
                    <li>${sdto.shop_name}</li>
                    <li>${sdto.operating_time}</li>
                    <li></li>
                </ul>
                <ul>
                    <li>${sdto.shop_phone}</li>
                    <li>${sdto.address}</li>
                    <li></li>
                </ul>

            </div>
            <div class="buy_detail">
                <ul>
                    <li>시작일</li>
                    <li>${dto.startdate}</li>

                </ul>
                <ul>
                    <li>할인 주기</li>
                    <li>${dto.discount_cycle}</li>
                </ul>
                <ul>
                    <li>경매 단위</li>
                    <li>${dto.auction_unit}</li>

                </ul>
                <ul>
                    <li>남은 수량</li>
                    <li>${dto.amount}</li>

                </ul>
            </div>
            <div class="buy_price">
                <div class="start_price">
                    <ul>
                        <li>시작 가격</li>
                        <li>${maxprice}</li>

                    </ul>
                    <ul>
                        <li class="nprice">tl작가격</li>
                        <li class=price_percent>
                            50% &darr;
                        </li>


                    </ul>
                </div>
                <div class="now_price">
                    <ul>
                        <li>현재 가격</li>
                        <li>2500원</li>
                    </ul>
                </div>
            </div>
            <button class="buy_btn">
                <h2>구매하기</h2>
            </button>
        </div>

    </section>
    
    
    <section class="shop_info">
        <div class="items_info">
            <div class="ing_info">
                <h2>이 가게에서 진행중인 경매</h2>
                <div class="info_items">
                    <img src="/img/item/one/1.jpg" alt="">
                    <img src="/img/item/one/2.jpg" alt="">
                    <img src="/img/item/one/3.jpg" alt="">
                    <img src="/img/item/one/4.jpg" alt="">
                </div>
            </div>
            <div class="ing_info">
                <h2>이 가게에서 진행예정 경매</h2>
                <div class="info_items">
                    <img src="" alt="">
                    <img src="" alt="">
                    <img src="" alt="">
                    <img src="" alt="">
                </div>
            </div>
        </div>
        <div class="shop_comment">
            <h2>사장님 오늘의 한마디</h2>
            <h3>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Officiis mollitia odio illum suscipit.
                Laboriosam
                qui temporibus,</h3>
        </div>

    </section>
    <div class="shopCotent_btn">
        <div class="tabs">
            <div class="tab" data-tab-target="#tab1">
                <p>메뉴</p>
            </div>
            <div class="tab" data-tab-target="#tab2">
                <p>가게정보</p>
            </div>
            <div class="tab" data-tab-target="#tab3">
                <p>리뷰</p>
            </div>
        </div>
    </div>
    <div class="content">
        <div id="tab1" data-tab-content class="items active">
            <div class="tab1_item">
            	<table>
		            <c:forEach var="article" items="${articleList}">
		            	<tr>
			            	<td>
				                <img src="/img/item/one/1.jpg" alt="">
				                <div class="shopinfo_info">
				                    <h2>${article.menu_name }</h2>
				                    <h3>멘트??</h3>
				                    <p>${article.price}</p>
				                </div>
			                </td>
		                </tr>
		            </c:forEach>
                </table>
            </div>


        </div>
        <div id="tab2" data-tab-content class="items">
            <div class="tab2_item">
                <img src="/img/item/one/1.jpg" alt="">
                <div class="shopinfo_info">
                    <h2>${sdto.shop_name}</h2>
                    <ul>
                        <li>
                            <h3>전화번호 :</h3>
                        </li>
                        <li>
                            <h3> ${sdto.shop_phone}</h3>
                        </li>
                    </ul>

                    <ul>
                        <li>
                            <h3>영업시간 :</h3>
                        </li>
                        <li>
                            <h3> ${sdto.operating_time}</h3>
                        </li>
                    </ul>
                    <ul>
                        <li>
                            <h3>포장여부 :</h3>
                        </li>
                        <li>
                            <h3> ${sdto.takeout}</h3>
                        </li>
                    </ul>
                    <ul>
                        <li>
                            <h3>주소 :</h3>
                        </li>
                        <li>
                            <h3> ${sdto.address}</h3>
                        </li>
                    </ul>


                </div>
            </div>
        </div>
        <div id="tab3" data-tab-content class="items">
            <div class="tab3_item">
                <h2>최근 리뷰</h2>
                <table>
                    <tr>
                        <th>no.</th>
                        <th>작성자</th>
                        <th>별점</th>
                        <th>작성시간</th>
                        <th>내용</th>
                    </tr>
                    ${article.rcount}
                    <c:forEach var="article" items="${rarticleList}">
                    <tr>
                    	<td>${rnumber}
							<c:set var="number" value="${rnumber-1}" />
						</td>
                        <td>${article.writer}</td>
                        <td>${article.grade}</td>
                        <td>${article.reg } </td>
                        <td>${article.content } </td>
                    </tr>
                    </c:forEach>
                </table>

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