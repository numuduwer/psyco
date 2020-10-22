<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                        <p>전체 구매내역</p>
                    </div>
                    <div class="tab" data-tab-target="#tab2">
                        <p>내가쓴 후기 </p>
                    </div>
                </div>
            </div>

            <div class="content">
                <!--   탭 1 내용-->
                <div id="tab1" data-tab-content class="items active">
                    <div class="userpage_tab1">
                        <ul class="reg">
                            <li>주문일 2020/8/30</li>
                            <li><a href="">주문 상세보기 >></a> </li>
                        </ul>
                        <div class="myPage_item_info">
                            <img src="/img/item/one/1.jpg" alt="">
                            <ul>
                                <li><a href="">경매 상품 이름</a></li>
                                <li> 할인률 </li>
                                <li>
                                    <span>1000원 / 1개</span>
                                </li>
                            </ul>
                            <button><a href="">후기 쓰러가기</a> </button>
                        </div>
                    </div>
                    <div class="userpage_tab1">
                        <ul class="reg">
                            <li>주문일 2020/8/30</li>
                            <li><a href="">주문 상세보기 >></a> </li>
                        </ul>
                        <div class="myPage_item_info">
                            <img src="/img/item/one/1.jpg" alt="">
                            <ul>
                                <li><a href="">경매 상품 이름</a></li>
                                <li> 할인률 </li>
                                <li>
                                    <span>1000원 / 1개</span>
                                </li>
                            </ul>
                            <button><a href="">후기 쓰러가기</a> </button>
                        </div>
                    </div>
                    <div class="userpage_tab1">
                        <ul class="reg">
                            <li>주문일 2020/8/30</li>
                            <li><a href="">주문 상세보기 >></a> </li>
                        </ul>
                        <div class="myPage_item_info">
                            <img src="/img/item/one/1.jpg" alt="">
                            <ul>
                                <li><a href="">경매 상품 이름</a></li>
                                <li> 할인률 </li>
                                <li>
                                    <span>1000원 / 1개</span>
                                </li>
                            </ul>
                            <button><a href="">후기 쓰러가기</a> </button>
                        </div>
                    </div>
                </div>


                <!--   탭 2 내용-->
                <div id="tab2" data-tab-content class="items">
                   <div class="userpage_tab2">
                        <h2>최근 리뷰</h2>
                        <table>
                            <tr>
                                <th>no.</th>
                                <th>제목</th>
                                <th>별점</th>
                                <th>작성시간</th>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>테스트 제목</td>
                                <td>별은 몇개</td>
                                <td>테스트 작성시간 </td>
                            </tr>
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